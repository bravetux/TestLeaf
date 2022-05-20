package week1.day2.assignments;

/*
 * Pseudo Code

 * a) Declare An array for {3,2,11,4,6,7};
 * b) Declare another array for {1,2,8,4,9,7};
 * c) Declare for loop iterator from 0 to array length
 * d) Declare a nested for another array from 0 to array length
 * e) Compare Both the arrays using a condition statement

 *  f) Print the first array (should match item in both arrays)
 */

public class FindIntersection
{

    // Invoke Main Method
    public static void main ( String[] args )
    {
        // Initialize the Loop Variables
        int i, j;

        //Initialize the Array
        int arr1[] = { 3 , 2 , 11 , 4 , 6 , 7 };
        int arr2[] = { 1 , 2 , 8 , 4 , 9 , 7 };

        //Loop the array elements
        for ( i = 0 , j = 0; i < arr1.length && j < arr1.length ; i++ , j++ )
        {
            //Find the matching element between the arrays
            if ( arr1[ i ] == arr2[ j ] )
            {
                //Print the Matching Element
                System.out.println ( "Match Found, Intersecting Element : " + arr1[ i ] );
            }
        }
    }

}
