
/**
 * Do Now exercise to test students on instances
 * @author Steve Lamont
 * @version 5 Feb 2016
 */
public class MooMoo
{
    private String type = "cow";
    private String sound = "moo";

    public MooMoo(){
    }
    
    public MooMoo(String animal, String call)
    {
        type = animal;
        sound = call;
    }

    public void setSound(String y){
        this.sound = y;
    }

    public String getSound(int y)
    {
        String line = "";
        for (int i=0; i<y; i++){
            line = line + this.type + " says " + this.sound + "; ";
        }
        return line;
    }
}
