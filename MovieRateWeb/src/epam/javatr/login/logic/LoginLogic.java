package epam.javatr.login.logic;

import java.util.ArrayList;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import epam.javatr.login.dao.MovieDAO;
import epam.javatr.login.dao.UserDAO;
import epam.javatr.login.entity.Movie;
import epam.javatr.login.entity.User;
import epam.javatr.login.pool.ConnectionPool;
import epam.javatr.login.pool.ProxyConnection;

public class LoginLogic {
	static Logger logger = LogManager.getLogger(LoginLogic.class);
	
	public static User checkLogin(String enterLogin, String enterPass) {
		boolean result=false;
		ConnectionPool<ProxyConnection> cp=ConnectionPool.getInstance();
		ProxyConnection cn=cp.getConnection();
		UserDAO userDAO = new UserDAO(cn);
		User userDB = userDAO.findEntityByName(enterLogin);
		String userLogin = userDB.getUserLogin();
		String userPass = userDB.getUserPass();
		if(userDB!=null){
			result = (userLogin.toUpperCase().equals(enterLogin.toUpperCase()) && userPass.equals(enterPass));
		}
        cp.closeConnection(cn);
		return (result == true ? userDB : null);
	}
	
	public static ArrayList<Movie> getNotRatedMovieContent(int userID){
		ConnectionPool<ProxyConnection> cp=ConnectionPool.getInstance();
		ProxyConnection cn=cp.getConnection();
		MovieDAO movieDAO = new MovieDAO(cn);
		ArrayList<Movie> moviesNotRated = movieDAO.getNotRatedMovies(userID);
        cp.closeConnection(cn);
		return moviesNotRated;
	}
	
	public static ArrayList<Movie> getRatedMovieContent(int userID){
		ConnectionPool<ProxyConnection> cp=ConnectionPool.getInstance();
		ProxyConnection cn=cp.getConnection();
		MovieDAO movieDAO = new MovieDAO(cn);
		ArrayList<Movie> moviesRated = movieDAO.getRatedMovies(userID);
		cp.closeConnection(cn);
		return moviesRated;
	}
}
