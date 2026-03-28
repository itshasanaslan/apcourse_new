package chess.pieces;

import java.util.ArrayList;

import chess.ActionRequest;
import chess.Cell;
import chess.Player;

public class Bishop extends Piece {

    public Bishop(Cell currentlyOnTheCell, String name, Player belongsToOwner) {
        super(currentlyOnTheCell, name, belongsToOwner);
    }

    @Override
    public ActionRequest canItMove(Cell toCell) {
        ActionRequest result = new ActionRequest();

        // get the current location on a local variable for easy access
        result.message = "Invalid move";
        int currentRow = this.getCurrentlyOnTheCell().getRow();
        int currentCol = this.getCurrentlyOnTheCell().getColumn();
        int toRow = toCell.getRow();
        int toCol = toCell.getColumn();

        // if it has got the same piece on the target
        if (toCell.getPieceOnMe() != null
                && toCell.getPieceOnMe().getBelongsToOwner().getColor().equals(this.getBelongsToOwner().getColor())) {
            result.message = "You cannot capture your own piece.";
            return result;
        }

        int rowDiff = Math.abs(toRow - currentRow);
        int colDiff = Math.abs(toCol - currentCol);
        // it msut be diagonal
        if (rowDiff != colDiff) {
            result.message = "A bishop can only move diagonally";
            return result;
        }

        // check if the path is clear
        int rowDirection = (toRow > currentRow) ? 1 : -1;
        int colDirection = (toCol > currentCol) ? 1 : -1;

        int row = currentRow + rowDirection;
        int col = currentCol + colDirection;

        while (row != toRow && col != toCol) {
            if (gameBoard.cells[row][col].getPieceOnMe() != null) {
                result.message = "A piece was found on iteration.Terminating";
                return result;
            }

            row += rowDirection;
            col += colDirection;
        }

        result.message = "Valid move";
        result.isSuccessful = true;
        return result;
    }

    @Override
    public int[][] getPossibleLocations() {
        ArrayList<int[]> possibleMoves = new ArrayList<>();
        int currentRow = this.getCurrentlyOnTheCell().getRow();
        int currentCol = this.getCurrentlyOnTheCell().getColumn();

        // initializer list
        int[][] directions = {
                { 1, 1 }, { 1, -1 }, { -1, 1 }, { -1, -1 }
        };

        for (int[] direction : directions) {
            int row = direction[0];
            int col = direction[1];

            // check if index in range
            while (row >= 0 && row < 8 && col >= 0 && col < 8) {
                possibleMoves.add(
                        new int[] { row, col });
                if (gameBoard.cells[row][col].getPieceOnMe() != null) {
                    break;
                    // shift to next direction
                }

                // if not move to next cell on the diagonal path
                row += direction[0];
                col += direction[1];
            }
        }

        // filter your moves
        ArrayList<int[]> validMoves = new ArrayList<>();
        for (int[] proposedMove : possibleMoves) {
            if (this.canItMove(gameBoard.cells[proposedMove[0]][proposedMove[1]]).isSuccessful) {
                validMoves.add(proposedMove);
            }
        }
        int[][] result = new int[validMoves.size()][2];

        for (int i = 0; i < validMoves.size(); i++) {
            result[i] = validMoves.get(i);
        }
        return result;

    }

}
