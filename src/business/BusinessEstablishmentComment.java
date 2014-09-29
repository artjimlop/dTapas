package business;

import java.util.List;

import dao.IEstablishmentCommentDAO;
import dao.JDBCEstablishmentCommentDAO;
import domain.EstablishmentComment;
import domain.IEstablishmentComment;

public class BusinessEstablishmentComment implements IBusinessEstablishmentComment {
	
	
	private IEstablishmentCommentDAO establishmentCommentDAO;

	
	public BusinessEstablishmentComment(){
		
		establishmentCommentDAO = new JDBCEstablishmentCommentDAO();
	
	}
	
	/* (non-Javadoc)
	 * @see business.IBusinessEstablishmentComment#getAllEstablishmentComment()
	 */
	@Override
	public  List<IEstablishmentComment> getAllEstablishmentComment(){
		
		return establishmentCommentDAO.getAllEstablishmentComment();
	}
	
		
	
	/* (non-Javadoc)
	 * @see business.IBusinessEstablishmentComment#getEstablishmentCommentByESTID(java.lang.Integer)
	 */
	@Override
	public List<IEstablishmentComment> getEstablishmentCommentByESTID(Integer estID){
		
//		List<EstablishmentComment> establishmentsComment = new ArrayList<>();
//		
//		for(EstablishmentComment establishmentComment : getAllEstablishmentComment()){
//			if(establishmentComment.getEstablishmentCommentOID() == ESTOID){
//				establishmentsComment.add(establishmentComment);
//			}
//		}
		
		return establishmentCommentDAO.getEstablishmentCommentByESTOID(estID);
	}
	
	/* (non-Javadoc)
	 * @see business.IBusinessEstablishmentComment#getEstablishmentCommentByCOMID(java.lang.Integer)
	 */
	@Override
	public IEstablishmentComment getEstablishmentCommentByCOMID(Integer comID){
//		EstablishmentComment resultEstablishmentComment = null;
//		
//		for(EstablishmentComment establishmentComment : getAllEstablishmentComment()){
//			if(establishmentComment.getEstablishmentCommentOID()==COMOID){
//				resultEstablishmentComment = establishmentComment;
//			}
//		}
		
		return establishmentCommentDAO.getEstablishmentCommentByCOMOID(comID);
	}
	
	/* (non-Javadoc)
	 * @see business.IBusinessEstablishmentComment#getAllEstablishmentCommentByLogin(java.lang.String)
	 */
	@Override
	public List<IEstablishmentComment> getAllEstablishmentCommentByLogin(String login){
		return establishmentCommentDAO.getAllEstablishmentCommentByLogin(login);
	}
	/* (non-Javadoc)
	 * @see business.IBusinessEstablishmentComment#getEstablishmentCommentByCOMNTESTID(java.lang.Integer)
	 */
	@Override
	public IEstablishmentComment getEstablishmentCommentByCOMNTESTID(Integer COMNTESTID){
//		EstablishmentComment resultEstablishmentComment = null;
//		
//		for(EstablishmentComment establishmentComment : getAllEstablishmentComment()){
//			if(establishmentComment.getEstablishmentCommentOID()==COMNTESTOID){
//				resultEstablishmentComment = establishmentComment;
//			}
//		}
		
		return establishmentCommentDAO.getEstablishmentCommentByID(COMNTESTID);
	}
	
	/* (non-Javadoc)
	 * @see business.IBusinessEstablishmentComment#insertEstablishmentComment(java.lang.String, java.lang.String, java.lang.Integer)
	 */
	@Override
	public void insertEstablishmentComment(String comment, String login,
			Integer ESTID){

		
		//Date commentDate = new java.sql.Date(Calendar.getInstance().getTimeInMillis());
		/*
		 * String comment, Date commentDate, String fatherOID, String COMOID, String USOID,
			String ESTOID, String COMNTESTOID
		 */
		
		EstablishmentComment establishmentComment = new EstablishmentComment(comment, login,
				ESTID);
//	
//		BusinessComment businessComment = new BusinessComment();
//		businessComment.insertComment(establishmentComment);
//				
		establishmentCommentDAO.insertEstablishmentComment(establishmentComment);
		

	}
	
	/* (non-Javadoc)
	 * @see business.IBusinessEstablishmentComment#deleteEstablishmentComment(java.lang.Integer)
	 */
	@Override
	public void deleteEstablishmentComment(Integer comestID){
		
		establishmentCommentDAO = new JDBCEstablishmentCommentDAO();
		establishmentCommentDAO.deleteEstablishmentComment(comestID);
		
	}
//	private void updateVariables(){
//		establishmentCommentDAO = new JDBCEstablishmentCommentDAO();
//		this.establishmentsComment = establishmentCommentDAO.getAllEstablishmentComment();
//		
//	}

}

