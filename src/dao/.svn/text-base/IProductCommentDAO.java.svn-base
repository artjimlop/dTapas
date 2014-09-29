package dao;

import java.util.List;

import domain.IProductComment;

/**
 * 
 * @author David Alanis
 *
 */

public interface IProductCommentDAO {
	
	List<IProductComment> getAllProductComment();
	
	IProductComment getProductCommentByProductCommentOID(String productCommentOID);
	IProductComment getProductCommentByCommentOID(String commentOID);
	List<IProductComment> getProductCommentByProductOID(String productOID);
	
	IProductComment getProductCommentByProductCommentID(Integer productCommentID);
	IProductComment getProductCommentByCommentID(Integer commentID);
	List<IProductComment> getProductCommentByProductID(Integer productID);
	
	void insertProductComment(IProductComment productComment);
	void deleteProductComment(Integer productCommentID);
	
	String getProductCommentOIDByID(Integer productCommentID);
	List<IProductComment> getAllProductCommentsByLogin(String login);
	

}
