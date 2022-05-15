package week1.day2.assignments;

public class MyCalculator {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Calculator calc = new Calculator();
		
		System.out.println("Addition:       " + calc.add(1, 2, 3));
		System.out.println("Subtraction:    " + calc.sub(5, 3));
		System.out.println("Multiplication: " + calc.mul(2, 3));
		System.out.println("Division:       " + calc.div(6.3f, 2.1f));
	}

}
