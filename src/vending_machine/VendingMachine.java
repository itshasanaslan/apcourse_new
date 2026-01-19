package vending_machine;

import java.io.File;
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

            int choice = s.nextInt() - 1;

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

    public static Item[] loadItems()   {

        try {
            // try read file and load items
            Item[] items;

            File inputFile = new File("vending_items.txt");
            Scanner reader = new Scanner(inputFile);

            int linesInTheFile = 0;

            while (reader.hasNext()) {
                linesInTheFile++;
                reader.nextLine();
            }

            reader.close();

            reader = new Scanner(inputFile);

            int index = 0;
            items = new Item[linesInTheFile];

            while (reader.hasNext()) {
                String[] line = reader.nextLine().split(",");
                items[index] = new Item(line[0], Integer.parseInt(line[1]), Double.parseDouble(line[2]));
                index++;
            }

            reader.close();
            return items;

        }

        // else

        catch (Exception e) {
            System.out.println("File doesn't exist. Returning default items");
            Item item1 = new Item("M&M", 10, 7.54);
            Item item2 = new Item("Ice-cream", 5, 10.23);
            Item item3 = new Item("Water", 5, 2.32);
            Item item4 = new Item("Ice tea", 10, 2.54);
            Item item5 = new Item("Chocolate", 1, 6.24);
            Item item6 = new Item("Brownies", 3, 6.24);
            Item item7 = new Item("Chips", 5, 6.24);
            Item item8 = new Item("Coke", 2, 6.24);
            Item item9 = new Item("Apple juice", 1, 6.24);
            Item item10 = new Item("Orange juice", 1, 6.24);
            Item[] items = { item1, item2, item3, item4, item5, item6, item7, item8, item9, item10 };
            return items;

        }
    }

    public static void run()  {

        Item[] items = VendingMachine.loadItems();
        User user = new User("Jack", 55);

        VendingMachine machine = new VendingMachine(items);
        machine.operate(user);

    }
}
