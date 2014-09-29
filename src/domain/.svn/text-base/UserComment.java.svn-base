package domain;

import java.sql.Date;
import java.sql.Time;

public class UserComment extends Comment implements IUserComment  {
	private Integer userCommentID;
	private String loginOver;
	
	//Para selects
	public UserComment(Integer commentID, String loginOver, String loginWriter,
			Date commentDate,Time commentTime, String comment,Integer userCommentID) {
		super(comment,commentDate, commentTime, loginWriter, commentID);
		this.loginOver = loginOver;
		this.userCommentID = userCommentID;
	}
	
	//Para insertar (business)
	public UserComment(String loginOver, String loginWriter, String comment) {
		super(comment,loginWriter);
		this.loginOver = loginOver;
	}
	
	/* (non-Javadoc)
	 * @see domain.IUserComment#getLoginOverWriter()
	 */
	@Override
	public String getLoginOverWriter() {
		return loginOver;
	}

	/* (non-Javadoc)
	 * @see domain.IUserComment#getUserCommentID()
	 */
	public Integer getUserCommentID() {
		return userCommentID;
	}

	/* (non-Javadoc)
	 * @see domain.IUserComment#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((userCommentID == null) ? 0 : userCommentID.hashCode());
		return result;
	}

	/* (non-Javadoc)
	 * @see domain.IUserComment#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UserComment other = (UserComment) obj;
		if (userCommentID == null) {
			if (other.userCommentID != null)
				return false;
		} else if (!userCommentID.equals(other.userCommentID))
			return false;
		return true;
	}

	
	
	

}
