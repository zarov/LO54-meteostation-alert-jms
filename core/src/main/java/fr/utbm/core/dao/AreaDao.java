package fr.utbm.core.dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import fr.utbm.core.entity.Area;
import fr.utbm.core.tools.HibernateUtil;

/**
 * @author Adrien Berthet <adrien.berthet@utbm.fr>
 * @package fr.utbm.core.dao
 */
public class AreaDao {

	/**
	 * @param a
	 */
	public void addArea(Area a) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			session.beginTransaction();
			session.persist(a);
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
	public Area getAreaById(int id) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		Area a = (Area) session.get(Area.class, id);
		session.close();
		return a;
	}

	/**
	 * @param id
	 */
	public void deleteAreaById(int id) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			session.beginTransaction();
			Area a = (Area) session.get(Area.class, id);
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

}
