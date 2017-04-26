package epam.javatr.parser.parsing;

import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.helpers.XMLReaderFactory;

import epam.javatr.parser.flower.Flower;
import epam.javatr.parser.flower.FlowerEnum;

import java.io.IOException;
import java.util.EnumSet;
import java.util.HashSet;
import java.util.Set;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;

public class SAXParser extends FlowersBuilder{
	private FlowerHandler sh;
	private XMLReader reader;

	public SAXParser() {
		sh = new FlowerHandler();
		try {
			reader = XMLReaderFactory.createXMLReader();
			reader.setContentHandler(sh);
		} catch (SAXException e) {
			System.err.print("SAX parser error: " + e);
		}
	}

	public Set<Flower> getFlowers() {
		return flowers;
	}

	public void buildSetFlowers(String fileName) {
		try {
			reader.parse(fileName);
		} catch (SAXException e) {
			System.err.print("SAX parser error: " + e);
		} catch (IOException e) {
			System.err.print("I/O flow error: " + e);
		}
		flowers = sh.getFlowers();
	}


	public class FlowerHandler extends DefaultHandler {
		private Set<Flower> flowers;
		private Flower current = null;
		private FlowerEnum currentEnum = null;
		private EnumSet<FlowerEnum> withText;

		public FlowerHandler() {
			flowers = new HashSet<Flower>();
			withText = EnumSet.range(FlowerEnum.NAME, FlowerEnum.LIGHTING);
		}

		public Set<Flower> getFlowers() {
			return flowers;
		}

		public void startElement(String uri, String localName, String qName, Attributes attrs) {
			if ("flower".equals(localName)) {
				current = new Flower();
				current.setItem(attrs.getValue(0));
				current.setMultiplying(attrs.getValue(2));
				if (attrs.getLength() == 3) {
					current.setSoil(attrs.getValue(1));
				}
			} else {
				FlowerEnum temp = FlowerEnum.valueOf(localName.toUpperCase());
				if (withText.contains(temp)) {
					currentEnum = temp;
				}
			}
		}

		public void endElement(String uri, String localName, String qName) {
			if ("flower".equals(localName)) {
				flowers.add(current);
			}
		}

		public void characters(char[] ch, int start, int length) {
			String s = new String(ch, start, length).trim();
			if (currentEnum != null) {
				switch (currentEnum) {
				case NAME:
					current.setName(s);
					break;
				case ORIGIN:
					current.setOrigin(s);
					break;
				case STALKCOLOUR:
					current.getVisual().setStalkColour(s);
					break;
				case LEAFCOLOUR:
					current.getVisual().setLeafColour(s);
					break;
				case AVGSIZEMETERS:
					current.getVisual().setAvgSizeMeters(Double.parseDouble(s));
					break;
				case TEMPERATURE:
					current.getGrowing().setTemperature(Double.parseDouble(s));
					break;
				case WATERMLWEEK:
					current.getGrowing().setWaterMLWeek(Integer.parseInt(s));
					break;
				case LIGHTING:
					current.getGrowing().setLighting(s);
					break;
				default:
					throw new EnumConstantNotPresentException(currentEnum.getDeclaringClass(), currentEnum.name());
				}
			}
			currentEnum = null;
		}
	}

}
