package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import utils.UIDGenerator;
import manager.ConnectionManager;
import domain.IUser;
import domain.User;

public class JDBCUserDAO implements IUserDAO{
	
	private Connection conn; 
	private String sql;
	private PreparedStatement stmt;
	private ResultSet result;
	
	@Override
	public List<IUser> getAllUsers() {
		conn = ConnectionManager.getInstance().openConnection();
		List<IUser> resultList = new ArrayList<IUser>();

		
		sql = "SELECT * " +
				"FROM users;";
		
		try {
			
			stmt = conn.prepareStatement(sql);
			result = stmt.executeQuery();
			
			IUser user = null;
//			List<Integer> followeds = null;
//			List<Integer> followers = null;
//			Map<Product, ProductScore> productsScore = null;
//			Map<Product, List<ProductComment>> productsComment = null;
//			Map<Establishment, EstablishmentScore> establishmentsScore = null;
//			Map<Establishment, List<EstablishmentComment>> establishmentsComment = null;
			
			while(result.next()){
				
//				followeds = getFolloweds(result.getInt("USOID"));
//				followers = getFollowers(result.getInt("USOID"));
//				productsScore = getProductsScore(result.getInt("USOID"));
//				productsComment = getProductsComment(result.getInt("USOID"));
//				establishmentsScore = getEstablishmentScore(result.getInt("USOID"));
//				establishmentsComment = getEstablishmentsComment(result.getInt("USOID"));
//				
//				user = new User(result.getString("login"),result.getString("password"),result.getString("email"),result.getDate("registryDate"),
//						result.getString("name"), result.getString("surnames"), followers, followeds, productsScore,productsComment,
//						establishmentsScore, establishmentsComment, result.getInt("USOID"));
				user = new User(result.getString("login"),result.getString("password"),result.getString("email"),result.getDate("registryDate"),
						result.getString("name"), result.getString("surnames"));
				resultList.add(user);
			}
			
			result.close();
			stmt.close();
			
		} catch (SQLException e) {
			
			e.printStackTrace();
			
		}finally{
			ConnectionManager.getInstance().closeConnection(conn);
			try {
				if(result != null)
					result.close();
				if(stmt != null)
					stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return resultList;
	}
	
	public String getUserOIDByLogin(String login){
		conn = ConnectionManager.getInstance().openConnection();
		String oid = "";
		
		sql = "SELECT * " +
				"FROM users " +
				"WHERE login=?;";
		
		try {
			
			stmt = conn.prepareStatement(sql);
			
			stmt.setString(1, login);
			
			result = stmt.executeQuery();
			
			while(result.next()){
				oid = result.getString("USOID");
			}
			
			result.close();
			stmt.close();
			
		} catch (SQLException e) {
			
			e.printStackTrace();
			
		}finally{
			ConnectionManager.getInstance().closeConnection(conn);
			try {
				if(result != null)
					result.close();
				if(stmt != null)
					stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return oid;
	}
	
	@Override
	public IUser getUserByOID(String OID){
		conn = ConnectionManager.getInstance().openConnection();
		IUser user = null;
		
		sql = "SELECT * " +
				"FROM users " +
				"WHERE USOID=?;";
		
		try {
			
			stmt = conn.prepareStatement(sql);
			
			stmt.setString(1, OID);
			
			result = stmt.executeQuery();
			
			while(result.next()){
				user = new User(result.getString("login"),result.getString("password"),result.getString("email"),result.getDate("registryDate"),
						result.getString("name"), result.getString("surnames"));
			}
			
			result.close();
			stmt.close();
			
		} catch (SQLException e) {
			
			e.printStackTrace();
			
		}finally{
			ConnectionManager.getInstance().closeConnection(conn);
			try {
				if(result != null)
					result.close();
				if(stmt != null)
					stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return user;
	}
	
	@Override
	public List<IUser> getAllUsersByName(String name){
		conn = ConnectionManager.getInstance().openConnection();
		List<IUser> resultList = new ArrayList<IUser>();
		IUser user;
		
		sql = "SELECT * " +
				"FROM users " +
				"WHERE name=?;";
		
		try {
			
			stmt = conn.prepareStatement(sql);
			
			stmt.setString(1, name);
			
			result = stmt.executeQuery();
			
			while(result.next()){
				user = new User(result.getString("login"),result.getString("password"),result.getString("email"),result.getDate("registryDate"),
						result.getString("name"), result.getString("surnames"));
				resultList.add(user);
			}
			
			result.close();
			stmt.close();
			
		} catch (SQLException e) {
			
			e.printStackTrace();
			
		}finally{
			ConnectionManager.getInstance().closeConnection(conn);
			try {
				if(result != null)
					result.close();
				if(stmt != null)
					stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return resultList;
	}
	
	@Override
	public List<IUser> getAllUsersBySurname(String surnames){
		conn = ConnectionManager.getInstance().openConnection();
		List<IUser> resultList = new ArrayList<IUser>();
		IUser user;
		
		sql = "SELECT * " +
				"FROM users " +
				"WHERE surnames=?;";
		
		try {
			
			stmt = conn.prepareStatement(sql);
			
			stmt.setString(1, surnames);
			
			result = stmt.executeQuery();
			
			while(result.next()){
				user = new User(result.getString("login"),result.getString("password"),result.getString("email"),result.getDate("registryDate"),
						result.getString("name"), result.getString("surnames"));
				resultList.add(user);
			}
			
			result.close();
			stmt.close();
			
		} catch (SQLException e) {
			
			e.printStackTrace();
			
		}finally{
			ConnectionManager.getInstance().closeConnection(conn);
			try {
				if(result != null)
					result.close();
				if(stmt != null)
					stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return resultList;
	}
	
	@Override
	public IUser getUserByLogin(String login){
		conn = ConnectionManager.getInstance().openConnection();
		IUser user = null;
		
		sql = "SELECT * " +
				"FROM users " +
				"WHERE login=?;";
		
		try {
			
			stmt = conn.prepareStatement(sql);
			
			stmt.setString(1, login);
			
			result = stmt.executeQuery();
			
			while(result.next()){
				user = new User(result.getString("login"),result.getString("password"),result.getString("email"),result.getDate("registryDate"),
						result.getString("name"), result.getString("surnames"));
			}
			
			result.close();
			stmt.close();
			
		} catch (SQLException e) {
			
			e.printStackTrace();
			
		}finally{
			ConnectionManager.getInstance().closeConnection(conn);
			try {
				if(result != null)
					result.close();
				if(stmt != null)
					stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return user;
	}
	
	@Override
	public IUser getAllUsersByEmail(String email){
		conn = ConnectionManager.getInstance().openConnection();
		IUser user = null;
		
		sql = "SELECT * " +
				"FROM users " +
				"WHERE email=?;";
		
		try {
			
			stmt = conn.prepareStatement(sql);
			
			stmt.setString(1, email);
			
			result = stmt.executeQuery();
			
			while(result.next()){
				user = new User(result.getString("login"),result.getString("password"),result.getString("email"),result.getDate("registryDate"),
						result.getString("name"), result.getString("surnames"));
			}
			
			result.close();
			stmt.close();
			
		} catch (SQLException e) {
			
			e.printStackTrace();
			
		}finally{
			ConnectionManager.getInstance().closeConnection(conn);
			try {
				if(result != null)
					result.close();
				if(stmt != null)
					stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return user;
	}
	@Override
	public List<IUser> getAllUsersByRegistryDate(Date registryDate){
		conn = ConnectionManager.getInstance().openConnection();
		List<IUser> resultList = new ArrayList<IUser>();
		IUser user;
		
		sql = "SELECT * " +
				"FROM users " +
				"WHERE registryDate=?;";
		
		try {
			
			stmt = conn.prepareStatement(sql);
			
			stmt.setDate(1, registryDate);
			
			result = stmt.executeQuery();
			
			while(result.next()){
				user = new User(result.getString("login"),result.getString("password"),result.getString("email"),result.getDate("registryDate"),
						result.getString("name"), result.getString("surnames"));
				resultList.add(user);
			}
			
		} catch (SQLException e) {
			
			e.printStackTrace();
			
		}finally{
			ConnectionManager.getInstance().closeConnection(conn);
			try {
				if(result != null)
					result.close();
				if(stmt != null)
					stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return resultList;
	}
	
	@Override
	public void insertUsers(IUser user){
		conn = ConnectionManager.getInstance().openConnection();
		
		sql = "INSERT INTO users (name,surnames,login,password,email,registryDate,USOID) " +
				"VALUES (?,?,?,?,?,?,?);";
		
		UIDGenerator uidGenerator = UIDGenerator.getInstance();
		String userOID = uidGenerator.getKey();
		
		try {
			
			stmt = conn.prepareStatement(sql);
			
			stmt.setString(1, user.getName());
			stmt.setString(2, user.getSurname());
			stmt.setString(3, user.getLogin());
			stmt.setString(4, user.getPassword());
			stmt.setString(5, user.getEmail());
			stmt.setDate(6, user.getRegistryDate());
			stmt.setString(7, userOID);
			
			stmt.executeUpdate();
			
			
		} catch (SQLException e) {
			
			e.printStackTrace();
			
		}finally{
			ConnectionManager.getInstance().closeConnection(conn);
			try {
				if(result != null)
					result.close();
				if(stmt != null)
					stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
	}
	
	@Override
	public void updateUsers(IUser user){
		conn = ConnectionManager.getInstance().openConnection();
		
		sql = "UPDATE users " +
				"SET password=?,email=?,name=?,surnames=? " +
				"WHERE login=?;";
		
		try {
			
			stmt = conn.prepareStatement(sql);
			
			stmt.setString(1, user.getPassword());
			stmt.setString(2, user.getEmail());
			stmt.setString(3, user.getName());
			stmt.setString(4, user.getSurname());
			stmt.setString(5, getUserOIDByLogin(user.getLogin()));
			
			stmt.executeUpdate();
			
			stmt.close();
			
			
		} catch (SQLException e) {
			
			e.printStackTrace();
			
		}finally{
			ConnectionManager.getInstance().closeConnection(conn);
			try {
				if(result != null)
					result.close();
				if(stmt != null)
					stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	@Override
	public void deleteUsers(IUser user){
		conn = ConnectionManager.getInstance().openConnection();
		
		sql = "DELETE FROM users " +
				"WHERE login=?;";
		
		try {
			
			stmt = conn.prepareStatement(sql);
			
			stmt.setString(1, user.getLogin());
			
			stmt.executeUpdate();
			
			stmt.close();
			
			
		} catch (SQLException e) {
			
			e.printStackTrace();
			
		}finally{
			ConnectionManager.getInstance().closeConnection(conn);
			try {
				if(result != null)
					result.close();
				if(stmt != null)
					stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
				
	}
	
	
//	/*
//	 * Métodos privados auxiliares para la clase
//	 */	
//	private List<Integer> getFollowers(Integer userOID){
//		conn = ConnectionManager.getInstance().openConnection();
//		List<Integer> resultList = new ArrayList<Integer>();
//		
//		sql = "SELECT * " +
//				"FROM followers " +
//				"WHERE FK_FOLLOWEDOID=?;";
//		
//		try {
//			
//			stmt = conn.prepareStatement(sql);
//			
//			stmt.setInt(1, userOID);
//			
//			result = stmt.executeQuery(); 
//			
//			while(result.next()){
//				resultList.add(result.getInt("FK_FOLLOWERSOID"));
//			}
//			
//		} catch (SQLException e) {
//			
//			e.printStackTrace();
//			
//		}finally{
//			ConnectionManager.getInstance().closeConnection(conn);
//			try {
//				if(result != null)
//					result.close();
//				if(stmt != null)
//					stmt.close();
//			} catch (SQLException e) {
//				e.printStackTrace();
//			}
//		}
//		
//		return resultList;
//	}
//	
//	private List<Integer> getFolloweds(Integer userOID){
//		conn = ConnectionManager.getInstance().openConnection();
//		List<Integer> resultList = new ArrayList<Integer>();
//		
//		sql = "SELECT * " +
//				"FROM followers " +
//				"WHERE FK_FOLLOWERSOID=?;";
//		
//		try {
//			
//			stmt = conn.prepareStatement(sql);
//			
//			stmt.setInt(1, userOID);
//			
//			result = stmt.executeQuery(); 
//			
//			while(result.next()){
//				resultList.add(result.getInt("FK_FOLLOWEDOID"));
//			}
//			
//		} catch (SQLException e) {
//			
//			e.printStackTrace();
//			
//		}finally{
//			ConnectionManager.getInstance().closeConnection(conn);
//			try {
//				if(result != null)
//					result.close();
//				if(stmt != null)
//					stmt.close();
//			} catch (SQLException e) {
//				e.printStackTrace();
//			}
//		}
//		
//		return resultList;
//	}
//	
//	private Map<Product, ProductScore> getProductsScore(String userOID){
//		
//		Map<Product, ProductScore> map= new HashMap<>();
//		
//		List<ProductScore> list = new JDBCProductScoreDAO().getScoresByUser(userOID);
//		Product product = null;
//		
//		for(ProductScore productScore: list){
//			product = new JDBCProductDAO().getProductByPROID(productScore.getProductOID());
//			map.put(product, productScore);
//		}
//				
//		return map;
//	}
//	
//	private Map<Product, List<ProductComment>> getProductsComment(String userOID){
//		
//		Map<Product, List<ProductComment>> map= new HashMap<>();
//		
//		List<ProductComment> list = new JDBCProductCommentDAO().getProductCommentByUSOID(userOID);
//		Product product = null;
//		
//		for(ProductComment productCommet: list){
//			product = new JDBCProductDAO().getProductByPROID(productCommet.getProductOID());
//			if(map.containsKey(product)){
//				map.get(product).add(productCommet);
//			}else{
//				map.put(product, new ArrayList<ProductComment>());
//				map.get(product).add(productCommet);
//			}
//		}
//				
//		return map;
//	}
//	
//	private Map<Establishment, EstablishmentScore> getEstablishmentScore(String userOID) throws SQLException{
//		
//		Map<Establishment, EstablishmentScore> map= new HashMap<>();
//		
//		List<EstablishmentScore> list = new JDBCEstablishmentScoreDAO().getScoresByUser(userOID);
//		Establishment establishment = null;
//		
//		for(EstablishmentScore establishmentScore: list){
//			establishment = new JDBCEstablishmentDAO().getEstablishmentByOID(establishmentScore.getEstablishmentOID());
//			map.put(establishment, establishmentScore);
//		}
//				
//		return map;
//	}
//	
//	private Map<Establishment, List<EstablishmentComment>> getEstablishmentsComment(String userOID) throws SQLException{
//			
//			Map<Establishment, List<EstablishmentComment>> map= new HashMap<>();
//			
//			List<EstablishmentComment> list = new JDBCEstablishmentCommentDAO().getCommentariesByUser(userOID);
//			Establishment establishment = null;
//			
//			for(EstablishmentComment establishmentCommet: list){
//				establishment = new JDBCEstablishmentDAO().getEstablishmentByOID(establishmentCommet.getEstablishmentOID());
//				if(map.containsKey(establishment)){
//					map.get(establishment).add(establishmentCommet);
//				}else{
//					map.put(establishment, new ArrayList<EstablishmentComment>());
//					map.get(establishment).add(establishmentCommet);
//				}
//			}
//					
//		return map;
//	}

}


