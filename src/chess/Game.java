package chess;

import java.util.ArrayList;
import java.util.Scanner;

import chess.pieces.Piece;

public class Game {

    public static final String WHITE = "WHITE"; // constant - final
    public static final String BLACK = "BLACK";

    private Player whitePlayer; // white
    private Player blackPlayer;
    private Board board;
    private Player currentPlayer;
    private ArrayList<Piece> capturedPieces;

    // has game finished or not
    private boolean isGameInProgress;
    // moveCount
    private int moveCount;
    // moves History
    private ArrayList<String> moveHistory;

    public Game(Player player1, Player player2, Board board) {
        this.capturedPieces = new ArrayList<Piece>();
        this.moveHistory = new ArrayList<String>();

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

    public void play() {
        printWelcomeMessage();
        printInstructions();
        Scanner scanner = new Scanner(System.in);

        while (this.isGameInProgress) {
            displayGameState(); // to show which player's turn at the moment
            System.out.println("Enter a command: >>> ");
            String command = scanner.nextLine().toLowerCase();

            try {
                processCommand(command);
                checkGameEnd();
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
                System.out.println("Type 'help' for instructions.");
            }
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
        System.out.println("7. Show captured pieces: 'captured'      (shows captured pieces)");
        System.out.println("8. Quit game:      'quit'");
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
        } else if (command.equals("explain")) {
            explainCurrentPosition();
        }

        else if (command.equals("history")) {
            displayMoveHistory();
        } else if (command.equals("help")) {
            printInstructions();
        } else if (command.equals("draw")) {
            // this.suggestDraw();
        }

        else if (command.equals("captured")) {
            System.out.println("Printing captured pieces");

            for (Piece captured : this.capturedPieces) {
                System.out.println(captured.getName());
            }

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
        for (String log : this.moveHistory) {
            System.out.println(log);
        }
    }

    public boolean isValidPositionFormat(String pos) {
        if (pos == null || pos.length() != 2) {
            return false;
        }
        String cols = "abcdefgh";
        String rows = "12345678";

        String file = pos.substring(0, 1);
        String rank = pos.substring(1, 2);
        return cols.indexOf(file) != -1 && rows.indexOf(rank) != -1;

    }

    // e2 e4
    public boolean isMoveCommand(String command) {
        int spaceIndex = command.indexOf(" ");
        if (spaceIndex == -1) {
            return false;
        }
        String from = command.substring(0, spaceIndex).trim(); // e2
        String to = command.substring(spaceIndex + 1).trim(); // e4
        return isValidPositionFormat(from) && isValidPositionFormat(to);
    }

    public void handleShowCommand(String position) {
        // e2
        int[] coords = convertPosition(position);
        Cell cell = this.board.cells[coords[0]][coords[1]];

        if (cell.getPieceOnMe() == null) {
            System.out.println("No piece at the position " + position);
            return;
        }

        if (cell.getPieceOnMe().getBelongsToOwner() != this.currentPlayer) {
            System.out.println("That's not your piece at position " + position);
            return;
        }

        // show e4

        int[][] possibleLocations = cell.getPieceOnMe().getPossibleLocations();

        if (possibleLocations == null || possibleLocations.length == 0) {
            System.out.println("No valid moves for piece at " + position);
            return;
        }

        // print the board and mark the possible locations
        System.out.println("Possible moves for " + cell.getPieceOnMe().getName() + " at " + position + " : ");
        displayBoardWithPossibleMoves(possibleLocations);

    }

    private void displayBoardWithPossibleMoves(int[][] possibleLocations) {
        String toBeDisplayed = "\n     a  b  c  d  e  f  g  h\n";
        toBeDisplayed += "    -------------------------\n";
        char type = '.';
        for (int row = 0; row < 8; row++) {
            toBeDisplayed += (8 - row) + " | ";

            for (int col = 0; col < 8; col++) {
                Cell cell = this.board.cells[row][col];
                boolean isThisCellInPossibleLocation = false;
                // I am on the cell at the moment here
                // if this cell is in possible locations
                for (int[] targetLocation : possibleLocations) {
                    if (cell.getRow() == targetLocation[0] && cell.getColumn() == targetLocation[1]) {
                        // okay, this cell is in possible locations. Mark it
                        isThisCellInPossibleLocation = true;
                        break;
                    }

                }
                if (isThisCellInPossibleLocation) {
                    toBeDisplayed += " # ";
                } else if (cell.getPieceOnMe() == null) {
                    toBeDisplayed += " . ";
                } else {
                    String pieceName = cell.getPieceOnMe().getName().toUpperCase();
                    boolean isWhite = pieceName.contains(Game.WHITE);
                    if (pieceName.contains("PAWN"))
                        type = 'P';
                    else if (pieceName.contains("ROOK"))
                        type = 'R';
                    else if (pieceName.contains("KNIGH"))
                        type = 'N';
                    else if (pieceName.contains("BISHOP"))
                        type = 'B';
                    else if (pieceName.contains("QUEEN"))
                        type = 'Q';
                    else if (pieceName.contains("KING"))
                        type = 'K';

                    if (!isWhite) {
                        type = Character.toLowerCase(type);
                    }

                    toBeDisplayed += " " + type + " ";
                }
            }

            toBeDisplayed += "  | " + (8 - row) + "\n";
        }

        toBeDisplayed += "    -------------------------\n";

        System.out.println(toBeDisplayed);
    }

    // a2 a3
    public void handleMoveCommand(String command) {
        // command = e2 e4
        if (!isMoveCommand(command)) {
            System.out.println("It's not a valid move command!");
            return;
        }
        int spaceIndex = command.indexOf(" ");
        int[] fromLocation = convertPosition(command);
        String toLocationString = command.substring(spaceIndex + 1).trim(); // e4

        // convert e2 into array indices
        // a = 97, h = 104
        // e

        int[] toLocation = convertPosition(toLocationString);
        int toCol = toLocation[1];
        int toRow = toLocation[0];
        Piece myPiece = this.board.cells[fromLocation[0]][fromLocation[1]].getPieceOnMe();

        if (myPiece == null) {
            System.out.println("No piece at the position " + command);
            return;
        }

        // check for the color; if that's opponent -> return

        if (!myPiece.getBelongsToOwner().getColor().equals(this.currentPlayer.getColor())) {
            System.out.println("It's not your piece you greedy!");
            return;
        }

        Cell targetCell = this.board.cells[toRow][toCol];
        ActionRequest request = myPiece.move(targetCell);

        // action is successful
        if (request.isSuccessful) {

            // we need to store the captured piece somwehee before we capture it.
            if (targetCell.getPieceOnMe() != null) {
                this.capturedPieces.add(targetCell.getPieceOnMe());
            }

            // clean the cell that you moved from
            this.board.cells[toRow][toCol].setPieceOnMe(null);

            // put your piece on the target cell
            targetCell.setPieceOnMe(myPiece);

            // update the new cell on your piece object
            myPiece.setCurrentlyOnTheCell(targetCell);
            // clean the prev loc
            if (request.isSuccessful) {
                this.board.cells[fromLocation[0]][fromLocation[1]].setPieceOnMe(null);

                // a2 a3 WHITE
                String log = moveCount + ") " + command.substring(0, 2) + " " + toLocationString + " ("
                        + this.currentPlayer.getColor() + ")";
                this.moveHistory.add(log);

                this.currentPlayer = this.currentPlayer == blackPlayer ? this.whitePlayer : this.blackPlayer;

            }

        }

        System.out.println(request.message);

        this.moveCount++;

    }

    public int[] convertPosition(String position) {

        // convert e2 into array indices
        // a = 97, h = 104
        // e
        int fromCol = position.charAt(0) - 'a';
        int fromRow = 8 - Character.getNumericValue(position.charAt(1));

        int[] coordinates = { fromRow, fromCol };
        return coordinates;
    }

    public void explainCurrentPosition() {
        // print the number of remaining pieces for both white, black and material
        // difference

        int blackPieces = 0;
        int whitePieces = 0;

        for (Cell[] cellArray : this.board.cells) {

            for (Cell cell : cellArray) {

                if (cell.getPieceOnMe() != null) {
                    if (cell.getPieceOnMe().getBelongsToOwner().getColor().equals(Game.BLACK)) {
                        blackPieces++;
                    }

                    else {
                        whitePieces++;
                    }
                }

            }

            System.out.println("Number of black pieces remaining: " + blackPieces);
            System.out.println("Number of white pieces remaining: " + whitePieces);

        }

        System.out.println("Position explanation has not been implemented yet");
    }


public void checkGameEnd(){
   if (isStaleMate() || isCheckMate() ) {
   // this.isGameInProgress = false;
   }
}


public boolean isStaleMate(){
    return false;
}

    public boolean isCheckMate() {

        Cell currentPlayersKingCell = null;
          for (Cell[] cellArray : this.board.cells) {

            for (Cell cell : cellArray) {

                if (cell.getPieceOnMe() != null && cell.getPieceOnMe().getName().indexOf("King") > -1) {

                    currentPlayersKingCell = cell;
                    
                   int[][] possibleLocationsForTheKing =  currentPlayersKingCell.getPieceOnMe().getPossibleLocations();
                    
                  if ( possibleLocationsForTheKing.length > 0) {
                    // king can move

                    return false;

                  }

                    }
                }
            }

       // no available moves for the king
        
       // check for any other pieces if they have available positions as kings location


       for (int r = 0 ; r < 8; r++) {

            for (int c = 0; c < 8; c++) {


                Piece onTheCell = this.board.cells[r][c].getPieceOnMe(); 

                int[][] possibleLocations = onTheCell.getPossibleLocations();

                for (int[] location: possibleLocations) {

                   if (currentPlayersKingCell != null) {
                     if (location[0] ==  currentPlayersKingCell.getRow() && location[1] == currentPlayersKingCell.getColumn()) {
                        // check mate

                        return true;
                    }
                   }
                } 
            }

       }
       
        return true;
    }

}
