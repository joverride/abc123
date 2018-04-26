package core.query;

import javax.naming.NamingException;
import javax.transaction.HeuristicMixedException;
import javax.transaction.HeuristicRollbackException;
import javax.transaction.NotSupportedException;
import javax.transaction.RollbackException;
import javax.transaction.SystemException;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import core.HibernateUtils;
import entities.Utente;

public class UserOperations {

	public static void test() throws NotSupportedException, SystemException, HeuristicMixedException, HeuristicRollbackException, RollbackException, NamingException {
		SessionFactory factory = HibernateUtils.getInstance();
	    Session s =  factory.getCurrentSession();
		try {  
		    if (!s.getTransaction().isActive())
				s.beginTransaction();
		    Utente u = s.get(Utente.class,new Integer(2));  
		    System.out.println(u == null);
		    s.getTransaction().commit();
		}  
		catch (RuntimeException e) {  
			s.getTransaction().rollback();
		    throw e;
		} 
	}
}
