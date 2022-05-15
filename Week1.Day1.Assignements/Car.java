package week1.day1.assignments;

public class Car {
	
	public void applyBreak() {
		System.out.println("Apply Brake");
	}

	public void applyGear() {
		System.out.println("Apply Gear");
	}
	
	public void switchonAc() {
		System.out.println("Switch on AC");
	}

	public void applyAccelerate() {
		System.out.println("Apply Acceleration");
	}

	public static void main(String[] args) {
		Car MyCar = new Car();
		MyCar.applyAccelerate();
		MyCar.applyGear();
		MyCar.switchonAc();
		MyCar.applyBreak();
	}

}
