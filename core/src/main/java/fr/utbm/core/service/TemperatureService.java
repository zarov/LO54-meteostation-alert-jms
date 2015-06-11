package fr.utbm.core.service;

import fr.utbm.core.dao.TemperatureDao;
import fr.utbm.core.entity.Temperature;
import java.util.Date;

/**
 * @author zarov
 * @package fr.utbm.core.service
 */
public class TemperatureService {
	public void addTemperature(Temperature t) {
		TemperatureDao dao = new TemperatureDao();
		dao.addTemperature(t);
	}

	public void addTemperature(float value, int sensorId) {
		Temperature t = new Temperature();
		t.setValue(value);
		t.setId(sensorId);
		t.setDate(new Date());
		addTemperature(t);
	}

	public void addTemperature(float value, int sensorId, Date date) {
		Temperature t = new Temperature();
		t.setValue(value);
		t.setId(sensorId);
		t.setDate(date);
		addTemperature(t);
	}

	public Temperature getTemperatureById(int id) {
		TemperatureDao dao = new TemperatureDao();
		return dao.getTemperatureById(id);
	}

	public void deleteTemperatureById(int id) {
		TemperatureDao dao = new TemperatureDao();
		dao.deleteTemperatureById(id);
	}
        
        public Temperature getLastTemperatureBySensorId(int id) {
                TemperatureDao dao = new TemperatureDao();
                return dao.getLastTemperatureBySensorId(id);
        }
}
