package chess.pieces;

import chess.ActionRequest;
import chess.Cell;
import chess.Player;

public class King extends Piece {

    public King(Cell currentlyOnTheCell, String name, Player belongsToOwner) {
        super(currentlyOnTheCell, name, belongsToOwner);
    }

    @Override
    public ActionRequest canItMove(Cell toCell) {
        ActionRequest result = new ActionRequest();
        result.message = "Invalid move";

        int currentRow = this.getCurrentlyOnTheCell().getRow();
        int currentCol = this.getCurrentlyOnTheCell().getColumn();
        int toRow = toCell.getRow();
        int toCol = toCell.getColumn();

        // if the target has the same color
        if (toCell.getPieceOnMe().getBelongsToOwner().getColor().equals(
                this.getBelongsToOwner().getColor()));

        // king can move ONE square in any direction
        int rowDiff = Math.abs(toRow - currentRow);
        int colDiff = Math.abs(toCol - currentCol);

        /*
         * 1. horizontally rowDiff = 0; colDiff = 1
         * 2. vertically rowDiff = 1, colDiff = 0
         * 3. ONE Square diagonally rowDiff = 1, colDiff = 1
         * if these are okay:
         * return "yaaay"
         * 
         */

        if ((rowDiff <= 1 && colDiff <= 1) && !(rowDiff == 0 && colDiff == 0)) {
            result.message = "Can move successfully";
            result.isSuccessful = true;
        }


        return result;
    }

    @Override
    public int[][] getPossibleLocations() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getPossibleLocations'");
    }

}
