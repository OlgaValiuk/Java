package epam.javatr.handler.chain;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import epam.javatr.handler.composite.IComponent;
import epam.javatr.handler.composite.Composite;

public class ParseToSentence implements IChain {

	private IChain chain;
	final String PATTERN = "(\\w*\\s*[\\,\\’\\-\\–]*)+[$\\.|\\!|\\?]";

	public void setNextChain(IChain nextChain) {
		this.chain = nextChain;
	}

	public ArrayList<IComponent> parse(String str) {
		ArrayList<IComponent> paragraph = new ArrayList<>();
		Pattern p = Pattern.compile(PATTERN);
		Matcher m = p.matcher(str);
		while (m.find()) {
			paragraph.add(new Composite(this.chain.parse(m.group().trim())));
		}
		return paragraph;
	}
}
