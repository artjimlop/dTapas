package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import business.BusinessEstablishmentScore;
import business.IBusinessEstablishmentScore;
import domain.IEstablishmentScore;

/**
 * Servlet implementation class ManagerEstablishmentScore
 */
@WebServlet("/ManagerEstablishmentScore")
public class ManagerEstablishmentScore extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ManagerEstablishmentScore() {
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
		showEstablishmentScores(request,response);
	}

	private void showEstablishmentScores(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		PrintWriter out = response.getWriter();
		IBusinessEstablishmentScore businessObject = new BusinessEstablishmentScore();
//	FUNCIONA	List<EstablishmentScore> list = businessObject.getAllScores();
//	FUNCIONA	List<EstablishmentScore> list = businessObject.getScoresByCreationDate(scoreCreationDate);
//	FUNCIONA	List<EstablishmentScore> list = businessObject.getScoresByEstablishment(establishmentOID);
//	FUNCIONA	List<EstablishmentScore> list = businessObject.getScoresByUser(userOID);
//	FUNCIONA	EstablishmentScore scoreOnly = businessObject.getEstablishmentScoreByOID(establishmentScoreOID);
//		Date date = new java.sql.Date(Calendar.getInstance().getTimeInMillis());
//		EstablishmentScore newScore = new EstablishmentScore(9.0, 9.0, 5.0, 9.0, 5.0, 5.0,
//				date,"1","1");
//		
//	FUNCIONA	businessObject.insertEstablishmentScore(newScore);
		
//	FUNCIONA	EstablishmentScore newScore = new EstablishmentScore(9.0, 9.0, 9.0, 9.0, 8.0, 8.0,
//				"1","1","1");
//		businessObject.updateEstablishmentScore(newScore);
		
		List<IEstablishmentScore> list = businessObject.getAllScores();
		out.println("Lista de puntuaciones de establecimientos: ");
		
		
		
		for(IEstablishmentScore score: list) {
			out.println(score.getMediumScore() + ": " + score.getEstablishmentID() + " " + score.getEstablishmentScoreID());
		}
	}
}
