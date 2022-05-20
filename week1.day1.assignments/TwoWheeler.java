package week1.day1.assignments;

public class TwoWheeler
{
    //Initialize the class member variables.
    int     noOfWheels    = 2;
    short   noOfMirrors   = 2;
    long    chassisNumber = 123467890;
    boolean isPunctured   = false; // Default false
    String  bikeName      = "SUZUKI";
    double  runningKM     = 8080.808;

    //Main Method Invoke
    public static void main ( String[] args )
    {
        //Create a Class Object to access the Class member Variables
        TwoWheeler bike = new TwoWheeler ( );

        //Print the Class member variables
        System.out.println ( "Name:        " + bike.bikeName );
        System.out.println ( "Chassis No.: " + bike.chassisNumber );
        System.out.println ( "Punctured ?: " + bike.isPunctured );
        System.out.println ( "No. Wheels : " + bike.noOfWheels );
        System.out.println ( "No. Mirrors: " + bike.noOfMirrors );
        System.out.println ( "Running KM : " + bike.runningKM );
    }
}
