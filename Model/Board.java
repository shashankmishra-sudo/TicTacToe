package ProjectsByShashank.TicTacToe.Model;

import java.util.ArrayList;
import java.util.List;

public class Board {
    private int numberOfPlayer;
    private List<List<Cell>> matrix;

    public int getNumberOfPlayer() {
        return numberOfPlayer;
    }

    public void setNumberOfPlayer(int numberOfPlayer) {
        this.numberOfPlayer = numberOfPlayer;
    }

    public List<List<Cell>> getMatrix() {
        return matrix;
    }

    public void setMatrix(List<List<Cell>> matrix) {
        this.matrix = matrix;
    }

    public Board(int numberOfPlayer) {
        this.numberOfPlayer = numberOfPlayer;
        this.matrix = new ArrayList<>();
        for(int i=0;i<=numberOfPlayer;i++){
            matrix.add(new ArrayList<>());
            for (int j=0;j<=numberOfPlayer;j++){
                matrix.get(i).add(new Cell(i,j));
            }
        }
    }

    public void displayBoard(){
        for(int i=0;i<=numberOfPlayer;i++){
            List<Cell> outer=matrix.get(i);
            for(Cell c:outer){
                c.displayCell();
            }
            System.out.println();
        }
    }
}
