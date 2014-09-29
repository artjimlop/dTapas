package domain;

import java.sql.Date;
import java.sql.Time;
import java.util.Calendar;

public class ProductScore implements IProductScore  {

	private Double mediumScore;
	private Double presentationScore;
	private Double quantityScore;
	private Double priceScore;
	private Date scoreDate;
	private Time scoreTime;
	private String login;
	private Integer productID;
	private Integer productScoreID;
	
	public ProductScore(Double presentationScore, 
			Double quantityScore, Double priceScore, String login, Integer productID) {
		this.presentationScore = presentationScore;
		this.quantityScore = quantityScore;
		this.priceScore = priceScore;
		this.login = login;
		this.productID = productID;
		this.scoreDate = new java.sql.Date(Calendar.getInstance().getTimeInMillis());
		this.scoreTime = new java.sql.Time(Calendar.getInstance().getTimeInMillis());
		this.mediumScore = (presentationScore + quantityScore + priceScore)/3;
	}
	
//	public ProductScore(Double presentationScore,
//			Double quantityScore, Double priceScore, String userOID,
//			String productOID, String productScoreOID) {
//
//		this.presentationScore = presentationScore;
//		this.quantityScore = quantityScore;
//		this.priceScore = priceScore;
//		this.userOID = userOID;
//		this.productOID = productOID;
//		this.productScoreOID = productScoreOID;
//		this.scoreDate = new java.sql.Date(Calendar.getInstance().getTimeInMillis());
//		this.mediumScore = (presentationScore + quantityScore + priceScore)/3;
//	}

	public ProductScore(Double mediumScore ,Double presentationScore, Double quantityScore, 
			Double priceScore, Date scoreDate,Time scoreTime, String login, Integer productID, Integer productScoreID) {
		this.presentationScore = presentationScore;
		this.quantityScore = quantityScore;
		this.priceScore = priceScore;
		this.login = login;
		this.productID = productID;
		this.productScoreID = productScoreID;
		this.scoreDate = scoreDate;
		this.scoreTime = scoreTime;
		this.mediumScore = mediumScore;
	}

	/* (non-Javadoc)
	 * @see domain.IProductScore#getPresentationScore()
	 */
	@Override
	public Double getPresentationScore() {
		return presentationScore;
	}
	
	/* (non-Javadoc)
	 * @see domain.IProductScore#setPresentationScore(java.lang.Double)
	 */
	@Override
	public void setPresentationScore(Double presentationScore) {
		this.presentationScore = presentationScore;
	}
	
	/* (non-Javadoc)
	 * @see domain.IProductScore#getQuantityScore()
	 */
	@Override
	public Double getQuantityScore() {
		return quantityScore;
	}

	/* (non-Javadoc)
	 * @see domain.IProductScore#setQuantityScore(java.lang.Double)
	 */
	@Override
	public void setQuantityScore(Double quantityScore) {
		this.quantityScore = quantityScore;
	}
	
	/* (non-Javadoc)
	 * @see domain.IProductScore#getPriceScore()
	 */
	@Override
	public Double getPriceScore() {
		return priceScore;
	}
	
	/* (non-Javadoc)
	 * @see domain.IProductScore#setPriceScore(java.lang.Double)
	 */
	@Override
	public void setPriceScore(Double priceScore) {
		this.priceScore = priceScore;
	}

	/* (non-Javadoc)
	 * @see domain.IProductScore#getMediumScore()
	 */
	@Override
	public Double getMediumScore() {
		return mediumScore;
	}
	
	/* (non-Javadoc)
	 * @see domain.IProductScore#getScoreDate()
	 */
	@Override
	public Date getScoreDate() {
		return scoreDate;
	}
	
	/* (non-Javadoc)
	 * @see domain.IProductScore#getLogin()
	 */
	@Override
	public String getLogin() {
		return login;
	}
	
	/* (non-Javadoc)
	 * @see domain.IProductScore#getProductID()
	 */
	@Override
	public Integer getProductID() {
		return productID;
	}
	
	/* (non-Javadoc)
	 * @see domain.IProductScore#getProductScoreID()
	 */
	@Override
	public Integer getProductScoreID() {
		return productScoreID;
	}

	@Override
	public Time getProductScoreTime() {
		return this.scoreTime;
	}
	

}
