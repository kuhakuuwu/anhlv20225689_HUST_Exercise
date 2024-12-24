package hust.soict.dsai.aims.screen;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.event.*;
import hust.soict.dsai.aims.media.*;

import javax.swing.JFrame;

import hust.soict.dsai.aims.cart.Cart;

public class CartScreenController {
private Cart cart;
private JFrame storeScreen;
private JFrame cartScreen;
private ObservableList<Media> itemsOrdered;
	
	@FXML
    private TableView<Media> tblMedia;
	
	@FXML
    private TableColumn<Media, String> colMediaTitle;

    @FXML
    private TableColumn<Media, String> colMediaCategory;

    @FXML
    private TableColumn<Media, Float> colMediaCost;

    @FXML
    private ToggleGroup filterCategory;
    
    @FXML
    private RadioButton radioBtnFilterId;

    @FXML
    private RadioButton radioBtnFilterTitle;

    @FXML
    private Button btnPlay;

    @FXML
    private Button btnRemove;
    
    @FXML
    private Label msgPopUp;
    
    @FXML
    private Label tCost;
    
    @FXML
    private TextField tfFilter;
    
    public CartScreenController (Cart cart, JFrame storeScreen, JFrame cartScreen) {
        super();
        this.cart = cart;
        this.storeScreen = storeScreen;
        this.cartScreen = cartScreen;
    }
    
    public CartScreenController () {
    	super();
    }

    @FXML
    private void initialize() {
    	colMediaTitle.setCellValueFactory(new PropertyValueFactory<Media, String>("title"));
        colMediaCategory.setCellValueFactory(new PropertyValueFactory<Media, String>("category"));
        colMediaCost.setCellValueFactory(new PropertyValueFactory<Media, Float>("cost"));
        
        updateTotalCost();
        
        itemsOrdered = FXCollections.observableArrayList(cart.getItemsOrdered());
        tblMedia.setItems(itemsOrdered);
        
        btnPlay.setVisible(false);
        btnRemove.setVisible(false);
        msgPopUp.setVisible(false);
        tCost.setVisible(true);
        
        tblMedia.getSelectionModel().selectedItemProperty().addListener(
            new ChangeListener<Media>() {

                @Override
                public void changed(ObservableValue<? extends Media> observable, Media oldValue, Media newValue) {
                    if(newValue != null) {
                        updateButtonBar(newValue);
                    }
                }
                
            }
        );  
        
        tfFilter.textProperty().addListener(new ChangeListener<String>() {
        	@Override
        	public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
        		showFilteredMedia(newValue);
        	}
        });

    }
    
    @FXML
    void btnRemovePressed(ActionEvent event) {
    	Media media = tblMedia.getSelectionModel().getSelectedItem();
    	msgPopUp.setText(media.getTitle() + " has been removed from cart!");
    	cart.removeMedia(media);
    	updateTotalCost();
    	itemsOrdered.remove(media);

    }
    
    @FXML 
    void btnPlayPressed(ActionEvent event) {
    	Media media = tblMedia.getSelectionModel().getSelectedItem();
    	String msg = ((Playable) media).play();
    	msgPopUp.setText(msg);
    }
    
    @FXML 
    void btnPlaceOrderPressed(ActionEvent event) {
    	if (cart.getNumberOfItemOrdered() > 0) {
    		msgPopUp.setText("Order placed! Thank you for your purchase!");
    		cart.clear();
    		tCost.setText("0 $");
    		itemsOrdered.clear();
    	} else msgPopUp.setText("Your cart is empty...");
    }
    
    @FXML
    void handleViewStore(ActionEvent event) {
    	System.out.println("Clicked!");
        if (storeScreen != null && cartScreen != null) {
            storeScreen.setVisible(true);
            cartScreen.setVisible(false);
            System.out.println("Navigated to Store Screen");
        } else {
            System.out.println("storeScreen or cartScreen is null");
        }
    }

    

    private void updateButtonBar(Media media) {
        btnPlay.setVisible(false);
        msgPopUp.setVisible(false);
        btnRemove.setVisible(true);
        
        if(media instanceof Playable) {
            btnPlay.setVisible(true);
            msgPopUp.setVisible(true);
        } else {
            btnPlay.setVisible(false);
        }
    }
    
    private void showFilteredMedia(String filterText) {
        // Get the list of media from the cart
        ObservableList<Media> mediaList = FXCollections.observableArrayList(cart.getItemsOrdered());

        // Wrap the ObservableList in a FilteredList
        FilteredList<Media> filteredList = new FilteredList<>(mediaList, p -> true);

        // Apply a filter based on the selected radio button and filter text
        filteredList.setPredicate(media -> {
            if (filterText == null || filterText.isEmpty()) {
                return true; // Show all media if the filter is empty
            }

            if (radioBtnFilterId.isSelected()) {
                // Filter by ID (Assuming Media has an `id` property, adapt this if needed)
                return String.valueOf(media.getId()).contains(filterText);
            } else if (radioBtnFilterTitle.isSelected()) {
                // Filter by Title
                return media.getTitle().toLowerCase().contains(filterText.toLowerCase());
            }

            return false;
        });

        // Set the filtered list as the items of the TableView
        tblMedia.setItems(filteredList);
    }
    
    private void updateTotalCost() {
    	float totalCost = cart.totalCost();
    	float roundedTotalCost = Math.round(totalCost * 100.0f) / 100.0f;  // Làm tròn đến 2 chữ số thập phân
    	tCost.setText(roundedTotalCost + " $");
    }

    
    public void setCart(Cart cart) {
    	this.cart = cart;
    }

}
