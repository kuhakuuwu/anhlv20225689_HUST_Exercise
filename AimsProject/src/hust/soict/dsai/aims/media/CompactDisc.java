package aims.media;

import java.util.ArrayList;

public class CompactDisc extends Disc {
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

}
