package hust.soict.dsai.test.store;

import hust.soict.dsai.aims.disc.DigitalVideoDisc;
import hust.soict.dsai.aims.store.Store;

public class StoreTest {
    public static void main(String[] args) {
        Store store = new Store();

        DigitalVideoDisc dvd1 = new DigitalVideoDisc("Before sunrise", "Romance", "Richard Linklater", 70, 20f);
        store.addDVD(dvd1);

        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Before sunset", "Romance", "Richard Linklater", 65, 21.5f);
        store.addDVD(dvd2);

        DigitalVideoDisc dvd3 = new DigitalVideoDisc("Before midnight", "Romance", "Richard Linklater", 75, 22.3f);
        store.addDVD(dvd3);

        DigitalVideoDisc dvd4 = new DigitalVideoDisc("Sadness", "Tragedy", "My Life", 100, 1f);
        store.addDVD(dvd4);

        store.removeDVD(dvd4);

        store.print();
    }



}
