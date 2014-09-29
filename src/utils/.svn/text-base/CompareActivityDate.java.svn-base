package utils;

import java.sql.Date;
import java.sql.Time;
import java.util.Comparator;

import domain.Comment;
import domain.EstablishmentScore;
import domain.IActivity;
import domain.IComment;
import domain.IEstablishmentScore;
import domain.IProductScore;
import domain.ProductScore;

public class CompareActivityDate implements Comparator<IActivity>{

	private Date getActivityDate(IActivity activity){
		Date date = null;
		if(activity instanceof IComment){
			date = ((Comment)activity).getCommentarieDate();
		}
		if(activity instanceof IProductScore){
			date = ((ProductScore)activity).getScoreDate();
		}
		if(activity instanceof IEstablishmentScore){
			date = ((EstablishmentScore)activity).getEstablishmentScoreCreationDate();
		}
		
		return date;
	}
	
	private Time getActivityTime(IActivity activity){
		Time time = null;
		if(activity instanceof IComment){
			time = ((Comment)activity).getCommentarieTime();
		}
		if(activity instanceof IProductScore){
			time = ((ProductScore)activity).getProductScoreTime();
		}
		if(activity instanceof IEstablishmentScore){
			time = ((EstablishmentScore)activity).getEstablishmentScoreTime();
		}
		
		return time;
	}
	public int compare(IActivity o1, IActivity o2) {
		Integer compare = 0;
		Date dateActivityOne = getActivityDate(o1);
		Time timeActivitOne = getActivityTime(o1);
		Date dateActivityTwo = getActivityDate(o2);
		Time timeActivitTwo = getActivityTime(o2);
		
		if(dateActivityOne.equals(dateActivityTwo)){
			compare = timeActivitOne.compareTo(timeActivitTwo);
		}else{
			compare = dateActivityOne.compareTo(dateActivityTwo);
		}
		
		return compare;
			
	}
	

}
