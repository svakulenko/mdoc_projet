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
 * Servlet implementation class AddWithSpring
 */
public class AddWithSpring extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddWithSpring() {
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
		String requestUrl = request.getRequestURL().toString();
		System.out.println(requestUrl);
		
		ApplicationContext  appCtx =	
				WebApplicationContextUtils.getWebApplicationContext(getServletContext());			
		String dbOutput = "";
		if (requestUrl.contains("Contact"))
		{
			IDAOContact daoContact = (IDAOContact) appCtx.getBean("daoContactProperty");
			dbOutput = daoContact.addContact(daoContact.getContact());
		}
		else
		{
			IDAOEntreprise daoEntreprise = (IDAOEntreprise) appCtx.getBean("daoEntrepriseProperty");
			dbOutput = daoEntreprise.addEntreprise(daoEntreprise.getEntreprise());
		}
		String responseUrl = "/addContactSpring.jsp" + ServerUtils.getNewParameter("dbOutput", dbOutput);
		System.out.println("::doPost responseUrl=" + responseUrl);

//		RequestDispatcher rd = getServletContext().getRequestDispatcher( responseUrl );
//		rd.forward(request, response);
		response.sendRedirect(request.getContextPath() + responseUrl); 
	}

}
