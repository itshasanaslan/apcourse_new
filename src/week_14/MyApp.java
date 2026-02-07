package week_14;

import helpers.ArrayHelpers;
import week_03.StudentProfile;

public class MyApp {

  public static StudentProfile[][] chessboard = new StudentProfile[8][8];

  public static void main(String[] args) {
    // accumulator

    int[][] grid = new int[5][5];

    for (int row = 0; row < grid.length; row++) {

      for (int col = 0; col < grid[row].length; col++) {
        // 1-10
        grid[row][col] = (int) (Math.random() * (9 - 1 + 1)) + 1;
      }
    }

    ArrayHelpers.print2DArray(grid);

    if (ArrayHelpers.includes(grid, 11)) {
      System.out.print("It includes " + 11);
      System.out.print(" " + ArrayHelpers.findOccurrences(grid, 11) + " times.");
    }
    // Linear search

  }

  public static int sumOf2DArray(int[][] array) {
    // calculate the sum of all items in the array

    int counter = 0;

    for (int[] row : array) {
      for (int col : row) {
        counter += col;
      }
    }

    return counter;
  }

  public static int[] getSumsOfRows(int[][] array) {

    int[] sumsOfRows = new int[array.length];

    int rowIndex = 0;
    for (int[] row : array) {
      int counter = 0;
      for (int value : row) {
        counter = counter + value;
      }

      sumsOfRows[rowIndex] = counter;
      rowIndex++;
      // put the sum into the array

    }

    return sumsOfRows;
  }

  public static void mondaySession() {
    // Hangman.run();

    /*
     * 
     * 
     * int[][] my2DArray = new int[3][3];
     * 
     * my2DArray[0] = new int[3];
     * 
     * my2DArray[0][2] = 3;
     * 
     * System.out.print(my2DArray[0][0]);
     * System.out.print(",");
     * System.out.print(my2DArray[0][1]);
     * System.out.print(","); System.out.print(my2DArray[0][2]);
     * System.out.print(",");
     * 
     */

    int[][] my2DArray = new int[3][3];
    int counter = 0;

    for (int row = 0; row < my2DArray.length; row++) {
      for (int col = 0; col < my2DArray[row].length; col++) {
        my2DArray[row][col] = counter++;
      }
    }

    ArrayHelpers.printArray(my2DArray[0]);
    ArrayHelpers.printArray(my2DArray[1]);
    ArrayHelpers.printArray(my2DArray[2]);

  }
}
