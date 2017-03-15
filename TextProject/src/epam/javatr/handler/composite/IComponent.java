package epam.javatr.handler.composite;

import java.util.ArrayList;

public interface IComponent {
	void addComponent(IComponent arrayList);

	void removeComponent(IComponent component);

	ArrayList<IComponent> getComposite();
}
