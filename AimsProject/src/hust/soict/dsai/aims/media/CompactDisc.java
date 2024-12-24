package hust.soict.dsai.aims.media;
import java.util.ArrayList;

public class CompactDisc extends Disc implements Playable{
    private String artist;
    private ArrayList<Track> tracks;

    //Getter
    public String getArtist() {
        return artist;
    }

    //Constructor
    //All
    public CompactDisc(String title, String category, String director, String artist, int length, float cost){
        super(title, category, director, length, cost);
        this.artist = artist;
        this.tracks = new ArrayList<>();
    }

    //All except length
    public CompactDisc(String title, String category, String director, String artist, float cost){
        super(title, category, director, cost);
        this.artist = artist;
        this.tracks = new ArrayList<>();
    }
    
    //By Title
    public CompactDisc(String title) {
        super(title);
        this.tracks = new ArrayList<>();
    }

    //By category, title and cost
    public CompactDisc(String title, String category, float cost) {
        super(title, category, cost);
        this.tracks = new ArrayList<>();
    }

    //By title and cost
    public CompactDisc(String title, float cost) {
        super(title, cost);
        this.tracks = new ArrayList<>();
    }

    //Add Track
    public boolean addTrack(Track track) {
        if(!tracks.contains(track)) {
            tracks.add(track);
            System.out.println("Track \"" + track.getTitle() + "\" has been added into the CD!");
            return true;
        } else {
            System.out.println("Track \"" + track.getTitle() + "\" is already in the CD!");
            return false;
        }
    }

    //Remove Track
    public boolean removeTrack(Track track) {
        if(tracks.contains(track)) {
            tracks.remove(track);
            System.out.println("Track \"" + track.getTitle() + "\" has been removed from the CD!");
            return true;
        } else {
            System.out.println("Track \"" + track.getTitle() + "\" is not in the CD!");
            return false;
        }
    }

    //Override getLength
    @Override
    public int getLength() {
        int totalLength = 0;
        for(Track track: tracks) {
            totalLength += track.getLength();
        }
        return totalLength;
    }

    //Hiển thị thông tin CD
    public void displayInfo() {
        System.out.print("CD - " + getTitle());

        if (getCategory() != null) {
            System.out.print(" - " + getCategory());
        } else System.out.print(" - N/A" );

        if (getDirector() != null) {
            System.out.print(" - " + getDirector());
        } else System.out.print(" - N/A" );

        if (artist != null) {
            System.out.print(" - " + artist);
        } else System.out.print(" - N/A" );

        if (getLength() !=  0) {
            System.out.print(" - " + getLength() + " mins");
        } else System.out.print(" - N/A" );

        System.out.print(": " + getCost() + "$");

        System.out.println();
    }

    @Override
    public String play() {
        if (this.getLength() > 0) {
            System.out.println("Playing CD: " + this.getTitle());
            System.out.println("CD artist: " + this.getArtist());
            System.out.println("CD length: " + this.getLength());
            for (Track track : tracks) {
                System.out.print("\n  | ");
                track.play();
            }
            return "Playing " + this.getTitle() + " - " + this.getLength() + " mins";
        } else {
        	System.out.println("CD \"" + this.getTitle() + "\" cannot be played!");
        	return this.getTitle() + " cannot be played!";
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("CD - ").append(getTitle());

        if (getCategory() != null) {
            sb.append(" - ").append(getCategory());
        } else {
            sb.append(" - N/A");
        }

        if (getDirector() != null) {
            sb.append(" - ").append(getDirector());
        } else {
            sb.append(" - N/A");
        }

        if (artist != null) {
            sb.append(" - ").append(artist);
        } else {
            sb.append(" - N/A");
        }

        if (getLength() != 0) {
            sb.append(" - ").append(getLength()).append(" mins");
        } else {
            sb.append(" - N/A");
        }

        sb.append(": ").append(getCost()).append("$\n");

        return sb.toString();
    }

}

