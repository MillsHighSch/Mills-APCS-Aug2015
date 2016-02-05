
/**
 * Do Now exercise to test students on instances
 * @author Steve Lamont
 * @version 5 Feb 2016
 */
public class MooMooRunner
{
    public static void main(String[] args){
        MooMoo fluffy = new MooMoo("horse", "neigh");
        MooMoo itchy = new MooMoo("pig", "oink");
        itchy.setSound("snort");
        MooMoo puddles = new MooMoo();
        puddles = itchy;
        itchy.setSound("honk");
        System.out.println(puddles.getSound(3));
    }
}
