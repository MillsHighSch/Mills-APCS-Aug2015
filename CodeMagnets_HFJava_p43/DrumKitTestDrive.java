
/**
 * Code Magnets form p43 of Head First Java
 * 
 * @author Steve Lamont 
 * @version 17 Jan 2016
 */
public class DrumKitTestDrive
{
    public static void main(String [] args ){

        DrumKit d = new DrumKit();
        d.playSnare();
        d.playTopHat();
        d.snare = false;
        if (d.snare == true) {
            d.playSnare(); 
        }
    }
}
