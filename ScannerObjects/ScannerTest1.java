
/**
 * Testing different ways to pass scanner objects
 * In this version we make the scanner object console1 a class variable
 * 
 * @author Steve Lamont
 * @version 25 Oct 2015
 */

import java.util.*; //for scanner object

public class ScannerTest1
{
    /*
     * Make console1 a class variable so we can call it from different methods
     * without creating new objects
     */
    public static Scanner console1 = new Scanner(System.in); 
    
    public static void main(String[] args)
    {
        System.out.println("Tell me your name: ");
        String name = console1.nextLine();
        System.out.println("Hello " + name);
        secondMethod(name);
    }
    /*
     * Create and call sencond method to demonstrate it can create another
     * instance of console1 without having to create an object.
     * We pass name into this object.
     */
    
    public static void secondMethod(String yourName)
    {
        System.out.println("Where do you live? ");
        String city = console1.nextLine();
        System.out.println(yourName + " lives in " + city);
    }
   
}
