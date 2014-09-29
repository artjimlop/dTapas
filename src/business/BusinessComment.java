package business;

import java.sql.Date;
import java.util.List;

import dao.ICommentDAO;
import dao.JDBCCommentDAO;
import domain.IComment;
/**
 * 
 * @author Arturo Jimenez
 *
 */
public class BusinessComment implements IBusinessComent {

	private ICommentDAO commentDAO;
	
	
	
	public BusinessComment(){
		
		commentDAO = new JDBCCommentDAO();
		
	}
	
	/* (non-Javadoc)
	 * @see business.IBusinessComent#getAllComments()
	 */
	@Override
	public List<IComment> getAllComments(){
		
		return this.commentDAO.getAllComments();
	}
	
	/* (non-Javadoc)
	 * @see business.IBusinessComent#getCommentsByDate(java.sql.Date)
	 */
	@Override
	public List<IComment> getCommentsByDate(Date date){
		
		return this.commentDAO.getCommentsByDate(date);
	}
	
	/* (non-Javadoc)
	 * @see business.IBusinessComent#getCommentByUserID(java.lang.String)
	 */
	@Override
	public List<IComment> getCommentByUserID(String userLogin){
		
		return this.commentDAO.getCommentByUserID(userLogin);
	}
	
	/* (non-Javadoc)
	 * @see business.IBusinessComent#getCommentByID(java.lang.Integer)
	 */
	@Override
	public IComment getCommentByID(Integer commentID){
		
		return this.commentDAO.getCommentByID(commentID);
	}
	
	/* (non-Javadoc)
	 * @see business.IBusinessComent#deleteComment(java.lang.Integer)
	 */
	@Override
	public void deleteComment(Integer commentID){
		
		this.commentDAO.deleteComment(commentID);
	}
}
