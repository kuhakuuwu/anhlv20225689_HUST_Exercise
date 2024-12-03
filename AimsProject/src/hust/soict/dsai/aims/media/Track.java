package aims.media;

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
    public void play() {
        if (this.length > 0) {
            System.out.println("Playing track: " + this.title);
            System.out.println("Track length: " + this.length);
        } else System.out.println("Track \"" + this.title + "\" cannot be played!");
    }

}
