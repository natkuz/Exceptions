
public class SurnameException extends RuntimeException {
    public SurnameException() {
        super("Last name must contain only latin characters");
    }
}
