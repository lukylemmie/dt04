package design04v2;

import java.awt.*;
import java.awt.image.*;
import java.io.*;
import javax.imageio.*;

public class DrawBoard extends Component {
    Board board;
    BufferedImage boardImg;

    public void paint(Graphics g) {
        final int BASE_X = 34;
        final int BASE_Y = 33;
        final int SQUARE = 29;

        Piece aPiece;
        int x;
        int y;

        g.drawImage(boardImg, 0, 0, null);

        for (int i = 0; i < Board.NUMBER_OF_SQUARES; i++) {
            aPiece = board.getPosition(i);
            if (aPiece != null) {
                x = SQUARE * (i % Board.DIMENSION) + BASE_X;
                y = SQUARE * (i / Board.DIMENSION) + BASE_Y;
                g.drawImage(aPiece.getImg(), x, y, null);
            }
        }
    }

    public DrawBoard(Board board) {
        this.board = board;
        try {
            boardImg = ImageIO.read(new File("chessPics/chess_board.gif"));
        } catch (IOException e) {
        }

    }

    public Dimension getPreferredSize() {
        if (boardImg == null) {
            return new Dimension(100, 100);
        } else {
            return new Dimension(boardImg.getWidth(null), boardImg.getHeight(null));
        }
    }
}
