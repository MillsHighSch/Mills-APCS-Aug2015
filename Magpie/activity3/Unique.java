package activity3;
public class Unique{
    public static void main(String[] args){
        Unique test = new Unique();
        int answer = test.findKeyword("yesterday is today's day before.", "day", 0);
        System.out.println(answer);
    }

        public int findKeyword(String statement, String goal, int startPos){
        String phrase = statement.trim().toLowerCase();
        goal = goal.toLowerCase();
        int psn = phrase.indexOf(goal, startPos);
        while (psn >= 0)
        {
            String before = " ", after = " ";
            if (psn > 0)
            {
                before = phrase.substring(psn - 1, psn);
            }
            if (psn + goal.length() < phrase.length())
            {
                after = phrase.substring(psn + goal.length(),
                    psn + goal.length() + 1);
            }
            /* determine the values of psn, before, and after at this point in the method. */
            if (((before.compareTo ("a") < 0 ) || (before.compareTo("z") > 0))
            &&
            ((after.compareTo ("a") < 0 ) || (after.compareTo("z") > 0)))
            {
                return psn;
            }
            psn = phrase.indexOf(goal, psn + 1);
        }
        return -1;
    }
}