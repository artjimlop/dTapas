package business;

import java.sql.Date;
import java.util.List;

import domain.IEstablishment;

public interface IBusinessEstablishment {

	 List<IEstablishment> getAllEstablishments();

	 List<IEstablishment> getEstablishmentsByNameEstablishment(
			String nameEstablishment);

	 List<IEstablishment> getEstablishmentsByCity(String city);

	 List<IEstablishment> getEstablishmentsByProvince(
			String province);

	 List<IEstablishment> getEstablishmentsByZone(String zone);

	 List<IEstablishment> getEstablishmentsByStreet(String street);

	 List<IEstablishment> getEstablishmentsByZipCode(
			Integer zipCode);

	 List<IEstablishment> getEstablishmentsByRegistryDate(
			Date registryDate);

	 IEstablishment getEstablishmentByID(Integer establishmentID);

	 List<IEstablishment> getEstablishmentByUserLoginID(
			String userLoginID);

	 void insertEstablishment(String nameEstablishment,
			String city, String province, String zone, String street,
			Integer zipCode, String userLogin);

	 void delete(Integer ESTID);

	 void updateEstablishment(IEstablishment establishment);

}