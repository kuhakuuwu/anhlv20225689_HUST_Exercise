package hust.soict.dsai.aims.store;

import hust.soict.dsai.aims.media.*;

public class StoreTest {
    public static void main(String[] args) {
        Store store = new Store();

        DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f);
        store.addMedia(dvd1);
        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", "Science Fiction", "George Lucas", 87, 24.95f);
        store.addMedia(dvd2);
        DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin", "Animation", 18.99f);
        store.addMedia(dvd3);
        DigitalVideoDisc dvd4 = new DigitalVideoDisc("Toy Story", "Animation", "John Lasseter", 81, 17.99f);
        store.addMedia(dvd4);
        DigitalVideoDisc dvd5 = new DigitalVideoDisc("Frozen", "Animation", "Chris Buck", 102, 16.99f);
        store.addMedia(dvd5);
        DigitalVideoDisc dvd6 = new DigitalVideoDisc("Beauty and the Beast", "Animation", "Bill Condon", 129, 20.99f);
        store.addMedia(dvd6);

        CompactDisc cd1 = new CompactDisc("Thriller", "Music", "Epic Records", "Michael Jackso", 42, 14.99f);
        store.addMedia(cd1);

        Book book1 = new Book("Harry Potter", "Fantasy", 29.99f);
        book1.addAuthor("J.K Rowling");
        store.addMedia(book1);

        store.searchByTitle("Thriller");
        store.searchByTitle("Toy Story");

        //Display store's inventory
        store.displayStore();

        //Remove a dvd
        store.removeMedia(dvd4); //Success
        store.removeMedia(dvd6); //Not found

        //Display store's inventory after removal
        store.displayStore();

        //Test sorting
        //Title then Cost
        store.sortByTitleCost();
        store.displayStore();

        //Cost then Title
        store.sortByCostTitle();
        store.displayStore();

    }

}
