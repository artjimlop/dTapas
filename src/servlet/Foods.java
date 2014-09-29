package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import business.BusinessFood;
import business.IBusinessFood;
import domain.IFood;

/**
 * Servlet implementation class Food
 */
@WebServlet("/Foods")
public class Foods extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Foods() {
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
		showFoods(request,response);
	}

	private void showFoods(HttpServletRequest request, HttpServletResponse response) throws IOException {
		PrintWriter out = response.getWriter();
		
		IBusinessFood businessFood = new BusinessFood();
		
//		Food food2 = businessFood.getFoodByID(1);
//		Food up = new Food(food2.getProductName(), 5.00, food2.getRegistryDate(), food2.getUserLoginID(), food2.getEstablishmentID(),
//				food2.getProductID(), "tipo actualizado", food2.getFoodID());
//		
//		businessFood.deleteFood(2);
//		businessFood.insertFood("Comida 2", 33.00, "link", 1, "tipo 2");
//		businessFood.updateFood(up);
		
//		String productName, Double price,
//		String userCreatorOID, String establishmentOID, String productOID,
//		String type, String foodOID
		
		List<IFood> foods = businessFood.getAllFoods();
		
		
		out.println(" Lista de Comidas: <br><br><br>");
		
		for(IFood food: foods) {
			out.println("Nombre del food: " + food.getProductName() + 
					" Día de registro: " + food.getRegistryDate()+
					" Precio del food: " + food.getPrice() + " Tipo de comida : " + food.getType() + "<br><br>");		
		}
		

		
//		foods = businessFood.getFoodsByType("tipo actualizado");
//		out.println("Lista de Comidas buscado por TIPO: <br><br><br>");
//		
//		for(Food food: foods) {
//			out.println("Nombre del food: " + food.getProductName() +  "<br><br>");		
//		}
//		


		
	}
}
