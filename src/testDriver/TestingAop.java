package testDriver;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import daoInterface.IDAOContact;

public class TestingAop {

	/**
	 * @param args
	 */
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		 //   ApplicationContext acx=new ClassPathXmlApplicationContext("beans.xml");  
	    ApplicationContext acx=new FileSystemXmlApplicationContext("WebContent/WEB-INF/applicationContext.xml");  
	    // ApplicationContext acx=new ClassPathXmlApplicationContext("com/kogent/beans.xml");   
//	    IMyBean dao = (IMyBean)acx.getBean("hello");
//	    dao.sayHello("1","2");
	    IDAOContact dao = (IDAOContact)acx.getBean("daoContactProperty");
	    dao.addContact("first", "last","mail","street","city","zip","country","pKind","pNumber");
	    
	   
	}

}
