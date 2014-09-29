package business;

import java.util.List;

import domain.IOther;
import domain.Other;

public interface IBusinessOther {

	 List<IOther> getAllOthers();

	 IOther getOthersByProduct(Integer prodID);

	//List<Other> getOthersBySize(String size);
	 List<IOther> getOthersBySize(String size);

	 List<IOther> getOthersByType(String type);

	//Other getOthersByOID(Integer OTROID);
	 IOther getOthersByID(Integer OTRID);

	 void insertOthers(String productName, Double price,
			String userlogin, Integer establishmentID, String size, String type);

	 void updateOthers(Other other);

	 void deleteOthers(Integer otherID);

}