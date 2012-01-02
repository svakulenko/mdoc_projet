package daoImpl;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import util.*;

import daoInterface.IDAOContact;
import domain.Address;
import domain.Contact;
import domain.PhoneNumber;

public class DAOContact extends HibernateDaoSupport implements IDAOContact {

	Contact contact;

	public DAOContact() {
	}

	public DAOContact(Contact contact) {
		this.contact = contact;
	}

	public void setContact(Contact contact) {
		this.contact = contact;
	}

	public Contact getContact() {
		return this.contact;
	}

	// String opFait = "l'operation a été fait";
	// String opNoRecords = "Pas de records dans dbase";

	public String clearTable() {
		System.out.println("::hClearTable start");
		String rvalue = null;
		rvalue = getHibernateTemplate().execute(
				new HibernateCallback<String>() {

					@Override
					public String doInHibernate(Session arg0)
							throws HibernateException, SQLException {

						@SuppressWarnings("unchecked")
						List<Contact> lst = arg0.createQuery("from Contact")
								.list();
						for (Contact c : lst) {
							arg0.delete(c);
						}

						return ServerUtils.opTableRemoved;
					}
				});

		return rvalue;

	}
	
	public String addContact (Contact contact)
	{
		String rvalue = null;
		getHibernateTemplate().saveOrUpdate(contact);
		rvalue = ServerUtils.opFait;
		return rvalue;
	}
	
	public String addContact(	String firstName, 
								String lastName, 
								String email,
								String street, 
								String city, 
								String zip, 
								String country,
								String phoneKind,
								String phoneNumber) 
	{
		String rvalue = null;

		Contact contact = new Contact();
		contact.setFirstName(firstName);
		contact.setLastName(lastName);
		contact.setEmail(email);
		
		Address address = new Address();
		address.setStreet(street);
		address.setCity(city);
		address.setZip(zip);
		address.setCountry(country);
		contact.setAddress(address); // Uni birectionnel
		
		PhoneNumber phone = new PhoneNumber(phoneKind, phoneNumber);
		contact.getPhoneNumbers().add(phone);
		phone.setContact(contact);
		
		getHibernateTemplate().save(contact);
		rvalue = ServerUtils.opFait;
		return rvalue;

	}

	/*
	 
	 contact = new Contact();
					contact.setFirstName(firstName);
					contact.setLastName(lastName);
					contact.setAddress(address);
					contact.setEmail(email);
					
					address = new Address();
					address.setStreet(street);
					address.setCity(city);
					address.setZip(zip);
					address.setCountry(country);
					contact.setAddress(address); // Uni birectionnel
					
					phone = new PhoneNumber("HomePhone", "myHomeNumber");
					contact.getPhoneNumbers().add(phone);
					phone.setContact(contact);
					phone = new PhoneNumber("CellPhone", "myCellNumber");
					contact.getPhoneNumbers().add(phone);
					phone.setContact(contact);
	 
	 
	 */
	
	
	
	//
	public String searchContact(final long id) {
		System.out.println("::hSearchContact start id=" + id);
		String rvalue = null;

		@SuppressWarnings("unchecked")
		List<Contact> l = this.getHibernateTemplate().find(
				"from Contact contact where contact.id = ?", id);
		System.out.println("l.size=" + l.size());

		if (l.size() != 0)
			rvalue = ServerUtils.generateTable(l, "Contact table");
		else
			rvalue = ServerUtils.opNoRecods;

		return rvalue;
	}

	//

	public String deleteContact(final long id) {
		System.out.println("::deleteContact start");
		String rvalue = null;
		rvalue = getHibernateTemplate().execute(
				new HibernateCallback<String>() {

					@Override
					public String doInHibernate(Session arg0)
							throws HibernateException, SQLException {

						Query q = arg0
								.createQuery("from Contact where id = :value ");
						q.setParameter("value", id);
						@SuppressWarnings("unchecked")
						List<Contact> l = q.list();
						for (Contact c : l) {
							arg0.delete(c);
						}

						return ServerUtils.opFait;
					}
				});

		return rvalue;
	}

	public String getAllContacts() {
		String rvalue = null;

		try {
			@SuppressWarnings("unchecked")
			List<Contact> l = getHibernateTemplate().find("from Contact");
			System.out.println("list ref=" + l);

			if (l.size() == 0)
				rvalue = ServerUtils.opNoRecods;
			else
				rvalue = ServerUtils.generateTable(l, "Contact table");

		} catch (Exception e) {
			rvalue = e.getMessage();
		}

		return rvalue;

	}

}
