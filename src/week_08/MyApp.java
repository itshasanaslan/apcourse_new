package week_08;

import java.util.Scanner;

public class MyApp {

    public static void main(String[] args) {
        //User user1 = new User("Ismail Adiguzel", 10000, "1234");

        ATM machine1 = new ATM("ZiraatKonak35", 20000.21);

        Scanner reader = new Scanner(System.in);
    
        User s;
        while (true) {

            System.out.print("Enter your name: ");
            String name = reader.nextLine().toLowerCase();

            s = machine1.userExists(name);

            if (s != null ){
                break;
            }
            else {
                System.out.println("User does not exist");
           
            }


        }


        while (machine1.canProceedWithLogin()) {
            // can try 3 times
            // Maria Garcia
            System.out.print("Enter the pin:");
            String pin = reader.next();

            if (machine1.validatePin(pin, s)) {
                machine1.showMenu(s);
            } else {
                System.out.println("Incorrect pin!");
            }
        }

    }

}
