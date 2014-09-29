package dao;

import java.sql.Date;
import java.util.List;

import domain.IEstablishmentScore;
/**
 * 
 * @author Arturo Jimenez
 *
 */
public interface IEstablishmentScoreDAO {
	
	List<IEstablishmentScore> getAllScores();
	List<IEstablishmentScore> getScoresByUser(String userOID);
	List<IEstablishmentScore> getScoresByCreationDate(Date scoreCreationDate);
	List<IEstablishmentScore> getScoresByEstablishment(String establishmentOID);
	IEstablishmentScore getEstablishmentScoreByOID(String establishmentScoreOID);
	
	void insertEstablishmentScore(IEstablishmentScore score);
	void updateEstablishmentScore(IEstablishmentScore score);
	
	IEstablishmentScore getEstablishmentScoreByID(Integer establishmentScoreID);
	String getEstablishmentScoreOIDByID(Integer establishmentScoreID);
	List<IEstablishmentScore> getScoresByEstablishmentID(Integer establishmentID);
	List<IEstablishmentScore> getScoresByUserLogin(String login);
}
