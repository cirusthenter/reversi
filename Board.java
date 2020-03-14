public class Board {
    static final int FIELDSIZE = 30;
    private int[][] field = new int[FIELDSIZE][FIELDSIZE];
    int occupied = 4;

    public Board() {
        for (int i = 0; i < FIELDSIZE; i++) {
            for (int j = 0; j < FIELDSIZE; j++) {
                field[i][j] = 0;
            }
        }
        field[FIELDSIZE/2 - 1][FIELDSIZE/2 - 1] = 1;
        field[FIELDSIZE/2][FIELDSIZE/2 - 1] = -1;
        field[FIELDSIZE/2 - 1][FIELDSIZE/2] = -1;
        field[FIELDSIZE/2][FIELDSIZE/2] = 1;
    }

    public void printBoard(){
        char letter = 'a';
        System.out.println("---------------------");
        System.out.print("|   ");
        for (int i = 0; i < FIELDSIZE - 1; i++){
            System.out.print(i + " ");
        }
        System.out.println(FIELDSIZE - 1 + " |");
        for (int i = 0; i < FIELDSIZE; i++, letter++) {
            System.out.print("| " + letter + " ");
            for (int j = 0; j < FIELDSIZE - 1; j++){
                if (field[i][j] == 1) {
                    System.out.print("● ");
                } else if (field[i][j] == -1) {
                    System.out.print("○ ");
                } else {
                    System.out.print("_ ");
                }
            }
            if (field[i][FIELDSIZE - 1] == 1) {
                System.out.println("● |");
            } else if (field[i][FIELDSIZE - 1] == -1) {
                System.out.println("○ |");
            } else {
                System.out.println("_ |");
            }
        }
        System.out.println("---------------------");
        System.out.println("Player 1: ●");
        System.out.println("Player 2: ○");
        System.out.println("---------------------");
    }

    public int setBoard(int player, String input){
        System.out.print("Player ");
        if (player == 1) {
            System.out.print(1 + " ● ");
        } else {
            System.out.print(2 + " ○ ");
        }
        System.out.println("input: " + input);
        if (input.length() != 2) {
            return 1;
        }
        int i = Integer.valueOf(input.charAt(0)) - 'a';
        int j = Integer.valueOf(input.charAt(1)) - '0';
        if (0 <= i && i < FIELDSIZE && 0 <= j && j < FIELDSIZE) {
        } else {
            i = Integer.valueOf(input.charAt(1)) - 'a';
            j = Integer.valueOf(input.charAt(0)) - '0';
            if (0 <= i && i < FIELDSIZE && 0 <= j && j < FIELDSIZE) {
            } else {
                return 1;
            }
        }
        if (field[i][j] != 0) {
            return 1;
        }
        if (seeAroundBoard(i, j, player) == 0) {
            return 1;
        }
        field[i][j] = player;
        occupied++;
        return 0;
    }

    public int seeAroundBoard(int i, int j, int player) {
        int valid = 0;
        if (0 < i) {
            if (0 < j){
                if (field[i - 1][j - 1] * player == -1) {
                    if (reverseBoard(i - 1, j - 1, 1, player) == 0) {
                        valid = 1;
                    }
                }
            }
            if (field[i - 1][j] * player == -1) {
                if (reverseBoard(i - 1, j, 2, player) == 0) {
                    valid = 1;
                }
            }
            if (j < FIELDSIZE - 1){
                if (field[i - 1][j + 1] * player == -1) {
                    if (reverseBoard(i - 1, j + 1, 3, player) == 0) {
                        valid = 1;
                    }
                }
            }
        }
        if (0 < j){
            if (field[i][j - 1] * player == -1) {
                if (reverseBoard(i, j - 1, 4, player) == 0) {
                    valid = 1;
                }
            }
        }
        if (j < FIELDSIZE - 1){
            if (field[i][j + 1] * player == -1) {
                if (reverseBoard(i, j + 1, 6, player) == 0) {
                    valid = 1;
                }
            }
        }
        if (i < FIELDSIZE - 1){
            if (0 < j){
                if (field[i + 1][j - 1] * player == -1) {
                    if (reverseBoard(i + 1, j - 1, 7, player) == 0) {
                        valid = 1;
                    }
                }
            }
            if (field[i + 1][j] * player == -1) {
                if (reverseBoard(i + 1, j, 8, player) == 0) {
                    valid = 1;
                }
            }
            if (j < FIELDSIZE - 1){
                if (field[i + 1][j + 1] * player == -1) {
                    if (reverseBoard(i + 1, j + 1, 9, player) == 0) {
                        valid = 1;
                    }
                }
            }
        }

        return valid;
    }

    public int reverseBoard(int i, int j, int direction, int player) {
        // returns 1 if none can be flipped and 0 otherwise
        // About variable "direction":
        // Let's say x == fidle[i][j], then
        // 1 2 3
        // 4 x 6
        // 7 8 9
        // e.g. if the value we want to check is in the NE,
        // the "direction" is going to be 3.
        //
        if (direction == 1) {
            if (0 < i && 0 < j) {
                if (field[i - 1][j - 1] * player == -1) {
                    int ret_val = reverseBoard(i - 1, j - 1, direction, player);
                    if (ret_val == 0) {
                        field[i][j] = player;
                    }
                    return ret_val;
                } else if (field[i - 1][j - 1] * player == 0) {
                    return 1;
                } else { //can be flipped!
                    field[i][j] = player;
                    return 0;
                }
            } else {
                return 1;
            }
        }
        if (direction == 2) {
            if (0 < i) {
                if (field[i - 1][j] * player == -1) {
                    int ret_val = reverseBoard(i - 1, j, direction, player);
                    if (ret_val == 0) {
                        field[i][j] = player;
                    }
                    return ret_val;
                } else if (field[i - 1][j] * player == 0) {
                    return 1;
                } else { //can be flipped!
                    field[i][j] = player;
                    return 0;
                }
            } else {
                return 1;
            }
        }
        if (direction == 3) {
            if (0 < i && j < FIELDSIZE - 1) {
                if (field[i - 1][j + 1] * player == -1) {
                    int ret_val = reverseBoard(i - 1, j + 1, direction, player);
                    if (ret_val == 0) {
                        field[i][j] = player;
                    }
                    return ret_val;
                } else if (field[i - 1][j + 1] * player == 0) {
                    return 1;
                } else { //can be flipped!
                    field[i][j] = player;
                    return 0;
                }
            } else {
                return 1;
            }
        }

        if (direction == 4) {
            if (0 < j) {
                if (field[i][j - 1] * player == -1) {
                    int ret_val = reverseBoard(i, j - 1, direction, player);
                    if (ret_val == 0) {
                        field[i][j] = player;
                    }
                    return ret_val;
                } else if (field[i][j - 1] * player == 0) {
                    return 1;
                } else { //can be flipped!
                    field[i][j] = player;
                    return 0;
                }
            } else {
                return 1;
            }
        }
        if (direction == 6) {
            if (j < FIELDSIZE - 1) {
                if (field[i][j + 1] * player == -1) {
                    int ret_val = reverseBoard(i, j + 1, direction, player);
                    if (ret_val == 0) {
                        field[i][j] = player;
                    }
                    return ret_val;
                } else if (field[i][j + 1] * player == 0) {
                    return 1;
                } else { //can be flipped!
                    field[i][j] = player;
                    return 0;
                }
            } else {
                return 1;
            }
        }

        if (direction == 7) {
            if (i < FIELDSIZE - 1 && 0 < j) {
                if (field[i + 1][j - 1] * player == -1) {
                    int ret_val = reverseBoard(i + 1, j - 1, direction, player);
                    if (ret_val == 0) {
                        field[i][j] = player;
                    }
                    return ret_val;
                } else if (field[i + 1][j - 1] * player == 0) {
                    return 1;
                } else { //can be flipped!
                    field[i][j] = player;
                    return 0;
                }
            } else {
                return 1;
            }
        }
        if (direction == 8) {
            if (i < FIELDSIZE - 1) {
                if (field[i + 1][j] * player == -1) {
                    int ret_val = reverseBoard(i + 1, j, direction, player);
                    if (ret_val == 0) {
                        field[i][j] = player;
                    }
                    return ret_val;
                } else if (field[i + 1][j] * player == 0) {
                    return 1;
                } else { //can be flipped!
                    field[i][j] = player;
                    return 0;
                }
            } else {
                return 1;
            }
        }
        if (direction == 9) {
            if (i < FIELDSIZE - 1 && j < FIELDSIZE - 1) {
                if (field[i + 1][j + 1] * player == -1) {
                    int ret_val = reverseBoard(i + 1, j + 1, direction, player);
                    if (ret_val == 0) {
                        field[i][j] = player;
                    }
                    return ret_val;
                } else if (field[i + 1][j + 1] * player == 0) {
                    return 1;
                } else { //can be flipped!
                    field[i][j] = player;
                    return 0;
                }
            } else {
                return 1;
            }
        }
        return 1;
    }

    public int passCheck(int player) {
        int valid = 0;
        int endcheck = 0;
        int finalcheckbit = 0;
        int i = 0;
        int j = 0;
        for (i = 0; i < FIELDSIZE; i++) {
            for (j = 0; j < FIELDSIZE; j++) {
                if (field[i][j] != 0) {
                    if (finalcheckbit == 1) {
                        //OK
                    } else if (endcheck == 0){
                        endcheck = field[i][j];
                    } else if (endcheck * field[i][j] == -1){
                        finalcheckbit = 1;
                    }
                    continue;
                }
                if (valid == 0){
                    valid = passCheckSet(i, j, player);
                }
            }
        }
        if (finalcheckbit == 0){
            return -1;
        } else {
            return valid;
        }
    }

    public int passCheckSet(int i, int j, int player) {
        int valid = 0;
        if (0 < i) {
            if (0 < j){
                if (field[i - 1][j - 1] * player == -1) {
                    if (passCheckBoard(i - 1, j - 1, 1, player) == 0) {
                        valid = 1;
                    }
                }
            }
            if (field[i - 1][j] * player == -1) {
                if (passCheckBoard(i - 1, j, 2, player) == 0) {
                    valid = 1;
                }
            }
            if (j < FIELDSIZE - 1){
                if (field[i - 1][j + 1] * player == -1) {
                    if (passCheckBoard(i - 1, j + 1, 3, player) == 0) {
                        valid = 1;
                    }
                }
            }
        }
        if (0 < j){
            if (field[i][j - 1] * player == -1) {
                if (passCheckBoard(i, j - 1, 4, player) == 0) {
                    valid = 1;
                }
            }
        }
        if (j < FIELDSIZE - 1){
            if (field[i][j + 1] * player == -1) {
                if (passCheckBoard(i, j + 1, 6, player) == 0) {
                    valid = 1;
                }
            }
        }
        if (i < FIELDSIZE - 1){
            if (0 < j){
                if (field[i + 1][j - 1] * player == -1) {
                    if (passCheckBoard(i + 1, j - 1, 7, player) == 0) {
                        valid = 1;
                    }
                }
            }
            if (field[i + 1][j] * player == -1) {
                if (passCheckBoard(i + 1, j, 8, player) == 0) {
                    valid = 1;
                }
            }
            if (j < FIELDSIZE - 1){
                if (field[i + 1][j + 1] * player == -1) {
                    if (passCheckBoard(i + 1, j + 1, 9, player) == 0) {
                        valid = 1;
                    }
                }
            }
        }

        return valid;
    }

    public int passCheckBoard(int i, int j, int direction, int player) {
        // returns 1 if none can be flipped and 0 otherwise
        // About variable "direction":
        // Let's say x == fidle[i][j], then
        // 1 2 3
        // 4 x 6
        // 7 8 9
        // e.g. if the value we want to check is in the NE,
        // the "direction" is going to be 3.
        //
        if (direction == 1) {
            if (0 < i && 0 < j) {
                if (field[i - 1][j - 1] * player == -1) {
                    return passCheckBoard(i - 1, j - 1, direction, player);
                } else if (field[i - 1][j - 1] * player == 0) {
                    return 1;
                } else {
                    return 0;
                }
            } else {
                return 1;
            }
        }
        if (direction == 2) {
            if (0 < i) {
                if (field[i - 1][j] * player == -1) {
                    return passCheckBoard(i - 1, j, direction, player);
                } else if (field[i - 1][j] * player == 0) {
                    return 1;
                } else {
                    return 0;
                }
            } else {
                return 1;
            }
        }
        if (direction == 3) {
            if (0 < i && j < FIELDSIZE - 1) {
                if (field[i - 1][j + 1] * player == -1) {
                    return passCheckBoard(i - 1, j + 1, direction, player);
                } else if (field[i - 1][j + 1] * player == 0) {
                    return 1;
                } else {
                    return 0;
                }
            } else {
                return 1;
            }
        }

        if (direction == 4) {
            if (0 < j) {
                if (field[i][j - 1] * player == -1) {
                    return passCheckBoard(i, j - 1, direction, player);
                } else if (field[i][j - 1] * player == 0) {
                    return 1;
                } else {
                    return 0;
                }
            } else {
                return 1;
            }
        }
        if (direction == 6) {
            if (j < FIELDSIZE - 1) {
                if (field[i][j + 1] * player == -1) {
                    return passCheckBoard(i, j + 1, direction, player);
                } else if (field[i][j + 1] * player == 0) {
                    return 1;
                } else {
                    return 0;
                }
            } else {
                return 1;
            }
        }

        if (direction == 7) {
            if (i < FIELDSIZE - 1 && 0 < j) {
                if (field[i + 1][j - 1] * player == -1) {
                    return passCheckBoard(i + 1, j - 1, direction, player);
                } else if (field[i + 1][j - 1] * player == 0) {
                    return 1;
                } else {
                    return 0;
                }
            } else {
                return 1;
            }
        }
        if (direction == 8) {
            if (i < FIELDSIZE - 1) {
                if (field[i + 1][j] * player == -1) {
                    return passCheckBoard(i + 1, j, direction, player);
                } else if (field[i + 1][j] * player == 0) {
                    return 1;
                } else {
                    return 0;
                }
            } else {
                return 1;
            }
        }
        if (direction == 9) {
            if (i < FIELDSIZE - 1 && j < FIELDSIZE - 1) {
                if (field[i + 1][j + 1] * player == -1) {
                    return passCheckBoard(i + 1, j + 1, direction, player);
                } else if (field[i + 1][j + 1] * player == 0) {
                    return 1;
                } else {
                    return 0;
                }
            } else {
                return 1;
            }
        }
        return 1;
    }
    public int player1Number() {
        int sum = 0;
        for (int i = 0; i < FIELDSIZE; i++) {
            for (int j = 0; j < FIELDSIZE; j++) {
                if (field[i][j] == 1) {
                    sum++;
                }
            }
        }
        return sum;
    }
    public int player2Number() {
        int sum = 0;
        for (int i = 0; i < FIELDSIZE; i++) {
            for (int j = 0; j < FIELDSIZE; j++) {
                if (field[i][j] == -1) {
                    sum++;
                }
            }
        }
        return sum;
    }
}
