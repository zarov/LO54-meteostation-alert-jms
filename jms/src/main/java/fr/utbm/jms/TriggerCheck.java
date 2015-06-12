package fr.utbm.jms;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Component;

import fr.utbm.core.entity.AlertHis;
import fr.utbm.core.entity.Area;
import fr.utbm.core.entity.Sensor;
import fr.utbm.core.entity.Station;
import fr.utbm.core.entity.Temperature;
import fr.utbm.core.entity.Trigger;
import fr.utbm.core.service.AlertHisService;
import fr.utbm.core.service.SensorService;
import fr.utbm.core.service.StationService;
import fr.utbm.core.service.TemperatureService;
import fr.utbm.core.service.TriggerService;

/**
 * This class has a job to check the triggers. The job is activated every X
 * seconds by a Quartz job (see src/main/resources/jms-trigger-quartz.xml).
 *
 * @author Adrien Berthet <adrien.berthet@utbm.fr>
 * @package fr.utbm.jms
 */
@Component("triggerCheck")
public class TriggerCheck {
	public TriggerCheck() {
	}

	/**
	 * The main method, it checks all the triggers, no exception.
	 */
	public void checkTrigger() {
		AlertSender sender = new AlertSender();
		TemperatureService tempService = new TemperatureService();

		TriggerService trigService = new TriggerService();
		List<Trigger> triggers = trigService.getAllTriggers();

		// For each trigger, get the last temperature associated and compare it
		// to the edges of the trigger.
		for (Trigger t : triggers) {
			Temperature lastTemp = tempService.getLastTemperatureBySensorId(t
					.getSensor().getId());
			if ((lastTemp.getValue() > t.getTrigHigh())
					|| (lastTemp.getValue() < t.getTrigLow())) {
				// If out, send a message and archive the alert in database.
				sender.sendMessage(t);
				addAlertHist(lastTemp.getDate(), t);
			}
		}
	}

	/**
	 * Check a list of trigger, given an Area or a Station
	 *
	 * @param clazz
	 *            the class of the location to check (Area or Station)
	 * @param id
	 *            the id of the location
	 */
	public void checkTrigger(Class<?> clazz, int id) {
		if (clazz.equals(Station.class)) {
			checkStation(id);
		} else if (clazz.equals(Area.class)) {
			checkArea(id);
		}
	}

	/**
	 * Check the trigger for a specific area. Gather only the stations in this
	 * area, and call the checkStation() method for each station in area.
	 *
	 * @param id
	 *            the area id
	 */
	private void checkArea(int id) {
		StationService staService = new StationService();
		List<Station> stations = staService.getAllStationsByAreaId(id);

		for (Station s : stations) {
			checkStation(s.getId());
		}
	}

	/**
	 * Check all the triggers available for a specific station. Does a similar
	 * job as the default checkTrigger() method.
	 *
	 * @param id
	 *            the station id
	 */
	private void checkStation(int id) {
		AlertSender sender = new AlertSender();
		TemperatureService tempService = new TemperatureService();
		TriggerService trigService = new TriggerService();

		SensorService senService = new SensorService();
		List<Sensor> sensors = senService.getAllSensorFromStationId(id);

		for (Sensor s : sensors) {
			int sId = s.getId();
			List<Trigger> triggers = trigService
					.getAllTriggersFromSensorId(sId);

			for (Trigger t : triggers) {
				Temperature lastTemp = tempService
						.getLastTemperatureBySensorId(sId);
				if ((lastTemp.getValue() > t.getTrigHigh())
						|| (lastTemp.getValue() < t.getTrigLow())) {
					sender.sendMessage(t);
					addAlertHist(lastTemp.getDate(), t);
				}
			}
		}
	}

	/**
	 * Archive an alert in database.
	 *
	 * @param d
	 *            the date of the alert
	 * @param t
	 *            the associated trigger
	 */
	private void addAlertHist(Date d, Trigger t) {
		AlertHisService ahistService = new AlertHisService();

		AlertHis ahist = new AlertHis(d, true, t);
		ahistService.registerAlertHis(ahist);
	}
}
