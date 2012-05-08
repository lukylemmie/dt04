package d4AcceptanceTests;

import design04.ChessThinker;
import design04.DeepTeal;

public class AcceptanceTest_ExampleBoard implements Test {

    public String toString() {
        return "testing the example board from the Design04 wiki page";
    }

    public void run() {
        String boardString =
                "|rd|nd|bd|qd|kd|bd|nd|rd|=\n" +
                        "|pd|pd|pd|  |  |pd|pd|pd|=\n" +
                        "|  |  |  |  |pd|  |  |  |=\n" +
                        "|  |  |  |pd|  |  |  |  |=\n" +
                        "|  |  |pl|pl|  |  |  |  |=\n" +
                        "|  |  |  |  |  |  |  |  |=\n" +
                        "|pl|pl|  |  |  |  |pl|pl|=\n" +
                        "|rl|nl|bl|ql|kl|bl|nl|rl|=\n";

        ChessThinker deepTeal = new DeepTeal();

        deepTeal.fromString(boardString);

        assert (boardString.equals(deepTeal.toString()));

        assert (!deepTeal.blackIsInCheck());
        assert (!deepTeal.blackIsInCheckMate());
        assert (!deepTeal.whiteCanMateInOneMove());
    }
}
