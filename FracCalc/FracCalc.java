  
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
        // this function produces the solution to the input
        
        // Find and convert / as operator to # to remove ambiguity
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
       //TODO : remoove for final.
       System.out.println("first whole: " + values[0][0]+ ", first numer: " + values[0][1]+ ", first denom: " + values  [0][2]);
       System.out.println("second whole: " + values[1][0]+ ", 2nd numer: " + values[1][1]+ ", 2nd denom: " + values  [1][2]);
       
       //Render both numbers as improper and unreduced fractions
       for (int k=0;k<2;k++){
           if (values[k][2]!=0){
               values[k][1]=values[k][1]+(values[k][0]*values[k][2]);
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
        
         //temporary print out. remove in final
        System.out.println("whole =" + results[0] + "; numer = " + results [1] + "; denom = " + results [2]);
        
        //TODO: reduce the fraction

        return "";
    }

     // This is driver for writing test routines
    public static void tester(){
        int [][] number = new int [3][3];
        int []result = new int [3];
        number [0][1]= 5;
        number [0][2]= 8;
        number [1][1]= 6;
        number [1][2]= 16;
        result = add_subt(number);
        System.out.println(result[0] + "..." + result[1] + "..." + result[2]);
        
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
            System.out.println(input);
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