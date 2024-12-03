package aims.store;

import aims.media.*;
import java.util.ArrayList;;

public class Store {
    private ArrayList<Media> itemsInStore = new ArrayList<>();  // Array to hold DVDs

    // Add a item to the store
    public void addMedia(Media media) {
        if (!itemsInStore.contains(media)) {
            itemsInStore.add(media);
            System.out.println("The item \"" + media.getTitle() + "\" has been added to the store!");
        } else {
            System.out.println("The item \"" + media.getTitle() + "\" is already in the store!");
        }
    }
    

    // Remove a item from the store
    public void removeMedia (Media media) {
        if (itemsInStore.contains(media)) {
            itemsInStore.remove(media);
            System.out.println("The item \"" + media.getTitle() + "\" has been removed!");
        } else System.out.println("The item \"" + media.getTitle() + "\" is not in the cart!");
    }   

    public Media searchByTitle(String title) {
        for (Media media : itemsInStore) {
            if (media.getTitle().equalsIgnoreCase(title)) {
                System.out.println("\nFound the item with title \"" + title + "\": ");
                media.displayInfo();
                return media;
            }
        }
        System.out.println("No item found with title \"" + title + "\".");
        return null;
    }

    public Media searchById(int id) {
        for (Media media : itemsInStore) {
            if (media.getId() == id) {  // So sánh id của Media
                System.out.println("Found item with ID: " + id + ": \n");
                media.displayInfo();
                return media;
            }
        }
        System.out.println("No item found with ID: " + id);
        return null;
    }    

    // Method to display all DVDs in the store
    public void displayStore() {
        System.out.println("\n********* Store Inventory *********");
        if (itemsInStore.isEmpty()) {
            System.out.println("The store is empty.");
        } else {
            System.out.println("Current items in store: " + itemsInStore.size() + " item(s).");
            int index = 1;
            for(Media media : itemsInStore) {
                System.out.print(index + ". ");
                media.displayInfo();  // Display each DVD's info
                index++;
            }
        }
        System.out.println("***********************************");
    }

}
