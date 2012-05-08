package design04v2;

public class Bishop extends Piece {
    public Bishop(Board board, boolean colour, int position) {
        super(board, colour, position);
        moveLimit = false;
    }

    @Override
    public void updateMoves() {
        cleanMoves();
        checkDirection(position, Board.MOVE_UP_LEFT, moveLimit);
        checkDirection(position, Board.MOVE_UP_RIGHT, moveLimit);
        checkDirection(position, Board.MOVE_DOWN_LEFT, moveLimit);
        checkDirection(position, Board.MOVE_DOWN_RIGHT, moveLimit);
        movesUpdated = true;
    }

    @Override
    public String pieceID() {
        String value;

        if (colour == WHITE) {
            value = "bl";
        } else {
            value = "bd";
        }

        return value;
    }

}
