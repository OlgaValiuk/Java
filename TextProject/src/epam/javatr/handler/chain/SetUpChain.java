package epam.javatr.handler.chain;

public class SetUpChain {

	private IChain text;

	public SetUpChain() {
		this.text = new ParseToParagraph();
		IChain paragraph = new ParseToSentence();
		IChain sentence = new ParseToLexeme();

		text.setNextChain(paragraph);
		paragraph.setNextChain(sentence);
}
	public IChain getText(){
		return text;
	}
}