package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import business.BusinessTapaRouteComment;
import business.IBusinessTapaRouteComment;
import domain.ITapaRouteComment;

/**
 * Servlet implementation class ManagerTapaRouteComment
 */
@WebServlet("/ManagerTapaRouteComment")
public class ManagerTapaRouteComment extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ManagerTapaRouteComment() {
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
		showTapaRouteComments(request,response);
	}

	private void showTapaRouteComments(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		IBusinessTapaRouteComment businessObject = new BusinessTapaRouteComment();
		
		/*
		 * String comment, String USOID, String COMMENTOID, 
			String ROUTEOID
		 */
//		TapaRouteComment commentarie = new TapaRouteComment("String","1","1","1");
//	FUNCIONA	businessObject.insertComment(commentarie);
//	FUNCIONA 	businessObject.delete("3");
		List<ITapaRouteComment> list = businessObject.getAllCommentaries();
//		List<TapaRouteComment> list = businessObject.getCommentariesByRoute("1");
//		TapaRouteComment list = businessObject.getTapaRouteCommentByOID("1");
		out.println("Lista de Comentarios-RutaTapas: ");
//		out.println(list.getCommentarieOID());
		for(ITapaRouteComment comment: list) {
			out.println(comment.getCommentarie() + ": " + comment.getUserCommentarieID() + " " + comment.getCommentarieDate());
		}
	}
}
