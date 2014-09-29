package dao;

import java.sql.Date;
import java.util.List;

import domain.IUserComment;

public interface IUserCommentDAO {
	List<IUserComment> getAllUserComments();
	IUserComment getUserCommentByUserCommentID(Integer id);
	List<IUserComment> getAllUserCommentsOverLogin(String login);
	List<IUserComment> getAllUserCommentsFromLogin(String login);
	List<IUserComment> getAllUserCommentsByDate(Date date);
	
	void insertUserComment(IUserComment userComment);
	void deleteUserComment(IUserComment userComment);
	
	
}
