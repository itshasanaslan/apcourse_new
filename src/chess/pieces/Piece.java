package chess.pieces;

import chess.ActionRequest;
import chess.Board;
import chess.Cell;
import chess.Player;

public abstract class Piece {
    public static Board gameBoard;
    private Cell currentlyOnTheCell;
    private String name;
    private Player belongsToOwner;


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
        ActionRequest isMoveAllowed = this.canItMove(toCell);
        if (isMoveAllowed.isSuccessful) {
            this.setCurrentlyOnTheCell(toCell);
        }
        return isMoveAllowed;
    }


    public abstract ActionRequest canItMove(Cell toCell);
   
    public abstract int[][] getPossibleLocations();

    
}
