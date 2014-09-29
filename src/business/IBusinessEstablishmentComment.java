package business;

import java.util.List;

import domain.IEstablishmentComment;

public interface IBusinessEstablishmentComment {

	 List<IEstablishmentComment> getAllEstablishmentComment();

	 List<IEstablishmentComment> getEstablishmentCommentByESTID(
			Integer estID);

	 IEstablishmentComment getEstablishmentCommentByCOMID(
			Integer comID);

	 List<IEstablishmentComment> getAllEstablishmentCommentByLogin(
			String login);

	 IEstablishmentComment getEstablishmentCommentByCOMNTESTID(
			Integer COMNTESTID);

	 void insertEstablishmentComment(String comment,
			String login, Integer ESTID);

	 void deleteEstablishmentComment(Integer comestID);
	//	private void updateVariables(){
	//		establishmentCommentDAO = new JDBCEstablishmentCommentDAO();
	//		this.establishmentsComment = establishmentCommentDAO.getAllEstablishmentComment();
	//		
	//	}

}