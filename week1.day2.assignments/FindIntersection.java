package week1.day2.assignments;

public class FindIntersection {
	/*
	 * Pseudo Code
	
	 * a) Declare An array for {3,2,11,4,6,7};	 
	 * b) Declare another array for {1,2,8,4,9,7};
	 * c) Declare for loop iterator from 0 to array length
	 * d) Declare a nested for another array from 0 to array length
	 * e) Compare Both the arrays using a condition statement
	 
	 *  f) Print the first array (should match item in both arrays)
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int i, j;
		int arr1[] = {3,2,11,4,6,7};
		int arr2[] = {1,2,8,4,9,7};

		for (i=0,j=0; i<arr1.length && j<arr1.length; i++, j++)
		{
			if (arr1[i] == arr2[j])
			{
				System.out.println("Match Found : " + arr1[i]);
			}
		}
	}

}
