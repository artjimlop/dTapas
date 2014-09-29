package business;

import java.sql.Date;
import java.util.List;

import domain.IProductScore;

public interface IBusinessProductScore {

	 List<IProductScore> getAllScores();

	 List<IProductScore> getScoresByUser(String login);

	 List<IProductScore> getScoresByCreationDate(
			Date scoreCreationDate);

	 List<IProductScore> getScoresByProductID(String productID);

	 IProductScore getProductScorebyID(Integer productScoreID);

	 void insertProductScore(IProductScore productScore);

	 void updateProductScore(IProductScore productScore);

	 void deleteProductScore(Integer productScoreID);

}