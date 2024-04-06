package ProjectsByShashank.TicTacToe.Controller;

import ProjectsByShashank.TicTacToe.Model.*;
import ProjectsByShashank.TicTacToe.Service.winningStratgy.WinningStratgyFactory;
import ProjectsByShashank.TicTacToe.Service.winningStratgy.WinningStratgyNames;
import ProjectsByShashank.TicTacToe.Service.winningStratgy.winningStratgy;

import java.util.List;

public class GameController {

    public Game createGame(int noOfPlayers, List<Player> players, WinningStratgyNames names){

        return new Game.Builder()
                .setPlayers(players)
                .setnumberOfPlayers(noOfPlayers)
                .setWinningStratgy(WinningStratgyFactory.getWinningStratgy(names,noOfPlayers))
                .build();
    }

    public void displayTheBoard(Board board){
        board.displayBoard();
    }

    public GameStatus checkGameStatus(Game game){

        return game.getGameStatus();
    }

    public Player getWinner(Game game){

        return game.getCurrentPlayer();
    }

    public Move executeMove(Game game,Player player){

        return player.makeMove(game.getCurrentBoard());
    }

    public Player checkWinner(Game game, Move lastMove){

        return game.getWinningStratgy().checkWinner(game.getCurrentBoard(),lastMove);
    }

    public Board undoMove(Board board,Move lastPlayedMove){

        return null;
    }
    public void replayGame(Game game){

    }
}
