package dbHandlers;


import java.sql.SQLException;
import java.util.List;


import mycommonFonctional.*;
import mydomain.Contact;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;


import springi.IDAOContact;


public class DAOContact extends DAOHibernateManager implements IDAOContact {
	

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

	
	String opFait = "l'operation a été fait";
	String opNoRecords = "Pas de records dans dbase";


	
	public String hClearTable() {
		System.out.println("::hClearTable start");
		String rvalue = null;
		rvalue = getHibernateTemplate().execute(new HibernateCallback<String>() {

			@Override
			public String doInHibernate(Session arg0) throws HibernateException,
					SQLException {


				@SuppressWarnings("unchecked")
				List<Contact> lst = arg0.createQuery("from Contact").list();
				for (Contact c : lst){
					arg0.delete(c);
				}
				
				return "table est effacé";
			}
		});
		
		
		return rvalue;

	}

	public String hAddContact(long id, String FirstName, String LastName,
			String Email) {
		String rvalue = null;
		
		Contact c = new Contact();
		c.setId(1);
		c.setFirstName(FirstName);
		c.setLastName(LastName);
		c.setEmail(Email);
		getHibernateTemplate().save(c);
		rvalue = opFait;

		return rvalue;

	}
	
	
	//
	public String hSearchContact(final long id){
		System.out.println("::hSearchContact start id=" + id);
		String rvalue = null;

		@SuppressWarnings("unchecked")
		List<Contact> l = this.getHibernateTemplate().find("from Contact contact where contact.id = ?",id);
		System.out.println("l.size=" + l.size());
		
		if (l.size() != 0)
			rvalue = serverUtils.generateTable(l, "Contact table");
		else
			rvalue = opNoRecords;


		return rvalue;
	}
	//



	public String deleteContact(final long id){
		System.out.println("::deleteContact start");
		String rvalue = null;
		rvalue = getHibernateTemplate().execute(new HibernateCallback<String>() {

			@Override
			public String doInHibernate(Session arg0) throws HibernateException,
					SQLException {
				
				
				Query q = arg0.createQuery("from Contact where id = :value ");
				q.setParameter("value", id);
				@SuppressWarnings("unchecked")				
				List<Contact> l = q.list();
				for (Contact c : l){
					arg0.delete(c);
				}
				
				return opFait;
			}
		});
				
		return rvalue;
	}
	
	public String getAllContacts(){
		String rvalue = null;

		try {
		@SuppressWarnings("unchecked")
		List<Contact> l = getHibernateTemplate().find("from Contact");
		System.out.println("list ref=" + l);
		
        if (l.size() == 0)
        	rvalue = opNoRecords;
        else
        	rvalue = serverUtils.generateTable(l, "Contact table");
        
		} catch (Exception e) {
			rvalue = e.getMessage();
			}


		return rvalue;

	}
	


}
