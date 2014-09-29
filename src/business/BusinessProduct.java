package business;

import java.sql.Date;
import java.util.List;

import dao.IProductDAO;
import dao.JDBCProductDAO;
import domain.IProduct;

public class BusinessProduct implements IBusinessProduct {
	
	private IProductDAO productDAO;
	
	public BusinessProduct(){
		
		this.productDAO = new JDBCProductDAO();
		
	}
	
	/* (non-Javadoc)
	 * @see business.IBusinessProduct#getProductByUserLogin(java.lang.String)
	 */
	@Override
	public List<IProduct> getProductByUserLogin(String userLogin){
		
		return this.productDAO.getProductByUserLogin(userLogin);
	}
	
	/* (non-Javadoc)
	 * @see business.IBusinessProduct#getProductByEstablisment(java.lang.Integer)
	 */
	@Override
	public List<IProduct> getProductByEstablisment(Integer establishmentID){
		
		return this.productDAO.getProductByEstablisment(establishmentID);
	}
	
	/* (non-Javadoc)
	 * @see business.IBusinessProduct#getProductByID(java.lang.Integer)
	 */
	@Override
	public IProduct getProductByID(Integer productID){
		
		return this.productDAO.getProductByID(productID);
	}
	
	/* (non-Javadoc)
	 * @see business.IBusinessProduct#getAllProduct()
	 */
	@Override
	public List<IProduct> getAllProduct(){
		
		return this.productDAO.getAllProduct();
	}
	
	/* (non-Javadoc)
	 * @see business.IBusinessProduct#getProductByName(java.lang.String)
	 */
	@Override
	public List<IProduct> getProductByName(String name){
		
		return this.productDAO.getProductByName(name);
	}
	
	/* (non-Javadoc)
	 * @see business.IBusinessProduct#getProductByRegistryDate(java.sql.Date)
	 */
	@Override
	public List<IProduct> getProductByRegistryDate(Date date){
		
		return this.productDAO.getProductByRegistryDate(date);
	}
	
	/* (non-Javadoc)
	 * @see business.IBusinessProduct#getProductByPrice(java.lang.Double)
	 */
	@Override
	public List<IProduct> getProductByPrice(Double price){
		
		return this.productDAO.getProductByPrice(price);
	}
	
	
	/* (non-Javadoc)
	 * @see business.IBusinessProduct#deleteProduct(java.lang.Integer)
	 */
	@Override
	public void deleteProduct(Integer productID){
		
		productDAO.deleteProduct(productID);

	}
}
