package domain;

import java.sql.Date;


public class Other extends Drink implements IOther  {
	
	private String size;
	private String type;
	private Integer otherID;
	
	public Other(){
		super();
		
		this.size = "";
		this.type = "";
	}
	
	public Other(String productName, Double price, Date date,
			String login, Integer establishmentID, Integer productID,
			String size, String type, Integer otherID){
		
		super(productName, date, price, login, establishmentID, productID);
		
		this.size = size;
		this.type = type;
		this.otherID = otherID;
		
	}
	
	public Other(String productName, Double price,
			String login, Integer establishmentID,
			String size, String type){
		
		super(productName, price, login, establishmentID);
		
		this.size = size;
		this.type = type;
//		this.otherID = otherID;
		
	}

	
	/* (non-Javadoc)
	 * @see domain.IOther#getSize()
	 */
	@Override
	public String getSize() {
		return size;
	}

	
	/* (non-Javadoc)
	 * @see domain.IOther#setSize(java.lang.String)
	 */
	@Override
	public void setSize(String size) {
		this.size = size;
	}

	
	/* (non-Javadoc)
	 * @see domain.IOther#getType()
	 */
	@Override
	public String getType() {
		return type;
	}

	
	/* (non-Javadoc)
	 * @see domain.IOther#setType(java.lang.String)
	 */
	@Override
	public void setType(String type) {
		this.type = type;
	}

	
	/* (non-Javadoc)
	 * @see domain.IOther#getOtherID()
	 */
	@Override
	public Integer getOtherID() {
		return otherID;
	}
		

}
