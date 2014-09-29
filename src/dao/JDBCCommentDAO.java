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
import domain.Comment;
import domain.IComment;
import domain.IUser;
/**
 * 
 * @author Arturo Jimenez
 *
 */
public class JDBCCommentDAO implements ICommentDAO {
	
	private Connection conn; 
	private String sql;
	private PreparedStatement stmt;
	private ResultSet result;
	
	private IUserDAO userDAO;
	
	@Override
	public IComment getCommentByOID(String COMOID) {
		IComment searchResults = null;
		conn = ConnectionManager.getInstance().openConnection();
		
		sql = "SELECT * FROM comments " +
				"WHERE COMOID=?";
		
		try{
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, COMOID);
			result = stmt.executeQuery();
			
			IUser user = null;
			this.userDAO = new JDBCUserDAO();
			
			if(result.next()){
				
				user = this.userDAO.getUserByOID(result.getString("FK_USOID"));
/*
 * public Comment(String comment, Date commentDate, Integer USOID, Integer COMMENTOID)
 */
				searchResults = new Comment(result.getString("commentarie"), result.getDate("commentDate"),result.getTime("commentTime"),
						user.getLogin(), result.getInt("commentID"));
				
				
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
	public List<IComment> getAllComments() {
		List<IComment> searchResults = new ArrayList<>();
		conn = ConnectionManager.getInstance().openConnection();
		
		sql = "SELECT * FROM comments " +
				"ORDER BY COMOID;";
		
		try{
			stmt = conn.prepareStatement(sql);
			result = stmt.executeQuery();
			
			IComment comment = null;
			IUser user = null;
			this.userDAO = new JDBCUserDAO();
			
			while(result.next()){
				user = this.userDAO.getUserByOID(result.getString("FK_USOID"));
				
				comment = new Comment(result.getString("commentarie"), result.getDate("commentDate"),result.getTime("commentTime"),
						user.getLogin(), result.getInt("commentID"));
				
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
	public List<IComment> getCommentsByDate(Date date) {
		List<IComment> searchResults = new ArrayList<>();
		conn = ConnectionManager.getInstance().openConnection();
		
		sql = "SELECT * FROM comments " +
				"WHERE commentDate=?;";
		
		try{
			stmt = conn.prepareStatement(sql);
			stmt.setDate(1, date);
			result = stmt.executeQuery();
			
			IComment comment = null;
			IUser user = null;
			this.userDAO = new JDBCUserDAO();
			
			while(result.next()){
				user = this.userDAO.getUserByOID(result.getString("FK_USOID"));
				
				comment = new Comment(result.getString("commentarie"), result.getDate("commentDate"),result.getTime("commentTime"),
						user.getLogin(), result.getInt("commentID"));;
				
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
	public List<IComment> getCommentsByUser(String USOID) {
		List<IComment> searchResults = new ArrayList<>();
		
		conn = ConnectionManager.getInstance().openConnection();
		
		sql = "SELECT * FROM comments " +
				"WHERE FK_USOID=?";
		
		try{
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, USOID);
			result = stmt.executeQuery();
			
			IComment comment = null;
			IUser user = null;
			
			this.userDAO = new JDBCUserDAO();
			
			while(result.next()){
				user = this.userDAO.getUserByOID(result.getString("FK_USOID"));
				
				comment = new Comment(result.getString("commentarie"), result.getDate("commentDate"),result.getTime("commentTime"),
						user.getLogin(), result.getInt("commentID"));;
				
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
	
	public IComment getCommentByID(Integer commentID){
		
		conn = ConnectionManager.getInstance().openConnection();
		IComment comment = null;
		
		sql = "SELECT * FROM comments " +
				"WHERE commentID=?";
		
		try{
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, commentID);
			result = stmt.executeQuery();
			
			
			IUser user = null;
			
			this.userDAO = new JDBCUserDAO();
			
			if(result.next()){
				user = this.userDAO.getUserByOID(result.getString("FK_USOID"));
				
				comment = new Comment(result.getString("commentarie"), result.getDate("commentDate"),result.getTime("commentTime"),
						user.getLogin(), result.getInt("commentID"));;
				
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
		
		return comment;
		
	}

	@Override
	public void insertComment(IComment comment, String commentOID) {
		
		conn = ConnectionManager.getInstance().openConnection();
		
		IDGenerator idGenerator = new IDGenerator("commentID", "comments");
		Integer commentID = idGenerator.nextValue();
		
		this.userDAO = new JDBCUserDAO();
		String userOID = this.userDAO.getUserOIDByLogin(comment.getUserCommentarieID());
		
		String sql = "INSERT INTO comments (commentarie,commentDate,commentTime, COMOID,commentID, FK_USOID)" +
				" VALUES (?, ?, ?, ?, ?, ?) ";
        PreparedStatement stmt = null;
        

        try {
            stmt = conn.prepareStatement(sql);

            stmt.setString(1, comment.getCommentarie());
            stmt.setDate(2, comment.getCommentarieDate());
            stmt.setTime(3, comment.getCommentarieTime());
            stmt.setString(4, commentOID);
            stmt.setInt(5, commentID);
            stmt.setString(6, userOID);

            stmt.executeUpdate();

        } catch (SQLException e) {
            System.out.println("Message: " + e.getMessage());
            System.out.println("SQLState: " + e.getSQLState());
            System.out.println("ErrorCode: " + e.getErrorCode());
        } finally {
            ConnectionManager.getInstance().closeConnection(conn);
        	try {
                if (stmt != null) {
                    stmt.close();
                }
            } catch (SQLException e) {
            }
        }
		
	}
	
	@Override
	public void deleteComment(Integer commentID){
		String commentOID = this.getCommentOIDByID(commentID);
		
		conn = ConnectionManager.getInstance().openConnection();
		
		sql = "DELETE FROM comments WHERE COMOID = ?;";
		
		try {
			
			stmt = conn.prepareStatement(sql);
			
			stmt.setString(1, commentOID);
			
			stmt.executeUpdate();
			
		} catch (SQLException e) {
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
	}
	
	public String getCommentOIDByID(Integer commentID){
		
		String commentOID = null;	
		conn = ConnectionManager.getInstance().openConnection();
		
		sql = "SELECT * FROM comments WHERE(commentID=?);";
		
		try{
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, commentID);
			
			result = stmt.executeQuery();
		
			if(result.next()){
				
				commentOID = result.getString("COMOID");
				
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

	@Override
	public List<IComment> getCommentByUserID(String userLogin) {
		
		this.userDAO = new JDBCUserDAO();
		
		String userOID = this.userDAO.getUserOIDByLogin(userLogin);
		List<IComment> comments = this.getCommentsByUser(userOID);
		
		return comments;
	}

}
