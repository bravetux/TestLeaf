/**
 * Assignment 2 - Collection - FindIntersectionUsingList
 * https://github.com/TestLeafPages/SeleniumAssignments/blob/master/week1/day2/assignments/mandatory/RemoveDuplicates.java
 * 
 */
package week3.day2.assignments;

import java.util.*;

/**
 * @author vignesh
 *
 */
/*
 * Pseudo Code

 * a) Declare An array for {3,2,11,4,6,7};	 
 * b) Declare another array for {1,2,8,4,9,7};
 * c) Declare for loop iterator from 0 to array length
 * d) Declare a nested for another array from 0 to array length
 * e) Compare Both the arrays using a condition statement
 
 *  f) Print the first array (shoud match item in both arrays)
 */
public class FindIntersectionUsingList
{
	public static void main(String[] args)
	{
		//Initialize the Integer Arrays
		Integer a1[] = new Integer [] {3,2,11,4,6,7};
		Integer a2[] = new Integer [] {1,2, 8,4,9,7};

		//Initialize the list, by converting the arrays to list
		List<Integer> list = Arrays.asList(a1);
		List<Integer> list1 = Arrays.asList(a2);

		//Find the intersection elements between the lists
		for (int i=0; i< list.size(); i++)
			for (int j = 0; j <list1.size(); j++)
				if (list.get(i) == list1.get(j))
					System.out.println("Matching: " + list.get(i));
	}
	
				

	/**
	 * 
	 */
	public FindIntersectionUsingList ( )
	{
		// TODO Auto-generated constructor stub
	}

}
