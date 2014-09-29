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
import domain.EstablishmentComment;
import domain.IComment;
import domain.IEstablishmentComment;

public class JDBCEstablishmentCommentDAO implements IEstablishmentCommentDAO{
	
	private Connection conn; 
	private String sql;
	private PreparedStatement stmt;
	private ResultSet result;
	
	private ICommentDAO commentDAO;
	private IEstablishmentDAO establishmentDAO;
	@Override
	public List<IEstablishmentComment> getAllEstablishmentComment(){
		
		List<IEstablishmentComment> searchResults = new ArrayList<>();
		conn = ConnectionManager.getInstance().openConnection();
		
		sql = "SELECT * FROM establishmentcomments;";
		
		try{
			stmt = conn.prepareStatement(sql);
			result = stmt.executeQuery();
			
			commentDAO = new JDBCCommentDAO();
			establishmentDAO = new JDBCEstablishmentDAO();
			
			IComment comment = null;
			EstablishmentComment establishmentComment = null;
			
			
			while(result.next()){
				comment = commentDAO.getCommentByOID((result.getString("FK_COMOID")));
			
				establishmentComment = new EstablishmentComment(comment.getCommentarie(),
						comment.getCommentarieDate(),comment.getCommentarieTime(), comment.getCommentarieID(), comment.getUserCommentarieID(),
						establishmentDAO.getEstablishmentByOID(result.getString("FK_ESTOID")).getEstablishmentID(), result.getInt("establishmentCommentID"));
				
				searchResults.add(establishmentComment);
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
	
	@Override
	public List<IEstablishmentComment> getEstablishmentCommentByESTOID(Integer ESTID){
		
		List<IEstablishmentComment> searchResults = new ArrayList<>();
		conn = ConnectionManager.getInstance().openConnection();
		
		commentDAO = new JDBCCommentDAO();
		establishmentDAO = new JDBCEstablishmentDAO();
		
		
		sql = "SELECT * FROM establishmentcomments WHERE (FK_ESTOID=?);";
		
		try{
			
			stmt = conn.prepareStatement(sql);
			
			stmt.setString(1, establishmentDAO.getEstablishmentOIDByID(ESTID));
			
			result = stmt.executeQuery();
			
			
			
			IComment comment = null;
			IEstablishmentComment establishmentComment = null;
			
			while(result.next()){
				
				comment = commentDAO.getCommentByOID(result.getString("FK_COMOID"));
				
				establishmentComment = new EstablishmentComment(comment.getCommentarie(),
						comment.getCommentarieDate(),comment.getCommentarieTime(), comment.getCommentarieID(), comment.getUserCommentarieID(),
						establishmentDAO.getEstablishmentByOID(result.getString("FK_ESTOID")).getEstablishmentID(), result.getInt("establishmentCommentID"));;
				
				searchResults.add(establishmentComment);
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

	
	public IEstablishmentComment getEstablishmentCommentByCOMOID(Integer COMID) {

		IEstablishmentComment searchResult = null;
		conn = ConnectionManager.getInstance().openConnection();
		commentDAO = new JDBCCommentDAO();
		establishmentDAO = new JDBCEstablishmentDAO();
		
		sql = "SELECT * FROM establishmentcomments  WHERE (FK_COMOID=?);";
		
		
		try{
			
			stmt = conn.prepareStatement(sql);
			
			stmt.setString(1, commentDAO.getCommentOIDByID(COMID));
			
			result = stmt.executeQuery();
			
			
			IComment comment = null;
			
			if(result.next()){
				
				comment = commentDAO.getCommentByOID(result.getString("FK_COMOID"));
				
				searchResult = new EstablishmentComment(comment.getCommentarie(),
						comment.getCommentarieDate(),comment.getCommentarieTime(), comment.getCommentarieID(), comment.getUserCommentarieID(),
						establishmentDAO.getEstablishmentByOID(result.getString("FK_ESTOID")).getEstablishmentID(), result.getInt("establishmentCommentID"));;
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
	
	
	
	public IEstablishmentComment getEstablishmentCommentByCOMNTESTOID(String COMNTESTOID){
		
		IEstablishmentComment searchResult = null;
		conn = ConnectionManager.getInstance().openConnection();
		
		sql = "SELECT * FROM establishmentcomments  WHERE (COMNTESTOID=?);";
		
		
		try{
			
			stmt = conn.prepareStatement(sql);
			
			stmt.setString(1, COMNTESTOID);
			
			result = stmt.executeQuery();
			
			commentDAO = new JDBCCommentDAO();
			establishmentDAO = new JDBCEstablishmentDAO();
			
			IComment comment = null;
			
			if(result.next()){
				
				comment = commentDAO.getCommentByOID(result.getString("FK_COMOID"));
				
				searchResult = new EstablishmentComment(comment.getCommentarie(),
						comment.getCommentarieDate(),comment.getCommentarieTime(), comment.getCommentarieID(), comment.getUserCommentarieID(),
						establishmentDAO.getEstablishmentByOID(result.getString("FK_ESTOID")).getEstablishmentID(), result.getInt("establishmentCommentID"));;
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
	public void insertEstablishmentComment(IEstablishmentComment establishmentComment){
		
		
		UIDGenerator uidGenerator = UIDGenerator.getInstance();
		String COMNTESTOID= uidGenerator.getKey();
		String COMOID= uidGenerator.getKey();
		
		IDGenerator idGenerator = new IDGenerator("establishmentCommentID", "establishmentcomments");
		Integer establishmentCommentID = idGenerator.nextValue();
		
		
		
//		Comment commentOID;
//		
		commentDAO = new JDBCCommentDAO();
		establishmentDAO = new JDBCEstablishmentDAO();
//		Comment comment = new Comment(establishmentComment.getCommentarie(),establishmentComment.getUserCommentarieOID(),
//				establishmentComment.getCommentarieOID());
//		
		commentDAO.insertComment(establishmentComment, COMOID);
// 		
// 		
//		commentOID = commentDAO.getCommentByOID(establishmentComment.getCommentOID());
		
		
		
		if(commentDAO.getCommentByOID(COMOID)!=null){
		
			conn = ConnectionManager.getInstance().openConnection();
			
			sql = "INSERT INTO establishmentcomments (COMNTESTOID, FK_COMOID, FK_ESTOID, establishmentCommentID) VALUES (?,?,?,?);";
			
			try{
				stmt = conn.prepareStatement(sql);
				
				stmt.setString(1, COMNTESTOID);
				stmt.setString(2, COMOID);
				stmt.setString(3, establishmentDAO.getEstablishmentOIDByID(establishmentComment.getEstablishmentID()));
				stmt.setInt(4, establishmentCommentID);
						
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
	public void deleteEstablishmentComment(Integer establishmentCommentID){
		
		IEstablishmentComment establishmentComment = this.getEstablishmentCommentByID(establishmentCommentID);
		
		commentDAO = new JDBCCommentDAO();
		if(establishmentComment!=null){
					
			commentDAO.deleteComment(establishmentComment.getCommentarieID());
			
		}
//		conn = ConnectionManager.getInstance().openConnection();
//		
//		sql = "DELETE FROM establishmentcomments " +
//				"WHERE COMNTESTOID = ?;";
//		
//		try {
//			
//			stmt = conn.prepareStatement(sql);
//			
//			stmt.setString(1, COMNTESTOID);
//			
//			stmt.executeUpdate();
//			
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}finally{
//			ConnectionManager.getInstance().closeConnection(conn);
//			if(result != null)
//				result.close();
//			if(stmt != null)
//				stmt.close();
//		}	
	}

	@Override
	public String getEstablishmentCommentOIDByID(Integer establishmentCommentID) {
		String COMNTESTOID = null;
		
		conn = ConnectionManager.getInstance().openConnection();
		
			
		sql = "SELECT * FROM establishmentcomments WHERE establishmentCommentID=?;";
		
		try{
			
			stmt = conn.prepareStatement(sql);
			
			stmt.setInt(1, establishmentCommentID);
			
			result = stmt.executeQuery();
			
			if(result.next()){
								
				COMNTESTOID =  result.getString("COMNTESTOID");
				 
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
		return COMNTESTOID;
	}
	
	public List<IEstablishmentComment> getAllEstablishmentCommentByLogin(String login){
		
		conn = ConnectionManager.getInstance().openConnection();
		List<IEstablishmentComment> resultList = new ArrayList<IEstablishmentComment>();
		IEstablishmentComment establishmentComment;
				
		
		sql = "SELECT * " +
				"FROM establishmentcomments " +
				"WHERE FK_COMOID=?;";
		commentDAO = new JDBCCommentDAO();
		
		List<IComment> comments = commentDAO.getCommentByUserID(login);
		
		try {
			
			stmt = conn.prepareStatement(sql);
			
			new JDBCUserDAO();
			
			
			for(IComment c: comments){
				stmt.setString(1, commentDAO.getCommentOIDByID(c.getCommentarieID()));
				result = stmt.executeQuery();				
				
				while(result.next()){
					
//					userWriteComment = userDAO.getUserByLogin(c.getUserCommentarieID());
//					userOverComment = userDAO.getUserByOID(result.getString("FK_USEROID"));
					establishmentDAO = new JDBCEstablishmentDAO();
					establishmentComment = new EstablishmentComment(c.getCommentarie(),
							c.getCommentarieDate(),c.getCommentarieTime(), c.getCommentarieID(), c.getUserCommentarieID(),
							establishmentDAO.getEstablishmentByOID(result.getString("FK_ESTOID")).getEstablishmentID(), result.getInt("establishmentCommentID"));;
					
					resultList.add(establishmentComment);
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
	public IEstablishmentComment getEstablishmentCommentByID(
			Integer establishmentCommentID) {
		String COMETESTOID = this.getEstablishmentCommentOIDByID(establishmentCommentID);
		
		return this.getEstablishmentCommentByCOMNTESTOID(COMETESTOID);
	}
	
//	public void updateEstablishmentComment(EstablishmentComment establishmentComment) {
//		
//		conn = ConnectionManager.getInstance().openConnection();
//		
////		if(getEstablishmentCommentByCOMNTESTOID(establishmentComment.getCommentOID())!=null){
//			
//			Comment commentOID;
//			
//			commentDAO = new JDBCCommentDAO();
//			
////			Comment comment = new Comment(establishmentComment.getCommentarie(),establishmentComment.getUserCommentarieOID(),
////					establishmentComment.getCommentarieOID());
//
//			//commentDAO.updateComment(comment);
//	 		/*
//	 		 * String comment, Date commentDate, String fatherOID, String COMOID, String USOID,
//			String ESTOID, String COMNTESTOID
//	 		 */
//	 		
//			commentOID = commentDAO.getCommentByOID(establishmentComment.getCommentarieOID());
//		
//			sql = "UPDATE establishmentcomments SET FK_COMOID=?, FK_ESTOID=? WHERE COMNTESTOID=?;";
//				
//			
//			if(commentOID!=null){
//				try{
//					stmt = conn.prepareStatement(sql);
//					
//					
//					stmt.setString(1, establishmentComment.getCommentarieOID());
//					stmt.setString(2, establishmentComment.getEstablishmentOID());
//					stmt.setString(3, establishmentComment.getEstablishmentCommentOID());
//					
//					stmt.executeUpdate();
//					
//				}catch (SQLException e) {
//					System.out.println("Message: " + e.getMessage());
//		            System.out.println("SQLState: " + e.getSQLState());
//		            System.out.println("ErrorCode: " + e.getErrorCode());
//				}finally{
//					
//					ConnectionManager.getInstance().closeConnection(conn);
//					try{
//						if(stmt != null){
//							stmt.close();
//						}
//					}catch (SQLException e) {
//					}
//				}
//			}
//		}


	}
//}

