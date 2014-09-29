package dao;

import java.sql.Date;
import java.util.List;

import domain.IComment;

/**
 * 
 * @author Arturo Jimenez
 *
 */
public interface ICommentDAO {
	
	List<IComment> getAllComments();

	List<IComment> getCommentsByDate(Date date);
	IComment getCommentByOID(String COMOID);
	List<IComment> getCommentsByUser(String USOID);
	List<IComment> getCommentByUserID(String userLogin);
	IComment getCommentByID(Integer commentID);
	
	
	//void insertComment(Comment comment);
	void insertComment(IComment comment, String commentOID); //este lo utilizaran las clases hijas de Comment
	void deleteComment(Integer commentID);
	
	String getCommentOIDByID(Integer commentID);
	
}
