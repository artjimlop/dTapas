<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ include file="imports.jsp"%> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>DTapas - Crear Ruta-Tapa</title>
<%@ include file="imports_head.html"%>
</head>
<body>

	<div id="div_contain">

		<%@ include file="header.html" %>
		
		<%@ include file="top_menu.html" %>

		<div id="div_body">
			
			<h3 id="title_space_user" class="blue_underline">Crear tapa rutas:</h3>
			
			<%
				String login = (String) session.getAttribute("session.user"); 
			%>
			<div id="div_user_space">
				
				<%
				//Si se tiene al menos un seguidor se puede hacer una ruta tapa;
				//en caso contrario, no.
				IBusinessUser businessUser = new BusinessUser();
				IUser user = businessUser.getUserByLogin(login);
				IBusinessFollower businessFollower = new BusinessFollower();
				List<IUser> followers = businessFollower.getMyFollowers(user.getLogin()); 
				if(followers.size()>0){
	
				%>
				<form onsubmit="return validar_formulario()" action="ManagerTapaRouteCheck" method="post">
					
					<div id="div_routename">
						<label> <b> Nombre Ruta-Tapa: </b> </label>
						<input id="input_nameroute" name="input_nameroute" type="text" >
					</div>
					
					<div id="div_targetdate">
						<label> <b> Fecha Ruta-Tapa: </b> </label>
						<input id="input_targetdate" name="input_targetdate" type="text" readonly>
						<img src='images/jacs.gif' title='Click aqui' alt='Click aqui'
                           	onclick="JACS.show(document.getElementById('input_targetdate'),event,7);" />
					</div>
					<label> <b> Establecimientos para la ruta: </b> <br> </label>
					<%  
						IBusinessEstablishment businessEstablishment = new BusinessEstablishment();
						List<IEstablishment> listEstablishments = businessEstablishment.getAllEstablishments();
						Integer establishments = listEstablishments.size();
						IEstablishment establishment;
						//Recorro la lista de establecimientos para mostrarlos y 
						//que el usuario seleccione los que quiera:
						int est=0;
						for (est=0; est <= establishments-1; est++) {
							establishment = listEstablishments.get(est);
							String establishmentName = establishment.getNameEstablishment();
							Integer establishmentID = establishment.getEstablishmentID();
					%>
					<input id="<%= "input_establishment"+est %>" type="checkbox" name= "<%="input_establishment"+est%>" value="<%= establishmentID %>"> <%= establishmentName %> <br>
					<% 	}; %>
					
					
					<div id="div_addfriends">
						<label> <b> ¡Sugierele la Ruta a tus seguidores! </b> <br></label>
						<% 
							IUser follower;
							//Recorro la lista de usuarios para mostrarlos y 
							//que el usuario seleccione los que quiera invitar:
							int f;
							for(f = 0; f<followers.size();f++){
								if(followers.get(f)!=null){
									follower = followers.get(f);
							%>
							<input id="<%= "input_follower"+f %>" type="checkbox" name= "<%="input_follower"+f%>" value="<%= follower.getLogin() %>"> <%= follower.getName() %> <br>
						<% }
						} %>
					</div>

					<div id="boton" align="center">
						<button type="submit">Continuar</button>
					</div>
				</form>
				<%} else{
				%> 
					<span>NO TIENES SEGUIDORES, NO PUEDES CREAR UNA RUTA-TAPA =(</span>
					
					<div id="boton" align="center">
						<a href="home.jsp">Volver al inicio</a>
					</div>
			
				<% 	
				}
				%>
				
				<%
					String error= (String) session.getAttribute("routeerror");
					if(error!=null){
					%>
					<div class="div_error">
						<hr>
						<label><%= error %></label>
					</div>
					<%
					}
					session.removeAttribute("routeerror");
				%>
			
		</div>

	</div>
	<%@ include file="foot.jsp" %>
	</div>
</body>
</html>