<%@ include file="imports.jsp"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Comida insertada</title>
<%@ include file="imports_head.html"%>
</head>
<body>
	<div id="div_contain">

		<%@ include file="header.html" %>
		
		<%@ include file="top_menu.html" %>

		<div id="div_body">
		
			<h3 id="title_space_user" class="blue_underline">Crear comida</h3>
			
			<%
			String login = (String) session.getAttribute("session.user"); 
			Integer establishmentID = Integer.parseInt(request.getParameter(("input_establ")));
			Double price = Double.parseDouble(request.getParameter(("input_price")));
			Double scorepre = Double.parseDouble(request.getParameter(("input_presentationscore")));
			Double scorequa = Double.parseDouble(request.getParameter(("input_quantityscore")));
			Double scorepri = Double.parseDouble(request.getParameter(("input_pricescore")));
			
			String productName = (String) request.getParameter("input_name");
			String type = (String) request.getParameter("input_type");
			String comment = (String) request.getParameter("input_comment");
		//	out.println(login + establishmentID + price + scorepre + scorepri + scorequa + productName + type + comment);
			
			IBusinessUser businessUser = new BusinessUser();
		//  IBusinessProduct product = new BusinessProduct();
			IBusinessFood food = new BusinessFood();
			IBusinessProductComment productcomment = new BusinessProductComment();
			IBusinessProductScore score = new BusinessProductScore();
			IBusinessUserComment usercoment = new BusinessUserComment();
			IBusinessEstablishment establishment = new BusinessEstablishment();
			if(food.testInsertFood(productName, type) ){
			%>
			
			Ya existe un producto insertado con el mismo nombre y el mismo tipo en el mismo establecimiento.
			<a href='newfood.jsp' >Volver</a>
				
			<%
				
			}
			else{
				Integer foodid = food.insertFood(productName, price, login, establishmentID, type);
				IFood food2 = food.getFoodByID(foodid);
				IProductScore productscore = new ProductScore(scorepre,scorequa, scorepri, login, food2.getProductID());
				score.insertProductScore(productscore);
				productcomment.insertProductComment(comment, login, food2.getProductID());
				IUserComment comment2 = new UserComment(login, login ,"¡Acabas de crear la comida " + food2.getProductName() + "!" );
				usercoment.insertUserComment(comment2);
			
			%>
			<div>
				
			<% 	
				if(request.getParameter("error")!=null && ((String)request.getParameter("error")).equals("si")){
			%>
				
				<div id="div_error_product">
					<label>Error: Se produjo un error al Insertar </label>
					
					<a href = 'newfood.jsp' >Volver</a>
				
				</div>
				<%
					}else{
				%>
				<label><b>¡Producto insertado!</b></label>
				<div id="div_info_food">
					<label><b>Nombre:</b> <%= food2.getProductName() %></label><br>
					<label><b>Establecimiento:</b> <%= establishment.getEstablishmentByID(establishmentID).getNameEstablishment() %></label><br>
					<label><b>Tipo:</b> <%= food2.getType() %></label><br>
					<label><b>Precio:</b> <%= food2.getPrice() %></label><br>
					<a href= 'foods.jsp' >Ver productos</a>
					
				</div>
				
			<%
					}
				}
			%>
			
			</div>
		</div>
	<%@ include file="foot.jsp" %>
	</div>
</body>
</html>