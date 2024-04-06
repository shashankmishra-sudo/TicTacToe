package ProjectsByShashank.TicTacToe.Service.winningStratgy;

import ProjectsByShashank.TicTacToe.Model.Board;
import ProjectsByShashank.TicTacToe.Model.Move;
import ProjectsByShashank.TicTacToe.Model.Player;

public interface winningStratgy {
    Player checkWinner(Board board, Move CurrentMove);
}
