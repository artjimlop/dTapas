package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import manager.ConnectionManager;
import utils.IDGenerator;
import utils.UIDGenerator;
import domain.Establishment;
import domain.IEstablishment;
import domain.IEstablishmentComment;
import domain.IEstablishmentScore;
import domain.ITapaRoute;
import domain.IUser;

public class JDBCEstablishmentTapaRouteDAO implements IEstablishmentTapaRouteDAO{
	
	private Connection conn; 
	private String sql;
	private PreparedStatement stmt;
	private ResultSet result;
//	private IProductDAO product;
//	private ITapaRouteDAO tapaRoute;
	private IEstablishmentScoreDAO usEstScorDAO;
	private IEstablishmentCommentDAO usEstCommDAO;
	private IUserDAO userDAO;

	@Override
	public List<IEstablishment> getAllEstablishments(){
		
		List<IEstablishment> searchResults = new ArrayList<>();
		conn = ConnectionManager.getInstance().openConnection();
		IEstablishmentDAO establishmentDAO = new JDBCEstablishmentDAO();
		sql = "SELECT * FROM taparouteestablishments; ";
		
		try{
			
			stmt = conn.prepareStatement(sql);
			result = stmt.executeQuery();
			
			while(result.next()){
				
				for(IEstablishment e : establishmentDAO.getAllEstablishments()){
					String oid = new JDBCEstablishmentDAO().getEstablishmentOIDByID(e.getEstablishmentID());
					if(oid.equals(result.getString("FK_ESTOID"))){
						searchResults.add(e);
					}
				}
			}
			
			result.close();
			stmt.close();
			
		}catch (SQLException e) {
			
			e.printStackTrace();
		
		}finally{
			ConnectionManager.getInstance().closeConnection(conn);
			try{
				if(result!= null){
					result.close();
				}
				if(stmt != null){
					stmt.close();
				}
			}catch (SQLException e) {
				}
			}
		
		return searchResults;
	}
	
	@Override
	public List<IEstablishment> getEstablishmentByRoute(String string){
		
		List<IEstablishment> searchResults = new ArrayList<>();
		conn = ConnectionManager.getInstance().openConnection();
		
		sql = "SELECT * FROM taparouteestablishments WHERE FK_ROUTEOID = ?;";
		
		try{
			
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, string);
			result = stmt.executeQuery();
			
//			User user = null;
//			List<Product> produc = new ArrayList<Product>();
//			List<TapaRoute> tapaRout = new ArrayList<TapaRoute>();
//			List<EstablishmentScore> estScore = new ArrayList<EstablishmentScore>();
//			List<EstablishmentComment> estComment = new ArrayList<EstablishmentComment>();
			
			IEstablishment establishment = null;
//			product = new JDBCProductDAO();
//			tapaRoute = new JDBCTapaRouteDAO();
			usEstScorDAO = new JDBCEstablishmentScoreDAO();
			usEstCommDAO = new JDBCEstablishmentCommentDAO();
			IEstablishmentDAO estDAO = new JDBCEstablishmentDAO();
//			Map<User, EstablishmentScore> userEstablishmentScore = new HashMap<User, EstablishmentScore>();
//			Map<User, List<EstablishmentComment>> userEstablishmentComment = new HashMap<User, List<EstablishmentComment>>();
			
			
			while(result.next()){
				
//				produc = product.getProductByEstablishment(result.getString("ESTOID"));
//				tapaRout = tapaRoute.getTapaRouteByName(result.getString("TRESTOID"));
				
				//Carga mapa userEstablishmentScore
//				estScore = usEstScorDAO.getScoresByUser(result.getString("ESTOID"));
//				for(EstablishmentScore establishmentScore : estScore){
//					user = userDAO.getUserByOID(establishmentScore.getUserOID());
//					userEstablishmentScore.put(user, establishmentScore);
//				}
//				//Carga mapa userEstablishmentComment
//				estComment = usEstCommDAO.getEstablishmentCommentByESTOID(result.getString("FK_ESTOID"));
//				for(EstablishmentComment establishmentComment : estComment){
//					user = userDAO.getUserByOID(establishmentComment.getCommentarieOID());
//					if(userEstablishmentComment.containsKey(user)){
//						userEstablishmentComment.get(user).add(establishmentComment);
//					}
//					else{
//						userEstablishmentComment.put(user, estComment);
//					}
//				}
//			
				String establishmentOID = result.getString("FK_ESTOID");
				establishment = estDAO.getEstablishmentByOID(establishmentOID);
				
				searchResults.add(establishment);
			}
			
			result.close();
			stmt.close();
			
		}catch (SQLException e) {
			
			e.printStackTrace();
			
		}finally{
			ConnectionManager.getInstance().closeConnection(conn);
			try{
				if(result!= null){
					result.close();
				}
				if(stmt != null){
					stmt.close();
				}
			}catch (SQLException e) {
				}
			}
		
		return searchResults;
	}
	
	@Override
	public List<ITapaRoute> getTapaRouteByEstablishment(String TRESTOID){
		
		List<ITapaRoute> searchResults = new ArrayList<>();
		conn = ConnectionManager.getInstance().openConnection();
		
		sql = "SELECT * FROM taparouteestablishments WHERE FK_TRESTOID = ?;";
		
		try{
			
			stmt = conn.prepareStatement(sql);
			result = stmt.executeQuery();
			
//			User user = null;
//			List<Product> produc = new ArrayList<Product>();
//			List<TapaRoute> tapaRout = new ArrayList<TapaRoute>();
//			List<EstablishmentScore> estScore = new ArrayList<EstablishmentScore>();
//			List<EstablishmentComment> estComment = new ArrayList<EstablishmentComment>();
			
//			Establishment establishment = null;
//			product = new JDBCProductDAO();
//			tapaRoute = new JDBCTapaRouteDAO();
			usEstScorDAO = new JDBCEstablishmentScoreDAO();
			usEstCommDAO = new JDBCEstablishmentCommentDAO();
			ITapaRouteDAO tapaRouteDAO = new JDBCTapaRouteDAO();
//			Map<User, EstablishmentScore> userEstablishmentScore = new HashMap<User, EstablishmentScore>();
//			Map<User, List<EstablishmentComment>> userEstablishmentComment = new HashMap<User, List<EstablishmentComment>>();
			
			
			while(result.next()){
				
//				produc = product.getProductByEstablishment(result.getString("ESTOID"));
//				tapaRout = tapaRoute.getTapaRouteByName(result.getString("TRESTOID"));
				
				//Carga mapa userEstablishmentScore
//				estScore = usEstScorDAO.getScoresByUser(result.getString("ESTOID"));
//				for(EstablishmentScore establishmentScore : estScore){
//					user = userDAO.getUserByOID(establishmentScore.getUserOID());
//					userEstablishmentScore.put(user, establishmentScore);
//				}
//				//Carga mapa userEstablishmentComment
//				estComment = usEstCommDAO.getEstablishmentCommentByESTOID(result.getString("FK_ESTOID"));
//				for(EstablishmentComment establishmentComment : estComment){
//					user = userDAO.getUserByOID(establishmentComment.getCommentarieOID());
//					if(userEstablishmentComment.containsKey(user)){
//						userEstablishmentComment.get(user).add(establishmentComment);
//					}
//					else{
//						userEstablishmentComment.put(user, estComment);
//					}
//				}
//				
//				establishment = new Establishment(result.getString("nameestablishment"),
//						result.getString("city"), result.getString("province"),
//						result.getString("zone"), result.getString("street"),
//						result.getInt("zipcode"), result.getDate("registrydate"),
//						result.getString("FK_USOID"),
//						result.getString("ESTOID"));
				String routeOID = result.getString("FK_ROUTEOID");
				
				searchResults.add(tapaRouteDAO.getTapaRouteByOID(routeOID));
			}
			
			result.close();
			stmt.close();
			
		}catch (SQLException e) {
			
			e.printStackTrace();
			
		}finally{
			ConnectionManager.getInstance().closeConnection(conn);
			try{
				if(result!= null){
					result.close();
				}
				if(stmt != null){
					stmt.close();
				}
			}catch (SQLException e) {
				}
			}
		
		return searchResults;
	}
	
	@Override
	public List<IEstablishment> getEstablishmentTapaRouteByUser(String USOID){
		
		List<IEstablishment> searchResults = new ArrayList<>();
		conn = ConnectionManager.getInstance().openConnection();
		
		sql = "SELECT * FROM TRESTOID" +
				"WHERE(FK_USOID='" + USOID + "');";
		
		try{
			stmt = conn.prepareStatement(sql);
			result = stmt.executeQuery();
			
			IUser user = null;
//			List<Product> produc = new ArrayList<Product>();
//			List<TapaRoute> tapaRout = new ArrayList<TapaRoute>();
			List<IEstablishmentScore> estScore = new ArrayList<IEstablishmentScore>();
			List<IEstablishmentComment> estComment = new ArrayList<IEstablishmentComment>();
			
			IEstablishment establishment = null;
//			product = new JDBCProductDAO();
//			tapaRoute = new JDBCTapaRouteDAO();
			usEstScorDAO = new JDBCEstablishmentScoreDAO();
			usEstCommDAO = new JDBCEstablishmentCommentDAO();
		
			Map<IUser, IEstablishmentScore> userEstablishmentScore = new HashMap<IUser, IEstablishmentScore>();
			Map<IUser, List<IEstablishmentComment>> userEstablishmentComment = new HashMap<IUser, List<IEstablishmentComment>>();
			
			
			while(result.next()){
				
//				produc = product.getProductByEstablishment(result.getString("ESTOID"));
//				tapaRout = tapaRoute.getTapaRouteByName(result.getString("TRESTOID"));
				
				//Carga mapa userEstablishmentScore
				estScore = usEstScorDAO.getScoresByUser(result.getString("ESTOID"));
				for(IEstablishmentScore establishmentScore : estScore){
					user = userDAO.getUserByLogin(establishmentScore.getLogin());
					userEstablishmentScore.put(user, establishmentScore);
				}
				//Carga mapa userEstablishmentComment
				IEstablishment est = new JDBCEstablishmentDAO().getEstablishmentByOID(result.getString("FK_ESTOID"));
				estComment = usEstCommDAO.getEstablishmentCommentByESTOID(est.getEstablishmentID());
				for(IEstablishmentComment establishmentComment : estComment){
					user = userDAO.getUserByLogin(establishmentComment.getUserCommentarieID());
					if(userEstablishmentComment.containsKey(user)){
						userEstablishmentComment.get(user).add(establishmentComment);
					}
					else{
						userEstablishmentComment.put(user, estComment);
					}
				}
				String login = new JDBCUserDAO().getUserByOID(USOID).getLogin();
				Integer establishmentID = new JDBCEstablishmentDAO().getEstablishmentByOID(result.getString("ESTOID")).getEstablishmentID(); 
				establishment = new Establishment(result.getString("nameestablishment"),
						result.getString("city"), result.getString("province"),
						result.getString("zone"), result.getString("street"),
						result.getInt("zipcode"), result.getDate("registrydate"),
						login,
						establishmentID);
				
				searchResults.add(establishment);
			}
			
			result.close();
			stmt.close();
			
		}catch (SQLException e) {
			
			e.printStackTrace();
			
		}finally{
			ConnectionManager.getInstance().closeConnection(conn);
			try{
				if(result!= null){
					result.close();
				}
				if(stmt != null){
					stmt.close();
				}
			}catch (SQLException e) {
				}
			}
		
		return searchResults;
	}

	
	public void updateEstablishmentTapaRoute(IEstablishment establishmentTapaRoute, String routeOID){
		
		conn = ConnectionManager.getInstance().openConnection();
		
		sql = "UPDATE TRESTOID SET nameestablishment='" + establishmentTapaRoute.getNameEstablishment() +
				"',FK_ESTOID='" +"'WHERE FK_ROUTEOID='" + routeOID + "';";
		
		try{
			
			stmt = conn.prepareStatement(sql);
			stmt.executeUpdate();
			
		}catch (SQLException e) {
			
			System.out.println("Message: " + e.getMessage());
            System.out.println("SQLState: " + e.getSQLState());
            System.out.println("ErrorCode: " + e.getErrorCode());
            
		}finally{
			ConnectionManager.getInstance().closeConnection(conn);
			try{
				if(result!= null){
					result.close();
				}
				if(stmt != null){
					stmt.close();
				}
			}catch (SQLException e) {
				}
			}
		
	}

	@Override
	public void delete(IEstablishment establishment, ITapaRoute tapaRoute){
		
		conn = ConnectionManager.getInstance().openConnection();
		
		String sql = "DELETE FROM taparouteestablishments WHERE FK_ESTOID = ? AND FK_ROUTEOID = ?;";

        try {
        	
            stmt = conn.prepareStatement(sql);
            String establishmentOID = new JDBCEstablishmentDAO().getEstablishmentOIDByID(establishment.getEstablishmentID());
            String tapaRouteOID = new JDBCTapaRouteDAO().getTapaRouteOIDByID(tapaRoute.getTapaRouteID());
            stmt.setString(1, establishmentOID);
            stmt.setString(2, tapaRouteOID);
            
            stmt.executeUpdate();
            
        } catch (SQLException e) {
        	
            System.err.println("Message: " + e.getMessage());
            System.err.println("SQLState: " + e.getSQLState());
            System.err.println("ErrorCode: " + e.getErrorCode());
            
        }finally{
			ConnectionManager.getInstance().closeConnection(conn);
			if(stmt != null)
				try {
					stmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
        }
		
	}

	public void insertEstablishmentTapaRoute(IEstablishment establishment, 
			ITapaRoute tapaRoute){
		
		conn = ConnectionManager.getInstance().openConnection();
		
		UIDGenerator uidGenerator = UIDGenerator.getInstance();
		String TRESTOID = uidGenerator.getKey();
		
		IDGenerator idGenerator = new IDGenerator("tapaRouteEstablishmentID", "taparouteestablishments");
		Integer tapaRouteID = idGenerator.nextValue();
		
		sql = "INSERT INTO taparouteestablishments (TRESTOID, FK_ESTOID, FK_ROUTEOID, tapaRouteEstablishmentID) " +
				"VALUES (?, ?, ?, ?);";
		
		
		try{
			stmt = conn.prepareStatement(sql);
			
			stmt.setString(1, TRESTOID);

			String establishmentOID = new JDBCEstablishmentDAO().getEstablishmentOIDByID(establishment.getEstablishmentID());
			Integer routeID = new IDGenerator("tapaRouteID","taparoutes").currentValue();
            String tapaRouteOID = new JDBCTapaRouteDAO().getTapaRouteOIDByID(routeID);
            stmt.setString(2, establishmentOID);
            stmt.setString(3, tapaRouteOID);
            stmt.setInt(4, tapaRouteID);
			
			stmt.executeUpdate();
			
		}catch (SQLException e) {
			
			System.out.println("Message: " + e.getMessage());
            System.out.println("SQLState: " + e.getSQLState());
            System.out.println("ErrorCode: " + e.getErrorCode());
            
		}finally{
			ConnectionManager.getInstance().closeConnection(conn);
			if(stmt != null)
				try {
					stmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
		}
	}

	@Override
	public List<ITapaRoute> getAllTapaRoutesFromEstablishmentTapaRoute(){
		List<ITapaRoute> searchResults = new ArrayList<>();
		conn = ConnectionManager.getInstance().openConnection();
		
		sql = "SELECT FK_ROUTEOID FROM taparouteestablishments;";
		
		try{
			
			stmt = conn.prepareStatement(sql);
			result = stmt.executeQuery();
			String tapaRouteOID;
			while(result.next()){
				tapaRouteOID = result.getString("FK_ROUTEOID");
				ITapaRoute tapaRoute = new JDBCTapaRouteDAO().getTapaRouteByOID(tapaRouteOID);
				searchResults.add(tapaRoute);
			}
			
			result.close();
			stmt.close();
			
		}catch (SQLException e) {
			
			e.printStackTrace();
		
		}finally{
			ConnectionManager.getInstance().closeConnection(conn);
			try{
				if(result!= null){
					result.close();
				}
				if(stmt != null){
					stmt.close();
				}
			}catch (SQLException e) {
				}
			}
		
		return searchResults;
	}
	
	@Override
	public List<IEstablishment> getAllEstablishmentsFromEstablishmentTapaRoute(){
		List<IEstablishment> searchResults = new ArrayList<>();
		IEstablishmentDAO establishmentDAO = new JDBCEstablishmentDAO();
		IEstablishment establishment = null;
		conn = ConnectionManager.getInstance().openConnection();
		
		sql = "SELECT FK_ESTOID FROM taparouteestablishments;";
		
		try{
			
			stmt = conn.prepareStatement(sql);
			result = stmt.executeQuery();
			String establishmentOID;
			while(result.next()){
				establishmentOID = result.getString("FK_ESTOID");
				establishment = establishmentDAO.getEstablishmentByOID(establishmentOID);
				searchResults.add(establishment);
			}
			
			result.close();
			stmt.close();
			
		}catch (SQLException e) {
			
			e.printStackTrace();
		
		}finally{
			ConnectionManager.getInstance().closeConnection(conn);
			try{
				if(result!= null){
					result.close();
				}
				if(stmt != null){
					stmt.close();
				}
			}catch (SQLException e) {
				}
			}
		
		return searchResults;
	}

	@Override
	public List<ITapaRoute> getTapaRouteByEstablishmentID(
			Integer establishmentID) {
		List<ITapaRoute> searchResults = new ArrayList<>();
		conn = ConnectionManager.getInstance().openConnection();
		String oid = new JDBCEstablishmentDAO().getEstablishmentOIDByID(establishmentID);
		
		sql = "SELECT * FROM taparouteestablishments WHERE FK_TRESTOID = ?;";
		
		try{
			
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, oid);
			result = stmt.executeQuery();
			

			usEstScorDAO = new JDBCEstablishmentScoreDAO();
			usEstCommDAO = new JDBCEstablishmentCommentDAO();
			ITapaRouteDAO tapaRouteDAO = new JDBCTapaRouteDAO();

			
			
			while(result.next()){
				

				String routeOID = result.getString("FK_ROUTEOID");
				
				searchResults.add(tapaRouteDAO.getTapaRouteByOID(routeOID));
			}
			
			result.close();
			stmt.close();
			
		}catch (SQLException e) {
			
			e.printStackTrace();
			
		}finally{
			ConnectionManager.getInstance().closeConnection(conn);
			try{
				if(result!= null){
					result.close();
				}
				if(stmt != null){
					stmt.close();
				}
			}catch (SQLException e) {
				}
			}
		
		return searchResults;
	}

	@Override
	public List<IEstablishment> getEstablishmentTapaRouteByUserLogin(String login) {
		List<IEstablishment> searchResults = new ArrayList<>();
		conn = ConnectionManager.getInstance().openConnection();
		String oid = new JDBCUserDAO().getUserOIDByLogin(login);
		sql = "SELECT * FROM TRESTOID" +
				"WHERE(FK_USOID='" + oid + "');";
		
		try{
			stmt = conn.prepareStatement(sql);
			result = stmt.executeQuery();
			
			IUser user = null;

			List<IEstablishmentScore> estScore = new ArrayList<IEstablishmentScore>();
			List<IEstablishmentComment> estComment = new ArrayList<IEstablishmentComment>();
			
			Establishment establishment = null;

			usEstScorDAO = new JDBCEstablishmentScoreDAO();
			usEstCommDAO = new JDBCEstablishmentCommentDAO();
		
			Map<IUser, IEstablishmentScore> userEstablishmentScore = new HashMap<IUser, IEstablishmentScore>();
			Map<IUser, List<IEstablishmentComment>> userEstablishmentComment = new HashMap<IUser, List<IEstablishmentComment>>();
			
			
			while(result.next()){
				

				estScore = usEstScorDAO.getScoresByUser(result.getString("ESTOID"));
				for(IEstablishmentScore establishmentScore : estScore){
					user = userDAO.getUserByLogin(establishmentScore.getLogin());
					userEstablishmentScore.put(user, establishmentScore);
				}
				
				IEstablishment est = new JDBCEstablishmentDAO().getEstablishmentByOID(result.getString("FK_ESTOID"));
				estComment = usEstCommDAO.getEstablishmentCommentByESTOID(est.getEstablishmentID());
				for(IEstablishmentComment establishmentComment : estComment){
					user = userDAO.getUserByLogin(establishmentComment.getUserCommentarieID());
					if(userEstablishmentComment.containsKey(user)){
						userEstablishmentComment.get(user).add(establishmentComment);
					}
					else{
						userEstablishmentComment.put(user, estComment);
					}
				}
				
				Integer establishmentID = new JDBCEstablishmentDAO().getEstablishmentByOID(result.getString("ESTOID")).getEstablishmentID(); 
				establishment = new Establishment(result.getString("nameestablishment"),
						result.getString("city"), result.getString("province"),
						result.getString("zone"), result.getString("street"),
						result.getInt("zipcode"), result.getDate("registrydate"),
						login,
						establishmentID);
				
				searchResults.add(establishment);
			}
			
			result.close();
			stmt.close();
			
		}catch (SQLException e) {
			
			e.printStackTrace();
			
		}finally{
			ConnectionManager.getInstance().closeConnection(conn);
			try{
				if(result!= null){
					result.close();
				}
				if(stmt != null){
					stmt.close();
				}
			}catch (SQLException e) {
				}
			}
		
		return searchResults;
	}

	@Override
	public List<IEstablishment> getEstablishmentByRouteID(Integer routeID) {
		List<IEstablishment> searchResults = new ArrayList<>();
		conn = ConnectionManager.getInstance().openConnection();
		String oid = new JDBCTapaRouteDAO().getTapaRouteOIDByID(routeID);
		sql = "SELECT * FROM taparouteestablishments WHERE FK_ROUTEOID = ?;";
		
		try{
			
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, oid);
			result = stmt.executeQuery();
			
			IEstablishment establishment = null;

			usEstScorDAO = new JDBCEstablishmentScoreDAO();
			usEstCommDAO = new JDBCEstablishmentCommentDAO();
			IEstablishmentDAO estDAO = new JDBCEstablishmentDAO();
		
			while(result.next()){
		
				String establishmentOID = result.getString("FK_ESTOID");
				establishment = estDAO.getEstablishmentByOID(establishmentOID);
				
				searchResults.add(establishment);
			}
			
			result.close();
			stmt.close();
			
		}catch (SQLException e) {
			
			e.printStackTrace();
			
		}finally{
			ConnectionManager.getInstance().closeConnection(conn);
			try{
				if(result!= null){
					result.close();
				}
				if(stmt != null){
					stmt.close();
				}
			}catch (SQLException e) {
				}
			}
		
		return searchResults;
	}
}

