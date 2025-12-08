package week_05;

import java.util.Scanner;

public class MyFancyApp {
    public static void main(String[] args) {

        int year = 2024;
        boolean isLeap = (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);

        if (isLeap) {
            System.out.println("It's a leap year!");
        }

        else {
            System.out.println("It's not a leap year!");
        }

        // alternatively
        if (year % 4 == 0) {
            if (year % 100 == 0) {
                if (year % 400 == 0) {
                    System.out.println(year + " is a Leap Year");
                } else {
                    System.out.println(year + " is Not a Leap Year");
                }
            } else {
                System.out.println(year + " is a Leap Year");
            }
        } else {
            System.out.println(year + " is Not a Leap Year");
        }

        Scanner sc = new Scanner(System.in);
        int number = 0;

        String command = "show";
        int age;

        // generate a random number between 1-10 inclusive
        // ask the user to find it
        // until the user find,
        // random number guesser game

        while (true) {
            System.out.print("Enter your command: ");
            command = sc.next();
            System.out.println(command);
            if (command.equals("show")) {
                showMenu();
            }

            else if (command.equals("quit")) {
                System.out.println("quitting");
                break;
            }

        }

    }

    // after

    public static void showMenu() {
        System.out.println("quit: quits your program");
        System.out.println("register: registers a new student");
        System.out.println("list: shows you the lsit of the students");
    }

    public static void charSimulator() {
        /*
         * Each “hero” is just a letents input a letter and then apply rules:
         * 
         * 'a'–'z' represent normal characters.
         * 
         * If the letter is between 'a' and 'm', increment it twice (e.g., 'b' → 'd').
         * If between 'n' and 'z', decrement it once
         * 
         * Special cases:
         * 
         * 'x', 'y', 'z' → wrap to 'a', 'b', 'c'
         * 
         * '!' or '?' → print: “Special character detected.”
         * print both the original and final character.
         */

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a letter: ");

        char hero = sc.next().charAt(0); // helloooo everyone! how are you \n
        char newHero = hero;

        if (hero != '!' && hero == '?') {

            if ((hero == 'x' || hero == 'y' || hero == 'z') || (hero == 'X' || hero == 'Y' || hero == 'Z')) {
                newHero -= 23;
            }

            else if ((hero >= 97 && hero <= 109) || (hero >= 65 && hero <= 77)) {
                newHero += 2;
            }

            else if ((hero >= 110 && hero <= 122) || (hero >= 78 && hero <= 90)) {
                newHero--;
            }

        }

        else {
            System.out.println("Special Character deteTced");

        }

        System.out.println("Original letter: " + hero);
        System.out.println("Enhanced letter: " + newHero);
    }

    public static void temp() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter your speed: ");

        boolean isAnOfficer = true;
        int speed = sc.nextInt();
        double balance = 1000; // HGS

        if (speed > 60 && !isAnOfficer) {

            System.out.println("A ticket is issued ");
            balance -= 50;

        }

        System.out.println("Drive safe!");
    }
}
