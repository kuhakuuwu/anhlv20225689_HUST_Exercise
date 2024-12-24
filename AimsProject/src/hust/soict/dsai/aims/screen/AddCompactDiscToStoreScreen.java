package hust.soict.dsai.aims.screen;

import javax.swing.JFrame;

import hust.soict.dsai.aims.store.Store;
import hust.soict.dsai.aims.cart.Cart;

public class AddCompactDiscToStoreScreen extends AddItemToStoreScreen{
	public AddCompactDiscToStoreScreen(JFrame storeScreen, JFrame cartScreen, Store store, Cart cart) {
        super(storeScreen, cartScreen, store, cart);
    }

    @Override
    protected String getItemType() {
    	return "cd";
    }
    
    @Override
    protected JFrame getCurrentScreen() {
    	return AddCompactDiscToStoreScreen.this;
    }
}