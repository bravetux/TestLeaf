package week1.day2.assignments;

/* Import Arrays for implementing Arrays.sort() */
import java.util.Arrays;

public class MissingElementInAnArray
{

    /* Invoke Main Method */
    public static void main ( String[] args )
    {
        // Initialize Array of integers
        int[] arr = { 1 , 2 , 3 , 4 , 7 , 6 , 8 };

        //Sort the Array Elements in Ascending Order
        Arrays.sort ( arr );

        //Loop the Array Elements
        for ( int i = 0 ; i < arr.length ; i++ )
        {
            //Logic to identify the missing number in the array
            if ( arr[ i ] != ( i + 1 ) )
            {
                //Print the missing number
                System.out.println ( "Missing Number Found to be: " + ( i + 1 ) );
                break;
            }
        }
    }

}
