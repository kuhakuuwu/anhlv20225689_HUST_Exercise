package aims.screen;

import aims.ItemCreator;
import aims.store.Store;
import aims.cart.Cart;
import java.util.Scanner;
import aims.media.*;

public class TestScreen {
    private static Store store = new Store();
    private static Cart cart = new Cart();
    private static Scanner scanner = new Scanner(System.in);

    public static void addItemToStore() {
        System.out.println("Enter media details:");
        while(true){
            String input = scanner.nextLine();

            if (input.equalsIgnoreCase("done")) {
                System.out.println("Done!");
                break;
            }
    
            Media media = ItemCreator.createMedia(input);
            if (media != null) {
                store.addMedia(media);
                System.out.println("Added");
            } else {
                System.out.println("Failed");
            }
        }
        
    }
    public static void main(String[] args) {
        addItemToStore();
        new StoreScreen(store, cart);
    }

}
