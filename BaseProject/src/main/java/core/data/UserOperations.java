package core.data;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.transaction.HeuristicMixedException;
import javax.transaction.HeuristicRollbackException;
import javax.transaction.NotSupportedException;
import javax.transaction.RollbackException;
import javax.transaction.SystemException;
import javax.transaction.UserTransaction;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import core.HibernateUtils;

public class UserOperations {

	public static void test() throws NotSupportedException, SystemException, HeuristicMixedException, HeuristicRollbackException, RollbackException, NamingException {
		UserTransaction tx = null;
		try {  
		     tx = (UserTransaction)new InitialContext()  
		                            .lookup("java:comp/UserTransaction");  
		    tx.begin();  
		    SessionFactory factory = HibernateUtils.getInstance();
		    // Do some work  
		    Session s =  factory.getCurrentSession();
		  //  Utente u = s.get(Utente.class,new Integer(2));  
		    System.out.println(tx.toString());
		    System.out.println(s.getTransaction().toString());
		    tx.commit();  
		}  
		catch (RuntimeException e) {  
		    tx.rollback();  
		    throw e; // or display error message  
		} 
	}
}
