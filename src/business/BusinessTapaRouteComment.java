package business;

import java.sql.Date;
import java.util.List;

import dao.ITapaRouteCommentDAO;
import dao.JDBCTapaRouteCommentDAO;
import domain.ITapaRouteComment;
/**
 * 
 * @author Arturo Jimenez
 *
 */
public class BusinessTapaRouteComment implements IBusinessTapaRouteComment {
	
//	private static BusinessTapaRouteComment businessTapaRouteComment;
	
//	private List<TapaRouteComment> tapaRouteComments;
	private ITapaRouteCommentDAO tapaRouteCommentDAO;
	
//	public static synchronized BusinessTapaRouteComment getInstance(){
//		
//		if(businessTapaRouteComment==null){
//			businessTapaRouteComment = new BusinessTapaRouteComment();
//		}
//		return businessTapaRouteComment;
//	}
	
	public BusinessTapaRouteComment(){
		
		tapaRouteCommentDAO = new JDBCTapaRouteCommentDAO();
//		this.tapaRouteComments = tapaRouteCommentDAO.getAllCommentaries();
		
	}
	
	
	/* (non-Javadoc)
	 * @see business.IBusinessTapaRouteComment#getAllCommentaries()
	 */
	@Override
	public List<ITapaRouteComment> getAllCommentaries(){
//		return this.tapaRouteComments;
		tapaRouteCommentDAO = new JDBCTapaRouteCommentDAO();
		return tapaRouteCommentDAO.getAllCommentaries();
	}
	

	/* (non-Javadoc)
	 * @see business.IBusinessTapaRouteComment#getCommentariesByUser(java.lang.String)
	 */
//	@Override
//	public List<ITapaRouteComment> getCommentariesByUser(String USOID){
//		List<TapaRouteComment> targetComments = new ArrayList<>();
//		
//		for(TapaRouteComment comment:getAllCommentaries()){
//			if(comment.getUserCommentarieOID().equals(USOID))
//				targetComments.add(comment);
//		}
//		
//		return targetComments;
//		tapaRouteCommentDAO = new JDBCTapaRouteCommentDAO();
//		return tapaRouteCommentDAO.getCommentariesByUser(USOID);
//	}
	/* (non-Javadoc)
	 * @see business.IBusinessTapaRouteComment#getCommentariesByRoute(java.lang.String)
	 */
//	@Override
//	public List<ITapaRouteComment> getCommentariesByRoute(String RUTTAPOID){
////		List<TapaRouteComment> targetComments = new ArrayList<>();
////		
////		for(TapaRouteComment comment:getAllCommentaries()){
////			if(comment.getTapaRouteOID().equals(RUTTAPOID))
////				targetComments.add(comment);
////		}
////		
////		return targetComments;
//		tapaRouteCommentDAO = new JDBCTapaRouteCommentDAO();
//		return tapaRouteCommentDAO.getCommentariesByRoute(RUTTAPOID);
//	}
	/* (non-Javadoc)
	 * @see business.IBusinessTapaRouteComment#getCommentariesByDate(java.sql.Date)
	 */
	@Override
	public List<ITapaRouteComment> getCommentariesByDate(Date commentDate){
//		List<TapaRouteComment> targetComments = new ArrayList<>();
//		
//		for(TapaRouteComment comment:getAllCommentaries()){
//			if(comment.getCommentarieDate().equals(commentDate))
//				targetComments.add(comment);
//		}
//		
//		return targetComments;
		tapaRouteCommentDAO = new JDBCTapaRouteCommentDAO();
		return tapaRouteCommentDAO.getCommentariesByDate(commentDate);
	}
	/* (non-Javadoc)
	 * @see business.IBusinessTapaRouteComment#getTapaRouteCommentByOID(java.lang.String)
	 */
//	@Override
//	public ITapaRouteComment getTapaRouteCommentByOID(String COMTRUTTAP){
////		TapaRouteComment targetComment = null ;
////		
////		for(TapaRouteComment comment:getAllCommentaries()){
////			if(comment.getTapaRouteCommentOID().equals(COMTRUTTAP))
////				targetComment = comment;
////		}
////		
////		return targetComment;
//		tapaRouteCommentDAO = new JDBCTapaRouteCommentDAO();
//		return tapaRouteCommentDAO.getTapaRouteCommentByOID(COMTRUTTAP);
//	}
	
	/*
	 * void insertComment(String comment, Date commentDate, Integer USOID, Integer RUTTAPOID);
	
	void delete(Integer COMTRUTTAPOID);
	 */
	/* (non-Javadoc)
	 * @see business.IBusinessTapaRouteComment#insertComment(domain.ITapaRouteComment)
	 */
	@Override
	public void insertComment(ITapaRouteComment comment){
		tapaRouteCommentDAO = new JDBCTapaRouteCommentDAO();
		tapaRouteCommentDAO.insertComment(comment);
	}
//	public void insertComment(String comment, String USOID, String commentOID, String routeOID){
//		UIDGenerator uidGenerator = UIDGenerator.getInstance();
//		String tapaRouteCommentOID = uidGenerator.getKey();
//		
//		TapaRouteComment resultComment = 
//				new  TapaRouteComment(comment, USOID, commentOID, tapaRouteCommentOID, routeOID);
//		tapaRouteCommentDAO = new JDBCTapaRouteCommentDAO();
//		
//		tapaRouteCommentDAO.insertComment(resultComment);
//		
//		updateVariables();
//		
//	}
	
	/* (non-Javadoc)
	 * @see business.IBusinessTapaRouteComment#delete(java.lang.Integer)
	 */
	@Override
	public void delete(Integer tapaRouteCommentID){
		tapaRouteCommentDAO = new JDBCTapaRouteCommentDAO();
		tapaRouteCommentDAO.delete(tapaRouteCommentID);
		
//		updateVariables();
	}
	
//	private void updateVariables(){
//		tapaRouteCommentDAO = new JDBCTapaRouteCommentDAO();
//		tapaRouteComments = tapaRouteCommentDAO.getAllCommentaries();
//	}
}
