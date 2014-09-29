package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import business.BusinessUser;
import business.IBusinessUser;
import domain.IUser;
import domain.User;

/**
 * Servlet implementation class ManagerUser
 */
@WebServlet("/ManagerUser")
public class ManagerUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ManagerUser() {
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
		showUser(request,response);
	}
	
	private void showUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		PrintWriter out = response.getWriter();
		IBusinessUser businessUser = new BusinessUser();
		
		IUser u = new User("dav", "dav", "dav", "dav", "dav");
		businessUser.insertUser(u);
		
		List<IUser> users = businessUser.getAllUsers();
		out.println("Usuarios del sistema: <br>");
		for(IUser user: users){
			out.println("Nombre:   " + user.getName() + "          Login:      " + user.getLogin() + "<br>");
		}
		
		u = businessUser.getUserByLogin("dav");
		businessUser.deleteUser(u);
		
		users = businessUser.getAllUsers();
		out.println("<br><br>Usuarios del sistema: <br>");
		for(IUser user: users){
			out.println("Nombre:   " + user.getName() + "          Login:      " + user.getLogin() + "<br>");
		}
	}

}
