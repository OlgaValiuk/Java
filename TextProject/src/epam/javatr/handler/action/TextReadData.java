package epam.javatr.handler.action;

import java.io.*;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class TextReadData {

	static Logger logger = LogManager.getLogger("TextReadData");

	public String ReadText(String TEXT_FILE) {
		String text = "";
		try (BufferedReader bf = new BufferedReader(new FileReader(TEXT_FILE))) {
			String lines;
			while ((lines = bf.readLine()) != null) {
				text += lines;
			}
		} catch (FileNotFoundException ex) {
			logger.fatal(TEXT_FILE + " the system cannot find the file specified", ex);
			throw new RuntimeException(ex);
		} catch (IOException ex2) {
			logger.log(Level.ERROR, ex2);
		}
		return text;
	}
}
