package business;

import java.sql.Date;
import java.util.List;

import dao.ITapaRouteDAO;
import dao.JDBCTapaRouteDAO;
import domain.ITapaRoute;
/**
 * 
 * @author Arturo Jimenez
 *
 */
public class BusinessTapaRoute implements IBusinessTapaRoute {
	
//	private static BusinessTapaRoute businessTapaRoute;
	
	//private List<TapaRoute> tapaRoutes;
	private ITapaRouteDAO tapaRouteDAO;
	
//	private Map<Establishment,TapaRoute> tapaRouteEstablishments = new HashMap<>();
//	private Map<TapaRouteComment,TapaRoute> tapaRouteComments = new HashMap<>();
//	private Map<User,TapaRoute> usersTapaRoutes = new HashMap<>();
	
//	public static synchronized BusinessTapaRoute getInstance(){
//		
//		if(businessTapaRoute==null){
//			businessTapaRoute = new BusinessTapaRoute();
//		}
//		return businessTapaRoute;
//	}
	
	public BusinessTapaRoute(){
		
		tapaRouteDAO = new JDBCTapaRouteDAO();
//		this.tapaRoutes = tapaRouteDAO.getAllRoutes();
//		BusinessEstablishmentTapaRoute businessEstablishmentTapaRoute = BusinessEstablishmentTapaRoute.getInstance();
//		BusinessTapaRouteComment businessTapaRouteComment = BusinessTapaRouteComment.getInstance();
//		BusinessUserTapaRoute businessUserTapaRoute = BusinessUserTapaRoute.getInstance();
//		
//		//this.tapaRouteEstablishments = loadTapaRouteEstablishments();
//		for(TapaRoute route:getAllRoutes()){
//			//falta ponerle el getInstance en la linea de abajo
//			for(Establishment establishment:businessEstablishmentTapaRoute.getEstablishmentByRoute(route.getTapaRouteOID())){
//				tapaRouteEstablishments.put(establishment, route);
//			}
//		}
//		//this.tapaRouteComments = loadTapaRouteComments();
//		for(TapaRoute route: getAllRoutes()){
//			//Se obtienen los comments:
//			for(TapaRouteComment comment:businessTapaRouteComment.getCommentariesByRoute(route.getTapaRouteOID())){
//				tapaRouteComments.put(comment, route);
//			}
//		}
//		//this.usersTapaRoutes = loadTapaRouteUsers();
//		for(TapaRoute tapaRoute:getAllRoutes()){
//			//Se obtienen los usuarios vinculados a esa ruta:
//			for(User tapaRouteUser: businessUserTapaRoute.getAllUserByRouteOID(tapaRoute.getTapaRouteOID())){
//				usersTapaRoutes.put(tapaRouteUser, tapaRoute);
//			}
//		}
	}
	
	/* (non-Javadoc)
	 * @see business.IBusinessTapaRoute#getAllRoutes()
	 */
	@Override
	public List<ITapaRoute> getAllRoutes() {
		tapaRouteDAO = new JDBCTapaRouteDAO();
		return tapaRouteDAO.getAllRoutes();
	}
	
	/* (non-Javadoc)
	 * @see business.IBusinessTapaRoute#getTapaRouteByName(java.lang.String)
	 */
	@Override
	public List<ITapaRoute> getTapaRouteByName(String name){
		tapaRouteDAO = new JDBCTapaRouteDAO();
		return tapaRouteDAO.getTapaRouteByName(name);
	}
	
	/* (non-Javadoc)
	 * @see business.IBusinessTapaRoute#getTapaRouteByCreationDate(java.sql.Date)
	 */
	@Override
	public List<ITapaRoute> getTapaRouteByCreationDate(Date date){
		tapaRouteDAO = new JDBCTapaRouteDAO();
		return tapaRouteDAO.getTapaRouteByCreationDate(date);
	}
	
	/* (non-Javadoc)
	 * @see business.IBusinessTapaRoute#getTapaRouteByTargetDate(java.sql.Date)
	 */
	@Override
	public List<ITapaRoute> getTapaRouteByTargetDate(Date date){
		tapaRouteDAO = new JDBCTapaRouteDAO();
		return tapaRouteDAO.getTapaRouteByCreationDate(date);
	}
	
	/* (non-Javadoc)
	 * @see business.IBusinessTapaRoute#getTapaRouteByCreatorUser(java.lang.String)
	 */
	@Override
	public List<ITapaRoute> getTapaRouteByCreatorUser(String userLogin){
		tapaRouteDAO = new JDBCTapaRouteDAO();
		return tapaRouteDAO.getTapaRouteByCreatorUser(userLogin);
	}
	
	/* (non-Javadoc)
	 * @see business.IBusinessTapaRoute#getTapaRouteByID(java.lang.Integer)
	 */
	@Override
	public ITapaRoute getTapaRouteByID(Integer tapaRouteID){
		tapaRouteDAO = new JDBCTapaRouteDAO();
		return tapaRouteDAO.getTapaRouteByID(tapaRouteID);
	}
	
	/*
	 * void insertTapaRoute(String name, Date creationDate, Date targetDate, Integer USOID);
	void updateTapaRoute(TapaRoute tapaRoute);
	
	void delete(Integer RUTTAPOID);
	 */
	
//	public void insertTapaRoute(String name, Date targetDate, String userCreatorOID){
//		UIDGenerator uidGenerator = UIDGenerator.getInstance();
//		String routeOID = uidGenerator.getKey();
//		
//		TapaRoute route = new TapaRoute(name, targetDate, userCreatorOID, routeOID);
//		tapaRouteDAO = new JDBCTapaRouteDAO();
//		
//		tapaRouteDAO.insertTapaRoute(route);
//	}
	
	/* (non-Javadoc)
	 * @see business.IBusinessTapaRoute#insertTapaRoute(domain.ITapaRoute)
	 */
	@Override
	public void insertTapaRoute(ITapaRoute tapaRoute){
		tapaRouteDAO = new JDBCTapaRouteDAO();
		tapaRouteDAO.insertTapaRoute(tapaRoute);
	}
	
	/* (non-Javadoc)
	 * @see business.IBusinessTapaRoute#updateTapaRoute(domain.ITapaRoute)
	 */
	@Override
	public void updateTapaRoute(ITapaRoute tapaRoute){
		tapaRouteDAO = new JDBCTapaRouteDAO();
		tapaRouteDAO.updateTapaRoute(tapaRoute);
	}
			
//	public void updateTapaRoute(String name, Date targetDate, 
//			String userCreatorOID, String tapaRouteOID){
//		TapaRoute tapaRoute = new TapaRoute(name,targetDate,userCreatorOID,tapaRouteOID);
//		
//		tapaRouteDAO = new JDBCTapaRouteDAO();
//		tapaRouteDAO.updateTapaRoute(tapaRoute);
//	}
	
	/* (non-Javadoc)
	 * @see business.IBusinessTapaRoute#delete(java.lang.Integer)
	 */
	@Override
	public void delete(Integer tapaRouteID){
		tapaRouteDAO.delete(tapaRouteID);
	}
	
	/* (non-Javadoc)
	 * @see business.IBusinessTapaRoute#getTapaRouteOIDByID(java.lang.Integer)
	 */
	@Override
	public String getTapaRouteOIDByID(Integer tapaRouteID){
		tapaRouteDAO = new JDBCTapaRouteDAO();
		return tapaRouteDAO.getTapaRouteOIDByID(tapaRouteID);
	}
	
//	private void updateVariables(){
//		tapaRouteDAO = new JDBCTapaRouteDAO();
//		this.tapaRoutes = tapaRouteDAO.getAllRoutes();
//		tapaRouteDAO.getAllRoutes();
//	}
	
	/*
	 * tapaRouteUsers.addAll(new JDBCUserTapaRouteDAO().getAllUserByRouteOID(ruteOID));
				tapaRouteComments.addAll(new JDBCTapaRouteCommentDAO().getCommentariesByRoute(ruteOID));
				tapaRouteEstablishments.addAll(new JDBCEstablishmentTapaRouteDAO().getEstablishmentByRoute(ruteOID));
	 */
	
//	private Map<User,TapaRoute> loadTapaRouteUsers() throws SQLException{
//		usersTapaRoutes = new HashMap<>();
//		
//		for(TapaRoute tapaRoute:getAllRoutes()){
//			//Se obtienen los usuarios vinculados a esa ruta:
//			BusinessUserTapaRoute businessObject = BusinessUserTapaRoute.getInstance();
//			for(User tapaRouteUser: businessObject.getAllUserByRouteOID(tapaRoute.getTapaRouteOID())){
//				usersTapaRoutes.put(tapaRouteUser, tapaRoute);
//			}
//		}
//		
//		return usersTapaRoutes;
//	}
//	
//	private Map<TapaRouteComment,TapaRoute> loadTapaRouteComments() throws SQLException{
//		tapaRouteComments = new HashMap<>();
//		
//		for(TapaRoute route: getAllRoutes()){
//			//Se obtienen los comments:
//			BusinessTapaRouteComment businessObject = BusinessTapaRouteComment.getInstance();
//			for(TapaRouteComment comment:businessObject.getCommentariesByRoute(route.getTapaRouteOID())){
//				tapaRouteComments.put(comment, route);
//			}
//		}
//		
//		return tapaRouteComments;
//	}
//	
//	private Map<Establishment,TapaRoute> loadTapaRouteEstablishments() throws SQLException{
//		tapaRouteEstablishments = new HashMap<>();
//		
//		for(TapaRoute route:getAllRoutes()){
//			//falta ponerle el getInstance en la linea de abajo
//			BusinessEstablishmentTapaRoute businessObject = BusinessEstablishmentTapaRoute.getInstance();
//			for(Establishment establishment:businessObject.getEstablishmentByRoute(route.getTapaRouteOID())){
//				tapaRouteEstablishments.put(establishment, route);
//			}
//		}
//		
//		return tapaRouteEstablishments;
//	}
	
//	public Map<User,TapaRoute> getTapaRouteUsers(){
//		return this.usersTapaRoutes;
//	}
//	
//	public Map<TapaRouteComment,TapaRoute> getTapaRouteComments(){
//		return this.tapaRouteComments;
//	}
//	
//	public Map<Establishment,TapaRoute> getTapaRouteEstablishments(){
//		return this.tapaRouteEstablishments;
//	}
}
