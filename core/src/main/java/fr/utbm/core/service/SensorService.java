package fr.utbm.core.service;

import java.util.List;

import org.springframework.stereotype.Service;

import fr.utbm.core.dao.SensorDao;
import fr.utbm.core.entity.Sensor;

/**
 * @author Adrien Berthet <adrien.berthet@utbm.fr>
 * @package fr.utbm.core.service
 */
@Service
public class SensorService {

	public void addSensor(Sensor s) {
		SensorDao dao = new SensorDao();
		dao.addSensor(s);
	}

	/*
	 * public void addSensor(String label, int stationId) { Sensor s = new
	 * Sensor(); s.setLabel(label); s.setStationId(stationId); addSensor(s); }
	 */

	/*
	 * public void addSensor(String label, Station station) { Sensor s = new
	 * Sensor(); s.setLabel(label); s.setStationId(station.getId());
	 * addSensor(s); }
	 */

	public Sensor getSensorById(int id) {
		SensorDao dao = new SensorDao();
		return dao.getSensorById(id);
	}

	public void deleteSensorById(int id) {
		SensorDao dao = new SensorDao();
		dao.deleteSensorById(id);
	}

	public List<Sensor> getAllSensorFromStationId(int id) {
		SensorDao dao = new SensorDao();
		return dao.getAllSensorFromSationId(id);
	}
}
