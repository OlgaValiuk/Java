package epam.javatr.handler.chain;

import java.util.ArrayList;
import java.util.regex.*;

import epam.javatr.handler.composite.IComponent;
import epam.javatr.handler.composite.Composite;

public class ParseToParagraph implements IChain {

	private IChain chain;
	final String PATTERN = "[^\t]+";

	public void setNextChain(IChain nextChain) {
		this.chain = nextChain;
	}

	public ArrayList<IComponent> parse(String txt) {
		ArrayList<IComponent> text = new ArrayList<>();
		Pattern p = Pattern.compile(PATTERN);
		Matcher m = p.matcher(txt);
		while (m.find()) {
			text.add(new Composite(this.chain.parse(m.group().trim())));
		}
		return text;
	}

}
