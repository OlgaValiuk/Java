package epam.javatr.handler.chain;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import epam.javatr.handler.composite.IComponent;
import epam.javatr.handler.composite.Leaf;

public class ParseToLexeme implements IChain {

	private IChain chain;
	final String PATTERN = "(\\w*[\\,|\\’|\\-|\\–]*)+[$\\s\\.|\\s\\!|\\s\\?]";

	public void setNextChain(IChain nextChain) {
		this.chain = nextChain;
	}

	public ArrayList<IComponent> parse(String str) {
		ArrayList<IComponent> sentence = new ArrayList<>();
		Pattern p = Pattern.compile(PATTERN);
		Matcher m = p.matcher(str);
		while (m.find()) {
			sentence.add(new Leaf(m.group().trim()));
		}
		return sentence;
	}

}
