package hust.soict.dsai.aims.screen;

import javax.swing.JFrame;

import hust.soict.dsai.aims.store.Store;
import hust.soict.dsai.aims.cart.Cart;

public class AddDigitalVideoDiscToStoreScreen extends AddItemToStoreScreen{
	public AddDigitalVideoDiscToStoreScreen(JFrame storeScreen, JFrame cartScreen, Store store, Cart cart) {
        super(storeScreen, cartScreen, store, cart);
    }

    @Override
    protected String getItemType() {
    	return "dvd";
    }
    
    @Override
    protected JFrame getCurrentScreen() {
    	return AddDigitalVideoDiscToStoreScreen.this;
    }
}