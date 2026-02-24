package week_17;

import java.io.FileNotFoundException;

import customer_manager.HRManager;
import helpers.ArrayHelpers;

public class Program {
    public static void main(String[] args) throws FileNotFoundException {
        HRManager manager = new HRManager();

        manager.loadCustomers("customers.csv");
      

        manager.sortByName();

        // insertion sort
        // selection sort 
        // merge sort

        // search algorithm -> linear search algorithm  
        // recursion 



        // the latest 




    }   

}