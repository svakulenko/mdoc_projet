package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import util.ServerUtils;

import daoInterface.IDAOContact;
import daoInterface.IDAOEntreprise;

/**
 * Servlet implementation class UpdateContact
 */
public class UpdateContact extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static final String ENTREPRISE = "entreprise";
	public static final String CONTACT = "contact";
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateContact() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String id = request.getParameter("id");
		System.out.println("Updating contact" +  id + "....");
		String firstName = request.getParameter("firstname");
		String lastName = request.getParameter("lastname");
		String email    = request.getParameter("email");
		String street = request.getParameter("street");	
		String city = request.getParameter("city");
		String zip = request.getParameter("zip");
		String country = request.getParameter("country");
		String phoneKind = request.getParameter("phonekind");
		String phoneNumber = request.getParameter("phoneNumber");
		String numSiret = request.getParameter("numsiret");
		
		String contactType = request.getParameter("typeBtn");
		
		ApplicationContext  appCtx =	
				WebApplicationContextUtils.getWebApplicationContext(getServletContext());		
		String dbOutput = "";
		IDAOContact daoContact = null;
		IDAOEntreprise daoEntreprise = null;
		if (contactType.equals(ENTREPRISE))
		{
			// For testing purposes
			daoEntreprise = (IDAOEntreprise) appCtx.getBean("daoEntrepriseProperty");
			dbOutput = daoEntreprise.addEntreprise(daoEntreprise.getEntreprise(),getServletContext());  //<-- Testing purpose
		}
		else 
		{		
			daoContact = (IDAOContact) appCtx.getBean("daoContactProperty");
			dbOutput = daoContact.updateContact(new Long(id), firstName, lastName, email, street, city, zip, country, phoneKind, phoneNumber);
		}
		
		
		String responseUrl = "/updateContact.jsp" + ServerUtils.getNewParameter("dbOutput", dbOutput);
		System.out.println("::doPost responseUrl=" + responseUrl);

		RequestDispatcher rd = getServletContext().getRequestDispatcher( responseUrl );
		rd.forward(request, response);
		
		
	}

}
