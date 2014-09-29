<%@ include file="imports_new_user.jsp"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>DTapas - La web de los tapeadores</title>
<%@ include file="imports_head.html"%>
</head>
<body>

	<div id="div_contain">

		<%@ include file="header.html" %>

		<div id="div_body">
			<h3 id="title_space_user" class="blue_underline">Registrar usuario:</h3>
			<%
				//Recoge los parametros:
					
				IUser user = (IUser) session.getAttribute("user");
			
				if(user != null){
					
					String login = user.getLogin();
					String name = user.getName();
					String surname = user.getSurname();
					String password = user.getPassword();
					String email = user.getEmail();
					
					//Crea usuario y lo inserta en BD:
					BusinessUser bUser = new BusinessUser();
					IUser newUser = new User(login,password,email,name,surname);
					bUser.insertUser(newUser);
				
				
			%>
			
			<label>Enhorabuena el siguiente usuario ha sido registrado con éxito:</label><br>
			<label><b>Login:</b> <%= login %></label><br>
			<label><b>Nombre:</b> <%= name %></label><br>
			<label><b>Apellidos:</b> <%= surname %></label><br>
			<label><b>Email:</b> <%= email %></label><br>
			<label>Por motivos de seguridad la contraseña no será mostrada.</label><br><br>
			<label><a href="index.jsp">Logeate</a> y comienza a disfrutar de dtapas.</label>
			
			<%
				}else{
			%>
					<label>Error al crear usuario. <a href="newuser.jsp">Volver al formulario de registro</a>.</label>
			<%
				}
			%>

		</div>

	<%@ include file="foot.html" %>
	</div>

</body>
</html>