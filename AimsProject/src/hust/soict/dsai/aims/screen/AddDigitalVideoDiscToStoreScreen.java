package hust.soict.dsai.aims.screen;

import javax.swing.JFrame;

import hust.soict.dsai.aims.store.Store;

public class AddDigitalVideoDiscToStoreScreen extends AddItemToStoreScreen{
	public AddDigitalVideoDiscToStoreScreen(JFrame storeScreen, JFrame cartScreen, Store store) {
        super(storeScreen, cartScreen, store);
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

