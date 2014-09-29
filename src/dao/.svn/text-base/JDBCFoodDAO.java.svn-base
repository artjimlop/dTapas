package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import utils.IDGenerator;
import utils.UIDGenerator;

import manager.ConnectionManager;
import domain.Food;
import domain.IFood;
import domain.IProduct;

/**
 * 
 * @author David Alanis
 *
 */

public class JDBCFoodDAO implements IFoodDAO {

	private Connection conn; 
	private String sql;
	private PreparedStatement stmt;
	private ResultSet result;
	
	private IProductDAO productDAO;
	
	
	public List<IFood> getAllFoods() {
		productDAO = new JDBCProductDAO();
		List<IFood> searchResults = new ArrayList<>();
		conn = ConnectionManager.getInstance().openConnection();
		productDAO = new JDBCProductDAO();
		
		sql = "SELECT * FROM meals ORDER BY type;";
		
		try{
			stmt = conn.prepareStatement(sql);
			result = stmt.executeQuery();
			
			IProduct product = null;
			IFood food = null;
			
			while(result.next()){
				
				product = productDAO.getProductByPROID(result.getString("FK_PRODOID"));
				
				food = new Food (product.getProductName(), product.getPrice(), product.getRegistryDate(),
						product.getUserLoginID(), product.getEstablishmentID(), product.getProductID(),
						result.getString("type"), result.getInt("foodID"));
				
				searchResults.add(food);
			}
			

		}catch (SQLException e) {
			e.printStackTrace();
		}finally{
			ConnectionManager.getInstance().closeConnection(conn);
			try{
				if(result!= null){
					result.close();
				}
				if(stmt != null){
					stmt.close();
				}
			}catch (SQLException e) {
				}
			}
		
		return searchResults;
	}

	
	public IFood getFoodByProduct(Integer PRODID) {
		productDAO = new JDBCProductDAO();
		IFood searchResult = null;
		conn = ConnectionManager.getInstance().openConnection();
		productDAO = new JDBCProductDAO();
		
		sql = "SELECT * FROM meals WHERE FK_PRODOID=?;";
		
		try{
			
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, PRODID);
			
			result = stmt.executeQuery();
			
			IProduct product = null;
			
			product = productDAO.getProductByID(PRODID);
			
			if(result.next()){
				
				searchResult = new Food (product.getProductName(), product.getPrice(), product.getRegistryDate(),
						product.getUserLoginID(), product.getEstablishmentID(), product.getProductID(),
						result.getString("type"), result.getInt("foodID"));
				
			}
			

		}catch (SQLException e) {
			e.printStackTrace();
		}finally{
			ConnectionManager.getInstance().closeConnection(conn);
			try{
				if(result!= null){
					result.close();
				}
				if(stmt != null){
					stmt.close();
				}
			}catch (SQLException e) {
				}
			}
		
		return searchResult;
	}
	
	
	public List<IFood> getFoodsByType(String type) {
		
		List<IFood> searchResults = new ArrayList<>();
		conn = ConnectionManager.getInstance().openConnection();
		productDAO = new JDBCProductDAO();
		
		sql = "SELECT * FROM meals WHERE(type=?) ORDER BY MEALOID;";
		
		try{
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, type);
			
			result = stmt.executeQuery();
			
			IProduct product = null;
			IFood food = null;
			
			while(result.next()){

				product = productDAO.getProductByPROID(result.getString("FK_PRODOID"));
				
				food = new Food (product.getProductName(), product.getPrice(), product.getRegistryDate(),
						product.getUserLoginID(), product.getEstablishmentID(), product.getProductID(),
						result.getString("type"), result.getInt("foodID"));
				
				searchResults.add(food);
			}
			

		}catch (SQLException e) {
			e.printStackTrace();
		}finally{
			ConnectionManager.getInstance().closeConnection(conn);
			try{
				if(result!= null){
					result.close();
				}
				if(stmt != null){
					stmt.close();
				}
			}catch (SQLException e) {
				}
			}
		
		return searchResults;
	}

	
	public Integer insertFood(IFood food) {
		
		
		UIDGenerator uidGenerator = UIDGenerator.getInstance();
		String MEALOID = uidGenerator.getKey();
		String productOID = uidGenerator.getKey();
		
		IDGenerator idGenerator = new IDGenerator("foodID", "meals");
		Integer foodID = idGenerator.nextValue();
		
		
		conn = ConnectionManager.getInstance().openConnection();
//		Product productOID;
//		
		productDAO = new JDBCProductDAO();
//		Product product = new Product(food.getProductName(), food.getPrice(),
//				food.getUserCreatorOID(), food.getEstablishmentOID(), food.getProductOID());
 		productDAO.insertProduct(food, productOID);
// 		
//		Integer productID = productDAO.getProductByPROID(productOID).getProductID();
		
		
		if(productDAO.getProductByPROID(productOID)!=null){
		
		sql = "INSERT INTO meals (type, FK_PRODOID, foodID, MEALOID) VALUES (?,?,?,?);";
		try{
			stmt = conn.prepareStatement(sql);
			
			stmt.setString(1, food.getType());
			stmt.setString(2, productOID);
			stmt.setInt(3, foodID);
			stmt.setString(4, MEALOID);
			
			stmt.executeUpdate();
			
		}catch (SQLException e) {
			System.out.println("Message: " + e.getMessage());
            System.out.println("SQLState: " + e.getSQLState());
            System.out.println("ErrorCode: " + e.getErrorCode());
		}finally{
			ConnectionManager.getInstance().closeConnection(conn);
			try{
				if(stmt != null){
					stmt.close();
				}
			}catch (SQLException e) {
				}
			}
		}
		return foodID;
	}
	
	
	public void deleteFood(Integer foodID) {
		
		productDAO = new JDBCProductDAO();
		IFood food = this.getFoodByID(foodID);
		if (food!=null){
				
			productDAO.deleteProduct(food.getProductID());
			
		}
	}

	/*private Integer selectOIDOfProduct(String productName, Date makeDate, Double price, Integer USOID, Integer ESTOID){
		
		Integer oid = null;
		conn = ConnectionManager.getInstance().openConnection();
		
		sql = "SELECT * FROM producto WHERE(nombreProducto = ?, fechaAlta = ?, precio = ?, FK_USOID = ?, FK_ESTOID = ?);";
		
		try{
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, productName);
			stmt.setDate(2, makeDate);
			stmt.setDouble(3, price);
			stmt.setInt(4, USOID);
			stmt.setInt(5, ESTOID);
			
			result = stmt.executeQuery();
			
			if(result.next()){
				oid = result.getInt("PRODOID");
			}
		}catch (SQLException e) {
            System.out.println("Message: " + e.getMessage());
            System.out.println("SQLState: " + e.getSQLState());
            System.out.println("ErrorCode: " + e.getErrorCode());
        } finally {
        	ConnectionManager.getInstance().closeConnection(conn);
        	
            try {
                if (result != null) {
                    result.close();
                }
                if (stmt != null) {
                    stmt.close();
                }
            } catch (SQLException e) {
            }
            
        }
        return oid;
	}
	*/
//	private String selectPROIDOfByFood(String MEALOID){
//		
//		String oid = null;
//		conn = ConnectionManager.getInstance().openConnection();
//		
//		sql = "SELECT * FROM meals WHERE(MEALOID = ?);";
//		
//		try{
//			stmt = conn.prepareStatement(sql);
//			stmt.setString(1, MEALOID);
//			
//			result = stmt.executeQuery();
//			
//			if(result.next()){
//				oid = result.getString("FK_PRODOID");
//			}
//		}catch (SQLException e) {
//            System.out.println("Message: " + e.getMessage());
//            System.out.println("SQLState: " + e.getSQLState());
//            System.out.println("ErrorCode: " + e.getErrorCode());
//        } finally {
//        	ConnectionManager.getInstance().closeConnection(conn);
//        	
//            try {
//                if (result != null) {
//                    result.close();
//                }
//                if (stmt != null) {
//                    stmt.close();
//                }
//            } catch (SQLException e) {
//            }
//            
//        }
//        return oid;
//	}
//
//
//	@Override
	public void updateFood(IFood food) {
		
		if(getFoodByID(food.getFoodID())!=null){
			
			conn = ConnectionManager.getInstance().openConnection();
			
//			Product productOID;
//			
			productDAO = new JDBCProductDAO();
//			Product product = new Product(food.getProductName(), food.getPrice(),
//					food.getUserCreatorOID(), food.getEstablishmentOID(), food.getProductOID());
	 		productDAO.updateProduct(food);
//	 		
//			productOID = productDAO.getProductByPROID(food.getProductOID());
		
			sql = "UPDATE meals SET type=?, FK_PRODOID=? WHERE foodID=?;";
				
			
			try{
				stmt = conn.prepareStatement(sql);
				
				stmt.setString(1, food.getType());
				stmt.setString(2, productDAO.getProductOIDByID(food.getProductID()));
				stmt.setInt(3, food.getFoodID());
				stmt.executeUpdate();
				
			}catch (SQLException e) {
				System.out.println("Message: " + e.getMessage());
	            System.out.println("SQLState: " + e.getSQLState());
	            System.out.println("ErrorCode: " + e.getErrorCode());
			}finally{
				
				ConnectionManager.getInstance().closeConnection(conn);
				try{
					if(stmt != null){
						stmt.close();
					}
				}catch (SQLException e) {
				}
			}

		}
		
	}


	@Override
	public IFood getFoodByOID(String MEALOID) {
		productDAO = new JDBCProductDAO();
		
		IFood searchResult = null;
		
		conn = ConnectionManager.getInstance().openConnection();
		
		IProduct product = null;
		
		sql = "SELECT * FROM meals WHERE MEALOID=?;";
		
		
		
		try{
			stmt = conn.prepareStatement(sql);
			
			stmt.setString(1, MEALOID);
			result = stmt.executeQuery();
			
			if(result.next()){
				
				product = productDAO.getProductByPROID(result.getString("FK_PRODOID"));
				
				searchResult = new Food (product.getProductName(), product.getPrice(), product.getRegistryDate(),
						product.getUserLoginID(), product.getEstablishmentID(), product.getProductID(),
						result.getString("type"), result.getInt("foodID"));
			}
			
		}catch (SQLException e) {
			e.printStackTrace();
		}finally{
			ConnectionManager.getInstance().closeConnection(conn);
			try{
				if(result!= null){
					result.close();
				}
				if(stmt != null){
					stmt.close();
				}
			}catch (SQLException e) {
				}
			}
		
		return searchResult;
	}


	@Override
	public IFood getFoodByID(Integer foodID) {
		String MEALOID = this.getFoodOIDByID(foodID);
		IFood food = this.getFoodByOID(MEALOID);
		return food;
	}


	@Override
	public String getFoodOIDByID(Integer foodID) {
		
		String MEALOID = null;
		
		conn = ConnectionManager.getInstance().openConnection();
		
			
		sql = "SELECT * FROM meals WHERE foodID=?;";
		
		try{
			
			stmt = conn.prepareStatement(sql);
			
			stmt.setInt(1, foodID);
			
			result = stmt.executeQuery();
			
			if(result.next()){
								
				MEALOID =  result.getString("MEALOID");
				 
			}
			
		}catch (SQLException e) {
			e.printStackTrace();
		}finally{
			ConnectionManager.getInstance().closeConnection(conn);
			try{
				if(result!= null){
					result.close();
				}
				if(stmt != null){
					stmt.close();
				}
			}catch (SQLException e) {
				}
			}
		return MEALOID;
	}


	@Override
	public Boolean testInsertFood(String foodname, String type) {
		Boolean response = false;
		productDAO = new JDBCProductDAO();
;
		conn = ConnectionManager.getInstance().openConnection();
		productDAO = new JDBCProductDAO();
		
		
		sql = "SELECT * FROM meals,products,establishments  WHERE meals.FK_PRODOID=products.PRODOID and products.FK_ESTOID=establishments.ESTOID and products.productName=? and meals.type=?;";
		
		try{
			
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, foodname);
			stmt.setString(2, type);
			
			result = stmt.executeQuery();
			

			
			
			if(result.next()){
				
				response = true;
				
			}
			

		}catch (SQLException e) {
			e.printStackTrace();
		}finally{
			ConnectionManager.getInstance().closeConnection(conn);
			try{
				if(result!= null){
					result.close();
				}
				if(stmt != null){
					stmt.close();
				}
			}catch (SQLException e) {
				}
			}
		return response;
	}
	
}

