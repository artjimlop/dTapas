package domain;

import java.sql.Date;

public interface ITapaRoute {

	String getName();

	void setName(String name);

	Date getTargetDate();

	void setTargetDate(Date targetDate);

	Date getRegistryDate();

	String getUserLogin();

	Integer getTapaRouteID();

}