package domain;

import java.sql.Date;
import java.sql.Time;

public interface IEstablishmentScore extends IActivity {

	/* (non-Javadoc)
	 * @see domain.IEstablishmentScore#getQualityScore()
	 */
	Double getQualityScore();

	/* (non-Javadoc)
	 * @see domain.IEstablishmentScore#setQualityScore(java.lang.Double)
	 */
	void setQualityScore(Double qualityScore);

	/* (non-Javadoc)
	 * @see domain.IEstablishmentScore#getServiceScore()
	 */
	Double getServiceScore();

	/* (non-Javadoc)
	 * @see domain.IEstablishmentScore#setServiceScore(java.lang.Double)
	 */
	void setServiceScore(Double serviceScore);

	/* (non-Javadoc)
	 * @see domain.IEstablishmentScore#getCleaningScore()
	 */
	Double getCleaningScore();

	/* (non-Javadoc)
	 * @see domain.IEstablishmentScore#setCleaningScore(java.lang.Double)
	 */
	void setCleaningScore(Double cleaningScore);

	/* (non-Javadoc)
	 * @see domain.IEstablishmentScore#getSizeScore()
	 */
	Double getSizeScore();

	/* (non-Javadoc)
	 * @see domain.IEstablishmentScore#setSizeScore(java.lang.Double)
	 */
	void setSizeScore(Double sizeScore);

	/* (non-Javadoc)
	 * @see domain.IEstablishmentScore#getLocationScore()
	 */
	Double getLocationScore();

	/* (non-Javadoc)
	 * @see domain.IEstablishmentScore#setLocationScore(java.lang.Double)
	 */
	void setLocationScore(Double locationScore);

	/* (non-Javadoc)
	 * @see domain.IEstablishmentScore#getPriceScore()
	 */
	Double getPriceScore();

	/* (non-Javadoc)
	 * @see domain.IEstablishmentScore#setPriceScore(java.lang.Double)
	 */
	void setPriceScore(Double priceScore);

	/* (non-Javadoc)
	 * @see domain.IEstablishmentScore#getMediumScore()
	 */
	Double getMediumScore();

	/* (non-Javadoc)
	 * @see domain.IEstablishmentScore#getEstablishmentScoreCreationDate()
	 */
	Date getEstablishmentScoreCreationDate();

	/* (non-Javadoc)
	 * @see domain.IEstablishmentScore#getEstablishmentScoreOID()
	 */
	Integer getEstablishmentScoreID();

	/* (non-Javadoc)
	 * @see domain.IEstablishmentScore#getUserOID()
	 */
	String getLogin();

	Integer getEstablishmentID();

	void setEstablishmentOID(Integer establishmentID);
	
	Time getEstablishmentScoreTime();
	

}