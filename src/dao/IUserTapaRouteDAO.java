package dao;

import java.util.List;

import domain.ITapaRoute;
import domain.IUser;

public interface IUserTapaRouteDAO {

		List<IUser> getAllUserFromUserTapaRoute();
		List<IUser> getAllUserByRouteOID(ITapaRoute tapaRoute);
		
		List<ITapaRoute> getAllTapaRoutesFromUserTapaRoute();
		List<ITapaRoute> getAllTapaRoutesByUserOID(IUser user);
		
		void insertUsersTapaRoute(IUser user, ITapaRoute tapaRoute);
		void deleteUsersTapaRoute(IUser user, ITapaRoute tapaRoute);
		
}
