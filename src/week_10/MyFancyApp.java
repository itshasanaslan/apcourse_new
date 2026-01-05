package week_10;

public class MyFancyApp {

     static Song song1;

    public static void main(String[] args) {
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



    public static void printInteger(int x) {
        System.out.println(x);
    }

    /*
    
      
    */
}
