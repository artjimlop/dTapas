package dao;


import java.util.List;

import domain.IFood;

/**
 * 
 * @author Juan Pedro Piña
 *
 */

public interface IFoodDAO {
	
	List<IFood> getAllFoods();
	IFood getFoodByProduct(Integer PRODID);
	List<IFood> getFoodsByType(String type);
	IFood getFoodByID(Integer foodID);
	IFood getFoodByOID(String MEALOID);
	String getFoodOIDByID(Integer foodID);
	Integer insertFood(IFood food);
	Boolean testInsertFood(String foodname, String type);
	void updateFood(IFood food);
	void deleteFood(Integer foodID);

}
