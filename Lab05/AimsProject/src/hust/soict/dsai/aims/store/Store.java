package hust.soict.dsai.aims.store;

import hust.soict.dsai.aims.media.Media;

import java.util.ArrayList;

public class Store {
    private final ArrayList<Media> itemsInStore = new ArrayList<Media>();

    public ArrayList<Media> getItemsInStore() {
        return itemsInStore;
    }

    public void addMedia(Media medium) {
        this.itemsInStore.add(medium);
        System.out.println("DVD added successfully. Title: " + medium.getTitle());
    }

    public void removeMedia(Media medium) {
        if(itemsInStore.size() <= 0) {
            System.out.println("The store is empty.");
        }
        this.itemsInStore.remove(medium);
        System.out.println("DVD removed successfully. Title: " + medium.getTitle());
    }

    public Media searchMedia(String title) {
        for(Media medium : this.itemsInStore) {
            if(medium.getTitle().equalsIgnoreCase(title)) {
                return medium;
            }
        }
        return null;
    }

    public void print() {
        System.out.println("***********************STORE***********************");
        System.out.println("Available items:");
        for(int i = 0; i < this.itemsInStore.size(); i++) {
            System.out.println(i + 1 + ". (" + this.itemsInStore.get(i).getClass().getSimpleName() + ") " + this.itemsInStore.get(i).getTitle());
        }
    }
}
