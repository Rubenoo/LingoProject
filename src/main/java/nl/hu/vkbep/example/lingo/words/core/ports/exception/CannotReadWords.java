package nl.hu.vkbep.example.lingo.words.core.ports.exception;

public class CannotReadWords extends RuntimeException {
    private CannotReadWords(Throwable cause) {
        super(cause);
    }

    public static CannotReadWords because(Throwable cause) {
        return new CannotReadWords(cause);
    }
}
