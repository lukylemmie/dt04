package d4AcceptanceTests;

import design04.ChessThinker;
import design04.DeepTeal;

/**
 * design task 04 comp2911
 * @author richard buckland
 * @date may 2010
 */
public class TestQueen  implements Test {

   public String toString () {
      return "richard's queen tests";
   }

   public void run () { 
      {
         String game = 
            "|kd|  |  |  |  |  |  |ql|=\n"+
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
            "|  |ql|  |  |  |  |  |  |=\n"+
            "|  |  |kl|  |  |  |  |  |=\n"+
            "|  |  |  |  |  |  |  |  |=\n"+
            "|  |  |  |  |  |  |  |  |=\n"+
            "|  |  |  |  |  |  |  |  |=\n"+
            "|  |  |  |  |  |  |  |  |=\n"+
            "|  |  |  |  |  |  |  |  |";
         
         ChessThinker ct = new DeepTeal (game);
         assert (ct.blackIsInCheck ());
         assert (ct.blackIsInCheckMate ());
      }
      
      
      
   }
}
