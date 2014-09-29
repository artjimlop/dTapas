package domain;

import java.sql.Date;




/**
 * 
 * @author David Alanis
 *
 */

public class Food extends Product implements IFood {
	
	private String type;
	private Integer foodID;
	
	
	
	public Food(){
		this.type = "";
	}
	
	public Food(String productName, Double price, Date date,
			String login, Integer establishmentID, Integer productID,
			String type, Integer foodID){
		
		super(productName, date, price, login, establishmentID, productID);
		
		this.type = type;
		this.foodID = foodID;
		
	}
	
	public Food(String productName, Double price, 
			String login, Integer establishmentID, 
			String type){
		
		super(productName, price, login, establishmentID);
		
		this.type = type;
			
		
	}

	
	/* (non-Javadoc)
	 * @see domain.IFood#getType()
	 */
	@Override
	public String getType() {
		return type;
	}

	
	/* (non-Javadoc)
	 * @see domain.IFood#setType(java.lang.String)
	 */
	@Override
	public void setType(String type) {
		this.type = type;
	}

	
	/* (non-Javadoc)
	 * @see domain.IFood#getFoodID()
	 */
	@Override
	public Integer getFoodID() {
		return foodID;
	}
	
}
