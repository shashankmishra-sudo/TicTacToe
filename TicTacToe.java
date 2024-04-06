package ProjectsByShashank.TicTacToe;

import ProjectsByShashank.TicTacToe.Controller.GameController;
import ProjectsByShashank.TicTacToe.Model.*;
import ProjectsByShashank.TicTacToe.Service.winningStratgy.WinningStratgyNames;

import java.util.*;

public class TicTacToe {
    public static void main(String[] args) {
        System.out.println("*****Welcome To The Game*****");
        Scanner sc=new Scanner(System.in);
        List<Player> players=new ArrayList<>();
        int id=1;
        int noOfPlayer=0;
        System.out.println("Do you want BOT in the game? Y | N");
        char isRequiredBot=sc.next().charAt(0);
        if(isRequiredBot=='y'||isRequiredBot=='Y'){
            Bot bot=new Bot(id++, BotDifficultyLevel.DIFFICULT);
            players.add(bot);
            noOfPlayer++;
        }
        System.out.println("How many human player with you");
        noOfPlayer+= sc.nextInt();
        while (id<=noOfPlayer){
            System.out.println("Enter The Player Name");
            String playerName=sc.next();
            System.out.println("Enter The Player Symbol : REMMEMBER You can not use # because it is symbol of BOT");
            char playerSymbol=sc.next().charAt(0);
            Player playerObj=new Player(id++,playerName,playerSymbol, PlayerType.HUMAN);
            players.add(playerObj);
        }
        Collections.shuffle(players);

        GameController gameController=new GameController();
        Game game=gameController.createGame(noOfPlayer,players, WinningStratgyNames.ORDDERONE);
        int playerIdx=-1;
        while (game.getGameStatus().equals(GameStatus.INPROGRESS)){
            System.out.println("Current Board States");
            gameController.displayTheBoard(game.getCurrentBoard());
            playerIdx++;
            playerIdx=playerIdx%noOfPlayer;
           Move playedMove= gameController.executeMove(game,players.get(playerIdx));
           Player winner=gameController.checkWinner(game,playedMove);

           if(winner!=null){
               System.out.println("Winner Is : "+winner.getPlayerName());
               break;
           }
           if(game.getMoves().size()==((noOfPlayer+1)*(noOfPlayer+1))){
               System.out.println("Game Is Draw");
               break;
           }

        }
        System.out.println("Final Board States ");
        gameController.displayTheBoard(game.getCurrentBoard());

        System.out.println("Do You Want To Replay?");

    }
}
