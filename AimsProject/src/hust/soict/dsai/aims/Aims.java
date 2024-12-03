package aims;

import aims.cart.Cart;
import aims.media.*;
import aims.store.Store;

public class Aims {
    public static void main(String[] args) {
        
        //Create new cart
        Cart anOrder = new Cart();

        //Create new DVD and add them to the cart
        DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation", "Roger Aller", 87, 19.95f);
        anOrder.addMedia(dvd1);

        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", "Science Fiction", "George Lucas", 87, 24.95f);
        anOrder.addMedia(dvd2);

        DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin", "Animation", 18.99f);
        anOrder.addMedia(dvd3);

        //print total cost of the items in cart
        //System.out.println("Total cost is: " + anOrder.totalCost());

        anOrder.displayCart();

        anOrder.removeMedia(dvd2);

        anOrder.displayCart();
    }

}
