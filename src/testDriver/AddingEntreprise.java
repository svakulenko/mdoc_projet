package testDriver;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import domain.Address;
import domain.ContactGroup;
import domain.Entreprise;
import domain.PhoneNumber;

public class AddingEntreprise {

	/**
	 * @param args
	 */
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		Session session = null;
		Entreprise entreprise = null;
		Address address = null;
		PhoneNumber phone = null;
		ContactGroup contactGroup = null;
		
		String firstName = "firstName";
		String lastName = "lastName";
		String email = "name@email.com";
		String street = "street";
		String city = "city";
		String zip = "12345";
		String country = "country";
		
		// If id in hbm file is "increment", then we dont need to explicitly set id value
		try
		{
			SessionFactory sessionFactory =
				new Configuration().configure().buildSessionFactory();
			session = sessionFactory.openSession();
			org.hibernate.Transaction tx = session.beginTransaction();
			//create a contact and save it into the DB
			entreprise = new Entreprise();
			entreprise.setFirstName(firstName);
			entreprise.setLastName(lastName);
			entreprise.setAddress(address);
			entreprise.setEmail(email);
			
			address = new Address();
			address.setStreet(street);
			address.setCity(city);
			address.setZip(zip);
			address.setCountry(country);
			entreprise.setAddress(address); // Uni birectionnel
			
			phone = new PhoneNumber("HomePhone", "myHomeNumber");
			entreprise.getPhoneNumbers().add(phone);
			phone.setContact(entreprise);
			phone = new PhoneNumber("CellPhone", "myCellNumber");
			entreprise.getPhoneNumbers().add(phone);
			phone.setContact(entreprise);
			
			contactGroup = new ContactGroup("contactGroup1");
			entreprise.getContactgroup().add(contactGroup);
			contactGroup.getContacts().add(entreprise);
			contactGroup = new ContactGroup("contactGroup2");
			entreprise.getContactgroup().add(contactGroup);
			contactGroup.getContacts().add(entreprise);
			//save the contact into the DB
			//session.save(a);
			session.saveOrUpdate(entreprise); // or session.persist(contact);
			
			//if you modify one of its properties, no need to save it again
			//contact.setFirstName("Robin");
			//mandatory to flush the data into the DB
			tx.commit();
			
			
			session = sessionFactory.openSession();
			tx = session.beginTransaction();
			contactGroup = (ContactGroup) session.load(ContactGroup.class, new Long(2));
			entreprise = new Entreprise();
			entreprise.setFirstName("Testing 2nd times");
			entreprise.setLastName(lastName);
			entreprise.setAddress(address);
			entreprise.setEmail(email);
			
			address = new Address();
			address.setStreet(street);
			address.setCity(city);
			address.setZip(zip);
			address.setCountry(country);
			entreprise.setAddress(address); // Uni birectionnel
			
			phone = new PhoneNumber("HomePhone", "myHomeNumber");
			entreprise.getPhoneNumbers().add(phone);
			phone.setContact(entreprise);
			phone = new PhoneNumber("CellPhone", "myCellNumber");
			entreprise.getPhoneNumbers().add(phone);
			phone.setContact(entreprise);
			entreprise.getContactgroup().add(contactGroup);
			contactGroup.getContacts().add(entreprise);
			
			session.saveOrUpdate(entreprise);
			tx.commit();
			
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
	}

}
