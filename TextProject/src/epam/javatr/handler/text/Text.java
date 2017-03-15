package epam.javatr.handler.text;

import epam.javatr.handler.action.TextReadData;

public class Text {

	private String text;
	
	public void setText(String TEXT_FILE){
		TextReadData trd = new TextReadData();
		this.text=trd.ReadText(TEXT_FILE);
	
	}
	
	public String getText(){
		return this.text;
	}
}
