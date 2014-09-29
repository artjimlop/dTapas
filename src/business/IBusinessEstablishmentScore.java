package business;

import java.sql.Date;
import java.util.List;

import domain.IEstablishmentScore;

public interface IBusinessEstablishmentScore {

	 List<IEstablishmentScore> getAllScores();

	 List<IEstablishmentScore> getScoresByUser(String login);

	 List<IEstablishmentScore> getScoresByCreationDate(
			Date scoreCreationDate);

	 List<IEstablishmentScore> getScoresByEstablishment(
			Integer establishmentID);

	 IEstablishmentScore getEstablishmentScoreByOID(
			Integer establishmentScoreID);

	 void insertEstablishmentScore(IEstablishmentScore score);

	 void updateEstablishmentScore(IEstablishmentScore score);

}