package week_10;

public class Song {

  // Fields (Property, attribute) for title (String), artist (String), rating
  // (int). Include a toString().

  private String title;
  private String artist;
  private int rating;

  public Song(String title, String artist, int rating) {
    this.title = title;
    this.artist = artist;
    this.rating = rating;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getArtist() {
    return artist;
  }

  public void setArtist(String artist) {
    this.artist = artist;
  }

  public int getRating() {
    return rating;
  }

  public void setRating(int rating) {
    this.rating = rating;
  }

  public String toString() {
    return this.getTitle() + " | by " + this.getArtist() + " | with a rating: " + this.getRating();
  }

}
