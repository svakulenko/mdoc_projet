package testDriver;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import domain.Address;
import domain.Contact;
import domain.PhoneNumber;

public class AddingContact {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Session session = null;
		Contact contact = null;
		Address address = null;
		PhoneNumber phone = null;
		
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
			
			//save the contact into the DB
			//session.save(a);
			session.save(contact); // or session.persist(contact);
			
			//if you modify one of its properties, no need to save it again
			//contact.setFirstName("Robin");
			//mandatory to flush the data into the DB
			tx.commit();
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
	}

}
