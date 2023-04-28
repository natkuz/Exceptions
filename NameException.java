
public class NameException extends RuntimeException {
    public NameException() {
        super("The name must contain only latin characters");
    }
}
