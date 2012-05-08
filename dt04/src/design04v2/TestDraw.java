package design04v2;

public class TestDraw {
    public static void main(String[] args) {
        test01();
    }

    public static void test01() {

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

        board.draw();
    }
}
