/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.utbm.core.service;

import fr.utbm.core.dao.AlertDao;
import fr.utbm.core.dao.TriggerDao;
import fr.utbm.core.dao.UserDao;
import fr.utbm.core.entity.Alert;
import fr.utbm.core.entity.Trigger;
import java.util.List;

/**
 *
 * @author java
 */
public class AlertService {
    	public void registerAlert(Alert a) {
            AlertDao d = new AlertDao();
            d.registerAlert(a);
	}
        
        public Alert getAlert(String id){
            AlertDao d = new AlertDao();
            return d.getAlertById(id);
        }
        
        public void deleteAlert(String id){
            AlertDao d = new AlertDao();
            d.deleteAlertById(id);
        }

        public List<Alert> getAllAlerts() {
            AlertDao d = new AlertDao();
            return d.getAllAlerts();
        }
}
