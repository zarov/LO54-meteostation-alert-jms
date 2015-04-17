/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.utbm.core.dao;

import fr.utbm.core.entity.Alert;
import fr.utbm.core.entity.Trigger;
import fr.utbm.core.tools.HibernateUtil;
import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.Session;

/**
 *
 * @author Julien
 */
public class AlertDao {
    public void registerAlert(Alert a) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        try{
            session.beginTransaction();
            session.persist(a);
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
    
    public Alert getAlertById(int id){
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Alert a = (Alert)session.get(Alert.class,id);
        session.close();
        return a;
    }
    
    public void deleteAlertById(int id){
        Session session = HibernateUtil.getSessionFactory().openSession();
        try{
            session.beginTransaction();
            Alert a = (Alert)session.get(Alert.class,id);
            session.delete(a);
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
