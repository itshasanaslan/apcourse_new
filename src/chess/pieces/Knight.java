package chess.pieces;

import java.util.ArrayList;

import chess.ActionRequest;
import chess.Board;
import chess.Cell;
import chess.Player;

// inheritance 2025 oop
// file reading

public class Knight extends Piece {

    public Knight(Cell currentlyOnTheCell, String name, Player belongsToOwner) {
        super(currentlyOnTheCell, name, belongsToOwner);
    }

    @Override
    public ActionRequest canItMove(Cell toCell) {
        ActionRequest result = new ActionRequest();
        result.message = "Invalid move";
        int currentRow = this.getCurrentlyOnTheCell().getRow();
        int currentCol = this.getCurrentlyOnTheCell().getColumn();
        int targetRow = toCell.getRow();
        int targetCol = toCell.getColumn();

        // check if the target hsa the same color
        if (toCell.getPieceOnMe() != null &&
                this.getCurrentlyOnTheCell().getPieceOnMe().getBelongsToOwner().getColor()
                        .equals(toCell.getPieceOnMe().getBelongsToOwner().getColor())) {
            result.message = "You cannot your own piece.";

            return result;
        }
        // a knight can only move in an L shape

        int rowDiff = Math.abs(targetRow - currentRow);
        int colDiff = Math.abs(targetCol - currentCol);

        if ((rowDiff * colDiff) == 2) {
            result.message = "Valid move";
            result.isSuccessful = true;
        }

        return result;
    }

    @Override
    public int[][] getPossibleLocations() {
        ArrayList<int[]> possibleMoves = new ArrayList<>();

        int currentRow = this.getCurrentlyOnTheCell().getRow();
        int currentCol = this.getCurrentlyOnTheCell().getColumn();

        // initializer list
        int[][] directions = {
                { -2, -1 }, { -2, 1 },
                { 2, -1 }, { 2, 1 },
                { -1, -2 }, { 1, -2 },
                { -1, 2 }, { 1, 2 }
        };

        for (int[] move: directions) {
            int newRow = currentRow + move[0];
            int newCol = currentCol + move[1];
            if (newRow >= 0 && newRow < 8 && newCol >= 0 && newCol < 8) {
                possibleMoves.add(new int[] {newRow, newCol});
            }
        }
        return this.filterMoves(possibleMoves);
    }

}