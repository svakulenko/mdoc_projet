package daoImpl;

import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate3.HibernateTemplate;

public class DAOHibernateManager {
	private HibernateTemplate hibernateTemplate;
	
	public HibernateTemplate getHibernateTemplate(){
		return hibernateTemplate;
	}
	
    public void setSessionFactory(SessionFactory sessionFactory) {   
          this.hibernateTemplate = new HibernateTemplate(sessionFactory);   
    } 
}
