package chess;

import chess.pieces.Piece;

public class Board {

    public static Cell[][] cells;

    public void initialize(Player whitePlayer, Player blackPlayer) {
        // create the cells
        this.cells = new Cell[8][8];
        Piece.setBoardObject(this);

        // create a for loop and initialize the cells
        // without the pieces the on it
        // just colro and location-> on proper position. For example, a8 must be cells[0][0]
    }

}
