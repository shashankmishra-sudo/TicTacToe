package ProjectsByShashank.TicTacToe.Service.winningStratgy;

import ProjectsByShashank.TicTacToe.Model.Board;
import ProjectsByShashank.TicTacToe.Model.Cell;
import ProjectsByShashank.TicTacToe.Model.Move;
import ProjectsByShashank.TicTacToe.Model.Player;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class OrderOfOneStratgy implements winningStratgy{
    private int numberOfPlayer;
    private List<HashMap<Character,Integer>> rowHashMapList;
    private List<HashMap<Character,Integer>> colHashMapList;
    private HashMap<Character,Integer> leftDiagonal;
    private HashMap<Character,Integer> righDiagonal;
    private HashMap<Character,Integer> corner;

    public OrderOfOneStratgy(int numberOfPlayer){
        rowHashMapList=new ArrayList<>();
        colHashMapList=new ArrayList<>();
        leftDiagonal=new HashMap<>();
        righDiagonal=new HashMap<>();
        corner=new HashMap<>();
        this.numberOfPlayer=numberOfPlayer;
        for(int i=0;i<=numberOfPlayer;i++){
            rowHashMapList.add(new HashMap<>());
            colHashMapList.add(new HashMap<>());
        }

    }


    @Override
    public Player checkWinner(Board board, Move CurrentMove) {
        Player player=CurrentMove.getPlayer();
        char symbol=player.getSymbol();
        int row=CurrentMove.getCell().getRow();
        int col=CurrentMove.getCell().getCol();

        boolean isWinner=((checkCorner(row,col) && checkAndUpdateCornersHashMap(board.getMatrix(),symbol))
                ||checkAndUpdateColHashMap(col,symbol)
                ||checkAndUpdaterowHashMap(row,symbol)
                ||(checkLeftDiagonal(row,col)&&checkAndUpdateleftDiagonalHashMap(symbol))
                ||(checkrightDiagonal(row,col)&&checkAndUpdaterightdiagonalHashMap(symbol))
        );

        if(isWinner){return player;}
        else{return null;}

    }

    public boolean checkLeftDiagonal(int row,int col){
        if(row==col){return true;}
        return false;
    }

    public boolean checkrightDiagonal(int row,int col){
        if(row+col==numberOfPlayer){return true;}
        return false;
    }

    public boolean checkCorner(int row,int col){
        return (
                (row==0&&col==0)
                || (row==0&&col==numberOfPlayer)
                || (row==numberOfPlayer&&col==0)
                || (row==numberOfPlayer&&col==numberOfPlayer)
                );
    }

    public boolean checkAndUpdaterowHashMap(int row,char symbol){
        HashMap<Character,Integer> rowHashMap=rowHashMapList.get(row);
        int count=rowHashMap.getOrDefault(symbol,0);
        count++;
        rowHashMap.put(symbol,count);
        return rowHashMap.get(symbol)==numberOfPlayer+2;
    }

    public boolean checkAndUpdateColHashMap(int col,char symbol){
        HashMap<Character,Integer> colHashMap=rowHashMapList.get(col);
        int count=colHashMap.getOrDefault(symbol,0);
        count++;
        colHashMap.put(symbol,count);
        return colHashMap.get(symbol)==numberOfPlayer+2;
    }

    public boolean checkAndUpdateleftDiagonalHashMap(char symbol){
        int count=leftDiagonal.getOrDefault(symbol,0);
        count++;
        leftDiagonal.put(symbol,count);
        return leftDiagonal.get(symbol)==numberOfPlayer+2;
    }
    public boolean checkAndUpdaterightdiagonalHashMap(char symbol){
        int count=righDiagonal.getOrDefault(symbol,0);
        count++;
        righDiagonal.put(symbol,count);
        return righDiagonal.get(symbol)==numberOfPlayer+2;
    }
    public boolean checkAndUpdateCornersHashMap(List<List<Cell>> matrix,char symbopl){
        int count=corner.getOrDefault(symbopl,0);
        count++;
        corner.put(symbopl,count);
        return corner.get(symbopl)==4;
    }

}
