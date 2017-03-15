package epam.javatr.handler.action;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import epam.javatr.handler.composite.IComponent;

public class SortLexemes {

	static Logger logger = LogManager.getLogger("SortLexemes");

	public void sortByFirstLetter(IComponent chain) {

		ArrayList<String> lexemes = new ArrayList<>();

		try {
			for (int i = 0; i < chain.getComposite().size(); i++) {
				for (int j = 0; j < chain.getComposite().get(i).getComposite().size(); j++) {
					for (int z = 0; z < chain.getComposite().get(i).getComposite().get(j).getComposite().size(); z++) {
						lexemes.add(chain.getComposite().get(i).getComposite().get(j).getComposite().get(z).toString());
					}
				}
			}

			Comparator<String> compLexeme = new Comparator<String>() {
				public int compare(String one, String two) {
					return Double.compare(one.toUpperCase().charAt(0), two.toUpperCase().charAt(0));
				}
			};
			Collections.sort(lexemes, compLexeme);

			System.out.println("\nSort lexemes by first letter:");

			for (int i = 0; i < lexemes.size(); i++) {
				System.out.print(lexemes.get(i) + " ");
				if (i != lexemes.size() - 1
						&& lexemes.get(i).toUpperCase().charAt(0) != lexemes.get(i + 1).toUpperCase().charAt(0)) {
					System.out.print("\n");
				}
			}
		} catch (UnsupportedOperationException e) {
			logger.log(Level.ERROR, "Wrong text composite structure! " + e);
		}
	}

}
