import java.util.Random;

public class tictaktoe
{

    static boolean isHumanTurn;
    static char humanSymbol;
    static char computerSymbol;

    public static void main(String[] args) {
        tossAndAssignSymbols();
        displayTossResult();
    }

    static void tossAndAssignSymbols() {
        Random random = new Random();
        boolean toss = random.nextBoolean();

        if (toss) {
            isHumanTurn = true;
            humanSymbol = 'X';
            computerSymbol = 'O';
        } else {
            isHumanTurn = false;
            humanSymbol = 'O';
            computerSymbol = 'X';
        }
    }

    static void displayTossResult() {
        if (isHumanTurn) {
            System.out.println("Human starts first");
        } else {
            System.out.println("Computer starts first");
        }

        System.out.println("Human symbol: " + humanSymbol);
        System.out.println("Computer symbol: " + computerSymbol);
    }
}