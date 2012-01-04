package daoInterface;

import domain.Contact;

public interface IDAOContact {
	public void setContact(Contact contact);
	public Contact getContact();
	public String clearTable();
	// Used naturally via form submission
	public String addContact(	String firstName, 
								String lastName,
								String email,
								String street,
								String city,
								String zip,
								String country,
								String phoneKind,
								String phoneNumber,
								String group
							 );
	public String addContact(String firstName,String lastName);
	// Used by Spring framework
	public String addContact(Contact contact);
	public String updateContact(long id,
			String firstName, 
			String lastName,
			String email,
			String street,
			String city,
			String zip,
			String country,
			String phoneKind,
			String phoneNumber
		 );
	public String searchContactSimple(String id );
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
		 );
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
		 );
	//public String searchContact(long id);
	public String deleteContact(long id);
	public String getAllContacts();
}