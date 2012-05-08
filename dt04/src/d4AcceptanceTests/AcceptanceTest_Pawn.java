package d4AcceptanceTests;

import design04.ChessThinker;
import design04.DeepTeal;

public class AcceptanceTest_Pawn implements Test {

    public String toString() {
        return "testing pawns";
    }

    public void run() {
        {
            String boardString =
                    "|  |  |  |  |  |  |  |  |=\n" +
                            "|  |  |  |  |  |  |  |  |=\n" +
                            "|  |  |  |  |  |kl|  |  |=\n" +
                            "|  |  |  |  |  |  |  |  |=\n" +
                            "|  |  |kd|  |  |  |  |  |=\n" +
                            "|  |pl|  |  |  |  |  |  |=\n" +
                            "|  |  |  |  |  |  |  |  |=\n" +
                            "|  |  |  |  |  |  |  |  |=\n";

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
                            "|  |  |kl|  |  |  |  |  |=\n" +
                            "|  |  |  |  |  |  |  |  |=\n" +
                            "|  |  |kd|  |  |  |  |  |=\n" +
                            "|  |pl|pl|pl|  |  |  |  |=\n" +
                            "|  |pl|pl|  |  |  |  |  |=\n" +
                            "|  |  |  |  |  |  |  |  |=\n";

            ChessThinker deepTeal = new DeepTeal();

            deepTeal.fromString(boardString);

            assert (boardString.equals(deepTeal.toString()));

            assert (deepTeal.blackIsInCheck());

            assert (deepTeal.blackIsInCheckMate());
        }

        {
            String boardString =
                    "|  |kd|  |  |  |  |  |  |=\n" +
                            "|  |  |  |pl|  |  |  |  |=\n" +
                            "|pl|pl|pl|pl|  |kl|  |  |=\n" +
                            "|  |  |  |  |  |  |  |  |=\n" +
                            "|  |  |  |  |  |  |  |  |=\n" +
                            "|  |  |  |  |  |  |  |  |=\n" +
                            "|  |  |  |  |  |  |  |  |=\n" +
                            "|  |  |  |  |  |  |  |  |=\n";

            ChessThinker deepTeal = new DeepTeal();

            deepTeal.fromString(boardString);

            assert (boardString.equals(deepTeal.toString()));

            assert (!deepTeal.blackIsInCheck());

            assert (!deepTeal.blackIsInCheckMate());

            assert (!deepTeal.whiteCanMateInOneMove());
        }

        {
            String boardString =
                    "|kd|  |pl|  |  |  |  |  |=\n" +
                            "|  |  |pl|  |  |  |  |  |=\n" +
                            "|kl|pl|pl|  |  |  |  |  |=\n" +
                            "|  |  |  |  |  |  |  |  |=\n" +
                            "|  |  |  |  |  |  |  |  |=\n" +
                            "|  |  |  |  |  |  |  |  |=\n" +
                            "|  |  |  |  |  |  |  |  |=\n" +
                            "|  |  |  |  |  |  |  |  |=\n";

            ChessThinker deepTeal = new DeepTeal();

            deepTeal.fromString(boardString);

            assert (boardString.equals(deepTeal.toString()));

            assert (!deepTeal.blackIsInCheck());

//         assert (!deepTeal.blackIsInCheckMate());

            assert (deepTeal.whiteCanMateInOneMove());

            deepTeal.makeWhiteMateMove();

            assert (deepTeal.blackIsInCheck());

            assert (deepTeal.blackIsInCheckMate());
        }
    }
}
