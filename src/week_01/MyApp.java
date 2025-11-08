package week_01;

import java.util.Scanner;

public class MyApp {

    public static void main(String[] args) {

        // data types

        // declare a variable
        int number1;
        int x = 22;
        int y = 0;
        // swapping variables
        int temp = x;
        x = y;
        y = temp;

        // + - * / %
        // PMDAS

        double calculation = 7.0 / 2.0;

        // 3.5
        System.out.print("The result is: ");
        System.out.println(calculation);

        String name = "�smail";
        System.out.println(name);

        System.out.print("Who are you: ");

        Scanner reader = new Scanner(System.in);

        String username = reader.nextLine();
        System.out.print("Hello ");
        System.out.println(username);
        System.out.print("Age ");

        int age = reader.nextInt();
        System.out.println(age + 1);

        // task
        //
        // Write a `main` method that **Imports** and **Instantiates** the `Scanner`.
        // Prompt for **Name**, **ID**, and **GPA** using the correct `Scanner` methods.

    }
}