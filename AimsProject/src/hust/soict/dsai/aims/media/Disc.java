package aims.media;

public abstract class Disc extends Media {
    private int length;
    private String director;
    private static int nbDisc = 0;

    //Construtor
    //All
    public Disc(String title, String category, String director, int length, float cost){
        super(title, category, cost);
        this.director = director;
        this.length = length;
        nbDisc++;
    }
    
    //By Title
    public Disc(String title) {
        super(title);
        nbDisc++;
    }

    //By category, title and cost
    public Disc(String title, String category, float cost) {
        super(title, category, cost);
        nbDisc++;
    }

    //By title and cost
    public Disc(String title, float cost) {
        super(title, cost);
        nbDisc++;
    }

    //By director, category, title and cost	
    public Disc(String title, String category, String director, float cost) {
        super(title, category, cost);
        this.director = director;
        nbDisc++;
    }

    //Accessor
    public String getDirector() {
        return director;
    }

    public int getLength() {
        return length;
    }

    public static int getNumberOfDisc() {
        return nbDisc;
    }
    
    //Display indo
    public abstract void displayInfo();

    @Override
    public abstract String toString();
}
