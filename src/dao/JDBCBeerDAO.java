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
import domain.Beer;
import domain.IBeer;
import domain.IProduct;




public class JDBCBeerDAO implements IBeerDAO {

	private Connection conn; 
	private String sql;
	private PreparedStatement stmt;
	private ResultSet result;
	
	private IProductDAO productDAO;
	

	public List<IBeer> getAllBeers() {
		
		productDAO = new JDBCProductDAO();
		List<IBeer> searchResults = new ArrayList<>();
		conn = ConnectionManager.getInstance().openConnection();
		
		productDAO = new JDBCProductDAO();
		
		sql = "SELECT * FROM beers;";
		
		try{
			stmt = conn.prepareStatement(sql);
			result = stmt.executeQuery();
			
			Beer beer = null;
			IProduct  product = null;
			//Map <User, ProductScore> usersScore = new HashMap<>();
			
			while(result.next()){
				
					
				product = productDAO.getProductByPROID(result.getString("FK_PRODOID"));
				
				beer = new Beer(product.getProductName(), product.getPrice(), product.getRegistryDate(),
						product.getUserLoginID(), product.getEstablishmentID(), product.getProductID(),
						result.getString("size"), result.getString("label"), result.getString("colour"),
						result.getString("temperature"), result.getInt("beerID"));
				
				searchResults.add(beer);
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


	public IBeer getBeerByProduct(Integer PRODID) {
		productDAO = new JDBCProductDAO();
		IBeer searchResult = null;
		conn = ConnectionManager.getInstance().openConnection();
		
		sql = "SELECT * FROM beers WHERE FK_PRODOID=?;";
		
		IProduct product = null;
		
		try{
			stmt = conn.prepareStatement(sql);
			
			stmt.setInt(1, PRODID);
			
			result = stmt.executeQuery();
			
			if(result.next()){
				
				product = productDAO.getProductByPROID(result.getString("FK_PRODOID"));
				
				searchResult = new Beer(product.getProductName(), product.getPrice(), product.getRegistryDate(),
						product.getUserLoginID(), product.getEstablishmentID(), product.getProductID(),
						result.getString("size"), result.getString("label"), result.getString("colour"),
						result.getString("temperature"), result.getInt("beerID"));
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


	
	public List<IBeer> getBeersByColor(String colour) {
		
		productDAO = new JDBCProductDAO();
		
		List<IBeer> searchResults = new ArrayList<>();
		conn = ConnectionManager.getInstance().openConnection();
		
		sql = "SELECT * FROM beers WHERE colour=?;";
		
		try{
			stmt = conn.prepareStatement(sql);
			
			stmt.setString(1, colour);
			
			result = stmt.executeQuery();
			
			Beer beer = null;
			
			IProduct product = null;
			
			while(result.next()){
				
				product = productDAO.getProductByPROID(result.getString("FK_PRODOID"));
				
				beer = new Beer(product.getProductName(), product.getPrice(), product.getRegistryDate(),
						product.getUserLoginID(), product.getEstablishmentID(), product.getProductID(),
						result.getString("size"), result.getString("label"), result.getString("colour"),
						result.getString("temperature"), result.getInt("beerID"));
				
				searchResults.add(beer);
				
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

	
	public List<IBeer> getBeersBySize(String size) {
		
		productDAO = new JDBCProductDAO();
		
		List<IBeer> searchResults = new ArrayList<>();
		
		conn = ConnectionManager.getInstance().openConnection();
		
		sql = "SELECT * FROM beers WHERE size=?";
		
		try{
			stmt = conn.prepareStatement(sql);
			
			stmt.setString(1, size);
			
			result = stmt.executeQuery();
			
			Beer beer = null;
			
			IProduct product = null;
			
			while(result.next()){
				
				product = productDAO.getProductByPROID(result.getString("FK_PRODOID"));
				
				beer = new Beer(product.getProductName(), product.getPrice(), product.getRegistryDate(),
						product.getUserLoginID(), product.getEstablishmentID(), product.getProductID(),
						result.getString("size"), result.getString("label"), result.getString("colour"),
						result.getString("temperature"), result.getInt("beerID"));
				
				searchResults.add(beer);
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
	
	@Override
	public List<IBeer> getBeersByTemperature(String temperature) {
		
		productDAO = new JDBCProductDAO();
		List<IBeer> searchResults = new ArrayList<>();
		conn = ConnectionManager.getInstance().openConnection();
		
		sql = "SELECT * FROM beers WHERE temperature=?;";
		
		try{
			stmt = conn.prepareStatement(sql);
			
			stmt.setString(1, temperature);
			
			result = stmt.executeQuery();
			
			Beer beer = null;
			
			IProduct product = null;
			
			while(result.next()){
				
				product = productDAO.getProductByPROID(result.getString("FK_PRODOID"));
				
				beer = new Beer(product.getProductName(), product.getPrice(), product.getRegistryDate(),
						product.getUserLoginID(), product.getEstablishmentID(), product.getProductID(),
						result.getString("size"), result.getString("label"), result.getString("colour"),
						result.getString("temperature"), result.getInt("beerID"));
				
				searchResults.add(beer);
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

	
	public List<IBeer> getBeersBylabel(String label) {
		
		List<IBeer> searchResults = new ArrayList<>();
		
		conn = ConnectionManager.getInstance().openConnection();
		
		sql = "SELECT * FROM beers WHERE label=?";
		
		try{
			stmt = conn.prepareStatement(sql);
			
			stmt.setString(1, label);
			
			result = stmt.executeQuery();
			IBeer beer = null;
			
			IProduct product = null;
			
			productDAO = new JDBCProductDAO();
			
			while(result.next()){
				
				
				product = productDAO.getProductByPROID(result.getString("FK_PRODOID"));
				
				beer = new Beer(product.getProductName(), product.getPrice(), product.getRegistryDate(),
						product.getUserLoginID(), product.getEstablishmentID(), product.getProductID(),
						result.getString("size"), result.getString("label"), result.getString("colour"),
						result.getString("temperature"), result.getInt("beerID"));
				
		
				searchResults.add(beer);
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

	
	public IBeer getBeerByOID(String BEEROID) {
		
		productDAO = new JDBCProductDAO();
		
		IBeer searchResult = null;
		
		conn = ConnectionManager.getInstance().openConnection();
		
		IProduct product = null;
		
		sql = "SELECT * FROM beers WHERE BEEROID=?;";
		
		try{
			stmt = conn.prepareStatement(sql);
			
			stmt.setString(1, BEEROID);
			
			result = stmt.executeQuery();
			
			if(result.next()){
				
				product = productDAO.getProductByPROID(result.getString("FK_PRODOID"));
				
				searchResult = new Beer(product.getProductName(), product.getPrice(), product.getRegistryDate(),
						product.getUserLoginID(), product.getEstablishmentID(), product.getProductID(),
						result.getString("size"), result.getString("label"), result.getString("colour"),
						result.getString("temperature"), result.getInt("beerID"));
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
	
	
public String getBeerOIDByID(Integer BEERID) {
		
		
		String beerOID = null;
		
		conn = ConnectionManager.getInstance().openConnection();
		
			
		sql = "SELECT * FROM beers WHERE beerID=?;";
		
		try{
			
			stmt = conn.prepareStatement(sql);
			
			stmt.setInt(1, BEERID);
			
			result = stmt.executeQuery();
			
			if(result.next()){
								
				beerOID =  result.getString("beerOID");
				 
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
		return beerOID;
	}

public IBeer getBeerByID(Integer BEERID) {
	
	String beerOID = this.getBeerOIDByID(BEERID);
	IBeer beer = this.getBeerByOID(beerOID);
	return beer;
	
}
	
	
	public void insertBeer(IBeer beer) {
		
			
		UIDGenerator uidGenerator = UIDGenerator.getInstance();
		
		String beerOID = uidGenerator.getKey();
		String productOID =uidGenerator.getKey();
		
		IDGenerator idGenerator = new IDGenerator("beerID", "beers");
		Integer beerID = idGenerator.nextValue();
		
		

		
		productDAO = new JDBCProductDAO();
//		Product product = new Product(beer.getProductName(), beer.getPrice(),
//				beer.getUserCreatorOID(), beer.getEstablishmentOID(), beer.getProductOID());
 		productDAO.insertProduct(beer, productOID);
 		
//		productID = productDAO.getProductByPROID(productOID).getProductID();
						
		
		
		if(productDAO.getProductByPROID(productOID)!=null){
			
			conn = ConnectionManager.getInstance().openConnection();
			
			sql = "INSERT INTO beers (size, label, colour, temperature, FK_PRODOID, beerID, BEEROID) VALUES (?, ? ,? , ?, ?, ?, ?);";
			
		try{
			stmt = conn.prepareStatement(sql);
			
			stmt.setString(1, beer.getSize());
			stmt.setString(2, beer.getLabel());
			stmt.setString(3, beer.getColor());
			stmt.setString(4, beer.getTemperature());
			stmt.setString(5, productOID);
			stmt.setInt(6, beerID);
			stmt.setString(7, beerOID);
			
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

	
	public void updateBeer(IBeer beer) {
		
		
		String beerOID = this.getBeerOIDByID(beer.getBeerID());
		
		
		if(beerOID!=null){
		productDAO = new JDBCProductDAO();
		productDAO.updateProduct(beer);
			
		conn = ConnectionManager.getInstance().openConnection();
//		
//		Product productOID;
//		
	
//		Product product = new Product(beer.getProductName(), beer.getPrice(),
//				beer.getUserCreatorOID(), beer.getEstablishmentOID(), beer.getProductOID());
 		
// 		
//		productOID = productDAO.getProductByPROID(beer.getProductOID());
		
	
		
			sql = "UPDATE beers SET size=?, label=? , colour=? , temperature=?, FK_PRODOID=? WHERE BEEROID=?;";
				
			try{
				stmt = conn.prepareStatement(sql);
				
				stmt.setString(1, beer.getSize());
				stmt.setString(2, beer.getLabel());
				stmt.setString(3, beer.getColor());
				stmt.setString(4, beer.getTemperature());
				stmt.setString(5, productDAO.getProductOIDByID(beer.getProductID()));
				stmt.setString(6, beerOID);
				
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

	
	public void deleteBeer(Integer BEERID) {
		productDAO = new JDBCProductDAO();
		IBeer beer = this.getBeerByID(BEERID);
		if(beer!=null){
			productDAO.deleteProduct(beer.getProductID());	
		}			
	}

}
