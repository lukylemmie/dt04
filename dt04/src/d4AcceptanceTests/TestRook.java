package d4AcceptanceTests;
/**
 * design task 04 comp2911
 * @author richard buckland
 * @date may 2010
 */
import design04.ChessThinker;
import design04.DeepTeal;

public class TestRook implements Test {

   public String toString () {
      return "richard's rook tests";
   }

   public void run () { 
      {
         String game = 
            "|kd|  |  |  |  |  |  |rl|=\n"+
            "|  |  |  |  |  |  |  |  |=\n"+
            "|  |  |  |  |  |  |  |  |=\n"+
            "|  |  |  |  |  |  |  |  |=\n"+
            "|  |  |  |  |  |  |  |  |=\n"+
            "|  |  |  |  |  |  |  |  |=\n"+
            "|  |  |  |  |  |  |  |  |=\n"+
            "|  |  |  |  |  |kl|  |  |";
         
         ChessThinker ct = new DeepTeal (game);
         assert (ct.blackIsInCheck ());
         assert (!ct.blackIsInCheckMate ());
      }
      
      {
         String game = 
            "|kd|  |  |  |  |  |  |  |=\n"+
            "|  |rl|  |  |  |  |  |  |=\n"+
            "|  |  |kl|  |  |  |  |  |=\n"+
            "|  |  |  |  |  |  |  |  |=\n"+
            "|  |  |  |  |  |  |  |  |=\n"+
            "|  |  |  |  |  |  |  |  |=\n"+
            "|  |  |  |  |  |  |  |  |=\n"+
            "|  |  |  |  |  |  |  |  |";
         
         ChessThinker ct = new DeepTeal (game);
         assert (!ct.blackIsInCheck ());
         assert (ct.blackIsInCheckMate ());
      }
   }     
}
