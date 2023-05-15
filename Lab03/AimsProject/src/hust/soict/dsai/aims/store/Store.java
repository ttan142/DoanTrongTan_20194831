package hust.soict.dsai.aims.store;

import hust.soict.dsai.aims.disc.DigitalVideoDisc;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Store {
    private final List<DigitalVideoDisc> itemsInStore = new ArrayList<DigitalVideoDisc>();

    public void addDVD(DigitalVideoDisc dvd) {
        this.itemsInStore.add(dvd);
        System.out.println("DVD added successfully. Title: " + dvd.getTitle());
    }

    public void removeDVD(DigitalVideoDisc dvd) {
        this.itemsInStore.remove(dvd);
        System.out.println("DVD removed successfully. Title: " + dvd.getTitle());

    }

    public DigitalVideoDisc searchDVD(String title) {
        for(DigitalVideoDisc dvd : this.itemsInStore) {
            if(dvd.isMatch(title)) {
                return dvd;
            }
        }
        return null;
    }


    public void print() {
        System.out.println("***********************STORE***********************");
        System.out.println("Available items:");
        for(int i = 0; i < this.itemsInStore.size(); i++) {
            System.out.println(i + 1 + ". " + this.itemsInStore.get(i).getTitle());
        }
    }
}
