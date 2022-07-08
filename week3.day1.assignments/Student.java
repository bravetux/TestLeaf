/**
 * 
 */
package week3.day1.assignments.org.student;

import week3.day1.assignments.org.department.Department;

/**
 * @author vignesh
 *
 */
public class Student extends Department
{

	/**
	 * Student Methods
	 */
	public void studentName ( )
	{
		System.out.println("Student Name: Vignesh");
	}

	public void studentDept ( )
	{
		System.out.println("Student Dept: CSE");
	}

	public void studentId ( )
	{
		System.out.println("Student Id: 309");
	}

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		Student s = new Student();

		s.studentId();		//Methods of Student Class
		s.studentName();
		s.studentDept();

		s.deptName();		//Inherit Methods from Department Class

		s.collegeCode(); 	//Inherit Methods from College Class
		s.collegeName();
		s.collegeRank();


	}

}
