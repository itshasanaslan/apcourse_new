package chess.pieces;

import java.util.ArrayList;

import chess.ActionRequest;
import chess.Cell;
import chess.Player;

public class Rook extends Piece {

    public Rook(Cell currentlyOnTheCell, String name, Player belongsToOwner) {
        super(currentlyOnTheCell, name, belongsToOwner);
    }

    public ActionRequest canItMove(Cell toCell) {

        // if the target has different color

        // is moving in straight lines

        // is path clear:
        // if horizontal:
        // do smt

        // else if vertical:
        // do smth

        ActionRequest result = new ActionRequest();
        result.message = "Invalid move!";

        int currentRow = this.getCurrentlyOnTheCell().getRow();
        int currentCol = this.getCurrentlyOnTheCell().getColumn();
        int targetRow = toCell.getRow();
        int targetCol = toCell.getColumn();

        // Check if target cell has a piece of the same color
        if (toCell.getPieceOnMe() != null &&
                toCell.getPieceOnMe().getBelongsToOwner().getColor().equals(this.getBelongsToOwner().getColor())) {
            return result;
        }

        // Rook can only move in straight lines (same row or same column)
        if (currentRow != targetRow && currentCol != targetCol) {
            return result;
        }

        // Check if path is clear
        if (currentRow == targetRow) {
            // Moving horizontally
            int start = Math.min(currentCol, targetCol);
            int end = Math.max(currentCol, targetCol);
            for (int col = start + 1; col < end; col++) {
                if (gameBoard.cells[currentRow][col].getPieceOnMe() != null) {
                    return result;
                }
            }
        } else {
            // Moving vertically
            int start = Math.min(currentRow, targetRow);
            int end = Math.max(currentRow, targetRow);
            for (int row = start + 1; row < end; row++) {
                if (gameBoard.cells[row][currentCol].getPieceOnMe() != null) {
                    return result;
                }
            }
        }

        result.message = "Valid move!";
        result.isSuccessful = true;
        return result;
    }

    @Override
    public ActionRequest move(Cell toCell) {
        ActionRequest isMoveAllowed = this.canItMove(toCell);
        if (isMoveAllowed.isSuccessful) {
            this.setCurrentlyOnTheCell(toCell);
        }
        return isMoveAllowed;
    }

    public int[][] getPossibleLocations() {
        ArrayList<int[]> possibleMoves = new ArrayList<>();
        int currentRow = this.getCurrentlyOnTheCell().getRow();
        int currentCol = this.getCurrentlyOnTheCell().getColumn();

        for (int col = currentCol + 1; col < 8; col++) {
            possibleMoves.add(
                    new int[] { currentRow, currentCol });
            if (gameBoard.cells[currentRow][currentCol].getPieceOnMe() != null) {
                break;
            }
        }

        for (int col = currentCol - 1; col >= 0; col--) {
            possibleMoves.add(
                    new int[] { currentRow, currentCol });
            if (gameBoard.cells[currentRow][currentCol].getPieceOnMe() != null) {
                break;
            }
        }

        for (int row = currentRow + 1; row < 8; row++) {
            possibleMoves.add(
                    new int[] { currentRow, currentCol });
            if (gameBoard.cells[currentRow][currentCol].getPieceOnMe() != null) {
                break;
            }
        }

        for (int row = currentRow - 1; row >= 0; row--) {
            possibleMoves.add(
                    new int[] { currentRow, currentCol });
            if (gameBoard.cells[currentRow][currentCol].getPieceOnMe() != null) {
                break;
            }
        }

        // filter your moves
        ArrayList<int[]> validMoves = new ArrayList<>();
        for (int[] proposedMove: possibleMoves) {
            if (this.canItMove(gameBoard.cells[proposedMove[0]][proposedMove[1]]).isSuccessful) {
                validMoves.add(proposedMove);
            }
        } 

        int[][] result = new int[validMoves.size()][2];

        for (int i = 0; i < validMoves.size(); i++){
            result[i] = validMoves.get(i);
        }
        return result;
    }

}
