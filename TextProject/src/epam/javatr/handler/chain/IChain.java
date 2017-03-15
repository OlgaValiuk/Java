package epam.javatr.handler.chain;

import java.util.ArrayList;
import epam.javatr.handler.composite.IComponent;

public interface IChain {
	public void setNextChain(IChain nextChain);
	public ArrayList<IComponent> parse(String text);
}
