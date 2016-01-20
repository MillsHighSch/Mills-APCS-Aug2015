
/**
 * Early test of using object
 * 
 * @author Steve Lamont 
 * @version 19 Jan 2016
 */
public class Golf
{
    public static void main(String[] args){
        ScoreKeeper golfer1 = new ScoreKeeper("Fred");
        ScoreKeeper golfer2 = new ScoreKeeper("Wilma");
        golfer1.holeScore(1,5,4);
        golfer2.holeScore(1,5,5);
        golfer1.holeScore(2, 3,5);
        golfer2.holeScore(2,3,5);
        golfer1.holeScore(3, 4,5);
        golfer2.holeScore(3,4,2);
        golfer1.holeScore(4, 3,2);
        golfer2.holeScore(4,3,3);
        golfer1.finalTally();
        golfer2.finalTally();
    }
}
