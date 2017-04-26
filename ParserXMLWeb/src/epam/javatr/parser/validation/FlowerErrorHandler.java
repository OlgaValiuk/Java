package epam.javatr.parser.validation;
import java.io.IOException;
import org.xml.sax.SAXParseException;
import org.xml.sax.helpers.DefaultHandler;
import org.apache.logging.log4j.*;
import org.apache.logging.log4j.core.appender.FileAppender;
import org.apache.logging.log4j.core.layout.PatternLayout;
import org.apache.logging.log4j.core.Layout.*;

public class FlowerErrorHandler extends DefaultHandler {
	static Logger logger = LogManager.getLogger("Train");
	public FlowerErrorHandler(String log) throws IOException {
		///FileAppender appender = new FileAppender(new PatternLayout("[%p] %d %c %M - %m%n"),log);
		//logger.addAppender(new FileAppender(new PatternLayout(), log));
		} 
	public void warning(SAXParseException e) {
		logger.warn(getLineAddress(e) + "-" + e.getMessage()); 
		} 
	public void error(SAXParseException e) {
		logger.error(getLineAddress(e) + " - " + e.getMessage()); 
		} 
	public void fatalError(SAXParseException e) {
		logger.fatal(getLineAddress(e) + " - " + e.getMessage()); 
		} 
	private String getLineAddress(SAXParseException e) {
		return e.getLineNumber() + " : " + e.getColumnNumber(); } 
	}

