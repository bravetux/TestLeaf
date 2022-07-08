/**
 * Assignment 2 - Collection - Program 2
 * https://github.com/TestLeafPages/SeleniumAssignments/tree/master/week1/day2/classroom/arrays
 * 
 */
package week3.day2.assignments;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author vignesh
 *
 */
public class FindSecondLargestUsingList
{

	public static void main(String[] args)
	{
		//Initialize the integer array
		Integer[] data = {3,2,11,4,6,7};
		
		//Convert the Array to List
		List<Integer> list = Arrays.asList(data);
		
		//Display the List 
		System.out.println("List: " + list + " List Size = " + list.size());
		
		//Sort the List using Collections and display
		Collections.sort(list);
		System.out.println("Sorted List: " + list);
		
		//Display the second largest Element
		System.out.println("Second Largest = " + list.get(list.size()-2));

	}

}
