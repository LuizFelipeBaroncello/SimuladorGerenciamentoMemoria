package exceptions;

public class ProcessNotFound extends Exception{
    public ProcessNotFound(String errorMessage, Throwable err) {
        super(errorMessage, err);
    }
    public ProcessNotFound(String errorMessage) {
        super(errorMessage);
    }
}
