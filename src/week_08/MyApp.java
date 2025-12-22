package week_08;

import java.util.Scanner;

public class MyApp {

    public static void main(String[] args) {
        User user1 = new User("Ismail Adiguzel", 10000, "1234");

        ATM machine1 = new ATM("ZiraatKonak35", 20000.21);

        Scanner reader = new Scanner(System.in);

        System.out.print("Enter the pin:");
        String pin = reader.next();

        if (machine1.validatePin(pin, user1)) {
            machine1.showMenu(user1);
        } else {
            System.out.println("Incorrect pin!");
        }

    }

}
