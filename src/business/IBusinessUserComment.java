package business;

import java.sql.Date;
import java.util.List;

import domain.IUserComment;

public interface IBusinessUserComment {

	 List<IUserComment> getAllUserComments();

	 IUserComment getUserCommentByUserCommentID(Integer id);

	 List<IUserComment> getAllUserCommentsOverUserLogin(
			String login);

	 List<IUserComment> getAllUserCommentsFromUserLogin(
			String login);

	 List<IUserComment> getAllUserCommentsByDate(Date date);

	 void insertUserComment(IUserComment userComment);

	 void deleteUserComment(IUserComment userComment);

}