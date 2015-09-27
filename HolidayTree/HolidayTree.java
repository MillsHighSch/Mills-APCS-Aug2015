
/**
 * Programming Project 3.1 passing parameters to methods
 * Drawing holiday trees based on two parameters:
 * Number of Segments
 * Segment Height
 * 
 * @author Steve Lamont
 * @version 25 Sept 2015
 */
public class HolidayTree
{public static void main(String[] args){
        holidayTree(3,4);  // example 1
        System.out.println("");
        holidayTree(2,5);  // example 2
    }

    public static void holidayTree(int numSegments, int segmentHeight){
        int center = (numSegments + segmentHeight) - 1; // important universal calculation to adapt to any range of parameters
        /* 
         * print each of the segments
         */
        for (int i = 1; i <= numSegments; i++){  // repeat based on number of segments to print
            for (int j=1; j <= segmentHeight; j++){
                int stars = 2 * ( i + j) - 3;
                writeSpaces(center - ((stars+1)/2));
                writeStars(stars);
                
                System.out.println("");
            }
        }
        /*
         * Print out the base
         */
        printTrunk(center);
        printTrunk(center);
        writeSpaces(center - 4);
        writeStars(7);
        System.out.println("");
    }

    public static void writeSpaces(int numSpaces){
        for (int i=1; i <= numSpaces; i++){
            System.out.print(" ");
        }
    }

    public static void writeStars(int numStars){
        for (int i=1; i <= numStars; i++){
            System.out.print("*");
        }
    }

    public static void printTrunk(int center){  //method to print the trunk in the right place
        writeSpaces(center - 1);
        System.out.println("*");
    }

}
