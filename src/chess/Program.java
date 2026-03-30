package chess;

public class Program {

    public static void main(String[] args) {
        // create 2 players
        Player whitePlayer = new Player("ismail", Game.WHITE);
        Player blackPlayer = new Player("emir", Game.BLACK);


        // create a board
        Board board = new Board();
        // initialize the board
        board.initialize(whitePlayer, blackPlayer);
        //create a game object
        Game game = new Game(whitePlayer, blackPlayer, board);

        // play the game.

        game.play();

    }
}
