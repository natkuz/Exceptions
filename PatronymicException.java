
public class PatronymicException extends RuntimeException {
    public PatronymicException() {
        super("Patronymic must contain only Latin characters");
    }
}
