package daoInterface;

import java.util.Set;

import domain.Entreprise;


public interface IDAOEntreprise 
{
	public Entreprise getEntreprise();
	public void setEntreprise(Entreprise entreprise);
	public void addEntreprise(long id, String FirstName, String LastName,String Email, int siretNumber);
	public Entreprise searchEntreprise(long id);
	public Entreprise deleteEntreprise(long id);
	public Set<Entreprise> getAllEntreprise();
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
