/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.utbm.core.dao;

import fr.utbm.core.entity.Alert;
import fr.utbm.core.entity.AlertHis;
import fr.utbm.core.tools.HibernateUtil;
import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.Session;

/**
 *
 * @author Julien
 */
public class AlertHisDao {
    public void registerAlertHis(AlertHis a) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        try{
            session.beginTransaction();
            session.saveOrUpdate(a);
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
    
    public AlertHis getAlertHisById(int id){
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        AlertHis a = (AlertHis)session.get(Alert.class,id);
        Hibernate.initialize(a.getTrigger());
        session.close();
        return a;
    }
    
    public void deleteAlertHisById(int id){
        Session session = HibernateUtil.getSessionFactory().openSession();
        try{
            session.beginTransaction();
            AlertHis a = (AlertHis)session.get(AlertHis.class,id);
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
