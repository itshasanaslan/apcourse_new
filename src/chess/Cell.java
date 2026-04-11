package chess;

import chess.pieces.Piece;

// each cell is a square
public class Cell {
    private char columnLetter; // implement the logic
    private int[] location; // [0, 1]
    private Piece pieceOnMe;
    private String color;

    public char getColumnLetter() {
        return columnLetter;
    }

    public void setColumn(char column) {
        this.columnLetter = column;
    }

    public int[] getLocation() {
        return location;
    }

    public int getRow() {
        return this.location[0];
    }

    public int getColumn() {
        return this.location[1];
    }

    public void setLocation(int[] location) {
        this.location = location;
    }

    public Piece getPieceOnMe() {
        return pieceOnMe;
    }

    public void setPieceOnMe(Piece pieceOnMe) {
        this.pieceOnMe = pieceOnMe;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Cell(int[] location, Piece pieceOnme, String color) {
        this.location = location;
        this.pieceOnMe = pieceOnme;
        this.color = color;
    }

}
