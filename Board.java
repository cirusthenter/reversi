public class Board {
    static final int FIELDSIZE = 8;
    static final int PLAYER1 = 1;   // ●
    static final int PLAYER2 = -1;  // ○

    private static final int[][] DIRECTIONS = {
        {-1, -1}, {-1, 0}, {-1, 1},
        { 0, -1},          { 0, 1},
        { 1, -1}, { 1, 0}, { 1, 1}
    };

    private final int[][] field = new int[FIELDSIZE][FIELDSIZE];
    int occupied = 4;

    public Board() {
        int mid = FIELDSIZE / 2;
        field[mid - 1][mid - 1] = PLAYER1;
        field[mid][mid - 1] = PLAYER2;
        field[mid - 1][mid] = PLAYER2;
        field[mid][mid] = PLAYER1;
    }

    private static char symbol(int cell) {
        return cell == PLAYER1 ? '●' : cell == PLAYER2 ? '○' : '_';
    }

    public void printBoard() {
        String line = "-".repeat(FIELDSIZE * 2 + 5);
        System.out.println(line);
        StringBuilder header = new StringBuilder("|   ");
        for (int j = 0; j < FIELDSIZE; j++) {
            header.append(j).append(' ');
        }
        System.out.println(header.append('|'));
        for (int i = 0; i < FIELDSIZE; i++) {
            StringBuilder row = new StringBuilder("| ").append((char) ('a' + i)).append(' ');
            for (int j = 0; j < FIELDSIZE; j++) {
                row.append(symbol(field[i][j])).append(' ');
            }
            System.out.println(row.append('|'));
        }
        System.out.println(line);
        System.out.println("Player 1: ●");
        System.out.println("Player 2: ○");
        System.out.println(line);
    }

    private static boolean inside(int i, int j) {
        return 0 <= i && i < FIELDSIZE && 0 <= j && j < FIELDSIZE;
    }

    /** Number of stones the player would flip in one direction from (i, j); 0 if none. */
    private int countFlips(int i, int j, int di, int dj, int player) {
        int n = 0;
        i += di;
        j += dj;
        while (inside(i, j) && field[i][j] == -player) {
            n++;
            i += di;
            j += dj;
        }
        return (inside(i, j) && field[i][j] == player) ? n : 0;
    }

    /** True if the player may place a stone at (i, j). */
    public boolean isValidMove(int i, int j, int player) {
        if (!inside(i, j) || field[i][j] != 0) {
            return false;
        }
        for (int[] d : DIRECTIONS) {
            if (countFlips(i, j, d[0], d[1], player) > 0) {
                return true;
            }
        }
        return false;
    }

    /** True if the player has at least one legal move. */
    public boolean hasMove(int player) {
        for (int i = 0; i < FIELDSIZE; i++) {
            for (int j = 0; j < FIELDSIZE; j++) {
                if (isValidMove(i, j, player)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean isFull() {
        return occupied >= FIELDSIZE * FIELDSIZE;
    }

    /** The game is over when the board is full or neither player can move. */
    public boolean isGameOver() {
        return isFull() || (!hasMove(PLAYER1) && !hasMove(PLAYER2));
    }

    /**
     * Parses input such as "4c" or "c4" (row letter + column digit, either order).
     * Returns {row, col} or null if the format is invalid.
     */
    static int[] parse(String input) {
        if (input == null) {
            return null;
        }
        input = input.trim().toLowerCase();
        if (input.length() != 2) {
            return null;
        }
        char a = input.charAt(0);
        char b = input.charAt(1);
        int i, j;
        if (Character.isLetter(a)) {
            i = a - 'a';
            j = b - '0';
        } else {
            i = b - 'a';
            j = a - '0';
        }
        return inside(i, j) ? new int[] {i, j} : null;
    }

    /** Tries to play the move; returns true on success, false if the input is invalid. */
    public boolean setBoard(int player, String input) {
        int[] pos = parse(input);
        if (pos == null || !isValidMove(pos[0], pos[1], player)) {
            return false;
        }
        for (int[] d : DIRECTIONS) {
            int n = countFlips(pos[0], pos[1], d[0], d[1], player);
            for (int k = 1; k <= n; k++) {
                field[pos[0] + d[0] * k][pos[1] + d[1] * k] = player;
            }
        }
        field[pos[0]][pos[1]] = player;
        occupied++;
        return true;
    }

    public int count(int player) {
        int sum = 0;
        for (int[] row : field) {
            for (int cell : row) {
                if (cell == player) {
                    sum++;
                }
            }
        }
        return sum;
    }

    public int player1Number() {
        return count(PLAYER1);
    }

    public int player2Number() {
        return count(PLAYER2);
    }
}
