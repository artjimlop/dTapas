
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
					<span><b>Rutas en las que participas: </b><%= new BusinessUserTapaRoute().getAllTapaRoutesByUser(user).size() %></span><br>
					<span><b>Comentarios: </b><%= new BusinessComment().getCommentByUserID(user.getLogin()).size() %></span><br>
				</div>
			</div>
		
			<div id="div_user_space">
			
				<h3 id="title_space_user" class="blue_underline">�ltimas acciones</h3>
			
				<%
				 	BusinessActivity ba = new BusinessActivity();
					List<IActivity> activities = ba.getAllActivitiesByUserLogin(user.getLogin());
					if(activities.size()>0){
						for(IActivity activity: activities){
							IRepresentationActivity representationActivity = ba.getRepresentationActivity(activity);
							out.println("<div id='div_ar'>");
							if(representationActivity.getRepresentationActivity()==1){
								//Score of product
				%>
				<div id="div_ar_userlogin"><label class="blue_bolder"><%= representationActivity.getUserLogin() %></label> ha puntuado el producto 
					<label class="blue_bolder"><%= representationActivity.getDestinityName() %></label></div>
				<div id="div_ar_date" class="blue">
					<%= Tools.getIntervalTime(representationActivity.getDate(), representationActivity.getTime()) %>
				</div>
				<div id="div_ar_contain">
					<div>Presentaci�n: <%= representationActivity.getPresentationScore() %></div>
					<div>Cantidad: <%= representationActivity.getQuantityScore() %></div>
					<div>Precio: <%= representationActivity.getPriceScore() %></div>
					<div>Nota media: <%= representationActivity.getMediumScore() %></div>
				</div>
				<%
							}else if(representationActivity.getRepresentationActivity()==2){
								//Score of establishment
				%>
				<div id="div_ar_userlogin"><label class="blue_bolder"><%= representationActivity.getUserLogin() %></label> ha puntuado el establecimiento 
					<label class="blue_bolder"><%= representationActivity.getDestinityName() %></label></div>
				<div id="div_ar_date" class="blue">
					<%= Tools.getIntervalTime(representationActivity.getDate(), representationActivity.getTime()) %>
				</div>
				<div id="div_ar_contain">
					<div>Calidad: <%= representationActivity.getQualityScore() %></div>
					<div>Servicio: <%= representationActivity.getServiceScore() %></div>
					<div>Limpieza: <%= representationActivity.getCleaningScore() %></div>
					<div>Dimensiones: <%= representationActivity.getSizeScore() %></div>
					<div>Localizaci�n: <%= representationActivity.getLocationScore() %></div>
					<div>Precios: <%= representationActivity.getPriceScore() %></div>
					<div>Nota media: <%= representationActivity.getMediumScore() %></div>
				</div>
				<%
							}else if(representationActivity.getRepresentationActivity()==3){
								//Comment of product
				%>
				<div id="div_ar_userlogin"><label class="blue_bolder"><%= representationActivity.getUserLogin() %></label> ha comentado el producto 
					<label class="blue_bolder"><%= representationActivity.getDestinityName() %></label></div>
				<div id="div_ar_date" class="blue">
					<%= Tools.getIntervalTime(representationActivity.getDate(), representationActivity.getTime()) %>
				</div>
				<div id="div_ar_contain">
					<div><%= representationActivity.getComment() %></div>
				</div>
				<%
							}else if(representationActivity.getRepresentationActivity()==4){
								//Comment of establishment
				%>
				<div id="div_ar_userlogin"><label class="blue_bolder"><%= representationActivity.getUserLogin() %></label> ha comentado el establecimiento 
					<label class="blue_bolder"><%= representationActivity.getDestinityName() %></label></div>
				<div id="div_ar_date" class="blue">
					<%= Tools.getIntervalTime(representationActivity.getDate(), representationActivity.getTime()) %>
				</div>
				<div id="div_ar_contain">
					<div><%= representationActivity.getComment() %></div>
				</div>
				<%
							}else if(representationActivity.getRepresentationActivity()==5){
								//Comment of user
								if(representationActivity.getUserLogin().equals(representationActivity.getDestinityName())){
				%>
				<div id="div_ar_userlogin"><label class="blue_bolder"><%= representationActivity.getUserLogin() %></label></div>	
				<%
								}else{
									String loginFrom = representationActivity.getUserLogin();
									String loginTo = representationActivity.getDestinityName();
									
				%>
				<div id="div_ar_userlogin"><label class="blue_bolder"><a href="home.jsp"><%= representationActivity.getUserLogin() %> </a> </label> dijo a 
					<label class="blue_bolder"><a href="home.jsp"><%= representationActivity.getDestinityName() %></a></label>
					<a href="home.jsp">Volver al inicio</a></div>
				<%
								}
				%>
				<div id="div_ar_date" class="blue">
					<%= Tools.getIntervalTime(representationActivity.getDate(), representationActivity.getTime()) %>
				</div>
				<div id="div_ar_contain">
					<div><%= representationActivity.getComment() %></div>
				</div>
				<%
							}else if(representationActivity.getRepresentationActivity()==6){
								//Comment of tapa route
				%>
				<div id="div_ar_userlogin"><label class="blue_bolder"><%= representationActivity.getUserLogin() %></label> ha comentado la ruta tapa  
					<label class="blue_bolder"><%= representationActivity.getDestinityName() %></label></div>
				<div id="div_ar_date" class="blue">
					<%= Tools.getIntervalTime(representationActivity.getDate(), representationActivity.getTime()) %>
				</div>
				<div id="div_ar_contain">
					<div><%= representationActivity.getComment() %></div>
				</div>
				<%
							}
							out.println("</div>");
						}
					}else{ //Se cumple si el usuario a�n no ha creado ninguna actividad
						out.println("El tapeador a�n no ha realizado ninguna actividad.");
					}
				%>
			
			</div>
			
			<div id="div_followers_followeds_suggest">
			
				<div id="div_followers">
					<div>
						<span id="title_followers">Tapean contigo:</span>
						<hr>
					</div>
					<%
						Iterator<IUser> userIt = new BusinessFollower().getMyFollowers(user.getLogin()).iterator(); 
						IUser u;
						if(new BusinessFollower().getMyFollowers(user.getLogin()).size() > 0){
							for(Integer i=0;i<4 && userIt.hasNext();i++){
								out.println("<div id='div_user_row'>");
								for(Integer j=0; j<3 && userIt.hasNext();j++){
								u = userIt.next();
					%>
						<div id="div_user_f">
							<div id="div_image_user"><img src="images/user_icon.jpg"></div>
							<div id="div_name_user"><%= u.getName() + " " + u.getSurname() %></div>
						</div>
					
					<%
								}
								out.println("</div>");
							}
						}else{
								out.println("Actualmente no tienes seguidores.");
							}; 
					%>
					<div>
						<hr>
						<a href="follower.jsp">Ver todos</a> (<%= new BusinessFollower().getMyFollowers(user.getLogin()).size() %>)
					</div>
				</div>
				
				<div id="div_followeds">
					<div>
						<span id="title_followeds">Tapeas con:</span>
						<hr>
					</div>
					<%
						
						if(new BusinessFollower().getMyFollowed(user.getLogin()).size() >0){
							userIt = new BusinessFollower().getMyFollowed(user.getLogin()).iterator();
							for(Integer i=0;i<4 && userIt.hasNext();i++){
								out.println("<div id='div_user_row'>");
								for(Integer j=0; j<3 && userIt.hasNext();j++){
								u = userIt.next();
					%>
					<div id="div_user_f" onclick="delete_follower('<%= user.getLogin() %>','<%= u.getLogin() %>','<%= request.getRequestURL() %>')" title="�Dejar de tapear con <%= u.getLogin() %>?">
						<div id="div_image_user"><img src="images/user_icon.jpg"></div>
						<div id="div_name_user"><%= u.getName() + " " + u.getSurname() %></div>
					</div>
					<%
								}
								out.println("</div>");
							}
						}else{
							out.println("Actualmente no sigues a nadie.");
						}; 
					%>
					<div>
						<hr>
						<a href="followed.jsp">Ver todos</a> (<%= new BusinessFollower().getMyFollowed(user.getLogin()).size() %>)
					</div>
				</div>
				
				<div id="div_suggests">
					<div>
						<span id="title_followers">Sugerencias de tapeadores:</span>
						<hr>
					</div>
					<%
						Set<IUser> suggest = new BusinessFollower().suggestTapeador(user.getLogin());
						userIt = suggest.iterator();
						if(suggest.size() > 0){
							for(Integer i=0;i<4 && userIt.hasNext();i++){
								out.println("<div id='div_user_row'>");
								for(Integer j=0; j<3 && userIt.hasNext();j++){
									u = userIt.next();
					%>
						<div id="div_user_f" onclick="add_follower('<%= user.getLogin() %>','<%= u.getLogin() %>','<%= request.getRequestURL() %>')" title="�Tapear con <%= u.getLogin() %>?">
							<div id="div_image_user"><img src="images/user_icon.jpg"></div>
							<div id="div_name_user"><%= u.getName() + " " + u.getSurname() %></div>
						</div>
					
					<%
								}
								out.println("</div>");
							}
						}else{
							out.println("Actualmente no existen sugerencias.");
						};
					%>
					<div>
						<hr>
						<a href="suggestTapeadores.jsp">Ver todos</a> ( <%= new BusinessFollower().suggestTapeador(user.getLogin()).size() %> )
					</div>
				</div>
			</div>
			
		</div>
		<%@ include file="foot.jsp" %>		
	</div>

</body>
</html>