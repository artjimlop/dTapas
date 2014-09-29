package dao;

import java.sql.Date;
import java.util.List;

import domain.IUser;

public interface IUserDAO {
	
	List<IUser> getAllUsers();
	IUser getUserByOID(String OID);
	String getUserOIDByLogin(String login);
	List<IUser> getAllUsersByName(String name);
	List<IUser> getAllUsersBySurname(String surnames);
	IUser getUserByLogin(String login);
	IUser getAllUsersByEmail(String email);
	List<IUser> getAllUsersByRegistryDate(Date registryDate);
	
	void insertUsers(IUser user);
	void updateUsers(IUser user);
	void deleteUsers(IUser user);

}
