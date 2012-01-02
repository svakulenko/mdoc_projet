package daoInterface;

import domain.Contact;

public interface IDAOContact {
	public void setContact(Contact contact);
	public Contact getContact();
	public String clearTable();
	public String addContact(long id, String FirstName, String LastName,String Email);
	public String searchContact(long id);
	public String deleteContact(long id);
	public String getAllContacts();
}
