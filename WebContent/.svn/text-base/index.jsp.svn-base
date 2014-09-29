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

			<div id="div_form_login">
			
				<fieldset>
					<form action="FrontController?destiny=home.jsp" method="post">
						<div id="div_login">
							<label>Usuario:</label>
							<input id="input_user" name="input_user" type="text">
						</div>
						<div id="div_password">
							<label>Clave:</label>
							<input id="input_password" name="input_password" type="password">
						</div>
						
						<%
							if(request.getParameter("error")!=null && ((String)request.getParameter("error")).equals("si")){
						%>
						<div id="div_error_login">
							<label>Error: nombre o clave no coinciden</label>
						</div>
						<%
							}
						%>
						
						<%
							if(request.getParameter("fin_sesion")!=null && ((String)request.getParameter("fin_sesion")).equals("si")){
								session.invalidate();
						%>
						<div id="div_fin_sesion">
							<label>La sesión se ha cerrado correctamente</label>
						</div>
						<%
							}
						%>
						<div id="boton" align="center">
							<button type="submit">Aceptar</button>
						</div>
					</form>
					<hr id="line_login">
					<a href="newuser.jsp">¿Quieres una cuenta? Regístrate</a>
				</fieldset>

			</div>

		</div>
	</div>

</body>
</html>