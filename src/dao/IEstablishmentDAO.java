package dao;

import java.sql.Date;
import java.util.List;

import domain.IEstablishment;

public interface IEstablishmentDAO {

	List<IEstablishment> getAllEstablishments();
	
	List<IEstablishment> getEstablishmentByEstablishmtName(String establishmentName);
	List<IEstablishment> getEstablishmentByCity(String city);
	List<IEstablishment> getEstablishmentByProvince(String province);
	List<IEstablishment> getEstablishmentByZone(String zone);
	List<IEstablishment> getEstablishmentByStreet(String street);
	List<IEstablishment> getEstablishmentByZipCode(Integer zipCode );
	List<IEstablishment> getEstablishmentByDate(Date date);
	
	IEstablishment getEstablishmentByOID(String establishmentOID);
	List<IEstablishment> getEstablihstmentByUserOID(String userOID);
	
	IEstablishment getEstablishmentByID(Integer establishmentID);
	List<IEstablishment> getEstablishmentByUserLoginID(String userLoginID);
	
	String getEstablishmentOIDByID(Integer establishmentID);
	
	void insertEstablishment(IEstablishment establishment);
	void delete(Integer ESTID);
	void updateEstablishment(IEstablishment establishment);
	
}
