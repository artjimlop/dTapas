package business;

import java.sql.Date;
import java.util.List;
import dao.IProductScoreDAO;
import dao.JDBCProductScoreDAO;
import domain.IProductScore;

public class BusinessProductScore implements IBusinessProductScore {
	
	private IProductScoreDAO productScoreDAO;
	
	public BusinessProductScore(){
		productScoreDAO = new JDBCProductScoreDAO();
	}
	
	/* (non-Javadoc)
	 * @see business.IBusinessProductScore#getAllScores()
	 */
	@Override
	public List<IProductScore> getAllScores(){
		return productScoreDAO.getAllScores();
	}
	
//	public List<IProductScore> getScoresByUserOID(String userOID){
//		return productScoreDAO.getScoresByUserOID(userOID);
//	}
	
	/* (non-Javadoc)
	 * @see business.IBusinessProductScore#getScoresByUser(java.lang.String)
	 */
	@Override
	public List<IProductScore> getScoresByUser(String login){
		return productScoreDAO.getScoresByUser(login);
	}
	
	/* (non-Javadoc)
	 * @see business.IBusinessProductScore#getScoresByCreationDate(java.sql.Date)
	 */
	@Override
	public List<IProductScore> getScoresByCreationDate(Date scoreCreationDate){
		return productScoreDAO.getScoresByCreationDate(scoreCreationDate);
	}
	
	/* (non-Javadoc)
	 * @see business.IBusinessProductScore#getScoresByProductID(java.lang.String)
	 */
	@Override
	public List<IProductScore> getScoresByProductID(String productID){
		return productScoreDAO.getScoresByProduct(productID);
	}
	
	/* (non-Javadoc)
	 * @see business.IBusinessProductScore#getProductScorebyID(java.lang.Integer)
	 */
	@Override
	public IProductScore getProductScorebyID(Integer productScoreID){
		return productScoreDAO.getProductScorebyID(productScoreID);
	}
	
//	public void insertProductScore(Double mediumScore ,Double presentationScore,
//			Double quantityScore, Double priceScore, String userOID, String productOID){
//		
//		UIDGenerator uidGenerator = UIDGenerator.getInstance();
//		IProductScore ps = new ProductScore(presentationScore,quantityScore,priceScore,userOID,productOID, uidGenerator.getKey());
//		productScoreDAO.insertProductScore(ps);
//	}
	
	/* (non-Javadoc)
	 * @see business.IBusinessProductScore#insertProductScore(domain.IProductScore)
	 */
	@Override
	public void insertProductScore(IProductScore productScore){
		productScoreDAO.insertProductScore(productScore);
	}
	
	/* (non-Javadoc)
	 * @see business.IBusinessProductScore#updateProductScore(domain.IProductScore)
	 */
	@Override
	public void updateProductScore(IProductScore productScore){

//		IProductScore ps = new BusinessProductScore().getProductScorebyOID(productScoreOID);
//		ps.setPresentationScore(presentationScore);
//		ps.setPriceScore(priceScore);
//		ps.setQuantityScore(quantityScore);
		
		productScoreDAO.updateProductScore(productScore);
	}
	
	/* (non-Javadoc)
	 * @see business.IBusinessProductScore#deleteProductScore(java.lang.Integer)
	 */
	@Override
	public void deleteProductScore(Integer productScoreID){
		productScoreDAO.deleteProductScore(productScoreID);
	}
	
}
