public class Reversi {
    public static void main (String[] args) {
        Board mainboard;
        String input;
        mainboard = new Board();
        mainboard.printBoard();
        while (mainboard.occupied < mainboard.FIELDSIZE * mainboard.FIELDSIZE){
            if (mainboard.passCheck(1) == 1) {
                input = javax.swing.JOptionPane.showInputDialog("Player 1");
                while (mainboard.setBoard(1, input) == 1) {
                    input = javax.swing.JOptionPane.showInputDialog("Input \"" + input + "\" is invalid\n Player 1");
                }
            } else if (mainboard.passCheck(1) == 0){
                System.out.println("***************");
                System.out.println("Player 1 PASSED");
                System.out.println("***************");
            } else if (mainboard.passCheck(1) == -1){
                System.out.println("All ○");
                break;
            }
            mainboard.printBoard();

            if (mainboard.occupied < mainboard.FIELDSIZE * mainboard.FIELDSIZE){
                if (mainboard.passCheck(-1) == 1) {
                    input = javax.swing.JOptionPane.showInputDialog("PLayer 2");
                    while (mainboard.setBoard(-1, input) == 1) {
                        input = javax.swing.JOptionPane.showInputDialog("Input \"" + input + "\" is invalid\n Player 2");
                    }
                } else if (mainboard.passCheck(-1) == 0){
                    System.out.println("***************");
                    System.out.println("Player 2 PASSED");
                    System.out.println("***************");
                } else if (mainboard.passCheck(-1) == -1){
                    System.out.println("All ●");
                    break;
                }
            }
            mainboard.printBoard();
        }
        int p1 = mainboard.player1Number();
        int p2 = mainboard.player2Number();
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


