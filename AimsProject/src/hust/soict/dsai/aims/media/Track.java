package aims.media;

public class Track {
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

}
