package week1.day1.assignments;

public class PrimeNumber {
	/*
	 * Goal: To find whether a number is a Prime number or not
	 * 
	 * input: 13
	 * output: 13 is a Prime Number
	 * 
	 * Shortcuts:
	 * 1) Print : type: syso, followed by: ctrl + space + enter
	 * 2) To create a 'for' loop: type 'for', followed by ctrl + space + down arrow + enter
	 * 3) To create an 'if' condition: type 'if', followed by ctrl + space +down arrow + enter
	 *   
	 * What are my learnings from this code?
	 * 1)
	 * 2)
	 * 3) 
	 * 
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int checkPrime = 29;
		boolean isPrime = true;
		
		if (checkPrime == 0 || checkPrime == 1)
		{
			System.out.println("Not Prime");
			return;
		}
		
		for(int i=2; i<checkPrime/2; i++)
		{
			if (checkPrime % i == 0)
			{
				isPrime = false;
				break;
			}
		}
		
		if (!isPrime)
			System.out.println("Not Prime");
		else
			System.out.println("Prime");
		}

	}

