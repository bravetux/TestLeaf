/**
 * 
 */
package week3.day1.assignments.bank;

/**
 * @author vignesh
 *
 */
public class Axis extends Bank
{

	/**
	 * Method Overriding
	 */
	public void deposit ( )
	{
		System.out.println("Axis Deposit() invoked");
	}

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		Axis a = new Axis();
		
		a.saving(); //from Bank Class
		a.deposit();	//Method Overriding from Axis
		a.fixed();  //from Bank Fixed

	}

}
