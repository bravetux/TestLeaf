package week1.day1.assignments;

public class FibonacciSeries {

	/*
	 * Goal: To find Fibonacci Series for a given range
	 * 
	 * input(range): 8 output: 0, 1, 1, 2, 3, 5, 8, 13
	 * 
	 * Shortcuts: 1) Print : type: syso, followed by: ctrl + space + enter 2) To
	 * create a 'for' loop: type 'for', followed by ctrl + space + down arrow +
	 * enter
	 * 
	 * What are my learnings from this code? 1) 2) 3)
	 * 
	 */
	public static void main(String[] args) {
		int range = 8;
		int f1 = 0, f2 = 1;
		int f3 = f1 + f2;
		
		System.out.print(f1+", ");
		System.out.print(f2+", ");
		for (int i = 3; i<=range; i++)
		{
			if (i != range)
				System.out.print(f3+", ");
			else
				System.out.print(f3);
			
			f1 = f2;
			f2 = f3;
			f3 = f1+f2;
			
		}

	}

}
