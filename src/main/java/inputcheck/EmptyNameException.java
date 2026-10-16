package inputcheck;
/**
 * Exception mot tomt namn
 */
public class EmptyNameException extends RuntimeException {
    public EmptyNameException(String message) {
        super(message);
    }

    public static void noEmptyName(String name) {
        if (name == null || name.isBlank()) {
            throw new EmptyNameException("* Can't leave name empty *");
        }
    }
}
