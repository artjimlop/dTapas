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
import domain.IComment;
import domain.IProduct;
import domain.IProductComment;
import domain.ProductComment;

/**
 * 
 * @author David Alanis
 *
 */

public class JDBCProductCommentDAO implements IProductCommentDAO {
	
	private Connection conn; 
	private String sql;
	private PreparedStatement stmt;
	private ResultSet result;
	
	private ICommentDAO commentDAO;
	private IProductDAO productDAO;


	public List<IProductComment> getAllProductComment() {
		
		List<IProductComment> searchResults = new ArrayList<>();
		conn = ConnectionManager.getInstance().openConnection();
		
		sql = "SELECT * FROM productcomments " +
				"ORDER BY productCommentID;";
		
		try{
			stmt = conn.prepareStatement(sql);
			result = stmt.executeQuery();
			
			commentDAO = new JDBCCommentDAO();
			productDAO = new JDBCProductDAO();
			
			IProduct product = null;
			IComment comment = null;
			IProductComment productComment = null;
			
			while(result.next()){
				
				comment = commentDAO.getCommentByOID(result.getString("FK_COMOID"));
				product = productDAO.getProductByPROID(result.getString("FK_PRODOID"));
				
				productComment = new ProductComment(comment.getCommentarie(), comment.getCommentarieDate(),comment.getCommentarieTime(), comment.getCommentarieID(),
						comment.getUserCommentarieID(), product.getProductID(), result.getInt("productCommentID"));
				
				searchResults.add(productComment);
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

	

	
	public void insertProductComment(IProductComment productComment) {
		
		conn = ConnectionManager.getInstance().openConnection();
		
		UIDGenerator uidGenerator = UIDGenerator.getInstance();
		
		String productCommentOID = uidGenerator.getKey();
		String commentOID = uidGenerator.getKey();
		
		commentDAO = new JDBCCommentDAO();
		commentDAO.insertComment(productComment, commentOID);
		
		productDAO = new JDBCProductDAO();
		String productOID = productDAO.getProductOIDByID(productComment.getProductID());
		
		IDGenerator idGenerator = new IDGenerator("productCommentID", "productComments");
		Integer productCommentID = idGenerator.nextValue();
		
		sql = "INSERT INTO productcomments (COMPROID, productCommentID, FK_COMOID, FK_PRODOID) VALUES (?, ?, ?, ?);";
		
		try{
			stmt = conn.prepareStatement(sql);
			
			stmt.setString(1, productCommentOID);
			stmt.setInt(2, productCommentID);
			stmt.setString(3, commentOID);
			stmt.setString(4, productOID);
			
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

	
	public void deleteProductComment(Integer productCommentID) {
		
		IProductComment productComment = this.getProductCommentByProductCommentID(productCommentID);
		
		Integer commentID = productComment.getCommentarieID();
		
		this.commentDAO = new JDBCCommentDAO();
		
		this.commentDAO.deleteComment(commentID);
	       
	}


	
	public IProductComment getProductCommentByProductCommentOID(
			String productCommentOID) {
		
		conn = ConnectionManager.getInstance().openConnection();
		IProductComment productComment = null;
		IComment comment = null;
		IProduct product = null;
		
		sql = "SELECT * FROM productComments WHERE(COMPROID=?);";
		
		try{
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, productCommentOID);
			
			result = stmt.executeQuery();
			
			commentDAO = new JDBCCommentDAO();
			productDAO = new JDBCProductDAO();
						
			if(result.next()){
				comment = commentDAO.getCommentByOID(result.getString("FK_COMOID"));
				product = productDAO.getProductByPROID(result.getString("FK_PRODOID"));
				
				productComment = new ProductComment(comment.getCommentarie(), comment.getCommentarieDate(),comment.getCommentarieTime(), comment.getCommentarieID(),
						comment.getUserCommentarieID(), product.getProductID(), result.getInt("productCommentID"));;
				
				
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
		
		return productComment;
	}




	@Override
	public IProductComment getProductCommentByCommentOID(String commentOID) {
		
		conn = ConnectionManager.getInstance().openConnection();
		IProductComment productComment = null;
		IComment comment = null;
		IProduct product = null;
		
		sql = "SELECT * FROM productComments WHERE(FK_COMOID=?);";
		
		try{
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, commentOID);
			
			result = stmt.executeQuery();
			
			commentDAO = new JDBCCommentDAO();
			productDAO = new JDBCProductDAO();
						
			if(result.next()){
				comment = commentDAO.getCommentByOID(result.getString("FK_COMOID"));
				product = productDAO.getProductByPROID(result.getString("FK_PRODOID"));
				
				productComment = new ProductComment(comment.getCommentarie(), comment.getCommentarieDate(),comment.getCommentarieTime(), comment.getCommentarieID(),
						comment.getUserCommentarieID(), product.getProductID(), result.getInt("productCommentID"));;
				
				
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
		
		return productComment;
	}




	@Override
	public List<IProductComment> getProductCommentByProductOID(String productOID) {
		
		conn = ConnectionManager.getInstance().openConnection();
		List<IProductComment> productComments = new ArrayList<>();
		IComment comment = null;
		
		sql = "SELECT * FROM productComments WHERE(FK_PRODOID=?);";
		
		try{
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, productOID);
			
			result = stmt.executeQuery();
			
			IProductComment productComment = null;
			IProduct product = null;
			
			commentDAO = new JDBCCommentDAO();
			productDAO = new JDBCProductDAO();
						
			while(result.next()){
				
				comment = commentDAO.getCommentByOID(result.getString("FK_COMOID"));
				product = productDAO.getProductByPROID(result.getString("FK_PRODOID"));
				
				productComment = new ProductComment(comment.getCommentarie(), comment.getCommentarieDate(),comment.getCommentarieTime(), comment.getCommentarieID(),
						comment.getUserCommentarieID(), product.getProductID(), result.getInt("productCommentID"));;
				
				productComments.add(productComment);
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
		
		return productComments;
	}




	@Override
	public IProductComment getProductCommentByProductCommentID(
			Integer productCommentID) {

		String productCommentOID = this.getProductCommentOIDByID(productCommentID);
		IProductComment productComment = this.getProductCommentByProductCommentOID(productCommentOID);
		
		return productComment;
	}




	@Override
	public IProductComment getProductCommentByCommentID(Integer commentID) {
		
		commentDAO = new JDBCCommentDAO();
		String commentOID = commentDAO.getCommentOIDByID(commentID);
		IProductComment productComment = this.getProductCommentByCommentOID(commentOID);
		
		return productComment;
	}




	@Override
	public List<IProductComment> getProductCommentByProductID(Integer productID) {

		productDAO = new JDBCProductDAO();
		String productOID = productDAO.getProductOIDByID(productID);
		List<IProductComment> productComments = this.getProductCommentByProductOID(productOID);
		
		return productComments;
	}




	@Override
	public String getProductCommentOIDByID(Integer productCommentID) {
		String establishmentOID = null;	
		conn = ConnectionManager.getInstance().openConnection();
		
		sql = "SELECT * FROM productComments WHERE(productCommentID=?);";
		
		try{
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, productCommentID);
			
			result = stmt.executeQuery();
		
			if(result.next()){
				
				establishmentOID = result.getString("COMPROID");
				
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
		
		return establishmentOID;
	}	
	
	public List<IProductComment> getAllProductCommentsByLogin(String login){
		conn = ConnectionManager.getInstance().openConnection();
		List<IProductComment> resultList = new ArrayList<IProductComment>();
		ProductComment productComment = null;
		
		sql = "SELECT * " +
				"FROM productcomments " +
				"WHERE FK_COMOID=?;";
		
		commentDAO = new JDBCCommentDAO();
		List<IComment> comments = commentDAO.getCommentByUserID(login);
		
		try {
			
			stmt = conn.prepareStatement(sql);
			
			
			productDAO = new JDBCProductDAO();
			commentDAO = new JDBCCommentDAO();
			
			for(IComment c: comments){
				stmt.setString(1, commentDAO.getCommentOIDByID(c.getCommentarieID()));
				result = stmt.executeQuery();				
				
				while(result.next()){
					
					IProduct product = new JDBCProductDAO().getProductByPROID(result.getString("FK_PRODOID"));
					productComment = new ProductComment(c.getCommentarie(), c.getCommentarieDate(),c.getCommentarieTime(), c.getCommentarieID(),
							c.getUserCommentarieID(), product.getProductID(), result.getInt("productCommentID"));;
					
					resultList.add(productComment);
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
	
}
