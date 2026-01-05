package week_09;

import week_07.Cellphone;

public class MyApp {

    public static void main(String[] args) {

      

       
    }

    public static void saturday(){
         /*
         * String[] loots = { "Rusty Sword", "Gold Coin", "cheese", "Health Potion",
         * "Helmet", "Magic potion",
         * "Dirty pants" };
         * 
         * for (int index = 0; index < loots.length; index++) {
         * loots[index] = "Default item"; // permanent
         * System.out.println("You have acquired:" + loots[index]);
         * }
         * 
         * System.out.println("First loop is done. Now the actual data is below");
         * 
         * for (int index = 0; index < loots.length; index++) {
         * String item = loots[index];
         * System.out.println("You have acquired:" + item);
         * }
         * 
         * int[] numbers = { 10, 20, 30 };
         * 
         * for (int index = 0; index < numbers.length; index++) {
         * int currentNumber = numbers[index];
         * currentNumber += 5;
         * currentNumber = numbers[index];
         * System.out.println(numbers[index]);
         * }
         */

        // an integer array with 5 items
        // Arrays
        // declare and create an array

        int[] myFancyArray = new int[5];
        myFancyArray[0] = -321;
        myFancyArray[1] = 5;
        myFancyArray[2] = -12;
        myFancyArray[3] = 654;
        myFancyArray[4] = 345;

        // traverse this array -> iterate each item and do smt

        String[] loots = { "Rusty Sword", "Gold Coin", "cheese", "Health Potion", "Helmet", "Magic potion" };

        for (int index = 0; index < loots.length; index++) {
            String item = loots[index];
            loots[index] = "blaaablaablaa";
            // print
        }

        for (String item : loots) {
            System.out.println(item);
        }

        Cellphone phone1 = new Cellphone();
        phone1.brand = "Samsung";
        phone1.year = 2025;




        Cellphone phone2 = new Cellphone();
        phone2.brand = "Apple";
        phone2.year = 2025;

        Cellphone phone3 = new Cellphone();
        phone3.brand = "Huawei";
        phone3.year = 2025;

        Cellphone[] phoneStore = new Cellphone[] {
                phone1,
                phone2,
                phone3 };

        for (Cellphone anything : phoneStore) {
            System.out.println(anything);
        }

        int[] someArray = { 1, 2, 3, 4, 5, 6 };

        changeValue(someArray);

        System.out.println(someArray[0]);

      

        // create a double array called temperatures
        // it will have 4 different temperatures
        // print all the temperatures using enhanced

        // write another classical for loop
        // increement each temperature by 15%
        // print again using enhanced for loop

    }

    public static void changeValue(int[] someHurray) {

        someHurray[0] = 10;
    }

    public static void sessionOne() {
        // Arrays
        // you need the items of SAME DATA TYPE
        // arrays are objects.

        // we declare an array in the memory.
        // int[] myArray = new int[5];

        int[] myArray = new int[] { 923, 21, 23, 123 };

        // access the items in the array using index

        int count = myArray.length;
        // System.out.println(myArray[3]);

        // 3 items
        String[] loots = new String[3];

        loots[0] = "Rusty Sword";
        loots[2] = "Gold coin";

        String text = "I have a " + loots[1];
        System.out.println(loots[1].length());
        // 2 rusty sworrd
        // 0 gold coin
    }
}
