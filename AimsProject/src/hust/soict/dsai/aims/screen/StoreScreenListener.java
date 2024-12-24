package hust.soict.dsai.aims.screen;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;

import javax.swing.*;

import hust.soict.dsai.aims.media.*;
import hust.soict.dsai.aims.store.*;
import hust.soict.dsai.aims.cart.*;

public class StoreScreenListener implements ActionListener{
    private Store store;
    private Cart cart;
    private JFrame storeScreen;
    private CartScreen cartScreen;
    private Scanner scanner = new Scanner(System.in);

    public StoreScreenListener(Store store, Cart cart, JFrame storeScreen) {
        this.store = store;
        this.cart = cart;
        this.storeScreen = storeScreen;
        this.cartScreen = null;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String cmd = e.getActionCommand();

        if (cmd.equals("View cart")) {
        	if (cartScreen == null) {
        		new CartScreen(cart, storeScreen);
        	} else cartScreen.setVisible(true);
        	storeScreen.setVisible(false);
        } else if (cmd.equals("Add Book")) {
            new AddBookToStoreScreen(storeScreen, cartScreen, store, cart);
            storeScreen.setVisible(false);
        } else if (cmd.equals("Add DVD")) {
        	new AddDigitalVideoDiscToStoreScreen(storeScreen, cartScreen, store, cart);
        	storeScreen.setVisible(false);
        } else if (cmd.equals("Add CD")) {
        	new AddCompactDiscToStoreScreen(storeScreen, cartScreen, store, cart);
        	storeScreen.setVisible(false);
        }
    }   

}