package inputcheck;

/**
 * Exception mot namn över 20 karaktärer
 */
public class NameLengthException extends RuntimeException {
    public NameLengthException(String message) {
        super(message);
    }
    public static void nameCheckLength(String name){
        if (name.length() > 20) {
            throw new NameLengthException("* Name can't be longer than 20 characters *");
        }
    }
}
