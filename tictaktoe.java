import java.util.Random;
import java.util.Scanner;

public class tictaktoe {

    static char[][] board = new char[3][3];
    static char humanSymbol = 'X';
    static char computerSymbol = 'O';
    static String currentPlayer = "Human";

    // UC1: Initialize Board
    public static void initializeBoard() {
        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++)
                board[i][j] = '-';
    }

    // Print Board
    public static void printBoard() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++)
                System.out.print(board[i][j] + " ");
            System.out.println();
        }
    }

    // UC3: User Input
    public static int getUserInput() {
        Scanner sc = new Scanner(System.in);
        int slot;
        while (true) {
            System.out.print("Enter slot (1-9): ");
            slot = sc.nextInt();
            if (slot >= 1 && slot <= 9) return slot;
            System.out.println("Invalid input!");
        }
    }

    // UC4: Convert Slot
    public static int[] convertToIndex(int slot) {
        return new int[]{(slot - 1) / 3, (slot - 1) % 3};
    }

    // UC5: Validate Move
    public static boolean isValidMove(int row, int col) {
        return row >= 0 && row < 3 && col >= 0 && col < 3 && board[row][col] == '-';
    }

    // UC6: Place Move
    public static void placeMove(int row, int col, char symbol) {
        board[row][col] = symbol;
    }

    // UC7: Computer Move
    public static void computerMove() {
        Random rand = new Random();
        while (true) {
            int slot = rand.nextInt(9) + 1;
            int[] idx = convertToIndex(slot);
            if (isValidMove(idx[0], idx[1])) {
                placeMove(idx[0], idx[1], computerSymbol);
                System.out.println("Computer chose: " + slot);
                break;
            }
        }
    }

    // UC8: Check Win
    public static boolean checkWin(char symbol) {
        for (int i = 0; i < 3; i++) {
            if ((board[i][0] == symbol && board[i][1] == symbol && board[i][2] == symbol) ||
                (board[0][i] == symbol && board[1][i] == symbol && board[2][i] == symbol))
                return true;
        }
        return (board[0][0] == symbol && board[1][1] == symbol && board[2][2] == symbol) ||
               (board[0][2] == symbol && board[1][1] == symbol && board[2][0] == symbol);
    }

    // Check Draw
    public static boolean isDraw() {
        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++)
                if (board[i][j] == '-') return false;
        return true;
    }

    public static void main(String[] args) {
        initializeBoard();
        printBoard();

        boolean gameRunning = true;

        while (gameRunning) {

            if (currentPlayer.equals("Human")) {
                int slot = getUserInput();
                int[] idx = convertToIndex(slot);

                if (isValidMove(idx[0], idx[1])) {
                    placeMove(idx[0], idx[1], humanSymbol);
                    currentPlayer = "Computer";
                } else {
                    System.out.println("Invalid move! Try again.");
                    continue;
                }

            } else {
                computerMove();
                currentPlayer = "Human";
            }

            printBoard();

            // Check win
            if (checkWin(humanSymbol)) {
                System.out.println("Human Wins!");
                gameRunning = false;
            } else if (checkWin(computerSymbol)) {
                System.out.println("Computer Wins!");
                gameRunning = false;
            } else if (isDraw()) {
                System.out.println("It's a Draw!");
                gameRunning = false;
            }
        }
    }
}