package epam.javatr.train.car;

enum PassengerCarStyle {
	GENERAL, SECONDCLASS, COUPE
}

public class PassengerCar extends Car {

	private int seatPossible;
	private int seatTaken;
	private PassengerCarStyle styleCar;

	public PassengerCar(int id, int yearProduced, int crewNumber, String style, int seatPossible, int seatTaken) {
		super(id, yearProduced, crewNumber);
		this.styleCar = PassengerCarStyle.valueOf(style);
		this.seatPossible = seatPossible;
		this.seatTaken = seatTaken;
	}
	
	
	public void setSeatPossible(int seatPossible) {
		this.seatPossible = seatPossible;
	}

	public void setSeatTaken(int seatTaken) {
		this.seatTaken = seatTaken;
	}

	public void setStyleCar(PassengerCarStyle styleCar) {
		this.styleCar = styleCar;
	}

	public int getSeatPossible() {
		return seatPossible;
	}

	public int getSeatTaken() {
		return seatTaken;
	}

	public PassengerCarStyle getStyleCar() {
		return styleCar;
	}
}
