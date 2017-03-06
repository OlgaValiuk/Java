package epam.javatr.train.action;

import java.io.*;
import java.util.ArrayList;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class CarReadData {

	static Logger logger = LogManager.getLogger("ReadData");

	public ArrayList<String> getData(String fileread, String startword, String stopword) {

		ArrayList<String> lines = new ArrayList<String>();

		try (BufferedReader br = new BufferedReader(new FileReader(fileread))) {
			String line;

			while ((line = br.readLine()) != null) {
				if (line.contains(startword)) {
					break;
				}
			}

			while ((line = br.readLine()) != null) {
				if (!line.contains("*")) {
					lines.add(line);
				}
				if (line == stopword) {
					break;
				}

			}

		}

		catch (FileNotFoundException ex) {
			
			logger.fatal(fileread + " the system cannot find the file specified", ex);
			throw new RuntimeException(ex);
			
		} catch (IOException ex2) {

			logger.log(Level.ERROR, ex2);

		}
		return lines;
	}
}
