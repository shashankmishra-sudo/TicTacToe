package ProjectsByShashank.TicTacToe.Model;

import ProjectsByShashank.TicTacToe.Service.botPlayingStratgy.BotPlayStratgyFactory;

public class Bot extends Player{
    private BotDifficultyLevel botDifficultyLevel;
    public Bot(int playerId,BotDifficultyLevel botDifficultyLevel) {
        super(playerId, "BOT", '#', PlayerType.BOT);
        this.botDifficultyLevel=botDifficultyLevel;
    }

    public Move makeMove(Board board){
        return BotPlayStratgyFactory.getBotPlayStratgy().makeMove(board,this);
    }

}
