package dao;

import java.util.List;

import domain.IUser;

public interface IFollowerDAO {
	
	//List<User> getAllFollower()
	//lista de usuarios que yo sigo
	List<IUser> getMyFollowed(String userlogin);
	//lista de usuario q me sigen
	List<IUser> getMyFollowers(String userlogin);
	String getFollowerByOID(String followerOID);
	IUser getFollowerBylogin(String userlogin);
	String getFollowerOIDbylogin(String userlogin);
	//User getFollowerByOID(String followerOID);
	void insetFollower(String loginFollowed, String loginFollowers);
	void deleteFollower(String userCurrent, String userSuggest);
		
}
