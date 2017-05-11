package epam.javatr.login.logic;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import epam.javatr.login.dao.UserDAO;
import epam.javatr.login.entity.User;
import epam.javatr.login.pool.ConnectionPool;
import epam.javatr.login.pool.ProxyConnection;
import epam.javatr.login.resource.ConfigurationManager;

public class RegisterLogic {
	static Logger logger = LogManager.getLogger(RegisterLogic.class);
	
	public static void registerLogin(String enterLogin, String enterEmail, String enterPass) {
		ConnectionPool<ProxyConnection> cp=ConnectionPool.getInstance();
		ProxyConnection cn=cp.getConnection();
		UserDAO userDAO = new UserDAO(cn);
		User userDB = userDAO.findEntityByName(enterLogin);
		if(userDB==null){
			userDAO.createUser(enterLogin, enterEmail, enterPass);
		}
		cp.closeConnection(cn);
	}
}
