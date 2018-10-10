package MyDFA;

import java.util.Scanner;
import java.util.regex.Pattern;

public class DFAExample1{

   // DFA for RegularEx: 0*1* 
   public static void main(String[] args){
      Scanner input = new Scanner(System.in);
      
      DFA mDFA = new DFA();      // construct DFA
      mDFA.addAcceptState("Q0");
      mDFA.addAcceptState("Q1");
      mDFA.addTransition('0', "Q0", "Q0");
      mDFA.addTransition('1', "Q0", "Q1");
      mDFA.addTransition('0', "Q1", "Q2");
      mDFA.addTransition('1', "Q1", "Q1");
      mDFA.addTransition('0', "Q2", "Q2");
      mDFA.addTransition('1', "Q2", "Q2");
      
      String userString;
      boolean restart = true;
      while(restart){      // program restart loop
         System.out.println("Enter a string of 0's and 1's: ");
         
         boolean validString = false;
         while(!validString){    // verify valid string loop
            userString = input.next();
            if(Pattern.matches("[01]*", userString)){  // verify user string has only 0's and 1's
               validString = true;
               mDFA.solve(userString);    // solve the DFA
            }
            else{
               input.nextLine();    // clear input
               System.out.println("Re-enter a string of 0's and 1's: ");
            }
         }    
         
         System.out.println("To restart, press any key.  To exit, enter 0.");
         String restartString = input.next();
         if(restartString.charAt(0) == '0'){
            restart = false;
            System.out.println("Program has terminated. ");
         }
         else
            input.nextLine();
      }
   }
}
