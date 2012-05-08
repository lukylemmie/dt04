package design04;

public class Knight extends Piece {

    public Knight(Board board, boolean colour, int position) {
        super(board, colour, position);
        moveLimit = true;
    }

    @Override
    public void updateMoves() {
        int positionPrime;
        cleanMoves();

        checkEdge(position);
        if (!onTopRow) {
            positionPrime = position + board.MOVE_UP;
            checkDirection(positionPrime, board.MOVE_UP_LEFT, moveLimit);
            checkDirection(positionPrime, board.MOVE_UP_RIGHT, moveLimit);
        }
        checkEdge(position);
        if (!onBottomRow) {
            positionPrime = position + board.MOVE_DOWN;
            checkDirection(positionPrime, board.MOVE_DOWN_LEFT, moveLimit);
            checkDirection(positionPrime, board.MOVE_DOWN_RIGHT, moveLimit);
        }
        checkEdge(position);
        if (!onLeftEdge) {
            positionPrime = position + board.MOVE_LEFT;
            checkDirection(positionPrime, board.MOVE_UP_LEFT, moveLimit);
            checkDirection(positionPrime, board.MOVE_DOWN_LEFT, moveLimit);
        }
        checkEdge(position);
        if (!onRightEdge) {
            positionPrime = position + board.MOVE_RIGHT;
            checkDirection(positionPrime, board.MOVE_UP_RIGHT, moveLimit);
            checkDirection(positionPrime, board.MOVE_DOWN_RIGHT, moveLimit);
        }

        movesUpdated = true;
    }

    @Override
    public String pieceID() {
        String value;

        if (colour == WHITE) {
            value = "nl";
        } else {
            value = "nd";
        }

        return value;
    }

}
