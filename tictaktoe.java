public class tictaktoe {

    // Method to place a move on the board
    public static void placeMove(char[][] board, int row, int col, char symbol) {
        board[row][col] = symbol;   // update board
    }

    // Utility method to print board (for testing)
    public static void printBoard(char[][] board) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        char[][] board = {
            {'-', '-', '-'},
            {'-', '-', '-'},
            {'-', '-', '-'}
        };

        int row = 1;
        int col = 1;
        char symbol = 'X';

        placeMove(board, row, col, symbol); // place move
        printBoard(board);                  // display updated board
    }
}