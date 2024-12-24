package hust.soict.dsai.aims.screen;

import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javax.swing.*;
import java.io.IOException;

import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.store.Store;

public abstract class AddItemToStoreScreen extends JFrame {
	private JFrame storeScreen;
	private JFrame cartScreen;
	private Store store;

    public AddItemToStoreScreen(JFrame storeScreen, JFrame cartScreen, Store store) {
        super("Add Item to Store");
        this.storeScreen = storeScreen;
        this.cartScreen = cartScreen;
        this.store = store;

        // Set up the JFrame
        this.setSize(1024, 768);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);

        // Create a JFXPanel to integrate JavaFX with Swing
        JFXPanel fxPanel = new JFXPanel();
        this.add(fxPanel);

        // Initialize JavaFX Scene
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                try {
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("addItem.fxml"));
                    String itemType = getItemType();
                    JFrame curScreen = getCurrentScreen();
                    AddItemToStoreController controller = new AddItemToStoreController(storeScreen, cartScreen, curScreen, store, itemType);
                    loader.setController(controller); // Set the controller for this screen
                    Parent root = loader.load(); // Load the FXML file

                    // Set the scene for the JavaFX Panel
                    fxPanel.setScene(new Scene(root));

                } catch (IOException e) {
                    System.out.println("Error loading FXML: " + e.getMessage());
                    e.printStackTrace();
                }
            }
        });
    }
    
    protected abstract String getItemType();
    
    protected abstract JFrame getCurrentScreen();

}
