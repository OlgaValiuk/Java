package epam.javatr.train.action;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import epam.javatr.train.car.BaggageCar;
import epam.javatr.train.car.Car;
import epam.javatr.train.car.PassengerCar;

public class CreateCarList {

	static Logger logger = LogManager.getLogger("CreateCarList");
	final static String PAS_PATTERN = "(\\d+)\\s(\\d+)\\s(\\d+)\\s(\\w+)\\s(\\d+)\\s(\\d+)";
	final static String BAG_PATTERN = "(\\d+)\\s(\\d+)\\s(\\d+)\\s(\\d+)\\s(\\d+)";
	
	public ArrayList<Car> createPassengerCar(ArrayList<String> strread) {

		ArrayList<Car> train = new ArrayList<Car>();
		
		for (int i = 0; i < strread.size(); i++) {
			try {
				Pattern p = Pattern.compile(PAS_PATTERN);
				Matcher m = p.matcher((String) strread.get(i));
				while (m.find()) {
					int id = Integer.valueOf(m.group(1));
					int year = Integer.valueOf(m.group(2));
					int crewNumber = Integer.valueOf(m.group(3));
					String style = String.valueOf(m.group(4));
					int seatPossible = Integer.valueOf(m.group(5));
					int seatTaken = Integer.valueOf(m.group(6));
					CarValidator test = new CarValidator();
					boolean isValid =test.validateCar(train, id, year, seatPossible, seatTaken);
					if(isValid){
						train.add(new PassengerCar(id, year, crewNumber, style, seatPossible, seatTaken));
					} else logger.log(Level.ERROR, "Invalid id/year/seat taken value of a passenger car: "+strread.get(i));
				}
			}
			catch (IllegalArgumentException ex) {
				logger.log(Level.ERROR, "Invalid passenger car style: "+strread.get(i));
			}

		}
		return train;
	}
	
	public ArrayList<Car> createBaggageCar(ArrayList<String> strread) {

		ArrayList<Car> train = new ArrayList<Car>();
		
		for (int i = 0; i < strread.size(); i++) {
			Pattern p = Pattern.compile(BAG_PATTERN);
			Matcher m = p.matcher((String) strread.get(i));
			while (m.find()) {
				int id = Integer.valueOf(m.group(1));
				int year = Integer.valueOf(m.group(2));
				int crewNumber = Integer.valueOf(m.group(3));
				int bagPossible = Integer.valueOf(m.group(4));
				int bagTaken = Integer.valueOf(m.group(5));
				CarValidator test = new CarValidator();
				boolean isValid =test.validateCar(train, id, year, bagPossible, bagTaken);
				if(isValid){
					train.add(new BaggageCar(id, year, crewNumber, bagPossible, bagTaken));
				} else logger.log(Level.ERROR, "Invalid id/year/bag taken value of a baggage car: "+strread.get(i));

			}
		}
		return train;
	}
}
