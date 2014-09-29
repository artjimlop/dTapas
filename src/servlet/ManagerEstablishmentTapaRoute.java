package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import business.BusinessEstablishmentTapaRoute;
import business.IBusinessEstablishmentTapaRoute;
import domain.IEstablishment;

/**
 * Servlet implementation class ManagerEstablishmentTapaRoute
 */
@WebServlet("/ManagerEstablishmentTapaRoute")
public class ManagerEstablishmentTapaRoute extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ManagerEstablishmentTapaRoute() {
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
		showEstablishmentsTapaRoutes(request,response);
	}

	private void showEstablishmentsTapaRoutes(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		PrintWriter out = response.getWriter();
		IBusinessEstablishmentTapaRoute businessObject = new BusinessEstablishmentTapaRoute();
		
//	FUNCIONA	businessObject.insertEstablishmentTapaRoute("1", "2");
//	FUNCIONA	businessObject.delete("133657291573150ffab6d");
		
		List<IEstablishment> list = businessObject.getAllEstablishments();
		
//	FUNCIONA	List<Establishment> list = businessObject.getEstablishmentByRoute("1");
//	FUNCIONA		List<Establishment> list = businessObject.getTapaRouteByEstablishment("2");
		out.println("Lista de Establecimientos Ruta-Tapa: ");
		
		for(IEstablishment e: list) {
			out.println(e.getNameEstablishment() + ": " + e.getCity() + " " + e.getZone());
		}
	}
}
