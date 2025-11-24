package week_03;

import java.util.Scanner;

public class App {

    public static void main(String[] args) {

        /*
         * 
         * // an insatnce StudentProfile
         * StudentProfile profile1 = new StudentProfile("Arda", "Ekin", "id3282", false,
         * 3.9);
         * // int x = 3;
         * 
         * // changer(profile1, x);
         * 
         * // System.out.println(x);
         * profile1.info();
         * StudentProfile profile2 = profile1;
         * System.out.println("Profile 2 is below:");
         * profile2.gpa = 0;
         * profile1.info();
         * 
         */

        StudentProfile profile1 = new StudentProfile("Arda", "Ekin", "id3282", false, 3.9);
        StudentProfile profile2 = new StudentProfile("Derin", "asaasas", "id:398983");

        // profile1.info();
        profile1.info(2.3);
        // StudentProfile profile2 = null;

    }

    public static void changer(StudentProfile student, int x) {
        // primitives are passed by value
        // objects are passed by reference
        student.gpa = 2;
        x = 5;
    }

    public static void mondaySession() {

        int x = 64;
        double sqrtOf64 = Math.sqrt(x);
        double absoluteValueOf = Math.abs(-3);
        double powerOfThree = Math.pow(2, 3);

        // 0.0 - 0.9999999
        int min = 35;
        int max = 38;
        // 0, 1, 2, 3
        int value = generateRandomNumber(min, max);
        System.out.println(value);
        // 19.14.35.0213981238712731297371231289
        calculateHypotenuse();

    }

    public static int generateRandomNumber(int min, int max) {
        int randomValue = (int) (Math.random() * (max - min + 1)) + min;
        return randomValue;
    }

    public static void calculateHypotenuse() {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the length of a: ");
        double a = scanner.nextDouble();

        System.out.print("Enter the length of b: ");
        double b = scanner.nextDouble();
        // c = sqrt(a2 + b2))

        double c = Math.sqrt(Math.pow(a, 2) + Math.pow(b, 2));
        System.out.println("Hypotenuse is :" + c);

    }

    public static void budget() {
        Scanner scan = new Scanner(System.in);

        System.out.print("Enter initial budget: ");
        double initialBudget = scan.nextDouble();

        System.out.print("Enter item cost: ");
        double itemCost = scan.nextDouble();

        double remaining = initialBudget - itemCost;

        // absolute difference (used if remaining < 0)
        double absDifference = Math.abs(remaining);

        // truncated integer budget
        int truncatedBudget = (int) remaining;

        System.out.println("Remaining Budget: " + remaining);
        System.out.println("Absolute Difference: " + absDifference);
        System.out.println("Truncated Budget: " + truncatedBudget);
    }

    // method signature
    // static -> we can just call it
    // void -> doesn't return anything
    // method name: sayHello
    // Once it's called, it must be called with a String. Because in the parameter
    // we have a String anything.
    public static void sayHello(String anything) {
        anything = "Arda";
        System.out.println("Hellloo " + anything);
    }

    public static String giveMeAName() {
        String randomName = "emir";
        return randomName;
    }

}
