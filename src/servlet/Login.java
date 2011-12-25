package servlet;


import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mycommonFonctional.*;

/**
 * Servlet implementation class Login
 */
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
        // 
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Login::doPost");
		@SuppressWarnings("unchecked")
		Enumeration<String> prms = request.getParameterNames();
		if (prms.hasMoreElements()) {
			String prmName = (String) prms.nextElement();
			System.out.println("enum par name = " + prmName ); //why only password?
		}
		
	    String lgn = request.getParameter("username");
		String pwd = request.getParameter("password");
	

			
		
		System.out.println("user=" + lgn + 
				", pwd=" + pwd +
				", methode =" +request.getMethod() +
				", parametersNames=" );
		
		System.out.println("getServletContext().getContextPath()=" + getServletContext().getContextPath());
		
		
		RequestDispatcher rd = null;
		


		
		//jsp variant
		//on ajoute le parameter supplementaire pour g�n�rer dynamiquement link dans error page
		String[] ParError = {"indexPage", getServletContext().getContextPath() + "/index.html"};
		String[] ParSuccess = {"acceuil", getServletContext().getContextPath() + "/accueil.jsp"};
		if (lgn == null || lgn == "" 
				|| pwd == ""|| pwd == null 
				|| !lgn.equals(pwd)
				)
			rd = getServletContext().getRequestDispatcher("/loginError.jsp"
				+ serverUtils.getNewParameter(ParError[0],ParError[1])
				);
		else
			rd = getServletContext().getRequestDispatcher("/loginSuccess.jsp"
					+ serverUtils.getNewParameter(ParSuccess[0],ParSuccess[1])
					);
		
		
		rd.forward(request, response);
		
		
	}
}
