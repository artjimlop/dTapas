package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import business.BusinessBeer;
import business.IBusinessBeer;
import domain.IBeer;

/**
 * Servlet implementation class Beers
 */
@WebServlet("/Beers")
public class Beers extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Beers() {
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
		showBeers(request,response);
	}
	private void showBeers(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		PrintWriter out = response.getWriter();
		IBusinessBeer businessBeer = new BusinessBeer();
		List<IBeer> beers = businessBeer.getAllBeers();
		
//		Beer beer2 = businessBeer.getBeerByID(1);
//		Beer up = new Beer(beer2.getProductName(), 5.00, beer2.getRegistryDate(), beer2.getUserLoginID(), beer2.getEstablishmentID(),
//				beer2.getProductID(), "Jarra", "Nueva", "Rubia" , beer2.getTemperature(), beer2.getBeerID());
//		
//		businessBeer.updateBeer(up);
//		businessBeer.insertBeer("Cruzcampo", 20.0, "link", 1, "Caña", "Cruzcampo", "Negra", "Normal");
		businessBeer.deleteBeer(2);
		
		out.println("Todos las Cervezas: ");
		
		for(IBeer beer : beers){
			out.println("Nombre de la cerveza: " + beer.getProductName() + 
					" Día de registro: " + beer.getRegistryDate() +
					" Precio de la cerveza : " + beer.getPrice() + " Tamaño: " 
					+ beer.getSize() + " Marca: " + beer.getLabel() + " Color: " + beer.getColor()
					+ " Temperatura: " + beer.getTemperature() + "<br> <br> <br> <br> ");
		}
		
//		
//		beers = businessBeer.getBeersBylabel("Nueva");
//		out.println("Lista de Cervezas buscado por Marca: <br><br><br>");
//		
//		for(Beer beer: beers) {
//			out.println("Nombre del beer: " + beer.getProductName() +  "<br><br>");		
//		}
//		
//
//		beers = businessBeer.getBeersByColor("Negra");
//		out.println("Lista de Cervezas buscado por Color: <br><br><br>");
//		
//		for(Beer beer: beers) {
//			out.println("Nombre del beer: " + beer.getProductName() +  "<br><br>");		
//		}
//		
//
//		beers = businessBeer.getBeersBySize("Caña");
//		out.println("Lista de Cervezas buscado por tamaño: <br><br><br>");
//		
//		for(Beer beer: beers) {
//			out.println("Nombre del beer: " + beer.getProductName() +  "<br><br>");		
//		}
//		
//		beers = businessBeer.getBeersByTemperature("Normal");
//		out.println("Lista de Cervezas buscado por Temperatura: <br><br><br>");
//		
//		for(Beer beer: beers) {
//			out.println("Nombre del beer: " + beer.getProductName() +  "<br><br>");		
//		}
		
	}

}
