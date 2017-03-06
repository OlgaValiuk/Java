package epam.javatr.train.action;

import java.util.ArrayList;
import java.util.stream.Collectors;

import epam.javatr.train.car.Car;

public class TrainFilterCar {

	public ArrayList<Car> filterByYearProducedFromTo(ArrayList<Car> train, int yearFrom, int yearTo) {
		ArrayList<Car> newtrain = (ArrayList<Car>) train.stream().filter(p -> p.getYearProduced() >= yearFrom)
				.filter(p -> p.getYearProduced() <= yearTo).collect(Collectors.toList());
		return newtrain;
	}
}
