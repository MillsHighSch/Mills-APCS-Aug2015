
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
                for (int k=1; k <= (center - ((stars+1)/2)); k++){
                    System.out.print(" ");
                }
                for (int m=1; m <= stars; m++){
                    System.out.print("*");
                }
                System.out.println("");
            }
        }
        /*
         * Print out the base
         */
        printTrunk(center);
        printTrunk(center);
        for (int i=1; i <= center - 4; i++){
            System.out.print(" ");
        }
        System.out.println("*******");
    }

    public static void printTrunk(int center){  //method to print the trunk in the right place
        for (int i=1; i <= center -1; i++){
            System.out.print(" ");
        }
        System.out.println("*");
    }

}
