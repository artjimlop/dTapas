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
import domain.Comment;
import domain.IComment;
import domain.ITapaRoute;
import domain.ITapaRouteComment;
import domain.TapaRouteComment;
/**
 * 
 * @author Arturo Jimenez
 *
 */
public class JDBCTapaRouteCommentDAO implements ITapaRouteCommentDAO {
	
	private Connection conn; 
	private String sql;
	private PreparedStatement stmt;
	private ResultSet result;
	
	
	@Override
	public List<ITapaRouteComment> getAllCommentaries() {
		List<ITapaRouteComment> searchResults = new ArrayList<>();
		IComment commentFather = null;
		
		conn = ConnectionManager.getInstance().openConnection();
		
		sql = "SELECT * FROM taparoutecomments " +
				"ORDER BY FK_ROUTEOID;";
		
		ITapaRouteComment comment = null;
		
		try{
			stmt = conn.prepareStatement(sql);
			result = stmt.executeQuery();
			
			while(result.next()){
				commentFather = new JDBCCommentDAO().getCommentByOID(result.getString("FK_COMOID"));
				
				
				ITapaRoute tapaRoute = new JDBCTapaRouteDAO().getTapaRouteByOID(result.getString("FK_ROUTEOID"));
				
				comment = new TapaRouteComment(commentFather.getCommentarie(),
						commentFather.getCommentarieDate(),
						commentFather.getCommentarieTime(),
						result.getInt("tapaRouteCommentID"),
						commentFather.getUserCommentarieID(),
						tapaRoute.getTapaRouteID(),
						commentFather.getCommentarieID());
				
				searchResults.add(comment);
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
	public List<ITapaRouteComment> getCommentariesByUser(String login) {
		List<ITapaRouteComment> searchResults = new ArrayList<>();
		conn = ConnectionManager.getInstance().openConnection();
		
		sql = "SELECT * FROM taparoutecomments ;";
		
		try{
			stmt = conn.prepareStatement(sql);
			
			result = stmt.executeQuery();
			
			TapaRouteComment comment = null;
			IComment commentFather = null;
			
			while(result.next()){
				commentFather = new JDBCCommentDAO().getCommentByOID(result.getString("FK_COMOID"));
				
				if(commentFather.getUserCommentarieID().equals(login)){
					
					ITapaRoute tapaRoute = new JDBCTapaRouteDAO().getTapaRouteByOID(result.getString("FK_ROUTEOID"));
					
					comment = new TapaRouteComment(commentFather.getCommentarie(),
							commentFather.getCommentarieDate(),
							commentFather.getCommentarieTime(),
							result.getInt("tapaRouteCommentID"),
							commentFather.getUserCommentarieID(),
							tapaRoute.getTapaRouteID(),
							commentFather.getCommentarieID());
					
					searchResults.add(comment);
				}
				
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
	public List<ITapaRouteComment> getCommentariesByRoute(String ROUTEOID) {
		List<ITapaRouteComment> searchResults = new ArrayList<>();
		conn = ConnectionManager.getInstance().openConnection();
		
		sql = "SELECT * FROM taparoutecomments " +
				"WHERE FK_ROUTEOID = ? ;";
		
		try{
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, ROUTEOID);
			result = stmt.executeQuery();
			
			TapaRouteComment comment = null;
			IComment commentFather = null;
			
			while(result.next()){
				commentFather = new JDBCCommentDAO().getCommentByOID(result.getString("FK_COMOID"));
				
				ITapaRoute tapaRoute = new JDBCTapaRouteDAO().getTapaRouteByOID(result.getString("FK_ROUTEOID"));
				
				comment =  new TapaRouteComment(commentFather.getCommentarie(),
						commentFather.getCommentarieDate(),
						commentFather.getCommentarieTime(),
						result.getInt("tapaRouteCommentID"),
						commentFather.getUserCommentarieID(),
						tapaRoute.getTapaRouteID(),
						commentFather.getCommentarieID());
				
				searchResults.add(comment);
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
	public void insertComment(ITapaRouteComment tapaRouteComment) {
		conn = ConnectionManager.getInstance().openConnection();
		UIDGenerator uidGenerator = UIDGenerator.getInstance();
		
		IDGenerator idGenerator = new IDGenerator("tapaRouteCommentID", "taparoutecomments");
		Integer tapaRouteCommentID = idGenerator.nextValue();
		
		String commentOID = uidGenerator.getKey();
		
	
		new JDBCCommentDAO().insertComment(tapaRouteComment, commentOID);
	
		String tapaRouteCommentOID = uidGenerator.getKey();
		
		sql = "INSERT INTO taparoutecomments " +
				"(TRCOID, FK_COMOID, FK_ROUTEOID, tapaRouteCommentID) " +
				"VALUES (?, ?, ?, ?);";
		
		try{
			
			stmt = conn.prepareStatement(sql);
			
			Integer routeID = new IDGenerator("tapaRouteID","taparoutes").currentValue();
			String tapaRouteOID = new JDBCTapaRouteDAO().getTapaRouteOIDByID(routeID);
			
			stmt.setString(1,  tapaRouteCommentOID);
			stmt.setString(2, commentOID);
			stmt.setString(3, tapaRouteOID);
			stmt.setInt(4, tapaRouteCommentID);
			
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
	public void delete(Integer tapaRouteCommentID) {

		conn = ConnectionManager.getInstance().openConnection();
		
//		if(getTapaRouteCommentByOID(TRCOID)!=null){
		
			String sql = "DELETE FROM taparoutecomments WHERE tapaRouteCommentID = ?;";
	
	        try {
	            stmt = conn.prepareStatement(sql);
	            stmt.setInt(1, tapaRouteCommentID);
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
//		}
	}

	@Override
	public List<ITapaRouteComment> getCommentariesByDate(Date commentDate) {
		List<ITapaRouteComment> searchResults = new ArrayList<>();
		
		conn = ConnectionManager.getInstance().openConnection();
		
		sql = "SELECT * FROM taparoutecomments ;";
		
		try{
			stmt = conn.prepareStatement(sql);
			
			result = stmt.executeQuery();
			
			ITapaRouteComment comment = null;
			IComment commentFather = null;
			
			while(result.next()){
				commentFather = new JDBCCommentDAO().getCommentByOID(result.getString("FK_COMOID"));
				if(comment.getCommentarieDate().equals(commentDate)){
					
					ITapaRoute tapaRoute = new JDBCTapaRouteDAO().getTapaRouteByOID(result.getString("FK_ROUTEOID"));
					
					comment = new TapaRouteComment(commentFather.getCommentarie(),
							commentFather.getCommentarieDate(),
							commentFather.getCommentarieTime(),
							result.getInt("tapaRouteCommentID"),
							commentFather.getUserCommentarieID(),
							tapaRoute.getTapaRouteID(),
							commentFather.getCommentarieID());;
				}
				
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


	public ITapaRouteComment getTapaRouteCommentByOID(String tRCOID) {
		
		ITapaRouteComment searchResult = null;
		
		conn = ConnectionManager.getInstance().openConnection();
		
		sql = "SELECT * FROM taparoutecomments WHERE (TRCOID=?);";
		
		try{
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, tRCOID);
			result = stmt.executeQuery();
			IComment commentFather = new Comment();
			if(result.next()){
				commentFather = new JDBCCommentDAO().getCommentByOID(result.getString("FK_COMOID"));
				
				ITapaRoute tapaRoute = new JDBCTapaRouteDAO().getTapaRouteByOID(result.getString("FK_ROUTEOID"));
				
				searchResult = new TapaRouteComment(commentFather.getCommentarie(),
						commentFather.getCommentarieDate(),
						commentFather.getCommentarieTime(),
						result.getInt("tapaRouteCommentID"),
						commentFather.getUserCommentarieID(),
						tapaRoute.getTapaRouteID(),
						commentFather.getCommentarieID());
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
	
	public String getTapaRouteCommentOIDByID(Integer tapaRouteCommentID){
		String oid = null;
		conn = ConnectionManager.getInstance().openConnection();
		
		sql = "SELECT * FROM taparoutecomments " +
				"WHERE tapaRouteCommentID = ? ;";
		
		try{
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, tapaRouteCommentID);
			result = stmt.executeQuery();
			
			
			while(result.next()){
				oid = result.getString("TRCOID");
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
	public List<ITapaRouteComment> getCommentariesByRouteID(Integer routeID) {
		List<ITapaRouteComment> searchResults = new ArrayList<>();
		conn = ConnectionManager.getInstance().openConnection();
		
		sql = "SELECT * FROM taparoutecomments " +
				"WHERE tapaRouteCommentID = ? ;";
		
		try{
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, routeID);
			result = stmt.executeQuery();
			
			ITapaRouteComment comment = null;
			IComment commentFather = null;
			
			while(result.next()){
				commentFather = new JDBCCommentDAO().getCommentByOID(result.getString("FK_COMOID"));
				
				ITapaRoute tapaRoute = new JDBCTapaRouteDAO().getTapaRouteByOID(result.getString("FK_ROUTEOID"));
				
				comment = new TapaRouteComment(commentFather.getCommentarie(),
						commentFather.getCommentarieDate(),
						commentFather.getCommentarieTime(),
						result.getInt("tapaRouteCommentID"),
						commentFather.getUserCommentarieID(),
						tapaRoute.getTapaRouteID(),
						commentFather.getCommentarieID());
				
				searchResults.add(comment);
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
}
