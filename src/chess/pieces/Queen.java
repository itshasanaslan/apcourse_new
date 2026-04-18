package chess.pieces;

import java.util.ArrayList;

import chess.ActionRequest;
import chess.Cell;
import chess.Player;

public class Queen extends Piece {

    public Queen(Cell currentlyOnTheCell, String name, Player belongsToOwner) {
        super(currentlyOnTheCell, name, belongsToOwner);

    }

    @Override
    public ActionRequest canItMove(Cell toCell) {
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

        // Queen can move like a rook (straight) or bishop (diagonal)
        int rowDiff = Math.abs(targetRow - currentRow);
        int colDiff = Math.abs(targetCol - currentCol);

        // Check if move is either straight or diagonal
        boolean isStraight = (currentRow == targetRow || currentCol == targetCol);
        boolean isDiagonal = (rowDiff == colDiff);

        if (!isStraight && !isDiagonal) {
            return result;
        }

        // Check if path is clear
        if (isStraight) {
            if (currentRow == targetRow) {
                // Moving horizontally
                int start = Math.min(currentCol, targetCol);
                int end = Math.max(currentCol, targetCol);
                for (int col = start + 1; col < end; col++) {
                    if (gameBoard.cells[currentRow][col].getPieceOnMe() != null) {
                        result.isSuccessful = false;
                        return result;
                    }
                }
            } else {
                // Moving vertically
                int start = Math.min(currentRow, targetRow);
                int end = Math.max(currentRow, targetRow);
                for (int row = start + 1; row < end; row++) {
                    if (gameBoard.cells[row][currentCol].getPieceOnMe() != null) {
                        result.isSuccessful = false;
                        return result;
                    }
                }
            }
        } else {
            // Moving diagonally
            int rowDirection = (targetRow > currentRow) ? 1 : -1;
            int colDirection = (targetCol > currentCol) ? 1 : -1;

            int row = currentRow + rowDirection;
            int col = currentCol + colDirection;

            while (row != targetRow && col != targetCol) {
                if (gameBoard.cells[row][col].getPieceOnMe() != null) {
                    result.isSuccessful = false;
                    return result;
                }
                row += rowDirection;
                col += colDirection;
            }
        }

        result.message = "Valid move!";
        result.isSuccessful = true;
        return result;
    }

    @Override
public int[][] getPossibleLocations() {
    ArrayList<int[]> possibleMoves = new ArrayList<>();
    int currentRow = this.getCurrentlyOnTheCell().getRow();
    int currentCol = this.getCurrentlyOnTheCell().getColumn();

    // The Queen combines Rook (orthogonal) and Bishop (diagonal) vectors
    int[][] directions = {
        { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 }, // Rook directions
        { 1, 1 }, { 1, -1 }, { -1, 1 }, { -1, -1 } // Bishop directions
    };

    for (int[] direction : directions) {
        // Initialize search from the cell adjacent to the Queen
        int row = currentRow + direction[0];
        int col = currentCol + direction[1];

        // Slide until the edge of the board is reached
        while (row >= 0 && row < 8 && col >= 0 && col < 8) {
            possibleMoves.add(new int[] { row, col });

            // If a piece is encountered, the path is blocked after this cell
            if (gameBoard.cells[row][col].getPieceOnMe() != null) {
                break;
            }

            // Continue moving in the current direction
            row += direction[0];
            col += direction[1];
        }
    }

    // Reuse your filtering logic to handle same-color captures or check constraints
    return this.filterMoves(possibleMoves);
}
}
