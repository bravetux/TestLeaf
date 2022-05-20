package week1.day2.assignments;

/* MyCalculator Class, to access Calculator Class */
public class MyCalculator
{

    //Main Method Invoked
    public static void main ( String[] args)
    {
        //Create Class Calculator Object, using new keyword
        Calculator calc = new Calculator ( );

        /* Invoke print statements, to invoke Member Functions of the 
         * Calculator Class using the object calc, created above.
         */
        
        System.out.println ( "Addition:       " + calc.add ( 1 , 2 , 3 ) );
        System.out.println ( "Subtraction:    " + calc.sub ( 5 , 3 ) );
        System.out.println ( "Multiplication: " + calc.mul ( 2 , 3 ) );
        System.out.println ( "Division:       " + calc.div ( 6.3f , 2.1f ) );
    }

}
