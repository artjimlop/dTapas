package domain;

import java.sql.Date;


public class Beer extends Drink implements IBeer {
	
	private String size;
	private String label;
	private String color;
	private String temperature;
	private Integer beerID;
	
	public Beer(){
		super();
		
		this.size = "";
		this.label = "";
		this.color = "";
		this.temperature = "";
	}
	
	public Beer(String productName, Double price, Date date,
			String login, Integer establishmentID, Integer productID,
			String size, String label, String color, String temperature,
			Integer beerID){
		
		super(productName, date, price, login, establishmentID, productID);
		
		this.size = size;
		this.label = label;
		this.color = color;
		this.temperature = temperature;
		this.setBeerID(beerID);
		
	}
	
	
	public Beer(String productName, Double price, 
			String login, Integer establishmentID,
			String size, String label, String color, String temperature){
		
		super(productName, price, login, establishmentID);
		
		this.size = size;
		this.label = label;
		this.color = color;
		this.temperature = temperature;
		this.setBeerID(beerID);
		
	}
	
	/* (non-Javadoc)
	 * @see domain.IBeer#getSize()
	 */
	@Override
	public String getSize() {
		return size;
	}

	
	/* (non-Javadoc)
	 * @see domain.IBeer#setSize(java.lang.String)
	 */
	@Override
	public void setSize(String size) {
		this.size = size;
	}

	
	/* (non-Javadoc)
	 * @see domain.IBeer#getLabel()
	 */
	@Override
	public String getLabel() {
		return label;
	}

	
	/* (non-Javadoc)
	 * @see domain.IBeer#setLabel(java.lang.String)
	 */
	@Override
	public void setLabel(String label) {
		this.label = label;
	}

	
	/* (non-Javadoc)
	 * @see domain.IBeer#getColor()
	 */
	@Override
	public String getColor() {
		return color;
	}

	
	/* (non-Javadoc)
	 * @see domain.IBeer#setColor(java.lang.String)
	 */
	@Override
	public void setColor(String color) {
		this.color = color;
	}

	
	/* (non-Javadoc)
	 * @see domain.IBeer#getTemperature()
	 */
	@Override
	public String getTemperature() {
		return temperature;
	}

	
	/* (non-Javadoc)
	 * @see domain.IBeer#setTemperature(java.lang.String)
	 */
	@Override
	public void setTemperature(String temperature) {
		this.temperature = temperature;
	}

	/* (non-Javadoc)
	 * @see domain.IBeer#getBeerID()
	 */
	public Integer getBeerID() {
		return beerID;
	}

	/* (non-Javadoc)
	 * @see domain.IBeer#setBeerID(java.lang.Integer)
	 */
	public void setBeerID(Integer beerID) {
		this.beerID = beerID;
	}

	


}
