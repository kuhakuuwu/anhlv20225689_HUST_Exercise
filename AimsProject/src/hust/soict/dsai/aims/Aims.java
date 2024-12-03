package aims;

import aims.media.*;
import aims.store.Store;
import aims.cart.Cart;
import java.util.Scanner;

public class Aims {
    private static Store store = new Store();
    private static Cart cart = new Cart();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            showMenu();
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline
            switch (choice) {
                case 1:
                    viewStore();
                    break;
                case 2:
                    updateStore();
                    break;
                case 3:
                    seeCart();
                    break;
                case 20225689: //For Testing
                    addItemToStore();
                    break;
                case 0:
                    System.out.println("Exiting AIMS. Goodbye!");
                    return;
                default:
                    System.out.println("Invalid choice. Please choose again.");
                    break;
            }
        }
    }

    public static void showMenu() {
        System.out.println("\nAIMS:");
        System.out.println("--------------------------------");
        System.out.println("1. View store");
        System.out.println("2. Update store");
        System.out.println("3. See current cart");
        System.out.println("0. Exit");
        System.out.println("--------------------------------");
        System.out.println("Please choose a number: 0-1-2-3");
    }
    

    //-----------------------------Store Menu------------------------------------
    public static void viewStore() {
        while (true) {
            store.displayStore();
            storeMenu();
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline
            switch (choice) {
                case 1:
                    seeMediaDetails();
                    break;
                case 2:
                    addMediaToCart();
                    break;
                case 3:
                    playMedia();
                    break;
                case 4:
                    seeCart();
                    return;
                case 0:
                    return;
                default:
                    System.out.println("Invalid choice. Please choose again.");
                    break;
            }
        }
    }

    public static void storeMenu() {
        System.out.println("\nOptions:");
        System.out.println("--------------------------------");
        System.out.println("1. See a media's details");
        System.out.println("2. Add a media to cart");
        System.out.println("3. Play a media");
        System.out.println("4. See current cart");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.println("Please choose a number: 0-1-2-3-4");
    }
    
    //Store Menu - Op1
    public static void seeMediaDetails() {
        System.out.print("\nEnter the title of the media: ");
        String title = scanner.nextLine();
        Media media = store.searchByTitle(title);
        if (media == null) {
            System.out.println("Media not found!");
            return;
        }
        //System.out.println(media.toString());
        mediaDetailsMenu();
        int choice = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        switch (choice) {
            case 1:
                cart.addMedia(media);
                System.out.println("Media added to cart.");
                break;
            case 2:
                if (media instanceof Playable) {
                    ((Playable) media).play();
                } else {
                    System.out.println("This media cannot be played.");
                }
                break;
            case 0:
                return;
            default:
                System.out.println("Invalid choice.");
                break;
        }
    }

    public static void mediaDetailsMenu() {
        System.out.println("\nOptions:");
        System.out.println("--------------------------------");
        System.out.println("1. Add to cart");
        System.out.println("2. Play");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.println("Please choose a number: 0-1-2");
    }

    //Store Menu - Op2
    public static void addMediaToCart() {
        System.out.print("\nEnter the title of the media: ");
        String title = scanner.nextLine();
        Media media = store.searchByTitle(title);
        if (media == null) {
            System.out.println("Media not found!");
            return;
        }
        cart.addMedia(media);
        System.out.println("Media added to cart. Total items in cart: " + cart.getNumberOfItemOrdered());
    }

    //Store Menu - Op3
    public static void playMedia() {
        System.out.print("\nEnter the title of the media: ");
        String title = scanner.nextLine();
        Media media = store.searchByTitle(title);
        if (media == null) {
            System.out.println("Media not found!");
            return;
        }
        if (media instanceof Playable) {
            ((Playable) media).play();
        } else {
            System.out.println("This media cannot be played.");
        }
    }
    //-----------------------------Both Menu------------------------------------
    //Main Menu - Op 3 or Store Menu - Op4
    public static void seeCart() {
        while (true) {
            cart.displayCart();
            cartMenu();
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline
            switch (choice) {
                case 1:
                    filterMenu();
                    break;
                case 2:
                    sortMenu();
                    break;
                case 3:
                    System.out.print("Enter the title of the media to remove: ");
                    String mediaTitle = scanner.nextLine();
                    Media mediaToRemove = store.searchByTitle(mediaTitle);
                    if (mediaToRemove != null) {
                        cart.removeMedia(mediaToRemove);
                        System.out.println("Media removed from the store.");
                    } else {
                        System.out.println("Media not found in the store.");
                    }
                    break;
                case 4:
                    playMedia();
                    break;
                case 5:
                    if (cart.clear()) {
                        System.out.println("Order placed. Thank you for your purchase!");
                    }
                    return;
                case 0:
                    return;
                default:
                    System.out.println("Invalid choice.");
                    break;
            }
        }
    }

    public static void cartMenu() {
        System.out.println("\nOptions:");
        System.out.println("--------------------------------");
        System.out.println("1. Filter medias in cart");
        System.out.println("2. Sort medias in cart");
        System.out.println("3. Remove media from cart");
        System.out.println("4. Play a media");
        System.out.println("5. Place order");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.println("Please choose a number: 0-1-2-3-4-5");
    }

    public static void filterMenu() {
        while (true) {
            System.out.println("\nFilter option: ");
            System.out.println("1. By ID");
            System.out.println("2. By Title");
            System.out.println("0. Back");
            System.out.print("Please choose number 0-1-2: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.println("Enter an ID: ");
                    int mId = scanner.nextInt();
                    scanner.nextLine();
                    cart.filterById(mId);
                    break;
                
                case 2:
                    System.out.println("Enter a Title: ");
                    String mTitle = scanner.nextLine();
                    scanner.nextLine();
                    cart.filterByTitle(mTitle);
                    break;

                case 0: //Back
                    return;
            
                default:
                System.out.println("Invalid choice. Please choose again.");
                break;
            }
        }
    }

    public static void sortMenu() {
        while (true) {
            System.out.println("\nSort option: ");
            System.out.println("1. By Title");
            System.out.println("2. By Cost");
            System.out.println("0. Back");
            System.out.print("Please choose number 0-1-2: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    cart.sortByTitleCost();
                    break;
                
                case 2:
                    cart.sortByCostTitle();
                    break;

                case 0: //Back
                    return;
            
                default:
                System.out.println("Invalid choice. Please choose again.");
                break;
            }
        }
    }

    //--------------------------------Main Menu--------------------------------------
    //Main Menu - Op2
    public static void updateStore() {
        while (true) {
            System.out.println("\nUpdate Store Options:");
            System.out.println("1. Add a Book");
            System.out.println("2. Add a Digital Video Disc (DVD)");
            System.out.println("3. Add a Compact Disc (CD)");
            System.out.println("4. Remove a Media");
            System.out.println("0. Back");
            System.out.print("Please choose a number: 0-1-2-3-4: ");
    
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline
    
            switch (choice) {
                case 1: // Add a Book
                    System.out.print("Enter title: ");
                    String bookTitle = scanner.nextLine();
                    System.out.print("Enter category: ");
                    String bookCategory = scanner.nextLine();
                    System.out.print("Enter cost: ");
                    float bookCost = scanner.nextFloat();
                    scanner.nextLine(); // Consume newline
                    Book book = new Book(bookTitle, bookCategory, bookCost);
                    System.out.print("Enter author: ");
                    String bookAuthor = scanner.nextLine();
                    book.addAuthor(bookAuthor);
                    store.addMedia(book);
                    System.out.println("Book added to the store.");
                    break;
    
                case 2: // Add a DVD
                    System.out.print("Enter title: ");
                    String dvdTitle = scanner.nextLine();
                    System.out.print("Enter category: ");
                    String dvdCategory = scanner.nextLine();
                    System.out.print("Enter director: ");
                    String dvdDirector = scanner.nextLine();
                    System.out.print("Enter length: ");
                    int dvdLength = scanner.nextInt();
                    System.out.print("Enter cost: ");
                    float dvdCost = scanner.nextFloat();
                    scanner.nextLine(); // Consume newline
                    store.addMedia(new DigitalVideoDisc(dvdTitle, dvdCategory, dvdDirector, dvdLength, dvdCost));
                    System.out.println("DVD added to the store.");
                    break;
    
                case 3: // Add a CD
                    System.out.print("Enter title: ");
                    String cdTitle = scanner.nextLine();
                    System.out.print("Enter category: ");
                    String cdCategory = scanner.nextLine();
                    System.out.print("Enter artist: ");
                    String cdArtist = scanner.nextLine();
                    System.out.print("Enter director: ");
                    String cdDirector = scanner.nextLine();
                    System.out.print("Enter length: ");
                    int cdLength = scanner.nextInt();
                    System.out.print("Enter cost: ");
                    float cdCost = scanner.nextFloat();
                    scanner.nextLine(); // Consume newline
                    store.addMedia(new CompactDisc(cdTitle, cdCategory, cdDirector, cdArtist, cdLength, cdCost));
                    System.out.println("CD added to the store.");
                    break;
    
                case 4: // Remove a Media
                    System.out.print("Enter the title of the media to remove: ");
                    String mediaTitle = scanner.nextLine();
                    Media mediaToRemove = store.searchByTitle(mediaTitle);
                    if (mediaToRemove != null) {
                        store.removeMedia(mediaToRemove);
                        System.out.println("Media removed from the store.");
                    } else {
                        System.out.println("Media not found in the store.");
                    }
                    break;
    
                case 0: // Back
                    return;
    
                default:
                    System.out.println("Invalid choice. Please choose again.");
                    break;
            }
        }
    }
    
    //------------For Testting-------------
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
    
}
