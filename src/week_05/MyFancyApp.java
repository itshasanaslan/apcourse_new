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
