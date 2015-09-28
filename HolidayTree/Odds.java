
/**
 * Derived from SC3.4
 * Used for Do Now 29 Sep 2015 Formative Test
 * 
 * @author Steve Lamont
 * @version 28 Sep 2015
 */
public class Odds{
    public static void main(String[] args){
        int num = 3;
        printOdds(num, ';');
        printOdds(9/2, '/');
        int i=25;
        printOdds(29-i+num, '.');
    }

    public static void printOdds(int num, char spacer){
        for (int i=1; i <= num; i++){
            System.out.print(" ");
            int odd = 2 * i - 1;
            System.out.print(odd);
        }
        System.out.print(spacer);
    }
}
