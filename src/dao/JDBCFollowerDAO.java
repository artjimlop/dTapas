package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import manager.ConnectionManager;
import utils.UIDGenerator;
import domain.IUser;

public class JDBCFollowerDAO implements IFollowerDAO {

	private Connection conn; 
	private String sql;
	private PreparedStatement stmt;
	private ResultSet result;
	private IUserDAO userDAO;
	
	//Lista de usuarios que sigo
	public List<IUser> getMyFollowed(String userlogin) {
		
		List<IUser> searchResult = new ArrayList<>();
		
		conn = ConnectionManager.getInstance().openConnection();
		
		sql = "SELECT * FROM followers;";
		
		userDAO= new JDBCUserDAO();
		
		try{
			stmt = conn.prepareStatement(sql);
			
			result = stmt.executeQuery();
			
			while(result.next()){
				if(userDAO.getUserOIDByLogin(userlogin).equals(result.getString("FK_USEROID")))
					searchResult.add(userDAO.getUserByOID(result.getString("FK_FOLLOWEDOID")));
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
	public List<IUser> getMyFollowers(String userlogin) {
		List<IUser> searchResult = new ArrayList<>();
		
		conn = ConnectionManager.getInstance().openConnection();
		
		sql = "SELECT * FROM followers;";
		
		
		try{
			stmt = conn.prepareStatement(sql);
			
			result = stmt.executeQuery();
			userDAO= new JDBCUserDAO();
			
			while(result.next()){
				if(userDAO.getUserOIDByLogin(userlogin).equals(result.getString("FK_FOLLOWEDOID")))
					searchResult.add(userDAO.getUserByOID(result.getString("FK_USEROID")));
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
	public void insetFollower(String loginFollowed,
			String loginFollowers) {
		
		
		UIDGenerator uidGenerator = UIDGenerator.getInstance();
		String FOLLOWOID = uidGenerator.getKey();
		
		conn = ConnectionManager.getInstance().openConnection();
		
		sql = "INSERT INTO followers (FOLLOWOID, FK_USEROID, FK_FOLLOWEDOID) VALUES (?, ? ,?);";
		
		userDAO= new JDBCUserDAO();
		
		try{
			stmt = conn.prepareStatement(sql);
			
			stmt.setString(1, FOLLOWOID);
			stmt.setString(2, userDAO.getUserOIDByLogin(loginFollowed));
			stmt.setString(3, userDAO.getUserOIDByLogin(loginFollowers));
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
	
	
		
	
	public void deleteFollower( String userCurrent, String userSuggest) {
		
		userDAO= new JDBCUserDAO();
		
		if (userDAO.getUserOIDByLogin(userCurrent)!=null && userDAO.getUserOIDByLogin(userSuggest)!=null){
			
			conn = ConnectionManager.getInstance().openConnection();
			
			sql = "DELETE FROM followers  WHERE FK_USEROID=? AND FK_FOLLOWEDOID=?;";
						
			
			try {
				
				stmt = conn.prepareStatement(sql);
				
				stmt.setString(1, userDAO.getUserOIDByLogin(userCurrent));
				stmt.setString(2, userDAO.getUserOIDByLogin(userSuggest));
				
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
	public String getFollowerByOID(String followerOID) {
		
		String searchResult = null;
		conn = ConnectionManager.getInstance().openConnection();
		
		sql = "SELECT * FROM followers WHERE FOLLOWOID=?;";
		
		try{
			
			stmt = conn.prepareStatement(sql);
			
			stmt.setString(1, followerOID);
			
			result = stmt.executeQuery();
			
			if(result.next()){
				
				searchResult = result.getString("FOLLOWOID");
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
	public IUser getFollowerBylogin(String userlogin) {
		
		userDAO= new JDBCUserDAO();
		IUser searchResult = null;
		conn = ConnectionManager.getInstance().openConnection();
		
		
		sql = "SELECT * FROM followers WHERE FOLLOWOID=?;";
		
		try{
			
			stmt = conn.prepareStatement(sql);
			
			stmt.setString(1, userDAO.getUserOIDByLogin(userlogin));
			
			result = stmt.executeQuery();
			
			if(result.next()){
				
				searchResult = userDAO.getUserByOID(result.getString("FOLLOWOID"));
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
	public String getFollowerOIDbylogin(String userlogin) {
		return null;
	}

	
}
