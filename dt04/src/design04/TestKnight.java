package design04;

public class TestKnight {
    public static void main(String[] args) {
        boolean assess = true;
        System.out.println("White Knight:");
        assess &= test01();
        assess &= test02();
        assess &= test03();
        assess &= test04();
        System.out.println("Black Knight:");
        assess &= test05();
        assess &= test06();
        assess &= test07();
        assess &= test08();

        if (assess) {
            System.out.println("All tests passed! You are AWESOME!");
        }
    }

    private static boolean test01() {
        boolean pass = true;
        System.out.println("Test01 - Testing open board movement: ");

        String boardString =
                "|  |  |  |  |  |  |  |  |=\n" +
                        "|  |  |  |  |  |  |  |  |=\n" +
                        "|  |  |  |  |  |  |  |  |=\n" +
                        "|  |  |  |nl|  |  |  |  |=\n" +
                        "|  |  |  |  |  |  |  |  |=\n" +
                        "|  |  |  |  |  |  |  |  |=\n" +
                        "|  |  |  |  |  |  |  |  |=\n" +
                        "|  |  |  |  |  |  |  |  |=\n";
        boolean[] validArray =
                {false, false, false, false, false, false, false, false,
                        false, false, true, false, true, false, false, false,
                        false, true, false, false, false, true, false, false,
                        false, false, false, false, false, false, false, false,
                        false, true, false, false, false, true, false, false,
                        false, false, true, false, true, false, false, false,
                        false, false, false, false, false, false, false, false,
                        false, false, false, false, false, false, false, false};

        Board board = new Board(boardString);

        for (int i = 0; i < board.NUMBER_OF_SQUARES; i++) {
            if (!(board.getPosition(27).canMoveTo(i) == validArray[i])) {
                pass = false;
            }
        }

        if (pass) {
            System.out.println("Passed (pieceID: " + board.getPosition(27).pieceID() + ")");
        } else {
            System.out.println("Failed (pieceID: " + board.getPosition(27).pieceID() + ")");
        }
        return pass;
    }

    private static boolean test02() {
        boolean pass = true;
        System.out.println("Test02 - testing same colour obstacles: ");

        String boardString =
                "|  |  |  |  |  |  |  |  |=\n" +
                        "|  |bl|bl|bl|bl|bl|  |  |=\n" +
                        "|  |bl|rl|ql|rl|bl|  |  |=\n" +
                        "|  |bl|ql|nl|ql|bl|  |  |=\n" +
                        "|  |bl|rl|ql|rl|bl|  |  |=\n" +
                        "|  |bl|bl|bl|bl|bl|  |  |=\n" +
                        "|  |  |  |  |  |  |  |  |=\n" +
                        "|  |  |  |  |  |  |  |  |=\n";
        boolean[] validArray =
                {false, false, false, false, false, false, false, false,
                        false, false, false, false, false, false, false, false,
                        false, false, false, false, false, false, false, false,
                        false, false, false, false, false, false, false, false,
                        false, false, false, false, false, false, false, false,
                        false, false, false, false, false, false, false, false,
                        false, false, false, false, false, false, false, false,
                        false, false, false, false, false, false, false, false};

        Board board = new Board(boardString);

        for (int i = 0; i < board.NUMBER_OF_SQUARES; i++) {
            if (!(board.getPosition(27).canMoveTo(i) == validArray[i])) {
                pass = false;
            }
        }

        if (pass) {
            System.out.println("Passed (pieceID: " + board.getPosition(27).pieceID() + ")");
        } else {
            System.out.println("Failed (pieceID: " + board.getPosition(27).pieceID() + ")");
        }
        return pass;
    }

    private static boolean test03() {
        boolean pass = true;
        System.out.println("Test03 - testing off colour obstacles: ");

        String boardString =
                "|  |  |  |  |  |  |  |  |=\n" +
                        "|  |bd|bd|bd|bd|bd|  |  |=\n" +
                        "|  |bd|rd|qd|rd|bd|  |  |=\n" +
                        "|  |bd|qd|nl|qd|bd|  |  |=\n" +
                        "|  |bd|rd|qd|dr|bd|  |  |=\n" +
                        "|  |bd|bd|bd|bd|bd|  |  |=\n" +
                        "|  |  |  |  |  |  |  |  |=\n" +
                        "|  |  |  |  |  |  |  |  |=\n";
        boolean[] validArray =
                {false, false, false, false, false, false, false, false,
                        false, false, true, false, true, false, false, false,
                        false, true, false, false, false, true, false, false,
                        false, false, false, false, false, false, false, false,
                        false, true, false, false, false, true, false, false,
                        false, false, true, false, true, false, false, false,
                        false, false, false, false, false, false, false, false,
                        false, false, false, false, false, false, false, false};

        Board board = new Board(boardString);

        for (int i = 0; i < board.NUMBER_OF_SQUARES; i++) {
            if (!(board.getPosition(27).canMoveTo(i) == validArray[i])) {
                pass = false;
            }
        }

        if (pass) {
            System.out.println("Passed (pieceID: " + board.getPosition(27).pieceID() + ")");
        } else {
            System.out.println("Failed (pieceID: " + board.getPosition(27).pieceID() + ")");
        }
        return pass;
    }

    private static boolean test04() {
        boolean pass = true;
        System.out.println("Test04 - testing protected obstacles: ");

        String boardString =
                "|  |  |  |  |  |  |  |  |=\n" +
                        "|  |bl|bl|bl|bl|bl|  |  |=\n" +
                        "|  |bl|rl|ql|rl|bl|  |  |=\n" +
                        "|  |bl|ql|nl|ql|bl|  |  |=\n" +
                        "|  |bl|rl|ql|rl|bl|  |  |=\n" +
                        "|  |bl|bl|bl|bl|bl|  |  |=\n" +
                        "|  |  |  |  |  |  |  |  |=\n" +
                        "|  |  |  |  |  |  |  |  |=\n";
        boolean[] validArray =
                {false, false, false, false, false, false, false, false,
                        false, false, true, false, true, false, false, false,
                        false, true, false, false, false, true, false, false,
                        false, false, false, false, false, false, false, false,
                        false, true, false, false, false, true, false, false,
                        false, false, true, false, true, false, false, false,
                        false, false, false, false, false, false, false, false,
                        false, false, false, false, false, false, false, false};

        Board board = new Board(boardString);

        for (int i = 0; i < board.NUMBER_OF_SQUARES; i++) {
            if (!(board.getPosition(27).canCapture(i) == validArray[i])) {
                pass = false;
            }
        }

        if (pass) {
            System.out.println("Passed (pieceID: " + board.getPosition(27).pieceID() + ")");
        } else {
            System.out.println("Failed (pieceID: " + board.getPosition(27).pieceID() + ")");
        }
        return pass;
    }

    private static boolean test05() {
        boolean pass = true;
        System.out.println("Test05 - Testing open board movement: ");

        String boardString =
                "|  |  |  |  |  |  |  |  |=\n" +
                        "|  |  |  |  |  |  |  |  |=\n" +
                        "|  |  |  |  |  |  |  |  |=\n" +
                        "|  |  |  |nd|  |  |  |  |=\n" +
                        "|  |  |  |  |  |  |  |  |=\n" +
                        "|  |  |  |  |  |  |  |  |=\n" +
                        "|  |  |  |  |  |  |  |  |=\n" +
                        "|  |  |  |  |  |  |  |  |=\n";
        boolean[] validArray =
                {false, false, false, false, false, false, false, false,
                        false, false, true, false, true, false, false, false,
                        false, true, false, false, false, true, false, false,
                        false, false, false, false, false, false, false, false,
                        false, true, false, false, false, true, false, false,
                        false, false, true, false, true, false, false, false,
                        false, false, false, false, false, false, false, false,
                        false, false, false, false, false, false, false, false};

        Board board = new Board(boardString);

        for (int i = 0; i < board.NUMBER_OF_SQUARES; i++) {
            if (!(board.getPosition(27).canMoveTo(i) == validArray[i])) {
                pass = false;
            }
        }

        if (pass) {
            System.out.println("Passed (pieceID: " + board.getPosition(27).pieceID() + ")");
        } else {
            System.out.println("Failed (pieceID: " + board.getPosition(27).pieceID() + ")");
        }
        return pass;
    }

    private static boolean test06() {
        boolean pass = true;
        System.out.println("Test06 - testing same colour obstacles: ");

        String boardString =
                "|  |  |  |  |  |  |  |  |=\n" +
                        "|  |bd|bd|bd|bd|bd|  |  |=\n" +
                        "|  |bd|rd|qd|rd|bd|  |  |=\n" +
                        "|  |bd|qd|nd|qd|bd|  |  |=\n" +
                        "|  |bd|rd|qd|rd|bd|  |  |=\n" +
                        "|  |bd|bd|bd|bd|bd|  |  |=\n" +
                        "|  |  |  |  |  |  |  |  |=\n" +
                        "|  |  |  |  |  |  |  |  |=\n";
        boolean[] validArray =
                {false, false, false, false, false, false, false, false,
                        false, false, false, false, false, false, false, false,
                        false, false, false, false, false, false, false, false,
                        false, false, false, false, false, false, false, false,
                        false, false, false, false, false, false, false, false,
                        false, false, false, false, false, false, false, false,
                        false, false, false, false, false, false, false, false,
                        false, false, false, false, false, false, false, false};

        Board board = new Board(boardString);

        for (int i = 0; i < board.NUMBER_OF_SQUARES; i++) {
            if (!(board.getPosition(27).canMoveTo(i) == validArray[i])) {
                pass = false;
            }
        }

        if (pass) {
            System.out.println("Passed (pieceID: " + board.getPosition(27).pieceID() + ")");
        } else {
            System.out.println("Failed (pieceID: " + board.getPosition(27).pieceID() + ")");
        }
        return pass;
    }

    private static boolean test07() {
        boolean pass = true;
        System.out.println("Test07 - testing off colour obstacles: ");

        String boardString =
                "|  |  |  |  |  |  |  |  |=\n" +
                        "|  |bl|bl|bl|bl|bl|  |  |=\n" +
                        "|  |bl|rl|ql|rl|bl|  |  |=\n" +
                        "|  |bl|ql|nd|ql|bl|  |  |=\n" +
                        "|  |bl|rl|ql|rl|bl|  |  |=\n" +
                        "|  |bl|bl|bl|bl|bl|  |  |=\n" +
                        "|  |  |  |  |  |  |  |  |=\n" +
                        "|  |  |  |  |  |  |  |  |=\n";
        boolean[] validArray =
                {false, false, false, false, false, false, false, false,
                        false, false, true, false, true, false, false, false,
                        false, true, false, false, false, true, false, false,
                        false, false, false, false, false, false, false, false,
                        false, true, false, false, false, true, false, false,
                        false, false, true, false, true, false, false, false,
                        false, false, false, false, false, false, false, false,
                        false, false, false, false, false, false, false, false};

        Board board = new Board(boardString);

        for (int i = 0; i < board.NUMBER_OF_SQUARES; i++) {
            if (!(board.getPosition(27).canMoveTo(i) == validArray[i])) {
                pass = false;
            }
        }

        if (pass) {
            System.out.println("Passed (pieceID: " + board.getPosition(27).pieceID() + ")");
        } else {
            System.out.println("Failed (pieceID: " + board.getPosition(27).pieceID() + ")");
        }
        return pass;
    }

    private static boolean test08() {
        boolean pass = true;
        System.out.println("Test08 - testing protected obstacles: ");

        String boardString =
                "|  |  |  |  |  |  |  |  |=\n" +
                        "|  |bd|bd|bd|bd|bd|  |  |=\n" +
                        "|  |bd|rd|qd|rd|bd|  |  |=\n" +
                        "|  |bd|qd|nd|qd|bd|  |  |=\n" +
                        "|  |bd|rd|qd|rd|bd|  |  |=\n" +
                        "|  |bd|bd|bd|bd|bd|  |  |=\n" +
                        "|  |  |  |  |  |  |  |  |=\n" +
                        "|  |  |  |  |  |  |  |  |=\n";
        boolean[] validArray =
                {false, false, false, false, false, false, false, false,
                        false, false, true, false, true, false, false, false,
                        false, true, false, false, false, true, false, false,
                        false, false, false, false, false, false, false, false,
                        false, true, false, false, false, true, false, false,
                        false, false, true, false, true, false, false, false,
                        false, false, false, false, false, false, false, false,
                        false, false, false, false, false, false, false, false};

        Board board = new Board(boardString);

        for (int i = 0; i < board.NUMBER_OF_SQUARES; i++) {
            if (!(board.getPosition(27).canCapture(i) == validArray[i])) {
                pass = false;
            }
        }

        if (pass) {
            System.out.println("Passed (pieceID: " + board.getPosition(27).pieceID() + ")");
        } else {
            System.out.println("Failed (pieceID: " + board.getPosition(27).pieceID() + ")");
        }
        return pass;
    }
}
