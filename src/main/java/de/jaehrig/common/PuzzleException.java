package de.jaehrig.common;

public class PuzzleException extends RuntimeException {
    public PuzzleException(Throwable cause) {
        super(cause);
    }

    public PuzzleException(String message) {
        super(message);
    }

    public PuzzleException(final String message, final Throwable cause) {
        super(message, cause);
    }
}
