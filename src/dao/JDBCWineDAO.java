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
import domain.IProduct;
import domain.IWine;
import domain.Wine;

public class JDBCWineDAO implements IWineDAO {
	
	
	private Connection conn; 
	private String sql;
	private PreparedStatement stmt;
	private ResultSet result;
	
	private IProductDAO productDAO;
	
	public List<IWine> getAllWines() {
		
		List<IWine> searchResults = new ArrayList<>();
		conn = ConnectionManager.getInstance().openConnection();
		
		sql = "SELECT * FROM wines;";
		
		try{
			stmt = conn.prepareStatement(sql);
			result = stmt.executeQuery();
			productDAO = new JDBCProductDAO();
			
			IWine wine = null;
			
			IProduct product = null;
			
			while(result.next()){
				
				product = productDAO.getProductByPROID(result.getString("FK_PRODOID"));
				
				wine = new Wine(product.getProductName(), product.getPrice(), product.getRegistryDate(),
						product.getUserLoginID(), product.getEstablishmentID(), product.getProductID(),
						result.getString("type"), result.getString("od"), result.getInt("year"),
						result.getString("growUpTime"), result.getString("label"), result.getInt("wineID"));
				
				searchResults.add(wine);
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

	public IWine getWineByProduct(Integer PRODID) {
		IWine searchResult = null;
		conn = ConnectionManager.getInstance().openConnection();
		
		sql = "SELECT * FROM wines WHERE (FK_PRODOID=?);";
		
		
		try{
			
			stmt = conn.prepareStatement(sql);
			
			stmt.setInt(1, PRODID);
			
			result = stmt.executeQuery();
			
			if(result.next()){
				
				productDAO = new JDBCProductDAO();
	
				IProduct product = productDAO.getProductByPROID(result.getString("FK_PRODOID"));
				
				searchResult = new Wine(product.getProductName(), product.getPrice(), product.getRegistryDate(),
						product.getUserLoginID(), product.getEstablishmentID(), product.getProductID(),
						result.getString("type"), result.getString("od"), result.getInt("year"),
						result.getString("growUpTime"), result.getString("label"), result.getInt("wineID"));
				
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

	public List<IWine> getWinesByType(String type) {
		List<IWine> searchResults = new ArrayList<>();
		conn = ConnectionManager.getInstance().openConnection();
		
		sql = "SELECT * FROM wines WHERE type=? ORDER BY type;";
		
		try{
			stmt = conn.prepareStatement(sql);
			
			stmt.setString(1, type);
			
			result = stmt.executeQuery();
			productDAO = new JDBCProductDAO();
			
			IWine wine = null;
			
			IProduct product = null;
			
			while(result.next()){
				product = productDAO.getProductByPROID(result.getString("FK_PRODOID"));
				
				wine = new Wine(product.getProductName(), product.getPrice(), product.getRegistryDate(),
						product.getUserLoginID(), product.getEstablishmentID(), product.getProductID(),
						result.getString("type"), result.getString("od"), result.getInt("year"),
						result.getString("growUpTime"), result.getString("label"), result.getInt("wineID"));
				
				searchResults.add(wine);
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

	
	public List<IWine> getWinesByOd(String od) {
		List<IWine> searchResults = new ArrayList<>();
		conn = ConnectionManager.getInstance().openConnection();
		
		sql = "SELECT * FROM wines WHERE od=? ORDER BY od;";
		
		try{
			
			stmt = conn.prepareStatement(sql);
			
			stmt.setString(1, od);
			
			result = stmt.executeQuery();
			productDAO = new JDBCProductDAO();
			
			IWine wine = null;
			
			IProduct product = null;
			
			while(result.next()){
				
				product = productDAO.getProductByPROID(result.getString("FK_PRODOID"));
				
				wine = new Wine(product.getProductName(), product.getPrice(), product.getRegistryDate(),
						product.getUserLoginID(), product.getEstablishmentID(), product.getProductID(),
						result.getString("type"), result.getString("od"), result.getInt("year"),
						result.getString("growUpTime"), result.getString("label"), result.getInt("wineID"));
				
				searchResults.add(wine);
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



	public List<IWine> getWinesByYear(Integer year) {
		List<IWine> searchResults = new ArrayList<>();
		conn = ConnectionManager.getInstance().openConnection();
		
		sql = "SELECT * FROM wines WHERE year=? ORDER BY year;";
		
		try{
			
			stmt = conn.prepareStatement(sql);
			
			stmt.setInt(1, year);
			
			result = stmt.executeQuery();
			productDAO = new JDBCProductDAO();
			
			IWine wine = null;
			
			IProduct product = null;
			
			while(result.next()){
				
				product = productDAO.getProductByPROID(result.getString("FK_PRODOID"));
				
				wine = new Wine(product.getProductName(), product.getPrice(), product.getRegistryDate(),
						product.getUserLoginID(), product.getEstablishmentID(), product.getProductID(),
						result.getString("type"), result.getString("od"), result.getInt("year"),
						result.getString("growUpTime"), result.getString("label"), result.getInt("wineID"));
				
				searchResults.add(wine);
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

	public List<IWine> getWinesBygrowuptime(String growuptime) {
		List<IWine> searchResults = new ArrayList<>();
		conn = ConnectionManager.getInstance().openConnection();
		
		sql = "SELECT * FROM wines WHERE growUpTime=? ORDER BY growUpTime;";
		
		try{
			
			stmt = conn.prepareStatement(sql);
			
			stmt.setString(1, growuptime);
			
			result = stmt.executeQuery();
			productDAO = new JDBCProductDAO();
			
			IWine wine = null;
			
			IProduct product = null;
			
			while(result.next()){
				
				product = productDAO.getProductByPROID(result.getString("FK_PRODOID"));
				
				wine = new Wine(product.getProductName(), product.getPrice(), product.getRegistryDate(),
						product.getUserLoginID(), product.getEstablishmentID(), product.getProductID(),
						result.getString("type"), result.getString("od"), result.getInt("year"),
						result.getString("growUpTime"), result.getString("label"), result.getInt("wineID"));
				
				searchResults.add(wine);
			
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


	public List<IWine> getWinesBylabel(String label) {
		
		List<IWine> searchResults = new ArrayList<>();
		conn = ConnectionManager.getInstance().openConnection();
		
		sql = "SELECT * FROM wines WHERE label=? ORDER BY label;";
		
		try{
			
			stmt = conn.prepareStatement(sql);
			
			stmt.setString(1, label);
			
			result = stmt.executeQuery();
			productDAO = new JDBCProductDAO();
			
			IWine wine = null;
			
			IProduct product = null;
			
			while(result.next()){
				product = productDAO.getProductByPROID(result.getString("FK_PRODOID"));
				
				wine = new Wine(product.getProductName(), product.getPrice(), product.getRegistryDate(),
						product.getUserLoginID(), product.getEstablishmentID(), product.getProductID(),
						result.getString("type"), result.getString("od"), result.getInt("year"),
						result.getString("growUpTime"), result.getString("label"), result.getInt("wineID"));
				
				searchResults.add(wine);
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

	public void insertWine(IWine wine) {
		

		UIDGenerator uidGenerator = UIDGenerator.getInstance();
		
		String wineOID = uidGenerator.getKey();
		String productOID = uidGenerator.getKey();
		
		IDGenerator idGenerator = new IDGenerator("wineID", "wines");
		Integer wineID = idGenerator.nextValue();
		
//		Product productOID;
//		
		productDAO = new JDBCProductDAO();
//		Product product = new Product(wine.getProductName(), wine.getPrice(),
//				wine.getUserCreatorOID(), wine.getEstablishmentOID(), wine.getProductOID());
//		
 		productDAO.insertProduct(wine, productOID);
 		
// 		
// 		
//		Integer productID = productDAO.getProductByPROID(productOID).getProductID();
		
		
		
		if(productDAO.getProductByPROID(productOID)!=null){
		
			conn = ConnectionManager.getInstance().openConnection();
			sql = "INSERT INTO wines (type, od, year, growUpTime, label, FK_PRODOID, wineID, WINEOID) VALUES (?,?,?,?,?,?,?,?);";
			
			try{
				stmt = conn.prepareStatement(sql);
				
				stmt.setString(1, wine.getType());
				stmt.setString(2, wine.getOd());
				stmt.setInt(3, wine.getYear());
				stmt.setString(4, wine.getGrowUpTime());
				stmt.setString(5, wine.getLabel());
				stmt.setString(6, productOID);
				stmt.setInt(7, wineID);
				stmt.setString(8, wineOID);
				
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

		/*private Integer selectOIDOfProduct(String productName, Date makeDate, Double price, Integer USOID, Integer ESTOID){
			
			Integer oid = null;
			conn = ConnectionManager.getInstance().openConnection();
			
			sql = "SELECT * FROM producto WHERE (nombreProducto = ?, fechaAlta = ?, precio = ?, FK_USOID = ?, FK_ESTOID = ?);";
			
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
	public void updateWine(IWine wine) {
		
		if(getWineByID(wine.getWineID())!=null){
			
				
		
//			Product productOID;
//			
			productDAO = new JDBCProductDAO();
//			Product product = new Product(wine.getProductName(), wine.getPrice(),
//					wine.getUserCreatorOID(), wine.getEstablishmentOID(), wine.getProductOID());
//			
	 		productDAO.updateProduct(wine);
//	 		
//			productOID = productDAO.getProductByPROID(wine.getProductOID());
		
	 		conn = ConnectionManager.getInstance().openConnection();
	 		
			sql = "UPDATE wines SET type=?, od=?, year=?, growUpTime=?, label=?, FK_PRODOID=? WHERE wineID=?;";
				
			try{
				stmt = conn.prepareStatement(sql);
				
				stmt.setString(1, wine.getType());
				stmt.setString(2, wine.getOd());
				stmt.setInt(3, wine.getYear());
				stmt.setString(4, wine.getGrowUpTime());
				stmt.setString(5, wine.getLabel());
				stmt.setString(6, productDAO.getProductOIDByID(wine.getProductID()));
				stmt.setInt(7, wine.getWineID());
				
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
	public void deleteWine(Integer wineID) {
		productDAO = new JDBCProductDAO();
		IWine wine = getWineByID(wineID);
		if(wine!=null){
			productDAO.deleteProduct(wine.getProductID());	
			
		}
	}

	public IWine getWineByOID(String WINEOID) {
		productDAO = new JDBCProductDAO();
		IWine searchResult = null;
		conn = ConnectionManager.getInstance().openConnection();
		
		sql = "SELECT * FROM wines WHERE WINEOID=?;";
		
		try{
			stmt = conn.prepareStatement(sql);
			
			stmt.setString(1, WINEOID);
			
			result = stmt.executeQuery();
						
			if(result.next()){
				
				IProduct product = productDAO.getProductByPROID(result.getString("FK_PRODOID"));
				
				searchResult = new Wine(product.getProductName(), product.getPrice(), product.getRegistryDate(),
						product.getUserLoginID(), product.getEstablishmentID(), product.getProductID(),
						result.getString("type"), result.getString("od"), result.getInt("year"),
						result.getString("growUpTime"), result.getString("label"), result.getInt("wineID"));
	
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
	public IWine getWineByID(Integer wineID) {
		
		String WINEOID = this.getWineOIDByID(wineID);
		IWine wine = this.getWineByOID(WINEOID);
		
		return wine;
	}

	@Override
	public String getWineOIDByID(Integer wineID) {

		String WINEOID = null;
		
		conn = ConnectionManager.getInstance().openConnection();
		
			
		sql = "SELECT * FROM wines WHERE wineID=?;";
		
		try{
			
			stmt = conn.prepareStatement(sql);
			
			stmt.setInt(1, wineID);
			
			result = stmt.executeQuery();
			
			if(result.next()){
								
				WINEOID =  result.getString("WINEOID");
				 
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
		return WINEOID;
	}

}
