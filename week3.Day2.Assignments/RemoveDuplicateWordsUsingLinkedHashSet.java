/**
 * Assignment 2 - Collection - RemoveDuplicates
 * https://github.com/TestLeafPages/SeleniumAssignments/blob/master/week1/day2/assignments/mandatory/RemoveDuplicates.java
 * 
 */
package week3.day2.assignments;

import java.util.*;

/**
 * @author vignesh
 *
 */
public class RemoveDuplicateWordsUsingLinkedHashSet
{

	/*
	 * Pseudo code 

	 * a) Use the declared String text as input
		String text = "We learn java basics as part of java sessions in java week1";		
	 * b) Initialize an integer variable as count	  
	 * c) Split the String into array and iterate over it 
	 * d) Initialize another loop to check whether the word is there in the array
	 * e) if it is available then increase and count by 1. 
	 * f) if the count > 1 then replace the word as "" 

	 * g) Displaying the String without duplicate words	
	 */

	public static void main(String[] args)
	{
		String text = "We learn java basics as part of java sessions in java week1";
		String txtSplit[] = text.split(" "); 
		String concat = "";
		
		System.out.println("Original Txt: " + text);
		
		LinkedHashSet<String> lhsSet = new  LinkedHashSet<String>(Arrays.asList(txtSplit));
		System.out.println(lhsSet);
		
		for (String sen : lhsSet)
			concat += sen+" ";
	
		System.out.println("Method1: " + concat);
		

		System.out.print("Method2: ");
        // Obtaining an Iterator
        Iterator<String> lhsItr = lhsSet.iterator();
		
        // printing the elements in LinkedHashSet
        while (lhsItr.hasNext())
        {
            System.out.print(lhsItr.next() + " ");
        }
		
		

	}

}
