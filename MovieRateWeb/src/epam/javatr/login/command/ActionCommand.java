package epam.javatr.login.command;
import javax.servlet.http.HttpServletRequest; 

public interface ActionCommand {
	String execute(HttpServletRequest request);
}
