package business;

import java.util.List;

import domain.IWine;
import domain.Wine;

public interface IBusinessWine {

	 List<IWine> getAllWines();

	 List<IWine> getWinesByType(String type);

	 IWine getWineByProduct(Integer prodID);

	 List<IWine> getWinesByOd(String od);

	 List<IWine> getWinesByYear(Integer year);

	 List<IWine> getWinesBygrowuptime(String growuptime);

	 List<IWine> getWinesBylabel(String label);

	 IWine getWineByID(Integer wineID);

	 void insertWine(String productName, Double price,
			String login, Integer establishmentID, String type, String od,
			Integer year, String growUpTime, String label);

	 void updateWine(Wine wine);

	 void deleteWine(Integer wineID);

}