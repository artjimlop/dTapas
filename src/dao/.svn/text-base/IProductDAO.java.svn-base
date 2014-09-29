package dao;

import java.sql.Date;
import java.util.List;

import domain.IProduct;

/**
 * 
 * @author David Alanis
 *
 */

public interface IProductDAO {
	
	List<IProduct> getAllProduct();
	
	List<IProduct> getProductByName(String name);
	List<IProduct> getProductByRegistryDate(Date date);
	List<IProduct> getProductByPrice(Double price);
	
	List<IProduct> getProductByCreatorUser(String USOID);
	List<IProduct> getProductByEstablishment(String ESTOID);
	IProduct getProductByPROID(String PROID);
	
	List<IProduct> getProductByUserLogin(String userLogin);
	List<IProduct> getProductByEstablisment(Integer establishmentID);
	IProduct getProductByID(Integer productID);
	
	void insertProduct(IProduct product, String productOID); //sera llamado por las clases hijas
	void updateProduct(IProduct product);
	void deleteProduct(Integer productID);
	
	String getProductOIDByID(Integer productID);

}
