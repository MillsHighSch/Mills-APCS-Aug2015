package activity2;

/**
 * A program to carry on conversations with a human user.
 * This is the initial version that:  
 * <ul><li>
 *       Uses indexOf to find strings
 * </li><li>
 *          Handles responding to simple words and phrases 
 * </li></ul>
 * This version uses a nested if to handle default responses.
 * @author Laurie White
 * Modified by Steven Lamont
 * 29 July 2015
 * @version April 2012
 */
public class Magpie2
{
    /**
     * Get a default greeting   
     * @return a greeting
     */
    public String getGreeting()
    {
        return "Hello, let's talk.";
    }
    
    /**
     * Gives a response to a user statement
     * 
     * @param statement
     *            the user statement
     * @return a response based on the rules given
     */
    public String getResponse(String statement)
    {
        String response = "";
        if (statement.indexOf("no") >= 0)
        {
            response = "Why so negative?";
        }
        else if (statement.indexOf("mother") >= 0
                || statement.indexOf("father") >= 0
                || statement.indexOf("sister") >= 0
                || statement.indexOf("brother") >= 0)
                {
            response = "Tell me more about your family.";
        }
        else if ((statement.indexOf("dog") >= 0) || (statement.indexOf("cat") >= 0))
            response = "Tell me more about your pets."; // added statement for pets  
        else if (statement.indexOf("Dreyer") >= 0)
            response = "She sounds like a good teacher"; // added teacher response
        else if (statement.contains("hot") || statement.contains("warm") || statement.contains("cold")) 
            response = "It sure is."; // added keyword response #1
        else if (statement.contains("boring")) 
            response = "Then do something else."; // added keyword response #2
        else if (statement.contains("why") || statement.contains("Why"))
            response = "Why do you ask?"; // added keywork response #3
        else
        {
            response = getRandomResponse();
        }
        return response;
    }

    /**
     * Pick a default response to use if nothing else fits.
     * @return a non-committal string
     */
    private String getRandomResponse()
    {
        final int NUMBER_OF_RESPONSES = 6;
        double r = Math.random();
        int whichResponse = (int)(r * NUMBER_OF_RESPONSES);
        String response = "";
        
        if (whichResponse == 0)
        {
            response = "Interesting, tell me more.";
        }
        else if (whichResponse == 1)
        {
            response = "Hmmm.";
        }
        else if (whichResponse == 2)
        {
            response = "Do you really think so?";
        }
        else if (whichResponse == 3)
        {
            response = "You don't say.";
        }
        else if (whichResponse == 4) response = "Get out of here."; // added nonsense response #1
        
        else if (whichResponse == 5) response = "Fascinating."; // added nonsense response #2

        return response;
    }
}
