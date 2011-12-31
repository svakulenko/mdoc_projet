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
//		Enumeration<String> prms = request.getParameterNames();
//		if (prms.hasMoreElements()) {
//			String prmName = (String) prms.nextElement();
//			System.out.println("enum par name = " + prmName ); //why only password?
//		}
		
	    String loginName = request.getParameter("username");
		String password = request.getParameter("password");
	

			
		
//		System.out.println("user=" + loginName + 
//				", pwd=" + password +
//				", methode =" +request.getMethod() +
//				", parametersNames=" );
//		
//		System.out.println("getServletContext().getContextPath()=" + getServletContext().getContextPath());
		
		
		RequestDispatcher rd = null;
		


		String path = "";
		//jsp variant
		//on ajoute le parameter supplementaire pour g�n�rer dynamiquement link dans error page
		String[] errorPage = {"indexPage", getServletContext().getContextPath() + "/index.html"};
		String[] successPage = {"acceuil", getServletContext().getContextPath() + "/accueil.jsp"};
		
		if (loginName.isEmpty()| !loginName.equals(password) )
			path = "/loginError.jsp" + serverUtils.getNewParameter(errorPage[0],errorPage[1]);
		else
			path = "/loginSuccess.jsp" + serverUtils.getNewParameter(successPage[0],successPage[1]);
		rd = getServletContext().getRequestDispatcher(path);
		rd.forward(request, response);
		
		
	}
}
