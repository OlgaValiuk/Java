package epam.javatr.login.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import epam.javatr.login.entity.Recall;
import epam.javatr.login.pool.ProxyConnection;

public class RecallDAO extends AbstractDAO<Recall>{
	static Logger logger = LogManager.getLogger(RecallDAO.class);
	private static final String SQL_INSERT_RECALL = "INSERT INTO recalls(recall_user_id, recall_movie_id,"
			+ " recall_rate, recall_comment) VALUES(?,?,?,?)";
	private static final String SQL_CALL_SET_MOVIE_RATE = "CALL setMovieRate(?)";
	private static final String SQL_CALL_SET_USER_RATE = "CALL setUserRate(?)";
	
	public RecallDAO(ProxyConnection connection) {
		super(connection);
	}

	public void createRecall(int userID, int movieID, double rate, String comment) {
		try {
			PreparedStatement st = null;
			try {
				st = connection.prepareStatement(SQL_INSERT_RECALL);
				st.setInt(1, userID);
				st.setInt(2, movieID);
				st.setDouble(3,rate);
				st.setString(4, comment);
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
			System.out.println("error not inserted");
		}
	}
	
	public void setMovieRate(int userID) {
		try{
		PreparedStatement st = null;
			try{
				st = connection.prepareStatement(SQL_CALL_SET_MOVIE_RATE);
				ResultSet rs = null;
				try{
					st.setInt(1, userID);
					rs = st.executeQuery();
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
	}
	
	public void setUserRate(int movieID) {
		try{
		PreparedStatement st = null;
			try{
				st = connection.prepareStatement(SQL_CALL_SET_USER_RATE);
				ResultSet rs = null;
				try{
					st.setInt(1, movieID);
					rs = st.executeQuery();
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
	}
	
	@Override
	public Recall findEntityByName(String name) {
		throw new UnsupportedOperationException();
	}

	@Override
	public ArrayList<Recall> getAllEntities() {
		throw new UnsupportedOperationException();
	}
}
