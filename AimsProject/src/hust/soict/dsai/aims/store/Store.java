package aims.store;

import aims.disc.DigitalVideoDisc;

public class Store {
    private DigitalVideoDisc[] itemsInStore;  // Array to hold DVDs
    private int currentIndex;  // Tracks the current index in the store

    // Default Constructor
    public Store() {
        itemsInStore = new DigitalVideoDisc[100000];  // Initialize the array
        currentIndex = 0;  // Start from the first position in the store
    }

    // Constructor with a max items number
    public Store(int maxItems) {
        itemsInStore = new DigitalVideoDisc[maxItems];  // Initialize the array
        currentIndex = 0;  // Start from the first position in the store
    }

    // Method to add a DVD to the store
    public void addDigitalVideoDisc(DigitalVideoDisc dvd) {
        if (currentIndex < itemsInStore.length) {
            itemsInStore[currentIndex] = dvd;  // Add DVD to the store
            currentIndex++;  // Move to the next position
            System.out.println("The DVD \"" + dvd.getTitle() + "\" has been added to the store!");
        } else {
            System.out.println("The store is full. Cannot add more DVDs!");
        }
    }

    // Method to remove a DVD from the store
    public void removeDigitalVideoDisc(DigitalVideoDisc dvd) {
        boolean found = false;
        for (int i = 0; i < currentIndex; i++) {
            if (itemsInStore[i].getId() == dvd.getId()) {  // Find DVD by ID
                found = true;
                // Shift items to the left to fill the gap
                for (int j = i; j < currentIndex - 1; j++) {
                    itemsInStore[j] = itemsInStore[j + 1];
                }
                itemsInStore[currentIndex - 1] = null;  // Clear last item
                currentIndex--;  // Decrease the number of DVDs in store
                System.out.println("The DVD \"" + dvd.getTitle() + "\" has been removed from the store!");
                break;
            }
        }
        if (!found) {
            System.out.println("The DVD with title '" + dvd.getTitle() + "' was not found in the store!");
        }
    }

    // Method to display all DVDs in the store
    public void displayStore() {
        System.out.println("\n********* Store Inventory *********");
        if (currentIndex == 0) {
            System.out.println("The store is empty.");
        } else {
            for (int i = 0; i < currentIndex; i++) {
                System.out.print((i + 1) + ". ");
                itemsInStore[i].displayInfo();  // Display each DVD's info
            }
        }
        System.out.println("***********************************");
    }

}
