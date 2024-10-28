package Aims;

public class DigitalVideoDisc {
    private String title;
    private String category;
    private String director;
    private int length;
    private float cost;

    //Accessor (Getter)
    public String getTitle() {
        return title;
    }

    public String getCategory() {
        return category;
    }

    public String getDirector() {
        return director;
    }

    public int getLength() {
        return length;
    }

    public float getCost() {
        return cost;
    }

    //Construtor
    //All
    public DigitalVideoDisc(String title, String category, String director, int length, float cost){
        this.title = title;
        this.category = category;
        this.director = director;
        this.length = length;
        this.cost = cost;
    }
    
    //By Title
    public DigitalVideoDisc(String title) {
        this.title = title;
    }

    //By category, title and cost
    public DigitalVideoDisc(String title, String category, float cost) {
        this.title = title;
        this.category = category;
        this.cost = cost;
    }

    //By director, category, title and cost	
    public DigitalVideoDisc(String title, String category, String director, float cost) {
        this.title = title;
        this.category = category;
        this.director = director;
        this.cost = cost;
    }

    public void displayInfo() {
        System.out.println("Title: " + title);
        System.out.println(" || Category: " + category);
        System.out.println(" || Director: " + director);
        System.out.println(" || Length: " + length + " mins");
        System.out.println(" || Cost: $" + cost);
        System.out.println();
    }

}
