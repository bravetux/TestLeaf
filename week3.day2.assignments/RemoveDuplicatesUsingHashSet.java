/**
 * Assignment 2 - Collection - Program 3
 * https://github.com/TestLeafPages/SeleniumAssignments/tree/master/week1/day2/classroom/arrays
 * 
 */
package week3.day2.assignments;

import java.util.*;

/**
 * @author vignesh
 *
 */
public class RemoveDuplicatesUsingHashSet
{
	public static void main(String[] args)
	{
		//Initialise Integer Array
		Integer[] arr = {14,12,13,11,15,14,18,16,17,19,18,17,20};

		//Convert array to list
		Set<Integer> setList1 = new HashSet<Integer>(Arrays.asList(arr));
		
		System.out.println("Duplicates Removed Array: " + setList1);


	}

}
