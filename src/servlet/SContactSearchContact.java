package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mycommonFonctional.serverUtils;

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import springi.IDAOContact;

/**
 * Servlet implementation class SContactSearchContact
 */
public class SContactSearchContact extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SContactSearchContact() {
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
		System.out.println("SContact::doPost 1");
		
		Integer id = Integer.parseInt(request.getParameter("contactID"));

		ApplicationContext  ac =	WebApplicationContextUtils.getWebApplicationContext(getServletContext());
		IDAOContact daoContact = (IDAOContact) ac.getBean("daocontact");
		//DAOContact daoContact = new DAOContact();

		String dbOutput = daoContact.hSearchContact(id);
		String responseUrl = "/searchContact.jsp" + serverUtils.getNewParameter("dbOutput", dbOutput);
		System.out.println("::doPost responseUrl=" + responseUrl);

		RequestDispatcher rd = getServletContext().getRequestDispatcher( responseUrl );
		rd.forward(request, response);
	}

}
