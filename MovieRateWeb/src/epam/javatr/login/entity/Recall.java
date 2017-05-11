package epam.javatr.login.entity;

public class Recall extends Entity{
	private int userID;
	private String userLogin;
	private int movieID;
	private double rate;
	private String comment;
	
	public Recall(int userID, String userLogin, int movieID, double rate, String comment) {
		super();
		this.userID = userID;
		this.userLogin = userLogin;
		this.movieID = movieID;
		this.rate = rate;
		this.comment = comment;
	}

	public String getUserLogin() {
		return userLogin;
	}
	
	public int getUserID() {
		return userID;
	}

	public int getMovieID() {
		return movieID;
	}

	@Override
	public String toString() {
		return "Recall [userID=" + userID + ", userLogin=" + userLogin + ", movieID=" + movieID + ", rate=" + rate
				+ ", comment=" + comment + "]";
	}

	public double getRate() {
		return rate;
	}

	public String getComment() {
		return comment;
	}
	
}
