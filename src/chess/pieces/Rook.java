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

    @Override
    public int[][] getPossibleLocations() {
        ArrayList<int[]> possibleMoves = new ArrayList<>();
        int currentRow = this.getCurrentlyOnTheCell().getRow();
        int currentCol = this.getCurrentlyOnTheCell().getColumn();

        // Directions: Right, Left, Down, Up
        int[][] directions = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };

        for (int[] d : directions) {
            int r = currentRow + d[0];
            int c = currentCol + d[1];

            // Slide in the direction until we hit an edge or a piece
            while (r >= 0 && r < 8 && c >= 0 && c < 8) {
                // We add the coordinate {r, c}, not the starting {currentRow, currentCol}
                possibleMoves.add(new int[] { r, c });

                // If there is a piece here, the path is blocked (stop sliding)
                if (gameBoard.cells[r][c].getPieceOnMe() != null) {
                    break;
                }

                r += d[0];
                c += d[1];
            }
        }

        return this.filterMoves(possibleMoves);
    }

}
