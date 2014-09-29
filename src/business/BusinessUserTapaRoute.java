package business;

import java.util.List;
import dao.IUserTapaRouteDAO;
import dao.JDBCUserTapaRouteDAO;
import domain.ITapaRoute;
import domain.IUser;

public class BusinessUserTapaRoute implements IBusinessUserTapaRoute {
	
	private IUserTapaRouteDAO userTapaRouteDAO;
	
	public BusinessUserTapaRoute(){
		userTapaRouteDAO = new JDBCUserTapaRouteDAO();
	}
	
	/* (non-Javadoc)
	 * @see business.IBusinessUserTapaRoute#getAllUserFromUserTapaRoute()
	 */
	@Override
	public List<IUser> getAllUserFromUserTapaRoute(){
		return userTapaRouteDAO.getAllUserFromUserTapaRoute();
	}
	
	/* (non-Javadoc)
	 * @see business.IBusinessUserTapaRoute#getAllUserByRoute(domain.ITapaRoute)
	 */
	@Override
	public List<IUser> getAllUserByRoute(ITapaRoute tapaRoute){
		return userTapaRouteDAO.getAllUserByRouteOID(tapaRoute);
	}
	
	/* (non-Javadoc)
	 * @see business.IBusinessUserTapaRoute#getAllTapaRoutesFromUserTapaRoute()
	 */
	@Override
	public List<ITapaRoute> getAllTapaRoutesFromUserTapaRoute(){
		return userTapaRouteDAO.getAllTapaRoutesFromUserTapaRoute();
	}
	
	/* (non-Javadoc)
	 * @see business.IBusinessUserTapaRoute#getAllTapaRoutesByUser(domain.IUser)
	 */
	@Override
	public List<ITapaRoute> getAllTapaRoutesByUser(IUser user){
		return userTapaRouteDAO.getAllTapaRoutesByUserOID(user);
	}
	
	/* (non-Javadoc)
	 * @see business.IBusinessUserTapaRoute#insertUsersTapaRoute(domain.IUser, domain.ITapaRoute)
	 */
	@Override
	public void insertUsersTapaRoute(IUser user, ITapaRoute tapaRoute){
		
//		UIDGenerator uidGenerator = UIDGenerator.getInstance();
//		
//		ITapaRoute tapaRoute = new BusinessTapaRoute().getTapaRouteByOID(tapaRouteOID);
//		IUser user = new BusinessUser().getUserByOID(userOID);
		
		userTapaRouteDAO.insertUsersTapaRoute(user, tapaRoute);
	}
	
	/* (non-Javadoc)
	 * @see business.IBusinessUserTapaRoute#deleteUsersTapaRoute(domain.IUser, domain.ITapaRoute)
	 */
	@Override
	public void deleteUsersTapaRoute(IUser user, ITapaRoute tapaRoute){		
		userTapaRouteDAO.deleteUsersTapaRoute(user, tapaRoute);
	}
	
}
