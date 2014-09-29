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
			
			<div id="div_user_space">
				<h3 id="title_space_user" class="blue_underline">Otros tapeadores:</h3>
				<%
				List<IUser> tapeadores = new BusinessUser().getAllUsers();
				tapeadores.remove(user);
				List<IUser> followeds = new BusinessFollower().getMyFollowed(user.getLogin());
				tapeadores.removeAll(followeds);
				if(tapeadores.size() > 0){
					for(IUser u : tapeadores){
				%>
					<div id="div_user_f" onclick="add_follower('<%= user.getLogin() %>','<%= u.getLogin() %>','<%= request.getRequestURL() %>')" title="¿Tapear con <%= u.getLogin() %>?">
						<div id="div_image_user"><img src="images/user_icon.jpg"></div>
						<div id="div_name_user" class="text_align_center"><%= u.getName() + " " + u.getSurname() %></div>
					</div>
				
				<%
						}
					}else{
						out.println("Actualmente no sigues a nadie.");
					}; 
				%>
			</div>
		
			<div id="div_followers_followeds_suggest">
			
				<div id="div_suggests">
					<div>
						<span id="title_followers">Sugerencias de tapeadores:</span>
						<hr>
					</div>
					<%
						IUser u;
						Set<IUser> suggest = new BusinessFollower().suggestTapeador(user.getLogin());
						Iterator<IUser> userIt = suggest.iterator();
						if(suggest.size() > 0){
							for(Integer i=0;i<4 && userIt.hasNext();i++){
								out.println("<div id='div_user_row'>");
								for(Integer j=0; j<3 && userIt.hasNext();j++){
									u = userIt.next();
					%>
						<div id="div_user_f" onclick="add_follower('<%= user.getLogin() %>','<%= u.getLogin() %>','<%= request.getRequestURL() %>')" title="¿Tapear con <%= u.getLogin() %>?">
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
						<a href="suggestTapeadores.jsp">Ver todos</a> (<%= new BusinessFollower().suggestTapeador(user.getLogin()).size() %>)
					</div>
				</div>
			</div>
			
		</div>
		<%@ include file="foot.jsp" %>
	</div>

</body>
</html>