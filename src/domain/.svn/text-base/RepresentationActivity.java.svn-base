package domain;

import java.sql.Date;
import java.sql.Time;

public class RepresentationActivity implements IRepresentationActivity {
	
	private Integer representationActivity;
	
	private Double mediumScore;
	private Double presentationScore;
	private Double quantityScore;
	private Double priceScore;
	private Date date;
	private Time time;
	private String userLogin;
	private Double qualityScore;
	private Double serviceScore;
	private Double cleaningScore;
	private Double sizeScore;
	private Double locationScore;
	private String comment;
	private String destinityName;
	
	
	public RepresentationActivity(IProductScore productScore, String productName){
		this.representationActivity = 1;
		
		this.mediumScore = productScore.getMediumScore();
		this.presentationScore = productScore.getPresentationScore();
		this.quantityScore = productScore.getQuantityScore();
		this.priceScore = productScore.getPriceScore();
		this.date = productScore.getScoreDate();
		this.time = productScore.getProductScoreTime();
		this.userLogin = productScore.getLogin();
		this.destinityName = productName;
	}
	
	public RepresentationActivity(IEstablishmentScore establishmentScore, String establishmentName){
		this.representationActivity = 2;
		
		this.mediumScore = establishmentScore.getMediumScore();
		this.qualityScore = establishmentScore.getQualityScore();
		this.serviceScore = establishmentScore.getServiceScore();
		this.cleaningScore = establishmentScore.getCleaningScore();
		this.sizeScore = establishmentScore.getSizeScore();
		this.locationScore = establishmentScore.getLocationScore();
		this.priceScore = establishmentScore.getPriceScore();
		this.date = establishmentScore.getEstablishmentScoreCreationDate();
		this.time = establishmentScore.getEstablishmentScoreTime();
		this.destinityName = establishmentName;
		this.userLogin = establishmentScore.getLogin();
	}
	
	public RepresentationActivity(IProductComment productComment, String productName){
		this.representationActivity = 3;
		
		this.comment = productComment.getCommentarie();
		this.date = productComment.getCommentarieDate();
		this.time = productComment.getCommentarieTime();
		this.userLogin = productComment.getUserCommentarieID();
		this.destinityName = productName;
	}
	
	
	public RepresentationActivity(IEstablishmentComment establishmentComment, String establishmentName){
		this.representationActivity = 4;
		
		this.comment = establishmentComment.getCommentarie();
		this.date = establishmentComment.getCommentarieDate();
		this.time = establishmentComment.getCommentarieTime();
		this.userLogin = establishmentComment.getUserCommentarieID();
		this.destinityName = establishmentName;
	}
	
	public RepresentationActivity(IUserComment userComment){
		this.representationActivity = 5;
		
		this.comment = userComment.getCommentarie();
		this.date = userComment.getCommentarieDate();
		this.time = userComment.getCommentarieTime();
		this.userLogin = userComment.getUserCommentarieID();
		this.destinityName = userComment.getLoginOverWriter();
	}
	
	public RepresentationActivity(ITapaRouteComment tapaRouteComment, String tapaRouteName){
		this.representationActivity = 6;
		
		this.comment = tapaRouteComment.getCommentarie();
		this.date = tapaRouteComment.getCommentarieDate();
		this.time = tapaRouteComment.getCommentarieTime();
		this.userLogin = tapaRouteComment.getUserCommentarieID();
		this.destinityName = tapaRouteName;
	}

	/* (non-Javadoc)
	 * @see domain.IRepresentationActivity#getMediumScore()
	 */
	public Double getMediumScore() {
		return mediumScore;
	}


	/* (non-Javadoc)
	 * @see domain.IRepresentationActivity#getPresentationScore()
	 */
	public Double getPresentationScore() {
		return presentationScore;
	}


	/* (non-Javadoc)
	 * @see domain.IRepresentationActivity#getQuantityScore()
	 */
	public Double getQuantityScore() {
		return quantityScore;
	}


	/* (non-Javadoc)
	 * @see domain.IRepresentationActivity#getPriceScore()
	 */
	public Double getPriceScore() {
		return priceScore;
	}


	/* (non-Javadoc)
	 * @see domain.IRepresentationActivity#getScoreDate()
	 */
	public Date getScoreDate() {
		return date;
	}


	/* (non-Javadoc)
	 * @see domain.IRepresentationActivity#getScoreTime()
	 */
	public Time getScoreTime() {
		return time;
	}


	/* (non-Javadoc)
	 * @see domain.IRepresentationActivity#getUserLogin()
	 */
	public String getUserLogin() {
		return userLogin;
	}

	/* (non-Javadoc)
	 * @see domain.IRepresentationActivity#getDate()
	 */
	public Date getDate() {
		return date;
	}

	/* (non-Javadoc)
	 * @see domain.IRepresentationActivity#getTime()
	 */
	public Time getTime() {
		return time;
	}

	/* (non-Javadoc)
	 * @see domain.IRepresentationActivity#getQualityScore()
	 */
	public Double getQualityScore() {
		return qualityScore;
	}

	/* (non-Javadoc)
	 * @see domain.IRepresentationActivity#getServiceScore()
	 */
	public Double getServiceScore() {
		return serviceScore;
	}

	/* (non-Javadoc)
	 * @see domain.IRepresentationActivity#getCleaningScore()
	 */
	public Double getCleaningScore() {
		return cleaningScore;
	}

	/* (non-Javadoc)
	 * @see domain.IRepresentationActivity#getSizeScore()
	 */
	public Double getSizeScore() {
		return sizeScore;
	}

	/* (non-Javadoc)
	 * @see domain.IRepresentationActivity#getLocationScore()
	 */
	public Double getLocationScore() {
		return locationScore;
	}

	/* (non-Javadoc)
	 * @see domain.IRepresentationActivity#getComment()
	 */
	public String getComment() {
		return comment;
	}

	/* (non-Javadoc)
	 * @see domain.IRepresentationActivity#getRepresentationActivity()
	 */
	public Integer getRepresentationActivity() {
		return representationActivity;
	}

	/* (non-Javadoc)
	 * @see domain.IRepresentationActivity#getDestinityName()
	 */
	public String getDestinityName() {
		return destinityName;
	}
	
	
	
	
	
	

}
