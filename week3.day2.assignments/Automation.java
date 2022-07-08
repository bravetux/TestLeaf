/**
 * Assignment 1 - Abstraction
 * class Automation 
 */
package week3.day2.assignments;

/**
 * @author vignesh
 *
 */
public class Automation extends MultipleLanguage
{

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		Automation obj = new Automation();
		
		obj.Java();
		obj.Selenium();
		obj.python();
		obj.ruby();

	}

	public void Java()
	{
		// TODO Auto-generated method stub
		System.out.println("Java - Automation");
		
	}

	public void Selenium()
	{
		// TODO Auto-generated method stub
		System.out.println("Selenium - Automation");
		
	}

	@Override
	public void ruby()
	{
		// TODO Auto-generated method stub
		System.out.println("Ruby - Automation");
		
	}

}
