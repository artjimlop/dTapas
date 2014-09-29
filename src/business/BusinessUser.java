package business;

import java.sql.Date;
import java.util.List;
import dao.IUserDAO;
import dao.JDBCUserDAO;
import domain.IUser;

public class BusinessUser implements IBusinessUser {
	
	private IUserDAO userDAO;
	
	
	public BusinessUser(){
		userDAO = new JDBCUserDAO();
	}
	
	/* (non-Javadoc)
	 * @see business.IBusinessUser#getAllUsers()
	 */
	@Override
	public List<IUser> getAllUsers(){
		return userDAO.getAllUsers();
	}
	
	/* (non-Javadoc)
	 * @see business.IBusinessUser#getAllUsersByName(java.lang.String)
	 */
	@Override
	public List<IUser> getAllUsersByName(String name){
		return userDAO.getAllUsersByName(name);
	}
	
	/* (non-Javadoc)
	 * @see business.IBusinessUser#getAllUsersBySurname(java.lang.String)
	 */
	@Override
	public List<IUser> getAllUsersBySurname(String surnames){
		return userDAO.getAllUsersBySurname(surnames);
	}
	
	/* (non-Javadoc)
	 * @see business.IBusinessUser#getUserByLogin(java.lang.String)
	 */
	@Override
	public IUser getUserByLogin(String login){
		return userDAO.getUserByLogin(login);
	}
	
	/* (non-Javadoc)
	 * @see business.IBusinessUser#getAllUsersByEmail(java.lang.String)
	 */
	@Override
	public IUser getAllUsersByEmail(String email){
		return userDAO.getAllUsersByEmail(email);
	}
	
	/* (non-Javadoc)
	 * @see business.IBusinessUser#getAllUsersByRegistryDate(java.sql.Date)
	 */
	@Override
	public List<IUser> getAllUsersByRegistryDate(Date registryDate){
		return userDAO.getAllUsersByRegistryDate(registryDate);
	}
	
	/* (non-Javadoc)
	 * @see business.IBusinessUser#insertUser(domain.IUser)
	 */
	@Override
	public void insertUser(IUser user){
//		UIDGenerator uidGenerator = UIDGenerator.getInstance();
//		String userOID = uidGenerator.getKey();
//		IUser user = new User(login, password, email, name, surnames);
		userDAO.insertUsers(user);
	}
	
	/* (non-Javadoc)
	 * @see business.IBusinessUser#updateUser(domain.IUser)
	 */
	@Override
	public void updateUser(IUser user){
//		IUser user = getUserByOID(userOID);
//		user.setName(user.getName());
//		user.setSurname(user.getSurname());
//		user.setEmail(user.getEmail());
//		user.setLogin(user.getLogin());
//		user.setPassword(user.getLogin());
		userDAO.updateUsers(user);
	}
	
	/* (non-Javadoc)
	 * @see business.IBusinessUser#deleteUser(domain.IUser)
	 */
	@Override
	public void deleteUser(IUser user){
		userDAO.deleteUsers(user);
	}
	
}

