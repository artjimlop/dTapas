package business;

import java.util.List;

import domain.IProductComment;

public interface IBusinessProductComment {

	 List<IProductComment> getAllProductComment();

	 IProductComment getProductCommentByProductCommentID(
			Integer productCommentID);

	 IProductComment getProductCommentByCommentID(
			Integer commentID);

	 List<IProductComment> getProductCommentByProductID(
			Integer productID);

	 void insertProductComment(String comment,
			String userLoginID, Integer productID);

	 void deleteProductComment(Integer productCommentID);

	 List<IProductComment> getAllProductCommentsByLogin(
			String login);

}