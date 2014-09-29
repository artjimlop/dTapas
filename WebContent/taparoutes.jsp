<%@ include file="imports.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
	<title>DTapas - La web de los tapeadores</title>
	<%@ include file="imports_head.html"%>
</head>
<body>

	<div id="div_contain">

		<%@ include file="header.html" %>
		
		<%@ include file="top_menu.html" %>
		
		<div id="div_body">
		
			<%
				String login = (String) session.getAttribute("session.user");
				IUser user = new BusinessUser().getUserByLogin(login);
			%>
		
				<h3 class="blue_underline"> RUTA-TAPAS CREADAS:</h3>
				<%
				 	BusinessTapaRoute businessTapaRoute = new BusinessTapaRoute();
					BusinessUserTapaRoute businessUserTapaRoute = new BusinessUserTapaRoute();
					BusinessEstablishmentTapaRoute businessEstablishmentTapaRoute = new BusinessEstablishmentTapaRoute();
					
					List<IUser> users = new ArrayList<IUser>();
					List<IEstablishment> establishments = new ArrayList<IEstablishment>();
					
					if(businessTapaRoute.getTapaRouteByCreatorUser(login).size() > 0){
					
						for(ITapaRoute tapaRoute: businessTapaRoute.getTapaRouteByCreatorUser(login)){
							
							users = businessUserTapaRoute.getAllUserByRoute(tapaRoute);
							
							establishments = businessEstablishmentTapaRoute.getEstablishmentByRoute(tapaRoute.getTapaRouteID());
							%>
							<span class="blue_underline"><b> <%= tapaRoute.getName() %> </b> </span>
							
							<% 
							//out.println(tapaRoute.getName() + "<br>");
							
							//ACABAR LA PAGINA DE MODIFICACION!!
							
							out.println("<br><b>Usuarios</b>: ");
							for(IUser us:users){
								out.println(us.getName() + ", ");
							}
							out.println("<br>");
							
							out.println("<b>Establecimientos</b>: ");
							for(IEstablishment e:establishments){
								out.println(e.getNameEstablishment()+", ");
							}
							out.println("<br>");
							out.println("<b>Fecha</b>: "+tapaRoute.getTargetDate().toString() + "<br>");
						
				%>
				
				<button onClick="location.href = 'updatetaparoute.jsp?idTapaRoute=<%= tapaRoute.getTapaRouteID() %>'" >Modificar</button>
				<button onClick="location.href = 'deletetaparoute.jsp?idTapaRoute=<%= tapaRoute.getTapaRouteID() %>'" >Eliminar</button>
				
				<%		
				
							out.println("<br><hr>");
						
						}
					}else{
							out.println("Aún no has creado ninguna ruta tapas. ¡Anímate y organiza tu primera ruta tapas con quien tu quieras! <a href='newtaparoute.jsp'>Crear ruta tapas</a>");
					}
					
					
				%>
			
			<h3 class="blue_underline"> RUTA-TAPAS EN LAS QUE PARTICIPAS:</h3>
			<%
				List<IUser> usersPart = new ArrayList<IUser>();
				List<IEstablishment> establishmentsPart = new ArrayList<IEstablishment>();
				
				if(businessUserTapaRoute.getAllTapaRoutesByUser(user).size() > 0){
				
					for(ITapaRoute tapaRoute: businessUserTapaRoute.getAllTapaRoutesByUser(user)){
						
						
						
						//meterlas en una list, ordenarlas por routedate y luego mostrarlas
						
						
						
						usersPart = businessUserTapaRoute.getAllUserByRoute(tapaRoute);
						
						establishmentsPart = businessEstablishmentTapaRoute.getEstablishmentByRoute(tapaRoute.getTapaRouteID());
						%>
						<span class="blue_underline"><b> <%= tapaRoute.getName() %> </b> <br> </span>
						<% 
						//out.println(tapaRoute.getName() + "<br>");
						out.println("<b>Usuarios</b>: ");
						for(IUser u:usersPart){
							out.println(u.getName()+", ");
						}
						out.println("<br>");
						
						out.println("<b>Establecimientos</b>: ");
						for(IEstablishment est:establishmentsPart){
							out.println(est.getNameEstablishment()+", ");
						}
						out.println("<br>");
						out.println("<b>Fecha</b>: "+tapaRoute.getTargetDate().toString());
						out.println("<br><hr>");
					}
				}else{
					out.println("Vaya, ctualmente no tienes ninguna ruta tapas organizada.");
				}
			%>
			
		</div>
		<%@ include file="foot.jsp" %>
	</div>

</body>
</html>