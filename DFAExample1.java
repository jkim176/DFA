package MyDFA;

import java.util.Scanner;

public class DFAExample1{

   // DFA for RegularEx: 0*1* 
   public static void main(String[] args){
      Scanner input = new Scanner(System.in);
      
      DFA mDFA = new DFA();
      mDFA.addAcceptState("Q0");
      mDFA.addAcceptState("Q1");
      mDFA.addTransition('0', "Q0", "Q0");
      mDFA.addTransition('1', "Q0", "Q1");
      mDFA.addTransition('0', "Q1", "Q2");
      mDFA.addTransition('1', "Q1", "Q1");
      mDFA.addTransition('0', "Q2", "Q2");
      mDFA.addTransition('1', "Q2", "Q2");
      
      char stop = 'a';
      while(stop != 'x'){
         System.out.println("Enter a string of 0's and 1's.");
         String userString = input.next();
      
         mDFA.solve(userString);
         
         System.out.println("\nTo try another string, enter any key.  Enter x to quit.\n");
         String quitString = input.next();
         char quitChar = quitString.charAt(0);
         if(quitChar == 'x'){
            stop = 'x';
            System.out.println("Program has terminated.");
         }
      }
   }
}