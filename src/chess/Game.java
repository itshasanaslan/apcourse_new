package chess;

import java.util.ArrayList;
import java.util.Scanner;

public class Game {

    public static final String WHITE = "WHITE"; // constant - final
    public static final String BLACK = "BLACK";

    private Player whitePlayer; // white
    private Player blackPlayer;
    private Board board;
    private Player currentPlayer;

    // has game finished or not
    private boolean isGameInProgress;
    // moveCount
    private int moveCount;
    // moves History
    private ArrayList<String> moveHistory;

    public Game(Player player1, Player player2, Board board) {
        if (player1.getColor().equals(Game.WHITE)) {
            this.whitePlayer = player1;
            this.blackPlayer = player2;
        } else {
            this.whitePlayer = player2;
            this.blackPlayer = player1;
        }
        this.board = board;
        this.currentPlayer = this.whitePlayer;
        this.isGameInProgress = true;
        this.moveHistory = new ArrayList<String>();
        this.moveCount = 0;
    }

    public void play(){
        printWelcomeMessage();
        printInstructions();
        Scanner  scanner = new Scanner(System.in);

        while (this.isGameInProgress) {
            displayGameState(); // to show which player's turn at the moment
            System.out.println("Enter a command: >>> ");
            String command = scanner.nextLine().toLowerCase();

            try {
                processCommand(command);
        }

        scanner.close();

    }

    private void printWelcomeMessage() {
        System.out.println("Welcome to Chess 26!");
        System.out.println("========================");
        System.out.println("White player: " + this.whitePlayer.getName());
        System.out.println("Black player: " + this.blackPlayer.getName());
    }

    private void printInstructions() {
   	System.out.println("\nAvailable Commands:");
		System.out.println("1. Move a piece:   'from to'    (e.g., 'e2 e4')");
		System.out.println("2. Show moves:     'show pos'   (e.g., 'show e2')");
		System.out.println("3. View board:     'board'      (shows current position)");
		System.out.println("4. View history:   'history'    (shows all moves)");
		System.out.println("5. Get help:       'help'       (shows this menu)");
        System.out.println("6. Suggest a draw: 'draw'       (suggest a draw)");
		System.out.println("7. Quit game:      'quit'");
		System.out.println("\nPiece symbols:");
		System.out.println("White pieces: P=Pawn, R=Rook, N=Knight, B=Bishop, Q=Queen, K=King");
		System.out.println("Black pieces: p=pawn, r=rook, n=knight, b=bishop, q=queen, k=king");
		System.out.println("Empty squares: .");
		System.out.println("Possible moves: #");
		System.out.println("\nNote: Coordinates use algebraic notation (a-h for columns, 1-8 for rows)");
	}
    

    private void displayGameState() {
        System.out.println("Move " + this.moveCount);
        System.out.println("Current turn for player + " + this.currentPlayer.getName() + "("
                + this.currentPlayer.getColor() + ")");
        System.out.println(this.board);
    }

    
	private void processCommand(String command) {
		if (command.equals("board")) {
			System.out.println(board);
			explainCurrentPosition();
		} else if (command.equals("history")) {
			displayMoveHistory();
		} else if (command.equals("help")) {
			printInstructions();
		} 
        else if (command.equals("draw")) {
            this.suggestDraw();
		} 
        else if (command.equals("quit")) {
			System.out.println("Game ended by user.");
			isGameInProgress = false;
		} else if (command.startsWith("show")) {
			String position = command.substring(4).trim();
			if (isValidPositionFormat(position)) {
				handleShowCommand(position);
			} else {
				System.out.println("Invalid position format. Use letters a-h and numbers 1-8 (e.g., 'show e2')");
			}
		} else if (isMoveCommand(command)) {
			handleMoveCommand(command);
		} else {
			System.out.println("Invalid command. Type 'help' for available commands.");
		}
	}

    public void help() {
        this.printInstructions();
        System.out.println("Helpign method is incomplete");
    }

    public void displayMoveHistory() {
        System.out.println("history method is incomplete");
    }

}
