package ProjectsByShashank.TicTacToe.Exception;

public class InvalidNumberOfBot extends RuntimeException{
    public InvalidNumberOfBot() {
    }

    public InvalidNumberOfBot(String message) {
        super(message);
    }

    public InvalidNumberOfBot(String message, Throwable cause) {
        super(message, cause);
    }

    public InvalidNumberOfBot(Throwable cause) {
        super(cause);
    }

    public InvalidNumberOfBot(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
