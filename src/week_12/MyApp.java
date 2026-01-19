package week_12;

import java.util.ArrayList;
import java.util.Arrays;
import vending_machine.User;

public class MyApp {

    public static void main(String[] args) {
        int[] numbersArray = new int[] { 10, 20, 30, 40, 50 }; // initializer list

        System.out.println(numbersArray.length);

        System.out.println(numbersArray[1]);

        // -----------------------------------------
        ArrayList<Integer> myList = new ArrayList<>(Arrays.asList(10, 20, 30, 40, 50));

        System.out.println(myList.size());

        myList.add(10);
        myList.add(20);
        myList.add(2, 25); // index, item
        int deletedOne = myList.remove(0);
        System.out.println(myList.get(1));

        ArrayList<User> users = new ArrayList<>(Arrays.asList(
                new User("Arda", 191),
                new User("Ismail", 191),
                new User("Emir", 191),
                new User("Alper", 191),
                new User("Alper", 191),
                new User("Alper", 191),
                new User("Alper", 191),
                new User("Derin", 191),
                new User("Selim", 191)

        ));

        
        for (int i = users.size() - 1; i >= 0 ; i--) {
           if ( users.get(i).getName().equals("Alper") ) {
            System.out.println("Deleted");
                users.remove(i);
            }
        }


        System.out.println(users);
    
    }
}
