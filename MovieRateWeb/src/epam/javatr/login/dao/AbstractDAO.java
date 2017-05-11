package epam.javatr.login.dao;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import epam.javatr.login.entity.Entity;
import epam.javatr.login.pool.ProxyConnection;

public abstract class AbstractDAO<T extends Entity> {
	
	static Logger logger = LogManager.getLogger(AbstractDAO.class);
	protected ProxyConnection connection;

	public AbstractDAO(ProxyConnection connection) {
		this.connection = connection;
	}

	public abstract T findEntityByName(String name);
	public abstract ArrayList<T> getAllEntities();
	
	public void close(Statement st) {
		try {
			if (st != null) {
				st.close();
			}
		} catch (SQLException e) {
			logger.log(Level.ERROR, "Statement was not closed.");
		}
	}
}
