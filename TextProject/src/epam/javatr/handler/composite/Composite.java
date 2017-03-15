package epam.javatr.handler.composite;

import java.util.ArrayList;

public class Composite implements IComponent {

	private ArrayList<IComponent> components;

	public Composite(ArrayList<IComponent> component) {
		this.components = component;
	}

	public Composite() {
		this.components = new ArrayList<>();
	}

	public void addComponent(IComponent component) {
		components.add(component);
	}

	public void removeComponent(IComponent component) {
		components.remove(component);
	}

	public String toString() {
		return components.toString();
	}

	public ArrayList<IComponent> getComposite() {
		return components;
	}

}
