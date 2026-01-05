package week_10;

public class Jukebox {
    private Song[] songList; // isn't initialized
    public Jukebox(int capacity) {
        
        this.songList = new Song[capacity];

    }


    public boolean addSong(Song s) {
        for (int index = 0; index < this.songList.length; index++) {
            if (this.songList[index] == null) {
                this.songList[index] = s;
                return true;
            }
        }
        return false;
    }

    public void playAll() {
        for (Song song : this.songList) {
            
            if (song != null) {
                System.out.println(song);
            }

        }
    }


    
    public void songsByArtist(String artist) {
        
        for (Song song : this.songList) {
            // null check
            if (song != null && artist.equals(song.getArtist())) { 
               System.out.println(song);
            }

        }

    }

}
