package business;

import java.util.List;
import java.util.Set;

import domain.IUser;

public interface IBusinessFollower {

	 List<IUser> getMyFollowed(String userLogin);

	 List<IUser> getMyFollowers(String userLogin);

	 void insertFollower(String loginFollowed,
			String loginFollowers);

	 void deleteFollower(String userCurrent, String userSuggest);

	 Set<IUser> suggestTapeador(String userLogin);

}