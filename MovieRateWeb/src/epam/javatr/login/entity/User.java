package epam.javatr.login.entity;

public class User extends Entity{

	private String userLogin;
	private String userPass;
	private int userID;
	private double userRate;
	private String userIsActive;
	private String userType;
	
	public User(int userID, String userLogin, String userPass, double userRate, String userIsActive, String userType){
		this.userID = userID;
		this.userLogin = userLogin;
		this.userPass = userPass;
		this.userRate = userRate;
		this.userIsActive = userIsActive;
		this.userType = userType;
	}
	
	public double getUserRate() {
		return userRate;
	}

	public String getUserIsActive() {
		return userIsActive;
	}

	public String getUserType() {
		return userType;
	}

	public int getUserID() {
		return userID;
	}
	
	public String getUserLogin() {
		return userLogin;
	}

	public String getUserPass() {
		return userPass;
	}
}
