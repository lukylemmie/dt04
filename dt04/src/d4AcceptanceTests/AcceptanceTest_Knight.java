package d4AcceptanceTests;
import design04.ChessThinker;
import design04.DeepTeal;

public class AcceptanceTest_Knight implements Test {

   public String toString () {
      return "testing knights";
   }

   public void run () {
      {
         String boardString = 
            "|  |  |  |  |  |  |kd|  |=\n" + 
            "|  |  |  |  |  |  |  |  |=\n" + 
            "|  |  |  |  |  |nl|  |  |=\n" +
            "|  |  |  |  |  |  |  |  |=\n" + 
            "|  |  |  |  |  |  |  |  |=\n" + 
            "|  |  |  |  |  |  |  |  |=\n" + 
            "|  |  |  |  |  |  |  |  |=\n" + 
            "|  |  |kl|  |  |  |  |  |=\n";

         ChessThinker deepTeal = new DeepTeal(); 

         deepTeal.fromString (boardString);

         assert (boardString.equals (deepTeal.toString()));

         assert (deepTeal.blackIsInCheck());

         assert (!deepTeal.blackIsInCheckMate());

         assert (!deepTeal.whiteCanMateInOneMove());
      }

      {
         String boardString = 
            "|  |  |nl|  |  |  |kd|  |=\n" + 
            "|  |  |  |  |  |  |  |  |=\n" + 
            "|  |  |  |  |nl|  |nl|  |=\n" +
            "|  |  |  |  |nl|  |nl|  |=\n" + 
            "|  |  |  |  |  |  |  |  |=\n" + 
            "|  |  |  |  |  |  |  |  |=\n" + 
            "|  |  |  |  |  |  |  |  |=\n" + 
            "|  |  |kl|  |  |  |  |  |=\n";

         ChessThinker deepTeal = new DeepTeal(); 

         deepTeal.fromString (boardString);

         assert (boardString.equals (deepTeal.toString()));

         assert (!deepTeal.blackIsInCheck());

         assert (deepTeal.whiteCanMateInOneMove());

         deepTeal.makeWhiteMateMove();

         assert (deepTeal.blackIsInCheckMate());
      }
   }
}
