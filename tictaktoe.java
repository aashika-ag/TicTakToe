public class tictaktoe {

    // UC10: Check if the game is a draw
    public static boolean isDraw(char[][] board) {

        // Traverse entire board
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {

                // If any cell is empty, it's not a draw
                if (board[i][j] == '-') {
                    return false;
                }
            }
        }

        return true; // No empty cells → draw
    }

    // Test
    public static void main(String[] args) {
        char[][] board = {
            {'X', 'O', 'X'},
            {'X', 'O', 'O'},
            {'O', 'X', 'X'}
        };

        if (isDraw(board)) {
            System.out.println("It's a Draw!");
        } else {
            System.out.println("Game Not Finished");
        }
    }
}