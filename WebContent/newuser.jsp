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

			<div id="div_form_user">
			
				<fieldset>
					<form onsubmit="return validar_formulario_user()" action="ManagerUserCheck" method="post">
						<div id="div_name">
							<label>Nombre:</label>
							<input id="input_user_name" name="input_user_name" type="text">
						</div>
					
						<div id="div_surname">
							<label>Apellidos:</label>
							<input id="input_user_surname" name="input_user_surname" type="text">
						</div>
						
						<div id="div_email">
							<label>Email:</label>
							<input id="input_user_email" name="input_user_email" type="text">
						</div>
					
						<div id="div_login_register">
							<label>Login:</label>
							<input id="input_user_login" name="input_user_login" type="text">
						</div>
						
						<div id="div_password">
							<label>Clave:</label>
							<input id="input_user_password" name="input_user_password" type="password">
						</div>
						
						<div id="div_password">
							<label>Repetir clave:</label>
							<input id="input_user_password2" name="input_user_password2" type="password">
						</div>
						
						<div id="boton" align="center">
							<button type="submit">Aceptar</button>
							<button type="reset">Borrar</button>
						</div>
						
						<%
						String error= (String) session.getAttribute("error");
						if(error!=null){
						%>
						<hr>
						<div class="div_error">
							<label><%= error %></label>
						</div>
						<%
							session.invalidate();
						}
						%>
						
					</form>
				</fieldset>

			</div>

		</div>

	<%@ include file="foot.html" %>
	</div>

</body>
</html>