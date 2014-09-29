package domain;

import java.sql.Date;
import java.util.Calendar;

public class Establishment implements IEstablishment  {
	
	private String nameEstablishment;
	private String city;
	private String province;
	private String zone;
	private String street;
	private Integer zipCode;
	private Date registryDate;
	private String userLogin;
	private Integer establishmentID;
	
	
	public Establishment(){
		
		this.nameEstablishment = "";
		this.city = "";
		this.province = "";
		this.zone = "";
		this.street = "";
		this.registryDate = new java.sql.Date(Calendar.getInstance().getTimeInMillis());
		
	}
	
	public Establishment(String nameEstablishment, String city, String province,
			String zone, String street, Integer zipCode,Date date, String userLogin, Integer establishmentID) {
		
		this.nameEstablishment = nameEstablishment;
		this.city = city;
		this.province = province;
		this.zone = zone;
		this.street = street;
		this.zipCode = zipCode;
		this.registryDate = date;
		this.userLogin = userLogin;
		this.establishmentID = establishmentID;
	}
	
	public Establishment(String nameEstablishment, String city, String province,
			String zone, String street, Integer zipCode, String userLogin){
		
		this.nameEstablishment = nameEstablishment;
		this.city = city;
		this.province = province;
		this.zone = zone;
		this.street = street;
		this.zipCode = zipCode;
		this.registryDate = new java.sql.Date(Calendar.getInstance().getTimeInMillis());
		this.userLogin = userLogin;
		
	}
	
	/* (non-Javadoc)
	 * @see domain.IEstablishment#getNameEstablishment()
	 */
	@Override
	public String getNameEstablishment() {
		return nameEstablishment;
	}

	/* (non-Javadoc)
	 * @see domain.IEstablishment#setNameEstablishment(java.lang.String)
	 */
	@Override
	public void setNameEstablishment(String nameEstablishment) {
		this.nameEstablishment = nameEstablishment;
	}

	/* (non-Javadoc)
	 * @see domain.IEstablishment#getCity()
	 */
	@Override
	public String getCity() {
		return city;
	}

	/* (non-Javadoc)
	 * @see domain.IEstablishment#setCity(java.lang.String)
	 */
	@Override
	public void setCity(String city) {
		this.city = city;
	}
	
	/* (non-Javadoc)
	 * @see domain.IEstablishment#getProvince()
	 */
	@Override
	public String getProvince() {
		return province;
	}

	/* (non-Javadoc)
	 * @see domain.IEstablishment#setProvince(java.lang.String)
	 */
	@Override
	public void setProvince(String province) {
		this.province = province;
	}

	/* (non-Javadoc)
	 * @see domain.IEstablishment#getZone()
	 */
	@Override
	public String getZone() {
		return zone;
	}

	/* (non-Javadoc)
	 * @see domain.IEstablishment#setZone(java.lang.String)
	 */
	@Override
	public void setZone(String zone) {
		this.zone = zone;
	}

	/* (non-Javadoc)
	 * @see domain.IEstablishment#getStreet()
	 */
	@Override
	public String getStreet() {
		return this.street;
	}

	/* (non-Javadoc)
	 * @see domain.IEstablishment#setStreet(java.lang.String)
	 */
	@Override
	public void setStreet(String street) {
		this.street = street;
	}

	/* (non-Javadoc)
	 * @see domain.IEstablishment#getZipCode()
	 */
	@Override
	public Integer getZipCode() {
		return this.zipCode;
	}

	/* (non-Javadoc)
	 * @see domain.IEstablishment#setZipCode(java.lang.Integer)
	 */
	@Override
	public void setZipCode(Integer zipCode) {
		this.zipCode = zipCode;
	}

	/* (non-Javadoc)
	 * @see domain.IEstablishment#getRegistryDate()
	 */
	@Override
	public Date getRegistryDate() {
		return this.registryDate;
	}

	/* (non-Javadoc)
	 * @see domain.IEstablishment#getUserLogin()
	 */
	@Override
	public String getUserLogin() {
		return this.userLogin;
	}
	
	/* (non-Javadoc)
	 * @see domain.IEstablishment#getEstablishmentID()
	 */
	@Override
	public Integer getEstablishmentID() {
		return this.establishmentID;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Establishment other = (Establishment) obj;
		if (establishmentID == null) {
			if (other.establishmentID != null)
				return false;
		} else if (!establishmentID.equals(other.establishmentID))
			return false;
		return true;
	}
	
}
