/**
 * Assignment 3: Using TreeSet
 */
package week3.day2.assignments;

import java.util.Arrays;
import java.util.Set;
import java.util.TreeSet;

/**
 * @author vignesh
 *
 */
public class MissingNumberUsingSet
{

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		Integer[] numbers = {4,6,7,2,3,1,9,10,8,8,6,2};
		
		//Array To TreeSet
		//Remove Duplicates
		TreeSet<Integer> tsList = new TreeSet<Integer>(Arrays.asList(numbers));
		System.out.println("TreeList: " + tsList);
		
		//Convert TreeSet to Object[]
		Object[] cleanObjArray = tsList.toArray();
		System.out.println("Object Size: " + cleanObjArray.length);
		
		//Integer[] to hold elements of Object[] of size
		Integer iArray[] = new Integer[cleanObjArray.length-1];
	
		//Convert Object[] elements to Integer[]
		for (int i = 0; i< (cleanObjArray.length-1); i++) {
			iArray[i] = (Integer) cleanObjArray[i];
		}
		
		//Find the Missing element in the iArray
		for (int i = 0; i< (iArray.length-1); i++)
			if (iArray[i] != (i+1))
			{
				System.out.println("Missing Element: " + (i+1));
				break;
			}
	}

}
