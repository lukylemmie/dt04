package design04;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;

public abstract class Piece {
    public final static boolean WHITE = true;
    public final static boolean BLACK = false;
    protected final Board board;
    protected final boolean colour;

    protected int position;
    protected boolean moveLimit;
    protected boolean movesUpdated = false;
    protected boolean[] validMoves;
    protected boolean[] validCapture;
    protected boolean onLeftEdge;
    protected boolean onRightEdge;
    protected boolean onTopRow;
    protected boolean onBottomRow;
    protected BufferedImage img = null;

    public Piece(Board board, boolean colour, int position) {

        this.colour = colour;
        this.position = position;
        this.board = board;

        validMoves = new boolean[board.NUMBER_OF_SQUARES];
        validCapture = new boolean[board.NUMBER_OF_SQUARES];

        if (!board.checkPrime()) {
            try {
                img = ImageIO.read(new File("chessPics/" + pieceID() + ".png"));
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }

        cleanMoves();
    }

    public BufferedImage getImg() {
        return img;
    }

    public List<Integer> getValidMoves() {
        List<Integer> validMovesList = new ArrayList<Integer>();

        for (int i = 0; i < board.NUMBER_OF_SQUARES; i++) {
            if (validMoves[i]) {
                validMovesList.add(i);
            }
        }

        return validMovesList;
    }

    public void resetMovesUpdated() {
        movesUpdated = false;
    }

    public boolean canMoveTo(int position) {
        if (!movesUpdated) {
            updateMoves();
        }

        return validMoves[position];
    }

    public boolean canCapture(int position) {
        if (!movesUpdated) {
            updateMoves();
        }

        return validCapture[position];
    }

    protected void cleanMoves() {
        for (int i = 0; i < validMoves.length; i++) {
            validMoves[i] = false;
            validCapture[i] = false;
        }
        movesUpdated = false;
    }

    public boolean getColour() {
        return colour;
    }

    public int getPosition() {
        return position;
    }

    // checks if position prime is on the edge
    public void checkEdge(int positionPrime) {
        if (positionPrime % board.DIMENSION == board.LEFT_EDGE) {
            onLeftEdge = true;
        } else {
            onLeftEdge = false;
        }
        if (positionPrime % board.DIMENSION == board.RIGHT_EDGE) {
            onRightEdge = true;
        } else {
            onRightEdge = false;
        }
        if (positionPrime < board.DIMENSION) {
            onTopRow = true;
        } else {
            onTopRow = false;
        }
        if (positionPrime >= board.NUMBER_OF_SQUARES - board.DIMENSION) {
            onBottomRow = true;
        } else {
            onBottomRow = false;
        }
    }

    public void checkDirection(int positionPrime, int direction, boolean limit) {
        boolean edgeValid = true;

        checkEdge(positionPrime);
        // if moving up + left, can't be on left edge or top row
        if ((direction == board.MOVE_UP_LEFT && (onLeftEdge || onTopRow))
                // if moving up, can't be on top row
                || (direction == board.MOVE_UP && onTopRow)
                // if moving up + right, can't be on right edge or top row
                || (direction == board.MOVE_UP_RIGHT && (onTopRow || onRightEdge))
                // if moving left, can't be on left edge
                || (direction == board.MOVE_LEFT && onLeftEdge)
                // if moving right, can't be on right edge
                || (direction == board.MOVE_RIGHT && onRightEdge)
                // if moving down + left, can't be on left edge or bottom row
                || (direction == board.MOVE_DOWN_LEFT && (onLeftEdge || onBottomRow))
                // if moving down, can't be on bottom row
                || (direction == board.MOVE_DOWN && onBottomRow)
                // if moving down + right, can't be on bottom row or right edge
                || (direction == board.MOVE_DOWN_RIGHT && (onBottomRow || onRightEdge))) {
            edgeValid = false;
        }

        if (edgeValid) {
            // if not stepping off the edge check next position in direction
            positionPrime += direction;
            // set next position as a valid capture position
            validCapture[positionPrime] = true;
            // update the board array for capture moves
            board.updateCaptureMoves(positionPrime, colour);
            // if no piece is there, keep iterating
            if (board.getPosition(positionPrime) == null) {
                validMoves[positionPrime] = true;
                if (!limit) {
                    checkDirection(positionPrime, direction, limit);
                }
                // if there is a piece there, check the colour
            } else if (board.getPosition(positionPrime).getColour() != colour) {
                // if a different colour, the move is valid
                validMoves[positionPrime] = true;
            }
        }
    }

    public abstract void updateMoves();

    public abstract String pieceID();

    public void setPosition(int positionPrime) {
        position = positionPrime;
    }
}
