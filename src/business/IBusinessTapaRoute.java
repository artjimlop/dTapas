package business;

import java.sql.Date;
import java.util.List;

import domain.ITapaRoute;

public interface IBusinessTapaRoute {

	 List<ITapaRoute> getAllRoutes();

	 List<ITapaRoute> getTapaRouteByName(String name);

	 List<ITapaRoute> getTapaRouteByCreationDate(Date date);

	 List<ITapaRoute> getTapaRouteByTargetDate(Date date);

	 List<ITapaRoute> getTapaRouteByCreatorUser(String userLogin);

	 ITapaRoute getTapaRouteByID(Integer tapaRouteID);

	 void insertTapaRoute(ITapaRoute tapaRoute);

	 void updateTapaRoute(ITapaRoute tapaRoute);

	 void delete(Integer tapaRouteID);

	 String getTapaRouteOIDByID(Integer tapaRouteID);

}