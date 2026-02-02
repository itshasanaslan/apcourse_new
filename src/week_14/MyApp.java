package week_14;

import helpers.ArrayHelpers;

public class MyApp {

    public static void main(String[] args) {
            
      //Hangman.run();

        /*
        
            
      int[][] my2DArray = new int[3][3];

      my2DArray[0] = new int[3];
    
        my2DArray[0][2] = 3;

        System.out.print(my2DArray[0][0]);
        System.out.print(",");
          System.out.print(my2DArray[0][1]);
        System.out.print(",");  System.out.print(my2DArray[0][2]);
        System.out.print(",");

        */



        int [][] my2DArray = new int[3][3];
        int counter = 0;
    
        for (int row = 0; row < my2DArray.length; row++ ) {
            for (int col =0; col < my2DArray[row].length ; col++) {
                    my2DArray[row][col] = counter++;
            }
        }


        ArrayHelpers.printArray(my2DArray[0]);
        ArrayHelpers.printArray(my2DArray[1]);
        ArrayHelpers.printArray(my2DArray[2]);





    }
}
