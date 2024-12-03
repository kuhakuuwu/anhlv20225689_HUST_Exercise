package aims.media;

import java.util.ArrayList;
import java.util.List;

public class Book extends Media {
    private List<String> authors = new ArrayList<String>();
    private static int nbBook = 0;

    //Accessor
    public List<String> getAuthors() {
        return new ArrayList<>(authors);
    }

    public static int getNumberOfBook() {
        return nbBook;
    }

    //Constructor
    //All
    public Book(String title, String category, float cost) {
        super(title, category, cost);
        nbBook++;
        //this.authors = new ArrayList<>();
    }

    //By Title
    public Book(String title) {
        super(title);
        //this.authors = new ArrayList<>();
        nbBook++;
    }

    //By Title and Cost
    public Book(String title, float cost) {
        super(title, cost);
        nbBook++;
    }

    //Add Author
    public boolean addAuthor(String author) {
        if(!this.authors.contains(author)) {
            this.authors.add(author);
            return true;
        } else {
            System.out.println("Author \"" + author + "\" already exists!");
            return false;
        }
    }

    public boolean removeAuthor(String author) {
        //Kiem tra xem tac gia co ton tai trong danh sach khong
        if (this.authors.contains(author)) {
            this.authors.remove(author);
            System.out.println("Removed author \"" + author + "\" successfully!");
            return true;
        } else {
            System.out.println("Author \"" + author + "\" not found!");
            return false;
        }
    }

    public void displayInfo() {
        System.out.print("Book - " + getTitle());
    
        if (getCategory() != null) {
            System.out.print(" - " + getCategory());
        } else {
            System.out.print(" - N/A");
        }
    
        if (!authors.isEmpty()) {
            System.out.print(" - Authors: ");
            for (String author : authors) {
                System.out.print(author + " ");
            }
        } else {
            System.out.print(" - N/A");
        }
    
        // Display cost
        System.out.print(": " + getCost() + "$");
        System.out.println();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Book - ").append(getTitle());

        if (getCategory() != null) {
            sb.append(" - ").append(getCategory());
        } else {
            sb.append(" - N/A");
        }

        if (!authors.isEmpty()) {
            sb.append(" - Authors: ");
            for (String author : authors) {
                sb.append(author).append(" ");
            }
        } else {
            sb.append(" - N/A");
        }

        sb.append(": ").append(getCost()).append("$\n");

        return sb.toString();
    }
    
}
