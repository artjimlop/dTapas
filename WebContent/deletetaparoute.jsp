<%@page import="utils.Tools"%>
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
				
				<%
					BusinessTapaRoute btr = new BusinessTapaRoute();
					BusinessUserTapaRoute butr = new BusinessUserTapaRoute();
					BusinessEstablishmentTapaRoute betr = new BusinessEstablishmentTapaRoute();
					
					ITapaRoute tapaRoute = btr.getTapaRouteByID(Integer.parseInt(request.getParameter("idTapaRoute")));
					if(tapaRoute != null){
						//elimina la ruta:
						btr.delete(tapaRoute.getTapaRouteID());
						//elimina los usuarios de esa ruta:
						for(IUser user:butr.getAllUserByRoute(tapaRoute)){
							butr.deleteUsersTapaRoute(user, tapaRoute);
						}
						//elimina los establecimientos de esa ruta:
						for(IEstablishment establishment:betr.getAllEstablishments()){
							betr.delete(establishment, tapaRoute);
						}
							
						out.println("Se ha eliminado con éxito la ruta tapas <b>" + tapaRoute.getName() + "</b>");
					}else{
						out.println("La tapa rutas indicado no existe.");
					}
				%>
			</div>
			
			<%@ include file="foot.jsp" %>
		</div>

	</body>
</html>