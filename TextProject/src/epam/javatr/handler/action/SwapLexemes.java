package epam.javatr.handler.action;

import java.util.ArrayList;
import java.util.Collections;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import epam.javatr.handler.composite.IComponent;

public class SwapLexemes {

	static Logger logger = LogManager.getLogger("SwapLexemes");

	public void swapFirstLastLexeme(IComponent chain) {
		try {
			for (int i = 0; i < chain.getComposite().size(); i++) {
				for (int j = 0; j < chain.getComposite().get(i).getComposite().size(); j++) {
					Collections.swap(chain.getComposite().get(i).getComposite().get(j).getComposite(), 0,
							chain.getComposite().get(i).getComposite().get(j).getComposite().size() - 1);
				}
			}
			System.out.println("\nSwap first and last lexemes: \n" + chain);
		} catch (UnsupportedOperationException e) {
			logger.log(Level.ERROR, "Wrong text composite structure! " + e);
		}
	}

}
