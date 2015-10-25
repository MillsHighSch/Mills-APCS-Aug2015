/**
 * Testing different ways to pass scanner objects
 * In this version we create scanner objects within each method
 * 
 * @author Steve Lamont
 * @version 25 Oct 2015
 */

import java.util.*; //for scanner object

public class ScannerTest2
{
    public static void main(String[] args)
    {
        Scanner console2 = new Scanner(System.in);  //create console2 as scanner object
        System.out.println("Tell me your name: ");
        String name = console2.nextLine();
        System.out.println("Hello " + name);
        secondMethod(name);
    }
    /*
     * Create and call sencond method to demonstrate it can create 
     * another Scanner object called console2
     * We pass name into this object.
     */
    
    public static void secondMethod(String yourName)
    {
        Scanner console2 = new Scanner(System.in); // create another console2 object
        System.out.println("Where do you live? ");
        String city = console2.nextLine();
        System.out.println(yourName + " lives in " + city);
    }
   
}

