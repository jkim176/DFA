package MyDFA;

class StateTransition{
   
   private char inputChar;
   private String source;
   private String target;
   
   StateTransition(char inputChar, String source, String target){
      
      this.inputChar = inputChar;
      this.source = source;
      this.target = target;
   }
   
   char getInputChar(){
      return inputChar;
   }
   
   String getSource(){
      return source;
   }
   
   String getTarget(){
      return target;
   }
   
   @Override
   public String toString(){
      return "At state " + source + " char " + inputChar + " targets state " + target;
   }
}
