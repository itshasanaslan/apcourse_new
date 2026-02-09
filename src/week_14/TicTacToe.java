package week_14;

import java.util.Scanner;

public class TicTacToe {
    private char[][] board;
    private char currentPlayer;

    public TicTacToe() {
        board = new char[3][3];
        currentPlayer = 'X';
        initializeBoard();
    }

    // Fill the board with dashes to start
    public void initializeBoard() {
        for (int r = 0; r < 3; r++) {
            for (int c = 0; c < 3; c++) {
                board[r][c] = '-';
            }
        }
    }

    public void printBoard() {
        for (int r = 0; r < 3; r++) {
            for (int c = 0; c < 3; c++) {
                System.out.print(board[r][c] + " ");
            }
            System.out.println();
        }
    }

    // Check if the board is full (for a draw)
    public boolean isBoardFull() {
        for (int r = 0; r < 3; r++) {
            for (int c = 0; c < 3; c++) {
                if (board[r][c] == '-')
                    return false;
            }
        }
        return true;
    }

    public boolean checkForWin() {
        return (checkRows() || checkCols() || checkDiagonals());
    }

    private boolean checkRows() {
        for (int r = 0; r < 3; r++) {
            if (board[r][0] != '-' && board[r][0] == board[r][1] && board[r][1] == board[r][2])
                return true;
        }
        return false;
    }

    private boolean checkCols() {
        for (int c = 0; c < 3; c++) {
            if (board[0][c] != '-' && board[0][c] == board[1][c] && board[1][c] == board[2][c])
                return true;
        }
        return false;
    }

    private boolean checkDiagonals() {
        return ((board[0][0] != '-' && board[0][0] == board[1][1] && board[1][1] == board[2][2]) ||
                (board[0][2] != '-' && board[0][2] == board[1][1] && board[1][1] == board[2][0]));
    }

    // Main game loop
    public static void run() {
        Scanner scan = new Scanner(System.in);
        TicTacToe game = new TicTacToe();
        boolean gameEnded = false;

        while (!gameEnded) {
            game.printBoard();
            System.out.println("Player " + game.currentPlayer + ", enter row and col (0-2): ");
            int row = scan.nextInt();
            int col = scan.nextInt();

            if (row >= 0 && row < 3 && col >= 0 && col < 3 && game.board[row][col] == '-') {
                game.board[row][col] = game.currentPlayer;

                if (game.checkForWin()) {
                    game.printBoard();
                    System.out.println("Player " + game.currentPlayer + " wins!");
                    gameEnded = true;
                } else if (game.isBoardFull()) {
                    game.printBoard();
                    System.out.println("It's a draw!");
                    gameEnded = true;
                } else {
                    // Switch players
                    game.currentPlayer = (game.currentPlayer == 'X') ? 'O' : 'X';
                }
            } else {
                System.out.println("Invalid move. Try again.");
            }
        }
        scan.close();
    }
}