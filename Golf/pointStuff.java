
/**
 * checking board work
 * 
 * @author Lamont 
 * @version 20 Jan 2016
 */
import java.awt.*;
public class pointStuff
{
    public static void main(String[] args){
        Point p = new Point();
        p.x = 5;
        p.y = 3;
        System.out.println(p); 
        Point p1 = new Point(7,2);
        System.out.println(p1);
        p1.x = 5;
        System.out.println(p1);
        Point p2 = new Point(5,3);
        System.out.println(p2);
        p1.translate(2,2);
        System.out.println(p1);
        Point p3 = p1;
        System.out.println(p3);
        p3.y = 9;
        System.out.println(p1);
        System.out.println(p3);
    }
}
