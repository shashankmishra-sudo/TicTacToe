package ProjectsByShashank.TicTacToe.Service.botPlayingStratgy;

public class BotPlayStratgyFactory {
    public static BotPlayStratgy getBotPlayStratgy(){
        return new RandomBot();
    }
}
