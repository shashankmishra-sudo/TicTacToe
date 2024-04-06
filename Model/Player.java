package ProjectsByShashank.TicTacToe.Model;
import ProjectsByShashank.TicTacToe.Model.Board;

import ProjectsByShashank.TicTacToe.Exception.InvalidMove;

import java.util.Scanner;

public class Player {
    private int playerId;
    private String playerName;
    private char symbol;
    private PlayerType playerType;

    public Player(int playerId, String playerName, char symbol, PlayerType playerType) {
        this.playerId = playerId;
        this.playerName = playerName;
        this.symbol = symbol;
        this.playerType = playerType;
    }

    public int getPlayerId() {
        return playerId;
    }

    public void setPlayerId(int playerId) {
        this.playerId = playerId;
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public void setSymbol(char symbol) {
        this.symbol = symbol;
    }

    public PlayerType getPlayerType() {
        return playerType;
    }

    public void setPlayerType(PlayerType playerType) {
        this.playerType = playerType;
    }

    public char getSymbol() {
        return symbol;
    }

    public void setSymbol(Character symbol) {
        this.symbol = symbol;
    }

    public Move makeMove(Board board){
        Scanner sc=new Scanner(System.in);
        System.out.println(this.playerName+" Please Enter Row For Making Move");
        int row=sc.nextInt();
        System.out.println(this.playerName+" Please Enter Col For Making Move");
        int col=sc.nextInt();
//        ValidateMove(); TODO

        Cell playedCell=board.getMatrix().get(row).get(col);
        playedCell.setCellState(CellState.FILLED);
        playedCell.setPlayer(this);


        return new Move(playedCell,this);

    }



    /* Validate Move TODO
    public void ValidateMove(int numberOfPlayer,int row,int col){
        if(row>numberOfPlayer||col>numberOfPlayer){
            throw new InvalidMove("You have played out of board");
        }
    }

    public void ValidateCellStatus(Cell cell){

    }

     */
}
