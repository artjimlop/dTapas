package domain;

public interface IUserComment extends IComment {

	String getLoginOverWriter();

	Integer getUserCommentID();

	int hashCode();

	boolean equals(Object obj);

}