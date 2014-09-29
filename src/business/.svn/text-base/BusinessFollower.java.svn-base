package business;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import dao.IFollowerDAO;
import dao.JDBCFollowerDAO;
import domain.IUser;

public class BusinessFollower implements IBusinessFollower {
	
	
	private IFollowerDAO followerDAO;
	

	
	public BusinessFollower() {
		this.followerDAO = new JDBCFollowerDAO();
		
	}

	/* (non-Javadoc)
	 * @see business.IBusinessFollower#getMyFollowed(java.lang.String)
	 */
	@Override
	public List<IUser> getMyFollowed(String userLogin){
		return followerDAO.getMyFollowed(userLogin);
	}
	
	/* (non-Javadoc)
	 * @see business.IBusinessFollower#getMyFollowers(java.lang.String)
	 */
	@Override
	public List<IUser> getMyFollowers(String userLogin){
		return followerDAO.getMyFollowers(userLogin);
	}
	
	/* (non-Javadoc)
	 * @see business.IBusinessFollower#insertFollower(java.lang.String, java.lang.String)
	 */
	@Override
	public void insertFollower(String loginFollowed, String loginFollowers){
		
		followerDAO.insetFollower(loginFollowed, loginFollowers);

	}
	
	
	/* (non-Javadoc)
	 * @see business.IBusinessFollower#deleteFollower(java.lang.String)
	 */
	@Override
	public void deleteFollower(String userCurrent, String userSuggest){
		
		followerDAO.deleteFollower(userCurrent, userSuggest);	

	}
	
	/* (non-Javadoc)
	 * @see business.IBusinessFollower#suggestTapeador(java.lang.String)
	 */
	@Override
	public Set<IUser> suggestTapeador(String userLogin){
		
		List<IUser> users = this.getMyFollowed(userLogin);
		Set<IUser> suggestUser = new HashSet<>();
		
		for(int indexUserOne = 0; indexUserOne<users.size(); indexUserOne++){
			IUser userOne = users.get(indexUserOne);
			List<IUser> usersOne = this.getMyFollowed(userOne.getLogin());
			
			for(int indexUserTwo = indexUserOne+1; indexUserTwo<users.size();indexUserTwo++){
				IUser userTwo = users.get(indexUserTwo);
				List<IUser> usersTwo = this.getMyFollowed(userTwo.getLogin());
				
				List<IUser> equalsUser = new ArrayList<IUser>(usersOne);
				equalsUser.retainAll(usersTwo);
				
				suggestUser.addAll(equalsUser);
				
			}
		}
		
		suggestUser.removeAll(new BusinessFollower().getMyFollowed(userLogin));
		suggestUser.remove(new BusinessUser().getUserByLogin(userLogin));
		return suggestUser;
	}
	
}
