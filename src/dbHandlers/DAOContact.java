package dbHandlers;


import java.util.ArrayList;
import java.util.List;


import mycommonFonctional.*;
import mydomain.Contact;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.springframework.orm.hibernate3.HibernateTemplate;

import springi.IDAOContact;


public class DAOContact implements IDAOContact{
	
	private HibernateTemplate ht;
	
	
	
	public HibernateTemplate getHt() {
		return ht;
	}
	public void setHt(SessionFactory sf) {
		this.ht = new HibernateTemplate(sf);
	}

	Contact contact;
	public DAOContact (){}
	public DAOContact (Contact contact){
		this.contact = contact;
	}
	public void setContact(Contact contact){
		this.contact= contact;
	}
	public Contact getContact(){
		return this.contact;
	}

	String tableName = "contact2";
	String opFait = "l'operation a été fait";
	String opNoRecords = "Pas de records dans dbase";

	// private Session session = null;

	// public void createSession ()
	// {
	// Configuration cfg = new Configuration().configure("hibernate.cfg.xml");
	// SessionFactory sessionFactory = cfg.buildSessionFactory();
	// session = sessionFactory.getCurrentSession();
	// }
	public String hClearTable() {
		System.out.println("::hClearTable start");
		String rvalue = null;
		Session s = null;
		try {
			SessionFactory sf = new Configuration().configure()
					.buildSessionFactory();
			s = sf.openSession();
			Transaction t = s.beginTransaction();

	        String hql = "DELETE from Contact";
	        s.createQuery(hql).executeUpdate();

	        //List<Contact> l = query.list();
	        //for (Contact c : l)
	        	//System.out.println(c.getFirstName());
	        	//Query q = s.createQuery("SELECT * FROM " + tableName );
			//q.executeUpdate();
			t.commit();
			
			rvalue = opFait;
		} catch (Exception e) {
			System.out.println("exception: " + e.getMessage());
			rvalue = e.getMessage();
		}
		System.out.println("::hClearTable end");
		return rvalue;

	}

	public String hAddContact(long id, String FirstName, String LastName,
			String Email) {
		String rvalue = null;
		
		
		/*
		System.out.println("::hAddContact start");

		Session s = null;
		
		try {
			SessionFactory sf = new Configuration().configure()
					.buildSessionFactory();
			s = sf.openSession();
			Transaction t = s.beginTransaction();
			Contact c = new Contact();
			c.setId(1);
			c.setFirstName(FirstName);
			c.setLastName(LastName);
			c.setEmail(Email);
			s.save(c);
			t.commit();
			rvalue = opFait;
			
		} catch (Exception e) {
			System.out.println("exception: " + e.getMessage());
			rvalue = e.getMessage();
			e.printStackTrace();
		}
		System.out.println("::hAddContact end");
		*/
		return rvalue;

	}
	/*
	public String hAddContact(long id, String FirstName, String LastName,
			String Email) {
		System.out.println("::hAddContact start");
		String rvalue = null;
		Session s = null;
		try {
			SessionFactory sf = new Configuration().configure()
					.buildSessionFactory();
			s = sf.openSession();
			Transaction t = s.beginTransaction();
			Contact c = new Contact();
			c.setId(1);
			c.setFirstName(FirstName);
			c.setLastName(LastName);
			c.setEmail(Email);
			s.save(c);
			t.commit();
			rvalue = opFait;
			
		} catch (Exception e) {
			System.out.println("exception: " + e.getMessage());
			rvalue = e.getMessage();
			e.printStackTrace();
		}
		System.out.println("::hAddContact end");
		return rvalue;

	}
	*/
	
	
	//
	public String hSearchContact(long id){
		System.out.println("::deleteContact start id=" + id);
		String rvalue = null;
		Session s = null;
		try {
			SessionFactory sf = new Configuration().configure()
					.buildSessionFactory();
			s = sf.openSession();
			
			Contact c =  (Contact) s.load(Contact.class, id);
			List<Contact> contactList = new ArrayList<Contact>();
			contactList.add(c);
			
            //System.out.println("select a ete fait fn=" + c.getFirstName() );   
            
			rvalue = serverUtils.generateTable(contactList, "Contact table");
			
			
		} catch (Exception e) {
			System.out.println("exception: " + e.getMessage());
			rvalue = e.getMessage();
		}
		
		return rvalue;
	}
	//



	public String deleteContact(long id){
		System.out.println("::deleteContact start id=" + id);
		String rvalue = null;
		Session s = null;
		try {
			SessionFactory sf = new Configuration().configure()
					.buildSessionFactory();
			s = sf.openSession();
			Transaction t = s.beginTransaction();
			Contact c = new Contact();
			
			c.setId(id);
			s.delete(c);
			t.commit();
			rvalue = opFait;
			
			
		} catch (Exception e) {
			System.out.println("exception: " + e.getMessage());
			rvalue = e.getMessage();
		}
		
		return rvalue;
	}
	
	public String getAllContacts(){
		System.out.println("::getAllContacts start");
		String rvalue = null;
		Session s = null;
		try {
			SessionFactory sf = new Configuration().configure()
					.buildSessionFactory();
			s = sf.openSession();
			Transaction t = s.beginTransaction();

	        String hql = "from Contact ";
	        Query query = s.createQuery(hql);
	        @SuppressWarnings("unchecked")
			List<Contact> l = query.list();
	        for (Contact c : l)
	        	System.out.println(c.getFirstName());
	        	//Query q = s.createQuery("SELECT * FROM " + tableName );
			//q.executeUpdate();
	        if (l.size() == 0)
	        	rvalue = opNoRecords;
	        else
	        	rvalue = serverUtils.generateTable(l, "Contact table");
	        
			t.commit();
			

		} catch (Exception e) {
			System.out.println("exception: " + e.getMessage());
			rvalue = e.getMessage();
		}
		System.out.println("::getAllContacts end rvalue=");
		return rvalue;

	}
	


}
