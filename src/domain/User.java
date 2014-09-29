package domain;

import java.sql.Date;
import java.util.Calendar;

public class User implements IUser  {
	
	private String login;
	private String password;
	private String email;
	private Date registryDate;
	private String name;
	private String surname;
//	private String userOID;
//	private List<Integer> followers;
//	private List<Integer> followeds;
//	private Map<Product, ProductScore> productsScore;
//	private Map<Product, List<ProductComment>> productsComment;
//	private Map<Establishment, EstablishmentScore> establishmentScore;
//	private Map<Establishment, List<EstablishmentComment>> establishmentComment;
	
	
	public User() {
		this.login = "";
		this.password = "";
		this.email = "";
		this.registryDate = new java.sql.Date(Calendar.getInstance().getTimeInMillis());
		this.name = "";
		this.surname = "";
//		this.userOID = "";
//		this.followers = new ArrayList<Integer>();
//		this.followeds = new ArrayList<Integer>();
//		this.productsScore = new HashMap<Product, ProductScore>();
//		this.productsComment = new HashMap<Product, List<ProductComment>>();
//		this.establishmentScore = new HashMap<Establishment, EstablishmentScore>();
//		this.establishmentComment = new HashMap<Establishment, List<EstablishmentComment>>();

	}	
	
//	public User(String login, String password, String email, Date registryDate, String name,
//			String surname, List<Integer> followers, List<Integer> followeds, Map<Product, ProductScore> productsScore,
//			Map<Product, List<ProductComment>> productsComment, Map<Establishment, EstablishmentScore> establishmentScore,
//			Map<Establishment, List<EstablishmentComment>> establishmentComment,
//			String userOID) {
	public User(String login, String password, String email, Date registryDate, String name, String surname) {
		this.login = login;
		this.password = password;
		this.email = email;
		this.registryDate = registryDate;
		this.name = name;
		this.surname = surname;
//		this.userOID = userOID;
//		this.followers = followers;
//		this.followeds = followeds;
//		this.productsScore = productsScore;
//		this.productsComment = productsComment;
//		this.establishmentScore = establishmentScore;
//		this.establishmentComment = establishmentComment;
	}

	public User(String login, String password, String email, String name, String surname) {
		
//		UIDGenerator uidGenerator = UIDGenerator.getInstance();
//		String userOID = uidGenerator.getKey();
		
		this.login = login;
		this.password = password;
		this.email = email;
		this.registryDate = new java.sql.Date(Calendar.getInstance().getTimeInMillis());
		this.name = name;
		this.surname = surname;
//		this.userOID = userOID;
//		this.followers = followers;
//		this.followeds = followeds;
//		this.productsScore = productsScore;
//		this.productsComment = productsComment;
//		this.establishmentScore = establishmentScore;
//		this.establishmentComment = establishmentComment;
	}

	
	/* (non-Javadoc)
	 * @see domain.IUser#getLogin()
	 */
	@Override
	public String getLogin() {
		return login;
	}


	
	/* (non-Javadoc)
	 * @see domain.IUser#setLogin(java.lang.String)
	 */
	@Override
	public void setLogin(String login) {
		this.login = login;
	}


	
	/* (non-Javadoc)
	 * @see domain.IUser#getPassword()
	 */
	@Override
	public String getPassword() {
		return password;
	}


	
	/* (non-Javadoc)
	 * @see domain.IUser#setPassword(java.lang.String)
	 */
	@Override
	public void setPassword(String password) {
		this.password = password;
	}


	
	/* (non-Javadoc)
	 * @see domain.IUser#getEmail()
	 */
	@Override
	public String getEmail() {
		return email;
	}


	
	/* (non-Javadoc)
	 * @see domain.IUser#setEmail(java.lang.String)
	 */
	@Override
	public void setEmail(String email) {
		this.email = email;
	}


	
	/* (non-Javadoc)
	 * @see domain.IUser#getName()
	 */
	@Override
	public String getName() {
		return name;
	}


	
	/* (non-Javadoc)
	 * @see domain.IUser#setName(java.lang.String)
	 */
	@Override
	public void setName(String name) {
		this.name = name;
	}


	
	/* (non-Javadoc)
	 * @see domain.IUser#getSurname()
	 */
	@Override
	public String getSurname() {
		return surname;
	}


	
	/* (non-Javadoc)
	 * @see domain.IUser#setSurname(java.lang.String)
	 */
	@Override
	public void setSurname(String surname) {
		this.surname = surname;
	}


	
	/* (non-Javadoc)
	 * @see domain.IUser#getRegistryDate()
	 */
	@Override
	public Date getRegistryDate() {
		return registryDate;
	}

	/* (non-Javadoc)
	 * @see domain.IUser#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((login == null) ? 0 : login.hashCode());
		return result;
	}

	/* (non-Javadoc)
	 * @see domain.IUser#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (login == null) {
			if (other.login != null)
				return false;
		} else if (!login.equals(other.login))
			return false;
		return true;
	}

//	@Override
//	public String getUserOID() {
//		return userOID;
//	}
//
//
	
//	@Override
//	public List<Integer> getFollowers() {
//		return followers;
//	}
//
//
//	
//	@Override
//	public List<Integer> getFolloweds() {
//		return followeds;
//	}
//
//
//	
//	@Override
//	public Map<Product, ProductScore> getProductsScore() {
//		return productsScore;
//	}
//
//
//	
//	@Override
//	public Map<Product, List<ProductComment>> getProductsComment() {
//		return productsComment;
//	}
//
//
//	
//	@Override
//	public Map<Establishment, EstablishmentScore> getEstablishmentScore() {
//		return establishmentScore;
//	}
//
//
//	
//	@Override
//	public Map<Establishment, List<EstablishmentComment>> getEstablishmentComment() {
//		return establishmentComment;
//	}
//
//
//	
//	@Override
//	public String getUserOID() {
//		return userOID;
//	}
	
	
	

}

