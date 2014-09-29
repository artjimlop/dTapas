package domain;

import java.sql.Date;
import java.sql.Time;


/**
 * 
 * @author Arturo Jimenez
 *
 */
public class TapaRouteComment extends Comment implements ITapaRouteComment {
	
	private Integer routeID;
	private Integer tapaRouteCommentID;
	
	public TapaRouteComment(){
		super();
	}
	/*
	public TapaRouteComment(String comment, String TAPAROUTECOMMENTOID,
			String USOID, String ROUTEOID, String COMMENTOID){
		super(comment,USOID, COMMENTOID);
		this.TAPAROUTECOMMENTOID=TAPAROUTECOMMENTOID;
		this.ROUTEOID=ROUTEOID;
	}
	*/
	public TapaRouteComment(String comment, Date commentDate, Time commentTime, Integer tapaRouteCommentID,
			String login, Integer routeID, Integer commentID){
		
		super(comment, commentDate,commentTime, login, commentID);
		this.tapaRouteCommentID=tapaRouteCommentID;
		this.routeID=routeID;
	}
	
	
	//Insert: String comment, String USOID, String COMMENTOID
	public TapaRouteComment(String comment, String login, Integer routeID){
		super(comment,login);
		this.routeID=routeID;
	}
	
	
	
	/* (non-Javadoc)
	 * @see domain.ITapaRouteComment#getTapaRouteID()
	 */
	public Integer getTapaRouteID() {
		return routeID;
	}

	
	/* (non-Javadoc)
	 * @see domain.ITapaRouteComment#getTapaRouteCommentID()
	 */
	public Integer getTapaRouteCommentID() {
		return tapaRouteCommentID;
	}
	
}
