package business;

import java.util.List;

import dao.IProductCommentDAO;
import dao.JDBCProductCommentDAO;
import domain.IProductComment;
import domain.ProductComment;

public class BusinessProductComment implements IBusinessProductComment {
	
	private IProductCommentDAO productCommentDAO;
	
	public BusinessProductComment(){
		
		productCommentDAO = new JDBCProductCommentDAO();
		
	}
	
	/* (non-Javadoc)
	 * @see business.IBusinessProductComment#getAllProductComment()
	 */
	@Override
	public List<IProductComment> getAllProductComment(){
	
		return this.productCommentDAO.getAllProductComment();
	}
	
	/* (non-Javadoc)
	 * @see business.IBusinessProductComment#getProductCommentByProductCommentID(java.lang.Integer)
	 */
	@Override
	public IProductComment getProductCommentByProductCommentID(Integer productCommentID){
		
		return this.productCommentDAO.getProductCommentByProductCommentID(productCommentID);
	}
	
	/* (non-Javadoc)
	 * @see business.IBusinessProductComment#getProductCommentByCommentID(java.lang.Integer)
	 */
	@Override
	public IProductComment getProductCommentByCommentID(Integer commentID){
		
		return this.productCommentDAO.getProductCommentByCommentID(commentID);
	}
	
	/* (non-Javadoc)
	 * @see business.IBusinessProductComment#getProductCommentByProductID(java.lang.Integer)
	 */
	@Override
	public List<IProductComment> getProductCommentByProductID(Integer productID){
		
		return this.productCommentDAO.getProductCommentByProductID(productID);
	}
	
	
	/* (non-Javadoc)
	 * @see business.IBusinessProductComment#insertProductComment(java.lang.String, java.lang.String, java.lang.Integer)
	 */
	@Override
	public void insertProductComment(String comment, String userLoginID, Integer productID){
		
		
		ProductComment productComment = new ProductComment(comment, userLoginID, productID);
		
		productCommentDAO.insertProductComment(productComment);
		
	}
	
	/* (non-Javadoc)
	 * @see business.IBusinessProductComment#deleteProductComment(java.lang.Integer)
	 */
	@Override
	public void deleteProductComment(Integer productCommentID){

		productCommentDAO.deleteProductComment(productCommentID);
		
	}
	
	/* (non-Javadoc)
	 * @see business.IBusinessProductComment#getAllProductCommentsByLogin(java.lang.String)
	 */
	@Override
	public List<IProductComment> getAllProductCommentsByLogin(String login){
		
		return this.productCommentDAO.getAllProductCommentsByLogin(login);
	}

}
