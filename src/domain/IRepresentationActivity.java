package domain;

import java.sql.Date;
import java.sql.Time;

public interface IRepresentationActivity {

	Double getMediumScore();

	Double getPresentationScore();

	Double getQuantityScore();

	Double getPriceScore();

	Date getScoreDate();

	Time getScoreTime();

	String getUserLogin();

	Date getDate();

	Time getTime();

	Double getQualityScore();

	Double getServiceScore();

	Double getCleaningScore();

	Double getSizeScore();

	Double getLocationScore();

	String getComment();

	Integer getRepresentationActivity();

	String getDestinityName();

}