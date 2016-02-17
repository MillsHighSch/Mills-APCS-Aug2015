
/**
 * Class Solution to demonstrate OOP
 * Chapter 9.1
 */
public class Vehicles
{
    // instance variables
    private String color;
    private int currentMileage;
    private int lastOilChange;
    /*
     * General case constuctor
     */
    public Vehicles(){
    }

    /*
     * Constructor for new vehicle
     */
    public Vehicles(String color){
        this.color = color;
        this.currentMileage = 0; //assume it is a new car
        this.lastOilChange = 0; // assume it comes with fresh oil
    }

    /*
     * Constructor for used vehicle
     */
    public Vehicles(String color, int currentMileage){
        this.color = color;
        this.currentMileage = currentMileage; 
        this.lastOilChange = 0; // assume it comes with fresh oil
    }

    /**
     * Change the number of miles the vehicle has travelled
     */
    public void changeMileage(int currentMileage)
    {
        this.currentMileage = currentMileage;
    }

    /**
     * Tell owner to change the oil
     */
    public void changeOil(){
        if (this.currentMileage - this.lastOilChange > 10000){
            System.out.println("Hey buddy, time to change your oil");
            this.lastOilChange = this.currentMileage;
        }
    }

    public String toString(){
        String output = " Color: " + this.color + "\n Current mileage: " + this.currentMileage +
            " Last oil change at: " + this.lastOilChange;
        return output;
    }
}
