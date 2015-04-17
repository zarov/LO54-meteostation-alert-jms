/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.utbm.core.service;

import fr.utbm.core.dao.AlertDao;
import fr.utbm.core.dao.AlertHisDao;
import fr.utbm.core.dao.TriggerDao;
import fr.utbm.core.dao.UserDao;
import fr.utbm.core.entity.Alert;
import fr.utbm.core.entity.AlertHis;
import fr.utbm.core.entity.Trigger;

/**
 *
 * @author java
 */
public class AlertHisService {
    	public void registerAlertHis(AlertHis a) {
            AlertHisDao d = new AlertHisDao();
            d.registerAlertHis(a);
	}
        
        public AlertHis getAlertHis(int id){
            AlertHisDao d = new AlertHisDao();
            return d.getAlertHisById(id);
        }
        
        public void deleteAlertHis(int id){
            AlertHisDao d = new AlertHisDao();
            d.deleteAlertHisById(id);
        }
}
