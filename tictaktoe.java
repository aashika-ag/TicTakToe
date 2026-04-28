import java.util.Scanner;

public class tictaktoe {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int slot = getUserSlot(scanner);
        System.out.println("Slot entered: " + slot);
        scanner.close();
    }

    static int getUserSlot(Scanner scanner) {
        int slot = scanner.nextInt();
        return slot;
    }
}