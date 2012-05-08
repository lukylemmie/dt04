package design04;

import java.util.List;

public class DeepTeal implements ChessThinker {
    private final static boolean DEBUG = false;

    private Board board;
    private Piece blackKing;
    private Piece whiteKing;

    private int checkmatePiecePosition;
    private int checkmateMove;

    // used for giving a "true checkmate" precedence over a stalemate
    private boolean stalemateFound = false;
    private boolean stalemateStored = false;
    private int stalematePiecePosition;
    private int stalemateMove;

    // boolean for image loading, allows for faster iterations
    private boolean prime = false;

    public DeepTeal() {

    }

    public DeepTeal(String game) {
        fromString(game);
    }

    // construct used for iterations, images won't be loaded into the pieces
    public DeepTeal(String game, boolean prime) {
        this.prime = prime;
        board = new Board(game, prime);
    }

    // returns a string representation of the board state
    @Override
    public void fromString(String boardString) {
        board = new Board(boardString);
    }


    public void setStalemateFound(boolean found) {
        stalemateFound = found;
    }

    public boolean getStalemateFound() {
        return stalemateFound;
    }

    // is black in check?
    @Override
    public boolean blackIsInCheck() {
        boolean inCheck = false;

        // get black king piece
        blackKing = board.getBlackKing();

        // if not null
        if (blackKing == null) {
            System.out.println("ERROR: Black King not found! Check not possible!");

            // is white attacking that square?
        } else if (board.canWhiteCapture(blackKing.getPosition())) {
            inCheck = true;
        }

        return inCheck;
    }

    // similar function for "is white in check?"
    public boolean whiteIsInCheck() {
        boolean inCheck = false;

        whiteKing = board.getWhiteKing();

        if (whiteKing != null && board.canBlackCapture(whiteKing.getPosition())) {
            inCheck = true;
        }

        return inCheck;
    }

    // is black in check mate?
    @Override
    public boolean blackIsInCheckMate() {
        boolean checkmate = true;

        // confirmed flag for early exit
        boolean confirmed = false;
        boolean stalemate = false;
        Piece aPiece = null;
        List<Integer> validMovesList;
        DeepTeal deepTealPrime;
        int count = 0;

        // can't be check mate if white king is in check
        if (whiteIsInCheck()) {
            checkmate = false;
            confirmed = true;
        }

        // stalemate flag, black king not in check
        if (!blackIsInCheck()) {
            stalemate = true;
        }

        // iterate through all of black's pieces
        for (int i = 0; (i < board.NUMBER_OF_SQUARES && !confirmed); i++) {
            aPiece = board.getPosition(i);
            // find a black piece
            if (aPiece != null && aPiece.getColour() == Board.BLACK) {
                // get list of valid moves for the black piece
                validMovesList = aPiece.getValidMoves();
                // check a black move has been found
                count++;
                // while a valid move that hasn't been tried exists
                while (validMovesList.size() > 0) {
                    // create a new DeepTeal to iterate on
                    deepTealPrime = new DeepTeal(board.toString(), true);
                    // test the move
                    deepTealPrime.makeMove(i, validMovesList.remove(0));
                    // if black is no longer in check, it is not checkmate
                    if (!deepTealPrime.blackIsInCheck()) {
                        checkmate = false;
                        confirmed = true;
                    }
                }
            }
        }

        // if no black pieces exist then can't be checkmate because black king gone?
        if (count == 0) {
            checkmate = false;
            confirmed = true;
        }

        if (checkmate && stalemate) {
            stalemateFound = true;
        }

        return checkmate;
    }

    // can white check mate in one move?
    @Override
    public boolean whiteCanMateInOneMove() {
        boolean checkmate = false;
        boolean confirmed = false;
        Piece aPiece = null;
        List<Integer> validMovesList;
        DeepTeal deepTealPrime;
        int positionPrime;

        // iterate through whites pieces
        for (int i = 0; (i < board.NUMBER_OF_SQUARES && !confirmed); i++) {
            aPiece = board.getPosition(i);
            // find a white piece
            if (aPiece != null && aPiece.getColour() == Board.WHITE) {
                // get the valid moves of the piece
                validMovesList = aPiece.getValidMoves();
                // iterate through the valid moves
                while (validMovesList.size() > 0) {
                    if (DEBUG) {
                        System.out.println("MoveList size: " + validMovesList.size());
                    }
                    // create a new DeepTeal to iterate through
                    deepTealPrime = new DeepTeal(board.toString(), true);
                    // trial the move
                    deepTealPrime.makeMove(i, (positionPrime = validMovesList.remove(0)));
                    if (DEBUG) {
                        System.out.println("Move: " + i + " to " + positionPrime + " id: " + aPiece.pieceID());
                    }
                    deepTealPrime.setStalemateFound(false);
                    // check that black is in checkmate
                    if (deepTealPrime.blackIsInCheckMate()) {
                        if (!deepTealPrime.getStalemateFound()) {
                            checkmate = true;
                            confirmed = true;
                            checkmatePiecePosition = i;
                            checkmateMove = positionPrime;
                        } else {
                            // check for stalemate
                            stalematePiecePosition = i;
                            stalemateMove = positionPrime;
                            stalemateStored = true;
                        }
                    }
                }
            }
        }

        // if no checkmate move was found but a stalemate move was found, use
        // that one instead
        if (!checkmate && stalemateStored) {
            checkmate = true;
            checkmatePiecePosition = stalematePiecePosition;
            checkmateMove = stalemateMove;
            System.out.println("WARNING: This is a Stalemate move!");
        }

        if (DEBUG) {
            System.out.println("Winning move: " + checkmatePiecePosition + " to " + checkmateMove);
        }

        return checkmate;
    }

    // make the white move checkmate
    @Override
    public void makeWhiteMateMove() {
        if (DEBUG) {
            System.out.println("Winning move: " + checkmatePiecePosition + " to " + checkmateMove);
        }
        board.movePiece(checkmatePiecePosition, checkmateMove);
    }

    // get a string of the board
    public String toString() {
        return board.toString();
    }

    // make a move on the board
    public void makeMove(int from, int to) {
        board.movePiece(from, to);
    }

    // graphically show board
    public void show() {
        if (!prime) {
            board.draw();
        }
    }
}
