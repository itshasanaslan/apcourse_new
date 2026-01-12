package my_games;

import java.util.Scanner;

public class LotteryGame {
    private int[] magicNumbers;

    public LotteryGame(int length, int max, int min) {
        magicNumbers = new int[length];

        for (int i = 0; i < magicNumbers.length; i++) {
            magicNumbers[i] = (int) (Math.random() * (max - min + 1)) + min;
        }
    }

    public int[] readFromUser() {
        Scanner input = new Scanner(System.in);
        int[] array = new int[magicNumbers.length];

        for (int i = 0; i < array.length; i++) {
            System.out.print("Enter number " + (i + 1) + ": ");
            array[i] = input.nextInt();
        }

        return array;
      
    }


 
    public boolean hasWon()  {
        int[] userNumbers = readFromUser();

        for (int i = 0; i < magicNumbers.length; i++) {
            if (userNumbers[i] != magicNumbers[i]) {
                return false;
            }
        }

        return true;
    }

    // Prints the lottery numbers (for testing/debugging)
    public void printMagicNumbers() {
        System.out.print("Lottery numbers: ");
        for (int num : magicNumbers) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    
    public static void run(){
        LotteryGame game = new LotteryGame(6, 25, 1);
         game.printMagicNumbers(); // testing purpose
        if (game.hasWon()) {
            System.out.println("You won the lottery!");
        } else {
            System.out.println("Sorry, you lost.");
        }
    }

}
