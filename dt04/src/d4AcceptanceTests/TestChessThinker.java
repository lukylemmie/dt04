package d4AcceptanceTests;

import design04.ChessThinker;
import design04.DeepTeal;

/**
 * design task 04 comp2911
 *
 * @author richard buckland
 * @date may 2010
 */
public class TestChessThinker implements Test {

    public String toString() {
        return "testing chess thinker";
    }

    public void run() {
        testCheck();
        testMate();
        testMateInOne();
    }


    private static void testMateInOne() {
        System.out.println("testing mate in one move...");

        {
            String game =
                    "|kd|  |  |  |  |  |  |rl|=\n" +
                            "|  |  |  |  |  |  |  |  |=\n" +
                            "|  |  |  |  |  |  |  |  |=\n" +
                            "|  |  |  |  |  |  |  |  |=\n" +
                            "|  |  |  |  |  |  |  |  |=\n" +
                            "|  |  |  |  |  |  |  |  |=\n" +
                            "|  |  |  |  |rl|  |  |  |=\n" +
                            "|  |  |  |  |  |kl|  |  |";

            ChessThinker thinker = new DeepTeal(game);
            assert (thinker.blackIsInCheck());
            assert (!thinker.blackIsInCheckMate());
            assert (thinker.whiteCanMateInOneMove());
        }

        {
            String game =
                    "|  |rd|  |  |  |  |  |kd|=\n" +
                            "|  |  |  |  |  |  |pd|  |=\n" +
                            "|  |rd|  |  |bl|  |  |  |=\n" +
                            "|  |pd|pd|pl|  |  |  |  |=\n" +
                            "|  |  |  |bd|  |rl|  |  |=\n" +
                            "|  |  |  |  |  |  |  |  |=\n" +
                            "|  |  |  |  |  |  |pl|pl|=\n" +
                            "|  |  |  |  |  |rl|  |kl|";

            ChessThinker thinker = new DeepTeal(game);
            assert (!thinker.blackIsInCheck());
            assert (!thinker.blackIsInCheckMate());
            assert (thinker.whiteCanMateInOneMove());
        }

        {
            String game =
                    "|  |rd|  |bd|  |  |  |kd|=\n" +
                            "|  |  |  |  |  |  |pd|  |=\n" +
                            "|  |rd|  |  |bl|  |  |  |=\n" +
                            "|  |pd|pd|pl|  |  |  |  |=\n" +
                            "|  |  |  |  |  |rl|  |  |=\n" +
                            "|  |  |  |  |  |  |  |  |=\n" +
                            "|  |  |  |  |  |  |pl|pl|=\n" +
                            "|  |  |  |  |  |rl|  |kl|";

            ChessThinker thinker = new DeepTeal(game);
            assert (!thinker.blackIsInCheck());
            assert (!thinker.blackIsInCheckMate());
            assert (!thinker.whiteCanMateInOneMove());
        }

        {
            String game =
                    "|kd|  |  |  |  |  |  |  |=\n" +
                            "|  |  |  |  |  |  |  |  |=\n" +
                            "|  |  |nl|  |  |  |  |bd|=\n" +
                            "|  |  |  |  |  |  |pl|  |=\n" +
                            "|  |  |  |  |pd|  |  |  |=\n" +
                            "|  |  |  |  |  |  |  |  |=\n" +
                            "|  |  |  |  |  |  |  |  |=\n" +
                            "|  |rl|  |  |  |kl|  |  |";

            ChessThinker thinker = new DeepTeal(game);
            assert (!thinker.blackIsInCheck());
            assert (!thinker.blackIsInCheckMate());
            assert (thinker.whiteCanMateInOneMove());
        }

        {
            String game =
                    "|  |bl|  |  |  |  |  |  |=\n" +
                            "|  |  |  |  |  |  |  |  |=\n" +
                            "|  |  |  |  |  |  |  |  |=\n" +
                            "|nl|  |kd|  |  |pl|  |rl|=\n" +
                            "|  |  |  |pd|  |  |  |  |=\n" +
                            "|  |  |  |  |  |  |  |  |=\n" +
                            "|  |rl|  |  |  |  |  |  |=\n" +
                            "|  |  |  |  |  |kl|  |  |";

            ChessThinker thinker = new DeepTeal(game);
            assert (!thinker.blackIsInCheck());
            assert (!thinker.blackIsInCheckMate());
            assert (thinker.whiteCanMateInOneMove());
        }

        {
            String game =
                    "|rd|  |  |qd|  |bd|nd|rd|=\n" +
                            "|pd|pd|pd|  |kd|bl|pd|pd|=\n" +
                            "|  |  |nd|pd|  |  |  |  |=\n" +
                            "|  |  |  |  |nl|  |  |  |=\n" +
                            "|  |  |  |  |pl|  |  |  |=\n" +
                            "|  |  |nl|  |  |  |  |  |=\n" +
                            "|pl|pl|pl|pl|  |pl|pl|pl|=\n" +
                            "|rl|  |bl|bd|kl|  |  |rl|";

            ChessThinker thinker = new DeepTeal(game);
            assert (!thinker.blackIsInCheck());
            assert (!thinker.blackIsInCheckMate());
            assert (thinker.whiteCanMateInOneMove());
        }
    }


    private static void testMate() {
        System.out.println("testing mate...");

        {
            String game =
                    "|kd|  |  |  |  |  |  |rl|=\n" +
                            "|  |  |  |  |  |  |  |  |=\n" +
                            "|  |  |  |  |  |  |  |  |=\n" +
                            "|  |  |  |  |  |  |  |  |=\n" +
                            "|  |  |  |  |  |  |  |  |=\n" +
                            "|  |  |  |  |  |  |  |  |=\n" +
                            "|  |  |  |  |  |  |  |  |=\n" +
                            "|  |  |  |  |  |kl|  |  |";

            ChessThinker ct = new DeepTeal(game);
            assert (!ct.blackIsInCheckMate());
        }

        {
            String game =
                    "|kd|  |  |  |  |  |  |rl|=\n" +
                            "|  |  |  |  |  |  |rl|  |=\n" +
                            "|  |  |  |  |  |  |  |  |=\n" +
                            "|  |  |  |  |  |  |  |  |=\n" +
                            "|  |  |  |  |  |  |  |  |=\n" +
                            "|  |  |  |  |  |  |  |  |=\n" +
                            "|  |  |  |  |  |  |  |  |=\n" +
                            "|  |  |  |  |  |kl|  |  |";

            ChessThinker ct = new DeepTeal(game);
            assert (ct.blackIsInCheckMate());
        }


        {
            String game =
                    "|  |  |kd|  |  |  |  |rl|=\n" +
                            "|  |  |kl|  |  |  |  |  |=\n" +
                            "|  |  |  |  |  |  |  |  |=\n" +
                            "|  |  |  |  |  |  |  |  |=\n" +
                            "|  |  |  |  |  |  |  |  |=\n" +
                            "|  |  |  |  |  |  |  |  |=\n" +
                            "|  |  |  |  |  |  |  |  |=\n" +
                            "|  |  |  |  |  |  |  |  |";

            ChessThinker ct = new DeepTeal(game);
            assert (!ct.blackIsInCheckMate());
        }
        {
            String game =
                    "|  |  |kd|  |  |  |  |rl|=\n" +
                            "|  |  |  |  |  |  |  |  |=\n" +
                            "|  |  |kl|  |  |  |  |  |=\n" +
                            "|  |  |  |  |  |  |  |  |=\n" +
                            "|  |  |  |  |  |  |  |  |=\n" +
                            "|  |  |  |  |  |  |  |  |=\n" +
                            "|  |  |  |  |  |  |  |  |=\n" +
                            "|  |  |  |  |  |  |  |  |";

            ChessThinker ct = new DeepTeal(game);
            assert (ct.blackIsInCheckMate());
        }
        {
            String game =
                    "|kd|kl|  |  |  |  |  |rl|=\n" +
                            "|  |  |  |  |  |  |  |  |=\n" +
                            "|  |  |  |  |  |  |  |  |=\n" +
                            "|  |  |  |  |  |  |  |  |=\n" +
                            "|  |  |  |  |  |  |  |  |=\n" +
                            "|  |  |  |  |  |  |  |  |=\n" +
                            "|  |  |  |  |  |  |  |  |=\n" +
                            "|  |  |  |  |  |  |  |  |";

            ChessThinker ct = new DeepTeal(game);
            assert (!ct.blackIsInCheckMate());
        }

        {
            String game =
                    "|rd|  |  |qd|  |bd|nd|rd|=\n" +
                            "|pd|pd|pd|  |kd|bl|pd|pd|=\n" +
                            "|  |  |nd|pd|  |  |  |  |=\n" +
                            "|  |  |  |nl|nl|  |  |  |=\n" +
                            "|  |  |  |  |pl|  |  |  |=\n" +
                            "|  |  |  |  |  |  |  |  |=\n" +
                            "|pl|pl|pl|pl|  |pl|pl|pl|=\n" +
                            "|rl|  |bl|bd|kl|  |  |rl|";

            ChessThinker thinker = new DeepTeal(game);
            assert (thinker.blackIsInCheck());
            assert (thinker.blackIsInCheckMate());
        }

    }


    public static void testCheck() {
        System.out.println("testing check...");

        {
            String game =
                    "|kd|  |  |  |  |  |  |rl|=\n" +
                            "|  |  |  |  |  |  |  |  |=\n" +
                            "|  |  |  |  |  |  |  |  |=\n" +
                            "|  |  |  |  |  |  |  |  |=\n" +
                            "|  |  |  |  |  |  |  |  |=\n" +
                            "|  |  |  |  |  |  |  |  |=\n" +
                            "|  |  |  |  |  |  |  |  |=\n" +
                            "|  |  |  |  |  |kl|  |  |";

            ChessThinker ct = new DeepTeal(game);
            assert (ct.blackIsInCheck());
        }
        {
            String game =
                    "|kd|  |  |  |  |  |  |rd|=\n" +
                            "|  |  |  |  |  |  |  |  |=\n" +
                            "|  |  |  |  |  |  |  |  |=\n" +
                            "|  |  |  |  |  |  |  |  |=\n" +
                            "|  |  |  |  |  |  |  |  |=\n" +
                            "|  |  |  |  |  |  |  |  |=\n" +
                            "|  |  |  |  |  |  |  |  |=\n" +
                            "|  |  |  |  |  |kl|  |  |";

            ChessThinker ct = new DeepTeal(game);
            assert (!ct.blackIsInCheck());
        }
        {
            String game =
                    "|  |  |  |  |  |  |  |  |=\n" +
                            "|  |kd|  |  |  |  |  |rd|=\n" +
                            "|  |  |  |  |rl|  |  |  |=\n" +
                            "|  |  |  |  |  |  |  |  |=\n" +
                            "|  |  |  |  |  |  |  |  |=\n" +
                            "|  |  |  |  |  |  |  |  |=\n" +
                            "|  |  |  |  |  |  |  |  |=\n" +
                            "|  |  |  |  |  |kl|  |  |";

            ChessThinker ct = new DeepTeal(game);
            assert (!ct.blackIsInCheck());
        }
        {
            String game =
                    "|  |  |  |  |  |  |  |  |=\n" +
                            "|  |kd|  |  |  |  |  |rd|=\n" +
                            "|  |  |  |  |rl|  |  |  |=\n" +
                            "|  |  |  |  |  |  |  |  |=\n" +
                            "|  |  |  |  |  |  |  |  |=\n" +
                            "|  |  |  |  |  |  |  |  |=\n" +
                            "|  |rl|  |  |  |  |  |  |=\n" +
                            "|  |  |  |  |  |kl|  |  |";

            ChessThinker ct = new DeepTeal(game);
            assert (ct.blackIsInCheck());
        }
        {
            String game =
                    "|  |  |  |  |  |  |  |  |=\n" +
                            "|  |kd|  |  |  |  |  |rd|=\n" +
                            "|  |  |kl|  |rl|  |  |  |=\n" +
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
                            "|  |kd|  |  |  |  |  |rd|=\n" +
                            "|  |kl|  |  |rl|  |  |  |=\n" +
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
                            "|  |kd|  |  |  |  |  |rd|=\n" +
                            "|kl|  |  |  |rl|  |  |  |=\n" +
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
                            "|kl|kd|  |  |  |  |  |rd|=\n" +
                            "|  |  |  |  |rl|  |  |  |=\n" +
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
                    "|kl|  |  |  |  |  |  |  |=\n" +
                            "|  |kd|  |  |  |  |  |rd|=\n" +
                            "|  |  |  |  |rl|  |  |  |=\n" +
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
                    "|  |kl|  |  |  |  |  |  |=\n" +
                            "|  |kd|  |  |  |  |  |rd|=\n" +
                            "|  |  |  |  |rl|  |  |  |=\n" +
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
                    "|  |  |kl|  |  |  |  |  |=\n" +
                            "|  |kd|  |  |  |  |  |rd|=\n" +
                            "|  |  |  |  |rl|  |  |  |=\n" +
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
                            "|  |kd|kl|  |  |  |  |rd|=\n" +
                            "|  |  |  |  |rl|  |  |  |=\n" +
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
                            "|  |kd|  |kl|  |  |  |rd|=\n" +
                            "|  |  |  |  |rl|  |  |  |=\n" +
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
                            "|  |kd|  |  |  |  |  |rd|=\n" +
                            "|  |  |  |  |rl|  |  |  |=\n" +
                            "|  |  |  |kl|  |  |  |  |=\n" +
                            "|  |  |  |  |  |  |  |  |=\n" +
                            "|  |  |  |  |  |  |  |  |=\n" +
                            "|  |  |  |  |  |  |  |  |=\n" +
                            "|  |  |  |  |  |  |  |  |";

            ChessThinker ct = new DeepTeal(game);
            assert (!ct.blackIsInCheck());
        }
    }
}
