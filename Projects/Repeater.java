
/**
 * Write a description of class Repeater here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Repeater{
    public static void main (String[] args){
        int counter = 1;
        for (int i=0; i <= 10; i++){
            for (int j=3; j > 0; j--){
                for (int k=1; k<=5; k++){
                    counter++;
                    k+=5;
                }
            }
        }
        System.out.println(counter);
    }       
}
