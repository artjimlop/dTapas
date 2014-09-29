package domain;

import java.sql.Date;
import java.sql.Time;

public interface IComment extends IActivity {

	String getCommentarie();

	Date getCommentarieDate();

	String getUserCommentarieID();

	Integer getCommentarieID();
	
	Time getCommentarieTime();
	

}