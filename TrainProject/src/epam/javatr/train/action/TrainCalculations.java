package epam.javatr.train.action;

import java.util.ArrayList;

import epam.javatr.train.car.BaggageCar;
import epam.javatr.train.car.Car;
import epam.javatr.train.car.PassengerCar;

public class TrainCalculations {

	public int countBag(ArrayList<Car> car){
		int sumBag = 0;
		for(Car ob : car){
			if (ob instanceof BaggageCar){
				sumBag += ((BaggageCar) ob).getBagTaken();
			}
		}
		System.out.println("Total bags taken: "+sumBag);
		return sumBag;
	}
	
	public int countPassenger(ArrayList<Car> car){
		int sumPassenger = 0;
		for(Car ob : car){
			if (ob instanceof PassengerCar){
				sumPassenger += ((PassengerCar) ob).getSeatTaken();
			}
		}
		System.out.println("Total passenger seats taken: "+sumPassenger);
		return sumPassenger;
	}
	
	public int countCrewPassenger(ArrayList<Car> car){
		int sumCrewPassenger = 0;
		for(Car ob : car){
			if (ob instanceof PassengerCar){
				sumCrewPassenger += ((PassengerCar) ob).getSeatTaken();
			}
			sumCrewPassenger+=ob.getCrewNumber();
		}
		System.out.println("Total passengers and crew: "+sumCrewPassenger);
		return sumCrewPassenger;
	}
}
