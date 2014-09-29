<%@ include file="imports.jsp"%>
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
			
			<%@ include file="top_menu.html" %>
	
			<div id="div_body">
			
				<h3 id="title_space_user" class="blue_underline">Establecimientos</h3>
	
				<%
				
			 	BusinessEstablishment be = new BusinessEstablishment();
				if(be.getAllEstablishments().size()>0){
					for(IEstablishment establishment: be.getAllEstablishments()){
				%>
				<div id="div_establishment">
					<div id="div_info_establishment">
						<label class="blue_underline"><b><%= establishment.getNameEstablishment() %></b></label><br>
						<label><b>Dirección:</b> <%= establishment.getStreet() %></label><br>
						<label><b>Ciudad:</b> <%= establishment.getCity() %></label><br>
						<label><b>Zona:</b> <%= establishment.getZone() %></label><br>
						<label><b>Código postal:</b> <%= establishment.getZipCode() %></label><br>
						<label><b>Provincia:</b> <%= establishment.getProvince() %></label><br>
					</div>
					<div id="div_image_establishment">
						<img id="img_establishment" src="images/establishment.jpg" alt="image establishment">
					</div>
				</div>
				
				<hr>
					
				<%
					}
				}else{
					out.println("Actualmente no existe ningún establecimiento.");
				}
				
				%>
			
	
			</div>
			
			<%@ include file="foot.jsp" %>
		</div>

	</body>
</html>