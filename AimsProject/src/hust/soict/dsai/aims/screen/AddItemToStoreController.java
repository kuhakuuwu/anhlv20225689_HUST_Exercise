package hust.soict.dsai.aims.screen;

import javax.swing.*;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.event.*;

import hust.soict.dsai.aims.store.Store;

public class AddItemToStoreController {
	private String itemType;
	private Store store;
	private JFrame storeScreen;
	private JFrame cartScreen;
	private JFrame addItemScreen;
	
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
    private Button confirmAuthorBtn;

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
    
    public AddItemToStoreController(JFrame storeScreen, JFrame cartScreen, JFrame addItemScreen, Store store, String itemType) {
    	super();
    	this.storeScreen = storeScreen;
    	this.cartScreen = cartScreen;
    	this.addItemScreen = addItemScreen;
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
        confirmAuthorBtn.setVisible(false);
        addTrackBtn.setVisible(false);

    	if (itemType.equals("book")) {
    		
    	} else if (itemType.equals("dvd")) {
    		
    	} else if (itemType.equals("cd")) {
    		
    	}
    }

    private void initializeBookScreen() {
        authorLabel.setVisible(true);
        authorReader.setVisible(true);
        confirmAuthorBtn.setVisible(true);
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
    void cancelBtnPressed(ActionEvent event) {

    }

    @FXML
    void confirmBtnPressed(ActionEvent event) {

    }
    
    

   
}
