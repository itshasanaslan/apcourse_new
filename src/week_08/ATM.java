package week_08;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class ATM {
    private String name; // Paypal, Ziraat, Garanti // attributes-properties -> access modifiers
    private double balance;
    private int attempts;
    public ArrayList<User> users;

    public ATM(String name, double balance) {
        this.name = name;
        this.balance = balance;
        this.loadUsers();
    }

    public ATM() {
        this.loadUsers();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }


    public User userExists(String name){
        for (User elem : this.users) {
                if (elem.getName().toLowerCase().equals(name)) {
                    return elem;
                }
        }

        System.out.println("cant findf");

        return null;
    }

    public void loadUsers() {
        // read the file and load the users into this.users
        this.users = new ArrayList<>();
        File usersFile = new File("usersAtm.txt");

        try {
            Scanner reader = new Scanner(usersFile);
            while (reader.hasNextLine()) {
                String[] data = reader.nextLine().split(",");
                User tempUser = new User(data[0], Double.parseDouble(data[1]),  data[2]);
                this.users.add(tempUser);
            }


        } catch (Exception e) {

            // add 3 template users to this.user
        this.users.add(new User("Ismail Adiguzel", 10000, "1234"));
        this.users.add(new User("Arda Ata", 20123, "1903"));
        this.users.add(new User("Derin Cetin", 32121, "3453"));


        }
        // if any error:
        

    }

    public boolean validatePin(String inputPin, User x) {

        if (this.attempts >= 3) {
            System.out.println("Too many attempts! Restart the ATM!");
            System.out.println("ACCOUNT LOCKED");

            return false;
        }

        boolean isSuccess = inputPin.equals(x.getPin());

        if (!isSuccess)
            this.attempts++;

        return isSuccess;
    }

    public boolean canProceedWithLogin() {
        return this.attempts < 3;
    }

    public void showMenu(User atmUser) {

        System.out.println("User logged in. Welcome to" + this.getName() + " ATM!");
        System.out.println(atmUser);
        String menuString = "1. View account balance.\n2. Deposit money.\n3. Withdraw money.\n4. Exit\n5. Print History.";
        Scanner reader = new Scanner(System.in);
        String command = "";

        while (!command.equals("4")) {

            System.out.println(menuString); // print the menu
            System.out.print("Operation (1-5): ");
            command = reader.next(); // read the input - command
            if (command.equals("1")) {
                // View account balance
                System.out.println(atmUser);
            }

            else if (command.equals("2")) {
                System.out.println("Current operation: Deposit");
                System.out.print("Enter the amount: $");
                double inputAmount = reader.nextDouble();
                boolean isTransactionSuccessful = atmUser.deposit(inputAmount);
                if (isTransactionSuccessful) {
                    System.out.println("SUCCESS! $" + inputAmount + " is added to your account.");
                    atmUser.incrementTransactionCount();
                    System.out.println(atmUser);
                    this.balance += inputAmount;
                    atmUser.log("Deposited $" + inputAmount);
                } else {
                    System.out.println("FAIL");
                    atmUser.log("Tried to deposit $" + inputAmount + " but failed.");

                }

            }

            else if (command.equals("3")) {
                System.out.println("Current operation: Withdraw");
                System.out.print("Enter the amount: $");
                double inputAmount = reader.nextDouble();

                // atm balance

                // if user tries to withdraw money which is greater than the cash stock
                if (inputAmount > this.balance) {
                    System.out.println("FAIL! We don't have the sufficient funds!");
                    continue;
                }

                boolean isTransactionSuccessful = atmUser.withdraw(inputAmount);

                if (isTransactionSuccessful) {
                    System.out.println("SUCCESS! $" + inputAmount + " is withdrawn from your account.");
                    System.out.println(atmUser);
                    atmUser.incrementTransactionCount();
                    atmUser.log("Deposited $" + inputAmount);

                    this.balance -= inputAmount;
                } else {
                    atmUser.log("Tried to withdraw $" + inputAmount + " but failed.");
                    System.out.println("FAIL");
                }

            }

            else if (command.equals("4")) {
                break;
            }

            else if (command.equals("5")) {
                System.out.println("System History for the User:");
                System.out.println(atmUser.getHistory());
            }

            else {
                System.out.println("INVALID OPERATION!");
            }

            System.out.print("Press any key to continue...");
            // you will fix this.

        }

    }
}
