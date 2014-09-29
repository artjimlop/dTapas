package dao;

import java.sql.Date;
import java.util.List;

import domain.ITapaRoute;

public interface ITapaRouteDAO {
	
	List<ITapaRoute> getAllRoutes();
	List<ITapaRoute> getTapaRouteByName(String name);
	List<ITapaRoute> getTapaRouteByCreationDate(Date date);
	List<ITapaRoute> getTapaRouteByTargetDate(Date date);
	//pone USOID, pero en realidad estamos usando el login
	List<ITapaRoute> getTapaRouteByCreatorUser(String USOID);
	
	ITapaRoute getTapaRouteByOID(String RUTTAPOID);
	
	void updateTapaRoute(ITapaRoute tapaRoute);
	
	void delete(Integer tapaRouteID);
	void insertTapaRoute(ITapaRoute tapaRoute);
	
	ITapaRoute getTapaRouteByID(Integer tapaRouteID);
	
	public String getTapaRouteOIDByID(Integer tapaRouteID);
	
	
}
