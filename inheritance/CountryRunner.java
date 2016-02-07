
/**
 * Write a description of class CountryRunner here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class CountryRunner
{
    public static void main(String[] args){
        LocalResident steve = new LocalResident();
        steve.setSSN("123456789");
        System.out.println(steve.getSSN() + "  " + steve.getSalesTax());
    }
}
