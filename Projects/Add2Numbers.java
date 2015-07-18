
/**
 * Write a description of class Add2Numbers here.
 * Testing to ensure BlueJ can take console input
 * @author Steve Lamont
 * @version 18 July 2015
 */
import java.util.*; // for scanner

public class Add2Numbers
{
    
    
    public static void main(String[] args)
    {
        // initialise instance variables
        Scanner console = new Scanner(System.in);
        System.out.println("What is first number? ");
        int first = console.nextInt();
        System.out.println("What is second number? ");
        int second = console.nextInt();
        int sum = first + second;
        System.out.println("The sum of numbers is: " + sum);
    }

    
}
