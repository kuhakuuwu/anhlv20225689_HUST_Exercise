package hust.soict.dsai.aims.screen;

import javax.swing.JFrame;

import hust.soict.dsai.aims.store.Store;

public class AddCompactDiscToStoreScreen extends AddItemToStoreScreen{
	public AddCompactDiscToStoreScreen(JFrame storeScreen, JFrame cartScreen, Store store) {
        super(storeScreen, cartScreen, store);
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

