public class tictaktoe {

    // UC9: Check if a player has won
    public static boolean checkWin(char[][] board, char symbol) {

        // Check rows
        for (int i = 0; i < 3; i++) {
            if (board[i][0] == symbol &&
                board[i][1] == symbol &&
                board[i][2] == symbol) {
                return true;
            }
        }

        // Check columns
        for (int j = 0; j < 3; j++) {
            if (board[0][j] == symbol &&
                board[1][j] == symbol &&
                board[2][j] == symbol) {
                return true;
            }
        }

        // Check diagonals
        if (board[0][0] == symbol &&
            board[1][1] == symbol &&
            board[2][2] == symbol) {
            return true;
        }

        if (board[0][2] == symbol &&
            board[1][1] == symbol &&
            board[2][0] == symbol) {
            return true;
        }

        return false; // no win found
    }

    // Test
    public static void main(String[] args) {
        char[][] board = {
            {'X', 'X', 'X'},
            {'-', 'O', '-'},
            {'-', '-', 'O'}
        };

        if (checkWin(board, 'X')) {
            System.out.println("X Wins!");
        } else {
            System.out.println("No Winner Yet");
        }
    }
}