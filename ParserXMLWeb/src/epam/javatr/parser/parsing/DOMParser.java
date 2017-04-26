package epam.javatr.parser.parsing;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;


import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import epam.javatr.parser.flower.Flower;
import epam.javatr.parser.flower.Flower.Growing;
import epam.javatr.parser.flower.Flower.Visual;

public class DOMParser extends FlowersBuilder{
	private DocumentBuilder docBuilder;

	public DOMParser() {
		this.flowers = new HashSet<Flower>();
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		try {
			docBuilder = factory.newDocumentBuilder();
		} catch (ParserConfigurationException e) {
			System.err.println("Error config parsing: " + e);
		}
	}

	public Set<Flower> getFlowers() {
		return flowers;
	}

	public void buildSetFlowers(String fileName) {
		Document doc = null;
		try {
			doc = docBuilder.parse(fileName);
			Element root = doc.getDocumentElement();
			NodeList flowersList = root.getElementsByTagName("flower");
			for (int i = 0; i < flowersList.getLength(); i++) {
				Element flowerElement = (Element) flowersList.item(i);
				Flower flower = buildGreenhouse(flowerElement);
				flowers.add(flower);
			}
		} catch (IOException e) {
			System.err.println("File error or I/O error: " + e);
		} catch (SAXException e) {
			System.err.println("Parsing failure: " + e);
		}
	}

	private Flower buildGreenhouse(Element flowerElement) {
		Flower flower = new Flower();
		flower.setItem(flowerElement.getAttribute("item"));
		flower.setSoil(flowerElement.getAttribute("soil"));
		flower.setMultiplying(flowerElement.getAttribute("multiplying"));
		flower.setName(getElementTextContent(flowerElement, "name"));
		flower.setOrigin(getElementTextContent(flowerElement, "origin"));
		Flower.Visual visual=flower.getVisual();
		Element visualElement = (Element) flowerElement.getElementsByTagName("visual").item(0);
		visual.setStalkColour(getElementTextContent(visualElement, "stalkColour"));
		visual.setLeafColour(getElementTextContent(visualElement, "leafColour"));
		Double size = Double.parseDouble(getElementTextContent(flowerElement, "avgSizeMeters"));
		visual.setAvgSizeMeters(size);
		Flower.Growing growing=flower.getGrowing();
		Element growingElement = (Element) flowerElement.getElementsByTagName("growing").item(0);
		Double temperature = Double.parseDouble(getElementTextContent(flowerElement, "temperature"));
		growing.setTemperature(temperature);
		Integer water = Integer.parseInt(getElementTextContent( flowerElement,"waterMLWeek"));
		growing.setWaterMLWeek(water); 
		growing.setLighting(getElementTextContent(growingElement, "lighting"));
		return flower;
	}

	private static String getElementTextContent(Element element, String elementName) {
		NodeList nList = element.getElementsByTagName(elementName);
		Node node = (Node) nList.item(0);
		String text = node.getTextContent();
		return text;
	}
}
