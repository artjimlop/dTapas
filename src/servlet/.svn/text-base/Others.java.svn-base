package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import business.BusinessOther;
import business.IBusinessOther;
import domain.IOther;

/**
 * Servlet implementation class Others
 */
@WebServlet("/Others")
public class Others extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Others() {
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
		showOthers(request,response);
	}
	private void showOthers(HttpServletRequest request, HttpServletResponse response) throws IOException {
		PrintWriter out = response.getWriter();
		
		IBusinessOther businessOther = new BusinessOther();
//		
//		Other other2 = businessOther.getOthersByID(1);
//		Other up = new Other(other2.getProductName(), 25.00, other2.getRegistryDate(), other2.getUserLoginID(), other2.getEstablishmentID(),
//				other2.getProductID(), "tamaño actualizado", "tipo actualizado", 1);
//		
//		businessOther.deleteOthers(1);
//		businessOther.insertOthers("El otro nuevo", 5.00, "link", 1, "tamaño nuevo 2", "tipo nuevo 2");
//		businessOther.updateOthers(up);
		
//	String productName, Double price,
//		String userCreatorOID, String establishmentOID, String productOID,
//		String size, String type, String otherOID
	
		
		List<IOther> others = businessOther.getAllOthers();
		
		
		
		
		out.println(" Lista de Otross: <br><br><br>");
		
		for(IOther other: others) {
			out.println("Nombre del other: " + other.getProductName() + 
					" Día de registro: " + other.getRegistryDate()+
					" Precio del other: " + other.getPrice() + " Tipo: " 
					+ other.getType() + " Tamaño: " + other.getSize() + "<br><br>");		
		}
//		
//		others = businessOther.getOthersBySize("tamaño actualizado");
//		out.println("Lista de otros buscado por tamaño: <br><br><br>");
//		
//		for(Other other: others) {
//			out.println("Nombre del other: " + other.getProductName() +  "<br><br>");		
//		}
//		
//		others = businessOther.getOthersByType("tipo actualizado");
//		out.println("Lista de otros buscado por TIPO: <br><br><br>");
//		
//		for(Other other: others) {
//			out.println("Nombre del other: " + other.getProductName() +  "<br><br>");		
//		}
//		
		
		

		
	}
}

