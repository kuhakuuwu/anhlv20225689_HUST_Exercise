package hust.soict.dsai.aims.screen;

import javax.swing.JFrame;

import hust.soict.dsai.aims.store.Store;

public class AddBookToStoreScreen extends AddItemToStoreScreen {
    public AddBookToStoreScreen(JFrame storeScreen, JFrame cartScreen, Store store) {
        super(storeScreen, cartScreen, store);
    }

    @Override
    protected String getItemType() {
    	return "book";
    }
    
    @Override
    protected JFrame getCurrentScreen() {
    	return AddBookToStoreScreen.this;
    }
}

