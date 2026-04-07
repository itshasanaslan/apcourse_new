package chess.pieces;

import java.util.ArrayList;

import chess.ActionRequest;
import chess.Board;
import chess.Cell;
import chess.Player;

public abstract class Piece {
    public static Board gameBoard;
    private Cell currentlyOnTheCell;
    private String name;
    private Player belongsToOwner;


    public static void setBoardObject(Board board) {
        gameBoard = board;
    }

    public Piece(Cell currentlyOnTheCell, String name, Player belongsToOwner) {
        this.currentlyOnTheCell = currentlyOnTheCell;
        this.name = name;
        this.belongsToOwner = belongsToOwner;
    }

    public Cell getCurrentlyOnTheCell() {
        return currentlyOnTheCell;
    }

    public void setCurrentlyOnTheCell(Cell currentlyOnTheCell) {
        this.currentlyOnTheCell = currentlyOnTheCell;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Player getBelongsToOwner() {
        return belongsToOwner;
    }

    public void setBelongsToOwner(Player belongsToOwner) {
        this.belongsToOwner = belongsToOwner;
    }



    public ActionRequest move(Cell toCell) {
        /* 

        ActionRequest isMoveAllowed = this.canItMove(toCell);
        if (isMoveAllowed.isSuccessful) {
            this.setCurrentlyOnTheCell(toCell);
        }
        return isMoveAllowed;
    }
        */
        return this.canItMove(toCell);
    }
   

    public int[][] filterMoves(  ArrayList<int[]> possibleMoves){

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


    public abstract ActionRequest canItMove(Cell toCell);
   
    public abstract int[][] getPossibleLocations();

    
}
