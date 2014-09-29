package domain;

import java.sql.Date;
import java.sql.Time;
import java.util.Calendar;
/**
 * 
 * @author Arturo Jimenez
 *
 */
public class EstablishmentScore implements IEstablishmentScore  {
	
	private Double mediumScore;
	private Double qualityScore;
	private Double serviceScore;
	private Double cleaningScore;
	private Double sizeScore;
	private Double locationScore;
	private Double priceScore;
	private Date establishmentScoreCreationDate;
	private Time establishmentScoreCreationTime;
	private Integer establishmentScoreID;
	private String login;
	private Integer establishmentID;
	
	public EstablishmentScore(){
		
		establishmentScoreCreationDate = new java.sql.Date(Calendar.getInstance().getTimeInMillis());
		establishmentScoreCreationTime = new java.sql.Time(Calendar.getInstance().getTimeInMillis());
	}
	/*
	public EstablishmentScore(Integer i){
		
		establishmentScoreCreationDate = new java.sql.Date(Calendar.getInstance().getTimeInMillis());
		establishmentScoreOID +=i.toString();
	}
	*/
	public EstablishmentScore(Double qualityScore, Double serviceScore,
			Double cleaningScore, Double sizeScore, Double locationScore,
			Double priceScore, Integer establishmentScoreID, String login) {

		this.qualityScore = qualityScore;
		this.serviceScore = serviceScore;
		this.cleaningScore = cleaningScore;
		this.sizeScore = sizeScore;
		this.locationScore = locationScore;
		this.priceScore = priceScore;
		this.establishmentScoreID = establishmentScoreID;
		this.login = login;
		this.establishmentScoreCreationDate = new java.sql.Date(Calendar.getInstance().getTimeInMillis());
		this.establishmentScoreCreationTime = new java.sql.Time(Calendar.getInstance().getTimeInMillis());
		this.mediumScore = (qualityScore + serviceScore + cleaningScore + sizeScore + 
				locationScore + priceScore)/6;
	}



	public EstablishmentScore(Double qualityScore, Double serviceScore,
			Double cleaningScore, Double sizeScore, Double locationScore,
			Double priceScore,
			Date date,Time time, String login , Integer establishmentID) {
			
		this.qualityScore = qualityScore;
		this.serviceScore = serviceScore;
		this.cleaningScore = cleaningScore;
		this.sizeScore = sizeScore;
		this.locationScore = locationScore;
		this.priceScore = priceScore;
		this.login = login;
		this.establishmentScoreCreationDate=date;
		this.establishmentScoreCreationTime = time;
		this.establishmentID=establishmentID;
		this.mediumScore = (qualityScore + serviceScore + cleaningScore + sizeScore + 
				locationScore + priceScore)/6;
	}


	public EstablishmentScore(Double mediumScore, Double qualityScore, Double serviceScore,
			Double cleaningScore, Double sizeScore, Double locationScore,
			Double priceScore,
			Date date,Time time, Integer establishmentScoreID, String login , Integer establishmentID) {
		
		this.mediumScore=mediumScore;
		this.qualityScore = qualityScore;
		this.serviceScore = serviceScore;
		this.cleaningScore = cleaningScore;
		this.sizeScore = sizeScore;
		this.locationScore = locationScore;
		this.priceScore = priceScore;
		this.login = login;
		this.establishmentScoreCreationDate=date;
		this.establishmentScoreCreationTime = time;
		this.establishmentID=establishmentID;
		this.establishmentScoreID = establishmentScoreID;
	}
	
	public EstablishmentScore(Double qualityScore, 
			Double serviceScore, Double cleaningScore, Double sizeScore, Double locationScore,
			Double priceScore, Integer establishmentScoreID, String login , Integer establishmentID){
		this.qualityScore = qualityScore;
		this.serviceScore = serviceScore;
		this.cleaningScore = cleaningScore;
		this.sizeScore = sizeScore;
		this.locationScore = locationScore;
		this.priceScore = priceScore;
		this.establishmentScoreID = establishmentScoreID;
		this.login = login;
		this.establishmentScoreCreationDate = new java.sql.Date(Calendar.getInstance().getTimeInMillis());
		this.mediumScore = (qualityScore + serviceScore + cleaningScore + sizeScore + 
				locationScore + priceScore)/6;
	}
	/* (non-Javadoc)
	 * @see domain.IEstablishmentScore#getQualityScore()
	 */
	/* (non-Javadoc)
	 * @see domain.IEstablishmentScore#getQualityScore()
	 */
	@Override
	public Double getQualityScore() {
		return qualityScore;
	}



	/* (non-Javadoc)
	 * @see domain.IEstablishmentScore#setQualityScore(java.lang.Double)
	 */
	/* (non-Javadoc)
	 * @see domain.IEstablishmentScore#setQualityScore(java.lang.Double)
	 */
	@Override
	public void setQualityScore(Double qualityScore) {
		this.qualityScore = qualityScore;
	}



	/* (non-Javadoc)
	 * @see domain.IEstablishmentScore#getServiceScore()
	 */
	/* (non-Javadoc)
	 * @see domain.IEstablishmentScore#getServiceScore()
	 */
	@Override
	public Double getServiceScore() {
		return serviceScore;
	}



	/* (non-Javadoc)
	 * @see domain.IEstablishmentScore#setServiceScore(java.lang.Double)
	 */
	/* (non-Javadoc)
	 * @see domain.IEstablishmentScore#setServiceScore(java.lang.Double)
	 */
	@Override
	public void setServiceScore(Double serviceScore) {
		this.serviceScore = serviceScore;
	}



	/* (non-Javadoc)
	 * @see domain.IEstablishmentScore#getCleaningScore()
	 */
	/* (non-Javadoc)
	 * @see domain.IEstablishmentScore#getCleaningScore()
	 */
	@Override
	public Double getCleaningScore() {
		return cleaningScore;
	}



	/* (non-Javadoc)
	 * @see domain.IEstablishmentScore#setCleaningScore(java.lang.Double)
	 */
	/* (non-Javadoc)
	 * @see domain.IEstablishmentScore#setCleaningScore(java.lang.Double)
	 */
	@Override
	public void setCleaningScore(Double cleaningScore) {
		this.cleaningScore = cleaningScore;
	}



	/* (non-Javadoc)
	 * @see domain.IEstablishmentScore#getSizeScore()
	 */
	/* (non-Javadoc)
	 * @see domain.IEstablishmentScore#getSizeScore()
	 */
	@Override
	public Double getSizeScore() {
		return sizeScore;
	}



	/* (non-Javadoc)
	 * @see domain.IEstablishmentScore#setSizeScore(java.lang.Double)
	 */
	/* (non-Javadoc)
	 * @see domain.IEstablishmentScore#setSizeScore(java.lang.Double)
	 */
	@Override
	public void setSizeScore(Double sizeScore) {
		this.sizeScore = sizeScore;
	}



	/* (non-Javadoc)
	 * @see domain.IEstablishmentScore#getLocationScore()
	 */
	/* (non-Javadoc)
	 * @see domain.IEstablishmentScore#getLocationScore()
	 */
	@Override
	public Double getLocationScore() {
		return locationScore;
	}



	/* (non-Javadoc)
	 * @see domain.IEstablishmentScore#setLocationScore(java.lang.Double)
	 */
	/* (non-Javadoc)
	 * @see domain.IEstablishmentScore#setLocationScore(java.lang.Double)
	 */
	@Override
	public void setLocationScore(Double locationScore) {
		this.locationScore = locationScore;
	}



	/* (non-Javadoc)
	 * @see domain.IEstablishmentScore#getPriceScore()
	 */
	/* (non-Javadoc)
	 * @see domain.IEstablishmentScore#getPriceScore()
	 */
	@Override
	public Double getPriceScore() {
		return priceScore;
	}



	/* (non-Javadoc)
	 * @see domain.IEstablishmentScore#setPriceScore(java.lang.Double)
	 */
	/* (non-Javadoc)
	 * @see domain.IEstablishmentScore#setPriceScore(java.lang.Double)
	 */
	@Override
	public void setPriceScore(Double priceScore) {
		this.priceScore = priceScore;
	}



	/* (non-Javadoc)
	 * @see domain.IEstablishmentScore#getMediumScore()
	 */
	/* (non-Javadoc)
	 * @see domain.IEstablishmentScore#getMediumScore()
	 */
	@Override
	public Double getMediumScore() {
		return mediumScore;
	}



	/* (non-Javadoc)
	 * @see domain.IEstablishmentScore#getEstablishmentScoreCreationDate()
	 */
	/* (non-Javadoc)
	 * @see domain.IEstablishmentScore#getEstablishmentScoreCreationDate()
	 */
	@Override
	public Date getEstablishmentScoreCreationDate() {
		return establishmentScoreCreationDate;
	}



	/* (non-Javadoc)
	 * @see domain.IEstablishmentScore#getEstablishmentScoreOID()
	 */
	/* (non-Javadoc)
	 * @see domain.IEstablishmentScore#getEstablishmentScoreID()
	 */
	@Override
	public Integer getEstablishmentScoreID() {
		return establishmentScoreID;
	}



	/* (non-Javadoc)
	 * @see domain.IEstablishmentScore#getUserOID()
	 */
	/* (non-Javadoc)
	 * @see domain.IEstablishmentScore#getLogin()
	 */
	@Override
	public String getLogin() {
		return login;
	}
	
	/* (non-Javadoc)
	 * @see domain.IEstablishmentScore#getEstablishmentID()
	 */
	public Integer getEstablishmentID() {
		return establishmentID;
	}

	/* (non-Javadoc)
	 * @see domain.IEstablishmentScore#setEstablishmentOID(java.lang.Integer)
	 */
	public void setEstablishmentOID(Integer establishmentID) {
		this.establishmentID = establishmentID;
	}
	
	public Time getEstablishmentScoreTime(){
		return this.establishmentScoreCreationTime;
	}


	
}
