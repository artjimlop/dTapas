package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import utils.IDGenerator;
import utils.UIDGenerator;

import manager.ConnectionManager;
import domain.Establishment;
import domain.IEstablishment;
import domain.IUser;


public class JDBCEstablishmentDAO implements IEstablishmentDAO{
	
	private Connection conn; 
	private String sql;
	private PreparedStatement stmt;
	private ResultSet result;
	
	private IUserDAO userDAO;


	@Override
	public List<IEstablishment> getAllEstablishments(){
		
		List<IEstablishment> searchResults = new ArrayList<>();
		conn = ConnectionManager.getInstance().openConnection();
		
		sql = "SELECT * FROM establishments " +
				"ORDER BY establishmentID;";
		
		try{
			stmt = conn.prepareStatement(sql);
			result = stmt.executeQuery();
			
			this.userDAO = new JDBCUserDAO();
			
			IUser user = null;
			IEstablishment establishment = null;					
		
			while(result.next()){
				
				user = userDAO.getUserByOID(result.getString("FK_USOID"));
				
				establishment = new Establishment(result.getString("nameEstablishment"),
						result.getString("city"), result.getString("province"),
						result.getString("zone"), result.getString("street"),
						result.getInt("zipcode"),result.getDate("registryDate"),
						user.getLogin(), result.getInt("establishmentID"));
				
				searchResults.add(establishment);
			}
			
			result.close();
			stmt.close();
			
		}catch (SQLException e) {
			
			e.printStackTrace();
			
		}finally{
			ConnectionManager.getInstance().closeConnection(conn);
			try{
			if(result != null)
				result.close();
			if(stmt != null)
				stmt.close();
			}catch (SQLException e) {
			}
		}
		
		return searchResults;
	}
	
	@Override
	public List<IEstablishment> getEstablishmentByEstablishmtName(
			String establishmentName) {


		List<IEstablishment> searchResults = new ArrayList<>();
		conn = ConnectionManager.getInstance().openConnection();
		
		sql = "SELECT * FROM establishments WHERE(nameEstablishment=?);";
		
		try{
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, establishmentName);
			result = stmt.executeQuery();
			
			this.userDAO = new JDBCUserDAO();
			
			IUser user = null;
			IEstablishment establishment = null;					
		
			while(result.next()){
				
				user = userDAO.getUserByOID(result.getString("FK_USOID"));
				
				establishment = new Establishment(result.getString("nameEstablishment"),
						result.getString("city"), result.getString("province"),
						result.getString("zone"), result.getString("street"),
						result.getInt("zipcode"),result.getDate("registryDate"),
						user.getLogin(), result.getInt("establishmentID"));
				
				searchResults.add(establishment);
			}
			
			result.close();
			stmt.close();
			
		}catch (SQLException e) {
			
			e.printStackTrace();
			
		}finally{
			ConnectionManager.getInstance().closeConnection(conn);
			try{
			if(result != null)
				result.close();
			if(stmt != null)
				stmt.close();
			}catch (SQLException e) {
			}
		}
		
		return searchResults;
	}


	@Override
	public List<IEstablishment> getEstablishmentByCity(String city) {
		
		List<IEstablishment> searchResults = new ArrayList<>();
		conn = ConnectionManager.getInstance().openConnection();
		
		sql = "SELECT * FROM establishments WHERE(city=?);";
		
		try{
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, city);
			
			result = stmt.executeQuery();
			
			this.userDAO = new  JDBCUserDAO();
			
			IUser user = null;
			IEstablishment establishment = null;					
		
			while(result.next()){
				
				user = userDAO.getUserByOID(result.getString("FK_USOID"));
				
				establishment = new Establishment(result.getString("nameEstablishment"),
						result.getString("city"), result.getString("province"),
						result.getString("zone"), result.getString("street"),
						result.getInt("zipcode"),result.getDate("registryDate"),
						user.getLogin(), result.getInt("establishmentID"));
				
				searchResults.add(establishment);
			}
			
			result.close();
			stmt.close();
			
		}catch (SQLException e) {
			
			e.printStackTrace();
			
		}finally{
			ConnectionManager.getInstance().closeConnection(conn);
			try{
			if(result != null)
				result.close();
			if(stmt != null)
				stmt.close();
			}catch (SQLException e) {
			}
		}
		
		return searchResults;
		
	}


	@Override
	public List<IEstablishment> getEstablishmentByProvince(String province) {
		
		List<IEstablishment> searchResults = new ArrayList<>();
		conn = ConnectionManager.getInstance().openConnection();
		
		sql = "SELECT * FROM establishments WHERE(province=?);";
		
		try{
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, province);
			
			result = stmt.executeQuery();
			
			this.userDAO = new JDBCUserDAO();
			
			IUser user = null;
			IEstablishment establishment = null;					
		
			while(result.next()){
				
				user = userDAO.getUserByOID(result.getString("FK_USOID"));
				
				establishment = new Establishment(result.getString("nameEstablishment"),
						result.getString("city"), result.getString("province"),
						result.getString("zone"), result.getString("street"),
						result.getInt("zipcode"),result.getDate("registryDate"),
						user.getLogin(), result.getInt("establishmentID"));
				
				searchResults.add(establishment);
			}
			
			result.close();
			stmt.close();
			
		}catch (SQLException e) {
			
			e.printStackTrace();
			
		}finally{
			ConnectionManager.getInstance().closeConnection(conn);
			try{
			if(result != null)
				result.close();
			if(stmt != null)
				stmt.close();
			}catch (SQLException e) {
			}
		}
		
		return searchResults;
	}


	@Override
	public List<IEstablishment> getEstablishmentByZone(String zone) {
		
		List<IEstablishment> searchResults = new ArrayList<>();
		conn = ConnectionManager.getInstance().openConnection();
		
		sql = "SELECT * FROM establishments WHERE(zone=?);";
		
		try{
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, zone);
			result = stmt.executeQuery();
			
			this.userDAO = new JDBCUserDAO();
			
			IUser user = null;
			IEstablishment establishment = null;					
		
			while(result.next()){
				
				user = userDAO.getUserByOID(result.getString("FK_USOID"));
				
				establishment = new Establishment(result.getString("nameEstablishment"),
						result.getString("city"), result.getString("province"),
						result.getString("zone"), result.getString("street"),
						result.getInt("zipcode"),result.getDate("registryDate"),
						user.getLogin(), result.getInt("establishmentID"));
				
				searchResults.add(establishment);
			}
			
			result.close();
			stmt.close();
			
		}catch (SQLException e) {
			
			e.printStackTrace();
			
		}finally{
			ConnectionManager.getInstance().closeConnection(conn);
			try{
			if(result != null)
				result.close();
			if(stmt != null)
				stmt.close();
			}catch (SQLException e) {
			}
		}
		
		return searchResults;
	}


	@Override
	public List<IEstablishment> getEstablishmentByStreet(String street) {

		List<IEstablishment> searchResults = new ArrayList<>();
		conn = ConnectionManager.getInstance().openConnection();
		
		sql = "SELECT * FROM establishments WHERE(street=?);";
		
		try{
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, street);
			
			result = stmt.executeQuery();
			
			this.userDAO = new JDBCUserDAO();
			
			IUser user = null;
			IEstablishment establishment = null;					
		
			while(result.next()){
				
				user = userDAO.getUserByOID(result.getString("FK_USOID"));
				
				establishment = new Establishment(result.getString("nameEstablishment"),
						result.getString("city"), result.getString("province"),
						result.getString("zone"), result.getString("street"),
						result.getInt("zipcode"),result.getDate("registryDate"),
						user.getLogin(), result.getInt("establishmentID"));
				
				searchResults.add(establishment);
			}
			
			result.close();
			stmt.close();
			
		}catch (SQLException e) {
			
			e.printStackTrace();
			
		}finally{
			ConnectionManager.getInstance().closeConnection(conn);
			try{
			if(result != null)
				result.close();
			if(stmt != null)
				stmt.close();
			}catch (SQLException e) {
			}
		}
		
		return searchResults;
		
	}


	@Override
	public List<IEstablishment> getEstablishmentByZipCode(Integer zipCode) {
		
		List<IEstablishment> searchResults = new ArrayList<>();
		conn = ConnectionManager.getInstance().openConnection();
		
		sql = "SELECT * FROM establishments WHERE(zipCode=?);";
		
		try{
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, zipCode);
			
			result = stmt.executeQuery();
			
			this.userDAO = new JDBCUserDAO();
			
			IUser user = null;
			IEstablishment establishment = null;					
		
			while(result.next()){
				
				user = userDAO.getUserByOID(result.getString("FK_USOID"));
				
				establishment = new Establishment(result.getString("nameEstablishment"),
						result.getString("city"), result.getString("province"),
						result.getString("zone"), result.getString("street"),
						result.getInt("zipcode"),result.getDate("registryDate"),
						user.getLogin(), result.getInt("establishmentID"));
				
				searchResults.add(establishment);
			}
			
			result.close();
			stmt.close();
			
		}catch (SQLException e) {
			
			e.printStackTrace();
			
		}finally{
			ConnectionManager.getInstance().closeConnection(conn);
			try{
			if(result != null)
				result.close();
			if(stmt != null)
				stmt.close();
			}catch (SQLException e) {
			}
		}
		
		return searchResults;
	}


	@Override
	public List<IEstablishment> getEstablishmentByDate(Date date) {
		
		List<IEstablishment> searchResults = new ArrayList<>();
		conn = ConnectionManager.getInstance().openConnection();
		
		sql = "SELECT * FROM establishments WHERE(registryDate=?);";
		
		try{
			stmt = conn.prepareStatement(sql);
			stmt.setDate(1, date);
			
			result = stmt.executeQuery();
			
			this.userDAO = new JDBCUserDAO();
			
			IUser user = null;
			IEstablishment establishment = null;					
		
			while(result.next()){
				
				user = userDAO.getUserByOID(result.getString("FK_USOID"));
				
				establishment = new Establishment(result.getString("nameEstablishment"),
						result.getString("city"), result.getString("province"),
						result.getString("zone"), result.getString("street"),
						result.getInt("zipcode"),result.getDate("registryDate"),
						user.getLogin(), result.getInt("establishmentID"));
				
				searchResults.add(establishment);
			}
			
			result.close();
			stmt.close();
			
		}catch (SQLException e) {
			
			e.printStackTrace();
			
		}finally{
			ConnectionManager.getInstance().closeConnection(conn);
			try{
			if(result != null)
				result.close();
			if(stmt != null)
				stmt.close();
			}catch (SQLException e) {
			}
		}
		
		return searchResults;
	}


	@Override
	public IEstablishment getEstablishmentByOID(String establishmentOID) {
		
		IEstablishment establishment = null;	
		conn = ConnectionManager.getInstance().openConnection();
		
		sql = "SELECT * FROM establishments WHERE(ESTOID=?);";
		
		try{
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, establishmentOID);
			
			result = stmt.executeQuery();
			
			IUser user = null;
			this.userDAO = new JDBCUserDAO();
		
			if(result.next()){
				
				user = userDAO.getUserByOID(result.getString("FK_USOID"));
				
				establishment = new Establishment(result.getString("nameEstablishment"),
						result.getString("city"), result.getString("province"),
						result.getString("zone"), result.getString("street"),
						result.getInt("zipcode"),result.getDate("registryDate"),
						user.getLogin(), result.getInt("establishmentID"));
				
			}
			
			result.close();
			stmt.close();
			
		}catch (SQLException e) {
			
			e.printStackTrace();
			
		}finally{
			ConnectionManager.getInstance().closeConnection(conn);
			try{
			if(result != null)
				result.close();
			if(stmt != null)
				stmt.close();
			}catch (SQLException e) {
			}
		}
		
		return establishment;
	}


	@Override
	public List<IEstablishment> getEstablihstmentByUserOID(String userOID) {
		
		List<IEstablishment> searchResults = new ArrayList<>();
		conn = ConnectionManager.getInstance().openConnection();
		
		sql = "SELECT * FROM establishments WHERE(FK_USOID=?);";
		
		try{
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, userOID);
			
			result = stmt.executeQuery();
			
			this.userDAO = new JDBCUserDAO();
			
			IUser user = null;
			IEstablishment establishment = null;					
		
			while(result.next()){
				
				user = userDAO.getUserByOID(result.getString("FK_USOID"));
				
				establishment = new Establishment(result.getString("nameEstablishment"),
						result.getString("city"), result.getString("province"),
						result.getString("zone"), result.getString("street"),
						result.getInt("zipcode"),result.getDate("registryDate"),
						user.getLogin(), result.getInt("establishmentID"));
				
				searchResults.add(establishment);
			}
			
			result.close();
			stmt.close();
			
		}catch (SQLException e) {
			
			e.printStackTrace();
			
		}finally{
			ConnectionManager.getInstance().closeConnection(conn);
			try{
			if(result != null)
				result.close();
			if(stmt != null)
				stmt.close();
			}catch (SQLException e) {
			}
		}
		
		return searchResults;
	}
	
	public String getEstablishmentOIDByID(Integer establishmentID){
		
		conn = ConnectionManager.getInstance().openConnection();
		
		String establishmentOID = null;	
		
		sql = "SELECT * FROM establishments WHERE(establishmentID=?);";
		
		try{
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, establishmentID);
			
			result = stmt.executeQuery();
		
			if(result.next()){
				
				establishmentOID = result.getString("ESTOID");
				
			}
			
			result.close();
			stmt.close();
			
		}catch (SQLException e) {
			
			e.printStackTrace();
			
		}finally{
			ConnectionManager.getInstance().closeConnection(conn);
			try{
			if(result != null)
				result.close();
			if(stmt != null)
				stmt.close();
			}catch (SQLException e) {
			}
		}
		
		return establishmentOID;
		
	}
	
	
	@Override
	public void insertEstablishment(IEstablishment establishment){
		
		conn = ConnectionManager.getInstance().openConnection();
		
		this.userDAO = new JDBCUserDAO();
		String userOID = this.userDAO.getUserOIDByLogin(establishment.getUserLogin());
		
		UIDGenerator uidGenerator = UIDGenerator.getInstance();
		String establishmentOID = uidGenerator.getKey();
		
		IDGenerator idGenerator = new IDGenerator("establishmentID", "establishments");
		Integer establishmentID = idGenerator.nextValue();
		
		sql = "INSERT INTO establishments " +
				"(nameEstablishment, city, province, zone, street, zipCode, registryDate,ESTOID,establishmentID, FK_USOID) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
		
		try{
			stmt = conn.prepareStatement(sql);
			
			stmt.setString(1, establishment.getNameEstablishment());
			stmt.setString(2, establishment.getCity());
			stmt.setString(3, establishment.getProvince());
			stmt.setString(4, establishment.getZone());
			if(establishment.getStreet()== null){
				stmt.setString(5, "");
			}else{
			stmt.setString(5, establishment.getStreet());
			}
			if(establishment.getZipCode()==null){
				stmt.setInt(6, 0);
			}else{
			stmt.setInt(6, establishment.getZipCode());
			}
			stmt.setDate(7, establishment.getRegistryDate());
			stmt.setString(8, establishmentOID);
			stmt.setInt(9, establishmentID);
			stmt.setString(10, userOID);
			
			stmt.executeUpdate();
			
		}catch (SQLException e) {
			
			System.out.println("Message: " + e.getMessage());
            System.out.println("SQLState: " + e.getSQLState());
            System.out.println("ErrorCode: " + e.getErrorCode());
            
		}finally{
			ConnectionManager.getInstance().closeConnection(conn);
			try{
			if(stmt != null)
				stmt.close();
			}catch (SQLException e) {
			}
		}
	
	}

	@Override
	public void delete(Integer ESTID) {
		
		String establishmentOID = this.getEstablishmentOIDByID(ESTID);
		conn = ConnectionManager.getInstance().openConnection();
		
		
		sql = "DELETE FROM establishments WHERE ESTOID = ?;";
		
			
			try{
				stmt = conn.prepareStatement(sql);
				stmt.setString(1, establishmentOID);
				
				stmt.executeUpdate();
				
			}catch (SQLException e) {
	            System.out.println("Message: " + e.getMessage());
	            System.out.println("SQLState: " + e.getSQLState());
	            System.out.println("ErrorCode: " + e.getErrorCode());
	        } finally {
	        	ConnectionManager.getInstance().closeConnection(conn);
	        	
	            try {
	                if (stmt != null)
	                    stmt.close();
	            } catch (SQLException e) {
	            	}
	        	}
	       }
	
	
	public void updateEstablishment(IEstablishment establishment) {
		
		String establishmentOID = this.getEstablishmentOIDByID(establishment.getEstablishmentID());
		
		conn = ConnectionManager.getInstance().openConnection();
		
		
		sql = "UPDATE establishments SET nameEstablishment=?, city=?, province=?, zone=?, street=?, zipCode=? WHERE(ESTOID=?);";
		
		
		try{
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, establishment.getNameEstablishment());
			stmt.setString(2, establishment.getCity());
			stmt.setString(3, establishment.getProvince());
			stmt.setString(4, establishment.getZone());
			stmt.setString(5, establishment.getStreet());
			stmt.setInt(6, establishment.getZipCode());
			stmt.setString(7, establishmentOID);
			
			stmt.executeUpdate();
			
		}catch (SQLException e) {
			System.out.println("Message: " + e.getMessage());
            System.out.println("SQLState: " + e.getSQLState());
            System.out.println("ErrorCode: " + e.getErrorCode());
		}finally{
			ConnectionManager.getInstance().closeConnection(conn);
			
			try{
				if(stmt != null){
					stmt.close();
				}
			}catch (SQLException e) {
			}
		}
		
	}

	@Override
	public IEstablishment getEstablishmentByID(Integer establishmentID) {
		String establishmentOID = this.getEstablishmentOIDByID(establishmentID);
		IEstablishment establishment = this.getEstablishmentByOID(establishmentOID);
		return establishment;
	}

	@Override
	public List<IEstablishment> getEstablishmentByUserLoginID(String userLoginID) {
		
		this.userDAO = new JDBCUserDAO();
		String userOID = this.userDAO.getUserOIDByLogin(userLoginID);
		List<IEstablishment> establishments = this.getEstablihstmentByUserOID(userOID);
		
		return establishments;
	}


	

}
