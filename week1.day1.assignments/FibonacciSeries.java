package week1.day1.assignments;
/*
 * Goal: To find Fibonacci Series for a given range
 *
 * input(range): 8 output: 0, 1, 1, 2, 3, 5, 8, 13
 *
 * Shortcuts: 1) Print : type: syso, followed by: ctrl + space + enter 2) To
 * create a 'for' loop: type 'for', followed by ctrl + space + down arrow +
 * enter
 *
 * What are my learnings from this code? 1) 2) 3)
 *
 */

public class FibonacciSeries
{
    //Main Method Invoke
    public static void main ( String[] args )
    {

        // Range of Fibonaci Series
        int range = 8;

        // Initialize Variables
        int f1 = 0, f2 = 1;
        // Initialize the First number in the series
        int f3 = f1 + f2;

        //Display the values of the series
        System.out.print ( f1 + ", " );
        System.out.print ( f2 + ", " );

        //For loop to generate the series
        for ( int i = 3 ; i <= range ; i++ )
        {
            //When within range, print with ending with comma
            if ( i != range )
                System.out.print ( f3 + ", " );
            else
                System.out.print ( f3 );

            // Compute the next fibonacci number
            f1 = f2;
            f2 = f3;
            f3 = f1 + f2;
        }

    }
}
