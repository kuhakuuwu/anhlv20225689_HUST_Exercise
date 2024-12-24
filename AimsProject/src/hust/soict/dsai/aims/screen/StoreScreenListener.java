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
            addBook();
        } else if (cmd.equals("Add DVD")) {
            addDVD();
        } else if (cmd.equals("Add CD")) {
        addCD();
        }
    }   

    private void addBook() {
        String bookTitle = JOptionPane.showInputDialog("Enter book title:");
        if (bookTitle == null || bookTitle.isEmpty()) return;

        String bookCategory = JOptionPane.showInputDialog("Enter book category:");
        if (bookCategory == null || bookCategory.isEmpty()) return;

        String costInput = JOptionPane.showInputDialog("Enter book cost:");
        try {
            float bookCost = Float.parseFloat(costInput);
            Book book = new Book(bookTitle, bookCategory, bookCost);

            String bookAuthor = JOptionPane.showInputDialog("Enter book author:");
            if (bookAuthor != null && !bookAuthor.isEmpty()) {
                book.addAuthor(bookAuthor);
            }

            store.addMedia(book);
            JOptionPane.showMessageDialog(null, "Book added to the store.");
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "Invalid input for cost. Please enter a valid number.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void addDVD() {
        String dvdTitle = JOptionPane.showInputDialog("Enter DVD title:");
        if (dvdTitle == null || dvdTitle.isEmpty()) return;

        String dvdCategory = JOptionPane.showInputDialog("Enter DVD category:");
        if (dvdCategory == null || dvdCategory.isEmpty()) return;

        String dvdDirector = JOptionPane.showInputDialog("Enter DVD director:");
        if (dvdDirector == null || dvdDirector.isEmpty()) return;

        String lengthInput = JOptionPane.showInputDialog("Enter DVD length:");
        try {
            int dvdLength = Integer.parseInt(lengthInput);

            String costInput = JOptionPane.showInputDialog("Enter DVD cost:");
            float dvdCost = Float.parseFloat(costInput);

            DigitalVideoDisc dvd = new DigitalVideoDisc(dvdTitle, dvdCategory, dvdDirector, dvdLength, dvdCost);
            store.addMedia(dvd);
            JOptionPane.showMessageDialog(null, "DVD added to the store.");
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "Invalid input for length or cost. Please enter valid numbers.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void addCD() {
        String cdTitle = JOptionPane.showInputDialog("Enter CD title:");
        if (cdTitle == null || cdTitle.isEmpty()) return;

        String cdCategory = JOptionPane.showInputDialog("Enter CD category:");
        if (cdCategory == null || cdCategory.isEmpty()) return;

        String cdArtist = JOptionPane.showInputDialog("Enter CD artist:");
        if (cdArtist == null || cdArtist.isEmpty()) return;

        String cdDirector = JOptionPane.showInputDialog("Enter CD director:");
        if (cdDirector == null || cdDirector.isEmpty()) return;

        String lengthInput = JOptionPane.showInputDialog("Enter CD length:");
        try {
            int cdLength = Integer.parseInt(lengthInput);

            String costInput = JOptionPane.showInputDialog("Enter CD cost:");
            float cdCost = Float.parseFloat(costInput);

            CompactDisc cd = new CompactDisc(cdTitle, cdCategory, cdDirector, cdArtist, cdLength, cdCost);
            store.addMedia(cd);
            JOptionPane.showMessageDialog(null, "CD added to the store.");
        } catch (NumberFormatException ex) {
           JOptionPane.showMessageDialog(null, "Invalid input for length or cost. Please enter valid numbers.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

}
