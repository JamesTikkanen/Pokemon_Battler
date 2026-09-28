import java.util.Scanner;

public class InputHelper {
    public static int readInt(Scanner scanner, String prompt) {
        while (true) {
            System.out.print(prompt);
            String input = scanner.nextLine();
            if (input == null || input.trim().isEmpty()) {
                System.out.println("*CAN NOT LEAVE EMPTY");
                continue;
            }
            try {
                return Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.println("*ONLY WHOLE NUMBERS");
            }
        }
    }
}
