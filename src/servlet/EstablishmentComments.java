package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import business.BusinessEstablishmentComment;
import business.IBusinessEstablishmentComment;
import domain.IEstablishmentComment;

/**
 * Servlet implementation class EstablishmentComments
 */
@WebServlet("/EstablishmentComments")
public class EstablishmentComments extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EstablishmentComments() {
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
		showEstablishmentComments(request,response);
	}

	private void showEstablishmentComments(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		PrintWriter out = response.getWriter();
		
		IBusinessEstablishmentComment businessEstablishmentComment = new BusinessEstablishmentComment();
		
//		EstablishmentComment establishmentComment2 = businessEstablishmentComment.getEstablishmentCommentByCOMNTESTOID("uno");
//		EstablishmentComment up = new EstablishmentComment(establishmentComment2.getCommentarie(), establishmentComment2.getCommentarieOID(),
//				establishmentComment2.getUserCommentarieOID(), establishmentComment2.getEstablishmentOID(), "uno");
//		
		
		businessEstablishmentComment.deleteEstablishmentComment(2);
//		businessEstablishmentComment.insertEstablishmentComment("Este es un comentario insertado por link de 2 vez", "link", 1);
//		businessEstablishmentComment.updateEstablishmentComments(up);
		
//	String comment, String COMOID, String USOID,
//		String ESTOID, String COMNTESTOID
	
		
		List<IEstablishmentComment> establishmentComments = businessEstablishmentComment.getAllEstablishmentComment();
		
		
		
		
		out.println(" Lista de Comentarios: <br><br><br>");
		
		for(IEstablishmentComment establishmentComment: establishmentComments) {
			out.println("Usuario : " + establishmentComment.getUserCommentarieID() + 
					" Día de comentario: " + establishmentComment.getCommentarieDate() +
					" Establecimiento comentado: " + establishmentComment.getEstablishmentID() + " Comentario: " 
					+ establishmentComment.getCommentarie() +  "<br><br>");		
		}
		
		establishmentComments = businessEstablishmentComment.getEstablishmentCommentByESTID(1);
		out.println("Lista de Comentario buscado por establecimiento: <br><br><br>");
		
		for(IEstablishmentComment establishmentComment: establishmentComments) {
			out.println("Nombre del establishmentComment: " + establishmentComment.getCommentarie() +  "<br><br>");		
		}
		
		IEstablishmentComment establishmentComments2 = businessEstablishmentComment.getEstablishmentCommentByCOMID(1);
		out.println("Lista de Comentarios buskador por COMOID: <br><br><br>");
		out.println("Nombre del establishmentComment: " + establishmentComments2.getCommentarie() +  "<br><br>");		
		
		
		
		

		
	}
}

