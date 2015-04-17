package fr.utbm.core.dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import fr.utbm.core.entity.Sensor;
import fr.utbm.core.tools.HibernateUtil;

/**
 * @author zarov
 * @package fr.utbm.core.dao
 */
public class SensorDao {

	/**
	 * @param s
	 */
	public void addSensor(Sensor s) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			session.beginTransaction();
			session.persist(s);
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
	 */
	public Sensor getSensorById(int id) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		Sensor sensor = (Sensor) session.get(Sensor.class, id);
		session.close();
		return sensor;
	}

	/**
	 * @param id
	 */
	public void deleteSensorById(int id) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			session.beginTransaction();
			Sensor s = (Sensor) session.get(Sensor.class, id);
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
