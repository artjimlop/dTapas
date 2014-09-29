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
			
			<h3 id="title_space_user" class="blue_underline">Lista de comidas:</h3>
				
			<% 	
				IBusinessFood bfood = new BusinessFood();
				IBusinessEstablishment bestablishment= new BusinessEstablishment();
				List <IFood> foods = bfood.getAllFoods();
				if (foods.size() > 0){
					for(IFood foodt: foods) {
						IEstablishment establishment = bestablishment.getEstablishmentByID(foodt.getEstablishmentID());
			%>
				<div id="div_establishment">
					<div id="div_info_establishment">
						<label class="blue_underline"><b><%= foodt.getProductName() %></b></label><br>
						<label><b>Precio:</b> <%= foodt.getPrice() %></label><br>
						<label><b>Tipo:</b> <%= foodt.getType() %></label><br>
						<label><b>Establecimiento:</b> <%= establishment.getNameEstablishment() %></label><br>
						<label><b>Dirección:</b> <%= establishment.getStreet() %></label><br>
						<label><b>Zona:</b> <%= establishment.getZone() %></label><br>
						<label><b>Localidad:</b> <%= establishment.getCity() %></label><br>
						<label><b>Provincia:</b> <%= establishment.getProvince() %></label><br>
					</div>
					<div id="div_image_establishment">
						<img id="img_establishment" src="images/food.jpg" alt="image food">
					</div>
				</div>
				
				<hr>					
			<%
					}
				}else{
					out.println("Actualmente no existe ninguna comida");
				}
			%>
			
			
		</div>
		<%@ include file="foot.jsp" %>
	</div>

</body>
</html>