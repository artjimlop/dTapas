function validar_formulario_user() {
	
	var formValidate = true;
	
	var name = document.getElementById("input_user_name");
	var surname = document.getElementById("input_user_surname");
	var login = document.getElementById("input_user_login");
	var password = document.getElementById("input_user_password");
	var password2 = document.getElementById("input_user_password2");
	var email = document.getElementById("input_user_email");

	//Variable que acumula los errores
	var errors = "";
	
	/* Comprobaciones del nombre y apellidos */
	if(name.value == ""){
		errors +="- El campo Nombre no puede estar vacio \n";
		formValidate = false;
	}
	
	if(surname.value == ""){
		errors +="- El campo Apellidos no puede estar vacio \n";
		formValidate = false;
	}
	
	/* LOGIN */
	if(login.value == ""){
		errors +="- El campo Login no puede estar vacio \n";
		formValidate = false;
	}
	
	//PASS:
	if(password.value == ""){
		errors +="- El campo Contraseña no puede estar vacio \n";
		formValidate = false;
	}
	
	if(password2.value == "" && password.value != ""){
		errors +="- Tienes que repetir la contraseña \n";
		formValidate = false;
	}
	
	if(password2.value != password.value && password.value != "" && password2.value != ""){
		errors +="- Las contraseñas tienen que ser iguales \n";
		formValidate = false;
	}
	
	//EMAIL:
	if(email.value == ""){
		errors +="- El campo Email no puede estar vacio \n";
		formValidate = false;
	}
	
	//Muestra errores:
	if(errors!=""){
		alert(errors);
	}
	
	return formValidate;
}

function add_follower(user_current,user_suggest,destiny){
	
	var resp = confirm("¿Deseas realmente tapear con " + user_suggest + "?");
	if(resp == true){
		window.location = "AddFollower?user_current=" + user_current + "&user_suggest=" + user_suggest + "&destiny=" + destiny;
	}
}

function delete_follower(user_current,user_suggest,destiny){
	
	var resp = confirm("¿Deseas realmente dejar de tapear con " + user_suggest + "?");
	if(resp == true){
		window.location = "DeleteFollower?user_current=" + user_current + "&user_suggest=" + user_suggest + "&destiny=" + destiny;
	}
}
