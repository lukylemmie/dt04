package design04;

public class Pawn extends Piece {

    public Pawn(Board board, boolean colour, int position) {
        super(board, colour, position);


    }

    @Override
    public void updateMoves() {
        cleanMoves();
        checkMovement();
        checkCapture();
        movesUpdated = true;
    }

    private void checkMovement() {
        checkEdge(position);

        if (colour == WHITE && !onTopRow &&
                board.getPosition(position + board.MOVE_UP) == null) {
            validMoves[position + board.MOVE_UP] = true;
        }
        if (colour == BLACK && !onBottomRow &&
                board.getPosition(position + board.MOVE_DOWN) == null) {
            validMoves[position + board.MOVE_DOWN] = true;
        }
    }

    private void checkCapture() {
        checkEdge(position);

        if (colour == WHITE && !onTopRow) {
            if (!onLeftEdge) {
                validCapture[position + board.MOVE_UP_LEFT] = true;
                board.updateCaptureMoves(position + board.MOVE_UP_LEFT, colour);
            }
            if (!onRightEdge) {
                validCapture[position + board.MOVE_UP_RIGHT] = true;
                board.updateCaptureMoves(position + board.MOVE_UP_RIGHT, colour);
            }
            if (!onLeftEdge &&
                    board.getPosition(position + board.MOVE_UP_LEFT) != null &&
                    board.getPosition(position + board.MOVE_UP_LEFT).colour != colour) {
                validMoves[position + board.MOVE_UP_LEFT] = true;
            }
            if (!onRightEdge &&
                    board.getPosition(position + board.MOVE_UP_RIGHT) != null &&
                    board.getPosition(position + board.MOVE_UP_RIGHT).colour != colour) {
                validMoves[position + board.MOVE_UP_RIGHT] = true;
            }
        } else if (colour == BLACK && !onBottomRow) {
            if (!onLeftEdge) {
                validCapture[position + board.MOVE_DOWN_LEFT] = true;
                board.updateCaptureMoves(position + board.MOVE_DOWN_LEFT, colour);
            }
            if (!onRightEdge) {
                validCapture[position + board.MOVE_DOWN_RIGHT] = true;
                board.updateCaptureMoves(position + board.MOVE_DOWN_RIGHT, colour);
            }
            if (!onLeftEdge &&
                    board.getPosition(position + board.MOVE_DOWN_LEFT) != null &&
                    board.getPosition(position + board.MOVE_DOWN_LEFT).colour != colour) {
                validMoves[position + board.MOVE_DOWN_LEFT] = true;
            }
            if (!onRightEdge &&
                    board.getPosition(position + board.MOVE_DOWN_RIGHT) != null &&
                    board.getPosition(position + board.MOVE_DOWN_RIGHT).colour != colour) {
                validMoves[position + board.MOVE_DOWN_RIGHT] = true;
            }
        }
    }

    @Override
    public String pieceID() {
        String value;

        if (colour == WHITE) {
            value = "pl";
        } else {
            value = "pd";
        }

        return value;
    }

}
