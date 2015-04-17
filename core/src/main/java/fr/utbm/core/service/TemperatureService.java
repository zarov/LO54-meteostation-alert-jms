package fr.utbm.core.service;

import java.util.Date;

import fr.utbm.core.dao.TemperatureDao;
import fr.utbm.core.entity.Temperature;

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
		t.setSensorId(sensorId);
		t.setDate(new Date());
		addTemperature(t);
	}

	public void addTemperature(float value, int sensorId, Date date) {
		Temperature t = new Temperature();
		t.setValue(value);
		t.setSensorId(sensorId);
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
}
