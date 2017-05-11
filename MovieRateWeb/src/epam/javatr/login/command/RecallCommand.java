package epam.javatr.login.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import epam.javatr.login.entity.User;
import epam.javatr.login.logic.LoginLogic;
import epam.javatr.login.logic.RecallLogic;
import epam.javatr.login.resource.ConfigurationManager;

public class RecallCommand implements ActionCommand{
	static Logger logger = LogManager.getLogger(RecallCommand.class);
	private static final String PARAM_NAME_USER = "userID";
	private static final String PARAM_NAME_MOVIE_ID = "movieID";
	private static final String PARAM_NAME_USER_RATE = "rate";
	private static final String PARAM_NAME_COMMENT = "comment";
	
	@Override
	public String execute(HttpServletRequest request) {
		String page = null;
		HttpSession currentSession = request.getSession();
		int userID = (int) currentSession.getAttribute(PARAM_NAME_USER);
		int movieID = Integer.parseInt(request.getParameter(PARAM_NAME_MOVIE_ID));
		double rate = 0;
		try{
			rate = Double.parseDouble(request.getParameter(PARAM_NAME_USER_RATE));
		} catch(NumberFormatException e)  
		  { 
			logger.log(Level.ERROR, "Rate is not a number: " +e);
		}
		String comment = request.getParameter(PARAM_NAME_COMMENT);
		RecallLogic.addRecall(userID, movieID, rate, comment);
		currentSession.setAttribute("moviesNotRated", LoginLogic.getNotRatedMovieContent(userID));
		currentSession.setAttribute("moviesRated", LoginLogic.getRatedMovieContent(userID));
		currentSession.setAttribute("userRate", RecallLogic.getUserRate(userID));
		page = ConfigurationManager.getProperty("path.page.main");
		return page;
	}

}
