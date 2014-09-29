package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import business.BusinessEstablishment;
import business.BusinessProduct;
import business.BusinessProductComment;
import business.BusinessUser;
import business.IBusinessEstablishment;
import business.IBusinessProduct;
import business.IBusinessProductComment;
import business.IBusinessUser;
import domain.IEstablishment;
import domain.IProduct;
import domain.IProductComment;
import domain.IUser;

/**
 * Servlet implementation class ManagerProductComment
 */
@WebServlet("/ManagerProductComment")
public class ManagerProductComment extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ManagerProductComment() {
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
		showProductComment(request, response);
	}
	
	private void showProductComment(HttpServletRequest request, HttpServletResponse response) throws IOException{
		
		PrintWriter out = response.getWriter();
		IBusinessProductComment businessProductComment = new BusinessProductComment();
		
		IBusinessUser businessUser = new BusinessUser();
		IBusinessProduct businessProduct = new BusinessProduct();
		IBusinessEstablishment businessEstablishment = new BusinessEstablishment();	
		
		List<IProductComment> productsComment = businessProductComment.getAllProductComment();

		
		for(IProductComment productComment : productsComment){
			IUser user = businessUser.getUserByLogin(productComment.getUserCommentarieID());
			IProduct product = businessProduct.getProductByID(productComment.getProductID());
			IEstablishment establishment = businessEstablishment.getEstablishmentByID(product.getEstablishmentID());
			
			out.println(" '" +user.getName()+"' " + " dijo sobre " + " '" + product.getProductName() + "' " + " de "+" '" + establishment.getNameEstablishment() +"' "
					+ productComment.getCommentarie() + "<br>");
			
			
		}
		
	}

}
