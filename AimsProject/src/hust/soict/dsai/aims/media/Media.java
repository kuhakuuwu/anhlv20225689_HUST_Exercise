package aims.media;

import java.util.Objects;

public abstract class Media {
    private int id;
    private String title;
    private String category;
    private float cost;
    private static int nbMedia = 0;

    //Constructor
    //All
    public Media(String title, String category, float cost) {
        this.id = ++nbMedia;
        this.title = title;
        this.category = category;
        this.cost = cost;
    }

    //By Title
    public Media(String title) {
        this.id = ++nbMedia;
        this.title = title;
    }

    //By Title and Cost
    public Media(String title, float cost) {
        this.id = ++nbMedia;
        this.title = title;
        this.cost = cost;
    }


    //Accessor
    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getCategory() {
        return category;
    }

    public float getCost() {
        return cost;
    }

    public static int getNumberOfMedia() {
        return nbMedia;
    }

    //Setter
    public void setTitle(String title) {
        this.title = title;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setCost(float cost) {
        this.cost = cost;
    }

    //Display info
    public abstract void displayInfo();

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true; // Same object reference
        if (obj == null || getClass() != obj.getClass()) return false; // Null or different class
        Media media = (Media) obj; // Cast to Media
        return Objects.equals(title, media.title); // Compare titles
    }

    @Override
    public int hashCode() {
        return Objects.hash(title); // Hash based on title
    }

}
