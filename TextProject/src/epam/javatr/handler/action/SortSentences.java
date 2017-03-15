package epam.javatr.handler.action;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import epam.javatr.handler.composite.IComponent;

public class SortSentences {

	static Logger logger = LogManager.getLogger("SortSentences");

	public void sortByLexemes(IComponent chain) {

		ArrayList<IComponent> sentences = new ArrayList<>();
		try {
			for (int i = 0; i < chain.getComposite().size(); i++) {
				for (int j = 0; j < chain.getComposite().get(i).getComposite().size(); j++) {
					sentences.add(chain.getComposite().get(i).getComposite().get(j));
				}
			}

			Comparator<IComponent> compSentence = new Comparator<IComponent>() {
				public int compare(IComponent one, IComponent two) {
					return Double.compare(two.getComposite().size(), one.getComposite().size());
				}
			};

			Collections.sort(sentences, compSentence);

			System.out.println("\nSort sentences by lexeme number: ");
			for (int i = 0; i < sentences.size(); i++) {
				System.out.println(sentences.get(i).getComposite().size() + " " + sentences.get(i));
			}
		} catch (UnsupportedOperationException e) {
			logger.log(Level.ERROR, "Wrong text composite structure! " + e);
		}
	}
}
