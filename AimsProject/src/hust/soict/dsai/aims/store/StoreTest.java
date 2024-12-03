package aims.store;

import aims.media.DigitalVideoDisc;

public class StoreTest {
    public static void main(String[] args) {
        Store store = new Store(5);//With or without max number of items allow

        DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f);
        store.addDigitalVideoDisc(dvd1);
        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", "Science Fiction", "George Lucas", 87, 24.95f);
        store.addDigitalVideoDisc(dvd2);
        DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin", "Animation", 18.99f);
        store.addDigitalVideoDisc(dvd3);
        DigitalVideoDisc dvd4 = new DigitalVideoDisc("Toy Story", "Animation", "John Lasseter", 81, 17.99f);
        store.addDigitalVideoDisc(dvd4);
        DigitalVideoDisc dvd5 = new DigitalVideoDisc("Frozen", "Animation", "Chris Buck", 102, 16.99f);
        store.addDigitalVideoDisc(dvd5);
        DigitalVideoDisc dvd6 = new DigitalVideoDisc("Beauty and the Beast", "Animation", "Bill Condon", 129, 20.99f);

        //Display store's inventory
        store.displayStore();

        //Try add more dvd when capacity is full
        store.addDigitalVideoDisc(dvd6); //Capacity full

        //Remove a dvd
        store.removeDigitalVideoDisc(dvd4); //Success
        store.removeDigitalVideoDisc(dvd6); //Not found

        //Display store's inventory after removal
        store.displayStore();

        //Add dvd 6 again
        store.addDigitalVideoDisc(dvd6);
        
        //Final Result
        store.displayStore();

    }

}
