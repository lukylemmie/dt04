package design04;

public class TestBoard {
    public static void main(String[] args) {
        boolean assess = true;
        System.out.println("Testing toString(): ");
        assess &= test01();
        System.out.println("Testing whiteCaptureMoves: ");
        assess &= test02();
        System.out.println("Testing blackCaptureMoves: ");
        assess &= test03();
        System.out.println("Testing whiteCaptureMoves2: ");
        assess &= test04();
        System.out.println("Testing blackCaptureMoves2: ");
        assess &= test05();
//		assess &= test06();
//		assess &= test07();
//		assess &= test08();

        if (assess) {
            System.out.println("All tests passed! You are AWESOME!");
        }
    }

    public static boolean test01() {
        boolean pass = false;
        String printTest;

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

        printTest = board.toString();

        if (printTest.equals(boardString)) {
            pass = true;
        } else {
            pass = false;
        }

        if (pass) {
            System.out.println("Passed");
        } else {
            System.out.println("Failed");
        }
        return pass;
    }

    private static boolean test02() {
        boolean pass = true;

        String boardString =
                "|  |  |  |  |  |  |  |  |=\n" +
                        "|  |  |  |  |  |  |  |  |=\n" +
                        "|  |  |  |  |  |  |  |  |=\n" +
                        "|  |  |  |ql|  |  |  |  |=\n" +
                        "|  |  |  |  |  |  |  |  |=\n" +
                        "|  |  |  |  |  |  |  |  |=\n" +
                        "|  |  |  |  |  |  |  |  |=\n" +
                        "|  |  |  |  |  |  |  |  |=\n";
        boolean[] validArray =
                {true, false, false, true, false, false, true, false,
                        false, true, false, true, false, true, false, false,
                        false, false, true, true, true, false, false, false,
                        true, true, true, false, true, true, true, true,
                        false, false, true, true, true, false, false, false,
                        false, true, false, true, false, true, false, false,
                        true, false, false, true, false, false, true, false,
                        false, false, false, true, false, false, false, true};

        Board board = new Board(boardString);

        for (int i = 0; i < board.NUMBER_OF_SQUARES; i++) {
            if (!(board.canWhiteCapture(i) == validArray[i])) {
                pass = false;
            }
        }

        if (pass) {
            System.out.println("Passed");
        } else {
            System.out.println("Failed");
        }
        return pass;
    }

    private static boolean test03() {
        boolean pass = true;

        String boardString =
                "|  |  |  |  |  |  |  |  |=\n" +
                        "|  |  |  |  |  |  |  |  |=\n" +
                        "|  |  |  |  |  |  |  |  |=\n" +
                        "|  |  |  |qd|  |  |  |  |=\n" +
                        "|  |  |  |  |  |  |  |  |=\n" +
                        "|  |  |  |  |  |  |  |  |=\n" +
                        "|  |  |  |  |  |  |  |  |=\n" +
                        "|  |  |  |  |  |  |  |  |=\n";
        boolean[] validArray =
                {true, false, false, true, false, false, true, false,
                        false, true, false, true, false, true, false, false,
                        false, false, true, true, true, false, false, false,
                        true, true, true, false, true, true, true, true,
                        false, false, true, true, true, false, false, false,
                        false, true, false, true, false, true, false, false,
                        true, false, false, true, false, false, true, false,
                        false, false, false, true, false, false, false, true};

        Board board = new Board(boardString);

        for (int i = 0; i < board.NUMBER_OF_SQUARES; i++) {
            if (!(board.canBlackCapture(i) == validArray[i])) {
                pass = false;
            }
        }

        if (pass) {
            System.out.println("Passed");
        } else {
            System.out.println("Failed");
        }
        return pass;
    }

    private static boolean test04() {
        boolean pass = true;

        String boardString =
                "|  |  |  |  |  |  |  |  |=\n" +
                        "|  |  |  |pl|  |  |  |  |=\n" +
                        "|  |  |  |  |  |  |  |  |=\n" +
                        "|  |  |kl|ql|kd|  |  |  |=\n" +
                        "|  |  |  |nl|  |  |  |  |=\n" +
                        "|  |  |  |  |  |  |  |  |=\n" +
                        "|  |  |  |  |  |  |pd|  |=\n" +
                        "|  |  |  |  |  |  |  |  |=\n";
        boolean[] validArray =
                {true, false, true, false, true, false, true, false,
                        false, true, false, true, false, true, false, false,
                        false, true, true, true, true, false, false, false,
                        false, true, true, true, true, true, false, false,
                        false, true, true, true, true, false, false, false,
                        false, true, false, false, false, true, false, false,
                        true, false, true, false, true, false, true, false,
                        false, false, false, false, false, false, false, false};

        Board board = new Board(boardString);

        for (int i = 0; i < board.NUMBER_OF_SQUARES; i++) {
            if (!(board.canWhiteCapture(i) == validArray[i])) {
                pass = false;
                System.out.println();
                System.out.println("Failing piece 1 at " + i + ":");
            }
        }

        if (pass) {
            System.out.println("Passed");
        } else {
            System.out.println("Failed");
        }
        return pass;
    }

    private static boolean test05() {
        boolean pass = true;

        String boardString =
                "|  |  |  |  |  |  |  |  |=\n" +
                        "|  |  |  |pl|  |  |  |  |=\n" +
                        "|  |  |  |  |  |  |  |  |=\n" +
                        "|  |  |kl|ql|kd|  |  |  |=\n" +
                        "|  |  |  |nl|  |  |  |  |=\n" +
                        "|  |  |  |  |  |  |  |  |=\n" +
                        "|  |  |  |  |  |  |pd|  |=\n" +
                        "|  |  |  |  |  |  |  |  |=\n";
        boolean[] validArray =
                {false, false, false, false, false, false, false, false,
                        false, false, false, false, false, false, false, false,
                        false, false, false, true, true, true, false, false,
                        false, false, false, true, false, true, false, false,
                        false, false, false, true, true, true, false, false,
                        false, false, false, false, false, false, false, false,
                        false, false, false, false, false, false, false, false,
                        false, false, false, false, false, true, false, true};

        Board board = new Board(boardString);

        for (int i = 0; i < board.NUMBER_OF_SQUARES; i++) {
            if (!(board.canBlackCapture(i) == validArray[i])) {
                pass = false;
            }
        }

        if (pass) {
            System.out.println("Passed");
        } else {
            System.out.println("Failed");
        }
        return pass;
    }
}
