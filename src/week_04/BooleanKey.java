package week_04;

public class BooleanKey {
    public static void main(String[] args) {
        
        System.out.println("--- Simple Boolean Expressions ---");
        System.out.println("1: " + (3 >= 2));
        System.out.println("2: " + (!(10 == 10)));
        System.out.println("3: " + (12 % 5 == 2));
        System.out.println("4: " + (7 < 6));
        System.out.println("5: " + (!(8 != 8)));

        System.out.println("\n--- Logical Operators in Action ---");
        System.out.println("1: " + ((2 + 2 == 4) && (3 * 3 == 9)));
        System.out.println("2: " + ((7 > 5) || (3 < 1)));
        System.out.println("3: " + ((4 % 2 == 0) && (10 / 2 > 3)));
        System.out.println("4: " + (!(6 > 4) || (2 <= 3)));
        System.out.println("5: " + ((5 + 5 == 10) && !(20 / 4 != 5)));

        System.out.println("\n--- Nested Conditions ---");
        System.out.println("1: " + ((10 > 8) && ((5 - 3) == 2)));
        System.out.println("2: " + (!(4 * 2 == 8) || (12 / 4 == 3)));
        System.out.println("3: " + (((7 - 4 > 2) || (10 % 3 == 1)) && (15 / 5 == 3)));
        System.out.println("4: " + (((8 <= 8) && !(3 > 5)) || ((9 / 3 == 3) && (7 > 6))));
        System.out.println("5: " + (!(3 * 3 != 9) && ((4 + 4 == 8) || (2 == 5))));

        System.out.println("\n--- Math-Heavy and Tricky ---");
        System.out.println("1: " + ((5 * 2 == 10) && (10 / 2 != 4)));
        System.out.println("2: " + (((10 % 3 == 1) && (4 * 2 >= 8)) || !(7 == 7)));
        System.out.println("3: " + (((6 + 2 > 9) || (8 - 3 < 6)) && (12 / 4 == 3)));
        System.out.println("4: " + (!(2 * 3 > 5) || ((10 / 5 == 2) && (15 % 4 == 3))));
        System.out.println("5: " + (((2 + 3 == 5) && !(9 - 3 > 7)) || (4 * 4 == 16)));

        System.out.println("\n--- Challenge Boolean Expressions ---");
        System.out.println("1: " + ((5 > 2) && ((10 % 3 == 1) || (2 * 3 < 5))));
        // Note: The one below is false because !(true) || (true && false) results in false
        System.out.println("2: " + (!(3 + 3 == 6) || ((4 / 2 == 2) && !(7 < 9)))); 
        System.out.println("3: " + ((6 * 6 == 36) && ((9 % 4 == 1) || !(8 <= 10))));
        System.out.println("4: " + (((12 / 4 == 3) && (5 % 2 == 1)) || ((3 * 3 > 8) && !(6 == 7))));
        System.out.println("5: " + (!(5 > 10) && ((7 - 2 < 6) || ((4 * 3 == 12) && (10 / 2 >= 5)))));
    }
}