package core;

import java.io.Serializable;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.persistence.NoResultException;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import entities.Entity;

public class HibernateUtils {

	private static SessionFactory factory;

	private HibernateUtils() {
	}

	public static SessionFactory getInstance() {
		if (factory == null) {
			factory = new Configuration().configure().buildSessionFactory();
		}
		return factory;
	}

	public static boolean save(Entity o) {
		Session session = getInstance().getCurrentSession();
		try {
			if (!session.getTransaction().isActive())
				session.beginTransaction();

			// Query
			session.save(o);

			session.getTransaction().commit();
			return true;
		} catch (HibernateException e) {
			Logger.getLogger(HibernateUtils.class.getName()).log(Level.SEVERE, "HibernateUtils.java throws exception",
					e);
			session.getTransaction().rollback();
			return false;
		}
	}

	public static boolean update(Entity o) {
		Session session = getInstance().getCurrentSession();
		try {
			if (!session.getTransaction().isActive())
				session.beginTransaction();

			// Query
			session.update(o);

			session.getTransaction().commit();
			return true;
		} catch (HibernateException e) {
			Logger.getLogger(HibernateUtils.class.getName()).log(Level.SEVERE, "HibernateUtils.java throws exception",
					e);
			session.getTransaction().rollback();
		}
		return false;
	}

	public static boolean delete(Entity e) {
		Session session = getInstance().getCurrentSession();
		try {
			if (!session.getTransaction().isActive())
				session.beginTransaction();

			// Query
			session.delete(e);

			session.getTransaction().commit();
			return true;
		} catch (HibernateException ex) {
			Logger.getLogger(HibernateUtils.class.getName()).log(Level.SEVERE, "HibernateUtils.java throws exception",
					ex);
			session.getTransaction().rollback();
			return false;
		}
	}

	public static Entity read(Serializable rowId, Entity e) {
		Entity dbObject = null;
		try {
			Session session = getInstance().getCurrentSession();
			if (!session.getTransaction().isActive())
				session.beginTransaction();

			// Query
			dbObject = (Entity) session.get(e.getClass().getName(), rowId);

			session.getTransaction().commit();
			return dbObject;

		} catch (HibernateException | NoResultException ex) {
			Logger.getLogger(HibernateUtils.class.getName()).log(Level.SEVERE, "HibernateUtils.java throws exception",
					ex);
			return dbObject;
		}
	}

	public static List<Entity> readAll(Class<Entity> c) {
		List<Entity> list = null;
		try {
			Session session = getInstance().getCurrentSession();
			if (!session.getTransaction().isActive())
				session.beginTransaction();

			CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
			CriteriaQuery<Entity> criteriaQuery = criteriaBuilder.createQuery(c);
			Root<Entity> root = criteriaQuery.from(c);

			// Query
			criteriaQuery.select(root);

			Query<Entity> query = session.createQuery(criteriaQuery);
			list = query.getResultList();

			session.getTransaction().commit();
		} catch (HibernateException e) {
			Logger.getLogger(HibernateUtils.class.getName()).log(Level.SEVERE, "HibernateUtils.java throws exception",
					e);
		}
		return list;
	}

	public static List<Entity> readByColumn(Class<Entity> c, String[] columns, String[] operators, String[] values) {
		List<Entity> list = null;
		try {
			Session session = getInstance().getCurrentSession();
			if (!session.getTransaction().isActive())
				session.beginTransaction();

			CriteriaBuilder builder = session.getCriteriaBuilder();
			CriteriaQuery<Entity> criteriaQuery = builder.createQuery(c);
			Root<Entity> root = criteriaQuery.from(c);

			// Query
			criteriaQuery.select(root);
			if (columns.length > 0) {
				Predicate[] p = new Predicate[columns.length];
				for (int i = 0; i < columns.length; i++) {
					if (operators[i].equals("="))
						p[i] = builder.equal(root.get(columns[i]), values[i]);
					else if (operators[i].equals("LIKE"))
						p[i] = builder.like(root.get(columns[i]), values[i]);
					else if (operators[i].equals("!="))
						p[i] = builder.notEqual(root.get(columns[i]), values[i]);
					else if (operators[i].equals("NOT LIKE"))
						p[i] = builder.notLike(root.get(columns[i]), values[i]);
				}
				criteriaQuery.where(builder.and(p));
			}

			Query<Entity> query = session.createQuery(criteriaQuery);
			list = query.getResultList();

			session.getTransaction().commit();
		} catch (HibernateException e) {
			Logger.getLogger(HibernateUtils.class.getName()).log(Level.SEVERE, "HibernateUtils.java throws exception",
					e);
		}
		return list;
	}
}
