package week_15;

import helpers.ArrayHelpers;

public class App {
    public static void main(String[] args) {
        int[] nums = { 57, 63, 10, 2, 18 };
        selectionSort(nums);
        ArrayHelpers.printArray(nums);

      

        // optimization
        int factorialOfSmt = factorial(-1);
        System.out.println(factorialOfSmt);

    }


    // fibonacci sequence 0, 1, 1, 2, 3, 5, 8, 13, 21, 34
    // write a recursive method
  /*
    . The Fibonacci SequenceWrite a function fibonacci(n) that returns the $n^{th}$ number in the sequence.The Rule:
     Each number is the sum of the two preceding ones ($0, 1, 1, 2, 3, 5, 8, \dots$).Base Cases: fib(0) = 0 and fib(1) = 1.Goal: Calculate fib(7).
  */

public static int fib(int n) {
        // Base Cases
        if (n == 0) return 0;
        if (n == 1) return 1;

        // Recursive Step
        return fib(n - 1) + fib(n - 2);
    }

    
    // recursion
    //recursive method
    // the method keeps calling itself until  a base case

public static int factorial(int x){
    // base case 
    // where should we stop the recursion
    if (x <= 1) return 1;
    return factorial(x - 1) * x;
}

    public static void sayHello(){
        System.out.print("Hello ");
    }

    public static void saySelim(){
                System.out.print(" Selim. ");

    }

    public static void talk(){
                System.out.print(" Are you coding a backend? ");

    }

    public static void temppp() {
        // syntax

        // 2d arrays
        // how to traverse
        // linear search
        // insertion sort

        boolean[][] mines = {
                { true, false, false, true, true, },
                { false, true, false, false, false }, // 1,2
                { false, false, true, false, true, }
        };

        System.out.print(countBombs(1, 2, mines));

        int[] nums = { 4, 1, 5, 7, 3, 2, 9, 8 };

        ArrayHelpers.printArray(nums);
        System.out.println("Sorted");

        // ArrayHelpers.sortArray(nums);

        ArrayHelpers.printArray(nums);

        int[][] matrix = new int[5][5];

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                matrix[i][j] = (int) (Math.random() * (100 - 1 + 1)) + 1;
            }
        }

        ArrayHelpers.print2DArray(matrix);

        int peak = findPeak(matrix);
        System.out.println("Located peak: " + peak);
    }

    public static int findPeak(int[][] grid) {
        int max = grid[0][0];

        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[row].length; col++) {

                // for each item locate the peak
                if (isPeak(grid, row, col)) {
                    // found peak, compare it to others
                    if (grid[row][col] > max) {
                        max = grid[row][col];
                    }
                }

            }
        }

        return max;
    }

    public static boolean isPeak(int[][] grid, int row, int col) {
        int val = grid[row][col];
        int rows = grid.length;
        int cols = grid[0].length;

        for (int r = row - 1; r <= row + 1; r++) {
            for (int c = col - 1; c <= col + 1; c++) {

                // 1. Skip if the current neighbor is the center point itself
                if (r == row && c == col) {
                    continue;
                }

                // 2. Check if the neighbor is within the grid boundaries
                if (r >= 0 && r < rows && c >= 0 && c < cols) {
                    // 3. If any neighbor is strictly greater, it's not a peak
                    if (grid[r][c] > val) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    // if N,S,E,A,NE,NW,SE,SW has true
    public static int countBombs(int r, int c, boolean[][] mines) {
        int count = 0;
        int rows = mines.length;
        int cols = mines[0].length;

        for (int i = r - 1; i <= r + 1; i++) {
            for (int j = c - 1; j <= c + 1; j++) {

                // check boundaries
                if (i >= 0 && i < rows && j >= 0 && j < cols) {
                    // skip the target
                    if (i == r && j == c) {
                        continue;
                    }
                    // check for bomb
                    if (mines[i][j]) {
                        count++;
                    }
                }
            }
        }
        return count;
    }

    public static void selectionSort(int[] array) {

        // [57, 63, 10, 2, 18]

        //
        for (int i = 0; i < array.length - 1; i++) {

            int minIndex = i;

            // compare 57 to all the items on the right

            for (int j = i + 1; j < array.length; j++) {

                if (array[j] < array[minIndex]) {
                    minIndex = j;
                }
            }


              int temp = array[i];
            array[i] = array[minIndex];
            array[minIndex] = temp;

        }

    }
}