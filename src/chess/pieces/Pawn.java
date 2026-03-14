package chess.pieces;

import chess.ActionRequest;
import chess.Cell;
import chess.Player;

public class Pawn extends Piece{
    public Pawn(Cell currentlyOnTheCell, String name, Player belongsToOwner){
        super(currentlyOnTheCell, name, belongsToOwner);
    }

    @Override
    public  ActionRequest canItMove(Cell toCell) {
        // in a different
        return new ActionRequest();
    }

    @Override
    public int[][] getPossibleLocations() {
        // TODO Auto-generated method stub
        return null;
    }




    @Override
    public ActionRequest move(Cell toCell) {
        // TODO Auto-generated method stub
        return null;
    }

}
