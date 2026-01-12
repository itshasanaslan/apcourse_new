package vending_machine;

import java.util.Scanner;

public class VendingMachine {
    private Item[] items;

    public VendingMachine(Item[] items) {
        this.items = items;
    }

    public void showSnacks() {
        System.out.println("------ITEMS------");
        for (int index = 0; index < this.items.length; index++) {
            System.out.println((index + 1) + ") " + this.items[index].toString());
        }
    }

    public void operate(User user) {
        this.showSnacks();
        Scanner s = new Scanner(System.in);

        while (true) {

            System.out.print("Enter an item number: ");
            System.out.println(user);

            int choice = s.nextInt();

            if (choice < 0 || choice > this.items.length) {
                System.out.println("Enter a valid item! Terminating!");
                break;
            }

            else {
                this.buy(user, this.items[choice]);
            }
        }
    }

    public void buy(User currentUser, Item whichItem) {

        if (itemExists(whichItem)) {

            // check balanace
            if (currentUser.getBalance() >= whichItem.getPrice()) {
                // get
                whichItem.setStock(whichItem.getStock() - 1);
                currentUser.setBalance(currentUser.getBalance() - whichItem.getPrice());
                System.out.println("Success! Giving the item " + whichItem.getName() + ".");
            } else {
                System.out.println("Insufficient funds!");
            }
        } else {
            System.out.println("The item is out of stock!");
        }
    }

    public boolean itemExists(Item item) {
        return item.getStock() > 0;
    }

    public static void run() {

        Item[] items = VendingMachine.loadItems();
        User user = new User("Jack", 55);

        VendingMachine machine = new VendingMachine(items);
        machine.operate(user);

    }
}
