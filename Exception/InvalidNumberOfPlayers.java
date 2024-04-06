package ProjectsByShashank.TicTacToe.Exception;

public class InvalidNumberOfPlayers extends RuntimeException{
    public InvalidNumberOfPlayers() {
    }

    public InvalidNumberOfPlayers(String message) {
        super(message);
    }

    public InvalidNumberOfPlayers(String message, Throwable cause) {
        super(message, cause);
    }

    public InvalidNumberOfPlayers(Throwable cause) {
        super(cause);
    }

    public InvalidNumberOfPlayers(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
