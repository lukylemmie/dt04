package d4AcceptanceTests;
import design04.ChessThinker;
import design04.DeepTeal;

public class AcceptanceTest_Queen implements Test {

   public String toString () {
      return "testing queens";
   }

   public void run () {
      {
         String boardString = 
            "|  |  |  |  |  |  |kd|  |=\n" + 
            "|ql|  |  |  |  |  |  |  |=\n" + 
            "|  |  |  |  |  |  |  |  |=\n" +
            "|  |  |  |  |  |  |  |  |=\n" + 
            "|  |  |  |  |  |  |  |  |=\n" + 
            "|  |  |  |  |  |  |  |  |=\n" + 
            "|ql|  |  |  |  |  |  |  |=\n" + 
            "|kl|  |  |  |  |ql|  |ql|=\n";

         ChessThinker deepTeal = new DeepTeal(); 

         deepTeal.fromString (boardString);

         assert (boardString.equals (deepTeal.toString()));

         assert (deepTeal.blackIsInCheck());

         assert (deepTeal.blackIsInCheckMate());
      }

      {
         String boardString = 
            "|  |  |  |  |  |  |kd|  |=\n" + 
            "|ql|  |  |  |  |  |  |  |=\n" + 
            "|  |  |  |  |  |  |  |  |=\n" +
            "|pd|  |  |  |  |  |  |  |=\n" + 
            "|  |  |  |  |  |  |  |  |=\n" + 
            "|ql|  |  |  |  |  |  |  |=\n" + 
            "|  |  |  |  |  |  |  |  |=\n" + 
            "|kl|  |  |  |  |ql|  |ql|=\n";

         ChessThinker deepTeal = new DeepTeal(); 

         deepTeal.fromString (boardString);

         assert (boardString.equals (deepTeal.toString()));

         assert (!deepTeal.blackIsInCheck());

         assert (!deepTeal.blackIsInCheckMate());

         assert (deepTeal.whiteCanMateInOneMove());
 
         deepTeal.makeWhiteMateMove();

         // assert (deepTeal.blackIsInCheck()); 
         // commented out as this is NOT a legal test, black may be
         // not in check but forced to move into check next move 

         assert (deepTeal.blackIsInCheckMate());
      }
   }
}
