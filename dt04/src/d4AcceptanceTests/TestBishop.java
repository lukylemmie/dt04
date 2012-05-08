package d4AcceptanceTests;

import design04.ChessThinker;
import design04.DeepTeal;

/**
 * design task 04 comp2911
 * @author richard buckland
 * @date may 2010
 */
public class TestBishop implements Test {

   public String toString () {
      return "richard's bishop tests";
   }

   public void run () {
         
         {
            String game = 
               "|kd|  |  |  |  |  |  |bl|=\n"+
               "|  |  |  |  |  |  |  |  |=\n"+
               "|  |  |  |  |  |  |  |  |=\n"+
               "|  |  |  |  |  |  |  |  |=\n"+
               "|  |  |  |  |  |  |  |  |=\n"+
               "|  |  |  |  |  |  |  |  |=\n"+
               "|  |  |  |  |  |  |  |  |=\n"+
               "|  |  |  |  |  |kl|  |  |";
            
            ChessThinker ct = new DeepTeal (game);
            assert (!ct.blackIsInCheck ());
            assert (!ct.blackIsInCheckMate ());
         }
         
         {
            String game = 
               "|kd|  |  |  |  |  |  |  |=\n"+
               "|  |  |  |  |  |  |  |  |=\n"+
               "|  |  |kl|  |  |  |  |  |=\n"+
               "|  |  |  |bl|  |  |  |  |=\n"+
               "|  |  |  |  |  |  |  |  |=\n"+
               "|  |  |  |  |  |  |  |  |=\n"+
               "|  |  |  |  |  |  |  |  |=\n"+
               "|  |  |  |  |  |  |  |  |";
            
            ChessThinker ct = new DeepTeal (game);
            assert (!ct.blackIsInCheck ());
            assert (!ct.blackIsInCheckMate ());
       } 
         
      {
            String game = 
               "|kd|  |  |  |  |  |  |  |=\n"+
               "|  |  |  |  |  |  |  |  |=\n"+
               "|kl|  |  |bl|  |  |  |  |=\n"+
               "|  |  |  |bl|  |  |  |  |=\n"+
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
