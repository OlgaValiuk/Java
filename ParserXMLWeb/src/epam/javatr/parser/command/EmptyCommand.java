package epam.javatr.parser.command;

import javax.servlet.http.HttpServletRequest;
import epam.javatr.parser.resource.ConfigurationManager;

public class EmptyCommand implements ActionCommand {
	@Override
	public String execute(HttpServletRequest request) {
		String page = ConfigurationManager.getProperty("path.page.login");
		return page;
	}
}
