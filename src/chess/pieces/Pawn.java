package chess.pieces;

import chess.ActionRequest;
import chess.Board;
import chess.Cell;
import chess.Game;
import chess.Player;


// inheritance 2025 oop
// file reading

public class Pawn extends Piece{


    public Pawn(Cell currentlyOnTheCell, String name, Player belongsToOwner){
        super(currentlyOnTheCell, name, belongsToOwner);
    }

    @Override
    public  ActionRequest canItMove(Cell toCell) {
        ActionRequest result = new ActionRequest();
        result.message = "Invalid move";

        int currentRow = this.getCurrentlyOnTheCell().getRow(); // there's an issue here
        int currentCol = this.getCurrentlyOnTheCell().getColumn();
        int toRow = toCell.getRow();
        int toCol = toCell.getColumn();

        int direction = this.getBelongsToOwner().getColor().equals(Game.WHITE) ? -1 : 1;

    // move one forward
        if (toCol == currentCol && toRow == currentRow + direction) {
            if (toCell.getPieceOnMe() ==  null) {
                result.isSuccessful = true;
                result.message = "The pawn moved forward one square.";
                return result;
            }
        }

    // move two forward if hasn't moved before
    boolean isFirstMove = (direction == -1 && currentRow == 6) || (direction == 1 && currentRow == 1);

 
    if (isFirstMove && currentCol == toCol  && toRow == currentRow + (2 * direction)) {
        if (toCell.getPieceOnMe()==null &&  Piece.gameBoard.cells[currentRow + direction][currentCol].getPieceOnMe() == null ) {
            result.isSuccessful = true;
            result.message = "The pawn moved forward two squares.";
            return result;
        }

    }


    // diagonal captures    
        if (toRow == currentRow+direction && Math.abs(toCol - currentCol) == 1) {
            if (toCell.getPieceOnMe() != null && !toCell.getPieceOnMe().getBelongsToOwner().equals(this.getBelongsToOwner())) {
                result.isSuccessful = true;
                result.message = "The pawn moved diagonally and captured a piece.";
                return result;
            }

        }
        return result;
    }

    @Override
    public int[][] getPossibleLocations() {
        // TODO Auto-generated method stub
        return null;
    }

 // show c2
 
}


