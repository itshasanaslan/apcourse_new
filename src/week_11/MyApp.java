package week_11;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import vending_machine.*;

public class MyApp {
    public static void main(String[] args) throws FileNotFoundException{


        // create file object
        File inputFile = new File("data.txt");
        // enable access for scanner to access the file
        Scanner scanner = new Scanner(inputFile);
    


        int numOfLines = 0;
        while (scanner.hasNext()){
                numOfLines++;
                // consume
                scanner.nextLine();
        }

        System.out.println(numOfLines);
        User[] users = new User[numOfLines];

        scanner.close();
        
        scanner = new Scanner(inputFile);
        int index = 0;
        while (scanner.hasNext() ) {
            // scope is local
            String[] data = scanner.nextLine().split(",");
            User user = new User(data[0], Double.parseDouble(data[1]));
            users[index] = user;
            index++;
            System.out.println(user);
        }

        
        System.out.println(users[0]);
        scanner.close();


       

    }

    public static void sessionOne(){
             // arrays

       

        /*
             double x = 4.31234324234;
        String xAsString = String.format("%.4f" , x);
        System.out.println(xAsString);
        */


        Scanner s = new Scanner(System.in);
          double value;
        try {
            // do something
            // if something goes wrong here
            // jump to the catch part
            value = s.nextDouble();
            // more
            //lines
        }

        catch (InputMismatchException e) {
            System.out.println("That's not a double");
        }

        catch (Exception e) {
               System.out.println("Something else happened");
                value = 1;
            }

        finally {

        }
            

        System.out.println("Program has finished");
    
    }
}
