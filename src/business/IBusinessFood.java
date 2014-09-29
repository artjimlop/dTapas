package business;

import java.util.List;

import domain.Food;
import domain.IFood;

public interface IBusinessFood {

	 List<IFood> getAllFoods();

	 IFood getFoodByProduct(Integer PRODID);

	 IFood getFoodByID(Integer foodID);

	 List<IFood> getFoodsByType(String type);

	 Integer insertFood(String productName, Double price,
			String login, Integer establishmentID, String type);
	 
	 Boolean testInsertFood(String productname, String type);
	 void updateFood(Food food);

	 void deleteFood(Integer foodID);

}