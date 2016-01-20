
/**
 * Early test of using object
 * 
 * @author Steve Lamont 
 * @version 19 Jan 2016
 */
public class Golf
{
    public static void main(String[] args){
        ScoreKeeper golfer = new ScoreKeeper();
        golfer.holeScore(1,5,4);
        golfer.holeScore(2, 3,5);
        golfer.holeScore(3, 4,5);
        golfer.holeScore(4, 3,2);
        golfer.finalTally();
    }
}
