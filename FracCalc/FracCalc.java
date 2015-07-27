  
import java.util.*;  //for input scanner

public class FracCalc {

    public static void main(String[] args) 
    {
        // TODO: Read the input from the user and call produceAnswer with an equation
        Scanner console = new Scanner(System.in);

        boolean is_quit = false;

        // Loop until user tells program to quit
        while (!is_quit){
            System.out.println();
            System.out.print("Enter fraction input or quit: ");
            String fraction = console.nextLine();
            System.out.println();

            // Let's first ensure the input is in correct form
            while (fraction == null || !(fraction.contains("+") || fraction.contains("-") || fraction.contains("*") || fraction.contains("/") || fraction.equals("quit"))){
                System.out.print("Please ensure the phrase contains either +, -, *, or /; or enter quit:  ");
                fraction = console.nextLine();
                System.out.println();
            }

            // Either set the quit sequence or process the result
            if (fraction.equals("quit"))
            {is_quit = true;
                System.out.println("Thank you for playing!");   
            }  
            else
            {System.out.print(produceAnswer(fraction));
            }
        }
    }

    // ** IMPORTANT ** DO NOT DELETE THIS FUNCTION.  This function will be used to test your code
    // This function takes a String 'input' and produces the result
    //
    // input is a fraction string that needs to be evaluated.  For your program, this will be the user input.
    //      e.g. input ==> "1/2 + 3/4"
    //        
    // The function should return the result of the fraction after it has been calculated
    //      e.g. return ==> "1_1/4"
    public static String produceAnswer(String input)
    { 
        // TODO: Implement this function to produce the solution to the input
        
        // TODO: Find and convert / as operator to # to remove ambiguity
        input = input.replace(" / "," # ");

        //Remove spaces from the string
        for (int k=0;k<input.length();k++){
            if (input.charAt(k)==' '){
                input = input.substring(0,k) + input.substring(k+1,input.length());
            }
        }    


        // Split the fraction into operator, first fraction, and second phrase
        String [] parsed = new String [2];
        parsed = parse_input(input);
        String operator = parsed [0];
        
        //print out a check. TODO: remove this for final
        System.out.println(parsed[1] + "..." + operator + "..." + parsed[2]);
        
        //Convert each fraction to integers strings -- whole number,numerator, denominator
       int [][] values = new int [2][3];
       values [0] = parse_fraction(parsed[1]);
       values [1] = parse_fraction(parsed[2]);
       //NO GOOD -- will not properly parse just whole number, puts it in numerator.
       System.out.println("first whole: " + values[0][0]+ ", first numer: " + values[0][1]+ ", first denom: " + values  [0][2]);

        return "";
    }

     // This is driver for writing test routines
    public static void tester(String input){

}

// Returns string with operator, first fraction, second fraction strings
public static String[] parse_input(String input){
    String [] parsed = new String [3];
    for (int i=0;i<input.length();i++){
            if (input.charAt(i)=='+' || input.charAt(i)=='-' || input.charAt(i)=='*' || input.charAt(i)=='#'){
                parsed[0] = input.substring(i,i+1);
                parsed[1] = input.substring(0,i);
                parsed[2] = input.substring(i+1,input.length());
                i=input.length();
            }
    }
    return parsed;
}

// Returns array with whole number, numerator, and denominator as integers
public static int [] parse_fraction(String input){
    int values [] = new int [3];
    for (int i=0; i<input.length();i++){
        if (input.charAt(i)=='_'){
            values[0] = Integer.parseInt(input.substring(0,i));
            input = input.substring(i+1,input.length());
            i=input.length();
        }
    }
    for (int i=0; i<input.length();i++){
        if (input.charAt(i)=='/'){
            values[1] = Integer.parseInt(input.substring(0,i));
            input = input.substring(i+1,input.length());
            i=input.length();
        }
    }
    values[2] = Integer.parseInt(input);
return values;
}
}