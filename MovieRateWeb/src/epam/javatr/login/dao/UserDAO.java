package epam.javatr.login.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import epam.javatr.login.entity.User;
import epam.javatr.login.pool.ProxyConnection;

public class UserDAO extends AbstractDAO<User> {

	static Logger logger = LogManager.getLogger(UserDAO.class);
	private static final String SQL_SELECT_PASSWORD = "SELECT user_id, user_login, user_password, user_rate, user_is_active,user_type"
													+ " FROM users WHERE user_login=?";
	private static final String SQL_INSERT_USER = "INSERT INTO users(user_login,user_email,user_type,user_password,"
			   									+ "user_rate,user_is_active) VALUES(?,?,'USER',?,0,'Y');";
	private static final String SQL_SELECT_USER_RATE = "SELECT user_rate FROM users WHERE user_id=?";

	public UserDAO(ProxyConnection connection) {
		super(connection);
	}

	public void createUser(String login, String email, String pass) {
		try {
			PreparedStatement st = null;
			try {
				st = connection.prepareStatement(SQL_INSERT_USER);
				st.setString(1, login);
				st.setString(2, email);
				st.setString(3, pass);
				st.executeUpdate();
			} finally {
				if (st != null) {
					close(st);
				} else {
					logger.log(Level.ERROR, "Statement was not created.");
				}
			}
		} catch (SQLException e) {
			logger.log(Level.ERROR, "DB Connection error: " + e);
		}
	}

	@Override
	public User findEntityByName(String name) {
		int userID = 0;
		String userLogin = null;
		String userPass = null;
		double userRate = 0;
		String userIsActive = null;
		String userType = null;
		try {
			PreparedStatement st = null;
			try {
				st = connection.prepareStatement(SQL_SELECT_PASSWORD);
				ResultSet rs = null;
				try {
					st.setString(1, name);
					rs = st.executeQuery();
					while (rs.next()) {
						userID = rs.getInt(1);
						userLogin = rs.getString(2).toUpperCase();
						userPass = rs.getString(3);
						userRate = rs.getDouble(4);
						userIsActive = rs.getString(5);
						userType = rs.getString(6);
					}
				} finally {
					if (rs != null) {
						rs.close();
					} else {
						logger.log(Level.ERROR, "Error reading from Database.");
					}
				}
			} finally {
				if (st != null) {
					close(st);
				} else {
					logger.log(Level.ERROR, "Statement was not created.");
				}
			}
		} catch (SQLException e) {
			logger.log(Level.ERROR, "DB Connection error: " + e);
		}
		return (userLogin == null ? null : (new User(userID, userLogin, userPass, userRate, userIsActive, userType)));
	}
	
	public double getUserRate(double userID) {
		int userRate=0;
		try{
		PreparedStatement st = null;
			try{
				st = connection.prepareStatement(SQL_SELECT_USER_RATE);
				ResultSet rs = null;
				try{
					st.setDouble(1, userID);
					rs = st.executeQuery();
					while(rs.next()){
						userRate=rs.getInt(1);
					}
				} finally{
					if(rs !=null){
						rs.close();
					} else {
						logger.log(Level.ERROR, "Error reading from Database.");
					}
				}
			}
			finally{
				if(st!=null){
					close(st);
				}
				else{
					logger.log(Level.ERROR, "Statement was not created.");
				}
			}
		} catch (SQLException e){
			logger.log(Level.ERROR, "DB Connection error: "+e);
		}
		return userRate;
	}
	
	@Override
	public ArrayList<User> getAllEntities() {
		throw new UnsupportedOperationException();
	}
}
