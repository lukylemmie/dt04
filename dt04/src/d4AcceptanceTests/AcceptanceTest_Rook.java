package d4AcceptanceTests;
import design04.ChessThinker;
import design04.DeepTeal;

public class AcceptanceTest_Rook implements Test {

   public String toString () {
      return "testing rooks";
   }

   public void run () {
      {
         String boardString = 
            "|rl|  |  |  |  |  |kd|  |=\n" + 
            "|rl|  |  |  |  |  |  |  |=\n" + 
            "|  |  |  |  |  |  |  |  |=\n" +
            "|  |  |  |  |  |  |  |  |=\n" + 
            "|  |  |  |  |  |  |  |  |=\n" + 
            "|  |  |  |  |  |  |  |  |=\n" + 
            "|  |  |  |  |  |  |  |  |=\n" + 
            "|kl|  |  |  |  |rl|  |rl|=\n";

         ChessThinker deepTeal = new DeepTeal(); 

         deepTeal.fromString (boardString);

         assert (boardString.equals (deepTeal.toString()));

         assert (deepTeal.blackIsInCheck());

         assert (deepTeal.blackIsInCheckMate());
      }

      {
         String boardString = 
            "|  |  |  |  |  |  |kd|  |=\n" + 
            "|rl|rl|  |  |  |  |  |  |=\n" + 
            "|  |  |  |  |  |  |  |  |=\n" +
            "|  |  |  |  |  |  |  |  |=\n" + 
            "|pd|  |  |  |  |  |  |  |=\n" + 
            "|  |  |  |  |  |  |  |  |=\n" + 
            "|  |  |  |  |  |  |  |  |=\n" + 
            "|kl|  |  |  |  |rl|  |rl|=\n";

         ChessThinker deepTeal = new DeepTeal(); 

         deepTeal.fromString (boardString);

         assert (boardString.equals (deepTeal.toString()));

         assert (!deepTeal.blackIsInCheck());

         assert (!deepTeal.blackIsInCheckMate());

         assert (deepTeal.whiteCanMateInOneMove());
 
         deepTeal.makeWhiteMateMove();

         assert (deepTeal.blackIsInCheckMate());
      }
   }
}
