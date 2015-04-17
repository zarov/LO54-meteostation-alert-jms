package fr.utbm.core.dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import fr.utbm.core.entity.Station;
import fr.utbm.core.tools.HibernateUtil;

/**
 * @author zarov
 * @package fr.utbm.core.dao
 */
public class StationDao {
	/**
	 * @param s
	 */
	public void addStation(Station t) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			session.beginTransaction();
			session.persist(t);
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

	/**
	 * @param id
	 * @return
	 */
	public Station getStationById(int id) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		Station s = (Station) session.get(Station.class, id);
		session.close();
		return s;
	}

	/**
	 * @param id
	 */
	public void deleteStationById(int id) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			session.beginTransaction();
			Station s = (Station) session.get(Station.class, id);
			session.delete(s);
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

}
