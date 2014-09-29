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
import domain.EstablishmentScore;
import domain.IEstablishmentScore;
/**
 * 
 * @author Arturo Jimenez
 *
 */
public class JDBCEstablishmentScoreDAO implements IEstablishmentScoreDAO {

	private Connection conn; 
	private String sql;
	private PreparedStatement stmt;
	private ResultSet result;
	
	private IUserDAO userDAO;
	
	@Override
	public List<IEstablishmentScore> getAllScores() {
		List<IEstablishmentScore> searchResults = new ArrayList<>();
		conn = ConnectionManager.getInstance().openConnection();
		
		sql = "SELECT * FROM establishmentscores " +
				"ORDER BY mediumScore;";
		
		try{
			stmt = conn.prepareStatement(sql);
			result = stmt.executeQuery();
			
			IEstablishmentScore score = null;
			
			while(result.next()){
				Integer establishmentID = 
						new JDBCEstablishmentDAO().getEstablishmentByOID(result.getString("FK_ESTOID")).getEstablishmentID();
				String login = new JDBCUserDAO().getUserByOID(result.getString("FK_USOID")).getLogin();
				
				score = new EstablishmentScore(result.getDouble("mediumScore"),
						result.getDouble("qualityScore"),
						result.getDouble("serviceScore"),result.getDouble("cleaningScore"),
						result.getDouble("sizeScore"),result.getDouble("locationScore"),
						result.getDouble("priceScore"),result.getDate("scoreDate"), result.getTime("scoreTime"),
						result.getInt("establishmentScoreID"),	login,
						establishmentID);
				
				searchResults.add(score);
			}
			
			result.close();
			stmt.close();
			
		}catch (SQLException e) {
			e.printStackTrace();
		}finally{
			ConnectionManager.getInstance().closeConnection(conn);
			try{
				if(result!=null){
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
	public List<IEstablishmentScore> getScoresByUser(String userLogin) {
		this.userDAO = new JDBCUserDAO();
		String userOID = this.userDAO.getUserOIDByLogin(userLogin);
		
		List<IEstablishmentScore> searchResults = new ArrayList<>();
		conn = ConnectionManager.getInstance().openConnection();
		
		sql = "SELECT * FROM establishmentscores " +
				"WHERE(FK_USOID=?);";
		
		try{
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, userOID);
			result = stmt.executeQuery();
			
			IEstablishmentScore score = null;
			
			while(result.next()){

				Integer establishmentID = 
						new JDBCEstablishmentDAO().getEstablishmentByOID(result.getString("FK_ESTOID")).getEstablishmentID();
				String login = new JDBCUserDAO().getUserByOID(result.getString("FK_USOID")).getLogin();
				
				score = new EstablishmentScore(result.getDouble("mediumScore"),
						result.getDouble("qualityScore"),
						result.getDouble("serviceScore"),result.getDouble("cleaningScore"),
						result.getDouble("sizeScore"),result.getDouble("locationScore"),
						result.getDouble("priceScore"),result.getDate("scoreDate"), result.getTime("scoreTime"),
						result.getInt("establishmentScoreID"),	login,
						establishmentID);
				
				searchResults.add(score);
			}
			
			result.close();
			stmt.close();
			
		}catch (SQLException e) {
			e.printStackTrace();
		}finally{
			ConnectionManager.getInstance().closeConnection(conn);
			try{
				if(result!=null){
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

	public List<IEstablishmentScore> getScoresByCreationDate(Date scoreCreationDate) {
		List<IEstablishmentScore> searchResults = new ArrayList<>();
		conn = ConnectionManager.getInstance().openConnection();
		
		sql = "SELECT * FROM establishmentscores " +
				"WHERE (scoreDate=?);";
		try{
			stmt = conn.prepareStatement(sql);
			stmt.setDate(1, scoreCreationDate);
			result = stmt.executeQuery();
			
			IEstablishmentScore score = null;
			
			while(result.next()){
				Integer establishmentID = 
						new JDBCEstablishmentDAO().getEstablishmentByOID(result.getString("FK_ESTOID")).getEstablishmentID();
				String login = new JDBCUserDAO().getUserByOID(result.getString("FK_USOID")).getLogin();
				
				score = new EstablishmentScore(result.getDouble("mediumScore"),
						result.getDouble("qualityScore"),
						result.getDouble("serviceScore"),result.getDouble("cleaningScore"),
						result.getDouble("sizeScore"),result.getDouble("locationScore"),
						result.getDouble("priceScore"),result.getDate("scoreDate"), result.getTime("scoreTime"),
						result.getInt("establishmentScoreID"),	login,
						establishmentID);
				
				searchResults.add(score);
			}
			
			result.close();
			stmt.close();
			
		}catch (SQLException e) {
			e.printStackTrace();
		}finally{
			ConnectionManager.getInstance().closeConnection(conn);
			try{
				if(result!=null){
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
	public List<IEstablishmentScore> getScoresByEstablishment(String establishmentOID) {
		List<IEstablishmentScore> searchResults = new ArrayList<>();
		conn = ConnectionManager.getInstance().openConnection();
		
		sql = "SELECT * FROM establishmentscores " +
				"WHERE(FK_ESTOID=?);";
		
		try{
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, establishmentOID);
			result = stmt.executeQuery();
			
			IEstablishmentScore score = null;
			
			while(result.next()){

				Integer establishmentID = 
						new JDBCEstablishmentDAO().getEstablishmentByOID(result.getString("FK_ESTOID")).getEstablishmentID();
				String login = new JDBCUserDAO().getUserByOID(result.getString("FK_USOID")).getLogin();
				
				score = new EstablishmentScore(result.getDouble("mediumScore"),
						result.getDouble("qualityScore"),
						result.getDouble("serviceScore"),result.getDouble("cleaningScore"),
						result.getDouble("sizeScore"),result.getDouble("locationScore"),
						result.getDouble("priceScore"),result.getDate("scoreDate"), result.getTime("scoreTime"),
						result.getInt("establishmentScoreID"),	login,
						establishmentID);
				
				searchResults.add(score);
			}
			
			result.close();
			stmt.close();
			
		}catch (SQLException e) {
			e.printStackTrace();
		}finally{
			ConnectionManager.getInstance().closeConnection(conn);
			try{
				if(result!=null){
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
	public IEstablishmentScore getEstablishmentScoreByOID(String establishmentScoreOID) {
		IEstablishmentScore score = null;
		conn = ConnectionManager.getInstance().openConnection();
		
		sql = "SELECT * FROM establishmentscores WHERE ESCOREOID = ?;";
		
		try{
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, establishmentScoreOID);
			result = stmt.executeQuery();
			
			while(result.next()){
				
				Integer establishmentID = 
						new JDBCEstablishmentDAO().getEstablishmentByOID(result.getString("FK_ESTOID")).getEstablishmentID();
				String login = new JDBCUserDAO().getUserByOID(result.getString("FK_USOID")).getLogin();
				
				score = new EstablishmentScore(result.getDouble("mediumScore"),
						result.getDouble("qualityScore"),
						result.getDouble("serviceScore"),result.getDouble("cleaningScore"),
						result.getDouble("sizeScore"),result.getDouble("locationScore"),
						result.getDouble("priceScore"),result.getDate("scoreDate"), result.getTime("scoreTime"),
						result.getInt("establishmentScoreID"),	login,
						establishmentID);
				
			}
			
			result.close();
			stmt.close();
			
		}catch (SQLException e) {
			e.printStackTrace();
		}finally{
			ConnectionManager.getInstance().closeConnection(conn);
			try{
				if(result!=null){
					result.close();
				}
				if(stmt != null){
					stmt.close();
				}
			}catch (SQLException e) {
			}
		}
		
		return score;
	}
	
	public void insertEstablishmentScore(IEstablishmentScore establishmentScore) {
		
		conn = ConnectionManager.getInstance().openConnection();
		
		IDGenerator idGenerator = new IDGenerator("establishmentScoreID", "establishmentscores");
		Integer establishmentScoreID = idGenerator.nextValue();
		
		UIDGenerator uidGenerator = UIDGenerator.getInstance();
		String ESCOREOID = uidGenerator.getKey();
		
		String sql = "INSERT INTO establishmentscores ( mediumScore, qualityScore," +
				"serviceScore, cleaningScore, sizeScore, locationScore, priceScore, scoreDate, scoreTime" +
				"ESCOREOID, FK_USOID, FK_ESTOID, establishmentScoreID) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?);";
        stmt = null;

        try {
            stmt = conn.prepareStatement(sql);
            
            String userOID = new JDBCUserDAO().getUserOIDByLogin(establishmentScore.getLogin());
            String establishmentOID = new JDBCEstablishmentDAO().getEstablishmentOIDByID(establishmentScore.getEstablishmentID());
            
            stmt.setDouble(1, establishmentScore.getMediumScore());
            stmt.setDouble(2, establishmentScore.getQualityScore());
            stmt.setDouble(3, establishmentScore.getServiceScore());
            stmt.setDouble(4, establishmentScore.getCleaningScore());
            stmt.setDouble(5, establishmentScore.getSizeScore());
            stmt.setDouble(6, establishmentScore.getLocationScore());
            stmt.setDouble(7, establishmentScore.getPriceScore());
            stmt.setDate(8, establishmentScore.getEstablishmentScoreCreationDate());
            stmt.setTime(9, establishmentScore.getEstablishmentScoreTime());
            stmt.setString(10, ESCOREOID);
            stmt.setString(11, userOID);
            stmt.setString(12, establishmentOID);
            stmt.setInt(13, establishmentScoreID);
            
            
            stmt.executeUpdate();

        } catch (SQLException e) {
            System.out.println("Message: " + e.getMessage());
            System.out.println("SQLState: " + e.getSQLState());
            System.out.println("ErrorCode: " + e.getErrorCode());
        } finally {
            ConnectionManager.getInstance().closeConnection(conn);
        	try {
                if (stmt != null) {
                    stmt.close();
                }
            } catch (SQLException e) {
            }
        }
	}

	@Override
	public void updateEstablishmentScore(IEstablishmentScore score) {
		conn = ConnectionManager.getInstance().openConnection();

		sql = "UPDATE establishmentscores SET mediumScore=?,qualityScore=?, serviceScore=?," +
				"cleaningScore=?, sizeScore=?, locationScore=?, priceScore=? " + 
				"WHERE (establishmentScoreID = ?);";
			
			try{
				stmt = conn.prepareStatement(sql);
				
				stmt.setDouble(1, score.getMediumScore());
				stmt.setDouble(2, score.getQualityScore());
				stmt.setDouble(3, score.getServiceScore());
				stmt.setDouble(4, score.getCleaningScore());
				stmt.setDouble(5, score.getSizeScore());
				stmt.setDouble(6, score.getLocationScore());
				stmt.setDouble(7, score.getPriceScore());
				stmt.setInt(8, score.getEstablishmentScoreID());
				
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
	
	public String getEstablishmentScoreOIDByID(Integer establishmentScoreID) {
		String oid = null;
		conn = ConnectionManager.getInstance().openConnection();
		
		sql = "SELECT * FROM establishmentscores WHERE ESCOREOID = ?;";
		
		try{
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, establishmentScoreID);
			result = stmt.executeQuery();
			
			while(result.next()){
				
				oid = result.getString("ESCOREOID");
				
			}
			
			result.close();
			stmt.close();
			
		}catch (SQLException e) {
			e.printStackTrace();
		}finally{
			ConnectionManager.getInstance().closeConnection(conn);
			try{
				if(result!=null){
					result.close();
				}
				if(stmt != null){
					stmt.close();
				}
			}catch (SQLException e) {
			}
		}
		
		return oid;
	}
	
	public IEstablishmentScore getEstablishmentScoreByID(Integer establishmentScoreID){
		IEstablishmentScore score = null;
		conn = ConnectionManager.getInstance().openConnection();
		
		sql = "SELECT * FROM establishmentscores WHERE establishmentScoreID = ?;";
		
		try{
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, establishmentScoreID);
			result = stmt.executeQuery();
			
			while(result.next()){
				
				Integer establishmentID = 
						new JDBCEstablishmentDAO().getEstablishmentByOID(result.getString("FK_ESTOID")).getEstablishmentID();
				String login = new JDBCUserDAO().getUserByOID(result.getString("FK_USOID")).getLogin();
				
				score = new EstablishmentScore(result.getDouble("mediumScore"),
						result.getDouble("qualityScore"),
						result.getDouble("serviceScore"),result.getDouble("cleaningScore"),
						result.getDouble("sizeScore"),result.getDouble("locationScore"),
						result.getDouble("priceScore"),result.getDate("scoreDate"), result.getTime("scoreTime"),
						result.getInt("establishmentScoreID"),	login,
						establishmentID);
				
			}
			
			result.close();
			stmt.close();
			
		}catch (SQLException e) {
			e.printStackTrace();
		}finally{
			ConnectionManager.getInstance().closeConnection(conn);
			try{
				if(result!=null){
					result.close();
				}
				if(stmt != null){
					stmt.close();
				}
			}catch (SQLException e) {
			}
		}
		
		return score;
	}

	@Override
	public List<IEstablishmentScore> getScoresByEstablishmentID(Integer establishmentID) {
		List<IEstablishmentScore> searchResults = new ArrayList<>();
		conn = ConnectionManager.getInstance().openConnection();
		String oid = new JDBCEstablishmentDAO().getEstablishmentOIDByID(establishmentID);
		sql = "SELECT * FROM establishmentscores " +
				"WHERE(FK_ESTOID=?);";
		
		try{
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, oid);
			result = stmt.executeQuery();
			
			IEstablishmentScore score = null;
			
			while(result.next()){

				String login = new JDBCUserDAO().getUserByOID(result.getString("FK_USOID")).getLogin();
				
				score = new EstablishmentScore(result.getDouble("mediumScore"),
						result.getDouble("qualityScore"),
						result.getDouble("serviceScore"),result.getDouble("cleaningScore"),
						result.getDouble("sizeScore"),result.getDouble("locationScore"),
						result.getDouble("priceScore"),result.getDate("scoreDate"), result.getTime("scoreTime"),
						result.getInt("establishmentScoreID"),	login,
						establishmentID);
				
				searchResults.add(score);
			}
			
			result.close();
			stmt.close();
			
		}catch (SQLException e) {
			e.printStackTrace();
		}finally{
			ConnectionManager.getInstance().closeConnection(conn);
			try{
				if(result!=null){
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
	public List<IEstablishmentScore> getScoresByUserLogin(String login) {
		List<IEstablishmentScore> searchResults = new ArrayList<>();
		conn = ConnectionManager.getInstance().openConnection();
		
		String oid = new JDBCUserDAO().getUserOIDByLogin(login);
		
		sql = "SELECT * FROM establishmentscores " +
				"WHERE(FK_USOID=?);";
		
		try{
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, oid);
			result = stmt.executeQuery();
			
			IEstablishmentScore score = null;
			
			while(result.next()){

				Integer establishmentID = 
						new JDBCEstablishmentDAO().getEstablishmentByOID(result.getString("FK_ESTOID")).getEstablishmentID();
				
				
				score = new EstablishmentScore(result.getDouble("mediumScore"),
						result.getDouble("qualityScore"),
						result.getDouble("serviceScore"),result.getDouble("cleaningScore"),
						result.getDouble("sizeScore"),result.getDouble("locationScore"),
						result.getDouble("priceScore"),result.getDate("scoreDate"), result.getTime("scoreTime"),
						result.getInt("establishmentScoreID"),	login,
						establishmentID);
				
				searchResults.add(score);
			}
			
			result.close();
			stmt.close();
			
		}catch (SQLException e) {
			e.printStackTrace();
		}finally{
			ConnectionManager.getInstance().closeConnection(conn);
			try{
				if(result!=null){
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

