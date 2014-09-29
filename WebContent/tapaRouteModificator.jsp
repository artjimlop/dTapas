<%@page import="java.sql.Date"%>
<%@ include file="imports.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>DTapas - ¡Tapa Ruta creada!</title>
		<%@ include file="imports_head.html"%>
	</head>
	<body>
	
		<div id="div_contain">
	
			<%@ include file="header.html" %>
			
			<%@ include file="top_menu.html" %>
	
			<div id="div_body">
				¡Tapa-Ruta Modificada! =)
				
				<%
				String login = (String) session.getAttribute("session.user");
				IUser user = new BusinessUser().getUserByLogin(login);
				
				String date = (String) request.getParameter("input_routedate");
				out.println("fecha:"+date);
				String nameRoute = (String) request.getParameter("input_nameroute");
				out.println("nombre: "+nameRoute);
				
				
				BusinessUser businessUser = new BusinessUser();
				BusinessUserComment businessUserComment = new BusinessUserComment();
				BusinessEstablishment businessEstablishment = new BusinessEstablishment();
				BusinessTapaRoute businessTapaRoute = new BusinessTapaRoute();
				BusinessUserTapaRoute businessUserTapaRoute = new BusinessUserTapaRoute();
				BusinessEstablishmentTapaRoute businessEstablishmentTapaRoute = new BusinessEstablishmentTapaRoute(); 
				BusinessTapaRouteComment businessTapaRouteComment = new BusinessTapaRouteComment();
				BusinessFollower bFoll = new BusinessFollower();
				
				int f = 0;
				IUser added;
				List<IUser> addeds = new ArrayList<IUser>();
				Integer followersLimit = bFoll.getMyFollowers(login).size();
				for(f=0;f<20;f++){
					if(request.getParameter("input_follower"+f)!=null){
						added = businessUser.getUserByLogin(request.getParameter("input_follower"+f));
						addeds.add(added);
						
						out.println(added.getName());
					}
				}
				
				int i = 0;
				List<IEstablishment> establishments = new ArrayList<IEstablishment>();
				List<String> names = new ArrayList<String>();
				Integer id;
				Integer establishmentsLimit = businessEstablishment.getAllEstablishments().size();
				for(i=0;i<establishmentsLimit;i++){
					if(request.getParameter("input_establishment"+i)!=null){
						id = Integer.parseInt(request.getParameter("input_establishment"+i));
						establishments.add(businessEstablishment.getEstablishmentByID(id));
						names.add(businessEstablishment.getEstablishmentByID(id).getNameEstablishment());
						
						out.println(request.getParameter("input_establishment"+i));	
					}	
				}
				out.println(names);
				
				//primero convertir dateString de sting a date:
				String regularDate = Tools.stringToDateString(date);
				Date targetDate = Date.valueOf(regularDate);
				//crear la ruta:
				//TapaRoute tapaRoute = new TapaRoute(nameRoute,targetDate,login);
				String modId = request.getParameter("input_routeid");
				//out.println("ID: "+modId);
				Integer routeId = Integer.parseInt(request.getParameter("input_routeid"));
				ITapaRoute tapaRoute = businessTapaRoute.getTapaRouteByID(routeId);
				tapaRoute.setName(nameRoute);
				tapaRoute.setTargetDate(targetDate);
				businessTapaRoute.updateTapaRoute(tapaRoute);
				//En este caso no te añades a la propia ruta porque ya estas.
				
				String standardComment;
				
				for(IUser add:addeds){
					businessUserTapaRoute.insertUsersTapaRoute(add, tapaRoute);
					if(add.getLogin().equals(user.getLogin())){
						standardComment = "¡Acabas de modificar la Ruta "+tapaRoute.getName()+"! Para el dia: "+tapaRoute.getTargetDate();
					}else{
						standardComment = "¡He modificado mi Ruta "+tapaRoute.getName() +", "+add.getLogin()+"!";
					}
					IUserComment comment = new UserComment(add.getLogin(),user.getLogin(),standardComment);
					businessUserComment.insertUserComment(comment);
				}
				
				for(IEstablishment est:establishments){
					businessEstablishmentTapaRoute.insertEstablishmentTapaRoute(est, tapaRoute);
				}
				
				String tapaRouteComment = "¡Acabo de modificar una ruta-tapa!";
				ITapaRouteComment trComment = new TapaRouteComment(tapaRouteComment, user.getLogin(), tapaRoute.getTapaRouteID());
				businessTapaRouteComment.insertComment(trComment);
				
				%>
				
	
			</div>
			
			<div id="boton" align="center">
				<a href="taparoutes.jsp">Ver RUTA-TAPAS</a>
			</div>
			
			<%@ include file="foot.jsp" %>
		</div>

	</body>
</html>