package nl.hu.vkbep.example.lingo.words.core.ports.exception;

public class CannotWriteWords extends RuntimeException {
    private CannotWriteWords(Throwable cause) {
        super(cause);
    }

    public static CannotWriteWords because(Throwable cause) {
        return new CannotWriteWords(cause);
    }
}
