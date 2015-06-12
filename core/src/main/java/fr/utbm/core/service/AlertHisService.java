package fr.utbm.core.service;

import java.util.List;

import fr.utbm.core.dao.AlertHisDao;
import fr.utbm.core.entity.AlertHis;

/**
 *
 * @author Julien
 */
public class AlertHisService {
	public void registerAlertHis(AlertHis a) {
		AlertHisDao d = new AlertHisDao();
		d.registerAlertHis(a);
	}

	public AlertHis getAlertHis(int id) {
		AlertHisDao d = new AlertHisDao();
		return d.getAlertHisById(id);
	}

	public void deleteAlertHis(int id) {
		AlertHisDao d = new AlertHisDao();
		d.deleteAlertHisById(id);
	}

	public List<AlertHis> getAllAlertHis() {
		AlertHisDao d = new AlertHisDao();
		return d.getAllAlertHis();
	}
}
