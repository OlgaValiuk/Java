package epam.javatr.handler.validation;

import org.junit.*;
import static org.junit.Assert.*;

import epam.javatr.handler.action.GenerateParsedText;
import epam.javatr.handler.action.SortLexemes;
import epam.javatr.handler.action.SortSentences;
import epam.javatr.handler.action.SwapLexemes;
import epam.javatr.handler.chain.SetUpChain;
import epam.javatr.handler.composite.Composite;
import epam.javatr.handler.composite.Leaf;
import epam.javatr.handler.text.Text;

public class TextValidator {

	private static String TEXT_FILE;
	private static Text txt;
	private static SetUpChain sChain;
	private static Composite chain;
	private static GenerateParsedText gpt;
	private static String newText;
	private static SortSentences sortSentences;
	private static SwapLexemes swapLexemes;
	private static SortLexemes sortLexemes;

	@BeforeClass
	public static void prepareActions() {
		TEXT_FILE = "./data/Text.txt";
		txt = new Text();
		txt.setText(TEXT_FILE);

		sChain = new SetUpChain();
		chain = new Composite(sChain.getText().parse(txt.getText()));
		System.out.println("Initial text: ");
		System.out.println(chain);

		/*Leaf l = new Leaf("NEW LEAF");
		Leaf l2 = new Leaf("IS AWESOME");
		Composite sentence1 = new Composite();
		sentence1.addComponent(l);
		sentence1.addComponent(l2);
		Composite paragraph1 = new Composite();
		paragraph1.addComponent(sentence1);
		chain.addComponent(paragraph1);
		chain.addComponent(sentence1);
		chain.addComponent(l);
		System.out.println(chain);*/

		gpt = new GenerateParsedText();
		newText = gpt.generateParsedText(chain);
		System.out.println("Generated text: ");
		System.out.println(newText);

		sortSentences = new SortSentences();
		sortSentences.sortByLexemes(chain);
		
		swapLexemes = new SwapLexemes();
		swapLexemes.swapFirstLastLexeme(chain);

		sortLexemes = new SortLexemes();
		sortLexemes.sortByFirstLetter(chain);
	}

	@Test
	public void compareTextLength() {
		boolean e = (newText.length() == txt.getText().length());
		assertTrue("Initial text length and generated text length aren't equal:", e);
	}
}
