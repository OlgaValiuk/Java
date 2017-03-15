package epam.javatr.handler.composite;

import java.util.ArrayList;

public class Leaf implements IComponent {

	private String lexeme;

	public Leaf(String lexeme) {
		this.lexeme = lexeme;
	}

	public void addComponent(IComponent component) {
		throw new UnsupportedOperationException();
	}

	public void removeComponent(IComponent component) {
		throw new UnsupportedOperationException();
	}

	public String toString() {
		return lexeme;
	}

	public ArrayList<IComponent> getComposite() {
		throw new UnsupportedOperationException();
	}

}
