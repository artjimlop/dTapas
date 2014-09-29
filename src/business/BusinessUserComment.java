package business;

import java.sql.Date;
import java.util.List;
import dao.IUserCommentDAO;
import dao.JDBCUserCommentDAO;
import domain.IUserComment;

public class BusinessUserComment implements IBusinessUserComment {
	
	private IUserCommentDAO userCommentDAO;
	
	public BusinessUserComment(){
		userCommentDAO = new JDBCUserCommentDAO();		
	}
	
	/* (non-Javadoc)
	 * @see business.IBusinessUserComment#getAllUserComments()
	 */
	@Override
	public List<IUserComment> getAllUserComments(){
		return userCommentDAO.getAllUserComments();
	}
	
	/* (non-Javadoc)
	 * @see business.IBusinessUserComment#getUserCommentByUserCommentID(java.lang.Integer)
	 */
	@Override
	public IUserComment getUserCommentByUserCommentID(Integer id){
		return userCommentDAO.getUserCommentByUserCommentID(id);
	}
	
	/* (non-Javadoc)
	 * @see business.IBusinessUserComment#getAllUserCommentsOverUserLogin(java.lang.String)
	 */
	@Override
	public List<IUserComment> getAllUserCommentsOverUserLogin(String login){
		return userCommentDAO.getAllUserCommentsOverLogin(login);
	}
	
	/* (non-Javadoc)
	 * @see business.IBusinessUserComment#getAllUserCommentsFromUserLogin(java.lang.String)
	 */
	@Override
	public List<IUserComment> getAllUserCommentsFromUserLogin(String login){
		return userCommentDAO.getAllUserCommentsFromLogin(login);
	}
	
	/* (non-Javadoc)
	 * @see business.IBusinessUserComment#getAllUserCommentsByDate(java.sql.Date)
	 */
	@Override
	public List<IUserComment> getAllUserCommentsByDate(Date date){
		return userCommentDAO.getAllUserCommentsByDate(date);
	}
	
	/* (non-Javadoc)
	 * @see business.IBusinessUserComment#insertUserComment(domain.IUserComment)
	 */
	@Override
	public void insertUserComment(IUserComment userComment){
//		UIDGenerator key = UIDGenerator.getInstance();
//		String UCOID = key.getKey();
//		String FK_COMOID = key.getKey();
//				
//		IUserComment userComment = new UserComment(FK_COMOID, UCOID, FK_USEROID, FK_USERCOMMENTOID, comment);
//		BusinessComment businessComment = new BusinessComment();
//		businessComment.insertComment(userComment);
		userCommentDAO.insertUserComment(userComment);
		
	}
	
	/* (non-Javadoc)
	 * @see business.IBusinessUserComment#deleteUserComment(domain.IUserComment)
	 */
	@Override
	public void deleteUserComment(IUserComment userComment){
//		IUserComment userComment = userCommentDAO.getUserCommentByUserCommentOID(oid);
		userCommentDAO.deleteUserComment(userComment);
//		new BusinessComment().deleteComment(userComment.getCommentarieID());
	}
	
}
