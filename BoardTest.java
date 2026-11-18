/** Minimal dependency-free tests. Run: javac Board.java BoardTest.java && java BoardTest */
public class BoardTest {
    private static int failures = 0;

    private static void check(boolean cond, String name) {
        if (!cond) {
            failures++;
            System.out.println("FAIL: " + name);
        } else {
            System.out.println("ok:   " + name);
        }
    }

    public static void main(String[] args) {
        int[] p = Board.parse("4c");
        check(p != null && p[0] == 2 && p[1] == 4, "parse 4c");
        p = Board.parse("C4");
        check(p != null && p[0] == 2 && p[1] == 4, "parse C4 (case-insensitive)");
        check(Board.parse("zz") == null, "parse rejects zz");
        check(Board.parse("44") == null, "parse rejects 44");
        check(Board.parse("a") == null, "parse rejects short input");
        check(Board.parse(null) == null, "parse rejects null");
        check(Board.parse("i0") == null, "parse rejects out-of-range row");

        Board b = new Board();
        check(b.player1Number() == 2 && b.player2Number() == 2, "initial counts 2/2");
        check(b.hasMove(Board.PLAYER1) && b.hasMove(Board.PLAYER2), "both players have opening moves");
        check(!b.setBoard(Board.PLAYER1, "a0"), "corner move invalid at start");
        check(!b.setBoard(Board.PLAYER1, "d3"), "occupied square invalid");
        check(b.setBoard(Board.PLAYER1, "4c"), "4c valid for player 1");
        check(b.player1Number() == 4 && b.player2Number() == 1, "counts after 4c are 4/1");
        check(!b.isGameOver(), "game not over after one move");

        if (failures > 0) {
            System.out.println(failures + " test(s) failed");
            System.exit(1);
        }
        System.out.println("All tests passed");
    }
}
