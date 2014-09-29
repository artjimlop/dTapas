package domain;

import java.sql.Date;
import java.util.Calendar;

/**
 * 
 * @author David Alanis
 *
 */

public class Product implements IProduct {
	
	private String productName;
	private Date registryDate;
	private Double price;
	private String userLoginID;
	private Integer establishmentID;
	private Integer productID;
	
	public Product(){
		
		this.productName = "";
		this.registryDate = new java.sql.Date(Calendar.getInstance().getTimeInMillis());
	}
	
	
	//Constructor que se llama desde el BO --> en el JDB es donde añadimos el ID de product
	public Product(String productName, Double price,
			String userLoginID, Integer establishmentID) {
		super();
		this.productName = productName;
		this.registryDate = new java.sql.Date(Calendar.getInstance().getTimeInMillis());
		this.price = price;
		this.userLoginID = userLoginID;
		this.establishmentID = establishmentID;
	}
	
	//Constructor que usamos desde las consultas a la BD
	public Product(String productName,Date date, Double price,
			String userLoginID, Integer establishmentID, Integer productID) {
		super();
		this.productName = productName;
		this.registryDate = date;
		this.price = price;
		this.userLoginID = userLoginID;
		this.establishmentID = establishmentID;
		this.productID = productID;
	}



	
	/* (non-Javadoc)
	 * @see domain.IProduct#getProductName()
	 */
	@Override
	public String getProductName() {
		return productName;
	}



	
	/* (non-Javadoc)
	 * @see domain.IProduct#setProductName(java.lang.String)
	 */
	@Override
	public void setProductName(String productName) {
		this.productName = productName;
	}



	
	/* (non-Javadoc)
	 * @see domain.IProduct#getPrice()
	 */
	@Override
	public Double getPrice() {
		return this.price;
	}



	
	/* (non-Javadoc)
	 * @see domain.IProduct#setPrice(java.lang.Double)
	 */
	@Override
	public void setPrice(Double price) {
		this.price = price;
	}



	
	/* (non-Javadoc)
	 * @see domain.IProduct#getRegistryDate()
	 */
	@Override
	public Date getRegistryDate() {
		return this.registryDate;
	}


	
	/* (non-Javadoc)
	 * @see domain.IProduct#getUserLoginID()
	 */
	@Override
	public String getUserLoginID() {
		return this.userLoginID;
	}



	
	/* (non-Javadoc)
	 * @see domain.IProduct#getEstablishmentID()
	 */
	@Override
	public Integer getEstablishmentID() {
		return this.establishmentID;
	}



	
	/* (non-Javadoc)
	 * @see domain.IProduct#getProductID()
	 */
	@Override
	public Integer getProductID() {
		return this.productID;
	}

	


}
