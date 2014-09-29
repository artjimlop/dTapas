package servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import business.BusinessUser;
import business.IBusinessUser;
import domain.IUser;

/**
 * Servlet implementation class FrontController
 */
@WebServlet("/FrontController")
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	String user = "practica";

	String passwd = "practica";

	public void init() throws ServletException {
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);

	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		try {
			processRequest(request, response);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void processRequest(HttpServletRequest request,
			HttpServletResponse response) throws IOException, ServletException, SQLException {
		if (logged(request)) {
			String resource = request.getParameter("destiny");
			RequestDispatcher d = request.getRequestDispatcher(resource);
			if(d!=null){
				d.forward(request,response);
			}
			System.out.println("LOGEADO & ACCEDIENDO A " + resource);
		} else {
			response.sendRedirect("index.jsp?error=si");
		}

	}

	private boolean logged(HttpServletRequest request) throws SQLException {
		
		boolean logged = false;

		HttpSession session = request.getSession(false);
		
		String userForm = request.getParameter("input_user");
		String passwdForm = request.getParameter("input_password");

		if (session == null) {
			session = request.getSession();
			if (userForm == null || passwdForm == null
					|| userForm.length() == 0 || passwdForm.length() == 0) {
				logged = false;

			} else {
				if (validation(userForm, passwdForm)) {
					logged = true;
					
					IBusinessUser businessUser = new BusinessUser();
					IUser user = businessUser.getUserByLogin(userForm);
					
					session.setAttribute("session.user", user.getLogin());
				} else {
					logged = false;
				}

			}

		} else {
			logged = false;
			if (userForm != null && passwdForm != null) {
				if (validation(userForm, passwdForm)) {
					IBusinessUser businessUser = new BusinessUser();
					IUser user = businessUser.getUserByLogin(userForm);
					
					session.setAttribute("session.user", user.getLogin());
					logged = true;
				} 

			}
		}
		return logged;
	}

	public boolean validation(String userForm, String passwdForm) throws SQLException {
		
		boolean res = false;
		IUser user = null;
		
		IBusinessUser businessUser = new BusinessUser();
		user = businessUser.getUserByLogin(userForm);
		if(user != null){
			String password = user.getPassword();
			if(password.equals(passwdForm)){
				res = true;
			}
		}
		
		return res;

	}
}
