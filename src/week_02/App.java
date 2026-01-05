package week_02;

import java.util.Scanner;

public class App {

    public static void main(String[] args) {

    
        Scanner scanner = new Scanner(System.in);
        // areaOfTwoTriangles();
        // System.out.println("What's your name: ");
        // String name = scanner.nextLine();
        // parameters
        // sayHello(name);
        // b
        // default val
        // char
        int number = 10;

        // passing value (copy)
        printMyNumber(number);

        System.out.println(number);
        String name = null;

        System.out.println(name);

        boolean isOverEighteen = false;

        // if statements
        // check if user is above eigghren yeras old
        // if so she can drive
        // if not he cannot drive

        char letter = 'a';

        System.out.println(letter + 1);

    }

    // signature of the method
    public static void sayHello(String xaaa) {
        System.out.println("Hello " + xaaa + "! .Welcome to our course");
    }

    public static void printMyNumber(int x) {
        // x = x + 1; //incrementation
        // compound operators
        x += 1000;
        x /= 3; // x = x / 3
        x *= 3; // x = x * 3
        x -= 3; // x = x - 3
        x++; // only by one
        x--; // only by one

        System.out.println("Your number is " + x);
    }

    public static double areaOfTriangle() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the length: ");
        double l = scanner.nextDouble();
        System.out.print("Enter the width: ");
        double w = scanner.nextDouble(); // method

        double area = l * w / 2;
        System.out.println("Area of this triangle is: " + area);

        // return
        return area;
    }

    public static void areaOfTwoTriangles() {

        // method
        // calculate the combined area of two triangles
        // get the length
        // get the height
        // multiply l and h
        // divide step 4 by 2.
        double areaOfTriangleOne = areaOfTriangle();

        double areaOfTriangleTwo = areaOfTriangle();

        System.out.println(
                "Area of triangle one and two are respectively: " + areaOfTriangleOne + " " + areaOfTriangleTwo);
        double combinedArea = areaOfTriangleOne + areaOfTriangleTwo;

    }

    public static int readNumberFromTheUser() {
        // open scanner
        // print somet
        // read
        return 992;
    }

    public static String giveMeAName() {
        return "mehmet";
    }

    public static void mondaySummary() {

        // a final variable cannot be changed.
        final double PI_VALUE = 3.14159;

        // Initialize the Scanner object to read keyboard input (System.in).
        Scanner scanner = new Scanner(System.in);

        // --- SECTION 1: CASTING (PRIMITIVE TYPE CONVERSION) ---
        System.out.println("--- 1. Casting Demonstration ---");

        // 1.1 Narrowing Conversion (Double to Int)
        // Explicit casting (int) is REQUIRED because data is lost.
        int wholeNumberPi = (int) PI_VALUE;

        // Extra -> We can actuall print stuff using the method below. It's called
        // String Concatenation. More on Saturday.
        System.out.println("Original Pi (double): " + PI_VALUE);
        System.out.println("Casting to int: " + wholeNumberPi + " (Decimal data lost: 3.14 becomes 3)");

        // 1.2 Widening Conversion (Int to Double)
        // This is automatic (implicit) because no data is lost.
        int num7 = 7;
        int num2 = 2;

        // To perform floating-point division, one operand MUST be cast to double.
        double average = (double) num7 / num2;
        System.out.println("\nInteger division: 7 / 2 = " + (num7 / num2)); // Output: 3
        System.out.println("Casted division: 7.0 / 2 = " + average); // Output: 3.5

        // --- SECTION 2: PARSING (STRING TO PRIMITIVE CONVERSION) ---
        System.out.println("\n--- 2. String Parsing Demonstration ---");

        String stringGpa = "3.85";
        String stringId = "1001";

        // CRITICAL NOTE ON DECIMAL SEPARATORS:
        // When parsing a String to a double, the String MUST use a period (.)
        // as the decimal separator (e.g., "3.85"). Using a comma (e.g., "3,85")
        // will cause a NumberFormatException in standard Java.

        // Integer, Double files provide methods to convert a String
        // (which is an Object) into its corresponding primitive type.
        double parsedGpa = Double.parseDouble(stringGpa);
        int parsedId = Integer.parseInt(stringId);

        System.out.println("String GPA: " + stringGpa + " --> Double GPA: " + parsedGpa);
        System.out.println("String ID: " + stringId + " --> Integer ID: " + parsedId);

        // --- SECTION 3: SCANNER INPUT AND PITFALLS ---
        System.out.println("\n--- 3. Scanner Input Methods & Buffer Pitfall ---");

        // Prompt 1: Read a GPA (double)
        // We MUST enter a period (.) as the decimal separator for nextDouble(),
        System.out.print("Enter GPA (double - USE PERIOD, e.g., 3.85): ");
        double gpa = scanner.nextDouble();

        // Prompt 2: Read Age (int) for Pitfall Simulation
        System.out.print("Age (int): ");
        int age = scanner.nextInt();

        // !!! BUFFER PITFALL WARNING !!!
        // nextInt() reads the number but leaves the ENTER key (\n) in the buffer.
        // The next nextLine() call will immediately consume this leftover '\n',
        // causing it to skip the user's chance to input their name.

        System.out.println("WATCH OUT! The next text prompt will be skipped if we don't clear the buffer.");

        // --- THE FIX ---
        // Clearing the buffer by consuming the leftover newline character:
        scanner.nextLine();

        // Prompt 3: Read Name (String) - This now works correctly!
        System.out.print("Enter  Name (String): ");
        String name = scanner.nextLine();

        // Prompt 4: Read ID using next() (which stops at whitespace)
        System.out.print("Enter  ID (one token, next()): ");
        String idNumber = scanner.next();

        // --- SECTION 4: NEXT VS NEXTLINE ---
        System.out.println("\n--- 4. next() vs. nextLine() ---");

        // next() reads only up to the first whitespace (space, tab, or newline).
        System.out.println("Read using next(): " + idNumber + " (Only one word/token)");

        // Note: next() also leaves a newline character, so we must clear again
        // if the next call is nextLine().
        scanner.nextLine();

        System.out.print("Enter a full sentence (nextLine()): ");
        String sentence = scanner.nextLine();

        // nextLine() reads the entire rest of the line, including spaces.
        System.out.println("Read using nextLine(): " + sentence + " (Entire line, spaces included)");

        // --- FINAL OUTPUT ---
        System.out.println("\n--- Final Data Summary ---");
        System.out.println("Name (String): " + name);
        System.out.println("Age (int): " + age);
        System.out.println("GPA (double): " + gpa);
        System.out.println("ID (String, read via next()): " + idNumber);

        // Good practice: Always close the Scanner when done.
        scanner.close();
    }

    public static void temp() {

        // I need to read input from the user
        // Name
        // age
        // gpa

        double x = 3.14;

        Scanner reader = new Scanner(System.in);

        // I'm reading a name
        // next()
        System.out.print("Name: ");
        String name = reader.nextLine();

        System.out.println("");
        System.out.print("GPA: ");
        double gpa = reader.nextDouble();
        // 3,14

        // 427181239112 TC

        // consume the buffer by calling nextLine
        reader.nextLine();
        System.out.print("ID: ");
        String idNumber = reader.nextLine();

        System.out.println(name);
        System.out.println(gpa);
        System.out.println(idNumber);

        // BUFFER PITFALL
        char randomLetter = '\n';
        System.out.println(randomLetter);
        String gpaa = "3.14";
        String numberInString = reader.nextLine();
        double myValue = Double.parseDouble(numberInString);
        // primitive
        int number = 5;
        double pi = 3.14;

        double anotherNumber = number;

        // type conversion - casting
        // variables can be converted to other types data
        // casting always happen from smallest to the largest value

        number = (int) 3.14;

        System.out.println(number);

        int num7 = 7;
        int num2 = 2;

        // cast
        double average = (double) num7 / num2;

        System.out.println(average);
    }

    public static void casting() {

        // primitive
        int number = 5;
        double pi = 3.14;

        double anotherNumber = number;

        // type conversion - casting
        // variables can be converted to other types data
        // casting always happen from smallest to the largest value

        number = (int) 3.14;

        System.out.println(number);

        int num7 = 7;
        int num2 = 2;

        // cast
        double average = (double) num7 / num2;

        System.out.println(average);

    }

}
