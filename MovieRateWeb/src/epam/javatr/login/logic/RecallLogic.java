package epam.javatr.login.logic;

import java.sql.SQLException;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import epam.javatr.login.dao.RecallDAO;
import epam.javatr.login.dao.UserDAO;
import epam.javatr.login.pool.ConnectionPool;
import epam.javatr.login.pool.ProxyConnection;

public class RecallLogic {
	static Logger logger = LogManager.getLogger(LoginLogic.class);

	public static void addRecall(int userID, int movieID, double rate, String comment) {
		ConnectionPool<ProxyConnection> cp = ConnectionPool.getInstance();
		ProxyConnection cn = cp.getConnection();
		RecallDAO recallDAO = new RecallDAO(cn);
		recallDAO.createRecall(userID, movieID, rate, comment);
		recallDAO.setMovieRate(userID);
		recallDAO.setUserRate(movieID);
		cp.closeConnection(cn);

	}
	
	public static double getUserRate(int userID) {
		ConnectionPool<ProxyConnection> cp = ConnectionPool.getInstance();
		ProxyConnection cn = cp.getConnection();
		UserDAO userDAO = new UserDAO(cn);
		double userRate = userDAO.getUserRate(userID);
		cp.closeConnection(cn);
		return userRate;
	}
}
