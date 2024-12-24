package hust.soict.dsai.aims.media;

import java.util.Objects;

public class Track implements Playable{
    private String title;
    private int length;

    //Constructor
    public Track(String title, int length){
        this.title = title;
        this.length = length;
    }

    //Getter
    public int getLength() {
        return length;
    }

    public String getTitle() {
        return title;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true; // Same object reference
        if (obj == null || getClass() != obj.getClass()) return false; // Null or different class
        Track track = (Track) obj; // Cast to Track
        return Objects.equals(title, track.title) && length == track.length; // Compare title and length
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, length); // Hash based on title and length
    }

    @Override
    public String play() {
        if (this.length > 0) {
            System.out.println("Playing track: " + this.title);
            System.out.println("Track length: " + this.length);
            return "Playing " + this.getTitle() + " - " + this.getLength() + " mins";
        } else {
        	System.out.println("Track \"" + this.title + "\" cannot be played!");
        	return this.getTitle() + " cannot be palyed!";
        }
    }

}
