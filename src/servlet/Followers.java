package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import business.BusinessFollower;
import business.IBusinessFollower;
import domain.IUser;

/**
 * Servlet implementation class Followers
 */
@WebServlet("/Followers")
public class Followers extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Followers() {
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
		showFollowers(request,response);
	}

	private void showFollowers(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		
		PrintWriter out = response.getWriter();
		
		IBusinessFollower businessFollower = new BusinessFollower();
	
//		businessFollower.deleteFollower("1336906505920ffffffff8cbf5ad9");
//		businessFollower.insertFollower("link", "tercero");
	
		
		List<IUser> followerd = businessFollower.getMyFollowed("link");
		List<IUser> followers = businessFollower.getMyFollowers("link");
		
		
		
		
		out.println(" Lista de usuarios que sige link: <br><br><br>");
		
		for(IUser user: followerd) {
			out.println("Nombre del usuario: " + user.getName() + "<br><br>");		
		}
		
	out.println(" Lista de usuarios que sigen alink: <br><br><br>");
		
		for(IUser user: followers) {
			out.println("Nombre del usuario: " + user.getName() + "<br><br>");		
		}
		

		

		
	}
}
