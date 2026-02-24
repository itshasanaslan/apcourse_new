package week_17;

import java.io.FileNotFoundException;

import customer_manager.HRManager;
import helpers.ArrayHelpers;

public class Program {
    public static void main(String[] args) throws FileNotFoundException {
        HRManager manager = new HRManager();

        manager.loadCustomers("customers.csv");
        

        System.out.println(manager.customers[0]);

        System.out.println(manager.customers[manager.customers.length-1]);
      



    }   

}