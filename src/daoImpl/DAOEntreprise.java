package daoImpl;

import java.util.Set;

import javax.servlet.ServletContext;

import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.web.context.support.WebApplicationContextUtils;

import util.ServerUtils;

import daoInterface.IDAOContact;
import daoInterface.IDAOEntreprise;
import domain.Contact;
import domain.Entreprise;

public class DAOEntreprise extends HibernateDaoSupport implements IDAOEntreprise {
	
	private Entreprise entreprise;
	public DAOEntreprise() {
	}
	public DAOEntreprise(Entreprise entreprise) {
		this.entreprise = entreprise;
	}
	public Entreprise getEntreprise() {
		return entreprise;
	}

	public void setEntreprise(Entreprise entreprise) {
		this.entreprise = entreprise;
	}
 
	@Override
	public String addEntreprise(Entreprise entreprise1,ServletContext sv) {
		String rvalue = null;
		
		
		
		ApplicationContext  appCtx =	
				WebApplicationContextUtils.getWebApplicationContext(sv);		
		String dbOutput = "";
		IDAOContact daoContact = null;
		IDAOEntreprise daoEntreprise = null;
			daoEntreprise = (IDAOEntreprise) appCtx.getBean("daoEntrepriseProperty");		
			daoContact = (IDAOContact) appCtx.getBean("daoContactProperty");
		//getHibernateTemplate().saveOrUpdate(daoContact.getContact()); // <---- 1
		Entreprise entreprise = daoEntreprise.getEntreprise();
		Contact contact = (Contact)entreprise;
		getHibernateTemplate().saveOrUpdate(contact); // <----- 2 The same, by why dont it work :((
		rvalue = ServerUtils.opFait;
		return rvalue;
	}

	@Override
	public String addEntreprise(String firstName, String lastName,
			String email, String street, String city, String zip,
			String country, String phoneKind, String phoneNumber,
			long siretNumber) {
		// TODO Auto-generated method stub
		return null;
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
