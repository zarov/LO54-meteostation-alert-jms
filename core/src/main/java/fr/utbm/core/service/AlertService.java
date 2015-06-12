package fr.utbm.core.service;

import java.util.List;

import fr.utbm.core.dao.AlertDao;
import fr.utbm.core.entity.Alert;

/**
 *
 * @author Julien
 */
public class AlertService {
	public void registerAlert(Alert a) {
		AlertDao d = new AlertDao();
		d.registerAlert(a);
	}

	public Alert getAlert(String id) {
		AlertDao d = new AlertDao();
		return d.getAlertById(id);
	}

	public void deleteAlert(String id) {
		AlertDao d = new AlertDao();
		d.deleteAlertById(id);
	}

	public List<Alert> getAllAlerts() {
		AlertDao d = new AlertDao();
		return d.getAllAlerts();
	}
}
