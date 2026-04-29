import java.util.Random;

public class tictaktoe {

    // Reuse from UC4
    public static int[] convertToIndex(int slot) {
        int row = (slot - 1) / 3;
        int col = (slot - 1) % 3;
        return new int[]{row, col};
    }

    // Reuse from UC5
    public static boolean isValidMove(char[][] board, int row, int col) {
        if (row < 0 || row > 2 || col < 0 || col > 2) return false;
        return board[row][col] == '-';
    }

    // Reuse from UC6
    public static void placeMove(char[][] board, int row, int col, char symbol) {
        board[row][col] = symbol;
    }

    // UC7: Computer random move
    public static void computerMove(char[][] board, char computerSymbol) {
        Random rand = new Random();
        int slot;
        int row, col;

        while (true) {
            slot = rand.nextInt(9) + 1; // 1–9
            int[] index = convertToIndex(slot);

            row = index[0];
            col = index[1];

            if (isValidMove(board, row, col)) {
                placeMove(board, row, col, computerSymbol);
                System.out.println("Computer chose slot: " + slot);
                break;
            }
        }
    }

    // Utility to print board
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
            {'-', 'X', '-'},
            {'-', '-', '-'}
        };

        char computerSymbol = 'O';

        computerMove(board, computerSymbol);
        printBoard(board);
    }
}