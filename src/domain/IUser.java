package domain;

import java.sql.Date;

public interface IUser {

	String getLogin();

	void setLogin(String login);

	String getPassword();

	void setPassword(String password);

	String getEmail();

	void setEmail(String email);

	String getName();

	void setName(String name);

	String getSurname();

	void setSurname(String surname);

	Date getRegistryDate();

	int hashCode();

	boolean equals(Object obj);

}