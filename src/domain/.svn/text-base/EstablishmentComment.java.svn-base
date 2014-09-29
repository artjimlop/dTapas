package domain;

import java.sql.Date;
import java.sql.Time;

public class EstablishmentComment extends Comment implements IEstablishmentComment  {

	private Integer ESTID;
	private Integer COMNTESTID;

	
	public EstablishmentComment(){
		super();
	}
	
	public EstablishmentComment(String comment, Date commentDate,Time commentTime, Integer COMID, String login,
			Integer ESTID, Integer COMNTESTID){
		super(comment,commentDate,commentTime,login,COMID);
		this.ESTID=ESTID;
		this.COMNTESTID=COMNTESTID;
	}

	public EstablishmentComment(String comment, Integer COMID, String login,
			Integer ESTID, Integer COMNTESTID){
		super(comment,login);

		this.ESTID=ESTID;
		this.COMNTESTID=COMNTESTID;
	}

	public EstablishmentComment(String comment, String login,
			Integer ESTID){
		super(comment,login);

		this.ESTID=ESTID;
//		this.COMNTESTID=COMNTESTID;
	}


	/* (non-Javadoc)
	 * @see domain.IEstablishmentComment#getEstablishmentID()
	 */
	@Override
	public Integer getEstablishmentID() {
		
		return ESTID;
	}

	/* (non-Javadoc)
	 * @see domain.IEstablishmentComment#getEstablishmentCommentID()
	 */
	@Override
	public Integer getEstablishmentCommentID() {
		
		return COMNTESTID;
	}
	
}

