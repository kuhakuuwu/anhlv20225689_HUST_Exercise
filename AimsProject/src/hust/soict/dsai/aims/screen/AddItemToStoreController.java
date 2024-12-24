package hust.soict.dsai.aims.screen;

import javax.swing.*;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.event.*;
import java.util.*;

import hust.soict.dsai.aims.store.Store;
import hust.soict.dsai.aims.media.*;
import hust.soict.dsai.aims.cart.Cart;

public class AddItemToStoreController {
	private String itemType;
	private Store store;
	private Cart cart;
	private JFrame storeScreen;
	private JFrame cartScreen;
	private JFrame currentScreen;
	private ArrayList<String> authors = new ArrayList<>();
	private ArrayList<Track> tracks = new ArrayList<>();
	
	
	@FXML
    private Button addTrackBtn;

    @FXML
    private Label addTrackLabel;

    @FXML
    private Label artistLabel;

    @FXML
    private TextField artistReader;

    @FXML
    private Label authorLabel;

    @FXML
    private TextField authorReader;

    @FXML
    private TextField categoryReader;

    @FXML
    private Button addAuthorBtn;

    @FXML
    private TextField costReader;

    @FXML
    private Label directorLabel;

    @FXML
    private TextField directorReader;

    @FXML
    private Label lengthLabel;

    @FXML
    private TextField lengthReader;

    @FXML
    private Label msgLog;

    @FXML
    private TextField titleReader;

    @FXML
    private Label trackLengthLabel;

    @FXML
    private TextField trackLengthReader;

    @FXML
    private Label trackTitleLabel;

    @FXML
    private TextField trackTitleReader;
    
    public AddItemToStoreController(JFrame storeScreen, JFrame cartScreen, JFrame currentScreen, Store store, Cart cart, String itemType) {
    	super();
    	this.storeScreen = storeScreen;
    	this.cartScreen = cartScreen;
    	this.currentScreen = currentScreen;
    	this.itemType = itemType;
    	this.store = store;
    }
    
    @FXML
    private void initialize() {
        directorReader.setVisible(false);
        lengthReader.setVisible(false);
        artistReader.setVisible(false);
        authorReader.setVisible(false);
        trackTitleReader.setVisible(false);
        trackLengthReader.setVisible(false);
        directorLabel.setVisible(false);
        lengthLabel.setVisible(false);
        artistLabel.setVisible(false);
        authorLabel.setVisible(false);
        addTrackLabel.setVisible(false);
        trackTitleLabel.setVisible(false);
        trackLengthLabel.setVisible(false);
        addAuthorBtn.setVisible(false);
        addTrackBtn.setVisible(false);
        msgLog.setVisible(false);

    	if (itemType.equals("book")) {
    		initializeBookScreen();
    	} else if (itemType.equals("dvd")) {
    		initializeDVDScreen();
    	} else if (itemType.equals("cd")) {
    		initializeCDScreen();
    	}
    }

    private void initializeBookScreen() {
        authorLabel.setVisible(true);
        authorReader.setVisible(true);
        addAuthorBtn.setVisible(true);
        msgLog.setText("Each book can add new author multiple time!");
        msgLog.setVisible(true);
    }

    private void initializeDVDScreen() {
        directorLabel.setVisible(true);
        directorReader.setVisible(true);
        lengthLabel.setVisible(true);
        lengthReader.setVisible(true);
    }

    private void initializeCDScreen() {
        directorLabel.setVisible(true);
        directorReader.setVisible(true);
        lengthLabel.setVisible(true);
        lengthReader.setVisible(true);
        lengthReader.setEditable(false);
        artistLabel.setVisible(true);
        artistReader.setVisible(true);
        addTrackLabel.setVisible(true);
        trackTitleLabel.setVisible(true);
        trackLengthLabel.setVisible(true);
        trackTitleReader.setVisible(true);
        trackLengthReader.setVisible(true);
        addTrackBtn.setVisible(true);
    }
    
    @FXML
    void btnAddAuthorPressed(ActionEvent event) {
    	String author = authorReader.getText().trim();
    	if (!author.isEmpty()) {
    		authors.add(author);
    		authorReader.clear();
    		msgLog.setText("Author " + author + " added!");
    	} else msgLog.setText("Please input author name before added!");
    }

    @FXML
    void btnAddTrackPressed(ActionEvent event) {
    	String title = trackTitleReader.getText().trim();
    	String lengthStr = trackLengthReader.getText().trim();
    	int length;
    	
    	try {
			length = Integer.parseInt(lengthStr);
		} catch (NumberFormatException e) {
			msgLog.setText("Input length is not a valid integer!");
			return;
		}	
    	
    	Track track = new Track(title, length);
    	tracks.add(track);
    	updateCdLength();
    }

    @FXML
    void cancelBtnPressed(ActionEvent event) {
    	titleReader.clear();
    	categoryReader.clear();
		costReader.clear();
		directorReader.clear();
		artistReader.clear();
		lengthReader.clear();
		authorReader.clear();
		trackTitleReader.clear();
		trackLengthReader.clear();
		authors.clear();
		tracks.clear();
		msgLog.setText("Cancelled!");
    }

    @FXML
    void confirmBtnPressed(ActionEvent event) {
    	try {
    		String title = titleReader.getText().trim();
    		String category = categoryReader.getText().trim();
    		String costStr = costReader.getText().trim();
    		msgLog.setVisible(true);
    		
    		if(title.isEmpty() ||costStr.isEmpty()) {
    			msgLog.setText("Title and Cost are required!");
    			return;
    		}
    		
    		float cost;
    		try {
    			cost = Float.parseFloat(costStr);
    			cost = Math.round(cost * 100.0f) / 100.0f;
    		} catch (NumberFormatException e) {
    			msgLog.setText("Input cost is not valid!");
    			return;
    		}
    		
    		if (itemType.equals("dvd")) {
    			String director = directorReader.getText().trim();
    			String lengthStr = lengthReader.getText().trim();
    			int length;
    			
    			if (director.isEmpty()) director = "N/A";
    			
    			try {
    				length = Integer.parseInt(lengthStr);
    			} catch (NumberFormatException e) {
    				msgLog.setText("Input length is not a valid integer!");
    				return;
    			}
    			
    			store.addMedia(new DigitalVideoDisc(title, category, director, length, cost));
    			msgLog.setText("A new dvd has been added to the store!");
    		}
    		
    		if (itemType.equals("book")) {
    			Book book = new Book(title, category, cost);
    			if (authors != null && !authors.isEmpty()) {
    				for (String author : authors) {
        				book.addAuthor(author);
        			}
    				authors.clear();
    			}
    			store.addMedia(book);
    			msgLog.setText("A new book has been added to the store!");
    		}
    		
    		if (itemType.equals("cd")) {
    			String director = directorReader.getText().trim();
    			String artist = artistReader.getText().trim();
    			
    			CompactDisc cd = new CompactDisc(title, category, director, artist, cost);
    			
    			if (tracks != null && !tracks.isEmpty()) {
    				for (Track track : tracks) {
    					cd.addTrack(track);
    				}
    				tracks.clear();
    			}
    			store.addMedia(cd);
    			msgLog.setText("A new cd has been added to the store");
    			
    		}
    			
    	} catch (Exception e) {
    		msgLog.setText("Error occurred!");
    	}

    }
    
    @FXML
    void handleAddBookPressed(ActionEvent event) {
    	new AddBookToStoreScreen(storeScreen, cartScreen, store, cart);
    	currentScreen.dispose();
    }

    @FXML
    void handleAddCdPressed(ActionEvent event) {
    	new AddCompactDiscToStoreScreen(storeScreen, cartScreen, store, cart);
    	currentScreen.dispose();
    }

    @FXML
    void handleAddDvdPressed(ActionEvent event) {
    	new AddDigitalVideoDiscToStoreScreen(storeScreen, cartScreen, store, cart);
    	currentScreen.dispose();
    }

    @FXML
    void handleViewCartPressed(ActionEvent event) {
    	if (cartScreen == null) {
    		new CartScreen(cart, storeScreen);
    	} else {
    		cartScreen.setVisible(true);
    	}
    	currentScreen.dispose();
    }

    @FXML
    void handleViewStorePressed(ActionEvent event) {
    	if (storeScreen == null) {
    		new StoreScreen(store, cart);
    	} else storeScreen.setVisible(true);
    	currentScreen.dispose();
    }
    
    private void updateCdLength() {
    	if (tracks != null && !tracks.isEmpty()) {
    		int trackLength = 0;
    		for (Track track : tracks) {
    			trackLength += track.getLength();
    		}
    		lengthReader.setText(String.valueOf(trackLength));
    	} else lengthReader.setText("0");
    }
    
    

   
}
