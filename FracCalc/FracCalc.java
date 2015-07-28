  
import java.util.*;  //for input scanner

public class FracCalc {

    public static void main(String[] args) 
    {
        // Read the input from the user and call produceAnswer with an equation
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
        // this function produces the solution to the input
        
        // Find and convert / as operator to # to remove ambiguity
        input = input.replace(" / "," # ");
        
        // Find and convert - as operator to $ to remove ambiguity
        input = input.replace(" - "," $ ");

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
        
        if (operator.contains("$")){operator = "-";}
        if (operator.contains("#")){operator = "/";}
               
        //Convert each fraction to integers arrays -- whole number,numerator, denominator
       int [][] values = new int [2][3];
       
       values [0] = parse_fraction(parsed[1]);
       values [1] = parse_fraction(parsed[2]);
       
       //Render both numbers as improper and unreduced fractions
       for (int k=0;k<2;k++){
           if (values[k][2]!=0){
               if (values[k][0]<0){
                   values[k][1]=(values[k][0]*values[k][2])-values[k][1];
                }
                else{
                    values[k][1]=values[k][1]+(values[k][0]*values[k][2]);
                }
               values[k][0]=0;
            }
            else{
               values[k][1]=values[k][0];
               values[k][2]=1;
            } 
        }
       
       // Perform raw calculations
       int [] results = new int [2];
       if (operator.contains("+")){
           results = add_subt(values);
        }
        else if (operator.contains("-")){
            values [1][1]=values[1][1]*(-1);
            results = add_subt(values);
        }
        else if (operator.contains("*")){
            results = mult_div(values);
        }
        else { //assume it is a divide
           int temp = values[1][2];
           values[1][2]= values[1][1];
           values[1][1]=temp;
           results= mult_div(values);
        }
        
        //pull out whole number
        results[0] = results[1]/results[2];
        results[1] = results[1] % results[2];
        if (results[1]<0){results[1] = results[1] * -1;} //Correct for stray negatives in num or denom
        if (results[2]<0){results[2] = results[2] * -1;}
       
        //reduce the fraction
        if (results[1] == 0){
            return Integer.toString(results[0]); // is just a whole number
        }
        if (results[2] < 0){ //negative in wrong place
            results[2] = results[2] * -1;
            results[1] = results[1] * -1;
        }
        if (results[1] < 0){ //fraction is negative
            results[0] = results[0] * -1;
            results[1] = results[1] * -1;
        }
        for (int i=2;i<= (1+results[1]/2);i++){ //Look for common denominators
                if ((results[1] % i == 0) && (results[2] % i == 0)){
                    results[1]=results[1]/i;
                    results[2]=results[2]/i;
                    i--;
                }
        }
        if (results[0] == 0){
            return results[1] + "/" + results[2];// There is no whole number portion
        }
        return results[0] + "_" + results[1] + "/" + results[2];
    }

// Returns string with operator, first fraction, second fraction strings
public static String[] parse_input(String input){
    String [] parsed = new String [3];
  
    for (int i=0;i<input.length();i++){
            if (input.charAt(i)=='+' || input.charAt(i)=='$' || input.charAt(i)=='*' || input.charAt(i)=='#'){
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
    
    //Special case: only a whole number
    if (!(input.contains("_") || (input.contains("/")))){
        values[0] = Integer.parseInt(input);
    }
    else{
  
        // First look for whole number
        if (input.contains("_")){
            values[0] = Integer.parseInt(input.substring(0,input.indexOf("_")));
            input = input.substring(input.indexOf("_")+1, input.length());
        }
        else{
            values [0]=0;
        }
        
        //Now look for fraction parts
        if (input.contains("/")){
            int i = input.indexOf("/");
            values[1] = Integer.parseInt(input.substring(0,i));
            values[2] = Integer.parseInt(input.substring(i+1,input.length()));
        }
        else{
            values [1]= 0;
            values [2]= 0;
        }
    }
return values;
}
public static int [] add_subt(int fractions[][]){
    int [] result = new int [3];
    fractions [0][1]=fractions [0][1]*fractions[1][2];
    fractions [1][1]=fractions [1][1]*fractions[0][2];
    result[1] = fractions [0][1]+fractions[1][1];
    result[2] = fractions[0][2]*fractions[1][2];
    return result;
}
public static int [] mult_div(int fractions[][]){
    int [] result = new int[3];
    result [1] = fractions [0][1]*fractions [1][1];
    result [2] = fractions [0][2]*fractions [1][2];
    return result;
}
}