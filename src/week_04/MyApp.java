package week_04;

import java.util.Scanner;

public class MyApp {

    public static void main(String[] args) {

    }

    public static void ifStatements() {
        // and && &
        // or
        // not !
        // 1.5 1.8
        // max age 15
        // your parent allowed

        int age = 16;
        boolean isOlderThan = age >= 18;
        boolean hasParentPermission = false;
        int number = 3;
        if (hasParentPermission) {
            System.out.println("You can join");
            hasParentPermission = false;
            number += 1;
        }

        number += 1;

        // compound operators
        // boolean canJoinTheTrip = isYoungerThan15 && hasParentPermission;
        boolean canJoinTheTrip = isOlderThan || hasParentPermission;
        System.out.println("Student can join the trip: " + canJoinTheTrip);
    }

    public static void booleanIntro() {
        // control structures

        // scanenr object reading age from the user
        int age = 19;
        boolean canDrive = age >= 18; // true

        String apple = "apple";
        String banana = "banana";

        int value = apple.compareTo(banana); // -1

        boolean doesAppleComeFirst = value < 0;

        boolean a = true;
        boolean b = false;

        boolean result = a != b;

        int die1 = rollADice();
        int die2 = rollADice();
        boolean isDouble = die1 == die2;
        System.out.println("Rolls: " + die1 + ", " + die2);
        System.out.println("Doubles? " + isDouble);

        int num1 = 953;
        boolean isEven = (num1 % 2 == 0);
        boolean isOdd = (num1 % 2 == 1);
        System.out.println("Is number even: " + isEven);
        System.out.println("Is number odd: " + isOdd);
    }

    public static int rollADice() {
        int min = 1;
        int max = 6;
        int x = (int) (Math.random() * (max - min + 1)) + 1;
        return x;
    }

    public static void tempp() {
        // OOP
        // STrings are immutable
        String text1 = "Hello"; // string pool
        String text2 = "Hello"; // string pool
        String text3 = new String("Hello");

        boolean areTheyTheSame = text1 == text3;

        System.out.println(areTheyTheSame);

        String story = "Once upon a time!";
        int length = story.length();
        System.out.println(length);

        // the third letter on an instance.
        // lettter is a char
        char theThirdLetter = story.charAt(3 - 1);
        System.out.println(theThirdLetter);

        String name = "mehmet duran"; // this is from scanner Mehmet Duran
        int indexOfSpace = name.indexOf(" ");

        String firstName = name.substring(0, indexOfSpace);
        // " " 4
        String lastName = name.substring(indexOfSpace + 1);
        System.out.println(firstName.toUpperCase() + " " + lastName.toUpperCase());
        System.out.println(firstName + " " + lastName.toLowerCase());

        String newName = nameAdjuster("mehmet duran");
        System.out.println(newName); // Arda Ekin

        String name1 = "mehmet";
        String name2 = "mehmet";

        // Java Quick Reference Sheet for ap exam
        int x = name1.compareTo(name2);
        boolean comesFirst = x < 0;
        System.out.println("The name " + name1 + " comes first: " + comesFirst);

        // substring
        // length
        // indexOf
        // toLower
        // toUpper
        // compareTo

        // Apple Banana
        // apple.compareTo(banana)
    }

    public static String nameAdjuster(String fullname) {
        int indexOfSpace = fullname.indexOf(" ");
        String firstName = fullname.substring(0, indexOfSpace);
        String lastName = fullname.substring(indexOfSpace + 1); // ekin
        String modifiedName = firstName.substring(0, 1).toUpperCase() + firstName.substring(1, indexOfSpace);
        String modifiedLastName = lastName.substring(0, 1).toUpperCase() + lastName.substring(1);
        return modifiedName + " " + modifiedLastName;
    }

}
