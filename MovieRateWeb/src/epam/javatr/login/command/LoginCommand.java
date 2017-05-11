package epam.javatr.login.command;

import epam.javatr.login.resource.ConfigurationManager;
import epam.javatr.login.resource.MessageManager;
import epam.javatr.login.entity.User;
import epam.javatr.login.logic.LoginLogic;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class LoginCommand implements ActionCommand {
	private static final String PARAM_NAME_LOGIN = "login";
	private static final String PARAM_NAME_PASSWORD = "password";

	@Override
	public String execute(HttpServletRequest request) {
		String page = null;
		String login = request.getParameter(PARAM_NAME_LOGIN);
		String pass = request.getParameter(PARAM_NAME_PASSWORD);
		int userID = 0;
		User user =LoginLogic.checkLogin(login, pass);
		if (user != null && user.getUserIsActive().equals("Y")) {
			HttpSession currentSession = request.getSession();
			currentSession.setAttribute("userLogin", user.getUserLogin());
			currentSession.setAttribute("userID", user.getUserID());
			currentSession.setAttribute("userRate", user.getUserRate());
			currentSession.setAttribute("userType", user.getUserType());
			currentSession.setAttribute("moviesNotRated", LoginLogic.getNotRatedMovieContent(userID));
			currentSession.setAttribute("moviesRated", LoginLogic.getRatedMovieContent(userID));
			if(user.getUserType().equals("ADMIN")){
			page = ConfigurationManager.getProperty("path.page.admin");
			}
			else{
			page = ConfigurationManager.getProperty("path.page.main");
			}
		} else {
			page = ConfigurationManager.getProperty("path.page.login");
			if(user==null){
				request.setAttribute("errorLoginPassMessage", MessageManager.getProperty("message.loginerror"));
			}
			else{
				request.setAttribute("errorLoginPassMessage", MessageManager.getProperty("message.notactive"));
			}
		}
		return page;
	}
}
