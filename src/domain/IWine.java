package domain;

public interface IWine extends IDrink{

	String getType();

	void setType(String type);

	String getOd();

	void setOd(String od);

	Integer getYear();

	void setYear(Integer year);

	String getGrowUpTime();

	void setGrowUpTime(String growUpTime);

	String getLabel();

	void setLabel(String label);

	Integer getWineID();

}