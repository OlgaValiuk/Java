package epam.javatr.login.pool;

import java.sql.Connection;
import java.sql.SQLException;

public interface AbstractFactoryConnection {
	public abstract Connection getConnection() throws SQLException;
}
