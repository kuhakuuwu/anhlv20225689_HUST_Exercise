package aims.cart;

import aims.media.*;

public class CartTest {
    public static void main(String[] args) {
        //Create new cart
        Cart cart = new Cart();

        //Create new DVD and add to Cart
        DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f);
        cart.addMedia(dvd1);

        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", "Science Fiction", "George Lucas", 87, 24.95f);
        cart.addMedia(dvd2);

        DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin", "Animation", 18.99f);
        cart.addMedia(dvd3);

        CompactDisc cd1 = new CompactDisc("Thriller", "Music", "Epic Records", "Michael Jackso", 42, 14.99f);
        cart.addMedia(cd1);

        Book book1 = new Book("Harry Potter", "Fantasy", 29.99f);
        book1.addAuthor("J.K Rowling");
        cart.addMedia(book1);

        //Test the print method
        cart.displayCart();

        //Test Search by ID
        cart.searchById(1);
        cart.searchById(10);

        //Test Search by Ttitle
        cart.searchByTitle("Star Wars");
        cart.searchByTitle("abc");

        //Test sorting
        //Title then Cost
        cart.sortByTitleCost();
        cart.displayCart();

        //Cost then Title
        cart.sortByCostTitle();
        cart.displayCart();
    }

}
