package business;

import java.sql.Date;
import java.util.List;

import dao.IEstablishmentDAO;
import dao.JDBCEstablishmentDAO;
import domain.Establishment;
import domain.IEstablishment;

public class BusinessEstablishment implements IBusinessEstablishment {
	
	private IEstablishmentDAO establishmentDAO;
	
	public BusinessEstablishment(){
		this.establishmentDAO = new JDBCEstablishmentDAO();
		
	}
	
	//Las puntuaciones por establecimiento se buscan en el BOEstablishmentScore
	//Con los comentarios pasa lo mismo
	
	/* (non-Javadoc)
	 * @see business.IBusinessEstablishment#getAllEstablishments()
	 */
	@Override
	public List<IEstablishment> getAllEstablishments(){
		
		return this.establishmentDAO.getAllEstablishments();
	}
	
	/* (non-Javadoc)
	 * @see business.IBusinessEstablishment#getEstablishmentsByNameEstablishment(java.lang.String)
	 */
	@Override
	public List<IEstablishment> getEstablishmentsByNameEstablishment(String nameEstablishment){

		return this.establishmentDAO.getEstablishmentByEstablishmtName(nameEstablishment);
	}
	
	/* (non-Javadoc)
	 * @see business.IBusinessEstablishment#getEstablishmentsByCity(java.lang.String)
	 */
	@Override
	public List<IEstablishment> getEstablishmentsByCity(String city){

		return this.establishmentDAO.getEstablishmentByCity(city);
	}
	
	/* (non-Javadoc)
	 * @see business.IBusinessEstablishment#getEstablishmentsByProvince(java.lang.String)
	 */
	@Override
	public List<IEstablishment> getEstablishmentsByProvince(String province){

		return this.establishmentDAO.getEstablishmentByProvince(province);
	}
	
	/* (non-Javadoc)
	 * @see business.IBusinessEstablishment#getEstablishmentsByZone(java.lang.String)
	 */
	@Override
	public List<IEstablishment> getEstablishmentsByZone(String zone){

		return this.establishmentDAO.getEstablishmentByZone(zone);
	}
	
	/* (non-Javadoc)
	 * @see business.IBusinessEstablishment#getEstablishmentsByStreet(java.lang.String)
	 */
	@Override
	public List<IEstablishment> getEstablishmentsByStreet(String street){

		return this.establishmentDAO.getEstablishmentByStreet(street);
	}
	
	/* (non-Javadoc)
	 * @see business.IBusinessEstablishment#getEstablishmentsByZipCode(java.lang.Integer)
	 */
	@Override
	public List<IEstablishment> getEstablishmentsByZipCode(Integer zipCode){

		return this.establishmentDAO.getEstablishmentByZipCode(zipCode);
	}
	
	/* (non-Javadoc)
	 * @see business.IBusinessEstablishment#getEstablishmentsByRegistryDate(java.sql.Date)
	 */
	@Override
	public List<IEstablishment> getEstablishmentsByRegistryDate(Date registryDate){

		return this.establishmentDAO.getEstablishmentByDate(registryDate);
	}
	
	/* (non-Javadoc)
	 * @see business.IBusinessEstablishment#getEstablishmentByID(java.lang.Integer)
	 */
	@Override
	public IEstablishment getEstablishmentByID(Integer establishmentID){
		
		return this.establishmentDAO.getEstablishmentByID(establishmentID);
	}
	
	/* (non-Javadoc)
	 * @see business.IBusinessEstablishment#getEstablishmentByUserLoginID(java.lang.String)
	 */
	@Override
	public List<IEstablishment> getEstablishmentByUserLoginID(String userLoginID){
		
		return this.establishmentDAO.getEstablishmentByUserLoginID(userLoginID);
	}
	/* (non-Javadoc)
	 * @see business.IBusinessEstablishment#insertEstablishment(java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.Integer, java.lang.String)
	 */
	@Override
	public void insertEstablishment(String nameEstablishment, String city, String province,
			String zone, String street, Integer zipCode, String userLogin){
		
		IEstablishment establishment = new Establishment(nameEstablishment, city, province, zone, street, zipCode, userLogin);
		this.establishmentDAO.insertEstablishment(establishment);
		
	}
	
	/* (non-Javadoc)
	 * @see business.IBusinessEstablishment#delete(java.lang.Integer)
	 */
	@Override
	public void delete(Integer ESTID){
		
		this.establishmentDAO.delete(ESTID);
	}
	
	/* (non-Javadoc)
	 * @see business.IBusinessEstablishment#updateEstablishment(domain.IEstablishment)
	 */
	@Override
	public void updateEstablishment(IEstablishment establishment){
		
		this.establishmentDAO.updateEstablishment(establishment);
	}
		
}

