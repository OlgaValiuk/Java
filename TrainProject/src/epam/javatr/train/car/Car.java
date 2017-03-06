package epam.javatr.train.car;

public class Car {

	private Integer id;
	private Integer yearProduced;
	private int crewNumber;

	public Car(int id, int yearProduced, int crewNumber) {
		this.id = id;
		this.yearProduced = yearProduced;
		this.crewNumber = crewNumber;
	}
	
	public void setCrewNumber(int crewNumber) {
		this.crewNumber = crewNumber;
	}

	public Integer getId() {
		return id;
	}

	public Integer getYearProduced() {
		return yearProduced;
	}

	public int getCrewNumber() {
		return crewNumber;
	}
	
}
