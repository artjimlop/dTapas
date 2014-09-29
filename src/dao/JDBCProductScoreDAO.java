package dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import utils.IDGenerator;
import utils.UIDGenerator;

import manager.ConnectionManager;

import domain.IProduct;
import domain.IProductScore;
import domain.IUser;
import domain.ProductScore;

public class JDBCProductScoreDAO implements IProductScoreDAO {
	
	private Connection conn; 
	private String sql;
	private PreparedStatement stmt;
	private ResultSet result;
	
	private IUserDAO userDAO;
	private IProductDAO productDAO;
	
	@Override
	public String getProductScoreOIDByID(Integer id) {
		conn = ConnectionManager.getInstance().openConnection();
		String oid=null;
		
		sql = "SELECT PRODSCOREOID FROM productscores " +
				"WHERE productScoreID=?;";
		
		try{
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, id);
			result = stmt.executeQuery();
		
			
			while(result.next()){
				
				oid = result.getString("PRODSCOREOID");
				
			}
			
			result.close();
			stmt.close();
			
		}catch (SQLException e) {
			e.printStackTrace();
		}finally{
			ConnectionManager.getInstance().closeConnection(conn);
			try{
				if(result!=null){
					result.close();
				}
				if(stmt != null){
					stmt.close();
				}
			}catch (SQLException e) {
			}
		}
		
		return oid;
	}
	
	@Override
	public List<IProductScore> getAllScores() {
		List<IProductScore> searchResults = new ArrayList<>();
		conn = ConnectionManager.getInstance().openConnection();
		
		sql = "SELECT * FROM productscores " +
				"ORDER BY mediumScore;";
		
		try{
			stmt = conn.prepareStatement(sql);
			result = stmt.executeQuery();
			
			IProductScore score = null;
			
			userDAO = new JDBCUserDAO();
			productDAO = new JDBCProductDAO();
			IProduct product;
			IUser user;
			
			while(result.next()){
				
				user = userDAO.getUserByOID(result.getString("FK_USOID"));
				product = productDAO.getProductByPROID(result.getString("FK_PRODOID"));
				
				score = new ProductScore(result.getDouble("mediumScore"), result.getDouble("presentationScore"),
						result.getDouble("quantityScore"), result.getDouble("priceScore"),
						result.getDate("scoreDate"),result.getTime("socreTime"), user.getLogin(), product.getProductID(), result.getInt("productScoreID"));
				
				searchResults.add(score);
			}
			
			result.close();
			stmt.close();
			
		}catch (SQLException e) {
			e.printStackTrace();
		}finally{
			ConnectionManager.getInstance().closeConnection(conn);
			try{
				if(result!=null){
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
	public List<IProductScore> getScoresByUser(String userLogin) {
		this.userDAO = new JDBCUserDAO();
		String userOID = this.userDAO.getUserOIDByLogin(userLogin);
		
		List<IProductScore> searchResults = new ArrayList<>();
		conn = ConnectionManager.getInstance().openConnection();
		
		sql = "SELECT * FROM productscores " +
				"WHERE (FK_USOID=?);";
		
		try{
			stmt = conn.prepareStatement(sql);
			
			stmt.setString(1, userOID);
			
			result = stmt.executeQuery();
			
			IProductScore score = null;
			
			userDAO = new JDBCUserDAO();
			productDAO = new JDBCProductDAO();
			IProduct product;
			IUser user;
			
			while(result.next()){
				
				user = userDAO.getUserByOID(result.getString("FK_USOID"));
				product = productDAO.getProductByPROID(result.getString("FK_PRODOID"));
				
				score = new ProductScore(result.getDouble("mediumScore"), result.getDouble("presentationScore"),
						result.getDouble("quantityScore"), result.getDouble("priceScore"),
						result.getDate("scoreDate"),result.getTime("scoreTime"), user.getLogin(), product.getProductID(), result.getInt("productScoreID"));
				
				searchResults.add(score);
			}
			
			result.close();
			stmt.close();
			
		}catch (SQLException e) {
			e.printStackTrace();
		}finally{
			ConnectionManager.getInstance().closeConnection(conn);
			try{
				if(result!=null){
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
	public List<IProductScore> getScoresByProduct(String productOID) {
		List<IProductScore> searchResults = new ArrayList<>();
		conn = ConnectionManager.getInstance().openConnection();
		
		sql = "SELECT * FROM productscores " +
				"WHERE (FK_PRODOID=?);";
		
		try{
			stmt = conn.prepareStatement(sql);
			
			stmt.setString(1, productOID);
			
			result = stmt.executeQuery();
			
			IProductScore score = null;
			
			userDAO = new JDBCUserDAO();
			productDAO = new JDBCProductDAO();
			IProduct product;
			IUser user;
			
			while(result.next()){
				
				user = userDAO.getUserByOID(result.getString("FK_USOID"));
				product = productDAO.getProductByPROID(result.getString("FK_PRODOID"));
				
				score = new ProductScore(result.getDouble("mediumScore"), result.getDouble("presentationScore"),
						result.getDouble("quantityScore"), result.getDouble("priceScore"),
						result.getDate("scoreDate"),result.getTime("socreTime"), user.getLogin(), product.getProductID(), result.getInt("productScoreID"));
				
				searchResults.add(score);
			}
			
			result.close();
			stmt.close();
			
		}catch (SQLException e) {
			e.printStackTrace();
		}finally{
			ConnectionManager.getInstance().closeConnection(conn);
			try{
				if(result!=null){
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
	public IProductScore getProductScorebyOID(String productScoreOID) {
		IProductScore searchResult = null;
		IUser user = null;
		IProduct product = null;
		conn = ConnectionManager.getInstance().openConnection();
		
		sql = "SELECT * FROM productscores WHERE (PRODSCOREOID=?);";
		
		try{
			stmt = conn.prepareStatement(sql);
			
			stmt.setString(1, productScoreOID);
			
			result = stmt.executeQuery();
			userDAO = new JDBCUserDAO();
			productDAO = new JDBCProductDAO();
			
			if(result.next()){
				
				user = userDAO.getUserByOID(result.getString("FK_USOID"));
				product = productDAO.getProductByPROID(result.getString("FK_PRODOID"));
				
				searchResult = new ProductScore(result.getDouble("mediumScore"), result.getDouble("presentationScore"),
						result.getDouble("quantityScore"), result.getDouble("priceScore"),
						result.getDate("scoreDate"),result.getTime("socreTime"), user.getLogin(), product.getProductID(), result.getInt("productScoreID"));
				
			}
			
			result.close();
			stmt.close();
			
		}catch (SQLException e) {
			e.printStackTrace();
		}finally{
			ConnectionManager.getInstance().closeConnection(conn);
			try{
				if(result!=null){
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
	public IProductScore getProductScorebyID(Integer productScoreID) {
		IProductScore searchResult = null;
		conn = ConnectionManager.getInstance().openConnection();
		
		IUser user = null;
		IProduct product = null;
		
		sql = "SELECT * FROM productscores WHERE (productScoreID=?);";
		
		try{
			stmt = conn.prepareStatement(sql);
			
			stmt.setInt(1, productScoreID);
			
			result = stmt.executeQuery();
			
			userDAO = new JDBCUserDAO();
			productDAO = new JDBCProductDAO();
			
			if(result.next()){
				
				user = userDAO.getUserByOID(result.getString("FK_USOID"));
				product = productDAO.getProductByPROID(result.getString("FK_PRODOID"));
				
				searchResult = new ProductScore(result.getDouble("mediumScore"), result.getDouble("presentationScore"),
						result.getDouble("quantityScore"), result.getDouble("priceScore"),
						result.getDate("scoreDate"),result.getTime("socreTime"), user.getLogin(), product.getProductID(), result.getInt("productScoreID"));
				
			}
			
			result.close();
			stmt.close();
			
		}catch (SQLException e) {
			e.printStackTrace();
		}finally{
			ConnectionManager.getInstance().closeConnection(conn);
			try{
				if(result!=null){
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
	public List<IProductScore> getScoresByCreationDate(Date scoreCreationDate) {
		List<IProductScore> searchResults = new ArrayList<>();
		conn = ConnectionManager.getInstance().openConnection();
		
		sql = "SELECT * FROM productscores WHERE scoreDate = ?;";
		
		try{
			stmt = conn.prepareStatement(sql);
			
			stmt.setDate(1, scoreCreationDate);
			
			result = stmt.executeQuery();
			
			IProductScore score = null;
			
			userDAO = new JDBCUserDAO();
			productDAO = new JDBCProductDAO();
			IProduct product;
			IUser user;
			
			while(result.next()){
				
				user = userDAO.getUserByOID(result.getString("FK_USOID"));
				product = productDAO.getProductByPROID(result.getString("FK_PRODOID"));
				
				score = new ProductScore(result.getDouble("mediumScore"), result.getDouble("presentationScore"),
						result.getDouble("quantityScore"), result.getDouble("priceScore"),
						result.getDate("scoreDate"),result.getTime("socreTime"), user.getLogin(), product.getProductID(), result.getInt("productScoreID"));
				
				searchResults.add(score);
			}
			
			result.close();
			stmt.close();
			
		}catch (SQLException e) {
			e.printStackTrace();
		}finally{
			ConnectionManager.getInstance().closeConnection(conn);
			try{
				if(result!=null){
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
	public void insertProductScore(IProductScore productScore){
		
		conn = ConnectionManager.getInstance().openConnection();
		
		String sql = "INSERT INTO productscores (mediumScore, presentationScore, quantityScore, priceScore, " +
				"scoreDate,scoreTime, PRODSCOREOID, productScoreID, FK_USOID, FK_PRODOID)" +
				" VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?) ;";
        

        try {
            stmt = conn.prepareStatement(sql);
            
            UIDGenerator uidGenerator = UIDGenerator.getInstance();
            
            userDAO = new JDBCUserDAO();
            productDAO = new JDBCProductDAO();

            stmt.setDouble(1, productScore.getMediumScore());
            stmt.setDouble(2, productScore.getPresentationScore());
            stmt.setDouble(3, productScore.getQuantityScore());
            stmt.setDouble(4, productScore.getPriceScore());
            stmt.setDate(5, productScore.getScoreDate());
            stmt.setTime(6, productScore.getProductScoreTime());
            stmt.setString(7, uidGenerator.getKey());
            stmt.setInt(8, new IDGenerator("productScoreID", "productscores").nextValue());
            stmt.setString(9, userDAO.getUserOIDByLogin(productScore.getLogin()) );
            stmt.setString(10, productDAO.getProductOIDByID(productScore.getProductID()));

            stmt.executeUpdate();
            
			stmt.close();

        } catch (SQLException e) {
            System.out.println("Message: " + e.getMessage());
            System.out.println("SQLState: " + e.getSQLState());
            System.out.println("ErrorCode: " + e.getErrorCode());
        } finally {
            ConnectionManager.getInstance().closeConnection(conn);
            try {
				if(stmt != null)
					stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
        }
		
	}
	
	@Override
	public void updateProductScore(IProductScore productScore){
		conn = ConnectionManager.getInstance().openConnection();
		
		sql = "UPDATE productscores " +
				"SET mediumScore=?,presentationScore=?,quantityScore=?,priceScore=?,scoreDate=? " +
				"WHERE PRODSCOREID = ?;";
		
		try{
			stmt = conn.prepareStatement(sql);

            stmt.setDouble(1, productScore.getMediumScore());
            stmt.setDouble(2, productScore.getPresentationScore());
            stmt.setDouble(3, productScore.getQuantityScore());
            stmt.setDouble(4, productScore.getPriceScore());
            stmt.setDate(5, productScore.getScoreDate());
            stmt.setInt(6, productScore.getProductScoreID());
			
			stmt.close();
			
		}catch (SQLException e) {
			System.out.println("Message: " + e.getMessage());
            System.out.println("SQLState: " + e.getSQLState());
            System.out.println("ErrorCode: " + e.getErrorCode());
		}finally{
			ConnectionManager.getInstance().closeConnection(conn);
			try {
				if(stmt != null)
					stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	@Override
	public void deleteProductScore(Integer productScoreID){
		
		conn = ConnectionManager.getInstance().openConnection();
		
		sql = "DELETE FROM productscores WHERE productScoreID = ?;";
		
		try {
			
			stmt = conn.prepareStatement(sql);
			
			stmt.setInt(1, productScoreID);
			
			stmt.executeUpdate();
			
			stmt.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			ConnectionManager.getInstance().closeConnection(conn);
			try {
				if(stmt != null)
					stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}	
	}
	
}
