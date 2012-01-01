package daoImpl;

import java.util.Set;

import daoInterface.IDAOEntreprise;
import domain.Entreprise;

public class DAOEntreprise implements IDAOEntreprise 
{
	private Entreprise entreprise;
	public DAOEntreprise(){
	}
	public DAOEntreprise(Entreprise entreprise)
	{
		this.entreprise = entreprise;
	}
	
	@Override
	public Entreprise getEntreprise() 
	{
		// TODO Auto-generated method stub
		return this.entreprise;
	}
	@Override
	public void setEntreprise(Entreprise entreprise) 
	{
		// TODO Auto-generated method stub
		this.entreprise = entreprise;
	}

	@Override
	public void addEntreprise(long id, String FirstName, String LastName,
			String Email, int siretNumber) 
	{
		// TODO Auto-generated method stub
		

	}

	@Override
	public Entreprise searchEntreprise(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Entreprise deleteEntreprise(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Set<Entreprise> getAllEntreprise() {
		// TODO Auto-generated method stub
		return null;
	}

}
