package epam.javatr.parser.parsing;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;

import epam.javatr.parser.flower.Flower;
import epam.javatr.parser.flower.FlowerEnum;
import epam.javatr.parser.flower.Flower.Growing;
import epam.javatr.parser.flower.Flower.Visual;

public class StAXParser extends FlowersBuilder{
	
	private XMLInputFactory inputFactory;

	public StAXParser() {
		inputFactory = XMLInputFactory.newInstance();
	}

	public Set<Flower> getFlowers() {
		return flowers;
	}

	public void buildSetFlowers(String fileName) {
		FileInputStream inputStream = null;
		XMLStreamReader reader = null;
		String name;
		try {
			inputStream = new FileInputStream(new File(fileName));
			reader = inputFactory.createXMLStreamReader(inputStream);
			while (reader.hasNext()) {
				int type = reader.next();
				if (type == XMLStreamConstants.START_ELEMENT) {
					name = reader.getLocalName();
					if (FlowerEnum.valueOf(name.toUpperCase()) == FlowerEnum.FLOWER) {
						Flower st = buildFlower(reader);
						flowers.add(st);
					}
				}
			}
		} catch (XMLStreamException ex) {
			System.err.println("StAX parsing error! " + ex.getMessage());
		} catch (FileNotFoundException ex) {
			System.err.println("File " + fileName + " not found! " + ex);
		} finally {
			try {
				if (inputStream != null) {
					inputStream.close();
				}
			} catch (IOException e) {
				System.err.println("Impossible close file " + fileName + " : " + e);
			}
		}
	}

	private Flower buildFlower(XMLStreamReader reader) throws XMLStreamException {
		Flower st = new Flower();
		st.setItem(reader.getAttributeValue(null, FlowerEnum.ITEM.getValue()));
		st.setSoil(reader.getAttributeValue(null, FlowerEnum.SOIL.getValue()));
		st.setMultiplying(reader.getAttributeValue(null, FlowerEnum.MULTIPLYING.getValue()));
		String name;
		while (reader.hasNext()) {
			int type = reader.next();
			switch (type) {
			case XMLStreamConstants.START_ELEMENT:
				name = reader.getLocalName();
				switch (FlowerEnum.valueOf(name.toUpperCase())) {
				case NAME:
					st.setName(getXMLText(reader));
					break;
				case ORIGIN:
					st.setOrigin(getXMLText(reader));
					break;
				case VISUAL:
					st.setVisual(getXMLVisual(reader));
					break;
				case GROWING:
					st.setGrowing(getXMLGrowing(reader));
					break;
				}
				break;
			case XMLStreamConstants.END_ELEMENT:
				name = reader.getLocalName();
				if (FlowerEnum.valueOf(name.toUpperCase()) == FlowerEnum.FLOWER) {
					return st;
				}
				break;
			}
		}
		throw new XMLStreamException("Unknown element in tag Flower");
	}

	private Flower.Visual getXMLVisual(XMLStreamReader reader) throws XMLStreamException {
		Flower.Visual visual = new Flower.Visual();
		int type;
		String name;
		while (reader.hasNext()) {
			type = reader.next();
			switch (type) {
			case XMLStreamConstants.START_ELEMENT:
				name = reader.getLocalName();
				switch (FlowerEnum.valueOf(name.toUpperCase())) {
				case STALKCOLOUR:
					visual.setStalkColour(getXMLText(reader));
					break;
				case LEAFCOLOUR:
					visual.setLeafColour(getXMLText(reader));
					break;
				case AVGSIZEMETERS:
					visual.setAvgSizeMeters(Double.parseDouble(getXMLText(reader)));
					break;
				}
				break;
			case XMLStreamConstants.END_ELEMENT:
				name = reader.getLocalName();
				if (FlowerEnum.valueOf(name.toUpperCase()) == FlowerEnum.VISUAL) {
					return visual;
				}
				break;
			}
		}
		throw new XMLStreamException("Unknown element in tag Visual");
	}

	private Flower.Growing getXMLGrowing(XMLStreamReader reader) throws XMLStreamException {
		Flower.Growing growing = new Flower.Growing();
		int type;
		String name;
		while (reader.hasNext()) {
			type = reader.next();
			switch (type) {
			case XMLStreamConstants.START_ELEMENT:
				name = reader.getLocalName();
				switch (FlowerEnum.valueOf(name.toUpperCase())) {
				case TEMPERATURE:
					growing.setTemperature(Double.parseDouble(getXMLText(reader)));
					break;
				case WATERMLWEEK:
					growing.setWaterMLWeek(Integer.parseInt(getXMLText(reader)));
					break;
				case LIGHTING:
					growing.setLighting(getXMLText(reader));
					break;
				}
				break;
			case XMLStreamConstants.END_ELEMENT:
				name = reader.getLocalName();
				if (FlowerEnum.valueOf(name.toUpperCase()) == FlowerEnum.GROWING) {
					return growing;
				}
				break;
			}
		}
		throw new XMLStreamException("Unknown element in tag Growing");
	}
	
	private String getXMLText(XMLStreamReader reader) throws XMLStreamException {
		String text = null;
		if (reader.hasNext()) {
			reader.next();
			text = reader.getText();
		}
		return text;
	}

}
