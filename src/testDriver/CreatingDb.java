package testDriver;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreatingDb {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Session session = null;
		try{
		SessionFactory sessionFactory =
		new Configuration().configure().buildSessionFactory();
		session = sessionFactory.openSession();
		} catch(Exception e){
		System.out.println(e.getMessage());
		}
	}

}
