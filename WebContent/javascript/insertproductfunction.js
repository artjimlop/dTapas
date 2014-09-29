function productPriceValidation() {

	
	var priceProduct = document.getElementById("input_price");

	//Variable que acumula los errores
	var errors = "";
	
     if (priceProduct.value.match(/[a-zA-Z]/)){
    	 errors +="- Por favor introduzca un numero";
     } else if(priceProduct.value==""){
		errors +="- El campo precio no puede estar vacio";
 	}
     else if(priceProduct.value < 0){
 		errors +="- Introduzca un precio positivo por favor";
     }
    
	if (errors != ""){
		buttonDesactive();
		document.getElementById("input_price").value = 0;
		document.getElementById("input_price").focus();
		alert(errors);		
	}
	else{
		if (priceProduct.value == 0)
	    	buttonDesactive();
		else
			buttonActive();
	}
}

function productScorePreValidation() {

	var score = document.getElementById("input_presentationscore");

	//Variable que acumula los errores
	var errors = "";
	if (score.value.match(/[a-zA-Z]/)){
		errors +="- Por favor introduzca un numero";
	} else if(score.value==""){
		errors +="- El campo Puntuacion de la presentacion no puede estar vacio";
	}
	else if (score.value > 10 || score.value < 0){
		errors +="- Por favor introduzca una puntuacion entre 0 y 10";
	}
     
	if (errors != ""){
		buttonDesactive();
		document.getElementById("input_presentationscore").value = 0;
		document.getElementById("input_presentationscore").focus();
		alert(errors);
	}
	else{
		buttonActive();
	}
}

function productScoreQuaValidation() {

	var score = document.getElementById("input_quantityscore");

	//Variable que acumula los errores
	var errors = "";
	if (score.value.match(/[a-zA-Z]/)){
		errors +="- Por favor introduzca un numero";
	} else if(score.value==""){
		errors +="- El campo Puntuacion de la cantidad no puede estar vacio";
	}
	else if (score.value > 10 || score.value < 0){
		errors +="- Por favor introduzca una puntuacion entre 0 y 10";
	}
     
	if (errors != ""){
		buttonDesactive();
		document.getElementById("input_quantityscore").value = 0;
		document.getElementById("input_quantityscore").focus();
		alert(errors);
	}
	else{
		buttonActive();
	}
}
function productScorePriceValidation() {

	var score = document.getElementById("input_pricescore");

	//Variable que acumula los errores
	var errors = "";
	if (score.value.match(/[a-zA-Z]/)){
		errors +="- Por favor introduzca un numero";
	} else if(score.value==""){
		errors +="- El campo Puntuacion del precio no puede estar vacio";
	}
	else if (score.value > 10 || score.value < 0){
		errors +="- Por favor introduzca una puntuacion entre 0 y 10";
	}
     
	if (errors != ""){
		buttonDesactive();
		document.getElementById("input_pricescore").value = 0;
		document.getElementById("input_pricescore").focus();
		alert(errors);
	}
	else{
		buttonActive();
	}
}	

function productCommentValidation() {
	

	var comment = document.getElementById("input_comment");
		
	//Variable que acumula los errores
	var errors = "";
	/* Comprobaciones del nombre */
	
	if(comment.value==""){
		errors +="- Por favor introduzca un comentario";
	}else if(comment.value.match(/^[^\s()<>@,;:\/]+@\w[\w\.-]+\.{2,}$/i)){  
   	    errores +="- Comentario invalido";
 	}
	
	if (errors != ""){
		alert(errors);
//		document.getElementById("input_comment").value = "Introduce un comentario";
		document.getElementById("input_comment").focus();
		buttonDesactive();		
	}
	else
		buttonActive();
}

function productname() {
	

	var name = document.getElementById("input_name");
		
	//Variable que acumula los errores
	var errors = "";
	/* Comprobaciones del nombre */
	
	if(name.value==""){
		errors +="- Por favor introduzca un Nombre";
	}else if(name.value.match(/^[^\s()<>@,;:\/]+@\w[\w\.-]+\.{2,}$/i)){  
   	    errores +="- Nombre invalido";
 	}
	
	if (errors != ""){
		document.getElementById("input_name").focus();
		alert(errors);
		buttonDesactive();
	}
	else
		buttonActive();
}



function buttonActive() {
	
//	alert("Llame al boton de activar");
	
	var name = document.getElementById("input_name").value;
	var price = document.getElementById("input_price").value;
	var type = document.getElementById("input_type").value;
	var scorepre = document.getElementById("input_presentationscore").value;
	var scoreq = document.getElementById("input_quantityscore").value;
	var scorepri = document.getElementById("input_pricescore").value;
	var comment = document.getElementById("input_comment").value;
	
//	alert(name + price + type + scorepre + scoreq + scorepri + comment);
	
	
	if (name != "" && price != "" && type != "" && scorepre != "" && scoreq != "" && scorepri != "" && comment != "" && price != 0){
		document.getElementById("button").disabled = false;
//		document.formulario.boton.disabled = false;
	}
}

function buttonDesactive() {
//	alert("funcion desactivar");
	document.getElementById("button").disabled = true;
}

function redirectproduct(){
	alert("entro en redireccionar");
	var name = document.getElementById("input_product").value;
	if (name == "Comida")
		window.location = "newfood.jsp";
}



