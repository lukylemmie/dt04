package d4AcceptanceTests;

import design04.ChessThinker;
import design04.DeepTeal;

/**
 * design task 04 comp2911
 *
 * @author richard buckland
 * @date may 2010
 */
public class TestPawn implements Test {

    public String toString() {
        return "richard's pawn tests";
    }

    public void run() {

        {
            String game =
                    "|  |  |  |  |  |  |  |  |=\n" +
                            "|  |  |  |  |  |  |  |  |=\n" +
                            "|  |  |  |  |  |  |  |  |=\n" +
                            "|  |  |  |  |  |  |  |  |=\n" +
                            "|kd|  |nl|nl|  |  |  |  |=\n" +
                            "|pl|  |  |  |  |  |  |  |=\n" +
                            "|  |  |  |  |  |  |  |  |=\n" +
                            "|  |  |  |  |  |kl|  |  |";

            ChessThinker ct = new DeepTeal(game);
            assert (!ct.blackIsInCheck());
            assert (ct.blackIsInCheckMate());
        }

        {
            String game =
                    "|kd|  |  |  |  |  |  |  |=\n" +
                            "|  |  |  |  |  |  |rl|  |=\n" +
                            "|  |nl|nl|  |  |  |  |  |=\n" +
                            "|  |  |  |bl|  |  |  |  |=\n" +
                            "|  |  |  |  |  |  |  |  |=\n" +
                            "|  |  |  |  |  |  |  |  |=\n" +
                            "|  |  |  |  |  |  |  |  |=\n" +
                            "|  |  |  |  |  |  |kl|  |";

            ChessThinker ct = new DeepTeal(game);
            assert (ct.blackIsInCheck());
            assert (ct.blackIsInCheckMate());
        }

        {
            String game =
                    "|kd|  |  |  |  |  |  |  |=\n" +
                            "|  |  |  |  |  |  |  |  |=\n" +
                            "|kl|  |  |bl|pd|  |  |  |=\n" +
                            "|  |  |  |bl|  |  |  |  |=\n" +
                            "|  |  |  |  |  |  |  |  |=\n" +
                            "|  |  |  |  |  |  |  |  |=\n" +
                            "|  |  |  |  |  |  |  |  |=\n" +
                            "|  |  |  |  |  |  |  |  |";

            ChessThinker ct = new DeepTeal(game);
            assert (ct.blackIsInCheck());
            assert (!ct.blackIsInCheckMate());
        }

        {
            String game =
                    "|  |  |  |  |  |  |  |  |=\n" +
                            "|  |  |  |kd|  |  |  |  |=\n" +
                            "|kl|  |  |  |pl|  |  |  |=\n" +
                            "|  |  |  |  |  |  |  |  |=\n" +
                            "|  |  |  |  |  |  |  |  |=\n" +
                            "|  |  |  |  |  |  |  |  |=\n" +
                            "|  |  |  |  |  |  |  |  |=\n" +
                            "|  |  |  |  |  |  |  |  |";

            ChessThinker ct = new DeepTeal(game);
            assert (ct.blackIsInCheck());
        }

        {
            String game =
                    "|  |  |  |  |  |  |  |  |=\n" +
                            "|  |  |  |  |kd|  |  |  |=\n" +
                            "|kl|  |  |  |pl|  |  |  |=\n" +
                            "|  |  |  |  |  |  |  |  |=\n" +
                            "|  |  |  |  |  |  |  |  |=\n" +
                            "|  |  |  |  |  |  |  |  |=\n" +
                            "|  |  |  |  |  |  |  |  |=\n" +
                            "|  |  |  |  |  |  |  |  |";

            ChessThinker ct = new DeepTeal(game);
            assert (!ct.blackIsInCheck());
        }

        {
            String game =
                    "|  |  |  |  |  |  |  |  |=\n" +
                            "|  |  |  |  |  |kd|  |  |=\n" +
                            "|kl|  |  |  |pl|  |  |  |=\n" +
                            "|  |  |  |  |  |  |  |  |=\n" +
                            "|  |  |  |  |  |  |  |  |=\n" +
                            "|  |  |  |  |  |  |  |  |=\n" +
                            "|  |  |  |  |  |  |  |  |=\n" +
                            "|  |  |  |  |  |  |  |  |";

            ChessThinker ct = new DeepTeal(game);
            assert (ct.blackIsInCheck());
        }

        {
            String game =
                    "|  |  |  |  |  |  |  |  |=\n" +
                            "|  |  |  |  |  |  |  |  |=\n" +
                            "|kl|  |  |  |pl|kd|  |  |=\n" +
                            "|  |  |  |  |  |  |  |  |=\n" +
                            "|  |  |  |  |  |  |  |  |=\n" +
                            "|  |  |  |  |  |  |  |  |=\n" +
                            "|  |  |  |  |  |  |  |  |=\n" +
                            "|  |  |  |  |  |  |  |  |";

            ChessThinker ct = new DeepTeal(game);
            assert (!ct.blackIsInCheck());
        }

        {
            String game =
                    "|  |  |  |  |  |  |  |  |=\n" +
                            "|  |  |  |  |  |  |  |  |=\n" +
                            "|kl|  |  |  |pl|  |  |  |=\n" +
                            "|  |  |  |  |  |kd|  |  |=\n" +
                            "|  |  |  |  |  |  |  |  |=\n" +
                            "|  |  |  |  |  |  |  |  |=\n" +
                            "|  |  |  |  |  |  |  |  |=\n" +
                            "|  |  |  |  |  |  |  |  |";

            ChessThinker ct = new DeepTeal(game);
            assert (!ct.blackIsInCheck());
        }

        {
            String game =
                    "|  |  |  |  |  |  |  |  |=\n" +
                            "|  |  |  |  |  |  |  |  |=\n" +
                            "|kl|  |  |  |pl|  |  |  |=\n" +
                            "|  |  |  |  |kd|  |  |  |=\n" +
                            "|  |  |  |  |  |  |  |  |=\n" +
                            "|  |  |  |  |  |  |  |  |=\n" +
                            "|  |  |  |  |  |  |  |  |=\n" +
                            "|  |  |  |  |  |  |  |  |";

            ChessThinker ct = new DeepTeal(game);
            assert (!ct.blackIsInCheck());
        }

        {
            String game =
                    "|  |  |  |  |  |  |  |  |=\n" +
                            "|  |  |  |  |  |  |  |  |=\n" +
                            "|kl|  |  |  |pl|  |  |  |=\n" +
                            "|  |  |  |kd|  |  |  |  |=\n" +
                            "|  |  |  |  |  |  |  |  |=\n" +
                            "|  |  |  |  |  |  |  |  |=\n" +
                            "|  |  |  |  |  |  |  |  |=\n" +
                            "|  |  |  |  |  |  |  |  |";

            ChessThinker ct = new DeepTeal(game);
            assert (!ct.blackIsInCheck());
        }

        {
            String game =
                    "|  |  |  |  |  |  |  |  |=\n" +
                            "|  |  |  |  |  |  |  |  |=\n" +
                            "|kl|  |  |kd|pl|  |  |  |=\n" +
                            "|  |  |  |  |  |  |  |  |=\n" +
                            "|  |  |  |  |  |  |  |  |=\n" +
                            "|  |  |  |  |  |  |  |  |=\n" +
                            "|  |  |  |  |  |  |  |  |=\n" +
                            "|  |  |  |  |  |  |  |  |";

            ChessThinker ct = new DeepTeal(game);
            assert (!ct.blackIsInCheck());
        }

        {
            String game =
                    "|  |  |  |  |  |  |  |  |=\n" +
                            "|  |  |  |  |  |  |  |rl|=\n" +
                            "|kd|  |kl|  |  |  |  |  |=\n" +
                            "|  |  |  |  |  |  |  |  |=\n" +
                            "|  |pl|  |pd|  |  |  |  |=\n" +
                            "|  |  |  |ql|  |  |  |  |=\n" +
                            "|  |  |  |  |  |  |  |  |=\n" +
                            "|  |  |  |  |  |  |  |  |";

            ChessThinker ct = new DeepTeal(game);
            assert (ct.blackIsInCheck());
            assert (ct.blackIsInCheckMate());
        }

        {
            String game =
                    "|  |  |  |  |  |  |  |  |=\n" +
                            "|  |  |  |  |  |  |  |rl|=\n" +
                            "|kd|  |kl|  |  |  |  |  |=\n" +
                            "|  |  |  |  |  |  |  |  |=\n" +
                            "|  |pl|  |  |pd|  |  |  |=\n" +
                            "|  |  |  |ql|  |  |  |  |=\n" +
                            "|  |  |  |  |  |  |  |  |=\n" +
                            "|  |  |  |  |  |  |  |  |";

            ChessThinker ct = new DeepTeal(game);
            assert (ct.blackIsInCheck());
            assert (!ct.blackIsInCheckMate());
        }

        {
            String game =
                    "|  |  |  |  |  |  |  |  |=\n" +
                            "|  |  |  |  |  |  |  |rl|=\n" +
                            "|kd|  |kl|  |  |  |  |  |=\n" +
                            "|  |  |pd|  |  |  |  |  |=\n" +
                            "|  |pl|  |  |  |  |  |  |=\n" +
                            "|  |  |  |ql|  |  |  |  |=\n" +
                            "|  |  |  |  |  |  |  |  |=\n" +
                            "|  |  |  |  |  |  |  |  |";

            ChessThinker ct = new DeepTeal(game);
            assert (ct.blackIsInCheck());
            assert (!ct.blackIsInCheckMate());
        }

        {
            String game =
                    "|  |  |  |  |  |  |  |  |=\n" +
                            "|  |  |  |  |  |  |  |rl|=\n" +
                            "|kd|  |kl|  |  |  |  |  |=\n" +
                            "|pd|  |  |  |  |  |  |  |=\n" +
                            "|  |pl|  |  |  |  |  |  |=\n" +
                            "|  |  |  |ql|  |  |  |  |=\n" +
                            "|  |  |  |  |  |  |  |  |=\n" +
                            "|  |  |  |  |  |  |  |  |";

            ChessThinker ct = new DeepTeal(game);
            assert (ct.blackIsInCheck());
            assert (ct.blackIsInCheckMate());
        }

        {
            String game =
                    "|  |  |  |  |  |  |  |  |=\n" +
                            "|  |  |rl|pd|  |  |  |  |=\n" +
                            "|kd|  |kl|  |  |  |  |  |=\n" +
                            "|  |  |  |  |  |  |  |  |=\n" +
                            "|  |pl|  |  |  |  |  |  |=\n" +
                            "|  |  |  |ql|  |  |  |  |=\n" +
                            "|  |  |  |  |  |  |  |  |=\n" +
                            "|  |  |  |  |  |  |  |  |";

            ChessThinker ct = new DeepTeal(game);
            assert (ct.blackIsInCheck());
            assert (!ct.blackIsInCheckMate());
        }
    }
}
