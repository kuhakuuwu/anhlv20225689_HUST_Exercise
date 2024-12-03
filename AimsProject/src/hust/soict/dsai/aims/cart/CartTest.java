package aims.cart;

import aims.media.*;

public class CartTest {
    public static void main(String[] args) {
        //Create new cart
        Cart cart = new Cart();

        //Create new DVD and add to Cart
        Media dvd1 = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f);
        cart.addMedia(dvd1);

        Media dvd2 = new DigitalVideoDisc("Star Wars", "Science Fiction", "George Lucas", 87, 24.95f);
        cart.addMedia(dvd2);

        Media dvd3 = new DigitalVideoDisc("Aladin", "Animation", 18.99f);
        cart.addMedia(dvd3);

        Media cd1 = new CompactDisc("Thriller", "Music", "Epic Records", "Michael Jackso", 42, 14.99f);
        cart.addMedia(cd1);

        Media book1 = new Book("Harry Potter", "Fantasy", 29.99f);
        ((Book) book1).addAuthor("J.K Rowling");
        cart.addMedia(book1);

        //Test the print method
        cart.displayCart();

        //Test Search by ID
        cart.searchById(1);
        cart.searchById(10);

        //Test Search by Ttitle
        cart.searchByTitle("Star Wars");
        cart.searchByTitle("abc");
    }

}
