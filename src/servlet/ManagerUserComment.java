package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import utils.IDGenerator;

import business.BusinessUserComment;
import business.IBusinessUserComment;
import domain.IUserComment;
import domain.UserComment;

/**
 * Servlet implementation class ManagerUserComment
 */
@WebServlet("/ManagerUserComment")
public class ManagerUserComment extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ManagerUserComment() {
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
		showUserComment(request,response);
	}
	
	private void showUserComment(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		PrintWriter out = response.getWriter();
		IBusinessUserComment businessUserComment = new BusinessUserComment();
		
		
		
		IUserComment uc = new UserComment("dav2","dav3","Prueba");
		businessUserComment.insertUserComment(uc);
		businessUserComment.insertUserComment(uc);
		
		List<IUserComment> userComments = businessUserComment.getAllUserComments();
		for(IUserComment userComment : userComments){
			out.println(userComment.getCommentarie() + "<br>");
		}
		
		out.println("<br><br>");
		
		uc = businessUserComment.getUserCommentByUserCommentID(new IDGenerator("usercommentid", "usercomments").currentValue());
		businessUserComment.deleteUserComment(uc);
		userComments = businessUserComment.getAllUserComments();
		for(IUserComment userComment : userComments){
			out.println(userComment.getCommentarie() + "<br>");
		}
		
	}

}
