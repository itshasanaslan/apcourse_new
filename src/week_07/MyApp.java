package week_07;

public class MyApp {
    public static void main(String[] args) {

        User user1 = new User();

        // properties in a class and they have access modifiers
        // access modifiers: public, private, default
        // if something is private, you cannot access using user1.propertyName
        // If you write methods to read and change them, they are called setter and
        // getter
        // If you have a property in a class, in the class always refer to them using
        // the keyword "this.propertyName"

    }

    public static void printChess() {

        for (int row = 0; row < 8; row++) {

            // the code below is gonna run 8 times per row, 0,1 , 2, 3,
            for (int col = 0; col < 8; col++) {

                if ((row + col) % 2 == 0) {
                    System.out.print("B ");
                } else {
                    System.out.print("W ");

                }

            }

            System.out.println();
        }
    }
}
