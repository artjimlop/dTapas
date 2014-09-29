package business;

import java.util.List;

import domain.IEstablishment;
import domain.ITapaRoute;

public interface IBusinessEstablishmentTapaRoute {

	 List<IEstablishment> getAllEstablishments();

	 List<ITapaRoute> getTapaRouteByEstablishment(
			Integer establishmentID);

	 List<IEstablishment> getEstablishmentByRoute(Integer routeID);

	 void insertEstablishmentTapaRoute(
			IEstablishment establishment, ITapaRoute tapaRoute);

	 void delete(IEstablishment establishment,
			ITapaRoute tapaRoute);

}