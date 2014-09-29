<%@page import="utils.Tools"%>
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
				BusinessTapaRoute businessTapaRoute = new BusinessTapaRoute();
				List<ITapaRoute> tapaRoutes = new ArrayList<ITapaRoute>();
				Integer id;
				
				tapaRoutes = businessTapaRoute.getAllRoutes();
				Iterator<ITapaRoute> itorTapaRoutes = tapaRoutes.iterator();
				ITapaRoute route;
				
				String routeID = request.getParameter("idTapaRoute");
				route = businessTapaRoute.getTapaRouteByID(Integer.parseInt(routeID));
				//out.println(route.getName());
				//out.println(route.getTapaRouteID());
				//A partir del id, obtengo todos los datos de la ruta.
				

			%>
		
			<div id="div_info_main_user">
				<div>
					<div id="div_image_main_user"><img src="images/user_icon.jpg"></div>
					<div id="div_name_main_user"><%= user.getName() + " " + user.getSurname() %></div>
					<div id="div_login_main_user"><%= user.getLogin() %></div>
				</div>
				<div id="div_more_info_main_user">
				<hr>
					<span><b>Fecha de registro: </b><%= Tools.dateStringToString(user.getRegistryDate().toString()) %></span><br>
					<span><b>E-mail: </b><%= user.getEmail() %></span><br>
					<span><b>Seguidores: </b><%= new BusinessFollower().getMyFollowers(user.getLogin()).size() %></span><br>
					<span><b>Sigues: </b><%= new BusinessFollower().getMyFollowed(user.getLogin()).size() %></span><br>
					<span><b>Rutas creadas: </b><%= new BusinessTapaRoute().getTapaRouteByCreatorUser(user.getLogin()).size() %></span><br>
					<span><b>Rutas organizadas: </b><%= new BusinessUserTapaRoute().getAllTapaRoutesByUser(user).size() %></span><br>
					<span><b>Comentarios: </b><%= new BusinessComment().getCommentByUserID(user.getLogin()).size() %></span><br>
					<a href="newtaparoute.jsp">Crea una ruta tapa</a>
					<a href="taparoutes.jsp">Ver ruta tapas</a>
				</div>
			</div>
		
			<div id="div_user_space">
			
				<form onsubmit="return validate_update_form()" action="tapaRouteModificator.jsp" method="post">
				
				<input id ="input_routeid" name="input_routeid" type="hidden" value= <%= route.getTapaRouteID() %>>
				
				<label> <b> MODIFICAR RUTA TAPA </b> <br> </label>
				<label>-------------------------------- <br> </label>
				
				<% 
				//UPDATE taparoutes SET nameRoute=?, routeDate=? WHERE ROUTEOID = ?
				//Meter nuevos usuarios y nuevos bares.
				 	out.println("Nombre: "+route.getName()+"<br>");
				
				%>
				
				Cambiar nombre:
				<input id="input_nameroute" name="input_nameroute" value=<%= route.getName() %> type="text">
				<br>
				<%
					out.println("Fecha: "+route.getTargetDate()+"<br>");
					String presentationDate = Tools.dateStringToString(route.getTargetDate().toString());
				%>
				
				Cambiar fecha:
				<input id="input_routedate" name="input_routedate" value= <%= presentationDate %> type="text" readonly>
							<img src='images/jacs.gif' title='Click aqui' alt='Click aqui'
                            	onclick="JACS.show(document.getElementById('input_routedate'),event,7);" />
				<br>
				<%
					BusinessUserTapaRoute bU = new BusinessUserTapaRoute();
					List<IUser> users = bU.getAllUserByRoute(route);
					String name;
					out.println("Tapeadores: ");
					for(IUser u:users){
						name = u.getName();
						out.println(name+" - ");
					}
					out.println("<br>");
					//Usuarios no invitados pero que te siguen:
					BusinessFollower bF = new BusinessFollower();
					List<IUser> followers = new ArrayList<IUser>();
					followers.addAll(bF.getMyFollowers(login));
					followers.removeAll(users);
					//muestro lista de no invitados en checkboxes:
					out.println("Invitar: <br>");
					IUser no;
					int f;
					for(f = 0; f<followers.size();f++){
						if(followers.get(f)==null){
							break;
						}
						no = followers.get(f);
					%>
					<input id="<%= "input_follower"+f %>" type="checkbox" name= "<%="input_follower"+f%>" value="<%= no.getLogin() %>"> <%= no.getName() %> <br>
				<%} %>
				<br>
				
				<%
					BusinessEstablishmentTapaRoute bE = new BusinessEstablishmentTapaRoute();
					List<IEstablishment> establishments = bE.getEstablishmentByRoute(route.getTapaRouteID());
					String est;
					out.println("Establecimientos: ");
					for(IEstablishment e:establishments){
						est=e.getNameEstablishment();
						out.println(est+" - ");
					}
					
					out.println("<br>");
					
					//elimino establecimientos añadidos:
					BusinessEstablishment bEst = new BusinessEstablishment();
					List<IEstablishment> notAddeds = new ArrayList<IEstablishment>();
					notAddeds.addAll(bEst.getAllEstablishments());
					notAddeds.removeAll(establishments);
					//for(IEstablishment noEst:notAddeds){
						//if(establishments.contains(noEst)){
							//notAddeds.remove(noEst);
						//}
					//}
					int e;
					IEstablishment nest;
					for (e=0; e < notAddeds.size(); e++) {
						nest = notAddeds.get(e);
						String establishmentName = nest.getNameEstablishment();
						Integer establishmentID = nest.getEstablishmentID();
				%>
				<input id="<%= "input_establishment"+e %>" type="checkbox" name= "<%="input_establishment"+e%>" value="<%= establishmentID %>"> <%= establishmentName %> <br>
					<% 	}; 
				%>
			
				<div id="boton" align="center">
					<button type="submit">MODIFICAR</button>
				</div>
				
				</form>
			</div>
			
			<div id="div_followers_followeds">
			
				<div id="div_followers">
					<div>
						<span id="title_followers">Seguidores:</span>
						<hr>
					</div>
					<%
						Iterator<IUser> userIt = new BusinessFollower().getMyFollowers(user.getLogin()).iterator();
						IUser u;
						for(Integer i=0;i<12 && userIt.hasNext();i++){
							u = userIt.next();
					%>
						<div id="div_user_f">
							<div id="div_image_user"><img src="images/user_icon.jpg"></div>
							<div id="div_name_user"><%= u.getName() + " " + u.getSurname() %></div>
						</div>
					
					<% }; %>
					<div>
						<hr>
						<a href="#">Ver todos</a> (<%= new BusinessFollower().getMyFollowers(user.getLogin()).size() %>)
					</div>
				</div>
				
				<div id="div_followeds">
					<div>
						<span id="title_followeds">Sigues:</span>
						<hr>
					</div>
					<%
						userIt = new BusinessFollower().getMyFollowed(user.getLogin()).iterator();
						for(Integer i=0;i<12 && userIt.hasNext();i++){
							u = userIt.next();
					%>
					<div id="div_user_f">
						<div id="div_image_user"><img src="images/user_icon.jpg"></div>
						<div id="div_name_user"><%= u.getName() + " " + u.getSurname() %></div>
					</div>
					
					<% }; %>
					<div>
						<hr>
						<a href="#">Ver todos</a> (<%= new BusinessFollower().getMyFollowed(user.getLogin()).size() %>)
					</div>
				</div>
			
			</div>
			
		</div>
		<%@ include file="foot.jsp" %>
	</div>

</body>
</html>