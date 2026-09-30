package inputcheck;

import model.Type;

import java.util.InputMismatchException;
import java.util.Scanner;

public class InputHelper {
    private static int maxHp = 200;
    private static int minHp = 0;
    private static int maxAtt = 100;
    private static int minAtt = 1;

    public static int readInt(Scanner scanner, String prompt) {
        while (true) {
            System.out.print(prompt);
            String input = scanner.nextLine();
            if (input == null || input.trim().isEmpty()) {
                System.out.println("* Can't leave empty *");
                continue;
            }
            try {
                return Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.println("* Only whole numbers *");
            }
        }
    }

    public static String readString(Scanner scanner, String prompt) {
        while (true) {
            System.out.print(prompt);
            try {
                String input = scanner.nextLine().trim();
                if (input.length() > 20) {
                    System.out.println("* Can't be more than 20 characters *");
                    continue;
                } else if (input == null || input.isBlank()) {
                    System.out.println("* Can't leave name empty *");
                    continue;
                }
                return input;
            } catch (InputMismatchException e) {
                System.out.println("* Invalid, try again *");
                continue;
            }
        }
    }

    public static int readIntHp(Scanner scanner, String prompt) {
        while (true) {
            System.out.print(prompt);
            String input = scanner.nextLine();
            if (input == null || input.trim().isEmpty()) {
                System.out.println("* Can't leave empty *");
                continue;
            }
            try {
                int in = Integer.parseInt(input);
                if (in < minHp || in > maxHp) {
                    System.out.println("* HP must be 1-200 *");
                    continue;
                }
                return in;
            } catch (NumberFormatException e) {
                System.out.println("* Only whole numbers *");
            }
        }
    }


    public static int readIntDamAcc(Scanner scanner, String prompt) {
        while (true) {
            System.out.print(prompt);
            String input = scanner.nextLine();
            if (input == null || input.trim().isEmpty()) {
                System.out.println("* Can't leave empty *");
                continue;
            }
            try {
                int in = Integer.parseInt(input);
                if (in < minAtt || in > maxAtt) {
                    System.out.println("* HP must be 1-100 *");
                    continue;
                }
                return in;
            } catch (NumberFormatException e) {
                System.out.println("* Only whole numbers *");
            }
        }
    }

    public static Type readType(Scanner scanner) {
        while (true) {
            System.out.println("[ Fire | Water | Grass | Electric | Normal ]");
            System.out.print("Write type: ");
            try {
                String input = scanner.nextLine().toUpperCase().trim();
                if (input == null || input.isBlank()) {
                    System.out.println("* Can't leave empty *");
                    continue;
                }
                return Type.valueOf(input);
            } catch (IllegalArgumentException e) {
                System.out.println("* Invalid, try again *");
                continue;
            }
        }
    }
}