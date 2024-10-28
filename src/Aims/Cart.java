package Aims;

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

    public float totalCost() {
        float total = 0;
        for (int i = 0; i < qtyOrdered; i++) {
            total += itemsOrdered[i].getCost();
        }
        return total;
    }

    public void displayCart() {
        System.out.println("Current items in the cart: " + qtyOrdered + " item(s).\n");
        for (int i = 0; i < qtyOrdered; i++) {
            itemsOrdered[i].displayInfo();
            System.out.println("-----------------------------------");
        }
        System.out.println("Total cost: $" + totalCost());
        System.out.println();
    }

}
