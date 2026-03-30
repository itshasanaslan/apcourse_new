package chess;

import chess.pieces.*;

public class Board {

    public static Cell[][] cells;

    public void initialize(Player whitePlayer, Player blackPlayer) {
        // create the cells
        this.cells = new Cell[8][8];
        Piece.setBoardObject(this);

        // create a for loop and initialize the cells
        // without the pieces the on it
        // just colro and location-> on proper position. For example, a8 must be
        // cells[0][0]

        String color = Game.WHITE;
        for (int row = 0; row < 8; row++) {
            // iterate each letter
            for (int col = 0; col < 8; col++) {
                int[] locationOfTheCell = { row, col };
                color = ((row + col) % 2 == 0) ? Game.WHITE : Game.BLACK;
                Cell tempCell = new Cell(locationOfTheCell, null, color);
                cells[row][col] = tempCell;
            }
        }

        // add the pieces
        this.setUpInitialPositionForPieces(whitePlayer, blackPlayer);
    }

    private void setUpInitialPositionForPieces(Player whitePlayer, Player blackPlayer) {
        for (int col = 0; col < 8; col++) {
            // rows 6 and 1

            // initialize the pawn for both players
            this.cells[6][col].setPieceOnMe(
                    new Pawn(this.cells[6][col], "WhitePawn", whitePlayer));
            this.cells[1][col].setPieceOnMe(
                    new Pawn(this.cells[6][col], "BlackPawn", blackPlayer));
        }

        // place the pieces for the white player
        cells[7][0].setPieceOnMe(new Rook(cells[7][0], "WhiteRook", whitePlayer));
        cells[7][1].setPieceOnMe(new Knight(cells[7][1], "WhiteKnight", whitePlayer));
        cells[7][2].setPieceOnMe(new Bishop(cells[7][2], "WhiteBishop", whitePlayer));
        cells[7][3].setPieceOnMe(new Queen(cells[7][3], "WhiteQueen", whitePlayer));
        cells[7][4].setPieceOnMe(new King(cells[7][4], "WhiteKing", whitePlayer));
        cells[7][5].setPieceOnMe(new Bishop(cells[7][5], "WhiteBishop", whitePlayer));
        cells[7][6].setPieceOnMe(new Knight(cells[7][6], "WhiteKnight", whitePlayer));
        cells[7][7].setPieceOnMe(new Rook(cells[7][7], "WhiteRook", whitePlayer));

        // place the pieces for the black player
        cells[0][0].setPieceOnMe(new Rook(cells[0][0], "BlackRook", blackPlayer));
        cells[0][1].setPieceOnMe(new Knight(cells[0][1], "BlackKnight", blackPlayer));
        cells[0][2].setPieceOnMe(new Bishop(cells[0][2], "BlackBishop", blackPlayer));
        cells[0][3].setPieceOnMe(new Queen(cells[0][3], "BlackQueen", blackPlayer));
        cells[0][4].setPieceOnMe(new King(cells[0][4], "BlackKing", blackPlayer));
        cells[0][5].setPieceOnMe(new Bishop(cells[0][5], "BlackBishop", blackPlayer));
        cells[0][6].setPieceOnMe(new Knight(cells[0][6], "BlackKnight", blackPlayer));
        cells[0][7].setPieceOnMe(new Rook(cells[0][7], "BlackRook", blackPlayer));

    }

    @Override
    public String toString() {
        String toBeDisplayed = "\n     a  b  c  d  e  f  g  h\n";
        toBeDisplayed += "    -------------------------\n";
        char type = '.';
        for (int row = 0; row < 8; row++) {
            toBeDisplayed += (8 - row) + " | ";

            for (int col = 0; col < 8; col++) {
                Cell cell = this.cells[row][col];

                if (cell.getPieceOnMe() == null) {
                    toBeDisplayed += " . ";
                } else {
                    String pieceName = cell.getPieceOnMe().getName().toUpperCase();
                    boolean isWhite = pieceName.contains(Game.WHITE);
                    if (pieceName.contains("PAWN"))
                        type = 'P';
                    else if (pieceName.contains("ROOK"))
                        type = 'R';
                    else if (pieceName.contains("KNIGH"))
                        type = 'N';
                    else if (pieceName.contains("BISHOP"))
                        type = 'B';
                    else if (pieceName.contains("QUEEN"))
                        type = 'Q';
                    else if (pieceName.contains("KING"))
                        type = 'K';

                
                    if (!isWhite) {
                        type = Character.toLowerCase(type);
                    }

                    toBeDisplayed += " " + type + " ";
                }
            }

            toBeDisplayed += "  | " + (8 - row) + "\n"; 
        }

             toBeDisplayed += "    -------------------------\n";

        return toBeDisplayed;
    }

}
