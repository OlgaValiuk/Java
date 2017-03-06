package epam.javatr.train.validation;

import static org.junit.Assert.*;
import java.util.ArrayList;
import org.junit.*;

import epam.javatr.train.action.CarReadData;
import epam.javatr.train.action.TrainCalculations;
import epam.javatr.train.action.TrainFilterCar;
import epam.javatr.train.action.TrainReport;
import epam.javatr.train.action.TrainSort;
import epam.javatr.train.car.Car;
import epam.javatr.train.car.PassengerCar;
import epam.javatr.train.getlist.Train;

public class ValidatorTrain {

	private static String FILE_CAR;
	private static CarReadData fileread;
	private static Train train;
	private static TrainCalculations calc;
	private static TrainReport report;
	private static TrainSort trsort ;
	private static TrainFilterCar tfilter;
	private static ArrayList<String> strread;
	private static int actual;
	
	@BeforeClass
	public static void prepareActions(){
	FILE_CAR = "./data/TrainCar.txt";
	fileread = new CarReadData();
	train = new Train();
	calc = new TrainCalculations();
	strread = fileread.getData(FILE_CAR, "Passenger Cars", "Baggage Cars");
	train.setCar(strread, "Passenger Cars");
	strread = fileread.getData(FILE_CAR, "Baggage Cars", null);
	train.setCar(strread, "Baggage Cars");
	report = new TrainReport();
	report.printTrain(train.getTrain());
	train.setCar(15, 2008, 2, "gjhg", 80 , 72);
	train.removeCar(6);
	tfilter = new TrainFilterCar();
	trsort = new TrainSort();
	trsort.sortTrainByYearId(train.getTrain());
	report.printTrain(train.getTrain());
	calc.countBag(train.getTrain());
	actual = calc.countPassenger(train.getTrain());
	calc.countCrewPassenger(train.getTrain());
	ArrayList<Car> newtrain = tfilter.filterByYearProducedFromTo(train.getTrain(), 1995, 2000);
	report.printTrain(newtrain);
	}
	
	
	@Test
	public void readDataNotEmptyTest(){
		ArrayList<String> strread = fileread.getData(FILE_CAR, "Passenger Cars", "Baggage Cars");
		assertNotNull(strread);
	}
	
	@Test
	public void setPassengerCarNotEmptyTest(){
		train.setCar(strread, "Passenger Cars");
		assertNotNull(train.getTrain());
	}
	
	@Test
	public void countPassengerTest(){
		int expected = 0;
		for(Car ob : train.getTrain()){
			if (ob instanceof PassengerCar){
				expected += ((PassengerCar) ob).getSeatTaken();
			}
		}
			assertEquals("Count Passengers Wrong:", expected, actual, 0.01);
}
}
