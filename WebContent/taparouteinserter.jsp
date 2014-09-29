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
			
				<h3 id="title_space_user" class="blue_underline">Crear tapa rutas:</h3>
				
				<%
				IBusinessUser businessUser = new BusinessUser();
				IBusinessUserComment businessUserComment = new BusinessUserComment();
				IBusinessEstablishment businessEstablishment = new BusinessEstablishment();
				IBusinessTapaRoute businessTapaRoute = new BusinessTapaRoute();
				IBusinessUserTapaRoute businessUserTapaRoute = new BusinessUserTapaRoute();
				IBusinessEstablishmentTapaRoute businessEstablishmentTapaRoute = new BusinessEstablishmentTapaRoute(); 
				IBusinessTapaRouteComment businessTapaRouteComment = new BusinessTapaRouteComment();
				IBusinessFollower bFoll = new BusinessFollower();
				//IUser user = (IUser) session.getAttribute("user");
				//Todos los datos del usuario:
				String login = (String) session.getAttribute("session.user");
				IUser user = businessUser.getUserByLogin(login);
				
				//Datos que se recogen y muestran de la ruta:
				ITapaRoute tapaRoute = (ITapaRoute) session.getAttribute("tapaRoute");
				List<IEstablishment> establishments = (List<IEstablishment>) session.getAttribute("establishments");
				List<IUser> addeds = (List<IUser>) session.getAttribute("addeds");
				
				//La ruta se inserta solo si ningun valor necesario es nulo.
				//En caso contrario, muestra un mensaje de error:
				if(tapaRoute!=null && establishments!=null && addeds!=null){
					businessTapaRoute.insertTapaRoute(tapaRoute);
					//Te insertas a ti mismo en los usuarios ruta tapa:
					addeds.add(user);
					
					//Añades un usercomment estandar para ti y todos los invitados:
					String standardComment;
					//Lista para mostrar los usuarios en el navegador:
					List<String> showAddedUsers = new ArrayList<String>();
					
					for(IUser add:addeds){
						businessUserTapaRoute.insertUsersTapaRoute(add, tapaRoute);
						if(add.getLogin().equals(user.getLogin())){
							String presentationDate = Tools.dateStringToString(tapaRoute.getTargetDate().toString());
							standardComment = "¡Acabas de crear la Ruta "+tapaRoute.getName()+"! Para el dia: "+presentationDate;
						}else{
							standardComment = "¡Te invito a participar en mi Ruta "+tapaRoute.getName() +", "+add.getLogin()+"!";
						}
						UserComment comment = new UserComment(add.getLogin(),user.getLogin(),standardComment);
						businessUserComment.insertUserComment(comment);
						//Lista para mostrar al usuario por pantalla los usuarios invitados:
						showAddedUsers.add(add.getName()+" "+add.getSurname());
					}
					
					//showEstablishments sirve para mostrar los establecimientos en el navegador
					List<String> showEstablishments = new ArrayList<String>();
					
					for(IEstablishment addedEstablisment:establishments){
						businessEstablishmentTapaRoute.insertEstablishmentTapaRoute(addedEstablisment, tapaRoute);
						//Lista para mostrar al usuario los establecimientos que componene
						//la ruta
						showEstablishments.add(addedEstablisment.getNameEstablishment());
					}
					
					//Se inserta un taparoutecomment automatico:
					String tapaRouteComment = "¡Acabo de crear una ruta-tapa!";
					ITapaRouteComment trComment = new TapaRouteComment(tapaRouteComment, user.getLogin(), tapaRoute.getTapaRouteID());
					businessTapaRouteComment.insertComment(trComment);
				
				%>
				
				<b>¡Tapa-Ruta Creada!</b>
				
				<div>
					<span> <b>Nombre de la ruta: </b> <%= tapaRoute.getName() %> </span>
				</div>
				
				<div>
					<span> <b>Fecha: </b> <%= Tools.dateStringToString(tapaRoute.getTargetDate().toString()) %> </span>
				</div>
				
				<div>
					<span> <b>Con los tapeadores: </b> <%= showAddedUsers%> </span>
				</div>
				
				<div>
					<span> <b>Vas a los establecimientos: </b> <%= showEstablishments %> </span>
				</div>
				
				<%
					//Al terminar el proceso se eliminan las variables de sesion
					//Para que al refrescar la pagina no se inserte otra vez la ruta:
						
					session.removeAttribute("tapaRoute");
					session.removeAttribute("establishments");
					session.removeAttribute("addeds");
					
				}else{ //Mensaje de error al refrescar la pagina:
					%> 
				<div>
					<span> <b> ¡VUELVE A TU CUEVA, TROLL! </b> </span>
				</div>
				<%	
				}
				%>
			</div>
			
			<div id="boton">
				<a href="taparoutes.jsp">Ver RUTA-TAPAS</a>
			</div>
			
			<%@ include file="foot.jsp" %>
		</div>

	</body>
</html>