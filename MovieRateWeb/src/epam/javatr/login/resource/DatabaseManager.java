package epam.javatr.login.resource;

import java.util.ResourceBundle;

public class DatabaseManager {
	private final static ResourceBundle resourceBundle = ResourceBundle.getBundle("resources.database");

	private DatabaseManager() {
	}

	public static String getProperty(String key) {
		return resourceBundle.getString(key);
	}
}
