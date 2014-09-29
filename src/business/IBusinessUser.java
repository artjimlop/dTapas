package business;

import java.sql.Date;
import java.util.List;

import domain.IUser;

public interface IBusinessUser {

	 List<IUser> getAllUsers();

	 List<IUser> getAllUsersByName(String name);

	 List<IUser> getAllUsersBySurname(String surnames);

	 IUser getUserByLogin(String login);

	 IUser getAllUsersByEmail(String email);

	 List<IUser> getAllUsersByRegistryDate(Date registryDate);

	 void insertUser(IUser user);

	 void updateUser(IUser user);

	 void deleteUser(IUser user);

}