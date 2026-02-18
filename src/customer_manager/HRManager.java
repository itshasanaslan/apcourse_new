package customer_manager;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class HRManager {

    private Customer[] customers;

    // customer_manager -> package
    // in the package, create class:HRManager.java

    // 


    public void loadCustomers(String filePath) throws FileNotFoundException {
        // will import the csv file into your customers array

        File ourFile = new File(filePath);
        Scanner reader = new Scanner(ourFile);


        // fixed in size
        // reading the lines and getting the count
        // we create our array with that size


        // we read it again. This time, we add them into our array.

        

    }

}
