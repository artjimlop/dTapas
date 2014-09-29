package business;

import java.util.List;

import dao.IEstablishmentTapaRouteDAO;
import dao.JDBCEstablishmentTapaRouteDAO;
import domain.IEstablishment;
import domain.ITapaRoute;

public class BusinessEstablishmentTapaRoute implements IBusinessEstablishmentTapaRoute {
	
//	private static BusinessEstablishmentTapaRoute businessEstablishmentTapaRoute;
//	
//	private List<Establishment> establishmentsTapaRoute;
	private IEstablishmentTapaRouteDAO establishmentTapaRouteDAO;
	
//	private Map<TapaRoute, List<Establishment>> establishmentsTapaRoutes;
	
//	public static synchronized BusinessEstablishmentTapaRoute getInstance(){
//		
//		if(businessEstablishmentTapaRoute==null){
//			businessEstablishmentTapaRoute = new BusinessEstablishmentTapaRoute();
//		}
//		return businessEstablishmentTapaRoute;
//	}
	
	public BusinessEstablishmentTapaRoute(){
		
		establishmentTapaRouteDAO = new JDBCEstablishmentTapaRouteDAO();
//		Set<Establishment> set = BusinessTapaRoute.getInstance().getTapaRouteEstablishments().keySet();
		//this.establishmentsTapaRoute =establishmentTapaRouteDAO.getAllEstablishments();
//		this.establishmentsTapaRoute = establishmentTapaRouteDAO.getAllEstablishments();  
//		establishmentsTapaRoutes = loadEstablishmentsTapaRoutes();
	}
	
	/* (non-Javadoc)
	 * @see business.IBusinessEstablishmentTapaRoute#getAllEstablishments()
	 */
	@Override
	public List<IEstablishment> getAllEstablishments(){
		establishmentTapaRouteDAO = new JDBCEstablishmentTapaRouteDAO();
		return establishmentTapaRouteDAO.getAllEstablishments();
//		return this.establishmentsTapaRoute;
	}
	
//	public List<Establishment> getEstablishmentTapaRouteByUser(String USOID){
//		
//		List<Establishment> establishments = new ArrayList<>();
//		
//		for(Establishment possibleEstablishment:getAllEstablishments()){
//			if(possibleEstablishment.getUserCreatorOID().equals(USOID)){
//				establishments.add(possibleEstablishment);
//			}
//		}
//		
//		return establishments;
//		establishmentTapaRouteDAO = new JDBCEstablishmentTapaRouteDAO();
//		return establishmentTapaRouteDAO.getEstablishmentTapaRouteByUser(USOID);
//	}
	
	
	/* (non-Javadoc)
	 * @see business.IBusinessEstablishmentTapaRoute#getTapaRouteByEstablishment(java.lang.Integer)
	 */
	@Override
	public List<ITapaRoute> getTapaRouteByEstablishment(Integer establishmentID){
//		
//		List<Establishment> establishments = new ArrayList<>();
//		
//		for(Establishment possibleEstablishment:getAllEstablishments()){
//			if(possibleEstablishment.getEstablishmentOID().equals(TRESTOID)){
//				establishments.add(possibleEstablishment);
//			}
//		}
//		
//		return establishments;
		establishmentTapaRouteDAO = new JDBCEstablishmentTapaRouteDAO();
		return establishmentTapaRouteDAO.getTapaRouteByEstablishmentID(establishmentID);
	}
	
	/* (non-Javadoc)
	 * @see business.IBusinessEstablishmentTapaRoute#getEstablishmentByRoute(java.lang.Integer)
	 */
	@Override
	public List<IEstablishment> getEstablishmentByRoute(Integer routeID){
		
//		return establishmentsTapaRoutes.get(FK_ROUTEOID);
		establishmentTapaRouteDAO = new JDBCEstablishmentTapaRouteDAO();
		return establishmentTapaRouteDAO.getEstablishmentByRouteID(routeID);
	}
	
	/* (non-Javadoc)
	 * @see business.IBusinessEstablishmentTapaRoute#insertEstablishmentTapaRoute(domain.IEstablishment, domain.ITapaRoute)
	 */
	@Override
	public void insertEstablishmentTapaRoute(IEstablishment establishment, ITapaRoute tapaRoute){
//		UIDGenerator uidGenerator = UIDGenerator.getInstance();		
		
//		BusinessTapaRoute bTr = new BusinessTapaRoute();
		
//		BusinessEstablishment bE = new BusinessEstablishment();
		establishmentTapaRouteDAO = new JDBCEstablishmentTapaRouteDAO();
		establishmentTapaRouteDAO.insertEstablishmentTapaRoute(establishment,tapaRoute);
	}
	
//	public void updateEstablishmentTapaRoute(String nameEstablishment, String city, String province,
//			String zone, String street, Integer zipCode, Date registryDate,
//			String userCreatorOID, String establishmentOID, String routeOID){
//		
//		establishmentTapaRouteDAO = new JDBCEstablishmentTapaRouteDAO();
//		Establishment establishment = new Establishment(nameEstablishment, city, province,
//				zone, street, zipCode, userCreatorOID, establishmentOID);
//		
//		establishmentTapaRouteDAO.updateEstablishmentTapaRoute(establishment, routeOID);
//	}
	//String establishmentOID, String FK_ROUTEOID
	
	/* (non-Javadoc)
	 * @see business.IBusinessEstablishmentTapaRoute#delete(domain.IEstablishment, domain.ITapaRoute)
	 */
	@Override
	public void delete(IEstablishment establishment, ITapaRoute tapaRoute){
		establishmentTapaRouteDAO = new JDBCEstablishmentTapaRouteDAO();
		establishmentTapaRouteDAO.delete(establishment, tapaRoute);
	}

	
//	private Map<TapaRoute, List<Establishment>> loadEstablishmentsTapaRoutes(){
//		//get all routes y get all establishments de establishmentTapaRoutes
//		Iterator<Establishment> itorEstablishments = establishmentTapaRouteDAO.getAllEstablishmentsFromEstablishmentTapaRoute().iterator();
//		Iterator<TapaRoute> itorRoutes = establishmentTapaRouteDAO.getAllTapaRoutesFromEstablishmentTapaRoute().iterator();
//		
//		Map<TapaRoute,List<Establishment>> map = new HashMap<>();
//		
//		BusinessTapaRoute bT = new BusinessTapaRoute();
//		BusinessEstablishment bE = new BusinessEstablishment();
//		
//		TapaRoute route;
//		Establishment establishment;
//		
//		while(itorRoutes.hasNext()){
//			route = bT.getTapaRouteByOID(itorRoutes.next().getTapaRouteOID());
//			establishment = bE.getEstablishmentByEstablishmentOID(itorEstablishments.next().getEstablishmentOID());
//			
//			if(map.containsKey(route)){
//				if(!map.get(route).contains(establishment)){
//					map.get(route).add(establishment);
//				}
//			}else{
//				List<Establishment> list = new ArrayList<>();
//				list.add(establishment);
//				map.put(route, list);
//			}
//		}
//		return map;
//	}
}

