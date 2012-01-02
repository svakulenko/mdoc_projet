package testDriver;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import domain.Address;
import domain.Contact;
import domain.ContactGroup;
import domain.PhoneNumber;

public class CreatingDb {

	/**
	 * @param args
	 */
	public static void main(String[] args) 
	{
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
