package daoImpl;

import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.hibernate.FetchMode;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import util.ServerUtils;

import daoInterface.IDAOEntreprise;
import domain.Address;
import domain.Contact;
import domain.ContactGroup;
import domain.Entreprise;
import domain.PhoneNumber;

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
	public String addEntreprise(Entreprise entreprise) {
		String rvalue = null;		
		getHibernateTemplate().saveOrUpdate(entreprise); // <---- 1
		rvalue = ServerUtils.opFait;
		return rvalue;
	}

	@Override
	public String addEntreprise(String firstName, String lastName,
			String email, String street, String city, String zip,
			String country, String phoneKind, String phoneNumber,
			long siretNumber,String group) {
		// TODO Auto-generated method stub
		String rvalue = null;

		Entreprise entreprise = new Entreprise();
		entreprise.setFirstName(firstName);
		entreprise.setLastName(lastName);
		entreprise.setEmail(email);
		entreprise.setNumSiret(siretNumber);
		
		Address address = new Address();
		address.setStreet(street);
		address.setCity(city);
		address.setZip(zip);
		address.setCountry(country);
		entreprise.setAddress(address); // Uni birectionnel
		
		PhoneNumber phone = new PhoneNumber();
		phone.setPhoneKind(phoneKind);
		phone.setPhoneNumber(phoneNumber);
		entreprise.getPhoneNumbers().add(phone);
		phone.setContact(entreprise);
		
		String query = "from ContactGroup contactGroup";
		List<ContactGroup> l = getHibernateTemplate().find(query);
		Iterator<ContactGroup> ite = l.iterator();
		ContactGroup contactGroup = null;
		while (ite.hasNext())
		{
			contactGroup = ite.next();
			if (contactGroup.getGroupName().equals(group))
			{
				entreprise.getContactgroup().add(contactGroup);
				contactGroup.getContacts().add(entreprise);
				getHibernateTemplate().saveOrUpdate(entreprise);
				rvalue = ServerUtils.opFait;
				return rvalue;
			}
		}
		
		// If new contact Group
		contactGroup = new ContactGroup();
		contactGroup.setGroupName(group);
		entreprise.getContactgroup().add(contactGroup);
		contactGroup.getContacts().add(entreprise);
		
		getHibernateTemplate().saveOrUpdate(entreprise);
		rvalue = ServerUtils.opFait;
		return rvalue;
	}
	
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
		 )
	{
		System.out.println("::hSearchContact start id=" + id);
		String rvalue = null;

		
		DetachedCriteria dc = DetachedCriteria.forClass(Contact.class)
				.setFetchMode("address", FetchMode.JOIN)
				.createAlias("address","a")
				.add(Restrictions.like("firstName", firstName+"%"))
				.add(Restrictions.like("lastName", lastName+"%"))
				.add(Restrictions.like("email", email+"%"))
				.add(Restrictions.like("a.street", street+"%"))
				.add(Restrictions.like("a.city", city+"%"))
				.add(Restrictions.like("a.zip", zip+"%"))
				.add(Restrictions.like("a.country", country+"%"))
				;;
				@SuppressWarnings("unchecked")
				List<Contact> l =getHibernateTemplate().findByCriteria(dc);
				for (Contact o : l)
				getHibernateTemplate().delete(o);

		
		

			rvalue = ServerUtils.opTableRemoved;

		return rvalue;
		
	}
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
		 )
	{

		System.out.println("::searchEntreprise start numSiret=" + numSiret);
		
		Long numSiretLong = null;
		try {
			numSiretLong = new Long(numSiret);
		}
		catch (Exception e){}

		
		String rvalue = null;

		
		DetachedCriteria dc = DetachedCriteria.forClass(Entreprise.class)
				.setFetchMode("address", FetchMode.JOIN)
				.createAlias("address","a")
				
				.add(Restrictions.like("firstName", firstName+"%"))
				.add(Restrictions.like("lastName", lastName+"%"))
				.add(Restrictions.like("email", email+"%"))
				.add(Restrictions.like("a.street", street+"%"))
				.add(Restrictions.like("a.city", city+"%"))
				.add(Restrictions.like("a.zip", zip+"%"))
				.add(Restrictions.like("a.country", country+"%"))
				;;
				
				if (numSiretLong != null)
					dc = dc.add(Restrictions.like("numSiret", numSiretLong));
				
				

		@SuppressWarnings("unchecked")
		List<Contact> l = getHibernateTemplate().findByCriteria(dc);
		
		if (l.size() != 0)
			rvalue = ServerUtils.generateTable(l, "Entreprise table");
		else
			rvalue = ServerUtils.opNoRecods;

		return rvalue;
	}
	
	@Override
	public String searchEntreprise(long id) {
		// TODO Auto-generated method stub
		System.out.println("::hSearchContact start id=" + id);
		String rvalue = null;

		@SuppressWarnings("unchecked")
		List<Contact> l = this.getHibernateTemplate().find(
				"from Contact contact where contact.id = ?", id);
		System.out.println("l.size=" + l.size());

		if (l.size() != 0)
			rvalue = ServerUtils.generateTable(l, "Entreprise table");
		else
			rvalue = ServerUtils.opNoRecods;

		return rvalue;
	}

	@Override
	public String deleteEntreprise(final long id) {
		// TODO Auto-generated method stub
		System.out.println("::deleteContact start");
		String rvalue = null;
		rvalue = getHibernateTemplate().execute(
				new HibernateCallback<String>() {

					@Override
					public String doInHibernate(Session arg0)
							throws HibernateException, SQLException {

						Query q = arg0
								.createQuery("from Contact where id = :value ");
						q.setParameter("value", id);
						@SuppressWarnings("unchecked")
						List<Contact> l = q.list();
						for (Contact c : l) {
							arg0.delete(c);
						}

						return ServerUtils.opFait;
					}
				});

		return rvalue;
	}

	@Override
	public String getAllEntreprise() {
		// TODO Auto-generated method stub
		String rvalue = null;

		try {
			@SuppressWarnings("unchecked")
			Session sess = null;
				
			StringBuffer requeteS = new StringBuffer();
			requeteS.append("from Entreprise entreprise")
					.append(" left join entreprise.address as address")
					.append(" left join entreprise.phoneNumbers as phoneNumber")
					.append(" left join entreprise.contactgroup as contactGroup");
			List<Object[]> l = getHibernateTemplate().find(requeteS.toString());
//			 List<Contact> l = getHibernateTemplate().find("from Contact");
			System.out.println("list ref=" + l);

			if (l.size() == 0)
				rvalue = ServerUtils.opNoRecods;
			else
				rvalue = ServerUtils.generateEntrepriseTable(l, "Entreprise table");

		} catch (Exception e) {
			rvalue = e.getMessage();
		}

		return rvalue;
	}

}
