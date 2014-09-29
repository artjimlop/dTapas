package business;


import java.util.List;

import dao.IBeerDAO;
import dao.JDBCBeerDAO;
import domain.Beer;
import domain.IBeer;




public class BusinessBeer implements IBusinessBeer {
	
//	private static BusinessBeer businessBeer;
//	
//	private List<Beer> beers;
	private IBeerDAO beerDAO;
//
//	public static synchronized BusinessBeer getInstance() throws SQLException{
//		
//		if(businessBeer==null){
//			businessBeer = new BusinessBeer();
//		}
//		return businessBeer;
//	}
	
	public BusinessBeer(){
		
		beerDAO = new JDBCBeerDAO();
//		this.beers = beerDAO.getAllBeers();
		
	}
	
	/* (non-Javadoc)
	 * @see business.IBusinessBeer#getAllBeers()
	 */
	@Override
	public List<IBeer> getAllBeers(){	
		return beerDAO.getAllBeers();
	}
	//Beer getBeerByProduct(Integer PRODOID);
	
	/* (non-Javadoc)
	 * @see business.IBusinessBeer#getBeerByProduct(java.lang.Integer)
	 */
	@Override
	public IBeer getBeerByProduct(Integer productID){
//		Beer resultBeer = null;
//		
//		for(Beer beer : getAllBeers()){
//			if(beer.getBeerOID()==PRODOID){
//				resultBeer = beer;
//			}
//		}
//		
//		return resultBeer;
		return beerDAO.getBeerByProduct(productID);
	}
	
	//List<Beer> getBeersByColor(String color);
	
	/* (non-Javadoc)
	 * @see business.IBusinessBeer#getBeersByColor(java.lang.String)
	 */
	@Override
	public List<IBeer> getBeersByColor(String color){
		return beerDAO.getBeersByColor(color);
	}
	
	//List<Beer> getBeersBySize(String size);
	/* (non-Javadoc)
	 * @see business.IBusinessBeer#getBeersBySize(java.lang.String)
	 */
	@Override
	public  List<IBeer> getBeersBySize(String size){
		return beerDAO.getBeersBySize(size);
	}
	
	
	//List<Beer> getBeersByTemperature(Integer temperature);
	/* (non-Javadoc)
	 * @see business.IBusinessBeer#getBeersByTemperature(java.lang.String)
	 */
	@Override
	public List<IBeer> getBeersByTemperature(String temperature){		
		return beerDAO.getBeersByTemperature(temperature);
	}
	
	//List<Beer> getBeersBylabel(String label);
	/* (non-Javadoc)
	 * @see business.IBusinessBeer#getBeersBylabel(java.lang.String)
	 */
	@Override
	public List<IBeer> getBeersBylabel(String label){		
		return beerDAO.getBeersBylabel(label);
	}		
	
	//Beer getBeerByOID(Integer CEROID);
	/* (non-Javadoc)
	 * @see business.IBusinessBeer#getBeerByID(java.lang.Integer)
	 */
	@Override
	public IBeer getBeerByID(Integer beerID){		
		return beerDAO.getBeerByID(beerID);
	}
	
	/*void insertBeer(String size, String color, String temperature, 
			String label, Integer CEROID, Integer PRODOID, String productName, Date makeDate, Double price,Integer USOID, 
			Integer ESTOID);
	void updateBeer(String size, String color, String temperature, 
			String label, Integer CEROID, Integer PRODOID);
	void deleteBeer(Integer CEROID);*/
	
	/* (non-Javadoc)
	 * @see business.IBusinessBeer#insertBeer(java.lang.String, java.lang.Double, java.lang.String, java.lang.Integer, java.lang.String, java.lang.String, java.lang.String, java.lang.String)
	 */
	@Override
	public void insertBeer(String productName, Double price,
			String userCreatorlogin, Integer establishmentID,
			String size, String label, String color, String temperature){

		Beer resultBeer = new  Beer(productName, price, userCreatorlogin, establishmentID, 
				size, label, color, temperature);
//
//		BusinessProduct product = new BusinessProduct();
//		product.insertProduct(resultBeer);
		beerDAO.insertBeer(resultBeer);
		
	}
	
	/* (non-Javadoc)
	 * @see business.IBusinessBeer#updateBeer(domain.Beer)
	 */
	@Override
	public void updateBeer(Beer beer){
//		
//		Beer beer = new  Beer(productName, price, userCreatorOID, establishmentOID, productOID,
//				size, label, color, temperature, beerOID);
		
//		BusinessProduct product = new BusinessProduct();
//		product.;
		
		beerDAO.updateBeer(beer);
	
	}
	
	/* (non-Javadoc)
	 * @see business.IBusinessBeer#deleteBeer(java.lang.Integer)
	 */
	@Override
	public void deleteBeer(Integer beerID){
		
		IBeerDAO beerDAO = new JDBCBeerDAO();
		beerDAO.deleteBeer(beerID);

		
	}	
	
//	private void updateVariables(){
//		beerDAO = new JDBCBeerDAO();
//		this.beers = beerDAO.getAllBeers();
//		
//	}
}
