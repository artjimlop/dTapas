package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import utils.IDGenerator;
import utils.UIDGenerator;
import manager.ConnectionManager;
import domain.*;

public class JDBCUserCommentDAO implements IUserCommentDAO{
	private Connection conn; 
	private String sql;
	private PreparedStatement stmt;
	private ResultSet result;
	private IUserDAO userDAO;
	private ICommentDAO commentDAO;
	
	@Override
	public List<IUserComment> getAllUserComments(){
		conn = ConnectionManager.getInstance().openConnection();
		List<IUserComment> resultList = new ArrayList<IUserComment>();
		IUserComment userComment = null;
		ICommentDAO commentDAO = new JDBCCommentDAO();
		IComment comment = null;
		
		sql = "SELECT * " +
				"FROM usercomments;";
		
		try {
			
			stmt = conn.prepareStatement(sql);
			result = stmt.executeQuery();
			
			IUser userWriteComment;
			IUser userOverComment;
			userDAO = new JDBCUserDAO();
			
			while(result.next()){
				comment = commentDAO.getCommentByOID(result.getString("FK_COMOID"));
				userWriteComment = userDAO.getUserByLogin(comment.getUserCommentarieID());
				userOverComment = userDAO.getUserByOID(result.getString("FK_USEROID"));
				
				userComment = new UserComment(comment.getCommentarieID(),userOverComment.getLogin(),userWriteComment.getLogin(),
						comment.getCommentarieDate(),comment.getCommentarieTime(),comment.getCommentarie(),result.getInt("userCommentID"));
				resultList.add(userComment);
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
	public IUserComment getUserCommentByUserCommentID(Integer id){
		conn = ConnectionManager.getInstance().openConnection();
		IUserComment userComment = null;
		ICommentDAO commentDAO = new JDBCCommentDAO();
		IComment comment = null;
		
		sql = "SELECT * " +
				"FROM usercomments " +
				"WHERE userCommentID=?;";
		
		try {
			
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, id);
			result = stmt.executeQuery();
			
			IUser userWriteComment;
			IUser userOverComment;
			userDAO = new JDBCUserDAO();
			
			while(result.next()){
				comment = commentDAO.getCommentByOID(result.getString("FK_COMOID"));
				userWriteComment = userDAO.getUserByLogin(comment.getUserCommentarieID());
				userOverComment = userDAO.getUserByOID(result.getString("FK_USEROID"));
				
				userComment = new UserComment(comment.getCommentarieID(),userOverComment.getLogin(),userWriteComment.getLogin(),
						comment.getCommentarieDate(),comment.getCommentarieTime(),comment.getCommentarie(),result.getInt("userCommentID"));
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
		
		return userComment;
	}
	
	@Override
	public List<IUserComment> getAllUserCommentsOverLogin(String login){
		userDAO = new JDBCUserDAO();
		String userLogin = userDAO.getUserOIDByLogin(login);
		
		conn = ConnectionManager.getInstance().openConnection();
		List<IUserComment> resultList = new ArrayList<IUserComment>();
		IUserComment userComment;
		ICommentDAO commentDAO = new JDBCCommentDAO();
		IComment comment;
		
		sql = "SELECT * " +
				"FROM usercomments " +
				"WHERE FK_USEROID=?;";
		
		try {
			
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, userLogin);
			result = stmt.executeQuery();
			
			IUser userWriteComment;
			IUser userOverComment;
			userDAO = new JDBCUserDAO();
			
			while(result.next()){
				comment = commentDAO.getCommentByOID(result.getString("FK_COMOID"));
				userWriteComment = userDAO.getUserByLogin(comment.getUserCommentarieID());
				userOverComment = userDAO.getUserByOID(result.getString("FK_USEROID"));
				
				userComment = new UserComment(comment.getCommentarieID(),userOverComment.getLogin(),userWriteComment.getLogin(),
						comment.getCommentarieDate(),comment.getCommentarieTime(),comment.getCommentarie(),result.getInt("userCommentID"));
				resultList.add(userComment);
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
	public List<IUserComment> getAllUserCommentsFromLogin(String login){
		conn = ConnectionManager.getInstance().openConnection();
		List<IUserComment> resultList = new ArrayList<IUserComment>();
		IUserComment userComment;
		
		sql = "SELECT * " +
				"FROM usercomments " +
				"WHERE FK_COMOID=?;";
		
		commentDAO = new JDBCCommentDAO();
		List<IComment> comments = commentDAO.getCommentByUserID(login);
		
		try {
			
			stmt = conn.prepareStatement(sql);
			
			IUser userWriteComment;
			IUser userOverComment;
			userDAO = new JDBCUserDAO();
			commentDAO = new JDBCCommentDAO();
			
			for(IComment comment: comments){
				stmt.setString(1, commentDAO.getCommentOIDByID(comment.getCommentarieID()));
				result = stmt.executeQuery();				
				
				while(result.next()){
					userWriteComment = userDAO.getUserByLogin(comment.getUserCommentarieID());
					userOverComment = userDAO.getUserByOID(result.getString("FK_USEROID"));
					
					userComment = new UserComment(comment.getCommentarieID(),userOverComment.getLogin(),userWriteComment.getLogin(),
							comment.getCommentarieDate(),comment.getCommentarieTime(),comment.getCommentarie(),result.getInt("userCommentID"));
					resultList.add(userComment);
				}
				
				result.close();
				
			}
			
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
	public List<IUserComment> getAllUserCommentsByDate(Date date){
		conn = ConnectionManager.getInstance().openConnection();
		List<IUserComment> resultList = new ArrayList<IUserComment>();		
		IUserComment userComment;
		
		sql = "SELECT * " +
				"FROM usercomments " +
				"WHERE FK_COMOID=?;";
		
		List<IComment> comments = commentDAO.getCommentsByDate(date);
		
		try {
			
			stmt = conn.prepareStatement(sql);
			
			IUser userWriteComment;
			IUser userOverComment;
			userDAO = new JDBCUserDAO();
			commentDAO = new JDBCCommentDAO();
			
			for(IComment comment: comments){
				stmt.setString(1, commentDAO.getCommentOIDByID(comment.getCommentarieID()));
				result = stmt.executeQuery();				
				
				while(result.next()){
					userWriteComment = userDAO.getUserByLogin(comment.getUserCommentarieID());
					userOverComment = userDAO.getUserByOID(result.getString("FK_USEROID"));
					
					userComment = new UserComment(comment.getCommentarieID(),userOverComment.getLogin(),userWriteComment.getLogin(),
							comment.getCommentarieDate(),comment.getCommentarieTime(),comment.getCommentarie(),result.getInt("userCommentID"));
					resultList.add(userComment);
				}
				
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
	public void insertUserComment(IUserComment userComment){
		conn = ConnectionManager.getInstance().openConnection();
		sql = "INSERT INTO usercomments (UCOID, userCommentID, FK_USEROID, FK_COMOID) VALUES (?, ?, ?, ?);";
		
		UIDGenerator uidGenerator = UIDGenerator.getInstance();
		String UCOID = uidGenerator.getKey();
		String COMOID = uidGenerator.getKey();
		
		IUser userOverComment;
		userDAO = new JDBCUserDAO();

		userOverComment = userDAO.getUserByLogin(userComment.getLoginOverWriter());
		
		commentDAO = new JDBCCommentDAO();
		commentDAO.insertComment(userComment, COMOID);
		
		String userOID = userDAO.getUserOIDByLogin(userOverComment.getLogin());
		
		try{
			stmt = conn.prepareStatement(sql);
			
			stmt.setString(1, UCOID);
			stmt.setInt(2, new IDGenerator("userCommentID", "usercomments").nextValue());
			stmt.setString(3, userOID);
			stmt.setString(4, COMOID);
			
			stmt.executeUpdate();
			
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
	public void deleteUserComment(IUserComment userComment){
		
		Integer commentID = userComment.getCommentarieID();
		
		commentDAO = new JDBCCommentDAO();
		commentDAO.deleteComment(commentID);
	}

}
