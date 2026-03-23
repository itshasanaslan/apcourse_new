package chess.pieces;

import chess.ActionRequest;
import chess.Cell;
import chess.Player;

public class Rook extends Piece {

    public Rook(Cell currentlyOnTheCell, String name, Player belongsToOwner){
        super(currentlyOnTheCell, name, belongsToOwner);
    }

    public ActionRequest canItMove(Cell toCell){


        // if the target has different color

        // is moving in straight lines

        // is path clear:
            // if horizontal:
                    // do smt

            // else if vertical:
                // do smth

        return new ActionRequest();
    }

     @Override
    public ActionRequest move(Cell toCell) {
        ActionRequest isMoveAllowed = this.canItMove(toCell);
        if (isMoveAllowed.isSuccessful) {
            this.setCurrentlyOnTheCell(toCell);
        }
        return isMoveAllowed;
    }
   
    public int[][] getPossibleLocations(){
        int[][] x = new int[1][1];
        return x;

}

}



