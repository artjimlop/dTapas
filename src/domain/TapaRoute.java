package domain;

import java.sql.Date;
import java.util.Calendar;

public class TapaRoute implements ITapaRoute  {
	
	private String name;
	private Date registryDate;
	private Date targetDate;
	private String userLogin;
	private Integer tapaRouteID;

	public TapaRoute(){
		
		this.name = "null";
		this.registryDate = new java.sql.Date(Calendar.getInstance().getTimeInMillis());
		this.targetDate = new java.sql.Date(Calendar.getInstance().getTimeInMillis());
		/*this.userTapaRoute = new ArrayList<User>();
		this.establishmentTapaRoute = new ArrayList<Establishment>();
		this.commentsTapaRoute = new ArrayList<TapaRouteComment>();*/
	}
	/*
	public TapaRoute(String tapaRouteOID){
		this.name = "";
		this.registryDate = new java.sql.Date(Calendar.getInstance().getTimeInMillis());
		this.targetDate = new java.sql.Date(Calendar.getInstance().getTimeInMillis());
		this.tapaRouteOID = tapaRouteOID;
	}
*/
	public TapaRoute(String name, Date targetDate, String userLogin) {
		
		this.name = name;
		/*this.userTapaRoute = userTapaRoute;
		this.establishmentTapaRoute = establishmentTapaRoute;
		this.commentsTapaRoute = commentsTapaRoute;*/
		this.userLogin = userLogin;
		this.registryDate = new java.sql.Date(Calendar.getInstance().getTimeInMillis());
		if(targetDate.before(registryDate)){
			this.targetDate = registryDate;
		}else{
			this.targetDate = targetDate;
		}
	}

	public TapaRoute(String name, Date registryDate, Date targetDate, String userLogin,
			Integer tapaRouteID) {
		//super();
		this.name = name;
		this.targetDate = targetDate;
		/*this.userTapaRoute = userTapaRoute;
		this.establishmentTapaRoute = establishmentTapaRoute;
		this.commentsTapaRoute = commentsTapaRoute; */
		this.userLogin = userLogin;
		this.tapaRouteID = tapaRouteID;
		this.registryDate = registryDate;
	}

	
	/* (non-Javadoc)
	 * @see domain.ITapaRoute#getName()
	 */
	@Override
	public String getName() {
		return name;
	}



	
	/* (non-Javadoc)
	 * @see domain.ITapaRoute#setName(java.lang.String)
	 */
	@Override
	public void setName(String name) {
		this.name = name;
	}



	
	/* (non-Javadoc)
	 * @see domain.ITapaRoute#getTargetDate()
	 */
	@Override
	public Date getTargetDate() {
		return targetDate;
	}



	
	/* (non-Javadoc)
	 * @see domain.ITapaRoute#setTargetDate(java.sql.Date)
	 */
	@Override
	public void setTargetDate(Date targetDate) {
		if(targetDate.before(this.registryDate)){
			this.targetDate = new java.sql.Date(Calendar.getInstance().getTimeInMillis());
		}else{
			this.targetDate = targetDate;
		}
	}



	
	/* (non-Javadoc)
	 * @see domain.ITapaRoute#getRegistryDate()
	 */
	@Override
	public Date getRegistryDate() {
		return registryDate;
	}



	
	/* (non-Javadoc)
	 * @see domain.ITapaRoute#getUserLogin()
	 */
	@Override
	public String getUserLogin() {
		return userLogin;
	}



	
	/* (non-Javadoc)
	 * @see domain.ITapaRoute#getTapaRouteID()
	 */
	@Override
	public Integer getTapaRouteID() {
		return tapaRouteID;
	}

	
	
}
