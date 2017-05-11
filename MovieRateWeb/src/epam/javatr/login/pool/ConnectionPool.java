package epam.javatr.login.pool;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.atomic.AtomicBoolean;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.concurrent.locks.ReentrantLock;

public class ConnectionPool<T extends Connection> {

	static Logger logger = LogManager.getLogger(ConnectionPool.class);
	private static ConnectionPool instance = null;
	private static ReentrantLock lock = new ReentrantLock();
	private ArrayBlockingQueue<T> connectionQueue;
	private final int POOL_SIZE =10;
	private static AtomicBoolean index = new AtomicBoolean(false);
	
	private ConnectionPool() {
		try {
			DriverManager.registerDriver(new com.mysql.jdbc.Driver());
			connectionQueue = new ArrayBlockingQueue<T>(POOL_SIZE);
			for (int i = 0; i < POOL_SIZE; i++) {
				FactoryProxyConnection conn = new FactoryProxyConnection();
				T proxy = (T) conn.getConnection();
				connectionQueue.offer((T) proxy);
			}
		} catch (SQLException e) {
			logger.log(Level.ERROR, "DB Connection error: " + e);
		}

	}
	
	public static ConnectionPool getInstance() {
		if(!index.get()){
		lock.lock();
		try {
			if (instance == null) {
				instance = new ConnectionPool();
				index.getAndSet(true);
			}
		} finally {
			lock.unlock();
		}
		}
		return instance;
	}

	public T getConnection(){
		T connection = null;
		try {
			connection = (T) connectionQueue.take();
		} catch (InterruptedException e) {
			logger.log(Level.ERROR, "Can not get connection: " + e);
		}
		return connection;
	}

	public void releaseConnections() {
		for (int i = 0; i < connectionQueue.size(); i++) {
			T connection;
			try {
				connection = (T) connectionQueue.take();
				connection.close();
			} catch (InterruptedException e) {
				logger.log(Level.ERROR, "DB Connection error: " + e);
			} catch (SQLException e) {
				logger.log(Level.ERROR, "Connection close error: " + e);
			}
		}
	}

	public void closeConnection(T connection) {
		connectionQueue.offer(connection);
	}
}