import java.util.Scanner;

public class Reversi {
    public static void main(String[] args) {
        Board board = new Board();
        Scanner in = new Scanner(System.in);
        board.printBoard();
        int player = Board.PLAYER1;
        while (!board.isGameOver()) {
            int number = player == Board.PLAYER1 ? 1 : 2;
            char mark = player == Board.PLAYER1 ? '●' : '○';
            if (!board.hasMove(player)) {
                System.out.println("***************");
                System.out.println("Player " + number + " PASSED");
                System.out.println("***************");
            } else {
                while (true) {
                    System.out.print("Player " + number + " " + mark + " input (e.g. 4c): ");
                    if (!in.hasNextLine()) {
                        System.out.println("\nInput closed. Game aborted.");
                        return;
                    }
                    String input = in.nextLine();
                    if (board.setBoard(player, input)) {
                        break;
                    }
                    System.out.println("Input \"" + input + "\" is invalid");
                }
                board.printBoard();
            }
            player = -player;
        }
        int p1 = board.player1Number();
        int p2 = board.player2Number();
        System.out.println("*************************");
        System.out.println("Player 1 ●: " + p1);
        System.out.println("Player 2 ○: " + p2);
        System.out.println("*************************");
        if (p1 > p2) {
            System.out.println("Player 1 ● WON by " + (p1 - p2) + "!");
        } else if (p1 == p2) {
            System.out.println("The game ended in a draw!");
        } else {
            System.out.println("Player 2 ○ WON by " + (p2 - p1) + "!");
        }
        System.out.println("*************************");
    }
}
