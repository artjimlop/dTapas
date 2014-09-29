package domain;

import java.sql.Date;
import java.sql.Time;
import java.util.Calendar;
/**
 * @author Arturo Jimenez
 */
public class Comment implements IComment{
	 
	private String comment;
	private Date commentDate;
	private Time commentTime;
	private String userLogin;
	private Integer commentID;
	
	public Comment(){
		this.comment="";
		this.commentDate = new java.sql.Date(Calendar.getInstance().getTimeInMillis());
		this.commentTime = new java.sql.Time(Calendar.getInstance().getTimeInMillis());
		this.userLogin = "";
	}
	
	public Comment(String comment, String userLogin){
		this.comment=comment;
		this.commentDate= new java.sql.Date(Calendar.getInstance().getTimeInMillis());
		this.commentTime = new java.sql.Time(Calendar.getInstance().getTimeInMillis());
		this.userLogin = userLogin;
	}
	
	
	public Comment(String comment, Date commentDate,Time commentTime, String userLogin, Integer commentID) {
		this.comment=comment;
		this.commentDate= commentDate;
		this.commentTime = commentTime;
		this.userLogin = userLogin;
		this.commentID = commentID;
	}

	/* (non-Javadoc)
	 * @see domain.IComment#getCommentarie()
	 */
	@Override
	public String getCommentarie() {
		return this.comment;
	}

	/* (non-Javadoc)
	 * @see domain.IComment#getCommentarieDate()
	 */
	@Override
	public Date getCommentarieDate() {
		return this.commentDate;
	}

	/* (non-Javadoc)
	 * @see domain.IComment#getUserCommentarieID()
	 */
	@Override
	public String getUserCommentarieID() {
		return this.userLogin;
	}

	/* (non-Javadoc)
	 * @see domain.IComment#getCommentarieID()
	 */
	@Override
	public Integer getCommentarieID() {
		return this.commentID;
	}
	
	public Time getCommentarieTime(){
		return this.commentTime;
	}
	
	
}
