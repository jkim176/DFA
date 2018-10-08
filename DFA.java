package MyDFA;

import java.util.ArrayList;
import java.lang.StringBuilder;

class DFA{
   
   private ArrayList<StateTransition> stateTransitions = new ArrayList<>();
   private ArrayList<String> acceptStates = new ArrayList<>();
   private ArrayList<String> stateSequence = new ArrayList<>();
   
   DFA(){   // all DFA's start state = "Q0"
      stateSequence.add("Q0");
   }
   
   void addAcceptState(String state){
      acceptStates.add(state);
   }
   
   void addTransition(char inputChar, String source, String target){    // add transition to state
      stateTransitions.add(new StateTransition(inputChar, source, target));
   }
   
   StringBuilder getStateSequence(){    // returns state sequence as a string
      StringBuilder result = new StringBuilder("");
      for(int i = 0; i < stateSequence.size(); i++){
         if(i == stateSequence.size() - 1)
            result.append(stateSequence.get(i));
         else
            result.append(stateSequence.get(i) + ", ");
      }
      return result;
   }
   
   String findTarget(char mChar, String mState){      // find target state, using char and current state
      String target = "";
      for(int i = 0; i < stateTransitions.size(); i++){
         StateTransition current = stateTransitions.get(i);
         if(current.getInputChar() == mChar && current.getSource() == mState){
            target = current.getTarget();
            break;
         }
      }
      return target;
   }
   
   void solve(String input){
      
      for(int i = 0; i < input.length(); i++){    // read all char in input String; add target state to state sequence
         char currentChar = input.charAt(i);
         String currentState = stateSequence.get(i);
         
         String currentTarget = findTarget(currentChar, currentState);
         stateSequence.add(currentTarget);
      }
      
      int lastIndex = stateSequence.size() - 1;
      if(acceptStates.contains(stateSequence.get(lastIndex)))
         System.out.println("The string " + input + " is accepted.");
      else
         System.out.println("The string " + input + " is rejected.");
      System.out.println("The state sequence for input " + input + ": \n" + getStateSequence());
      stateSequence.clear();
      stateSequence.add("Q0");
   }
}