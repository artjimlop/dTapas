package dao;

import java.sql.Date;
import java.util.List;

import domain.IProductScore;

public interface IProductScoreDAO {
	
	String getProductScoreOIDByID(Integer id);
	List<IProductScore> getAllScores();
	List<IProductScore> getScoresByUser(String userOID);
	List<IProductScore> getScoresByCreationDate(Date scoreCreationDate);
	List<IProductScore> getScoresByProduct(String productOID);
	IProductScore getProductScorebyOID(String productScoreOID);
	IProductScore getProductScorebyID(Integer productScoreID);
	
	void insertProductScore(IProductScore productScore);
	void updateProductScore(IProductScore score);
	void deleteProductScore(Integer productScoreID);
	
}
