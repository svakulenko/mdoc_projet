package daoInterface;

import java.util.Set;

import javax.servlet.ServletContext;

import domain.Entreprise;


public interface IDAOEntreprise 
{
	public Entreprise getEntreprise();
	public void setEntreprise(Entreprise entreprise);
	
	public String addEntreprise(Entreprise entreprise);
	public String addEntreprise(	String firstName, 
			String lastName,
			String email,
			String street,
			String city,
			String zip,
			String country,
			String phoneKind,
			String phoneNumber,
			long siretNumber
		 );
	public String searchEntreprise(long id);
	public String deleteEntreprise(long id);
	public String getAllEntreprise();
	
	public String searchEntreprise(long id,
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
	public String deleteEntreprise(long id,
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
}


/*

public void setContact(Contact contact);
	public Contact getContact();
	public String hClearTable();
	public String hAddContact(long id, String FirstName, String LastName,String Email);
	public String hSearchContact(long id);
	public String deleteContact(long id);
	public String getAllContacts();

*/
