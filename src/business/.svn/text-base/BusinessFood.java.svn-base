package business;

import java.util.List;

import dao.IFoodDAO;
import dao.JDBCFoodDAO;
import domain.Food;
import domain.IFood;

public class BusinessFood implements IBusinessFood {
//	
//	private static BusinessFood businessFood;
//	
//	private List<Food> foods;
	private IFoodDAO foodDAO;

//public static synchronized BusinessFood getInstance() throws SQLException{
//		
//		if(businessFood==null){
//			businessFood = new BusinessFood();
//		}
//		return businessFood;
//	}
	
	public BusinessFood(){
		
		foodDAO = new JDBCFoodDAO();
//		this.foods = foodDAO.getAllFoods();
		
	}
	
	/* (non-Javadoc)
	 * @see business.IBusinessFood#getAllFoods()
	 */
	@Override
	public List<IFood> getAllFoods(){
		
		return foodDAO.getAllFoods();
		
	}
	
	/* (non-Javadoc)
	 * @see business.IBusinessFood#getFoodByProduct(java.lang.Integer)
	 */
	@Override
	public IFood getFoodByProduct(Integer PRODID){
		
//		Food resultFood = null;
//		
//		for(Food food : getAllFoods()){
//			if(food.getFoodOID()==PRODOID){
//				resultFood = food;
//			}
//		}
//		
		return foodDAO.getFoodByProduct(PRODID);
		
	}
	
	/* (non-Javadoc)
	 * @see business.IBusinessFood#getFoodByID(java.lang.Integer)
	 */
	@Override
	public IFood getFoodByID(Integer foodID){
		
		return foodDAO.getFoodByID(foodID);
	}
	
	/* (non-Javadoc)
	 * @see business.IBusinessFood#getFoodsByType(java.lang.String)
	 */
	@Override
	public List<IFood> getFoodsByType(String type){
		
//		List<Food> foods = new ArrayList<>();
//		
//		for(Food food : getAllFoods()){
//			if(food.getType() == type){
//				foods.add(food);
//			}
//		}
		
		return foodDAO.getFoodsByType(type);
		
	}
	
	/* (non-Javadoc)
	 * @see business.IBusinessFood#insertFood(java.lang.String, java.lang.Double, java.lang.String, java.lang.Integer, java.lang.String)
	 */
	@Override
	public Integer insertFood(String productName, Double price,
			String login, Integer establishmentID,
			String type){
		
	
		Food resultFood = new  Food(productName, price, login, establishmentID,
				type);
		

		return foodDAO.insertFood(resultFood);
		
	
	}
	
	/* (non-Javadoc)
	 * @see business.IBusinessFood#updateFood(domain.Food)
	 */
	@Override
	public void updateFood(Food food){
		
//		Food food = new  Food(productName, price, userCreatorOID, establishmentOID, productOID, type, foodOID);
		
//		BusinessProduct product = new BusinessProduct();
//		product.updateProduct(food);
		
		foodDAO.updateFood(food);
		

	}
	
	/* (non-Javadoc)
	 * @see business.IBusinessFood#deleteFood(java.lang.Integer)
	 */
	@Override
	public void deleteFood(Integer foodID){
		
		IFoodDAO foodDAO = new JDBCFoodDAO();
		foodDAO.deleteFood(foodID);

	}

	@Override
	public Boolean testInsertFood(String productname, String type) {
		IFoodDAO foodDAO = new JDBCFoodDAO();
		return foodDAO.testInsertFood(productname, type);
	}

//	private void updateVariables(){
//		foodDAO = new JDBCFoodDAO();
//		this.foods = foodDAO.getAllFoods();
//		
//	}
}
