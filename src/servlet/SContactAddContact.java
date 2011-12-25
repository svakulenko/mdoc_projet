package servlet;

import java.io.IOException;
import java.util.Iterator;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;




import mycommonFonctional.serverUtils;
import mydomain.PhoneNumber;

import org.springframework.context.*;
import org.springframework.web.context.support.WebApplicationContextUtils;

import springi.*;

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
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("SContact::doPost 1");
		
		


		
		String FirstName = request.getParameter("firstname");
		String LastName = request.getParameter("lastname");
		String Email    = request.getParameter("email");
		String street = request.getParameter("street");	
/*


		String city = request.getParameter("city");
		String zip    = request.getParameter("zip");
		String country = request.getParameter("country");
		String phonekind = request.getParameter("phonekind");
		String phonenumber    = request.getParameter("phonenumber");
*/	
		System.out.println("street=" + street);
		//DAOContact daoContact = new DAOContact();
		
		ApplicationContext  ac =	WebApplicationContextUtils.getWebApplicationContext(getServletContext());

		
		IDAOContact dao = (IDAOContact) ac.getBean("daocontactContr");
        Iterator<PhoneNumber> itr = dao.getContact().getPhoneNumbers().iterator();
        while(itr.hasNext()){
          System.out.println(itr.next().getPhoneKind());
        }
        
		dao = (IDAOContact) ac.getBean("daocontact");
		System.out.println("dao.contact=" + dao.getContact());
		itr = dao.getContact().getPhoneNumbers().iterator();
        while(itr.hasNext()){
          System.out.println(itr.next().getPhoneKind());
        }
		

        
		String dbOutput = dao.hAddContact(0, FirstName, LastName, Email);
		
		String responseUrl = "/addContact.jsp" + serverUtils.getNewParameter("dbOutput", dbOutput);
		System.out.println("::doPost responseUrl=" + responseUrl);

		RequestDispatcher rd = getServletContext().getRequestDispatcher( responseUrl );
		rd.forward(request, response);
	}

}
