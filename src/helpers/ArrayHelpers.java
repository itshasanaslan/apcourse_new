package helpers;

public class ArrayHelpers {

    public static int findMax(int[] someArray) {
        int maxValue = Integer.MIN_VALUE;
        for (int index = 0; index < someArray.length; index++) {
            if (someArray[index] > maxValue) {
                maxValue = someArray[index];
            }
        }
        return maxValue;
    }

    public static int findMin(int[] someArray) {
        int minValue = Integer.MAX_VALUE;
        for (int index = 0; index < someArray.length; index++) {
            if (someArray[index] < minValue) {
                minValue = someArray[index];
            }
        }
        return minValue;
    }

    public static void printArray(int[] array) {

        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + ", ");
        }

        System.out.println();
    }

    public static void print2DArray(int[][] grid) {
        for (int[] eachRow : grid) {
            ArrayHelpers.printArray(eachRow);
        }
    }

    public static boolean includes(int[][] grid, int x) {
        // if item x exist in the grid.

        // jsut itereate the rows
        // and the cols
        // if array[row][col] == x;return true;

        for (int row = 0; row < grid.length; row++) {

            for (int col = 0; col < grid[row].length; col++) {
                if (grid[row][col] == x) {
                    return true;
                }
            }
        }

        return false;
    }

    public static int findOccurrences(int[][] grid, int x) {
        int occurs = 0;
        for (int row = 0; row < grid.length; row++) {

            for (int col = 0; col < grid[row].length; col++) {
                if (grid[row][col] == x) {
                    occurs++;
                }
            }
        }

        return occurs;
    }

    public static int[] getLocation(int x, int[][] grid) {
        int[] location = { -1, -1 };
        if (ArrayHelpers.includes(grid, x)) {
            for (int row = 0; row < grid.length; row++) {
                for (int col = 0; col < grid[row].length; col++) {
                    if (grid[row][col] == x) {
                        location[0] = row;
                        location[1] = col;
                    }
                }
            }
        }
        return location;
    }


    public static void sortArray(int[] array) {
        // start from 2nd item
        for (int i = 1; i < array.length; i++ ) {
            int key = array[i];
            int j = i -1;

            while (j >= 0 && array[j] > key) {
                array[j+1] = array[j];
                j--;
            }

            array[j + 1] = key;
        }

    }

}
