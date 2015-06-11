package fr.utbm.jms;

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
import java.util.Date;
import java.util.List;
import org.springframework.stereotype.Component;

/**
 *
 * @author Adrien
 */
@Component("triggerCheck")
public class TriggerCheck {
    public TriggerCheck () {}
    
    public void checkTrigger() {
        AlertSender sender = new AlertSender();
        TemperatureService tempService = new TemperatureService();
        
        TriggerService trigService = new TriggerService();
        List<Trigger> triggers = trigService.getAllTriggers();
        
        for(Trigger t : triggers) {
            Temperature lastTemp = tempService.getLastTemperatureBySensorId(t.getSensor().getId());
            if(lastTemp.getValue() > t.getTrigHigh() || lastTemp.getValue() < t.getTrigLow()) {
                sender.sendMessage(t);
                addAlertHist(lastTemp.getDate(), t);
            }
        }
    }
    
    public void checkTrigger(Class<?> clazz, int id) {
        if(clazz.equals(Station.class)) {
            checkStation(id);
        } else if (clazz.equals(Area.class)) {
            checkArea(id);
        }
    }
    
    private void checkArea(int id) {
        StationService staService = new StationService();
        List<Station> stations = staService.getAllStationsByAreaId(id);
        
        for(Station s : stations) {
            checkStation(s.getId());
        }
    }
    
    private void checkStation(int id) {
        AlertSender sender = new AlertSender();
        TemperatureService tempService = new TemperatureService();
        TriggerService trigService = new TriggerService();
        
        SensorService senService = new SensorService();
        List<Sensor> sensors = senService.getAllSensorFromStationId(id);
        
        for(Sensor s : sensors) {
            int sId = s.getId();
            List<Trigger> triggers = trigService.getAllTriggersFromSensorId(sId);
            
            for(Trigger t : triggers) {
                Temperature lastTemp = tempService.getLastTemperatureBySensorId(sId);
                if(lastTemp.getValue() > t.getTrigHigh() || lastTemp.getValue() < t.getTrigLow()) {
                    sender.sendMessage(t);
                    addAlertHist(lastTemp.getDate(), t);
                }
            }
        }
    }
    
    private void addAlertHist(Date d, Trigger t) {
        AlertHisService ahistService = new AlertHisService();
        
        AlertHis ahist = new AlertHis(d, true, t);
        ahistService.registerAlertHis(ahist);
    }
}
