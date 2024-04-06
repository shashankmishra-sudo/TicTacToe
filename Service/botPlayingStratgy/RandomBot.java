package ProjectsByShashank.TicTacToe.Service.botPlayingStratgy;


import ProjectsByShashank.TicTacToe.Exception.GameOverException;
import ProjectsByShashank.TicTacToe.Model.*;

import java.util.List;

public class RandomBot implements BotPlayStratgy {
    @Override
    public Move makeMove(Board board, Player bot) {
        List<List<Cell>> matrx=board.getMatrix();
        for(int i=0;i<matrx.size();i++){
            for (int j=0;j<matrx.get(i).size();j++){
                if(matrx.get(i).get(j).getCellState().equals(CellState.ENPTY)){
                    board.getMatrix().get(i).get(j).setPlayer(bot);
                    board.getMatrix().get(i).get(j).setCellState(CellState.FILLED);
                    return new Move(board.getMatrix().get(i).get(j),bot);
                }
            }
        }
        throw new GameOverException("There are no empty cell");
    }
}
