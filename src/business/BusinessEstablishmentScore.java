package business;

import java.sql.Date;
import java.util.List;

import dao.IEstablishmentScoreDAO;
import dao.JDBCEstablishmentScoreDAO;
import domain.IEstablishmentScore;
/**
 * 
 * @author Arturo Jimenez
 *
 */
public class BusinessEstablishmentScore implements IBusinessEstablishmentScore {
	
//	private static BusinessEstablishmentScore businessEstablishmentScore;
//	private List<EstablishmentScore> establishmentScores;
	private IEstablishmentScoreDAO establishmentScoreDAO;
	
//	public static synchronized BusinessEstablishmentScore getInstance(){
//		
//		if(businessEstablishmentScore==null){
//			businessEstablishmentScore = new BusinessEstablishmentScore();
//		}
//		return businessEstablishmentScore;
//	}
	
	public BusinessEstablishmentScore(){
		
		establishmentScoreDAO = new JDBCEstablishmentScoreDAO();
//		this.establishmentScores = establishmentScoreDAO.getAllScores();
		
	}
	
	/* (non-Javadoc)
	 * @see business.IBusinessEstablishmentScore#getAllScores()
	 */
	@Override
	public List<IEstablishmentScore> getAllScores(){
//		return this.establishmentScores;
		establishmentScoreDAO = new JDBCEstablishmentScoreDAO();
		return establishmentScoreDAO.getAllScores();
	}
	
	/* (non-Javadoc)
	 * @see business.IBusinessEstablishmentScore#getScoresByUser(java.lang.String)
	 */
	@Override
	public List<IEstablishmentScore> getScoresByUser(String login){
//		List<EstablishmentScore> scores = new ArrayList<>();
//		
//		for(EstablishmentScore score : getAllScores()){
//			if(score.getUserOID().equals(userOID)){
//				scores.add(score);
//			}
//		}
//		
//		return scores;
		establishmentScoreDAO = new JDBCEstablishmentScoreDAO();
		return establishmentScoreDAO.getScoresByUserLogin(login);
	}
	
	/* (non-Javadoc)
	 * @see business.IBusinessEstablishmentScore#getScoresByCreationDate(java.sql.Date)
	 */
	@Override
	public List<IEstablishmentScore> getScoresByCreationDate(Date scoreCreationDate){
//		List<EstablishmentScore> scores = new ArrayList<>();
//		
//		for(EstablishmentScore score : getAllScores()){
//			if(score.getEstablishmentScoreCreationDate().equals(scoreCreationDate)){
//				scores.add(score);
//			}
//		}
//		
//		return scores;
		establishmentScoreDAO = new JDBCEstablishmentScoreDAO();
		return establishmentScoreDAO.getScoresByCreationDate(scoreCreationDate);
	}
	
	/* (non-Javadoc)
	 * @see business.IBusinessEstablishmentScore#getScoresByEstablishment(java.lang.Integer)
	 */
	@Override
	public List<IEstablishmentScore> getScoresByEstablishment(Integer establishmentID){
//		List<EstablishmentScore> scores = new ArrayList<>();
//		
//		for(EstablishmentScore score : getAllScores()){
//			if(score.getEstablishmentOID().equals(establishmentOID)){
//				scores.add(score);
//			}
//		}
//		
//		return scores;
		establishmentScoreDAO = new JDBCEstablishmentScoreDAO();
		return establishmentScoreDAO.getScoresByEstablishmentID(establishmentID);
	}
	
	/* (non-Javadoc)
	 * @see business.IBusinessEstablishmentScore#getEstablishmentScoreByOID(java.lang.Integer)
	 */
	@Override
	public IEstablishmentScore getEstablishmentScoreByOID(Integer establishmentScoreID){
//		EstablishmentScore score = null;
//		
//		for(EstablishmentScore possibleScore : getAllScores()){
//			if(possibleScore.getEstablishmentScoreOID().equals(establishmentScoreOID)){
//				score = possibleScore;
//			}
//		}
//		
//		return score;
		establishmentScoreDAO = new JDBCEstablishmentScoreDAO();
		return establishmentScoreDAO.getEstablishmentScoreByID(establishmentScoreID);
	}
	
	
//	public void insertEstablishmentScore(Double qualityScore, Double serviceScore,
//			Double cleaningScore, Double sizeScore, Double locationScore,
//			Double priceScore,
//			String USOID , String establishmentOID){
//			
//			UIDGenerator uidGenerator = UIDGenerator.getInstance();
//			String establishmentScoreOID = uidGenerator.getKey();
//			
//			EstablishmentScore establishmentScore = new EstablishmentScore(qualityScore, serviceScore,
//					cleaningScore, sizeScore, locationScore, priceScore,
//					establishmentScoreOID, USOID , establishmentOID);
//			establishmentScoreDAO = new JDBCEstablishmentScoreDAO();
//			
//			establishmentScoreDAO.insertEstablishmentScore(establishmentScore);
//			
//			updateVariables();
//			
//	}
	/* (non-Javadoc)
	 * @see business.IBusinessEstablishmentScore#insertEstablishmentScore(domain.IEstablishmentScore)
	 */
	@Override
	public void insertEstablishmentScore(IEstablishmentScore score){
		establishmentScoreDAO = new JDBCEstablishmentScoreDAO();
		establishmentScoreDAO.insertEstablishmentScore(score);
	}
//	public void updateEstablishmentScore(Double qualityScore, 
//			Double serviceScore, Double cleaningScore, Double sizeScore, Double locationScore,
//			Double priceScore, String establishmentScoreOID, String USOID , String establishmentOID){
//		
//		EstablishmentScore establishmentScore = new EstablishmentScore(qualityScore,
//				serviceScore, cleaningScore, sizeScore, locationScore, priceScore, establishmentScoreOID, USOID,
//				establishmentOID);
//		establishmentScoreDAO = new JDBCEstablishmentScoreDAO();
//		establishmentScoreDAO.updateEstablishmentScore(establishmentScore);
//		
//		updateVariables();
//	}
	/* (non-Javadoc)
	 * @see business.IBusinessEstablishmentScore#updateEstablishmentScore(domain.IEstablishmentScore)
	 */
	@Override
	public void updateEstablishmentScore(IEstablishmentScore score){
		establishmentScoreDAO = new JDBCEstablishmentScoreDAO();
		establishmentScoreDAO.updateEstablishmentScore(score);
	}
//	private void updateVariables(){
//		establishmentScoreDAO = new JDBCEstablishmentScoreDAO();
//		this.establishmentScores = establishmentScoreDAO.getAllScores();
//	}
}
