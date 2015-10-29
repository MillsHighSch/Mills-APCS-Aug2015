
/**
 * Write a description of class Oct29_DoNow here.
 * testing students on if statements and order of precedence
 * @author Steve Lamont
 * @version 29 Oct 2015
 */
public class Oct29_DoNow
{
   public static void main(String[] args)
   {
       int x = 2;
       int y = 3;
       if (x++ * 2 - 1 == 3 && x == y++){
           if (x < y++ || y > 10 / 2 - 1 && true ) {
               x--;
               y++;
            }
            y++;
        }
        else if (x == 2 && x * y < 10){
            if (x < y++ || 2 * y == 6) {
                x--;
            }
            else {
                x+=3;
            }
        }
        else{
            y--;
        }
        System.out.println(x + y);
    }
}
