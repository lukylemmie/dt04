package design04;
public interface ChessThinker {

      /**
       * sets the configuration of the board to match the input string.  This replaces 
       * the previous configuration (if any). The "configuration" of a board means the 
       * collection of pieces not yet taken and their locations. 
       * @param boardString a string representing the new configuration of the board 
       * (in Design04 format)
       */
      public void fromString (String boardString);
     
      /**
       * If it were White's move now could White take the Black King?
       */
      public boolean blackIsInCheck();

      /**
       * If it were Black's move now, is there no move Black can make which will prevent White 
       * from taking the Black king next move?
       */
      public boolean blackIsInCheckMate();

      /**
       * If it were White's move now, is there a move Which can make which will immediately 
       * place Black in checkmate?
       */
       public boolean whiteCanMateInOneMove();

       
       /**
        * If White can mate in one move, make that move.  This function should only be called if
        * White can mate in one move.  Its behaviour is undefined otherwise.
        */
      public void makeWhiteMateMove();

      /**
       * Return a String representing the current configuration of the board.
       * 
       * The string is in Design04 format.
       */
      public String toString();
   }