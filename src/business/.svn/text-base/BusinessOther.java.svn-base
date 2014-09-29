package business;

import java.util.List;

import dao.IOthersDAO;
import dao.JDBCOthersDAO;
import domain.IOther;
import domain.Other;


public class BusinessOther implements IBusinessOther {

//	private static BusinessOther businessOther;
//	
//	private List<Other> others;
	private IOthersDAO otherDAO;

//	public static synchronized BusinessOther getInstance() throws SQLException{
//		
//		if(businessOther==null){
//			businessOther = new BusinessOther();
//		}
//		return businessOther;
//	}
	
	public BusinessOther(){
		
		otherDAO = new JDBCOthersDAO();
		
	}
	
	/* (non-Javadoc)
	 * @see business.IBusinessOther#getAllOthers()
	 */
	@Override
	public List<IOther> getAllOthers(){
		
		return otherDAO.getAllOthers();
	}
	
	//Other getOthersByProduct(Integer PRODOID);
	
	/* (non-Javadoc)
	 * @see business.IBusinessOther#getOthersByProduct(java.lang.Integer)
	 */
	@Override
	public IOther getOthersByProduct(Integer prodID){
//		Other resultOther = null;
//		
//		for(Other other : getAllOthers()){
//			if(other.getOtherOID()==PRODOID){
//				resultOther = other;
//			}
//		}
		
		return otherDAO.getOthersByProduct(prodID);
	}
	
	//List<Other> getOthersBySize(String size);
	/* (non-Javadoc)
	 * @see business.IBusinessOther#getOthersBySize(java.lang.String)
	 */
	@Override
	public List<IOther> getOthersBySize(String size){
//	List<Other> others = new ArrayList<>();
//		
//		for(Other other : getAllOthers()){
//			if(other.getSize() == size){
//				others.add(other);
//			}
//		}
//		
		return otherDAO.getOthersBySize(size);
	}
	
	//List<Other> getOthersBylabel(String label);
	
	/* (non-Javadoc)
	 * @see business.IBusinessOther#getOthersByType(java.lang.String)
	 */
	@Override
	public List<IOther> getOthersByType(String type){
//		List<Other> others = new ArrayList<>();
//		
//		for(Other other : getAllOthers()){
//			if(other.getType() == type){
//				others.add(other);
//			}
//		}
		
		return otherDAO.getOthersByType(type);
	}
	
	
	//Other getOthersByOID(Integer OTROID);
	/* (non-Javadoc)
	 * @see business.IBusinessOther#getOthersByID(java.lang.Integer)
	 */
	@Override
	public IOther getOthersByID(Integer OTRID){
//	Other resultOther = null;
//		
//		for(Other other : getAllOthers()){
//			if(other.getOtherOID()==OTROID){
//				resultOther = other;
//			}
//		}
//		
		return otherDAO.getOthersByID(OTRID);
	}
	
	/*void insertOthers(String size, String type, Integer PRODOID, String productName,
			Date makeDate, Double price,Integer USOID, Integer ESTOID);
	void updateOthers(String size, String type, Integer OTROID, Integer PRODOID);
	void deleteOthers(Integer OTROID);*/
	
	/* (non-Javadoc)
	 * @see business.IBusinessOther#insertOthers(java.lang.String, java.lang.Double, java.lang.String, java.lang.Integer, java.lang.String, java.lang.String)
	 */
	@Override
	public void insertOthers(String productName, Double price,
			String userlogin, Integer establishmentID, 
			String size, String type){

		
		Other resultOther = new  Other(productName, price, userlogin, establishmentID, size, type);
		
//		BusinessProduct product = new BusinessProduct();
//		product.insertProduct(resultOther);
//		
		otherDAO.insertOthers(resultOther);
		
		
	}
	
	/* (non-Javadoc)
	 * @see business.IBusinessOther#updateOthers(domain.Other)
	 */
	@Override
	public void updateOthers(Other other){
//		Other other = new  Other(productName, price, userCreatorOID, establishmentOID, productOID,
//				size, type, otherOID);
		
//		BusinessProduct product = new BusinessProduct();
//		product.updateProduct(other);
		
		otherDAO.updateOthers(other);
		
		
	}
	
	/* (non-Javadoc)
	 * @see business.IBusinessOther#deleteOthers(java.lang.Integer)
	 */
	@Override
	public void deleteOthers(Integer otherID){
		IOthersDAO otherDAO = new JDBCOthersDAO();
		otherDAO.deleteOthers(otherID);
		
	}
	
//	private void updateVariables(){
//		otherDAO = new JDBCOthersDAO();
//		this.others = otherDAO.getAllOthers();
//		
//	}
}
