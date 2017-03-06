package epam.javatr.train.getlist;

import java.util.ArrayList;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import epam.javatr.train.action.CarValidator;
import epam.javatr.train.action.CreateCarList;
import epam.javatr.train.car.BaggageCar;
import epam.javatr.train.car.Car;
import epam.javatr.train.car.PassengerCar;

public class Train {

	static Logger logger = LogManager.getLogger("Train");

	private ArrayList<Car> train = new ArrayList<Car>();

	public void setCar(ArrayList<String> strread, String type) {
		CreateCarList carList = new CreateCarList();
		if (type == "Passenger Cars"){
			train.addAll(carList.createPassengerCar(strread));
		} else {
			train.addAll(carList.createBaggageCar(strread));
		}
	}

	public void setCar(int id, int yearProduced, int crewNumber, String style, int seatPossible, int seatTaken) {
		try {
			CarValidator test = new CarValidator();
			boolean isValid = test.validateCar(train, id, yearProduced, seatPossible, seatTaken);
			if (isValid) {
				train.add(new PassengerCar(id, yearProduced, crewNumber, style, seatPossible, seatTaken));
			}
		} catch (IllegalArgumentException ex) {
			logger.log(Level.ERROR, "Invalid passenger car style: "+style);
		}

	}

	public void setCar(int id, int yearProduced, int crewNumber, int bagPossible, int bagTaken) {
		CarValidator test = new CarValidator();
		boolean isValid = test.validateCar(train, id, yearProduced, bagPossible, bagTaken);
		if (isValid) {
			train.add(new BaggageCar(id, yearProduced, crewNumber, bagPossible, bagTaken));
		}
	}

	public ArrayList<Car> getTrain() {
		return train;
	}

	public void removeCar(int id) {
		for (Car t : train) {
			if (t.getId() == id) {
				train.remove(t);
				break;
			}
		}
	}

}
