package exceptions;

public class MemoryOutOfBound extends Exception {

    public MemoryOutOfBound(String errorMessage, Throwable err) {
        super(errorMessage, err);
    }
    public MemoryOutOfBound(String errorMessage) {
        super(errorMessage);
    }
}
