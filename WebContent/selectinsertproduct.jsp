<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ include file="imports.jsp"%> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<%@ include file="imports_head.html"%>
</head>
<body>
		<div id="div_contain">
			<%@ include file="header.html" %>
			
			<%@ include file="top_menu.html" %>
	
			<div id="div_body">
				<h3 id="title_space_user" class="blue_underline">Selecione porducto:</h3>
					<form action="selectproduct" method="post">
						<div id="div_product">
							<label>Seleccione un producto:  </label> <select id="input_product" name="input_product"   style="width: 127px;" >
							<option value="Comida">Comida</option>
							<option value="Cerveza">Cerveza</option>
							<option value="1/2 Ración">Vino</option>
							<option value="Plato">Otros</option>
							</select>
						</div>
						
					<div id="button" align="left">
							<button type="submit">Continuar</button>
						</div>
					</form>
			</div>
			<%@ include file="foot.jsp" %>
		</div>				
</body>
</html>