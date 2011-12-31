package daoInterface;

import mydomain.Contact;

public interface IDAOContact {
	public void setContact(Contact contact);
	public Contact getContact();
	public String hClearTable();
	public String hAddContact(long id, String FirstName, String LastName,String Email);
	public String hSearchContact(long id);
	public String deleteContact(long id);
	public String getAllContacts();
}
