
/**
 * This runs the objects in the superclass Vehicles
 * chapter 9.1
 */
public class VehicleRunner
{
    public static void main(String[] args){
       // Create an instance of Convertible
        Convertible marysCar = new Convertible("yellow", 2015, "Mini", "ragtop");
       System.out.println(marysCar);
       System.out.println(marysCar);
       // Make mileage 12,000 miles to car then check for maintenance
       marysCar.changeMileage(12000);
       System.out.println(marysCar);
       marysCar.changeOil();
       // create and print a race car
       Racecar joesCar = new Racecar("red", 2016, "Lotus", false);
       System.out.println(joesCar);
       // create a Motorcycle - new
       Motorcycle suesHog = new Motorcycle("blue", 2000);
       System.out.println(suesHog);
       // change miles then check for oil change
       suesHog.changeMileage(7000);
       System.out.println(suesHog);
       suesHog.changeOil();
       
    }
}
