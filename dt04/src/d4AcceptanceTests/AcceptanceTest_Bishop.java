package d4AcceptanceTests;

import design04.ChessThinker;
import design04.DeepTeal;

public class AcceptanceTest_Bishop implements Test {

    public String toString() {
        return "testing bishops";
    }

    public void run() {
        {
            String boardString =
                    "|  |  |  |  |  |  |kd|  |=\n" +
                            "|  |  |  |  |  |  |  |  |=\n" +
                            "|  |  |  |  |  |  |  |  |=\n" +
                            "|  |  |  |  |  |  |  |  |=\n" +
                            "|  |  |  |  |  |  |  |  |=\n" +
                            "|  |  |  |  |  |  |  |  |=\n" +
                            "|bl|  |  |  |  |  |  |  |=\n" +
                            "|kl|  |  |  |  |  |  |  |=\n";

            ChessThinker deepTeal = new DeepTeal();

            deepTeal.fromString(boardString);

            assert (boardString.equals(deepTeal.toString()));

            assert (deepTeal.blackIsInCheck());

            assert (!deepTeal.blackIsInCheckMate());

            assert (!deepTeal.whiteCanMateInOneMove());
        }

        {
            String boardString =
                    "|  |  |  |  |  |  |  |  |=\n" +
                            "|  |  |  |  |  |  |  |  |=\n" +
                            "|  |  |  |  |  |  |  |  |=\n" +
                            "|  |  |  |kd|  |  |  |  |=\n" +
                            "|bl|  |  |  |  |  |  |  |=\n" +
                            "|bl|  |bl|bl|  |  |  |  |=\n" +
                            "|bl|  |  |  |  |  |  |  |=\n" +
                            "|kl|  |  |  |  |  |  |  |=\n";

            ChessThinker deepTeal = new DeepTeal();

            deepTeal.fromString(boardString);

            assert (boardString.equals(deepTeal.toString()));

            assert (deepTeal.blackIsInCheck());

            assert (deepTeal.blackIsInCheckMate());
        }

        {
            String boardString =
                    "|  |  |  |  |  |  |  |  |=\n" +
                            "|  |  |  |  |  |  |  |  |=\n" +
                            "|  |  |  |  |  |  |bl|  |=\n" +
                            "|  |  |  |kd|  |  |  |  |=\n" +
                            "|bl|  |  |  |  |  |  |  |=\n" +
                            "|bl|  |bl|bl|  |  |  |  |=\n" +
                            "|  |  |  |  |  |  |  |  |=\n" +
                            "|kl|  |  |  |  |  |  |  |=\n";

            ChessThinker deepTeal = new DeepTeal();

            deepTeal.fromString(boardString);

            assert (boardString.equals(deepTeal.toString()));

            assert (!deepTeal.blackIsInCheck());

            assert (!deepTeal.blackIsInCheckMate());

            assert (deepTeal.whiteCanMateInOneMove());

            deepTeal.makeWhiteMateMove();

            // assert (deepTeal.blackIsInCheck());

            // assert (deepTeal.blackIsInCheckMate());
        }
    }
}
