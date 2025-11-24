package week_04;

import java.util.Scanner;
import javax.crypto.MacSpi;

public class MyApp {

    public static void main(String[] args) {
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
