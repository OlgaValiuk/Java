package epam.javatr.handler.action;

import epam.javatr.handler.composite.IComponent;
import epam.javatr.handler.composite.Leaf;

public class GenerateParsedText {

	private String generatedText = "";

	public String generateParsedText(IComponent str) {
		for (IComponent c : str.getComposite()) {
			while (!(c instanceof Leaf)) {
				generateParsedText(c);
				break;
			}
			while (c instanceof Leaf) {
				generatedText += " " + c;
				break;
			}

		}
		return generatedText;
	}
}
