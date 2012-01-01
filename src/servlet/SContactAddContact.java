package servlet;

import java.io.IOException;
import java.util.Iterator;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;





import org.springframework.context.*;
import org.springframework.web.context.support.WebApplicationContextUtils;

import util.ServerUtils;

import daoInterface.*;
import domain.PhoneNumber;


/**
 * Servlet implementation class SContactAddContact
 */
public class SContactAddContact extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SContactAddContact() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		System.out.println("SContact::doPost 1");
		String firstName = request.getParameter("firstname");
		String lastName = request.getParameter("lastname");
		String email    = request.getParameter("email");
		String street = request.getParameter("street");	

		System.out.println("street=" + street);
		//DAOContact daoContact = new DAOContact();
		
		ApplicationContext  appCtx =	WebApplicationContextUtils.getWebApplicationContext(getServletContext());
		
		IDAOContact daoContact = (IDAOContact) appCtx.getBean("daocontactProperty");
        Iterator<PhoneNumber> iterator = daoContact.getContact().getPhoneNumbers().iterator();
        
        // Testing it values
        // Address;
        System.out.println(daoContact.getContact().getAddress().toString());
        PhoneNumber phoneNumber = null;
        while(iterator.hasNext())
        {
        	phoneNumber = iterator.next();
        	System.out.println("Kind: " + phoneNumber.getPhoneKind() + " Number: " + phoneNumber.getPhoneNumber());
        }
        
        IDAOEntreprise daoEntreprise = (IDAOEntreprise) appCtx.getBean("daoEntrepriseConstructor");
        System.out.println(daoEntreprise.toString());
        
        
//		dao = (IDAOContact) appCtx.getBean("daocontact");
//		System.out.println("dao.contact=" + dao.getContact());
//		iterator = dao.getContact().getPhoneNumbers().iterator();
//        
//		while(iterator.hasNext())
//        {
//          System.out.println(iterator.next().getPhoneKind());
//        }
//		
//
//        
		String dbOutput = daoContact.hAddContact(0, firstName, lastName, email);
		
		String responseUrl = "/addContact.jsp" + ServerUtils.getNewParameter("dbOutput", dbOutput);
		System.out.println("::doPost responseUrl=" + responseUrl);

		RequestDispatcher rd = getServletContext().getRequestDispatcher( responseUrl );
		rd.forward(request, response);
	}

}


/*
String city = request.getParameter("city");
String zip    = request.getParameter("zip");
String country = request.getParameter("country");
String phonekind = request.getParameter("phonekind");
String phonenumber    = request.getParameter("phonenumber");
*/	