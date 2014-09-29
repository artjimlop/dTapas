package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import business.BusinessFollower;

/**
 * Servlet implementation class DeleteFollower
 */
@WebServlet("/DeleteFollower")
public class DeleteFollower extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteFollower() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BusinessFollower bf = new BusinessFollower();
		String userCurrent = request.getParameter("user_current");
		String userSuggest = request.getParameter("user_suggest");
		String destiny = request.getParameter("destiny");
		bf.deleteFollower(userCurrent, userSuggest);
		response.sendRedirect(destiny);
	}

}
