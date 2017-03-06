package epam.javatr.train.action;

import epam.javatr.train.car.Car;
import java.util.ArrayList;
import java.util.Calendar;

public class CarValidator {

	public boolean validateCar(ArrayList<Car> train, int id, int year, int possible, int taken){

		int curyear = Calendar.getInstance().get(Calendar.YEAR);
		boolean isIdUnique = true;
		boolean isValid = true;
		for (Car ob : train) {
			isIdUnique = (ob.getId() != id);
		}
		isValid = (curyear >= year && possible >= taken && isIdUnique) ;
		return isValid;
	}
	
}
