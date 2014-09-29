package business;

import java.sql.Date;
import java.util.List;

import domain.IProduct;

public interface IBusinessProduct {

	 List<IProduct> getProductByUserLogin(String userLogin);

	 List<IProduct> getProductByEstablisment(
			Integer establishmentID);

	 IProduct getProductByID(Integer productID);

	 List<IProduct> getAllProduct();

	 List<IProduct> getProductByName(String name);

	 List<IProduct> getProductByRegistryDate(Date date);

	 List<IProduct> getProductByPrice(Double price);

	 void deleteProduct(Integer productID);

}