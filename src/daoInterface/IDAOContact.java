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
								String phoneNumber
							 );
	// Used by Spring framework
	public String addContact (Contact contact);
	public String searchContact(long id);
	public String deleteContact(long id);
	public String getAllContacts();
}
/*
String firstName = request.getParameter("firstname");
		String lastName = request.getParameter("lastname");
		String email    = request.getParameter("email");
		String street = request.getParameter("street");	
		String city = request.getParameter("city");
		String zip = request.getParameter("zip");
		String phoneKind = request.getParameter("phonekind");
		String phoneNumber = request.getParameter("phoneNumber");
		String numSiret = request.getParameter("numsiret");
*/