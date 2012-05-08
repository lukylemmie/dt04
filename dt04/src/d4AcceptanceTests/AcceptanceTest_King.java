package d4AcceptanceTests;
import design04.ChessThinker;
import design04.DeepTeal;

public class AcceptanceTest_King implements Test {

   public String toString () {
      return "testing kings";
   }

   public void run () {
      {
         String boardString = 
            "|  |  |  |  |  |  |kd|  |=\n" + 
            "|  |  |  |  |  |  |  |  |=\n" + 
            "|  |  |  |  |  |kl|  |  |=\n" +
            "|  |  |  |  |  |  |  |  |=\n" + 
            "|  |  |  |  |  |  |  |  |=\n" + 
            "|  |  |  |  |  |  |  |  |=\n" + 
            "|  |  |  |  |  |  |  |  |=\n" + 
            "|  |  |  |  |  |  |  |  |=\n";

         ChessThinker deepTeal = new DeepTeal(); 

         deepTeal.fromString (boardString);

         assert (boardString.equals (deepTeal.toString()));

         assert (!deepTeal.blackIsInCheck());

         assert (!deepTeal.blackIsInCheckMate());

         assert (!deepTeal.whiteCanMateInOneMove());
      }

      {
         String boardString = 
            "|  |  |  |  |  |  |  |kd|=\n" + 
            "|  |  |  |  |  |  |pl|  |=\n" + 
            "|  |  |  |  |  |  |  |  |=\n" +
            "|  |  |  |  |  |  |  |  |=\n" + 
            "|  |  |  |  |  |  |  |  |=\n" + 
            "|  |  |  |  |  |  |  |  |=\n" + 
            "|  |  |  |  |  |  |  |  |=\n" + 
            "|  |  |  |  |  |  |  |kl|=\n";

         ChessThinker deepTeal = new DeepTeal(); 

         deepTeal.fromString (boardString);

         assert (boardString.equals (deepTeal.toString()));
         assert (deepTeal.blackIsInCheck());
         assert (!deepTeal.blackIsInCheckMate());
         assert (!deepTeal.whiteCanMateInOneMove());
      }
   }
}
