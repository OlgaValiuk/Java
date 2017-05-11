package epam.javatr.login.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Statement;
import java.util.ArrayList;
import epam.javatr.login.entity.Movie;
import epam.javatr.login.entity.Recall;
import epam.javatr.login.entity.User;
import epam.javatr.login.pool.ProxyConnection;

public class MovieDAO extends AbstractDAO<Movie>{
	
	static Logger logger = LogManager.getLogger(MovieDAO.class);
	private static final String SQL_SELECT_ALL_MOVIES="SELECT movie_id, movie_name, movie_desc, movie_year, movie_rate FROM movies";
	private static final String SQL_SELECT_RATED_MOVIES="SELECT movie_id, movie_name, movie_desc, movie_year, movie_rate"
														+ " FROM recalls r "
														+ " INNER JOIN movies ON r.recall_movie_id = movie_id"
														+ " WHERE recall_user_id = ?";
	private static final String SQL_SELECT_NOT_RATED_MOVIES="SELECT movie_id, movie_name, movie_desc, movie_year, movie_rate "
															+ "FROM movies LEFT JOIN recalls ON movie_id=recall_movie_id "
															+ "AND recall_user_id =? WHERE recall_movie_id IS NULL";
	private static final String SQL_SELECT_MOVIE_RECALLS="SELECT user_id, user_login, recall_rate, recall_comment"
														+ " FROM recalls INNER JOIN users ON recall_user_id = user_id"
														+ " WHERE recall_movie_id =?";
	
	public MovieDAO(ProxyConnection connection) {
		super(connection);
	}
	
	public ArrayList<Movie> getNotRatedMovies(int userID) {
		ArrayList<Movie> movies = new ArrayList<>();
		try{
			PreparedStatement st = null;
			try{
				System.out.println(connection instanceof ProxyConnection);
				System.out.println(connection.isClosed());
				st = connection.prepareStatement(SQL_SELECT_NOT_RATED_MOVIES);
				ResultSet rs = null;
				try{
					st.setInt(1, userID);
					rs = st.executeQuery();
					while(rs.next()){
						int movieID = rs.getInt(1);
						String movieName = rs.getString(2);
						String movieDesc =  rs.getString(3);
					    int movieYear =  rs.getInt(4);
					    double movieRate =  rs.getDouble(5);
					    movies.add(new Movie(movieID, movieName, movieDesc, movieYear, movieRate));
					}
					if(movies.size()==0){
						logger.log(Level.ERROR, "Movies not found.");
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
			logger.log(Level.ERROR, "DB Connection error: "+e+"123");
		}
		return movies;
	}
	
	public ArrayList<Recall> getMovieRecalls(int movieID) {
		ArrayList<Recall> recalls = new ArrayList<>();
		try{
			PreparedStatement st = null;
			try{
				System.out.println(connection instanceof ProxyConnection);
				System.out.println(connection.isClosed());
				st = connection.prepareStatement(SQL_SELECT_MOVIE_RECALLS);
				ResultSet rs = null;
				try{
					st.setInt(1, movieID);
					rs = st.executeQuery();
					while(rs.next()){
						int userID = rs.getInt(1);
						String userLogin = rs.getString(2);
						double recallRate = rs.getDouble(3);
						String recallComment =  rs.getString(4);
					    recalls.add(new Recall(userID, userLogin, movieID, recallRate, recallComment));
					}
					if(recalls.size()==0){
						logger.log(Level.ERROR, "Movies not found.");
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
			logger.log(Level.ERROR, "DB Connection error: "+e+"456");
		}
		return recalls;
	}
	
	public ArrayList<Movie> getRatedMovies(int userID) {
		ArrayList<Movie> movies = new ArrayList<>();
		try{
			PreparedStatement st = null;
			try{
				st = connection.prepareStatement(SQL_SELECT_RATED_MOVIES);
				ResultSet rs = null;
				try{
					st.setInt(1, userID);
					rs = st.executeQuery();
					while(rs.next()){
						int movieID = rs.getInt(1);
						String movieName = rs.getString(2);
						String movieDesc =  rs.getString(3);
					    int movieYear =  rs.getInt(4);
					    double movieRate =  rs.getDouble(5);
					    ArrayList<Recall> recalls = getMovieRecalls(movieID);
					    System.out.println(recalls);
					    movies.add(new Movie(movieID, movieName, movieDesc, movieYear, movieRate, recalls));
					}
					if(movies.size()==0){
						logger.log(Level.ERROR, "Movies not found.");
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
			logger.log(Level.ERROR, "DB Connection error: "+e+"456");
		}
		return movies;
	}
	
	public ArrayList<Movie> getAllEntities() {
		ArrayList<Movie> movies = new ArrayList<>();
		try{
			Statement st = null;
			//try{
				st = connection.createStatement();
				ResultSet rs = null;
				try{
					rs = st.executeQuery(SQL_SELECT_ALL_MOVIES);
					while(rs.next()){
						int movieID = rs.getInt(1);
						String movieName = rs.getString(2);
						String movieDesc =  rs.getString(3);
					    int movieYear =  rs.getInt(4);
					    double movieRate =  rs.getDouble(5);
					    movies.add(new Movie(movieID, movieName, movieDesc, movieYear, movieRate));
					}
					if(movies.size()==0){
						logger.log(Level.ERROR, "Movies not found.");
					}
				} finally{
					if(rs !=null){
						rs.close();
					} else {
						logger.log(Level.ERROR, "Error reading from Database.");
					}
				}
			/*}
			finally{
				if(st!=null){
					close(st);
				}
				else{
					logger.log(Level.ERROR, "Statement was not created.");
				}
			}*/
		} catch (SQLException e){
			logger.log(Level.ERROR, "DB Connection error: "+e);
		}
		return movies;
	}

	@Override
	public Movie findEntityByName(String name) {
		throw new UnsupportedOperationException();
	} 

}
