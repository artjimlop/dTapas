package business;

import java.util.List;

import domain.Beer;
import domain.IBeer;

public interface IBusinessBeer {

	 List<IBeer> getAllBeers();

	//Beer getBeerByProduct(Integer PRODOID);

	 IBeer getBeerByProduct(Integer productID);

	 List<IBeer> getBeersByColor(String color);

	//List<Beer> getBeersBySize(String size);
	 List<IBeer> getBeersBySize(String size);

	//List<Beer> getBeersByTemperature(Integer temperature);
	 List<IBeer> getBeersByTemperature(String temperature);

	//List<Beer> getBeersBylabel(String label);
	 List<IBeer> getBeersBylabel(String label);

	//Beer getBeerByOID(Integer CEROID);
	 IBeer getBeerByID(Integer beerID);

	 void insertBeer(String productName, Double price,
			String userCreatorlogin, Integer establishmentID, String size,
			String label, String color, String temperature);

	 void updateBeer(Beer beer);

	 void deleteBeer(Integer beerID);

}