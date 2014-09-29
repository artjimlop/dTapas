package servlet;

import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import utils.Tools;
import business.BusinessEstablishment;
import business.BusinessFollower;
import business.BusinessTapaRoute;
import business.BusinessUser;
import business.IBusinessEstablishment;
import business.IBusinessFollower;
import business.IBusinessTapaRoute;
import business.IBusinessUser;
import domain.IEstablishment;
import domain.ITapaRoute;
import domain.IUser;
import domain.TapaRoute;

/**
 * Servlet implementation class ManagerTapaRouteCheck
 */
@WebServlet("/ManagerTapaRouteCheck")
public class ManagerTapaRouteCheck extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ManagerTapaRouteCheck() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Business necesarios:
		IBusinessTapaRoute businessTapaRoute = new BusinessTapaRoute();
		IBusinessUser businessUser = new BusinessUser();
		IBusinessEstablishment businessEstablishment = new BusinessEstablishment();
		IBusinessFollower businessFollowers = new BusinessFollower();
		
		String destiny = null;
		HttpSession session = request.getSession();
		
		//Todos los datos del usuario:
		String login = (String) session.getAttribute("session.user");
		IUser user = businessUser.getUserByLogin(login);
		
		//Se recogen los parametros propios de la ruta tapa:
		String tapaRouteName = (String) request.getParameter("input_nameroute");
		String tapaPresentationRouteDate = (String) request.getParameter("input_targetdate");
		
		//Con este for se buscan que parametros "input_follower+numero" han
		//sido introducidos por el usuario.
		//El parametro contiene como value el Login del follower
		int f = 0;
		IUser added;
		List<IUser> addeds = new ArrayList<IUser>();
		Integer followersLimit = businessFollowers.getMyFollowers(user.getLogin()).size();
		
		for(f=0;f<followersLimit;f++){
			if(request.getParameter("input_follower"+f)!=null){	
				added = businessUser.getUserByLogin(request.getParameter("input_follower"+f));
				addeds.add(added);
			}
		}
		//Con este for se buscan que parametros "input_establishment+numero" han
		//sido introducidos por el usuario.
		//El parametro contiene como value el establishmentID
		int e = 0;
		List<IEstablishment> establishments = new ArrayList<IEstablishment>();
		//List<String> names = new ArrayList<String>();
		Integer id;
		Integer establishmentsLimit = businessEstablishment.getAllEstablishments().size();
		
		for(e=0;e<establishmentsLimit;e++){
			if(request.getParameter("input_establishment"+e)!=null){
				
			id = Integer.parseInt(request.getParameter("input_establishment"+e));
			establishments.add(businessEstablishment.getEstablishmentByID(id));
			//names.add(businessEstablishment.getEstablishmentByID(id).getNameEstablishment());
			}
				
		}
		
		//La fecha en String de presentacion se pasa a fecha de SQLDate:
		Date tapaRouteDate = Date.valueOf(Tools.stringToDateString(tapaPresentationRouteDate));
		
		//crear la ruta:
		ITapaRoute tapaRoute = new TapaRoute(tapaRouteName,tapaRouteDate,user.getLogin());
		
		
		
		Date today = new java.sql.Date(Calendar.getInstance().getTimeInMillis());
		
		
		if(tapaRouteName != null && tapaRouteDate != null){
			//Rutas con ese nombre:
			List<ITapaRoute> possibleSimilarRoutes = businessTapaRoute.getTapaRouteByName(tapaRouteName);
			
			ITapaRoute possibleSimilarRoute = null;
			//For para comprobar que el usuario ha creado una ruta con ese nombre antes
			for(ITapaRoute route : possibleSimilarRoutes){
				if(route.getUserLogin().equals(user.getLogin())){
					possibleSimilarRoute = route;
				}
			}

			//Si la ha creado y la fecha de ruta no ha pasado, error:
			if(possibleSimilarRoute!=null && 
					(possibleSimilarRoute.getTargetDate().equals(today) || 
					possibleSimilarRoute.getTargetDate().after(today))){
				String error = "Ya existe una ruta con el nombre " + tapaRouteName;
				session.setAttribute("routeerror", error);
				destiny ="newtaparoute.jsp";
			}else{
				session.setAttribute("tapaRoute", tapaRoute);
				session.setAttribute("addeds", addeds);
				session.setAttribute("establishments", establishments);
				session.setAttribute("session.user", user.getLogin());
				destiny = "taparouteinserter.jsp";
			}
		}else{
			session.setAttribute("routeerror", "Rellene <b>todos</b> los campos.");
			destiny = "newtaparoute.jsp";
		} 
		response.sendRedirect(destiny);
	}

}
