package design04v2;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;

public class Board {
    public final static boolean WHITE = Piece.WHITE;
    public final static boolean BLACK = Piece.BLACK;

    // if the board is being used for move calculation, don't load the images
    private boolean prime = false;

    // dimensions of the board, currently configured for a square of 8x8
    public final static int BOARD_SIZE = 8;
    public final static int DIMENSION = BOARD_SIZE + 2; // + 2 for boarders
    public final static int NUMBER_OF_SQUARES = BOARD_SIZE * BOARD_SIZE;
    public final static int ARRAY_SIZE = DIMENSION * DIMENSION;
    public final static int FIRST_POSITION = DIMENSION + 1;

    // edge values required for a 1D array
    public final static int LEFT_EDGE = 0;
    public final static int RIGHT_EDGE = DIMENSION - 1;
    public final static int MOVE_UP = -DIMENSION;
    public final static int MOVE_LEFT = -1;
    public final static int MOVE_RIGHT = 1;
    public final static int MOVE_DOWN = DIMENSION;
    public final static int MOVE_UP_LEFT = MOVE_UP + MOVE_LEFT;
    public final static int MOVE_UP_RIGHT = MOVE_UP + MOVE_RIGHT;
    public final static int MOVE_DOWN_LEFT = MOVE_DOWN + MOVE_LEFT;
    public final static int MOVE_DOWN_RIGHT = MOVE_DOWN + MOVE_RIGHT;

    // array of white and black capture moves (all squares guarded by
    // white/black pieces respectively)
    // this minor increase in board intelligence makes calculating DeepTeal
    // strategies a lot simpler
    private boolean[] whiteCaptureMoves = new boolean[ARRAY_SIZE];
    private boolean[] blackCaptureMoves = new boolean[ARRAY_SIZE];

    // marks the edges of the board
    private boolean[] boardEdge = new boolean[ARRAY_SIZE];

    // pointer to white and black kings
    private Piece whiteKing;
    private Piece blackKing;

    // end game flags
    private boolean whiteKingTaken = false;
    private boolean blackKingTaken = false;

    // array of pieces - the virtual board
    private Piece[] board = new Piece[ARRAY_SIZE];

    // creates a board from a string
    public Board(String boardString) {
        String[] inputBoard = new String[NUMBER_OF_SQUARES];
        List<String> listInputBoard = new ArrayList<String>();

        //marks the edges of the board
        markEdge();

        // read the string into a 1d array of piece IDs
        boardString = boardString.substring(1);
        inputBoard = boardString.split("[|][=]*[\n]*[|]*");

        for (int i = 0; i < NUMBER_OF_SQUARES; i++) {
            listInputBoard.add(inputBoard[i]);
        }

        // insert the pieces into the board
        for (int i = 0; listInputBoard.size() > 0; i++) {
            while (onBoardEdge(i)) {
                i++;
            }
            insertPiece(i, listInputBoard.remove(0));
        }

        // warning message if no black king was inserted
        if (blackKing == null) {
            System.out.println("WARNING: No black king detected!");
        }

        // gets all the pieces to update their valid moves
        updateAll();
    }

    // separate constructor for a board used by DeepTealPrime for iterations
    // faster because it doesn't need to load images
    public Board(String boardString, boolean prime) {
        //prime flag informs pieces not to load images
        this.prime = prime;
        String[] inputBoard = new String[NUMBER_OF_SQUARES];
        List<String> listInputBoard = new ArrayList<String>();

        //marks the edges of the board
        markEdge();

        // read the string into a 1d array of piece IDs
        boardString = boardString.substring(1);
        inputBoard = boardString.split("[|][=]*[\n]*[|]*");

        for (int i = 0; i < NUMBER_OF_SQUARES; i++) {
            listInputBoard.add(inputBoard[i]);
        }

        // insert the pieces into the board
        for (int i = 0; listInputBoard.size() > 0; i++) {
            while (onBoardEdge(i)) {
                i++;
            }
            insertPiece(i, listInputBoard.remove(0));
        }

        // warning message if no black king was inserted
        if (blackKing == null) {
            System.out.println("WARNING: No black king detected!");
        }

        // gets all the pieces to update their valid moves
        updateAll();
    }

    // return prime flag
    public boolean checkPrime() {
        return prime;
    }

    // fills in the edge boolean array
    public void markEdge() {
        for (int i = 0; i < ARRAY_SIZE; i++) {
            if (i % DIMENSION == LEFT_EDGE || i % DIMENSION == RIGHT_EDGE || i < DIMENSION || i >= ARRAY_SIZE - DIMENSION) {
                boardEdge[i] = true;
            } else {
                boardEdge[i] = false;
            }
        }
    }

    public boolean onBoardEdge(int position) {
        return boardEdge[position];
    }

    // the draw function
    public void draw() {
        JFrame f = new JFrame("Chess Position");

        f.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });

        f.add(new DrawBoard(this));
        f.pack();
        f.setVisible(true);
    }

    public boolean isWhiteKingTaken() {
        return whiteKingTaken;
    }

    public boolean isBlackKingTaken() {
        return blackKingTaken;
    }

    public Piece getWhiteKing() {
        return whiteKing;
    }

    public Piece getBlackKing() {
        return blackKing;
    }

    public boolean canWhiteCapture(int position) {
        return whiteCaptureMoves[position];
    }

    public boolean canBlackCapture(int position) {
        return blackCaptureMoves[position];
    }

    // generates string of the board
    public String toString() {
        int squareCount = 0;
        String boardString = "";

        for (int i = 0; squareCount < NUMBER_OF_SQUARES; i++) {
            while (onBoardEdge(i)) {
                i++;
            }
            if (board[i] != null) {
                boardString += "|" + board[i].pieceID();
                squareCount++;
            } else {
                boardString += "|  ";
                squareCount++;
            }
            if (squareCount % BOARD_SIZE == 0) {
                boardString += "|=\n";
            }
        }

        return boardString;
    }

    // function to insert the pieces into the board
    public void insertPiece(int position, String piece) {
        boolean colour = WHITE;
        if (piece.charAt(1) == 'd') {
            colour = BLACK;
        } else if (piece.charAt(1) == 'l') {
            colour = WHITE;
        }

        if (piece.charAt(0) == 'b') {
            board[position] = new Bishop(this, colour, position);
        } else if (piece.charAt(0) == 'n') {
            board[position] = new Knight(this, colour, position);
        } else if (piece.charAt(0) == 'p') {
            board[position] = new Pawn(this, colour, position);
        } else if (piece.charAt(0) == 'q') {
            board[position] = new Queen(this, colour, position);
        } else if (piece.charAt(0) == 'r') {
            board[position] = new Rook(this, colour, position);
        } else if (piece.charAt(0) == 'k') {
            board[position] = new King(this, colour, position);
            if (colour == WHITE) {
                if (whiteKing != null) {
                    System.out.println("WARNING: Multiple white kings detected!");
                }
                whiteKing = board[position];
            } else {
                if (blackKing != null) {
                    System.out.println("WARNING: Multiple black kings detected!");
                }
                blackKing = board[position];
            }
        }
    }

    // returns a piece from the position
    public Piece getPosition(int position) {
        return board[position];
    }

    // function to clean the capture moves arrays
    public void cleanCapture() {
        for (int i = 0; i < ARRAY_SIZE; i++) {
            whiteCaptureMoves[i] = false;
            blackCaptureMoves[i] = false;
        }
    }

    // function used by pieces to update the capture moves array
    public void updateCaptureMoves(int position, boolean colour) {
        if (colour == WHITE) {
            whiteCaptureMoves[position] = true;
        } else {
            blackCaptureMoves[position] = true;
        }
    }

    // moves a piece, used by DeepTeal to iterate various positions
    public void movePiece(int from, int to) {
        if (!onBoardEdge(to) && board[from].canMoveTo(to)) {
            if (board[to] != null) {
                if (board[to].pieceID() == "kd") {
                    blackKingTaken = true;
                }
                if (board[to].pieceID() == "kl") {
                    whiteKingTaken = true;
                }
            }

            board[to] = board[from];
            board[from] = null;
            board[to].setPosition(to);
            updateAll();
        } else {
            System.out.println("ERROR: Invalid Move! " + board[from].pieceID() + " (" + from + " to " + to + ")");
        }
    }

    // tells all the pieces to update their moves
    private void updateAll() {
        cleanCapture();
        for (int i = 0; i < ARRAY_SIZE; i++) {
            if (board[i] != null) {
                board[i].updateMoves();
            }
        }
    }
}
