<%@ include file="imports.jsp"%>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>DTapas - Crear nueva comida</title>
<%@ include file="imports_head.html"%>
</head>
<body>

	<div id="div_contain">

		<%@ include file="header.html" %>
		
		<%@ include file="top_menu.html" %>

		<div id="div_body">
		
			<div id="div_user_space">
			
				<h3 id="title_space_user" class="blue_underline">Añadir comida</h3>
				
				<fieldset>
					<form action="insertfood.jsp" method="post">
						
						<div id="div_establishment">
							<label>Seleccione un Establecimeinto:  </label>
							<select id="input_establ" name="input_establ"   style="width: 127px;">
						<% 
							BusinessEstablishment businessEstablishment = new BusinessEstablishment();
							List<IEstablishment> listEstablishments = businessEstablishment.getAllEstablishments();
							for (IEstablishment establishment : listEstablishments) {
						%>
							<option value="<%= establishment.getEstablishmentID() %>"><%= establishment.getNameEstablishment() %></option>
						<%
						}
						%>
							</select>
					
						</div>
						
						<div id="div_nameproduct">
							<label id="label_name">Nombre de la comida:  </label>
							<input id="input_name" name="input_name" maxlength="50" type="text" onBlur="productname()">
						</div>
						
						<div id="div_price">
							<label id="label_price">Precio: </label>
							<input id="input_price" maxlength="7" name="input_price" value="0" type="text" onBlur="productPriceValidation()">
						</div>
							<div id="div_type">
							<label>Tipo: </label>
							<select id="input_type" name="input_type">
								<option value="Ración">Ración</option>
								<option value="Tapa">Tapa</option>
								<option value="1/2 Ración">1/2 Ración</option>
								<option value="Plato">Plato</option>
								<option value="Postre">Postre</option>
							</select>
							
							
						</div>
						
						
						<b class="blue_underline">Puntuacion para la comida:</b>
										
						<div id="div_presentationscore">
							<label>Puntuacion de la presentacion: </label>
							<input id="input_presentationscore" name="input_presentationscore" maxlength="4" value="0"  type="text" style="width: 60px;" onBlur="productScorePreValidation()">
						</div>
						<div id="div_quantityscore">
							<label>Puntuacion de la Cantidad: </label>
							<input id="input_quantityscore" name="input_quantityscore" value="0" maxlength="4" type="text" style="width: 60px;" onBlur="productScoreQuaValidation()">
						</div>
						<div id="div_pricescore">
							<label>Puntuacion del precio: </label>
							<input id="input_pricescore" name="input_pricescore" value="0" type="text" maxlength="4" style="width: 60px;" onBlur="productScorePriceValidation()">
						</div>
						
						
						<span id="title_food">Comentario de la comida:</span>
						<div id="div_pricescore">
							
							<input id="input_comment" name="input_comment" maxlength="500" type="text" style="width: 631px; height: 117px" onBlur="productCommentValidation()" onChange="buttonActive()" onKeyDown="buttonActive()">
						</div>
						<% 	if(request.getParameter("error")!=null && ((String)request.getParameter("error")).equals("si")){
						%>
						<div id="div_error_product">
							<label>Error: Se produjo un error al producto</label>
						</div>
						<%
							}
						%>
						<div id="div_button" align="left">
							<button type="submit" disabled=true id="button">Insertar Comida</button>
						</div>
					</form>
				</fieldset>

			
		</div>

	</div>
	<%@ include file="foot.jsp" %>
	</div>
</body>
</html>