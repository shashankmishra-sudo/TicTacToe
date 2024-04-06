package ProjectsByShashank.TicTacToe.Model;

import DesignPatterns.Factory.componnents.Button.Button;
import ProjectsByShashank.TicTacToe.Exception.DuplicateSymolException;
import ProjectsByShashank.TicTacToe.Exception.InvalidNumberOfBot;
import ProjectsByShashank.TicTacToe.Exception.InvalidNumberOfPlayers;
import ProjectsByShashank.TicTacToe.Service.winningStratgy.winningStratgy;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Game {
    private Board currentBoard;
    private List<Player> players;
    private Player currentPlayer;
    private GameStatus gameStatus;
    private List<Move> moves;
    private List<Board> boardStates;
    private winningStratgy winningStratgy;
    private int numberOfPlayers;
    private boolean isBotPresent;


    private Game(Board currentBoard, List<Player> players, winningStratgy winningStratgy) {
        this.currentBoard = currentBoard;
        this.players = players;
        this.currentPlayer = null;
        this.gameStatus = GameStatus.INPROGRESS;
        this.moves = new ArrayList<>();
        this.boardStates = new ArrayList<>();
        this.winningStratgy = winningStratgy;
        this.isBotPresent = isBotPresent;
        this.numberOfPlayers=players.size();
    }
    public static Builder getBuilderInstance(){
       return new Builder();
    }
    public Board getCurrentBoard() {
        return currentBoard;
    }

    public void setCurrentBoard(Board currentBoard) {
        this.currentBoard = currentBoard;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }

    public Player getCurrentPlayer() {
        return currentPlayer;
    }

    public void setCurrentPlayer(Player currentPlayer) {
        this.currentPlayer = currentPlayer;
    }

    public GameStatus getGameStatus() {
        return gameStatus;
    }

    public void setGameStatus(GameStatus gameStatus) {
        this.gameStatus = gameStatus;
    }

    public List<Move> getMoves() {
        return moves;
    }

    public void setMoves(List<Move> moves) {
        this.moves = moves;
    }

    public List<Board> getBoardStates() {
        return boardStates;
    }

    public void setBoardStates(List<Board> boardStates) {
        this.boardStates = boardStates;
    }

    public ProjectsByShashank.TicTacToe.Service.winningStratgy.winningStratgy getWinningStratgy() {
        return winningStratgy;
    }

    public void setWinningStratgy(ProjectsByShashank.TicTacToe.Service.winningStratgy.winningStratgy winningStratgy) {
        this.winningStratgy = winningStratgy;
    }

    public boolean isBotPresent() {
        return isBotPresent;
    }

    public void setBotPresent(boolean botPresent) {
        isBotPresent = botPresent;
    }


    public static class Builder{
        private Board currentBoard;
        private List<Player> players;
        private winningStratgy winningStratgy;
        private int numberOfPlayers;

        public Builder setCurrentBoard(Board currentBoard) {
            this.currentBoard = currentBoard;
            return this;
        }

        public Builder setPlayers(List<Player> players) {
            this.players = players;
            return this;
        }

        public Builder setWinningStratgy(ProjectsByShashank.TicTacToe.Service.winningStratgy.winningStratgy winningStratgy) {
            this.winningStratgy = winningStratgy;
            return this;
        }
        public Builder setnumberOfPlayers(int numberOfPlayers) {
            this.numberOfPlayers = numberOfPlayers;
            return this;
        }
        //*************Validation**************
        public void validateNoOfPlayers(){
            if(players.size()<2){
                throw new InvalidNumberOfPlayers("Number of Player should be more than 1");
            }
        }

        public void validateUniqueSymbols(){
            HashSet<Character> symbols=new HashSet<>();
            for (Player p:players){
                if(symbols.contains(p.getSymbol())){throw new DuplicateSymolException("Duplicate symbol found");}
                symbols.add(p.getSymbol());
            }
  }
        public void validateNumberOfBot(){
            int botCount=0;
            for (Player p:players){
                if(p.getPlayerType()==PlayerType.BOT){botCount++;}
            }
            if(botCount>1){throw new InvalidNumberOfBot("Maximum 1 bot can play in the game");
            }
        }

        public void validate(){
            validateNoOfPlayers();
            validateNumberOfBot();
            validateUniqueSymbols();
        }

        public Game build(){
            validate();
            return new Game(new Board(numberOfPlayers),players,winningStratgy);
        }

    }




}
