function validar_formulario() {
	
	var formValidate = true;
	
	var name = document.getElementById("input_nameroute");
	var date = document.getElementById("input_targetdate");
	
	//Hay establecimientos?:
	var i=0;
	var establishments = false;
	for(i=0;i<20;i++){
		if(document.getElementById("input_establishment"+i)!=null){
			if(document.getElementById("input_establishment"+i).checked == true){
				establishments = true;
			}
		}
	}
	
	//Hay followers a�adidos?:
	var followers = false;
	var f = 0;
	for(f=0;f<20;f++){
		if(document.getElementById("input_follower"+f)!=null){
			if(document.getElementById("input_follower"+f).checked == true){
				followers = true;
			}
		}
	}
	
	
	//Variable que acumula los errores
	var errors = "";
	
	/* Comprobaciones del nombre */
	if(name.value == ""){
		errors +="- El campo Nombre no puede estar vacio \n";
		formValidate = false;
	}
	
	/* Comprobaciones de date */
	if(date.value == ""){
		errors +="- El campo Fecha no puede estar vacio \n";
		formValidate = false;
	}else if(validate_date(date.value)==false){
		formValidate = false;
	}
	
	/* Al menos debe haber un establecimiento */
	if(establishments == false){
		errors +="- Anyade un establecimiento, anda \n";
		formValidate = false;
	}
	
	/* Al menos debe haber un follower a�adido */
	if(followers == false){
		errors +="- Anyade al menos a un follower, autista \n";
		formValidate = false;
	}
	
	if(errors!=""){
		alert(errors);
	}
	
	return formValidate;
}

function validate_date(date){
	
	var formValidate = true;
	//Convertimos la fecha de "presentacion" a fecha tipo DATE.
	var newDate = date.split("-");
	
	var dia = newDate[0];
	var mes = newDate[1];
	var anyo = newDate[2];
	
	switch (mes) {
	case "Jan":
		mes="01";
		break;
	case "Feb":
		mes="02";
		break;
	case "Mar":
		mes="03";
		break;
	case "Apr":
		mes="04";
		break;
	case "May":
		mes="05";
		break;
	case "Jun":
		mes="06";
		break;
	case "Jul":
		mes="07";
		break;
	case "Aug":
		mes="08";
		break;
	case "Sep":
		mes="09";
		break;
	case "Oct":
		mes="10";
		break;
	case "Nov":
		mes="11";
		break;
	case "Dec":
		mes="12";
		break;

	default:
		break;
	}

	//newDate = anyo + "-" + mes + "-" + dia;
	//Ahora tenemos un array con la DATE:
	var arrayDate = [anyo,mes,dia];
	
	var today = new Date();
	
//	var day = parseInt(arrayDate[2]);
//	var month = parseInt(arrayDate[1]);
	var year = parseInt(arrayDate[0]);
	
	if(year<today.getFullYear()){
		formValidate = false;
		alert("Anyo introducido no valido.");
	}
	
	//parseInt(today.getMonth()+1) por un error en el new date, da un mes menos
	//de en el que estamos.
	//Se le quita por un error al cambiar de mes?
//	if(month<parseInt(today.getMonth()) && year==today.getFullYear()){
//		formValidate = false;
//		alert("Mes introducido no valido, Anyo correcto.");
//	}
//	if(day<today.getDate() && month==parseInt(today.getMonth()) && year==today.getFullYear()){
//		formValidate = false;
//		alert("Dia introducido no valido, el resto correcto.");
//	}
	
	return formValidate;
	
}

function validate_update_form() {

	var formValidate = true;
	
	var name = document.getElementById("input_nameroute");
	var date = document.getElementById("input_routedate");
	
	//Variable que acumula los errores
	var errors = "";
	
	/* Comprobaciones del nombre */
	if(name.value == ""){
		errors +="- El campo Nombre no puede estar vacio \n";
		formValidate = false;
	}else if(name.value.match(/^[^\s()<>@,;:\/]+@\w[\w\.-]+\.{2,}$/i)){  
   	    errores +="- Nombre invalido";
 	}
	
	/* Comprobaciones de date */
	if(date.value == ""){
		errors +="- El campo Fecha no puede estar vacio \n";
		formValidate = false;
	}else if(validate_date(date.value)==false){
		errors +="- Error en la Fecha \n";
		formValidate = false;
	}
	
	if(errors!=""){
		alert(errors);
	}
	
	return formValidate;
}