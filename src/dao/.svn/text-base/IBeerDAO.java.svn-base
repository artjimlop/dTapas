package dao;


import java.util.List;

import domain.IBeer;

public interface IBeerDAO {

	List<IBeer> getAllBeers();
	IBeer getBeerByOID(String BEEROID);	
	IBeer getBeerByProduct(Integer PRODID);
	List<IBeer> getBeersByColor(String color);
	List<IBeer> getBeersBySize(String size);
	List<IBeer> getBeersByTemperature(String temperature);
	List<IBeer> getBeersBylabel(String label);
	IBeer getBeerByID(Integer BEERID);
	String getBeerOIDByID(Integer BEERID);
	void insertBeer(IBeer beer);
	void updateBeer(IBeer beer);
	void deleteBeer(Integer BEERID);
}
