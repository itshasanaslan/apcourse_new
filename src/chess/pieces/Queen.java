package chess.pieces;

import chess.ActionRequest;
import chess.Cell;
import chess.Player;

public class Queen extends Piece{

    public Queen(Cell currentlyOnTheCell, String name, Player belongsToOwner) {
        super(currentlyOnTheCell, name, belongsToOwner);
   
    }

    @Override
    public ActionRequest canItMove(Cell toCell) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'canItMove'");


        // is a mix of bishop and rook
    }

    @Override
    public int[][] getPossibleLocations() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getPossibleLocations'");
    }

}
