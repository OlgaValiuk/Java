package epam.javatr.login.command;

import javax.servlet.http.HttpServletRequest;

import epam.javatr.login.logic.LoginLogic;
import epam.javatr.login.logic.RegisterLogic;
import epam.javatr.login.resource.ConfigurationManager;
import epam.javatr.login.resource.MessageManager;

public class RegisterCommand implements ActionCommand{
	private static final String PARAM_NAME_LOGIN = "login";
	private static final String PARAM_NAME_PASSWORD = "password";
	private static final String PARAM_NAME_EMAIL = "email";

	@Override
	public String execute(HttpServletRequest request) {
		String page = null;
		String login = request.getParameter(PARAM_NAME_LOGIN);
		String pass = request.getParameter(PARAM_NAME_PASSWORD);
		String email = request.getParameter(PARAM_NAME_EMAIL);
		RegisterLogic.registerLogin(login, email, pass);
		request.setAttribute("user", login);
		page = ConfigurationManager.getProperty("path.page.register");
		/*if (LoginLogic.checkLogin(login, pass)) {
			request.setAttribute("user", login);
			page = ConfigurationManager.getProperty("path.page.main");
		} else {
			request.setAttribute("errorLoginPassMessage", MessageManager.getProperty("message.loginerror"));
			page = ConfigurationManager.getProperty("path.page.login");
		}*/
		return page;
	}
}
