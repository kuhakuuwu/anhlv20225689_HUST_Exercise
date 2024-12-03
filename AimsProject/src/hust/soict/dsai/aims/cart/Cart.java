package aims.cart;

import aims.media.*;
import java.util.ArrayList;

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
                System.out.println("Found the item with ID " + id + ": \n");
                media.displayInfo();
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
                System.out.println("\nFound the item with title \"" + title + "\": " + media.toString());
                return media;
            }
        }
        System.out.println("\nNo item found with title \"" + title + "\"!");
        return null;
    }

    //Tổng giá trị sản phẩm trong giỏ
    public float totalCost() {
        float total = 0;
        for (Media media : itemsOrdered) {
            total += media.getCost();
        }
        return total;
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
                System.out.print(index + ". ");
                media.displayInfo();
                index++;
            }
            System.out.println("---------------------------------------------------");
            System.out.println("Total cost: $" + totalCost());
            System.out.println("***************************************************");
            System.out.println();
        }    
    }

}
