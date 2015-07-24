
/**
 * this is my first use of BlueJ, to calculate factorials of numbers up to 100.
 * 
 * @author (Steve) 
 * @version (1.0)
 */
public class Factorial
{
   
    public static void main(String[] args)
    {
        final int NUM_FACTS = 25;
        for (int i = 1; i < NUM_FACTS; i++){
            System.out.printf("%3d! is %14.4e\n",i,factorial(i));
            //System.out.println(i + "! is ");
            //System.out.printf("%14.4e", factorial(i));
        }
    }
    public static double factorial(int n)
    {
        double result = 1;
        for (int i=2; i <= n; i++)
            result *= i;
        return result;
    }    
}
