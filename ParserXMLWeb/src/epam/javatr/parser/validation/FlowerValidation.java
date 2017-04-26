package epam.javatr.parser.validation;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.xml.XMLConstants;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import org.xml.sax.SAXException;

import epam.javatr.parser.resource.MessageManager;

public class FlowerValidation {

	public void validateSchema(HttpServletRequest request, String filename, String schemaname) {
		String logname = "logs/log.txt";
		Schema schema = null;
		String language = XMLConstants.W3C_XML_SCHEMA_NS_URI;
		SchemaFactory factory = SchemaFactory.newInstance(language);
		try {
			schema = factory.newSchema(new File(schemaname));
			SAXParserFactory spf = SAXParserFactory.newInstance();
			spf.setSchema(schema);
			SAXParser parser = spf.newSAXParser();
			parser.parse(filename, new FlowerErrorHandler(logname));
			System.out.println(filename + " is valid");
			request.setAttribute("statusXML", MessageManager.getProperty("message.validxml"));
		} catch (ParserConfigurationException e) {
			//System.err.println(filename + " config error: " + e.getMessage());
			request.setAttribute("statusXML", MessageManager.getProperty("message.invalidxml"));
		} catch (SAXException e) {
			//System.out.println(e);
			//System.err.println(filename + " SAX error: " + e.getMessage());
			request.setAttribute("statusXML", MessageManager.getProperty("message.invalidxml"));
		} catch (IOException e) {
			//System.err.println("I/O error: " + e.getMessage());
			request.setAttribute("statusXML", MessageManager.getProperty("message.invalidxml"));
		}
	}

}
