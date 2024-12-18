package aims.cart;

import aims.disc.DigitalVideoDisc;

public class CartTest {
    public static void main(String[] args) {
        //Create new cart
        Cart cart = new Cart();

        //Create new DVD and add to Cart
        DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f);
        cart.addDigitalVideoDisc(dvd1);

        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", "Science Fiction", "George Lucas", 87, 24.95f);
        cart.addDigitalVideoDisc(dvd2);

        DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin", "Animation", 18.99f);
        cart.addDigitalVideoDisc(dvd3);

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
