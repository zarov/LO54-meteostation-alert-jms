package fr.utbm.core.dao;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

import fr.utbm.core.entity.Temperature;
import fr.utbm.core.tools.HibernateUtil;

/**
 * @author Adrien Berthet <adrien.berthet@utbm.fr>
 * @package fr.utbm.core.dao
 */
public class TemperatureDao {

	/**
	 * @param t
	 */
	public void addTemperature(Temperature t) {
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
	public Temperature getTemperatureById(int id) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		Temperature t = (Temperature) session.get(Temperature.class, id);
		session.close();
		return t;
	}

	/**
	 * @param id
	 */
	public void deleteTemperatureById(int id) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			session.beginTransaction();
			Temperature t = (Temperature) session.get(Temperature.class, id);
			session.delete(t);
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

	public Temperature getLastTemperatureBySensorId(int id) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		Query query = session
				.createQuery(
						"from fr.utbm.core.entity.Temperature t where t.sensor.id = :id order by t.date desc")
				.setParameter("id", id);
		query.setMaxResults(1);
		Temperature t = (Temperature) query.uniqueResult();
		session.close();
		return t;
	}

}
