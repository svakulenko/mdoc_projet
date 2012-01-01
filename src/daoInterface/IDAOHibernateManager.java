package daoInterface;

import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate3.HibernateTemplate;

public interface IDAOHibernateManager 
{
	public HibernateTemplate getHibernateTemplate();
	public void setSessionFactory(SessionFactory sessionFactory);
}
