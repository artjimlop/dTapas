package domain;

import java.sql.Date;



public class Wine extends Drink implements IWine  {
	
	private String type;
	private String od;
	private Integer year;
	private String growUpTime;
	private String label;
	private Integer wineID;
	
	
	public Wine(){
		super();
		
		this.type = "";
		this.od = "";
		this.growUpTime = "";
		this.label = "";
	}
	
	public Wine(String productName, Double price, Date date,
			String login, Integer establishmentID, Integer productID,
			String type, String od, Integer year, String growUpTime, String label,
			Integer wineID){
		
		super(productName, date, price, login, establishmentID, productID);
		
		
		this.type = type;
		this.od = od;
		this.year = year;
		this.growUpTime = growUpTime;
		this.label = label;
		this.wineID = wineID;
			
	}
	
	public Wine(String productName, Double price, 
			String login, Integer establishmentID,
			String type, String od, Integer year, String growUpTime, String label){
		
		super(productName, price, login, establishmentID);
		
		
		this.type = type;
		this.od = od;
		this.year = year;
		this.growUpTime = growUpTime;
		this.label = label;
					
	}

	
	/* (non-Javadoc)
	 * @see domain.IWine#getType()
	 */
	@Override
	public String getType() {
		return type;
	}

	
	/* (non-Javadoc)
	 * @see domain.IWine#setType(java.lang.String)
	 */
	@Override
	public void setType(String type) {
		this.type = type;
	}

	
	/* (non-Javadoc)
	 * @see domain.IWine#getOd()
	 */
	@Override
	public String getOd() {
		return od;
	}

	
	/* (non-Javadoc)
	 * @see domain.IWine#setOd(java.lang.String)
	 */
	@Override
	public void setOd(String od) {
		this.od = od;
	}

	
	/* (non-Javadoc)
	 * @see domain.IWine#getYear()
	 */
	@Override
	public Integer getYear() {
		return year;
	}

	
	/* (non-Javadoc)
	 * @see domain.IWine#setYear(java.lang.Integer)
	 */
	@Override
	public void setYear(Integer year) {
		this.year = year;
	}

	
	/* (non-Javadoc)
	 * @see domain.IWine#getGrowUpTime()
	 */
	@Override
	public String getGrowUpTime() {
		return growUpTime;
	}

	
	/* (non-Javadoc)
	 * @see domain.IWine#setGrowUpTime(java.lang.String)
	 */
	@Override
	public void setGrowUpTime(String growUpTime) {
		this.growUpTime = growUpTime;
	}

	
	/* (non-Javadoc)
	 * @see domain.IWine#getLabel()
	 */
	@Override
	public String getLabel() {
		return label;
	}

	
	/* (non-Javadoc)
	 * @see domain.IWine#setLabel(java.lang.String)
	 */
	@Override
	public void setLabel(String label) {
		this.label = label;
	}

	
	/* (non-Javadoc)
	 * @see domain.IWine#getWineID()
	 */
	@Override
	public Integer getWineID() {
		return wineID;
	}
	
	
}
