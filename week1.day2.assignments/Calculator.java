package week1.day2.assignments;

/* Calculator Class, Contains Operation Methods */
public class Calculator {

	/* Description: Additon Method
	 * Arguments: 2 Integer Arguments
	 * Return Value: Integer
	 */
	public int add(int num1, int num2, int num3)
	{
		return(num1+num2+num3);
	}

	/* Description: Subraction Method
	 * Arguments: 2 Integer Arguments
	 * Return Value: Integer
	 */
	public int sub(int num1, int num2)
	{
		return(num1-num2);
	}

	/* Description: Multiplication Method
	 * Arguments: 2 Double Arguments
	 * Return Value: Double
	 */
	public double mul(double num1, double num2)
	{
		return(num1 * num2);
	}

	/* Description: Division Method, prevents division by 0
	 * Arguments: 2 Float Arguments
	 * Return Value: Float
	 */
	public float div(float num1, float num2)
	{
		if (num1 != 0)
			return (num1/num2);
		else
			return 0;
	}

	//Main Method for Calculator Class
	public static void main(String[] args) {
		// No Operations
	}

}

