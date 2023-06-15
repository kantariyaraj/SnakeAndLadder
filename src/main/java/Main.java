import snakeandladder.model.Board;
import snakeandladder.model.Dice;
import snakeandladder.model.Game;
import snakeandladder.model.Player;
import snakeandladder.model.specialentity.Ladder;
import snakeandladder.model.specialentity.Snake;

public class Main {
    public static void main(String[] args) throws Exception {
        Board board = new Board(10);

        //Add Snakes in the board
        board.addSpecialEntity(new Snake(17, 7));
        board.addSpecialEntity(new Snake(62, 19));
        board.addSpecialEntity(new Snake(54, 34));
        board.addSpecialEntity(new Snake(64, 60));
        board.addSpecialEntity(new Snake(87, 36));
        board.addSpecialEntity(new Snake(93, 73));
        board.addSpecialEntity(new Snake(95, 75));
        board.addSpecialEntity(new Snake(98, 79));

        //Add Ladders in the board
        board.addSpecialEntity(new Ladder(1, 38));
        board.addSpecialEntity(new Ladder(4, 14));
        board.addSpecialEntity(new Ladder(9, 31));
        board.addSpecialEntity(new Ladder(28, 84));
        board.addSpecialEntity(new Ladder(21, 42));
        board.addSpecialEntity(new Ladder(51, 67));
        board.addSpecialEntity(new Ladder(72, 91));
        board.addSpecialEntity(new Ladder(80, 99));

        Player player1 = new Player("Foo");
        Player player2 = new Player("Bar");

        Game game = new Game(board, new Dice(6));

        game.addPlayer(player1);
        game.addPlayer(player2);

        game.startGame();
    }
}