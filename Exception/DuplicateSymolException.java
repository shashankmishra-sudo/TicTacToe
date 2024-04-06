package ProjectsByShashank.TicTacToe.Exception;

public class DuplicateSymolException extends RuntimeException{
    public DuplicateSymolException() {
    }

    public DuplicateSymolException(String message) {
        super(message);
    }

    public DuplicateSymolException(String message, Throwable cause) {
        super(message, cause);
    }

    public DuplicateSymolException(Throwable cause) {
        super(cause);
    }

    public DuplicateSymolException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
