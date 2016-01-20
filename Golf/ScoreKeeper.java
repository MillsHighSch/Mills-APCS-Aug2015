
/**
 *Object to keep score on golf game
 * 
 * @author Steve Lamont 
 * @version 19 Jan 2016
 */
public class ScoreKeeper
{
    // initialize cumulative scores to zero
    int cumulScore = 0;
    int cumulPar = 0;
    String results[] = {"horrible","double bogey", "bogey", "par", "birdie",
        "eagle", "fantastic"};

    /*
     * use results from each hole, add to cumulative totals, then print relative to par 
     * for each hole
     */
    void holeScore(int hole, int par, int score){
      this.cumulScore += score;
      this.cumulPar += par;
      if (score-par > 2) System.out.println("Hole " + hole + ": " + results[0]); // for bad results
      else if (par-score >2) System.out.println("Hole " + hole + ": " + results[6]);
      else System.out.println("Hole " + hole + ": " + results[(par-score) + 3]);
    }
    /*
     * Use the final tallies to print out how the golfer did on the entire round.
     */
    void finalTally(){
        if (cumulScore > cumulPar){
            System.out.println("Overall you shot " + (cumulScore-cumulPar) +
            " over par");
        }
        else if (cumulScore < cumulPar){
            System.out.println("Overall you shot " + (cumulPar-cumulScore) +
            " under par");
        }
        else System.out.println("Overall you shot par");
    }
}
