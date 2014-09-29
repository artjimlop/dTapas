package dao;

import java.util.List;

import domain.IEstablishment;
import domain.ITapaRoute;

public interface IEstablishmentTapaRouteDAO {
	
	List<IEstablishment> getAllEstablishments();
	List<ITapaRoute> getTapaRouteByEstablishment(String TRESTOID);
	List<IEstablishment> getEstablishmentTapaRouteByUser(String USOID);
	List<IEstablishment> getEstablishmentByRoute(String FK_ROUTEOID);
	
	void updateEstablishmentTapaRoute(IEstablishment establishmentTR, String routeOID);
	
	void delete(IEstablishment establishment, ITapaRoute tapaRoute);
	void insertEstablishmentTapaRoute(IEstablishment establishment, ITapaRoute tapaRoute);
	List<ITapaRoute> getAllTapaRoutesFromEstablishmentTapaRoute();
	List<IEstablishment> getAllEstablishmentsFromEstablishmentTapaRoute();
	
	List<ITapaRoute> getTapaRouteByEstablishmentID(Integer establishmentID);
	List<IEstablishment> getEstablishmentTapaRouteByUserLogin(String login);
	List<IEstablishment> getEstablishmentByRouteID(Integer routeID);
	
}


