package epam.javatr.train.action;

import java.util.ArrayList;

import epam.javatr.train.car.BaggageCar;
import epam.javatr.train.car.Car;
import epam.javatr.train.car.PassengerCar;

public class TrainReport {

	public void printTrain(ArrayList<Car> train){
		System.out.println("Train:");
		for(Car ob : train){
			if (ob instanceof PassengerCar){
				System.out.println("id:" +ob.getId() +
						           " year: "+ob.getYearProduced()+
						           " crew: "+ ob.getCrewNumber()+
						           " seatPossible: "+((PassengerCar) ob).getSeatPossible()+
						           " seatTaken: "+((PassengerCar) ob).getSeatTaken()+
						           " style: "+((PassengerCar) ob).getStyleCar() );
			}
			if (ob instanceof BaggageCar){
				System.out.println("id:" +ob.getId() +
						           " year: "+ob.getYearProduced()+
						           " crew: "+ ob.getCrewNumber()+
						           " bagPossible: "+((BaggageCar) ob).getBagPossible()+
						           " bagTaken: "+((BaggageCar) ob).getBagTaken() );
			}
		}
	}
}
