package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import manager.ConnectionManager;
import utils.IDGenerator;
import utils.UIDGenerator;
import domain.ITapaRoute;
import domain.IUser;
import domain.TapaRoute;
/**
 * 
 * @author Arturo Jimenez
 *
 */
public class JDBCTapaRouteDAO implements ITapaRouteDAO {
	
	private Connection conn; 
	private String sql;
	private PreparedStatement stmt;
	private ResultSet result;
	
	
	public List<ITapaRoute> getAllRoutes() {
		
		List<ITapaRoute> searchResults = new ArrayList<>();
		
//		List<User> tapaRouteUsers = new ArrayList<>();
//		List<TapaRouteComment> tapaRouteComments = new ArrayList<>();
//		List<Establishment> tapaRouteEstablishments = new ArrayList<>();
		
		conn = ConnectionManager.getInstance().openConnection();
		
		sql = "SELECT * FROM taparoutes ORDER BY routeDate ;";
		
		try{
			stmt = conn.prepareStatement(sql);
			result = stmt.executeQuery();
			
//			tapaRouteUsers = new JDBCUserTapaRouteDAO().getAllUserFromUserTapaRoute();
//			tapaRouteComments = new JDBCTapaRouteCommentDAO().getAllCommentaries();
//			tapaRouteEstablishments = new JDBCEstablishmentTapaRouteDAO().getAllEstablishments();
			
			ITapaRoute tapaRoute = null;
			IUserDAO userDAO = new JDBCUserDAO();
			
			while(result.next()){
				
				
				IUser user = userDAO.getUserByOID(result.getString("FK_USOID"));
				String login = user.getLogin();
				
				tapaRoute = new TapaRoute(result.getString("nameRoute"),
						result.getDate("creationRouteDate"),
						result.getDate("routeDate"),
						login,
						result.getInt("tapaRouteID"));
				
				searchResults.add(tapaRoute);
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
	public List<ITapaRoute> getTapaRouteByName(String name) {
		List<ITapaRoute> searchResults = new ArrayList<>();
		
		conn = ConnectionManager.getInstance().openConnection();
		
		sql = "SELECT * FROM taparoutes " +
				"WHERE nameRoute = ? ;";
		
		try{
			stmt = conn.prepareStatement(sql);
			stmt.setString(1,name);
			result = stmt.executeQuery();
			
			
			
			ITapaRoute tapaRoute = null;
			
			while(result.next()){
				
				IUserDAO userDAO = new JDBCUserDAO();
				IUser user = userDAO.getUserByOID(result.getString("FK_USOID"));
				
				tapaRoute = new TapaRoute(result.getString("nameRoute"),
						result.getDate("creationRouteDate"),
						result.getDate("routeDate"),
						user.getLogin(),
						result.getInt("tapaRouteID"));
				
				searchResults.add(tapaRoute);
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
	public List<ITapaRoute> getTapaRouteByCreationDate(Date date) {
		List<ITapaRoute> searchResults = new ArrayList<>();
		
		
		conn = ConnectionManager.getInstance().openConnection();
		
		sql = "SELECT * FROM taparoutes " +
				"WHERE creationRouteDate = ? ;";
		
		try{
			stmt = conn.prepareStatement(sql);
			stmt.setDate(1, date);
			result = stmt.executeQuery();
			
			
			ITapaRoute tapaRoute = null;
			
			while(result.next()){
				
				IUserDAO userDAO = new JDBCUserDAO();
				IUser user = userDAO.getUserByOID(result.getString("FK_USOID"));
				
				tapaRoute = new TapaRoute(result.getString("nameRoute"),
						result.getDate("creationRouteDate"),
						result.getDate("routeDate"),
						user.getLogin(),
						result.getInt("tapaRouteID"));
				
				searchResults.add(tapaRoute);
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
	public List<ITapaRoute> getTapaRouteByTargetDate(Date date) {
		List<ITapaRoute> searchResults = new ArrayList<>();
		
		
		conn = ConnectionManager.getInstance().openConnection();
		
		sql = "SELECT * FROM taparoutes " +
				"WHERE routeDate= ? ;";
		
		try{
			stmt = conn.prepareStatement(sql);
			stmt.setDate(1, date);
			result = stmt.executeQuery();
			
			ITapaRoute tapaRoute = null;
			
			while(result.next()){
				
				IUserDAO userDAO = new JDBCUserDAO();
				IUser user = userDAO.getUserByOID(result.getString("FK_USOID"));
				
				tapaRoute = new TapaRoute(result.getString("nameRoute"),
						result.getDate("creationRouteDate"),
						result.getDate("routeDate"),
						user.getLogin(),
						result.getInt("tapaRouteID"));
				
				searchResults.add(tapaRoute);
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
	public List<ITapaRoute> getTapaRouteByCreatorUser(String USOID) {
		//pone USOID, pero en realidad estamos usando el login
		List<ITapaRoute> searchResults = new ArrayList<>();
		IUserDAO userDAO1 = new JDBCUserDAO();
		//usamos el login para obtener el OID
		String userOID = userDAO1.getUserOIDByLogin(USOID);

		conn = ConnectionManager.getInstance().openConnection();
		
		sql = "SELECT * FROM taparoutes " +
				"WHERE FK_USOID = ? ORDER BY routeDate ;";
		
		try{
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, userOID);
			result = stmt.executeQuery();
			
			ITapaRoute tapaRoute = null;
			
			while(result.next()){
			
				IUserDAO userDAO = new JDBCUserDAO();
				IUser user = userDAO.getUserByOID(result.getString("FK_USOID"));
				
				tapaRoute = new TapaRoute(result.getString("nameRoute"),
						result.getDate("creationRouteDate"),
						result.getDate("routeDate"),
						user.getLogin(),
						result.getInt("tapaRouteID"));
				
				searchResults.add(tapaRoute);
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
	public void insertTapaRoute(ITapaRoute tapaRoute) {
		
		conn = ConnectionManager.getInstance().openConnection();
		
		IDGenerator idGenerator = new IDGenerator("tapaRouteID", "taparoutes");
		Integer tapaRouteID = idGenerator.nextValue();
		
		UIDGenerator uidGenerator = UIDGenerator.getInstance();
		String tapaRouteOID = uidGenerator.getKey();
		
		IUserDAO userDAO = new JDBCUserDAO();
		String userOID = userDAO.getUserOIDByLogin(tapaRoute.getUserLogin());
		
		sql = "INSERT INTO taparoutes (nameRoute, creationRouteDate, routeDate,FK_USOID, ROUTEOID, tapaRouteID) " +
				"VALUES (?, ?, ?, ?, ?, ?);";
		
		try{
			stmt = conn.prepareStatement(sql);
			
			stmt.setString(1, tapaRoute.getName());
			stmt.setDate(2, tapaRoute.getRegistryDate());
			stmt.setDate(3, tapaRoute.getTargetDate());
			stmt.setString(4, userOID);
			stmt.setString(5, tapaRouteOID);
			stmt.setInt(6, tapaRouteID);
			
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

	@Override
	public void updateTapaRoute(ITapaRoute tapaRoute) {
		
		conn = ConnectionManager.getInstance().openConnection();
		
//		if(getTapaRouteByOID(tapaRoute.getTapaRouteOID())!=null){
		//String tapaRouteOID = this.getTapaRouteOIDByID(tapaRoute.getTapaRouteID());
		
			sql = "UPDATE taparoutes SET nameRoute=?, routeDate=? WHERE tapaRouteID = ? ;";
			
			try{
				stmt = conn.prepareStatement(sql);
				stmt.setString(1, tapaRoute.getName());
				stmt.setDate(2, tapaRoute.getTargetDate());
				stmt.setInt(3, tapaRoute.getTapaRouteID());
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

	@Override
	public void delete(Integer tapaRouteID) {
		
		conn = ConnectionManager.getInstance().openConnection();
		
		//if(getTapaRouteByOID(ROUTEOID)!=null){
		
			String sql = "DELETE FROM taparoutes WHERE tapaRouteID = ?;";
	
	        try {
	            stmt = conn.prepareStatement(sql);
	            stmt.setInt(1,tapaRouteID);
	            stmt.executeUpdate();
	        } catch (SQLException e) {
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
		//}
	}


	@Override
	public ITapaRoute getTapaRouteByOID(String ROUTEOID) {
		ITapaRoute tapaRoute = null;
		
		conn = ConnectionManager.getInstance().openConnection();
		
		sql = "SELECT * FROM taparoutes WHERE (ROUTEOID=?);";
		
		try{
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, ROUTEOID);
			result = stmt.executeQuery();
			
			if(result.next()){
				
				IUserDAO userDAO = new JDBCUserDAO();
				IUser user = userDAO.getUserByOID(result.getString("FK_USOID"));
				
				tapaRoute = new TapaRoute(result.getString("nameRoute"),
						result.getDate("creationRouteDate"),
						result.getDate("routeDate"),
						user.getLogin(),
						result.getInt("tapaRouteID"));
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
		
		return tapaRoute;
	}

	public ITapaRoute getTapaRouteByID(Integer tapaRouteID) {
		ITapaRoute searchResult = null;
		

		conn = ConnectionManager.getInstance().openConnection();
		
		sql = "SELECT * FROM taparoutes " +
				"WHERE tapaRouteID = ? ;";
		
		try{
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, tapaRouteID);
			result = stmt.executeQuery();
			
			while(result.next()){
				
				IUserDAO userDAO = new JDBCUserDAO();
				IUser user = userDAO.getUserByOID(result.getString("FK_USOID"));
				
				searchResult = new TapaRoute(result.getString("nameRoute"),
						result.getDate("creationRouteDate"),
						result.getDate("routeDate"),
						user.getLogin(),
						result.getInt("tapaRouteID"));
				
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
	
	public String getTapaRouteOIDByID(Integer tapaRouteID){
		String searchResult = null;

		conn = ConnectionManager.getInstance().openConnection();
		
		sql = "SELECT * FROM taparoutes " +
				"WHERE tapaRouteID = ? ;";
		
		try{
			stmt = conn.prepareStatement(sql);
			
			stmt.setInt(1, tapaRouteID);
			
			result = stmt.executeQuery();
			
			while(result.next()){
				
				searchResult = result.getString("ROUTEOID");
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

}