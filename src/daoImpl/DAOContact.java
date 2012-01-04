package daoImpl;

import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;

import org.hibernate.FetchMode;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import util.*;

import daoInterface.IDAOContact;
import domain.Address;
import domain.Contact;
import domain.ContactGroup;
import domain.PhoneNumber;

public class DAOContact extends HibernateDaoSupport implements IDAOContact {

	Contact contact;
	String firstName;

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

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

	public String addContact(Contact contact) {
		String rvalue = null;
		getHibernateTemplate().saveOrUpdate(contact);
		rvalue = ServerUtils.opFait;
		return rvalue;
	}

	public String addContact(String firstName, String lastName, String email,
			String street, String city, String zip, String country,
			String phoneKind, String phoneNumber,String group) {
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

		PhoneNumber phone = new PhoneNumber();
		phone.setPhoneKind(phoneKind);
		phone.setPhoneNumber(phoneNumber);
		contact.getPhoneNumbers().add(phone);
		phone.setContact(contact);

		
		String query = "from ContactGroup contactGroup";
		List<ContactGroup> l = getHibernateTemplate().find(query);
		Iterator<ContactGroup> ite = l.iterator();
		ContactGroup contactGroup = null;
		
		while (ite.hasNext())
		{
			contactGroup = ite.next();
			if (contactGroup.getGroupName().equals(group))
			{
				contact.getContactgroup().add(contactGroup);
				contactGroup.getContacts().add(contact);
				getHibernateTemplate().saveOrUpdate(contact);
				
				rvalue = ServerUtils.opFait;
				return rvalue;
			}
		}
		
		// If new contact Group
		contactGroup = new ContactGroup();
		contactGroup.setGroupName(group);
		contact.getContactgroup().add(contactGroup);
		contactGroup.getContacts().add(contact);
		
		getHibernateTemplate().saveOrUpdate(contact);
		rvalue = ServerUtils.opFait;
		return rvalue;

	}

	/*
	 * 
	 * contact = new Contact(); contact.setFirstName(firstName);
	 * contact.setLastName(lastName); contact.setAddress(address);
	 * contact.setEmail(email);
	 * 
	 * address = new Address(); address.setStreet(street);
	 * address.setCity(city); address.setZip(zip); address.setCountry(country);
	 * contact.setAddress(address); // Uni birectionnel
	 * 
	 * phone = new PhoneNumber("HomePhone", "myHomeNumber");
	 * contact.getPhoneNumbers().add(phone); phone.setContact(contact); phone =
	 * new PhoneNumber("CellPhone", "myCellNumber");
	 * contact.getPhoneNumbers().add(phone); phone.setContact(contact);
	 */

	//
	public String searchContactSimple(final String id) {
		System.out.println("searchContactSimple");
		String rvalue = null;
		
		@SuppressWarnings("unchecked")
		List<Contact> l = this.getHibernateTemplate().find(
				"from Contact contact where contact.id = ?", new Long(id));
		
		System.out.println("l.size=" + l.size());


			
		
		System.out.println("ret value31");
		if (l.size() != 0)
			rvalue = ServerUtils.generateTable(l, "Contact table");
		else
			rvalue = ServerUtils.opNoRecods;

		System.out.println("ret value");
		return rvalue;
	}
	public String deleteContact(long id,
			String firstName, 
			String lastName,
			String email,
			String street,
			String city,
			String zip,
			String country,
			String phoneKind,
			String phoneNumber,
			String numSiret
		 )
	{
		System.out.println("::hSearchContact start id=" + id);
		String rvalue = null;

		
		DetachedCriteria dc = DetachedCriteria.forClass(Contact.class)
				.setFetchMode("address", FetchMode.JOIN)
				.createAlias("address","a")
				.add(Restrictions.like("firstName", firstName+"%"))
				.add(Restrictions.like("lastName", lastName+"%"))
				.add(Restrictions.like("email", email+"%"))
				.add(Restrictions.like("a.street", street+"%"))
				.add(Restrictions.like("a.city", city+"%"))
				.add(Restrictions.like("a.zip", zip+"%"))
				.add(Restrictions.like("a.country", country+"%"))
				;;
				@SuppressWarnings("unchecked")
				List<Contact> l =getHibernateTemplate().findByCriteria(dc);
				for (Contact o : l)
				getHibernateTemplate().delete(o);

		
		

			rvalue = ServerUtils.opTableRemoved;

		return rvalue;
		
	}
	public String searchContact(long id,
			String firstName, 
			String lastName,
			String email,
			String street,
			String city,
			String zip,
			String country,
			String phoneKind,
			String phoneNumber,
			String numSiret
		 ){
		System.out.println("::hSearchContact start id=" + id);
		String rvalue = null;

		
		DetachedCriteria dc = DetachedCriteria.forClass(Contact.class)
				.setFetchMode("address", FetchMode.JOIN)
				.createAlias("address","a")
				.add(Restrictions.like("firstName", firstName+"%"))
				.add(Restrictions.like("lastName", lastName+"%"))
				.add(Restrictions.like("email", email+"%"))
				.add(Restrictions.like("a.street", street+"%"))
				.add(Restrictions.like("a.city", city+"%"))
				.add(Restrictions.like("a.zip", zip+"%"))
				.add(Restrictions.like("a.country", country+"%"))
				;;

		@SuppressWarnings("unchecked")
		List<Contact> l =getHibernateTemplate().findByCriteria(dc);
		
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
			Session sess = null;
				
			StringBuffer requeteS = new StringBuffer();
			requeteS.append("from Contact contact")
					.append(" left join contact.address as address")
					.append(" left join contact.phoneNumbers as phoneNumber")
					.append(" left join contact.contactgroup as contactGroup");
			List<Object[]> l = getHibernateTemplate().find(requeteS.toString());
//			 List<Contact> l = getHibernateTemplate().find("from Contact");
			System.out.println("list ref=" + l);

			if (l.size() == 0)
				rvalue = ServerUtils.opNoRecods;
			else
				rvalue = ServerUtils.generateContactTable(l, "Contact table");

		} catch (Exception e) {
			rvalue = e.getMessage();
		}

		return rvalue;

	}

	@Override
	public String updateContact(long id, String firstName, String lastName,
			String email, String street, String city, String zip,
			String country, String phoneKind, String phoneNumber) {
		String rvalue = null;
		StringBuffer requeteS = new StringBuffer();
		requeteS.append("from Contact contact")
				.append(" left join contact.address as address")
				.append(" left join contact.phoneNumbers as phoneNumber")
				.append(" left join contact.contactgroup as contactGroup where contact.id="+id);
		List<Object[]> l = getHibernateTemplate().find(requeteS.toString());
		if (l.size() == 0)
		{
			rvalue = "Contact dont exist!";
			return rvalue;
		}
		Contact contact = (Contact) l.get(0)[0];	
		if (firstName != null)
			contact.setFirstName(firstName);
		if (lastName != null)
			contact.setLastName(lastName);
		if (email != null)
			contact.setEmail(email);

		Address address = (Address) l.get(0)[1];
		if (street != null)
			address.setStreet(street);
		if (city != null)
			address.setCity(city);
		if (zip != null)
			address.setZip(zip);
		if (country != null)
			address.setCountry(country);
		contact.setAddress(address); // Uni birectionnel

		PhoneNumber phone = (PhoneNumber) l.get(0)[2];
		if (phoneKind != null)
			phone.setPhoneKind(phoneKind);
		if (phoneNumber != null)
			phone.setPhoneNumber(phoneNumber);
		getHibernateTemplate().saveOrUpdate(contact);
		rvalue = ServerUtils.opFait;
		return rvalue;
	}

	@Override
	public String addContact(String firstName, String lastName) {
		// TODO Auto-generated method stub
		System.out.println("Executing addContact...");
		return null;
	}

}
