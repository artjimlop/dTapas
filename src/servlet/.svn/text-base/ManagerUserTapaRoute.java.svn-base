package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import business.BusinessTapaRoute;
import business.BusinessUser;
import business.BusinessUserTapaRoute;
import business.IBusinessUserTapaRoute;
import domain.ITapaRoute;
import domain.IUser;

/**
 * Servlet implementation class ManagerUserTapaRoute
 */
@WebServlet("/ManagerUserTapaRoute")
public class ManagerUserTapaRoute extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ManagerUserTapaRoute() {
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
		showUserTapaRoute(request,response);
	}
	
	private void showUserTapaRoute(HttpServletRequest request, HttpServletResponse response) throws IOException{
		PrintWriter out = response.getWriter();
		IBusinessUserTapaRoute businessUserTapaRoute = new BusinessUserTapaRoute();
		
		IUser user = new BusinessUser().getUserByLogin("practica");
		ITapaRoute tapaRoute = new BusinessTapaRoute().getTapaRouteByID(1);
		businessUserTapaRoute.insertUsersTapaRoute(user, tapaRoute);
		
		List<IUser> users= businessUserTapaRoute.getAllUserFromUserTapaRoute();
		for(IUser u: users){
			out.println(u.getLogin());
		}
		
		businessUserTapaRoute.deleteUsersTapaRoute(user, tapaRoute);
		
		users= businessUserTapaRoute.getAllUserFromUserTapaRoute();
		for(IUser u: users){
			out.println(u.getLogin());
		}
		
		
		
		
	}

}
