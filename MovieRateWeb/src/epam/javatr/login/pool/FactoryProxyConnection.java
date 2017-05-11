package epam.javatr.login.pool;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Connection;

import epam.javatr.login.resource.DatabaseManager;

public class FactoryProxyConnection implements AbstractFactoryConnection{

	final static String URL =  DatabaseManager.getProperty("db.url");
	final static String USER = DatabaseManager.getProperty("db.user");
	final static String PASS = DatabaseManager.getProperty("db.password");
	
	@Override
	public Connection getConnection() throws SQLException {

		Connection connection = null;
		connection = DriverManager.getConnection(URL, USER, PASS);
		return new ProxyConnection(connection);
	}
}
