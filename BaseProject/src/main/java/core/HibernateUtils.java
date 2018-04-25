package core;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtils {
	
	private static SessionFactory factory;
	
	private HibernateUtils() {}
	
	public static SessionFactory getInstance() {
		if(factory == null) {
			factory = new Configuration().configure().buildSessionFactory();
		}
		return factory;
	}
	
}
