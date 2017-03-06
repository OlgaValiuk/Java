package epam.javatr.train.car;

public class BaggageCar extends Car {

	private int bagPossible;
	private int bagTaken;

	public BaggageCar(int id, int yearProduced, int crewNumber, int bagPossible, int bagTaken) {
		super(id, yearProduced, crewNumber);
		this.bagPossible = bagPossible;
		this.bagTaken = bagTaken;
	}
	
	
	public void setBagPossible(int bagPossible) {
		this.bagPossible = bagPossible;
	}

	public void setBagTaken(int bagTaken) {
		this.bagTaken = bagTaken;
	}

	public int getBagPossible() {
		return bagPossible;
	}

	public int getBagTaken() {
		return bagTaken;
	}

}
