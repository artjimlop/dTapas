package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import business.BusinessUser;
import business.IBusinessUser;
import domain.IUser;
import domain.User;

/**
 * Servlet implementation class ManagerUserCheck
 */
@WebServlet("/ManagerUserCheck")
public class ManagerUserCheck extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ManagerUserCheck() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String login = (String) request.getParameter("input_user_login");
		String name = (String) request.getParameter("input_user_name");
		String surname = (String) request.getParameter("input_user_surname");
		String password = (String) request.getParameter("input_user_password");
		String email = (String) request.getParameter("input_user_email");
		
		String destiny = null;
		
		IUser user = new User(login, password, email, name, surname);
		
		HttpSession session = request.getSession();
		session.setAttribute("user", user);
		
		IBusinessUser businessUser = new BusinessUser();
		
		if(login != null && email != null){
			if(businessUser.getUserByLogin(login) != null){
				session.setAttribute("error", "Ya existe un usuario con el login <b>" + login + "</b>.");
				destiny ="newuser.jsp";
			}else if(businessUser.getAllUsersByEmail(email) != null){
				session.setAttribute("error", "Ya existe un usuario con el e-mail <b>" + email + "</b>.");
				destiny ="newuser.jsp";
			}else{
				session.setAttribute("user", user);
				destiny = "usercreator.jsp";
			}
		}else{
			session.setAttribute("error", "Rellene <b>todos</b> los campos.");
			destiny = "newuser.jsp";
		}
		response.sendRedirect(destiny);
	}

}
