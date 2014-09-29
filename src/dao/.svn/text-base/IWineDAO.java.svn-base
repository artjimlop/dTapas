package dao;


import java.util.List;

import domain.IWine;

public interface IWineDAO {

	List<IWine> getAllWines();
	IWine getWineByProduct(Integer PRODID);
	List<IWine> getWinesByType(String type);
	List<IWine> getWinesByOd(String od);
	List<IWine> getWinesByYear(Integer year);
	List<IWine> getWinesBygrowuptime(String growuptime);
	List<IWine> getWinesBylabel(String label);
	IWine getWineByOID(String WINEOID);
	IWine getWineByID(Integer wineID);
	String getWineOIDByID(Integer wineID);
	void insertWine(IWine Wine);
	void updateWine(IWine wine);
	void deleteWine(Integer wineID);
	
}
