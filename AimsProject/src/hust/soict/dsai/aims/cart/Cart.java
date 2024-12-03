package aims.cart;

import aims.media.*;

public class Cart {
    public static final int MAX_NUMBERS_ORDERED = 20;
    private DigitalVideoDisc itemsOrdered[] = new DigitalVideoDisc[MAX_NUMBERS_ORDERED];
    private int qtyOrdered = 0;

    //Add a DVD to cart
    public void addDigitalVideoDisc (DigitalVideoDisc disc) {
        if (qtyOrdered < MAX_NUMBERS_ORDERED) {
            itemsOrdered[qtyOrdered] = disc;
            qtyOrdered++;
            System.out.println("The disc has been added!");
        } else System.out.println("The cart is full. Cannot add more items!");
    }

    public void addDigitalVideoDisc (DigitalVideoDisc[] discList) {
        for (DigitalVideoDisc disc : discList) {
            if (qtyOrdered < MAX_NUMBERS_ORDERED) {
                addDigitalVideoDisc(disc);
            } else System.out.println("The cart is full. Cannot add more items!");
        }
    }

    public void addDigitalVideoDisc (DigitalVideoDisc disc1, DigitalVideoDisc disc2) {
        if ((qtyOrdered + 1) < MAX_NUMBERS_ORDERED) {
            addDigitalVideoDisc(disc1);
            addDigitalVideoDisc(disc2);
        } else System.out.print("The cart is full. Cannot add two more items!");
    }
    
    //Remove a DVD from cart
    public void removeDigitalVideoDisc (DigitalVideoDisc disc) {
        boolean found = false;
        for (int i = 0; i < qtyOrdered; i++) {
            if (itemsOrdered[i].equals(disc)) {
                found = true;
                // Shift items to the left to clear the gap
                for (int j = i; j < qtyOrdered - 1; j++) {
                    itemsOrdered[j] = itemsOrdered[j+1];
                }
                itemsOrdered[qtyOrdered -1] = null; //Clear the last item
                qtyOrdered--;
                System.out.println("The disc has been removed!");
                break;
            }
        }

        if (!found) {
            System.out.println("Cannot find the disc in the cart!");
        }
    }

    //Tìm kiếm bằng ID
    public void searchById(int id) {
        boolean found = false;
        for (int i = 0; i < qtyOrdered; i++) {
            if (itemsOrdered[i].getId() == id) {
                found = true;
                System.out.println("Found the DVD with ID " + id + ": \n");
                itemsOrdered[i].displayInfo();
                break; 
            }
        }
        if (!found) System.out.println("No DVD found with ID " + id + "!");
    }

    //Tìm kiếm bằng Title
    public void searchByTitle(String title) {
        boolean found = false;
        for (int i = 0; i < qtyOrdered; i++) {
            if (itemsOrdered[i].isMatch(title)) {
                found = true;
                System.out.println("\nFound the DVD with title \"" + title + "\": ");
                itemsOrdered[i].displayInfo();
            }
        }
        if (!found) {
            System.out.println("\nNo DVD found with title \"" + title + "\"!");
        }
    }

    //Tổng giá trị sản phẩm trong giỏ
    public float totalCost() {
        float total = 0;
        for (int i = 0; i < qtyOrdered; i++) {
            total += itemsOrdered[i].getCost();
        }
        return total;
    }

    //Hiển thị giỏ hàng
    public void displayCart() {
        System.out.println();
        System.out.println("Current items in the cart: " + qtyOrdered + " item(s).");
        System.out.println("***********************CART***********************");
        for (int i = 0; i < qtyOrdered; i++) {
            System.out.print((i+1) + ". ");
            itemsOrdered[i].displayInfo();
        }
        System.out.println("---------------------------------------------------");
        System.out.println("Total cost: $" + totalCost());
        System.out.println("***************************************************");
        System.out.println();
    }

}
