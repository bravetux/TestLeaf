/**
 * 
 */
package week3.day1.assignments.org.sys;

/**
 * @author vignesh
 *
 */
public class Desktop extends Computer
{

	/**
	 * Desktop Method
	 */
	public void desktopSize ( )
	{
		System.out.println("This is Desktop Size");
	}

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		Desktop d = new Desktop();
		d.computerModel();
		d.desktopSize();

	}

}
