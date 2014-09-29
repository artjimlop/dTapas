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
		
			<h3 id="title_space_user" class="blue_underline">Sugerencias de tapeadores:</h3>
			
			<%
				String login = (String) session.getAttribute("session.user");
				IUser user = new BusinessUser().getUserByLogin(login);
			%>

			<div id="div_user_space">
		
				<%
					BusinessFollower businessFollower = new BusinessFollower();
			 		Set<IUser> users = businessFollower.suggestTapeador(user.getLogin());
			 		if(!users.isEmpty()){
					for(IUser u : users){
				
				%>
					<div id="div_user_f" onclick="add_follower('<%= user.getLogin() %>','<%= u.getLogin() %>','<%= request.getRequestURL() %>')" title="¿Tapear con <%= u.getLogin() %>?">
						<div id="div_image_user"><img src="images/user_icon.jpg"></div>
						<div id="div_name_user" class="text_align_center"><%= u.getName() + " " + u.getSurname() %></div>
					</div>
				
				<%}
			 		}else{out.println("No hay sugerencias posibles"); 
			 	}; %>
					
			</div>
		</div>
		<%@ include file="foot.jsp" %>
	</div>
	
</body>
</html>