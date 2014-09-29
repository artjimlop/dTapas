package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import manager.ConnectionManager;
import utils.IDGenerator;
import utils.UIDGenerator;
import domain.IOther;
import domain.IProduct;
import domain.Other;


public class JDBCOthersDAO implements IOthersDAO {
	
	private Connection conn; 
	private String sql;
	private PreparedStatement stmt;
	private ResultSet result;
	
	private IProductDAO productDAO;
	
	
	public List<IOther> getAllOthers() {
		
		productDAO = new JDBCProductDAO();
		List<IOther> searchResults = new ArrayList<>();
		
		conn = ConnectionManager.getInstance().openConnection();
		
		sql = "SELECT * FROM others;";
		
		try{
			stmt = conn.prepareStatement(sql);
			result = stmt.executeQuery();
			
			IOther Other = null;
			
			IProduct product = null;
			
			while(result.next()){
				
				product = productDAO.getProductByPROID(result.getString("FK_PRODOID"));
				
				Other = new Other(product.getProductName(), product.getPrice(), product.getRegistryDate(),
						product.getUserLoginID(), product.getEstablishmentID(), product.getProductID(),
						result.getString("size"), result.getString("type"), 
						result.getInt("otherID"));
				
				searchResults.add(Other);
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

	
	public IOther getOthersByProduct(Integer PRODID) {
		
		productDAO = new JDBCProductDAO();
		IOther searchResult = null;
		
		conn = ConnectionManager.getInstance().openConnection();
		
		sql = "SELECT * FROM others WHERE FK_PRODOID=?;";
		
		
		
		try{
			stmt = conn.prepareStatement(sql);
			
			stmt.setInt(1, PRODID);
			
			result = stmt.executeQuery();
			
			IProduct product = null;
			
			if(result.next()){
				
				product = productDAO.getProductByPROID(result.getString("FK_PRODOID"));
				
				searchResult = new Other(product.getProductName(), product.getPrice(), product.getRegistryDate(),
						product.getUserLoginID(), product.getEstablishmentID(), product.getProductID(),
						result.getString("size"), result.getString("type"), 
						result.getInt("otherID"));
				
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

	

	
	public List<IOther> getOthersBySize(String size) {
		
		List<IOther> searchResults = new ArrayList<>();
		
		conn = ConnectionManager.getInstance().openConnection();
		
		sql = "SELECT * FROM others WHERE size=?;";
		
		productDAO = new JDBCProductDAO();
		try{
			stmt = conn.prepareStatement(sql);
			
			stmt.setString(1, size);
			
			result = stmt.executeQuery();
			
			IOther Other = null;
			
			IProduct product = null;
			
			while(result.next()){
				
				product = productDAO.getProductByPROID(result.getString("FK_PRODOID"));
				
				Other = new Other(product.getProductName(), product.getPrice(), product.getRegistryDate(),
						product.getUserLoginID(), product.getEstablishmentID(), product.getProductID(),
						result.getString("size"), result.getString("type"), 
						result.getInt("otherID"));
				
				searchResults.add(Other);
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



	
	public List<IOther> getOthersByType(String type) {
		
		List<IOther> searchResults = new ArrayList<>();
		
		conn = ConnectionManager.getInstance().openConnection();
		
		sql = "SELECT * FROM others WHERE type=?;";
		
		productDAO = new JDBCProductDAO();
		try{
			stmt = conn.prepareStatement(sql);
			
			stmt.setString(1, type);
			
			result = stmt.executeQuery();
			
			
			IOther Other = null;
			
			IProduct product = null;
			
			while(result.next()){
				
				product = productDAO.getProductByPROID(result.getString("FK_PRODOID"));
				
				Other = new Other(product.getProductName(), product.getPrice(), product.getRegistryDate(),
						product.getUserLoginID(), product.getEstablishmentID(), product.getProductID(),
						result.getString("size"), result.getString("type"), 
						result.getInt("otherID"));
				
				searchResults.add(Other);
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

	
	public IOther getOthersByOID(String OTHEROID) {
		
		productDAO = new JDBCProductDAO();
		IOther searchResult = null;
		
		conn = ConnectionManager.getInstance().openConnection();
		
		sql = "SELECT * FROM others WHERE OTHEROID=?;";
		
		try{
			stmt = conn.prepareStatement(sql);
			
			stmt.setString(1, OTHEROID);
			
			result = stmt.executeQuery();
			
			
			IProduct product = null;
			
			if(result.next()){
				
				product = productDAO.getProductByPROID(result.getString("FK_PRODOID"));
				
				searchResult = new Other(product.getProductName(), product.getPrice(), product.getRegistryDate(),
						product.getUserLoginID(), product.getEstablishmentID(), product.getProductID(),
						result.getString("size"), result.getString("type"), 
						result.getInt("otherID"));
				
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


	
	public void insertOthers(IOther other) {
		
		

		UIDGenerator uidGenerator = UIDGenerator.getInstance();
		
		String OTHEROID = uidGenerator.getKey();
		String productOID = uidGenerator.getKey();
		
		IDGenerator idGenerator = new IDGenerator("otherID", "others");
		Integer otherID = idGenerator.nextValue();
		
		conn = ConnectionManager.getInstance().openConnection();
		
//		Product productOID;
//		
		productDAO = new JDBCProductDAO();
//		Product product = new Product(other.getProductName(), other.getPrice(),
//				other.getUserCreatorOID(), other.getEstablishmentOID(), other.getProductOID());
 		productDAO.insertProduct(other, productOID);
// 		
//		Integer productID = productDAO.getProductByPROID(productOID).getProductID();
		
		
		
		
		if(productDAO.getProductByPROID(productOID)!=null){
		
		try{
			
			sql = "INSERT INTO others (size, type, FK_PRODOID, otherID, OTHEROID) VALUES (?,?,?,?,?);";
			
			stmt = conn.prepareStatement(sql);
			
			stmt.setString(1, other.getSize());
			stmt.setString(2, other.getType());
			stmt.setString(3, productOID);
			stmt.setInt(4, otherID);
			stmt.setString(5, OTHEROID);
			
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

	
	public void updateOthers(IOther other) {
		
		if(getOthersByID(other.getOtherID())!=null){
			
		
//		Product productOID;
//		
		productDAO = new JDBCProductDAO();
//		Product product = new Product(other.getProductName(), other.getPrice(),
//				other.getUserCreatorOID(), other.getEstablishmentOID(), other.getProductOID());
 		productDAO.updateProduct(other);
// 		
//		productOID = productDAO.getProductByPROID(other.getProductOID());
		
		
 		conn = ConnectionManager.getInstance().openConnection();
		sql = "UPDATE others SET size=? , type=? , FK_PRODOID=? WHERE otherID=?;";
				
			try{
				stmt = conn.prepareStatement(sql);
				
				stmt.setString(1, other.getSize());
				stmt.setString(2, other.getType());
				stmt.setString(3, productDAO.getProductOIDByID(other.getProductID()));
				stmt.setInt(4, other.getOtherID());
				
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


	
	public void deleteOthers(Integer otherID) {
		productDAO = new JDBCProductDAO();
		
		IOther other = getOthersByID(otherID);
		if(other!=null){
				
				productDAO.deleteProduct(other.getProductID());
			
		}
	}


	@Override
	public String getOtherOIDByID(Integer otherID) {

		String OTHEROID = null;
		
		conn = ConnectionManager.getInstance().openConnection();
		
			
		sql = "SELECT * FROM others WHERE otherID=?;";
		
		try{
			
			stmt = conn.prepareStatement(sql);
			
			stmt.setInt(1, otherID);
			
			result = stmt.executeQuery();
			
			if(result.next()){
								
				OTHEROID =  result.getString("OTHEROID");
				 
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
		return OTHEROID;
	}


	@Override
	public IOther getOthersByID(Integer otherID) {
		String OTHEROID = this.getOtherOIDByID(otherID);
		IOther other = this.getOthersByOID(OTHEROID);
		return other;
	}

}
