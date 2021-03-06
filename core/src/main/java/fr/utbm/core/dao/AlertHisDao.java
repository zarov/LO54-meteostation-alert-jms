/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.utbm.core.dao;

import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

import fr.utbm.core.entity.Alert;
import fr.utbm.core.entity.AlertHis;
import fr.utbm.core.tools.HibernateUtil;

/**
 *
 * @author Julien
 */
public class AlertHisDao {
	public void registerAlertHis(AlertHis a) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			session.beginTransaction();
			session.saveOrUpdate(a);
			session.getTransaction().commit();
		} catch (HibernateException he) {
			he.printStackTrace();
			if (session.getTransaction() != null) {
				try {
					session.getTransaction().rollback();
				} catch (HibernateException he2) {
					he2.printStackTrace();
				}
			}
		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

	public AlertHis getAlertHisById(int id) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		AlertHis a = (AlertHis) session.get(Alert.class, id);
		Hibernate.initialize(a.getTrigger());
		session.close();
		return a;
	}

	public void deleteAlertHisById(int id) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			session.beginTransaction();
			AlertHis a = (AlertHis) session.get(AlertHis.class, id);
			session.delete(a);
			session.getTransaction().commit();
		} catch (HibernateException he) {
			he.printStackTrace();
			if (session.getTransaction() != null) {
				try {
					session.getTransaction().rollback();
				} catch (HibernateException he2) {
					he2.printStackTrace();
				}
			}
		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

	public List<AlertHis> getAllAlertHis() {
		List<AlertHis> res = null;
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		Query query = session.createQuery("from fr.utbm.core.entity.AlertHis");
		res = query.list();
		session.close();
		return res;
	}
}
