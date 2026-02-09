package week_15;

import helpers.ArrayHelpers;

public class App {
    public static void main(String[] args) {
        // syntax

        // 2d arrays
        // how to traverse
        // linear search

        boolean[][] mines = {
                { true, false, false, true, true, },
                { false, true, false, false, false }, // 1,2
                { false, false, true, false, true, }
        };

        System.out.print(countBombs(1, 2, mines));


        int[] nums = {4,1,5,7,3,2,9,8};

        ArrayHelpers.printArray(nums);
        System.out.println("Sorted");

        //ArrayHelpers.sortArray(nums);
        
        ArrayHelpers.printArray(nums);




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



    public static void sort(int[] array){

        /*
                    
                    write a for loop. Start from index one, to the end
            {
            int key = hold the current value as temporary
            int indexOfLeft = i -1;


            while (is value on the left is greater) {
                    update teh current index with the value on the left.
                    decrement while counter
            }


                array[indexOfleft + 1] = temporary
 }
        
        */





}
