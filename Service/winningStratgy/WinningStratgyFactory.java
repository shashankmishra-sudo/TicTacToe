package ProjectsByShashank.TicTacToe.Service.winningStratgy;

public class WinningStratgyFactory {
    public static winningStratgy getWinningStratgy(WinningStratgyNames names,int numberOfPlayers) {
        return new OrderOfOneStratgy(numberOfPlayers);
    }
}
