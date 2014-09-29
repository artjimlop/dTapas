package business;

import java.util.List;

import dao.IWineDAO;
import dao.JDBCWineDAO;
import domain.IWine;
import domain.Wine;

public class BusinessWine implements IBusinessWine {
	
	private IWineDAO wineDAO;

	public BusinessWine(){
		
		wineDAO = new JDBCWineDAO();
		
	}	
	/* (non-Javadoc)
	 * @see business.IBusinessWine#getAllWines()
	 */
	@Override
	public List<IWine> getAllWines(){
		
		return this.wineDAO.getAllWines();
	}

	//List<Wine> getWinesByType(String type);
	
	/* (non-Javadoc)
	 * @see business.IBusinessWine#getWinesByType(java.lang.String)
	 */
	@Override
	public List<IWine> getWinesByType(String type){
		
		return wineDAO.getWinesByType(type);
	}
	
	/* (non-Javadoc)
	 * @see business.IBusinessWine#getWineByProduct(java.lang.Integer)
	 */
	@Override
	public IWine getWineByProduct(Integer prodID){
//		Wine resultWine = null;
//		
//		for(Wine wine : getAllWines()){
//			if(wine.getWineOID()==PRODOID){
//				resultWine = wine;
//			}
//		}
		
		return wineDAO.getWineByProduct(prodID);
	}
	
	//List<Wine> getWinesByOd(String od);
	
	/* (non-Javadoc)
	 * @see business.IBusinessWine#getWinesByOd(java.lang.String)
	 */
	@Override
	public List<IWine> getWinesByOd(String od){
//		List<Wine> wines = new ArrayList<>();
//		
//		for(Wine wine : getAllWines()){
//			if(wine.getOd() == od){
//				wines.add(wine);
//			}
//		}
		
		return wineDAO.getWinesByOd(od);
	}
	
	//List<Wine> getWinesByYear(Integer year);
	
	/* (non-Javadoc)
	 * @see business.IBusinessWine#getWinesByYear(java.lang.Integer)
	 */
	@Override
	public List<IWine> getWinesByYear(Integer year){
//		List<Wine> wines = new ArrayList<>();
//		
//		for(Wine wine : getAllWines()){
//			if(wine.getYear() == year){
//				wines.add(wine);
//			}
//		}
//		
		return wineDAO.getWinesByYear(year);
	}
	
	
	//List<Wine> getWinesBygrowuptime(String growuptime);
	
	/* (non-Javadoc)
	 * @see business.IBusinessWine#getWinesBygrowuptime(java.lang.String)
	 */
	@Override
	public List<IWine> getWinesBygrowuptime(String growuptime){
//		List<Wine> wines = new ArrayList<>();
//		
//		for(Wine wine : getAllWines()){
//			if(wine.getGrowUpTime() == growuptime){
//				wines.add(wine);
//			}
//		}
		
		return wineDAO.getWinesBygrowuptime(growuptime);
	}
	
	//List<Wine> getWinesBylabel(String label);
	
	/* (non-Javadoc)
	 * @see business.IBusinessWine#getWinesBylabel(java.lang.String)
	 */
	@Override
	public List<IWine> getWinesBylabel(String label){
//	List<Wine> wines = new ArrayList<>();
//		
//		for(Wine wine : getAllWines()){
//			if(wine.getLabel() == label){
//				wines.add(wine);
//			}
//		}
//		
		return wineDAO.getWinesBylabel(label);
	}
	
	//Wine getWineByOID(Integer VINOID);
	
	/* (non-Javadoc)
	 * @see business.IBusinessWine#getWineByID(java.lang.Integer)
	 */
	@Override
	public IWine getWineByID(Integer wineID){
//	Wine resultWine = null;
//		
//		for(Wine wine : getAllWines()){
//			if(wine.getWineOID()== VINOID){
//				resultWine = wine;
//			}
//		}
		
		return wineDAO.getWineByID(wineID);
	}
	 
	
	/*void insertWine(String type, String od, Integer year, String growuptime, 
			String label, Integer VINOID, Integer PRODOID, String productName, Date makeDate, Double price,Integer USOID, 
			Integer ESTOID);
	void updateWine(String type, String od, Integer year, String growuptime, 
			String label, Integer VINOID, Integer PRODOID);
	void deleteWine(Integer VINOID);
	*/
	
	/* (non-Javadoc)
	 * @see business.IBusinessWine#insertWine(java.lang.String, java.lang.Double, java.lang.String, java.lang.Integer, java.lang.String, java.lang.String, java.lang.Integer, java.lang.String, java.lang.String)
	 */
	@Override
	public void insertWine(String productName, Double price,
			String login, Integer establishmentID, String type, String od,
			Integer year, String growUpTime, String label){
		
		
		Wine resultWine = new  Wine(productName, price, login, establishmentID, type, od, year, growUpTime, label);
		
//		BusinessProduct product = new BusinessProduct();
//		product.insertProduct(resultWine);
		
		
		
		wineDAO.insertWine(resultWine);
		

	}
	
	/* (non-Javadoc)
	 * @see business.IBusinessWine#updateWine(domain.Wine)
	 */
	@Override
	public void updateWine(Wine wine){
		
//		Wine wine = new  Wine(productName, price, userCreatorOID, establishmentOID, productOID,
//				type, od, year, growUpTime, label, wineOID);
		
//		BusinessProduct product = new BusinessProduct();
//		product.updateProduct(wine);
		
		wineDAO.updateWine(wine);
		

	}
	
	/* (non-Javadoc)
	 * @see business.IBusinessWine#deleteWine(java.lang.Integer)
	 */
	@Override
	public void deleteWine(Integer wineID){
		IWineDAO wineDAO = new JDBCWineDAO();
		wineDAO.deleteWine(wineID);
	}
	
//	private void updateVariables(){
//		wineDAO = new JDBCWineDAO();
//		this.wines = wineDAO.getAllWines();
//		updateVariables();
//		
//	}

}
