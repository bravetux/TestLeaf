package week1.day1.assignments;

/*
 * Goal: Find the Factorial of a given number
 *
 * input: 5
 * output: 5*4*3*2*1 = 120
 *
 * Shortcuts:
 * 1) Print : type: syso, followed by: ctrl + space + enter
 * 2) To create a 'for' loop: type 'for', followed by ctrl + space + down arrow + enter
 *
 * What are my learnings from this code?
 * 1)
 * 2)
 * 3)
 *
 */

public class Factorial
{
    //Main Method Invoke
    public static void main ( String[] args )
    {
        // Range of Factorial
        int range = 5;

        // Start Value for computation
        int factorial = 1;

        //For loop to compute factorial
        for ( int i = 1 ; i <= range ; i++ )
        {
            factorial = factorial * i;
        }

        //Print the Final Result
        System.out.println ( "Factorial " + factorial );
    }
}
