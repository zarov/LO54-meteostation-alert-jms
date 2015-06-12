package fr.utbm.core.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

import fr.utbm.core.entity.Station;
import fr.utbm.core.tools.HibernateUtil;

/**
 * @author Adrien Berthet <adrien.berthet@utbm.fr>
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

	public List<Station> getAllStations() {
		List<Station> res = null;
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		Query query = session.createQuery("from fr.utbm.core.entity.Station");
		res = query.list();
		session.close();
		return res;
	}

	public List<Station> getAllStationsByAreaId(int id) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		Query query = session.createQuery(
				"from fr.utbm.core.entity.Station s where s.area.id =:id")
				.setParameter("id", id);
		List<Station> res = query.list();
		session.close();
		return res;
	}

}
