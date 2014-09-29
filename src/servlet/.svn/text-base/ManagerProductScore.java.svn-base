package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import business.BusinessProductScore;
import business.IBusinessProductScore;
import domain.IProductScore;

/**
 * Servlet implementation class ManagerProductScore
 */
@WebServlet("/ManagerProductScore")
public class ManagerProductScore extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ManagerProductScore() {
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
		showProductScores(request,response);
	}
	
	private void showProductScores(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		IBusinessProductScore businessObject = new BusinessProductScore();
		
		
//	FUNCIONA	List<ProductScore> list = businessObject.getScoresByProduct("1");
//		Date date = new java.sql.Date(Calendar.getInstance().getTimeInMillis());
//	FUNCIONA	List<ProductScore> list = businessObject.getScoresByCreationDate(date);
//	FUNCIONA	List<ProductScore> list = businessObject.getScoresByUser("2");
//	FUNCIONA	ProductScore score = businessObject.getProductScorebyOID("1");
		/*
		 * Double presentationScore,
			Double quantityScore, Double priceScore, String userOID,
			String productOID
		 */
		
//		ProductScore p = new ProductScore(9.0,6.0,7.0,"1","2");
//	FUNCIONA	businessObject.insertProductScore(p);
//	FUNCIONA	businessObject.updateProductScore(p);
//		businessObject.deleteProductScore("1336666823748ffffffff9a7899a9");
		//		List<ProductScore> list = businessObject
//		ProductScore p = new ProductScore(8.0,8.0,8.0,"user",1);
		List<IProductScore> list = businessObject.getAllScores();
		for(IProductScore score:list){
			out.println(" '" +score.getLogin()+"' " + " puntuó " + " '" + score.getProductID() + "' " + " con una media de "+" '" + score.getMediumScore());
		}
	}
}
