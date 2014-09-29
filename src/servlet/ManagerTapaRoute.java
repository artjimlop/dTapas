package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import business.BusinessTapaRoute;
import business.IBusinessTapaRoute;
import domain.ITapaRoute;

/**
 * Servlet implementation class ManagerTapaRoute
 */
@WebServlet("/ManagerTapaRoute")
public class ManagerTapaRoute extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ManagerTapaRoute() {
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
		showTapaRoutes(request,response);
	}

	private void showTapaRoutes(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		
		//Prueba insert: FUNCIONA
//		Date targetDate = new java.sql.Date(Calendar.getInstance().getTimeInMillis());
//		TapaRoute route = new TapaRoute("LLANES",targetDate,"1");
//		businessObject.insertTapaRoute(route);
		
//		List<TapaRoute> list = BusinessTapaRoute.getInstance().getAllRoutes();
		//List<TapaRoute> list = BusinessTapaRoute.getInstance().getTapaRouteByCreatorUser("1");
		IBusinessTapaRoute businessObject = new BusinessTapaRoute();
//	FUNCIONA	List<TapaRoute> list = businessObject.getTapaRouteByName("prueba");
		
//	FUNCIONA	List<TapaRoute> list = businessObject.getTapaRouteByCreationDate(targetDate);
//	FUNCIONA	List<TapaRoute> list = businessObject.getTapaRouteByCreatorUser("1");
//	FUNCIONA	List<TapaRoute> list = businessObject.getTapaRouteByName("inserta");
//	FUNCIONA	List<TapaRoute> list = businessObject.getTapaRouteByTargetDate(targetDate);
//	FUNCIONA	TapaRoute route = businessObject.getTapaRouteByOID("1");
//		out.println(route.getName());
		
		
//	FUNCIONA		businessObject.delete("1");
		
//	FUNCIONA 	PRUEBA DEL UPDATE:

//		Date targetDate = new java.sql.Date(Calendar.getInstance().getTimeInMillis());
//		TapaRoute route = new TapaRoute("cambio",targetDate,targetDate,"1","1");
//		businessObject.updateTapaRoute(route);
		

		List<ITapaRoute> list = businessObject.getAllRoutes();
		out.println("Lista de RutaTapas: ");
		
		for(ITapaRoute t: list){
			out.println(t.getName());
		}
		
			
		
	}
}
