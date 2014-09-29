package domain;

import java.sql.Date;
import java.sql.Time;

public interface IProductScore  extends IActivity{

	Double getPresentationScore();

	void setPresentationScore(Double presentationScore);

	Double getQuantityScore();

	void setQuantityScore(Double quantityScore);

	Double getPriceScore();

	void setPriceScore(Double priceScore);

	Double getMediumScore();

	Date getScoreDate();

	String getLogin();

	Integer getProductID();

	Integer getProductScoreID();
	
	Time getProductScoreTime();
	

}