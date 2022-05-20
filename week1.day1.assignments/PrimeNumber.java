package week1.day1.assignments;

/*
 * Goal: To find whether a number is a Prime number or not
 *
 * input: 13
 * output: 13 is a Prime Number
 *
 * Shortcuts:
 * 1) Print : type: syso, followed by: ctrl + space + enter
 * 2) To create a 'for' loop: type 'for', followed by ctrl + space + down arrow + enter
 * 3) To create an 'if' condition: type 'if', followed by ctrl + space +down arrow + enter
 *
 * What are my learnings from this code?
 * 1)
 * 2)
 * 3)
 *
 */

public class PrimeNumber
{
    //Main Method Invoke
    public static void main ( String[] args )
    {
        //Number to be checked for prime
        int checkPrime = 29;

        //Flag to determine the number if Prime
        boolean isPrime = true;

        // 0 and 1 are not prime, handling corner case
        if ( checkPrime == 0 || checkPrime == 1 )
        {
            System.out.println ( "Not Prime" );
            return;
        }

        //Run for loop from 2 to checkPrime/2
        for ( int i = 2 ; i < checkPrime / 2 ; i++ )
        {
            //Check Modulo of the number in range of 2 to checkPrime/2
            if ( checkPrime % i == 0 )
            {
                //Number is divisible
                //Setting Boolean variable as not prime.
                isPrime = false;
                break;
            }
        }

        //Base on the flag, Printing Prime or not
        if ( !isPrime )
            System.out.println ( "Not Prime" );
        else
            System.out.println ( "Prime" );
    }
}

