package week_17;

import java.io.FileNotFoundException;
import java.util.ArrayList;

import customer_manager.HRManager;
import helpers.ArrayHelpers;

public class Program {
    public static void main(String[] args) throws FileNotFoundException {
        HRManager manager = new HRManager();

        manager.loadCustomers("customers.csv");
        
        System.out.println(manager.customers[1]);
        System.out.println("Sorting started");

        manager.sortFirstNameMergeSort(manager.customers, 0, manager.customers.length-1);
        System.out.println(manager.customers[0]);


        System.out.println("Sorting finished");


            // Time complexity -> big O Notation
            //selection sort 
            //insertion sort
            // linear search



            // merge sort divide and conquer



        


    }   

}