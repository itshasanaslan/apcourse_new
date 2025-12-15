package week_06;

import java.util.Scanner;

public class MyApp {

    public static void main(String[] args) {

        /*
         * Scanner sc = new Scanner(System.in);
         * 
         * int times = -1;
         * 
         * while (times < 1) {
         * System.out.print("How many numbers would you like to enter: ");
         * times = sc.nextInt();
         * }
         * 
         * int max = Integer.MIN_VALUE;
         * 
         * for (int i = 1; i <= times; i++) {
         * System.out.print("Enter the " + i + ". number: ");
         * int numberFromUser = sc.nextInt();
         * if (numberFromUser > max) {
         * max = numberFromUser;
         * }
         * 
         * }
         * 
         * System.out.println("Max num is: " + max);
         */

        String text = "Hello";
        // concat
        int occurence = 0;

        for (int i = 0; i < text.length(); i++) {

            // check if they are equal
            if (text.substring(i, i + 1).equals("e")) {
                occurence++;
            }

        }

        System.out.println(text.substring(4, 4 + 1));
    }

    public static void loopComparison() {
        // init
        System.out.println("For: ");
        for (int i = 0; i < 6;) {
            System.out.print(++i + ",");
        }

        int i = 0;
        System.out.println("While: ");
        while (i < 6) {
            System.out.print(++i + ",");
        }

    }

    public static void fancyStuff() {
        Scanner sc = new Scanner(System.in);
        int x = 3, y = 5;
        int max = x > y ? x : y;

    }

    public static void sumOfDigits() {

        Scanner sc = new Scanner(System.in);
        int number = -1;

        while (true) {
            System.out.print("Enter a positive: ");

            number = sc.nextInt();
            if (number < 1)
                break;

        }

        int sum = 0;
        while (number > 0) {
            int digit = number % 10; // get last digit
            sum += digit;
            number = number / 10;
        }

        System.out.println(sum);

        /*
         * Task
         * 
         * Create a Scanner and ask for a positive integer n.
         * 
         * Create a variable int sum = 0;
         * 
         * Use a while loop to extract each digit.
         * 
         * Add the digit to sum.
         * 
         * Chop off the last digit.
         * 
         * Print the final sum.
         * 
         * Example: Input 251 -> Output 8
         */
    }
}
