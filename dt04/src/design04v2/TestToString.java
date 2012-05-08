package design04v2;

public class TestToString {
    public static void main(String[] args) {
        String boardString =
                "|rd|nd|bd|qd|kd|bd|nd|rd|=\n" +
                        "|pd|pd|pd|  |  |pd|pd|pd|=\n" +
                        "|  |  |  |  |pd|  |  |  |=\n" +
                        "|  |  |  |pd|  |  |  |  |=\n" +
                        "|  |  |pl|pl|  |  |  |  |=\n" +
                        "|  |  |  |  |  |  |  |  |=\n" +
                        "|pl|pl|  |  |  |  |pl|pl|=\n" +
                        "|rl|nl|bl|ql|kl|bl|nl|rl|=\n";
        Board board = new Board(boardString);

        Pawn whitePawn = new Pawn(board, true, 0);
        Pawn blackPawn = new Pawn(board, false, 0);
        Rook whiteRook = new Rook(board, true, 0);
        Rook blackRook = new Rook(board, false, 0);
        Knight whiteKnight = new Knight(board, true, 0);
        Knight blackKnight = new Knight(board, false, 0);
        Bishop whiteBishop = new Bishop(board, true, 0);
        Bishop blackBishop = new Bishop(board, false, 0);
        Queen whiteQueen = new Queen(board, true, 0);
        Queen blackQueen = new Queen(board, false, 0);
        King whiteKing = new King(board, true, 0);
        King blackKing = new King(board, false, 0);

        System.out.println("WhitePawn: " + whitePawn.toString());
        System.out.println("BlackPawn: " + blackPawn.toString());
        System.out.println("WhiteRook: " + whiteRook.toString());
        System.out.println("BlackRook: " + blackRook.toString());
        System.out.println("WhiteKnight: " + whiteKnight.toString());
        System.out.println("BlackKnight: " + blackKnight.toString());
        System.out.println("whiteBishop: " + whiteBishop.toString());
        System.out.println("blackBishop: " + blackBishop.toString());
        System.out.println("whiteQueen: " + whiteQueen.toString());
        System.out.println("blackQueen: " + blackQueen.toString());
        System.out.println("whiteKing: " + whiteKing.toString());
        System.out.println("blackKing: " + blackKing.toString());
    }
}
