package customer_manager;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

import helpers.ArrayHelpers;

public class HRManager {

    public Customer[] customers;

    // customer_manager -> package
    // in the package, create class:HRManager.java

    //

    //last line is also added into array: which shouldn't be.
    public void loadCustomers(String filePath) throws FileNotFoundException {

        File file = new File(filePath);
        Scanner reader = new Scanner(file);
        // read the file lines to get the size of the array to be created.
        int lines = 0;
        while (reader.hasNext()) {
            String[] customerLineasCSV = reader.nextLine().split(","); // consume the line

            // checking for null rows
            if (customerLineasCSV.length > 1) {
                    lines++;
            }
           
        }
        reader.close();
        

        //ignore the header in the csv
        lines--;

        // initialize the array
        this.customers = new Customer[lines];
        reader = new Scanner(file);

        reader.nextLine();
        int counter = 0;
        while (reader.hasNext()) {

            String[] customerLineasCSV = reader.nextLine().split(","); // consume the line
            // checking for any incomplete lines to skip parsing.   
            if (customerLineasCSV.length < 3) {
                    continue;}

                
            Customer customer = new Customer(
                    Integer.parseInt(customerLineasCSV[0]),
                    customerLineasCSV[1],
                    customerLineasCSV[2],
                    customerLineasCSV[3],
                    customerLineasCSV[4],
                    customerLineasCSV[5],
                    customerLineasCSV[6],
                    customerLineasCSV[7],
                    customerLineasCSV[8],
                    customerLineasCSV[9],
                    customerLineasCSV[10]);
            this.customers[counter] = customer;
            counter++;
        }
        reader.close();


    }



        public  void sortById() {
        // start from 2nd item
        for (int i = 1; i < this.customers.length; i++ ) {
            Customer key = this.customers[i];
            int j = i -1; // index for the item on the left

            while (j >= 0 && this.customers[j].getCustomerId() > key.getCustomerId()) {
                this.customers[j+1] = this.customers[j];
                j--;
            }

            this.customers[j + 1] = key;
        }

    }


       public  void sortByIdDescending() {
        // start from 2nd item
        for (int i = 1; i < this.customers.length; i++ ) {
            Customer key = this.customers[i];
            int j = i -1; // index for the item on the left

            while (j >= 0 && this.customers[j].getCustomerId() < key.getCustomerId()) {
                this.customers[j+1] = this.customers[j];
                j--;
            }

            this.customers[j + 1] = key;
        }

    }



         public  void sortByName() {
        // start from 2nd item
        for (int i = 1; i < this.customers.length; i++ ) {
            Customer key = this.customers[i];
            int j = i -1; // index for the item on the left

            while (j >= 0 && this.customers[j].getFirstName().compareTo(key.getFirstName()) > 0) {
                this.customers[j+1] = this.customers[j];
                j--;
            }

            this.customers[j + 1] = key;
        }

    }

    // 99862
    // first, sort it 
    // binary search
    // assumes that the data is already sorted

}
