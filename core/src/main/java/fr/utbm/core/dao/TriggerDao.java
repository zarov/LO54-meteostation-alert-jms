/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.utbm.core.dao;

import fr.utbm.core.entity.Trigger;
import fr.utbm.core.tools.HibernateUtil;
import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.Session;

/**
 *
 * @author java
 */
public class TriggerDao {
    public void registerTrigger(Trigger t) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        try{
            session.beginTransaction();
            session.persist(t);
            session.getTransaction().commit();
        }
        catch (HibernateException he) {
            he.printStackTrace();
            if(session.getTransaction() != null) { 
                try {
                    session.getTransaction().rollback();	
                }catch(HibernateException he2) {he2.printStackTrace(); }
            }
        }
        finally {
            if(session != null) {
                session.close();
            }
        }
    }
    
    public Trigger getTriggerById(int id){
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Trigger t = (Trigger)session.get(Trigger.class,id);
        Hibernate.initialize(t.getSensor());
        Hibernate.initialize(t.getAlert());
        session.close();
        return t;
    }
    
    public void deleteTriggerById(int id){
        Session session = HibernateUtil.getSessionFactory().openSession();
        try{
            session.beginTransaction();
            Trigger t = (Trigger)session.get(Trigger.class,id);
            session.delete(t);
            session.getTransaction().commit();
        }
        catch (HibernateException he) {
            he.printStackTrace();
            if(session.getTransaction() != null) { 
                try {
                    session.getTransaction().rollback();	
                }catch(HibernateException he2) {he2.printStackTrace(); }
            }
        }
        finally {
            if(session != null) {
                session.close();
            }
        }
    }
}