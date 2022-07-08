/**
 * 
 */
package week3.day1.assignments;

/**
 * @author vignesh
 *
 */
public class Students
{

	/**
	 * Method getStudentInfo Overloading
	 */
	public void getStudentInfo ( )
	{
		System.out.println("Get Student Info");
	}
	
	public void getStudentInfo ( int studentId,  String studentName)
	{
		System.out.println("Get Student Id: " + studentId + " & Name:" + studentName);
	}

	public void getStudentInfo ( String emailId, int studentPhone)
	{
		System.out.println("Get Student emailId: " + emailId + " & Phone:" + studentPhone);
	}

	
	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args)
	{
		Students s = new Students();
		s.getStudentInfo();
		s.getStudentInfo(101, "Vignesh");
		s.getStudentInfo("vignesh@bravetux.com", 30846);
	}

}
