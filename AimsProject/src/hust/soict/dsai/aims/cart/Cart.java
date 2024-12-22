package hust.soict.dsai.aims.cart;

import hust.soict.dsai.aims.media.*;
import java.util.ArrayList;
import java.util.Collections;

public class Cart {
    public static final int MAX_NUMBERS_ORDERED = 20;
    private ArrayList<Media> itemsOrdered = new ArrayList<>();

    //Add a Media to cart
    public void addMedia (Media media) {
        if (itemsOrdered.size() >= MAX_NUMBERS_ORDERED) {
            System.out.println("The cart is full. Cannot add more items!");
        } else if (itemsOrdered.contains(media)) {
            System.out.println("The item \"" + media.getTitle() + "\" is already in the cart!");
        } else {
            itemsOrdered.add(media);
            System.out.println("The item \"" + media.getTitle() + "\" has been added!");
        }
    }
    
    //Remove a Media from cart
    public void removeMedia (Media media) {
        if (itemsOrdered.contains(media)) {
            itemsOrdered.remove(media);
            System.out.println("The item \"" + media.getTitle() + "\" has been removed!");
        } else System.out.println("The item \"" + media.getTitle() + "\" is not in the cart!");
    }    

    //Tìm kiếm bằng ID
    public Media searchById(int id) {
        for (Media media : itemsOrdered) {
            if (media.getId() == id) {
                System.out.println("Found the item with ID " + id + ": \n" + media.toString());
                return media;
            }
        }
        System.out.println("No item found with ID " + id + "!");
        return null;
    }

    //Tìm kiếm bằng Title
    public Media searchByTitle(String title) {
        for (Media media : itemsOrdered) {
            if (media.getTitle().equalsIgnoreCase(title)) {
                System.out.println("\nFound the item with title \"" + title + "\": \n" + media.toString());
                return media;
            }
        }
        System.out.println("\nNo item found with title \"" + title + "\"!\n");
        return null;
    }

    // Filter by Title
    public void filterByTitle(String title) {
        boolean found = false;
        for (Media media : itemsOrdered) {
            if (media.getTitle().equalsIgnoreCase(title)) {
                System.out.println(media.toString());
                found = true;
            }
        }
        if (!found) {
            System.out.println("\nNo items found with the title \"" + title + "\"!\n");
        }
    }

    // Filter by ID
    public void filterById(int id) {
        boolean found = false;
        for (Media media : itemsOrdered) {
            if (media.getId() == id) {
                System.out.println(media.toString());
                found = true;
            }
        }
        if (!found) {
            System.out.println("\nNo items found with the ID " + id + "!\n");
        }
    }

    //Sort by Title then Cost
    public void sortByTitleCost() {
        System.out.println("Sort by Title then by Cost: ");
        Collections.sort(itemsOrdered, Media.COMPARE_BY_TITLE_COST);
        System.out.println("Sorted complete!");
    }

    //Sort by Cost then Title
    public void sortByCostTitle() {
        System.out.println("Sort by Cost then by Title: ");
        Collections.sort(itemsOrdered, Media.COMPARE_BY_COST_TITLE);
        System.out.println("Sorted complete!");
    }

    //Tổng giá trị sản phẩm trong giỏ
    public float totalCost() {
        float total = 0;
        for (Media media : itemsOrdered) {
            total += media.getCost();
        }
        return total;
    }

    //Tong so san pham trong gio hang
    public int getNumberOfItemOrdered() {
        return itemsOrdered.size();
    }

    //Xoa san pham trong gio hang
    public boolean clear() {
        if (itemsOrdered.isEmpty()) {
            System.out.println("The cart is empty!");
            return false;
        } else {
            itemsOrdered.clear();
            return true;
        }
    }

    //Hiển thị giỏ hàng
    public void displayCart() {
        System.out.println();
        if(itemsOrdered.isEmpty()) {
            System.out.println("The cart is empty!");
        } else {
            int index = 1;
            System.out.println("Current items in the cart: " + itemsOrdered.size() + " item(s).");
            System.out.println("***********************CART***********************");
            for (Media media : itemsOrdered) {
                System.out.print(index + ". " + media.toString());
                index++;
            }
            System.out.println("---------------------------------------------------");
            System.out.println("Total cost: $" + totalCost());
            System.out.println("***************************************************");
            System.out.println();
        }    
    }

}
