package hust.soict.dsai.aims.screen;

import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javax.swing.*;
import java.io.IOException;

import hust.soict.dsai.aims.cart.Cart;

public class CartScreen extends JFrame {
	private Cart cart;
	private JFrame storeScreen;
    
    public CartScreen(Cart cart, JFrame storeScreen) {
        super();
        this.cart = cart;
        this.storeScreen = storeScreen;

        JFXPanel fxPanel = new JFXPanel();
        this.add(fxPanel);

        this.setTitle("Cart");
        this.setVisible(true);
        this.setSize(1100, 768);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                try {
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("cart.fxml"));
                    
                    CartScreenController controller = new CartScreenController(cart, storeScreen, CartScreen.this);
                    loader.setController(controller);
                    Parent root = loader.load(); 
                    System.out.println("Generate cart window...");
                    //controller.setCart(cart);  
                    fxPanel.setScene(new Scene(root));
                } catch (IOException e) {
                	System.out.println("Error loading FXML: " + e.getMessage());
                    e.printStackTrace();
                }
            }
        });
    }
}
