package utils;

import java.sql.Date;
import java.sql.Time;
import java.util.Calendar;

public class Tools {
	
	public static String dateStringToString(String date){
		//yyyy-mm-dd -> dd-mmm-yyyy
		
		String newDate;
		
		String dia = date.substring(0, 4);
		String mes = date.substring(5, 7);
		String anyo = date.substring(8, 10);
		
		mes = mes.toLowerCase();
		switch (mes) {
		case "01":
			mes="Ene";
			break;
		case "02":
			mes="Feb";
			break;
		case "03":
			mes="Mar";
			break;
		case "04":
			mes="Abr";
			break;
		case "05":
			mes="May";
			break;
		case "06":
			mes="Jun";
			break;
		case "07":
			mes="Jul";
			break;
		case "08":
			mes="Ago";
			break;
		case "09":
			mes="Sep";
			break;
		case "10":
			mes="Oct";
			break;
		case "11":
			mes="Nov";
			break;
		case "12":
			mes="Dic";
			break;			

		default:
			break;
		}
		
		newDate = anyo + "-" + mes + "-" + dia;
		
		return newDate;
	}
	
	public static String stringToDateString(String date){		
		//dd-mmm-yyyy -> yyyy-mm-dd
		
		String newDate;
		
		String dia = date.substring(0, 2);
		String mes = date.substring(3, 6);
		String anyo = date.substring(7, 11);
		
		mes = mes.toLowerCase();
		switch (mes) {
		case "jan":
			mes="01";
			break;
		case "feb":
			mes="02";
			break;
		case "mar":
			mes="03";
			break;
		case "apr":
			mes="04";
			break;
		case "may":
			mes="05";
			break;
		case "jun":
			mes="06";
			break;
		case "jul":
			mes="07";
			break;
		case "aug":
			mes="08";
			break;
		case "sep":
			mes="09";
			break;
		case "oct":
			mes="10";
			break;
		case "nov":
			mes="11";
			break;
		case "dec":
			mes="12";
			break;

		default:
			break;
		}
		
		newDate = anyo + "-" + mes + "-" + dia;
		
		return newDate;
	}
	
	@SuppressWarnings("deprecation")
	public static String getIntervalTime(Date date, Time time){
		
		Date actualDate = new java.sql.Date(Calendar.getInstance().getTimeInMillis());
		Time actualTime = new java.sql.Time(Calendar.getInstance().getTimeInMillis());
		Time actualTimeReal = new Time(actualTime.getHours(), actualTime.getMinutes(), actualTime.getSeconds());
 
		String interval = null;
		long intervalDay = actualDate.getTime() - date.getTime();
		long intervalTime = Math.abs(actualTimeReal.getTime() - time.getTime());
		
		if(intervalDay/86400000 != 0){
		interval = ("Hace " + intervalDay/86400000 + " día(s)");
		}else{
			if(intervalTime/3600000>0){
				interval = ("Hace  " + intervalTime/3600000 + " hora(s)" );
				}
			else if(intervalTime/60000>0){
				interval = ("Hace  " + intervalTime/60000 + " minuto(s)");
			}
			else{
				interval = ("Hace  " + intervalTime/1000 + " segundos");	
				}
			}
		return interval;
	}

}
