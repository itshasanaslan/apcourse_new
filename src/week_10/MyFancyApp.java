package week_10;

public class MyFancyApp {

     static Song song1;

    public static void main(String[] args) {


        String[] songs = {"Cruel Summer", "Vampire",  "Flowers", "Paint Town"};

        // reverse the array.
        for (int i = 0; i < songs.length / 2; i ++) {
            String temp = songs[i];
            songs[i] = songs[songs.length - 1 -i];
            songs[songs.length - 1 -i] = temp;

            System.out.println("Swapping " + temp + " with " + songs[i]);
        }

        // sorting

        /*
        String[] songsReversed = new String[songs.length];
        
        for (int i = songs.length - 1; i >= 0; i--) {
            songsReversed[songs.length - 1 - i] =  songs[i];
        }
 */



        // 1.1, 1.5,  1.1, 1.1, 1.1, 1.1, 1.2, 

        // create array of sensor reading values = > 15 differente double values
        // put 
        // for loop to check if sensor is stuck.
        // if it gives you the same value 4 times (consecutively) -> true
        // return false

        // boolean sensorFails()

        
        for (String song: songs) {
            System.out.println(song);
        }


       int[] prices = {100, 105, 95, 120, 110};
        int largestGap = -1;

        for (int i = 0; i < prices.length -1; i++ ) {

          int currentDif =  Math.abs(prices[i] - prices[i + 1]);
            // adjacent parirs
            if (currentDif > largestGap) {
                largestGap = currentDif;
            }
        }

        System.out.println("Largest Gap:" + largestGap);

        double[] sensor = {
    3.2, 7.5, 1.1, 9.8, 4.6,
    2.2, 5.5, 5.5, 5.5, 5.5, // 4 consecutive items
    8.9, 6.3, 0.4, 7.7, 1.9,
    2.8, 9.1, 3.6, 4.0, 6.8
};

        System.out.println(sensorFails(sensor));

        
    }


    // If there are 4 consecutive values, it means sensor is failing
    public static boolean sensorFails(double[] sensorValues) {

        int counter = 0;
        for (int i = 0; i < sensorValues.length - 1; i++) {
    
            if (sensorValues[i] == sensorValues[i+1]) {
                counter++;
                if (counter == 3) {
                    System.out.println("Sensor stuck at: " + sensorValues[i]);
                }
            }
         
           else {
                counter = 0;
           }
        }

        return  false;

    }

    public static void monday(){
         System.out.println("Package is running");

        Jukebox myBox = new Jukebox(3);


        Song song3 = new Song("Faint", "Linkin Park" , 10);
        Song song4 = new Song("Many Men", "50 cents" , 8);

        System.out.println("Attempting to add song 1: " + myBox.addSong(song1));


        myBox.addSong(new Song("Song2", "Blur" ,  6));



        System.out.println("Attempting to add song 3: " + myBox.addSong(song3));
        System.out.println("Attempting to add song 4: " + myBox.addSong(song4));


        myBox.playAll();

    }


    public static void changeX(int[] ar) {
        ar[0] =  111;
    }

    public static void printInteger(int x) {
        System.out.println(x);
    }

    /*
    
      
    */
}
