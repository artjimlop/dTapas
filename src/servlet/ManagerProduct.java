package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import business.BusinessProduct;
import business.IBusinessProduct;
import domain.IProduct;

/**
 * Servlet implementation class ManagerProduct
 */

/**
 * 
 * @author David Alanis
 *
 */

@WebServlet("/ManagerProduct")
public class ManagerProduct extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ManagerProduct() {
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
			showProduct(request,response);
	}
	
	
	private void showProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		PrintWriter out = response.getWriter();
		IBusinessProduct businessProduct = new BusinessProduct();
		businessProduct.deleteProduct(1);
		
		List<IProduct> products = businessProduct.getAllProduct();
		out.println("Todos los productos: " + "<br>");
		
		for(IProduct product : products){
			out.println("Nombre del producto: " + product.getProductName() + 
					"Día de registro: " + product.getRegistryDate()  +
					"Precio del producto: " + product.getPrice() + "<br>");
		}
	}
	
	

}
