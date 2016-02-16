
/**
 * Class Solution to demonstrate OOP
 * Chapter 9.1
 */
public class Car
{
    // instance variables
    private int year;
    private String make;
    private boolean smogChecked;

    /**
     * Constructor for objects of class Car
     */
    public Car()
    {
        // initialise instance variables
        this.smogChecked = true;
    }

    /*
     * Constructor for special form of class Car
     */
    public Car(int year, String make){
        this.smogChecked = true;
        this.year = year;
        this.make = make;
    }

    /**
     * Tell owner to do the smog check 
     */
    public void smogCheck()
    {
        if (!smogChecked) {
            System.out.println("Hey buddy, go get the smog check done. Fix the car if you need to");
            this.smogChecked = true;
        }
    }
}
