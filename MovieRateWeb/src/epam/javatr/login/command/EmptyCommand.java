package epam.javatr.login.command;

import javax.servlet.http.HttpServletRequest;
import epam.javatr.login.resource.ConfigurationManager;

public class EmptyCommand implements ActionCommand {
	@Override
	public String execute(HttpServletRequest request) {
		String page = ConfigurationManager.getProperty("path.page.login");
		return page;
	}
}
