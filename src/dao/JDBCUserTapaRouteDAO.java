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

import domain.ITapaRoute;
import domain.IUser;

public class JDBCUserTapaRouteDAO implements IUserTapaRouteDAO{

	private Connection conn; 
	private String sql;
	private PreparedStatement stmt;
	private ResultSet result;
	
	@Override
	public List<IUser> getAllUserFromUserTapaRoute(){
		conn = ConnectionManager.getInstance().openConnection();
		List<IUser> resultList = new ArrayList<IUser>();
		String userOID;
		IUser user;
		
		sql = "SELECT FK_USOID " +
				"FROM taparouteusers;";
		
		try {
			
			stmt = conn.prepareStatement(sql);
			result = stmt.executeQuery();
			
			while(result.next()){
				userOID = result.getString("FK_USOID");
				user = new JDBCUserDAO().getUserByOID(userOID);
				resultList.add(user);
			}
			
			result.close();
			stmt.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			ConnectionManager.getInstance().closeConnection(conn);
			try {
				if(result != null)
					result.close();
				if(stmt != null)
					stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		}
		
		return resultList;
	}
	
	@Override
	public List<IUser> getAllUserByRouteOID(ITapaRoute tapaRoute){
		conn = ConnectionManager.getInstance().openConnection();
		List<IUser> resultList = new ArrayList<IUser>();
		IUser o;
		
		sql = "SELECT FK_USOID " +
				"FROM taparouteusers " +
				"WHERE FK_ROUTEOID=?;";
		
		try {
			
			stmt = conn.prepareStatement(sql);
			
			stmt.setString(1, new JDBCTapaRouteDAO().getTapaRouteOIDByID(tapaRoute.getTapaRouteID()));
			
			result = stmt.executeQuery();
			
			while(result.next()){
				o = new JDBCUserDAO().getUserByOID(result.getString("FK_USOID"));
				resultList.add(o);
			}
			
			result.close();
			stmt.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			ConnectionManager.getInstance().closeConnection(conn);
			try {
				if(result != null)
					result.close();
				if(stmt != null)
					stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return resultList;
	}
	
	@Override
	public List<ITapaRoute> getAllTapaRoutesFromUserTapaRoute(){
		conn = ConnectionManager.getInstance().openConnection();
		List<ITapaRoute> resultList = new ArrayList<ITapaRoute>();
		ITapaRoute tapaRoute;
		
		sql = "SELECT FK_ROUTEOID " +
				"FROM taparouteusers;";
		
		try {
			
			stmt = conn.prepareStatement(sql);
			result = stmt.executeQuery();
			
			while(result.next()){
				tapaRoute = new JDBCTapaRouteDAO().getTapaRouteByOID(result.getString("FK_ROUTEOID"));
				resultList.add(tapaRoute);
			}
			
			result.close();
			stmt.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			ConnectionManager.getInstance().closeConnection(conn);
			try {
				if(result != null)
					result.close();
				if(stmt != null)
					stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return resultList;
	}
	
	@Override
	public List<ITapaRoute> getAllTapaRoutesByUserOID(IUser user){
		IUserDAO userDAO = new JDBCUserDAO();
		String userOID = userDAO.getUserOIDByLogin(user.getLogin());
		
		conn = ConnectionManager.getInstance().openConnection();
		List<ITapaRoute> resultList = new ArrayList<ITapaRoute>();
		ITapaRoute o;
		
		sql = "SELECT FK_ROUTEOID " +
				"FROM taparouteusers " +
				"WHERE FK_USOID=?;";
		
		try {
			
			stmt = conn.prepareStatement(sql);
			
			stmt.setString(1, userOID);
			
			result = stmt.executeQuery();
			
			while(result.next()){
				o = new JDBCTapaRouteDAO().getTapaRouteByOID(result.getString("FK_ROUTEOID"));
				resultList.add(o);
			}
			
			result.close();
			stmt.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			ConnectionManager.getInstance().closeConnection(conn);
			try {
				if(result != null)
					result.close();
				if(stmt != null)
					stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return resultList;
	}	

	@Override
	public void insertUsersTapaRoute(IUser user, ITapaRoute tapaRoute){
		conn = ConnectionManager.getInstance().openConnection();
		
		sql = "INSERT INTO taparouteusers(TRUSEROID, tapaRouteUserID,FK_USOID,FK_ROUTEOID) " +
				"VALUES (?,?,?,?);";
		
		UIDGenerator uidGenerator = UIDGenerator.getInstance();
		String userTapaRouteOID = uidGenerator.getKey();
		
		try {
			
			stmt = conn.prepareStatement(sql);
			
			stmt.setString(1, userTapaRouteOID);
			stmt.setInt(2, new IDGenerator("tapaRouteUserID", "taparouteusers").nextValue());
			stmt.setString(3, new JDBCUserDAO().getUserOIDByLogin(user.getLogin()));
			Integer routeID = new IDGenerator("tapaRouteID","taparoutes").currentValue();
			stmt.setString(4, new JDBCTapaRouteDAO().getTapaRouteOIDByID(routeID));
			
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
	
	@Override
	public void deleteUsersTapaRoute(IUser user, ITapaRoute tapaRoute){
		conn = ConnectionManager.getInstance().openConnection();
		
		sql = "DELETE FROM taparouteusers " +
			  "WHERE FK_USOID=? AND FK_ROUTEOID=?;";
				
		try {
			
			stmt = conn.prepareStatement(sql);
			
			stmt.setString(1, new JDBCUserDAO().getUserOIDByLogin(user.getLogin()));
			stmt.setString(2, new JDBCTapaRouteDAO().getTapaRouteOIDByID(tapaRoute.getTapaRouteID()));
			
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
