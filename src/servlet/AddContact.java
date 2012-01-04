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
public class AddContact extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
	public static final String ENTREPRISE = "entreprise";
	public static final String CONTACT = "contact";
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddContact() {
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
		System.out.println("Adding contact info into database....");
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastname");
		String email    = request.getParameter("email");
		String street = request.getParameter("street");	
		String city = request.getParameter("city");
		String zip = request.getParameter("zip");
		String country = request.getParameter("country");
		String phoneKind = request.getParameter("phonekind");
		String phoneNumber = request.getParameter("phoneNumber");
		String group = request.getParameter("groupName");
		ApplicationContext  appCtx =	
				WebApplicationContextUtils.getWebApplicationContext(getServletContext());			
			
		IDAOContact daoContact = (IDAOContact) appCtx.getBean("daoContactProperty");
		String dbOutput = daoContact.addContact(daoContact.getContact());
		
		
//		String dbOutput = daoContact.addContact(firstName, 
//												lastName, 
//												email, 
//												street, 
//												city, 
//												zip, 
//												country, 
//												phoneKind, 
//												phoneNumber,
//												group);
		daoContact.addContact("first", "last");
		
		String responseUrl = "/addContact.jsp" + ServerUtils.getNewParameter("dbOutput", dbOutput);
		System.out.println("::doPost responseUrl=" + responseUrl);

		RequestDispatcher rd = getServletContext().getRequestDispatcher( responseUrl );
		rd.forward(request, response);
	}

}
