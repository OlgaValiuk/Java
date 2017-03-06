package epam.javatr.train.action;

import java.util.ArrayList;
import java.util.Comparator;

import epam.javatr.train.car.Car;

public class TrainSort {

	public void sortTrainByYearId(ArrayList<Car> train){
		train.sort(Comparator.comparing(Car::getYearProduced).thenComparing(Car::getId)); 
	}
}
