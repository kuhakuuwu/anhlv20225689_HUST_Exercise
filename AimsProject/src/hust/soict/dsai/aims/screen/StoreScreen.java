package aims.screen;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

import aims.media.*;
import aims.store.Store;
import aims.cart.Cart;

public class StoreScreen extends JFrame{
    private Store store;
    private Cart cart;

    JPanel createNorth() {
        JPanel north = new JPanel();
        north.setLayout(new BoxLayout(north, BoxLayout.Y_AXIS));
        north.add(createMenuBar());
        north.add(createHeader());
        return north;
    }

    JMenuBar createMenuBar() {
        JMenu menu = new JMenu("Option");

        JMenu smUpdateStore = new JMenu("Update Store");
        JMenuItem addBook = new JMenuItem("Add Book");
        addBook.addActionListener(new StoreScreenListener(store, cart));
        smUpdateStore.add(addBook);

        JMenuItem addDVD = new JMenuItem("Add DVD");
        addDVD.addActionListener(new StoreScreenListener(store, cart));
        smUpdateStore.add(addDVD);
        
        JMenuItem addCD = new JMenuItem("Add CD");
        addCD.addActionListener(new StoreScreenListener(store, cart));
        smUpdateStore.add(addCD);

        menu.add(smUpdateStore);
        menu.add(new JMenuItem("View store"));

        JMenuItem viewCart = new JMenuItem("View cart");
        viewCart.addActionListener(new StoreScreenListener(store, cart));
        menu.add(viewCart);

        JMenuBar menuBar = new JMenuBar();
        menuBar.setLayout(new FlowLayout(FlowLayout.LEFT));
        menuBar.add(menu);

        return menuBar;
    }

    JPanel createHeader() {
        JPanel header = new JPanel();
        header.setLayout(new BoxLayout(header, BoxLayout.X_AXIS));

        JLabel title = new JLabel("AIMS");
        title.setFont(new Font(title.getFont().getName(), Font.PLAIN, 50));
        title.setForeground(Color.CYAN);

        JButton vCart = new JButton("View cart");
        vCart.addActionListener(new StoreScreenListener(store, cart));
        vCart.setPreferredSize(new Dimension(100, 50));
        vCart.setMaximumSize(new Dimension(100, 50));

        header.add(Box.createRigidArea(new Dimension(10, 10)));
        header.add(title);
        header.add(Box.createHorizontalGlue());
        header.add(vCart);
        header.add(Box.createRigidArea(new Dimension(10, 10)));

        return header;
    }

    JPanel createCenter() {
        JPanel center = new JPanel();
        center.setLayout(new GridLayout(3, 3, 2, 2));

        ArrayList<Media> mediaInStore = store.getItemsInStore();

        for (int i = 0; i < 9; i++) {
            MediaStore cell = new MediaStore(mediaInStore.get(i), cart);
            center.add(cell);
        }

        return center;
    }
    
    public StoreScreen(Store store, Cart cart) {
        this.store = store;
        this.cart = cart;
        Container cp = getContentPane();
        cp.setLayout(new BorderLayout());

        cp.add(createNorth(), BorderLayout.NORTH);
        cp.add(createCenter(), BorderLayout.CENTER);

        setVisible(true);
        setTitle("Store");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1024, 768);
    }

}
