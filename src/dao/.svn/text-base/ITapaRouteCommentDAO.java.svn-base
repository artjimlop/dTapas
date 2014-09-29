package dao;

import java.sql.Date;
import java.util.List;

import domain.ITapaRouteComment;

public interface ITapaRouteCommentDAO {
	
	List<ITapaRouteComment> getAllCommentaries();
	List<ITapaRouteComment> getCommentariesByUser(String USOID);
	List<ITapaRouteComment> getCommentariesByRoute(String RUTTAPOID);
	List<ITapaRouteComment> getCommentariesByDate(Date commentDate);
	
	ITapaRouteComment getTapaRouteCommentByOID(String COMTRUTTAP);
	
	void delete(Integer tapaRouteCommentID);
	void insertComment(ITapaRouteComment tapaRouteComment);

	List<ITapaRouteComment> getCommentariesByRouteID(Integer routeID);
}
