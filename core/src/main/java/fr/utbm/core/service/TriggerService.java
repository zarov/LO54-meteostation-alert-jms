/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.utbm.core.service;

import fr.utbm.core.dao.TriggerDao;
import fr.utbm.core.dao.UserDao;
import fr.utbm.core.entity.Trigger;

/**
 *
 * @author java
 */
public class TriggerService {
    	public void registerTrigger(Trigger t) {
            TriggerDao d = new TriggerDao();
            d.registerTrigger(t);
	}
        
        public Trigger getTrigger(int id){
            TriggerDao d = new TriggerDao();
            return d.getTriggerById(id);
        }
        
        public void deleteTrigger(int id){
            TriggerDao d = new TriggerDao();
            d.deleteTriggerById(id);
        }
}
