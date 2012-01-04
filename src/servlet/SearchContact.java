package servlet;

import java.io.IOException;

import javax.naming.Context;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import util.ServerUtils;

import daoInterface.IDAOContact;
import util.*;

/**
 * Servlet implementation class SContactSearchContact
 */
public class SearchContact extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchContact() {
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
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String reqUrl =  request.getRequestURL().toString();
		System.out.println("SearchContact::doPost reqUrl='" + reqUrl + "'");
		System.out.println("request.getContextPath()" + request.getContextPath());
		
		//Integer id = Integer.parseInt(request.getParameter("contactID"));
		String id 		 = request.getParameter("id");
		String firstName = request.getParameter("firstname");
		String lastName = request.getParameter("lastname");
		String email    = request.getParameter("email");
		String street = request.getParameter("street");	
		String city = request.getParameter("city");
		String zip = request.getParameter("zip");
		String country = request.getParameter("country");
		String phoneKind = request.getParameter("phonekind");
		String phoneNumber = request.getParameter("phonenumber");
		String numSiret = request.getParameter("numsiret");
		
		ServerUtils.showParameters(firstName, lastName, email, street, city, zip, country, phoneKind, phoneNumber, numSiret);
		
		ApplicationContext  ac =	WebApplicationContextUtils.getWebApplicationContext(getServletContext());
		IDAOContact daoContact = (IDAOContact) ac.getBean("daoContactProperty");
		
		
		String dbOutput = null;

		if (reqUrl.matches(".*/ContactSimple")){
			System.out.println(".*/ContactSimple");
			dbOutput = daoContact.searchContactSimple(id);
        }
		else if (reqUrl.matches(".*/ContactCriteria")){
			System.out.println(".*/ContactCriteria");
			dbOutput = daoContact.searchContact(0, firstName, lastName, email, street, city, zip, country, phoneKind, phoneNumber, numSiret);
		}
		else if (reqUrl.matches(".*/EntrepriseSimple")){
			System.out.println(".*/EntrepriseSimple");
			System.out.println("entreprise");
		}
		else if (reqUrl.matches(".*/EntrepriseCriteria")){
			System.out.println(".*/EntrepriseCriteria");
		}
		else
			System.out.println("no of if/else of criteria, warning");
		 
		


		String responseUrl = "/" + "accueil.jsp" + ServerUtils.getNewParameter("dbOutputRaw", dbOutput);
		System.out.println("::doPost responseUrl=" + responseUrl);

		
		//RequestDispatcher rd = getServletContext().getRequestDispatcher( responseUrl );
		//rd.forward(request, response);
	
		response.sendRedirect(request.getContextPath() + responseUrl); 

		
		
		


		
	}

}
