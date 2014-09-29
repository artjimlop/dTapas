package servlet;


import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import business.BusinessWine;
import business.IBusinessWine;
import domain.IWine;
/**
 * Servlet implementation class Wine
 */
@WebServlet("/ManagerWines")

public class ManagerWines extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ManagerWines() {
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
		showWines(request,response);
	}

	private void showWines(HttpServletRequest request, HttpServletResponse response) throws IOException {
		PrintWriter out = response.getWriter();
		
		IBusinessWine businessWine = new BusinessWine();
		
//		Wine wine2 = businessWine.getWineByID(1);
//		Wine up = new Wine(wine2.getProductName(), 5.00, wine2.getRegistryDate(), wine2.getUserLoginID(), wine2.getEstablishmentID(),
//				wine2.getProductID(), "tiporaro", "odcambiada", 2012 , "reserva" , "nueva marca way", wine2.getWineID());
//		
//		businessWine.deleteWine(2);
//		businessWine.insertWine("El Vino Nuevo", 50.00, "link", 1, "tipo nuevo", "odneeva", 2000, "reserva", "marca nueva");
//		businessWine.updateWine(up);
		
//		String userCreatorOID, String establishmentOID, String productOID,
//		String type, String od, Integer year, String growUpTime, String label,
//		String wineOID){
	
		
		List<IWine> wines = businessWine.getAllWines();
		
		
		
		
		out.println(" Lista de Vinos: <br><br><br>");
		
		for(IWine wine: wines) {
			out.println("Nombre del wine: " + wine.getProductName() + 
					"Día de registro: " + wine.getRegistryDate()+
					"Precio del wine: " + wine.getPrice() + " Tipo: " 
					+ wine.getType() + " Denomnacion Origen: " + wine.getOd() + " Año: " + wine.getYear()
					+ " Añada: " + wine.getGrowUpTime() + " Marca: " + wine.getLabel() + "<br><br>");		
		}
		
//		wines = businessWine.getWinesBygrowuptime("reserva");
//		out.println("Lista de Vinos buscado por añada joven: <br><br><br>");
//		
//		for(Wine wine: wines) {
//			out.println("Nombre del wine: " + wine.getProductName() +  "<br><br>");		
//		}
//		
//		wines = businessWine.getWinesByType("tipo nuevo");
//		out.println("Lista de Vinos buscado por TIPO: <br><br><br>");
//		
//		for(Wine wine: wines) {
//			out.println("Nombre del wine: " + wine.getProductName() +  "<br><br>");		
//		}
//		
//		wines = businessWine.getWinesByOd("odneeva");
//		out.println("Lista de Vinos buscado por OD: <br><br><br>");
//		
//		for(Wine wine: wines) {
//			out.println("Nombre del wine: " + wine.getProductName() +  "<br><br>");		
//		}
//		
//		wines = businessWine.getWinesBylabel("marca nueva");
//		out.println("Lista de Vinos buscado por MARCA: <br><br><br>");
//		
//		for(Wine wine: wines) {
//			out.println("Nombre del wine: " + wine.getProductName() +  "<br><br>");		
//		}
//		

		
	}
}
