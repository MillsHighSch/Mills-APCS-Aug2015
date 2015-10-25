/**
 * Testing different ways to pass scanner objects
 * In this version we create scanner objects within each method,
 * and give them different names
 * 
 * @author Steve Lamont
 * @version 25 Oct 2015
 */

import java.util.*; //for scanner object

public class ScannerTest4
{
    public static void main(String[] args)
    {
        Scanner console4 = new Scanner(System.in);  //create console4 as scanner object
        System.out.println("Tell me your name: ");
        String name = console4.nextLine();
        System.out.println("Hello " + name);
        secondMethod(name);
    }
    /*
     * Create and call sencond method to demonstrate it can create 
     * a different Scanner object called input4
     * We pass name into this object.
     */
    
    public static void secondMethod(String yourName)
    {
        Scanner input4 = new Scanner(System.in);  //create input4 as new scanner object
        System.out.println("Where do you live? ");
        String city = input4.nextLine();
        System.out.println(yourName + " lives in " + city);
    }
   
}