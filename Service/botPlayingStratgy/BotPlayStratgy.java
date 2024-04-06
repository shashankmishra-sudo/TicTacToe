package ProjectsByShashank.TicTacToe.Service.botPlayingStratgy;

import ProjectsByShashank.TicTacToe.Model.Board;
import ProjectsByShashank.TicTacToe.Model.Move;
import ProjectsByShashank.TicTacToe.Model.Player;

public interface BotPlayStratgy {
    Move makeMove(Board board, Player player);
}
