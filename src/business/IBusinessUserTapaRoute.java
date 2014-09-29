package business;

import java.util.List;

import domain.ITapaRoute;
import domain.IUser;

public interface IBusinessUserTapaRoute {

	 List<IUser> getAllUserFromUserTapaRoute();

	 List<IUser> getAllUserByRoute(ITapaRoute tapaRoute);

	 List<ITapaRoute> getAllTapaRoutesFromUserTapaRoute();

	 List<ITapaRoute> getAllTapaRoutesByUser(IUser user);

	 void insertUsersTapaRoute(IUser user, ITapaRoute tapaRoute);

	 void deleteUsersTapaRoute(IUser user, ITapaRoute tapaRoute);

}