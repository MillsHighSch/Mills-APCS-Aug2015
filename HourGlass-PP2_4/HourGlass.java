
/**
 * PP 2.4 from BJP
 * 
 * @author Steve Lamont
 * @version 17 Sep 2015
 */
public class HourGlass{
    public static void main(String[] args){
        topBase();
        topFunnel();
        middle();
        bottomFunnel();
        topBase();
    }

    public static void topBase(){
        System.out.print("|");
        for (int i=1; i <= 10; i++){
            System.out.print("\"");
        }
        System.out.println("|");
    }

    public static void topFunnel(){
        for (int i=1; i<=4; i++){
            for (int k=1; k<=i; k++){
                System.out.print(" ");
            }
            System.out.print("\\");
            for (int k=1; k<=10-2*i; k++){
                System.out.print(":");
            }
            System.out.println("/");
        }
    }

    public static void middle(){
        System.out.println("     ||"); // not worth doing a loop for the 5 spaces
    }

    public static void bottomFunnel(){  //mostly same as topFunnel
        for (int i=4; i>=1; i--){  // this is backwards from topFunnel
            for (int k=1; k<=i; k++){
                System.out.print(" ");
            }
            System.out.print("/");  //switch to forward slash
            for (int k=1; k<=10-2*i; k++){
                System.out.print(":");
            }
            System.out.println("\\"); //switch to back slash
        }
    }
}