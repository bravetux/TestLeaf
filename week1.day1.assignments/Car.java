package week1.day1.assignments;

public class Car {
	//applyBreak Method
	public void applyBreak() {
		System.out.println("Apply Brake");
	}
	
	//applyGear Method
	public void applyGear() {
		System.out.println("Apply Gear");
	}
	
	//switchonAc Method
	public void switchonAc() {
		System.out.println("Switch on AC");
	}

	//applyAccelerate Method
	public void applyAccelerate() {
		System.out.println("Apply Acceleration");
	}

	//Main Function Invoke
	public static void main(String[] args) {
		
		//Create Object MyCar for class Car
		Car MyCar = new Car();
		MyCar.applyAccelerate();
		MyCar.applyGear();
		MyCar.switchonAc();
		MyCar.applyBreak();
	}
}
