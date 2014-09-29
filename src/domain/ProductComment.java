package domain;

import java.sql.Date;
import java.sql.Time;

/**
 * 
 * @author David Alanis
 *
 */

public class ProductComment extends Comment implements IProductComment {
	
	private Integer productCommentID;
	private Integer productID;
	
	public ProductComment(){
		super();

	}
	
	public ProductComment(String comment, String userLogin, Integer productID){
		//String comment, String userLogin
		super(comment,  userLogin);
		
		this.productID = productID;
		
	}
	
	public ProductComment(String comment,Date date,Time commentTime, Integer commentID,
			String userLogin, Integer productID, Integer productCommentID){
		//String comment, Date commentDate, String userLogin, Integer commentID
		super(comment,date,commentTime,userLogin,commentID);
		
		this.productID = productID;
		this.productCommentID = productCommentID;
	}
	
	/* (non-Javadoc)
	 * @see domain.IProductComment#getProductID()
	 */
	public Integer getProductID() {
		return this.productID;
	}


	/* (non-Javadoc)
	 * @see domain.IProductComment#getProductCommentID()
	 */
	public Integer getProductCommentID() {
		return this.productCommentID;
	}	

}
