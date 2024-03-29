package design04v2;

public class TestEdge {
    public static void main(String[] args) {
        boolean assess = true;
        System.out.println("Knights:");
        assess &= test01();
        System.out.println("Kings:");
        assess &= test02();
        System.out.println("Bishops:");
        assess &= test03();
        System.out.println("Queens:");
        assess &= test04();
        System.out.println("Rooks:");
        assess &= test05();
        System.out.println("Pawns:");
        assess &= test06();

        if (assess) {
            System.out.println("All tests passed! You are AWESOME!");
        }
    }

    private static boolean[] convertArray(boolean[] input) {
        boolean[] output = new boolean[Board.ARRAY_SIZE];
        int pointer = 0;

        for (int i = 0; i < Board.ARRAY_SIZE; i++) {
            if (i % Board.DIMENSION == Board.LEFT_EDGE || i % Board.DIMENSION == Board.RIGHT_EDGE ||
                    i < Board.DIMENSION || i >= Board.ARRAY_SIZE - Board.DIMENSION) {
                output[i] = false;
            } else {
                output[i] = input[pointer];
                pointer++;
            }
        }

        return output;
    }

    private static boolean test01() {
        boolean pass = true;
        System.out.println("Test01 - testing edge cases: ");

        String boardString =
                "|  |  |  |nl|  |  |  |  |=\n" +
                        "|  |  |  |  |  |  |  |  |=\n" +
                        "|  |  |  |  |  |  |  |  |=\n" +
                        "|  |  |  |  |  |  |  |nd|=\n" +
                        "|nl|  |  |  |  |  |  |  |=\n" +
                        "|  |  |  |  |  |  |  |  |=\n" +
                        "|  |  |  |  |  |  |  |  |=\n" +
                        "|  |  |  |  |nd|  |  |  |=\n";
        boolean[] validArray1 =
                {false, false, false, false, false, false, false, false,
                        false, true, false, false, false, true, false, false,
                        false, false, true, false, true, false, false, false,
                        false, false, false, false, false, false, false, false,
                        false, false, false, false, false, false, false, false,
                        false, false, false, false, false, false, false, false,
                        false, false, false, false, false, false, false, false,
                        false, false, false, false, false, false, false, false};

        boolean[] validArray2 =
                {false, false, false, false, false, false, false, false,
                        false, false, false, false, false, false, true, false,
                        false, false, false, false, false, true, false, false,
                        false, false, false, false, false, false, false, false,
                        false, false, false, false, false, true, false, false,
                        false, false, false, false, false, false, true, false,
                        false, false, false, false, false, false, false, false,
                        false, false, false, false, false, false, false, false};

        boolean[] validArray3 =
                {false, false, false, false, false, false, false, false,
                        false, false, false, false, false, false, false, false,
                        false, true, false, false, false, false, false, false,
                        false, false, true, false, false, false, false, false,
                        false, false, false, false, false, false, false, false,
                        false, false, true, false, false, false, false, false,
                        false, true, false, false, false, false, false, false,
                        false, false, false, false, false, false, false, false};

        boolean[] validArray4 =
                {false, false, false, false, false, false, false, false,
                        false, false, false, false, false, false, false, false,
                        false, false, false, false, false, false, false, false,
                        false, false, false, false, false, false, false, false,
                        false, false, false, false, false, false, false, false,
                        false, false, false, true, false, true, false, false,
                        false, false, true, false, false, false, true, false,
                        false, false, false, false, false, false, false, false};

        validArray1 = convertArray(validArray1);
        validArray2 = convertArray(validArray2);
        validArray3 = convertArray(validArray3);
        validArray4 = convertArray(validArray4);
        Board board = new Board(boardString);

        for (int i = 0; i < Board.NUMBER_OF_SQUARES; i++) {
            if (!(board.getPosition(14).canMoveTo(i) == validArray1[i])) {
                pass = false;
            }
        }

        for (int i = 0; i < Board.NUMBER_OF_SQUARES; i++) {
            if (!(board.getPosition(48).canMoveTo(i) == validArray2[i])) {
                pass = false;
            }
        }

        for (int i = 0; i < Board.NUMBER_OF_SQUARES; i++) {
            if (!(board.getPosition(51).canMoveTo(i) == validArray3[i])) {
                pass = false;
            }
        }

        for (int i = 0; i < Board.NUMBER_OF_SQUARES; i++) {
            if (!(board.getPosition(85).canMoveTo(i) == validArray4[i])) {
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

    private static boolean test02() {
        boolean pass = true;
        System.out.println("Test02 - testing edge cases: ");

        String boardString =
                "|  |  |  |kl|  |  |  |  |=\n" +
                        "|  |  |  |  |  |  |  |  |=\n" +
                        "|  |  |  |  |  |  |  |  |=\n" +
                        "|  |  |  |  |  |  |  |kd|=\n" +
                        "|kl|  |  |  |  |  |  |  |=\n" +
                        "|  |  |  |  |  |  |  |  |=\n" +
                        "|  |  |  |  |  |  |  |  |=\n" +
                        "|  |  |  |  |kd|  |  |  |=\n";
        boolean[] validArray1 =
                {false, false, true, false, true, false, false, false,
                        false, false, true, true, true, false, false, false,
                        false, false, false, false, false, false, false, false,
                        false, false, false, false, false, false, false, false,
                        false, false, false, false, false, false, false, false,
                        false, false, false, false, false, false, false, false,
                        false, false, false, false, false, false, false, false,
                        false, false, false, false, false, false, false, false};

        boolean[] validArray2 =
                {false, false, false, false, false, false, false, false,
                        false, false, false, false, false, false, false, false,
                        false, false, false, false, false, false, true, true,
                        false, false, false, false, false, false, true, false,
                        false, false, false, false, false, false, true, true,
                        false, false, false, false, false, false, false, false,
                        false, false, false, false, false, false, false, false,
                        false, false, false, false, false, false, false, false};

        boolean[] validArray3 =
                {false, false, false, false, false, false, false, false,
                        false, false, false, false, false, false, false, false,
                        false, false, false, false, false, false, false, false,
                        true, true, false, false, false, false, false, false,
                        false, true, false, false, false, false, false, false,
                        true, true, false, false, false, false, false, false,
                        false, false, false, false, false, false, false, false,
                        false, false, false, false, false, false, false, false};

        boolean[] validArray4 =
                {false, false, false, false, false, false, false, false,
                        false, false, false, false, false, false, false, false,
                        false, false, false, false, false, false, false, false,
                        false, false, false, false, false, false, false, false,
                        false, false, false, false, false, false, false, false,
                        false, false, false, false, false, false, false, false,
                        false, false, false, true, true, true, false, false,
                        false, false, false, true, false, true, false, false};

        validArray1 = convertArray(validArray1);
        validArray2 = convertArray(validArray2);
        validArray3 = convertArray(validArray3);
        validArray4 = convertArray(validArray4);
        Board board = new Board(boardString);

        for (int i = 0; i < Board.NUMBER_OF_SQUARES; i++) {
            if (!(board.getPosition(14).canMoveTo(i) == validArray1[i])) {
                pass = false;
            }
        }

        for (int i = 0; i < Board.NUMBER_OF_SQUARES; i++) {
            if (!(board.getPosition(48).canMoveTo(i) == validArray2[i])) {
                pass = false;
            }
        }

        for (int i = 0; i < Board.NUMBER_OF_SQUARES; i++) {
            if (!(board.getPosition(51).canMoveTo(i) == validArray3[i])) {
                pass = false;
            }
        }

        for (int i = 0; i < Board.NUMBER_OF_SQUARES; i++) {
            if (!(board.getPosition(85).canMoveTo(i) == validArray4[i])) {
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
        System.out.println("Test03 - testing edge cases: ");

        String boardString =
                "|  |  |  |bl|  |  |  |  |=\n" +
                        "|  |  |  |  |  |  |  |  |=\n" +
                        "|  |  |  |  |  |  |  |  |=\n" +
                        "|  |  |  |  |  |  |  |bd|=\n" +
                        "|bl|  |  |  |  |  |  |  |=\n" +
                        "|  |  |  |  |  |  |  |  |=\n" +
                        "|  |  |  |  |  |  |  |  |=\n" +
                        "|  |  |  |  |bd|  |  |  |=\n";
        boolean[] validArray1 =
                {false, false, false, false, false, false, false, false,
                        false, false, true, false, true, false, false, false,
                        false, true, false, false, false, true, false, false,
                        true, false, false, false, false, false, true, false,
                        false, false, false, false, false, false, false, true,
                        false, false, false, false, false, false, false, false,
                        false, false, false, false, false, false, false, false,
                        false, false, false, false, false, false, false, false};

        boolean[] validArray2 =
                {false, false, false, false, true, false, false, false,
                        false, false, false, false, false, true, false, false,
                        false, false, false, false, false, false, true, false,
                        false, false, false, false, false, false, false, false,
                        false, false, false, false, false, false, true, false,
                        false, false, false, false, false, true, false, false,
                        false, false, false, false, true, false, false, false,
                        false, false, false, true, false, false, false, false};

        boolean[] validArray3 =
                {false, false, false, false, true, false, false, false,
                        false, false, false, true, false, false, false, false,
                        false, false, true, false, false, false, false, false,
                        false, true, false, false, false, false, false, false,
                        false, false, false, false, false, false, false, false,
                        false, true, false, false, false, false, false, false,
                        false, false, true, false, false, false, false, false,
                        false, false, false, true, false, false, false, false};

        boolean[] validArray4 =
                {false, false, false, false, false, false, false, false,
                        false, false, false, false, false, false, false, false,
                        false, false, false, false, false, false, false, false,
                        true, false, false, false, false, false, false, false,
                        false, true, false, false, false, false, false, true,
                        false, false, true, false, false, false, true, false,
                        false, false, false, true, false, true, false, false,
                        false, false, false, false, false, false, false, false};

        validArray1 = convertArray(validArray1);
        validArray2 = convertArray(validArray2);
        validArray3 = convertArray(validArray3);
        validArray4 = convertArray(validArray4);
        Board board = new Board(boardString);

        for (int i = 0; i < Board.NUMBER_OF_SQUARES; i++) {
            if (!(board.getPosition(14).canMoveTo(i) == validArray1[i])) {
                pass = false;
            }
        }

        for (int i = 0; i < Board.NUMBER_OF_SQUARES; i++) {
            if (!(board.getPosition(48).canMoveTo(i) == validArray2[i])) {
                pass = false;
            }
        }

        for (int i = 0; i < Board.NUMBER_OF_SQUARES; i++) {
            if (!(board.getPosition(51).canMoveTo(i) == validArray3[i])) {
                pass = false;
            }
        }

        for (int i = 0; i < Board.NUMBER_OF_SQUARES; i++) {
            if (!(board.getPosition(85).canMoveTo(i) == validArray4[i])) {
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
        System.out.println("Test04 - testing edge cases: ");

        String boardString =
                "|  |  |  |ql|  |  |  |  |=\n" +
                        "|  |  |  |  |  |  |  |  |=\n" +
                        "|  |  |  |  |  |  |  |  |=\n" +
                        "|  |  |  |  |  |  |  |qd|=\n" +
                        "|ql|  |  |  |  |  |  |  |=\n" +
                        "|  |  |  |  |  |  |  |  |=\n" +
                        "|  |  |  |  |  |  |  |  |=\n" +
                        "|  |  |  |  |qd|  |  |  |=\n";
        boolean[] validArray1 =
                {true, true, true, false, true, true, true, true,
                        false, false, true, true, true, false, false, false,
                        false, true, false, true, false, true, false, false,
                        true, false, false, true, false, false, true, false,
                        false, false, false, true, false, false, false, true,
                        false, false, false, true, false, false, false, false,
                        false, false, false, true, false, false, false, false,
                        false, false, false, true, false, false, false, false};

        boolean[] validArray2 =
                {false, false, false, false, true, false, false, true,
                        false, false, false, false, false, true, false, true,
                        false, false, false, false, false, false, true, true,
                        true, true, true, true, true, true, true, false,
                        false, false, false, false, false, false, true, true,
                        false, false, false, false, false, true, false, true,
                        false, false, false, false, true, false, false, true,
                        false, false, false, true, false, false, false, true};

        boolean[] validArray3 =
                {true, false, false, false, true, false, false, false,
                        true, false, false, true, false, false, false, false,
                        true, false, true, false, false, false, false, false,
                        true, true, false, false, false, false, false, false,
                        false, true, true, true, true, true, true, true,
                        true, true, false, false, false, false, false, false,
                        true, false, true, false, false, false, false, false,
                        true, false, false, true, false, false, false, false};

        boolean[] validArray4 =
                {false, false, false, false, true, false, false, false,
                        false, false, false, false, true, false, false, false,
                        false, false, false, false, true, false, false, false,
                        true, false, false, false, true, false, false, false,
                        false, true, false, false, true, false, false, true,
                        false, false, true, false, true, false, true, false,
                        false, false, false, true, true, true, false, false,
                        true, true, true, true, false, true, true, true};

        validArray1 = convertArray(validArray1);
        validArray2 = convertArray(validArray2);
        validArray3 = convertArray(validArray3);
        validArray4 = convertArray(validArray4);
        Board board = new Board(boardString);

        for (int i = 0; i < Board.NUMBER_OF_SQUARES; i++) {
            if (!(board.getPosition(14).canMoveTo(i) == validArray1[i])) {
                pass = false;
            }
        }

        for (int i = 0; i < Board.NUMBER_OF_SQUARES; i++) {
            if (!(board.getPosition(48).canMoveTo(i) == validArray2[i])) {
                pass = false;
            }
        }

        for (int i = 0; i < Board.NUMBER_OF_SQUARES; i++) {
            if (!(board.getPosition(51).canMoveTo(i) == validArray3[i])) {
                pass = false;
            }
        }

        for (int i = 0; i < Board.NUMBER_OF_SQUARES; i++) {
            if (!(board.getPosition(85).canMoveTo(i) == validArray4[i])) {
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

    private static boolean test05() {
        boolean pass = true;
        System.out.println("Test05 - testing edge cases: ");

        String boardString =
                "|  |  |  |rl|  |  |  |  |=\n" +
                        "|  |  |  |  |  |  |  |  |=\n" +
                        "|  |  |  |  |  |  |  |  |=\n" +
                        "|  |  |  |  |  |  |  |rd|=\n" +
                        "|rl|  |  |  |  |  |  |  |=\n" +
                        "|  |  |  |  |  |  |  |  |=\n" +
                        "|  |  |  |  |  |  |  |  |=\n" +
                        "|  |  |  |  |rd|  |  |  |=\n";
        boolean[] validArray1 =
                {true, true, true, false, true, true, true, true,
                        false, false, false, true, false, false, false, false,
                        false, false, false, true, false, false, false, false,
                        false, false, false, true, false, false, false, false,
                        false, false, false, true, false, false, false, false,
                        false, false, false, true, false, false, false, false,
                        false, false, false, true, false, false, false, false,
                        false, false, false, true, false, false, false, false};

        boolean[] validArray2 =
                {false, false, false, false, false, false, false, true,
                        false, false, false, false, false, false, false, true,
                        false, false, false, false, false, false, false, true,
                        true, true, true, true, true, true, true, false,
                        false, false, false, false, false, false, false, true,
                        false, false, false, false, false, false, false, true,
                        false, false, false, false, false, false, false, true,
                        false, false, false, false, false, false, false, true};

        boolean[] validArray3 =
                {true, false, false, false, false, false, false, false,
                        true, false, false, false, false, false, false, false,
                        true, false, false, false, false, false, false, false,
                        true, false, false, false, false, false, false, false,
                        false, true, true, true, true, true, true, true,
                        true, false, false, false, false, false, false, false,
                        true, false, false, false, false, false, false, false,
                        true, false, false, false, false, false, false, false};

        boolean[] validArray4 =
                {false, false, false, false, true, false, false, false,
                        false, false, false, false, true, false, false, false,
                        false, false, false, false, true, false, false, false,
                        false, false, false, false, true, false, false, false,
                        false, false, false, false, true, false, false, false,
                        false, false, false, false, true, false, false, false,
                        false, false, false, false, true, false, false, false,
                        true, true, true, true, false, true, true, true};

        validArray1 = convertArray(validArray1);
        validArray2 = convertArray(validArray2);
        validArray3 = convertArray(validArray3);
        validArray4 = convertArray(validArray4);
        Board board = new Board(boardString);

        for (int i = 0; i < Board.NUMBER_OF_SQUARES; i++) {
            if (!(board.getPosition(14).canMoveTo(i) == validArray1[i])) {
                pass = false;
                System.out.println();
                System.out.println("Failing piece 1 at " + i + ":");
            }
        }

        for (int i = 0; i < Board.NUMBER_OF_SQUARES; i++) {
            if (!(board.getPosition(48).canMoveTo(i) == validArray2[i])) {
                pass = false;
                System.out.println();
                System.out.println("Failing piece 2 at " + i + ":");
            }
        }

        for (int i = 0; i < Board.NUMBER_OF_SQUARES; i++) {
            if (!(board.getPosition(51).canMoveTo(i) == validArray3[i])) {
                pass = false;
                System.out.println();
                System.out.println("Failing piece 14 at " + i + ":");
            }
        }

        for (int i = 0; i < Board.NUMBER_OF_SQUARES; i++) {
            if (!(board.getPosition(85).canMoveTo(i) == validArray4[i])) {
                pass = false;
                System.out.println();
                System.out.println("Failing piece 15 at " + i + ":");
            }
        }

        if (pass) {
            System.out.println("Passed");
        } else {
            System.out.println("Failed");
        }
        return pass;
    }

    private static boolean test06() {
        boolean pass = true;
        System.out.println("Test06 - testing edge cases: ");

        String boardString =
                "|  |  |  |pd|pl|  |  |  |=\n" +
                        "|pd|  |  |  |  |  |  |pl|=\n" +
                        "|  |  |  |  |  |  |  |  |=\n" +
                        "|  |  |  |  |  |  |  |pd|=\n" +
                        "|pl|  |  |  |  |  |  |  |=\n" +
                        "|  |  |  |  |  |  |  |  |=\n" +
                        "|  |  |  |  |  |  |  |  |=\n" +
                        "|  |  |  |pl|pd|  |  |  |=\n";
        boolean[] validArray1 =
                {false, false, false, false, false, false, false, false,
                        false, false, false, true, false, false, false, false,
                        false, false, false, false, false, false, false, false,
                        false, false, false, false, false, false, false, false,
                        false, false, false, false, false, false, false, false,
                        false, false, false, false, false, false, false, false,
                        false, false, false, false, false, false, false, false,
                        false, false, false, false, false, false, false, false};

        boolean[] validArray2 =
                {false, false, false, false, false, false, false, false,
                        false, false, false, false, false, false, false, false,
                        false, false, false, false, false, false, false, false,
                        false, false, false, false, false, false, false, false,
                        false, false, false, false, false, false, false, false,
                        false, false, false, false, false, false, false, false,
                        false, false, false, false, false, false, false, false,
                        false, false, false, false, false, false, false, false};

        boolean[] validArray3 =
                {false, false, false, false, false, false, false, false,
                        false, false, false, false, false, false, false, false,
                        true, false, false, false, false, false, false, false,
                        false, false, false, false, false, false, false, false,
                        false, false, false, false, false, false, false, false,
                        false, false, false, false, false, false, false, false,
                        false, false, false, false, false, false, false, false,
                        false, false, false, false, false, false, false, false};

        boolean[] validArray4 =
                {false, false, false, false, false, false, false, true,
                        false, false, false, false, false, false, false, false,
                        false, false, false, false, false, false, false, false,
                        false, false, false, false, false, false, false, false,
                        false, false, false, false, false, false, false, false,
                        false, false, false, false, false, false, false, false,
                        false, false, false, false, false, false, false, false,
                        false, false, false, false, false, false, false, false};

        boolean[] validArray5 =
                {false, false, false, false, false, false, false, false,
                        false, false, false, false, false, false, false, false,
                        false, false, false, false, false, false, false, false,
                        false, false, false, false, false, false, false, false,
                        false, false, false, false, false, false, false, true,
                        false, false, false, false, false, false, false, false,
                        false, false, false, false, false, false, false, false,
                        false, false, false, false, false, false, false, false};

        boolean[] validArray6 =
                {false, false, false, false, false, false, false, false,
                        false, false, false, false, false, false, false, false,
                        false, false, false, false, false, false, false, false,
                        true, false, false, false, false, false, false, false,
                        false, false, false, false, false, false, false, false,
                        false, false, false, false, false, false, false, false,
                        false, false, false, false, false, false, false, false,
                        false, false, false, false, false, false, false, false};

        boolean[] validArray7 =
                {false, false, false, false, false, false, false, false,
                        false, false, false, false, false, false, false, false,
                        false, false, false, false, false, false, false, false,
                        false, false, false, false, false, false, false, false,
                        false, false, false, false, false, false, false, false,
                        false, false, false, false, false, false, false, false,
                        false, false, false, true, false, false, false, false,
                        false, false, false, false, false, false, false, false};

        boolean[] validArray8 =
                {false, false, false, false, false, false, false, false,
                        false, false, false, false, false, false, false, false,
                        false, false, false, false, false, false, false, false,
                        false, false, false, false, false, false, false, false,
                        false, false, false, false, false, false, false, false,
                        false, false, false, false, false, false, false, false,
                        false, false, false, false, false, false, false, false,
                        false, false, false, false, false, false, false, false};

        validArray1 = convertArray(validArray1);
        validArray2 = convertArray(validArray2);
        validArray3 = convertArray(validArray3);
        validArray4 = convertArray(validArray4);
        validArray5 = convertArray(validArray5);
        validArray6 = convertArray(validArray6);
        validArray7 = convertArray(validArray7);
        validArray8 = convertArray(validArray8);
        Board board = new Board(boardString);

        for (int i = 0; i < Board.NUMBER_OF_SQUARES; i++) {
            if (!(board.getPosition(14).canMoveTo(i) == validArray1[i])) {
                pass = false;
            }
        }

        for (int i = 0; i < Board.NUMBER_OF_SQUARES; i++) {
            if (!(board.getPosition(15).canMoveTo(i) == validArray2[i])) {
                pass = false;
            }
        }

        for (int i = 0; i < Board.NUMBER_OF_SQUARES; i++) {
            if (!(board.getPosition(21).canMoveTo(i) == validArray3[i])) {
                pass = false;
            }
        }

        for (int i = 0; i < Board.NUMBER_OF_SQUARES; i++) {
            if (!(board.getPosition(28).canMoveTo(i) == validArray4[i])) {
                pass = false;
            }
        }

        for (int i = 0; i < Board.NUMBER_OF_SQUARES; i++) {
            if (!(board.getPosition(48).canMoveTo(i) == validArray5[i])) {
                pass = false;
            }
        }

        for (int i = 0; i < Board.NUMBER_OF_SQUARES; i++) {
            if (!(board.getPosition(51).canMoveTo(i) == validArray6[i])) {
                pass = false;
            }
        }

        for (int i = 0; i < Board.NUMBER_OF_SQUARES; i++) {
            if (!(board.getPosition(84).canMoveTo(i) == validArray7[i])) {
                pass = false;
            }
        }

        for (int i = 0; i < Board.NUMBER_OF_SQUARES; i++) {
            if (!(board.getPosition(85).canMoveTo(i) == validArray8[i])) {
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
