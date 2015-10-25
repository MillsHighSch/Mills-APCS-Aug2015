/**
 * Testing different ways to pass scanner objects
 * In this version we create scanner objects within the main method,
 * then pass the oject to the second method to use
 * 
 * @author Steve Lamont
 * @version 25 Oct 2015
 */

import java.util.*; //for scanner object

public class ScannerTest3
{
    public static void main(String[] args)
    {
        Scanner console3 = new Scanner(System.in);  //create console2 as scanner object
        System.out.println("Tell me your name: ");
        String name = console3.nextLine();
        System.out.println("Hello " + name);
        secondMethod(console3, name); // pass scanner object to other method
    }
    /*
     * Create and call sencond method and pass our scanner object console3 for
     * it to use get more input from the user
     * We pass name into this object.
     */
    
    public static void secondMethod(Scanner console3, String yourName) //receive scanner object
    {
        System.out.println("Where do you live? ");
        String city = console3.nextLine(); // use our same console3 scanner object
        System.out.println(yourName + " lives in " + city);
    }
   
}