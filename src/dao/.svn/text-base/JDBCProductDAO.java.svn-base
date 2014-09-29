package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import utils.IDGenerator;

import manager.ConnectionManager;
import domain.IEstablishment;
import domain.IProduct;
import domain.IUser;
import domain.Product;

/**
 * 
 * @author David Alanis
 *
 */

public class JDBCProductDAO implements IProductDAO {
	
	private Connection conn; 
	private String sql;
	private PreparedStatement stmt;
	private ResultSet result;
	
	private IUserDAO userDAO;
	private IEstablishmentDAO establishmentDAO;
	
	
	public List<IProduct> getAllProduct() {
		
		List<IProduct> searchResults = new ArrayList<>();
		conn = ConnectionManager.getInstance().openConnection();
		
		sql = "SELECT * FROM products " +
				"ORDER BY productName;";
		
		try{
			stmt = conn.prepareStatement(sql);
			result = stmt.executeQuery();
			
			IProduct product = null;	
			IUser user = null;
			IEstablishment establishment = null;
			
			this.userDAO = new JDBCUserDAO();
			this.establishmentDAO = new JDBCEstablishmentDAO();
			
			
			while(result.next()){
				user = this.userDAO.getUserByOID(result.getString("FK_USOID"));
				establishment = this.establishmentDAO.getEstablishmentByOID(result.getString("FK_ESTOID"));
				
				product = new Product(result.getString("productName"), result.getDate("registryDate"), result.getDouble("price"),
						user.getLogin(), establishment.getEstablishmentID(), result.getInt("productID"));
				
				searchResults.add(product);
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

	
	public List<IProduct> getProductByName(String name) {

		List<IProduct> searchResults = new ArrayList<>();
		conn = ConnectionManager.getInstance().openConnection();
		
		sql = "SELECT * FROM products " +
				"WHERE(productName=?);";
		
		try{
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, name);
			
			result = stmt.executeQuery();
			
			IProduct product = null;
			IUser user = null;
			IEstablishment establishment = null;
			
			this.userDAO = new JDBCUserDAO();
			this.establishmentDAO = new JDBCEstablishmentDAO();
			
			while(result.next()){
				
				user = this.userDAO.getUserByOID(result.getString("FK_USOID"));
				establishment = this.establishmentDAO.getEstablishmentByOID(result.getString("FK_ESTOID"));
				
				product = new Product(result.getString("productName"), result.getDate("registryDate"), result.getDouble("price"),
						user.getLogin(), establishment.getEstablishmentID(), result.getInt("productID"));
				
				searchResults.add(product);
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

	
	public List<IProduct> getProductByRegistryDate(Date date) {
		
		List<IProduct> searchResults = new ArrayList<>();
		conn = ConnectionManager.getInstance().openConnection();
		
		sql = "SELECT * FROM products " +
				"WHERE(registryDate=?);";
		
		try{
			stmt = conn.prepareStatement(sql);
			stmt.setDate(1, date);
			
			result = stmt.executeQuery();
			
			IProduct product = null;
			IUser user = null;
			IEstablishment establishment = null;
			
			this.userDAO = new JDBCUserDAO();
			this.establishmentDAO = new JDBCEstablishmentDAO();
			
			while(result.next()){
				
				user = this.userDAO.getUserByOID(result.getString("FK_USOID"));
				establishment = this.establishmentDAO.getEstablishmentByOID(result.getString("FK_ESTOID"));
				
				product = new Product(result.getString("productName"), result.getDate("registryDate"), result.getDouble("price"),
						user.getLogin(), establishment.getEstablishmentID(), result.getInt("productID"));
				
				searchResults.add(product);
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

	
	public List<IProduct> getProductByPrice(Double price) {

		List<IProduct> searchResults = new ArrayList<>();
		conn = ConnectionManager.getInstance().openConnection();
		
		sql = "SELECT * FROM products " +
				"WHERE(price=?);";
		
		try{
			stmt = conn.prepareStatement(sql);
			stmt.setDouble(1, price);
			
			result = stmt.executeQuery();
			
			IProduct product = null;
			IUser user = null;
			IEstablishment establishment = null;
			
			this.userDAO = new JDBCUserDAO();
			this.establishmentDAO = new JDBCEstablishmentDAO();
			
			while(result.next()){
				
				user = this.userDAO.getUserByOID(result.getString("FK_USOID"));
				establishment = this.establishmentDAO.getEstablishmentByOID(result.getString("FK_ESTOID"));
				
				product = new Product(result.getString("productName"), result.getDate("registryDate"), result.getDouble("price"),
						user.getLogin(), establishment.getEstablishmentID(), result.getInt("productID"));
				
				searchResults.add(product);
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

	
	public List<IProduct> getProductByCreatorUser(String USOID) {

		List<IProduct> searchResults = new ArrayList<>();
		conn = ConnectionManager.getInstance().openConnection();
		
		sql = "SELECT * FROM products " +
				"WHERE(FK_USOID=?);";
		
		try{
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, USOID);
			
			result = stmt.executeQuery();
			
			IProduct product = null;
			IUser user = null;
			IEstablishment establishment = null;
			
			this.userDAO = new JDBCUserDAO();
			this.establishmentDAO = new JDBCEstablishmentDAO();
			
			while(result.next()){
				
				user = this.userDAO.getUserByOID(result.getString("FK_USOID"));
				establishment = this.establishmentDAO.getEstablishmentByOID(result.getString("FK_ESTOID"));
				
				product = new Product(result.getString("productName"), result.getDate("registryDate"), result.getDouble("price"),
						user.getLogin(), establishment.getEstablishmentID(), result.getInt("productID"));
				
				searchResults.add(product);
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

	
	public List<IProduct> getProductByEstablishment(String ESTOID) {

		List<IProduct> searchResults = new ArrayList<>();
		conn = ConnectionManager.getInstance().openConnection();
		
		sql = "SELECT * FROM products " +
				"WHERE(FK_ESTOID=?);";
		
		try{
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, ESTOID);
			result = stmt.executeQuery();
			
			IProduct product = null;
			IUser user = null;
			IEstablishment establishment = null;
			
			this.userDAO = new JDBCUserDAO();
			this.establishmentDAO = new JDBCEstablishmentDAO();
			
			while(result.next()){	
				
				user = this.userDAO.getUserByOID(result.getString("FK_USOID"));
				establishment = this.establishmentDAO.getEstablishmentByOID(result.getString("FK_ESTOID"));
				
				product = new Product(result.getString("productName"), result.getDate("registryDate"), result.getDouble("price"),
						user.getLogin(), establishment.getEstablishmentID(), result.getInt("productID"));
				
				searchResults.add(product);
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
	
	public IProduct getProductByPROID(String PROID) {
		
		conn = ConnectionManager.getInstance().openConnection();
		IProduct product = null;
		
		sql = "SELECT * FROM products WHERE(PRODOID=?);";
		
		try{
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, PROID);
			
			result = stmt.executeQuery();
			
			IUser user = null;
			IEstablishment establishment = null;
			
			this.userDAO = new JDBCUserDAO();
			this.establishmentDAO = new JDBCEstablishmentDAO();
						
			if(result.next()){
				
				user = this.userDAO.getUserByOID(result.getString("FK_USOID"));
				establishment = this.establishmentDAO.getEstablishmentByOID(result.getString("FK_ESTOID"));
				
				product = new Product(result.getString("productName"), result.getDate("registryDate"), result.getDouble("price"),
						user.getLogin(), establishment.getEstablishmentID(), result.getInt("productID"));
				
				
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
		
		return product;
		
	}


	
	public void insertProduct(IProduct product, String productOID) {
		
		conn = ConnectionManager.getInstance().openConnection();
		
		IDGenerator idGenerator = new IDGenerator("productID", "products");
		Integer productID = idGenerator.nextValue();
		
		this.userDAO = new JDBCUserDAO();
		String userOID = this.userDAO.getUserOIDByLogin(product.getUserLoginID());
		
		this.establishmentDAO = new JDBCEstablishmentDAO();
		String establishmentOID = this.establishmentDAO.getEstablishmentOIDByID(product.getEstablishmentID());
		
		sql = "INSERT INTO products (productName, registryDate, price, PRODOID, FK_USOID, FK_ESTOID, productID) VALUES (?, ?, ?, ?, ?, ?,?);";
		
		try{
			stmt = conn.prepareStatement(sql);
			
			stmt.setString(1, product.getProductName());
			stmt.setDate(2, product.getRegistryDate());
			stmt.setDouble(3, product.getPrice());
			stmt.setString(4, productOID);
			stmt.setString(5, userOID);
			stmt.setString(6, establishmentOID);
			stmt.setInt(7, productID);
			
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


	
	public void updateProduct(IProduct product) {
		
		String productOID = this.getProductOIDByID(product.getProductID());
		
		conn = ConnectionManager.getInstance().openConnection();
		sql = "UPDATE products SET productName=?,price=? WHERE(PRODOID=?);";
		
		
		try{
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, product.getProductName());
			stmt.setDouble(2, product.getPrice());
			stmt.setString(3, productOID);
			
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


	public void deleteProduct(Integer productID) {
		
		String productOID = this.getProductOIDByID(productID);
		conn = ConnectionManager.getInstance().openConnection();
		
		sql = "DELETE FROM products WHERE(PRODOID =?);";
		
			
			try{
				stmt = conn.prepareStatement(sql);
				stmt.setString(1, productOID);
				
				stmt.executeUpdate();
				
			}catch (SQLException e) {
	            System.out.println("Message: " + e.getMessage());
	            System.out.println("SQLState: " + e.getSQLState());
	            System.out.println("ErrorCode: " + e.getErrorCode());
	        } finally {
	        	ConnectionManager.getInstance().closeConnection(conn);
	        	
	            try {
	                if (stmt != null)
	                    stmt.close();
	            } catch (SQLException e) {
	            	}
	        	}
	       }


	@Override
	public List<IProduct> getProductByUserLogin(String userLogin) {
		
		this.userDAO = new JDBCUserDAO();
		String userOID = this.userDAO.getUserOIDByLogin(userLogin);
		List<IProduct> products = this.getProductByCreatorUser(userOID);
		return products;
	}


	@Override
	public List<IProduct> getProductByEstablisment(Integer establishmentID) {
		
		this.establishmentDAO = new JDBCEstablishmentDAO();
		String establishmentOID = this.establishmentDAO.getEstablishmentOIDByID(establishmentID);
		List<IProduct> products = this.getProductByEstablishment(establishmentOID);
		return products;
	}


	@Override
	public IProduct getProductByID(Integer productID) {
		
		String productOID = this.getProductOIDByID(productID);
		IProduct product = this.getProductByPROID(productOID);
		return product;
	}


	@Override
	public String getProductOIDByID(Integer productID) {
		String commentOID = null;	
		conn = ConnectionManager.getInstance().openConnection();
		
		sql = "SELECT * FROM products WHERE(productID=?);";
		
		try{
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, productID);
			
			result = stmt.executeQuery();
		
			if(result.next()){
				
				commentOID = result.getString("PRODOID");
				
			}
			
			result.close();
			stmt.close();
			
		}catch (SQLException e) {
			
			e.printStackTrace();
			
		}finally{
			ConnectionManager.getInstance().closeConnection(conn);
			try{
			if(result != null)
				result.close();
			if(stmt != null)
				stmt.close();
			}catch (SQLException e) {
			}
		}
		
		return commentOID;
	}


	
}
	



