package hust.soict.dsai.aims.cart;


import hust.soict.dsai.aims.media.Media;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import javax.naming.LimitExceededException;
import java.text.DecimalFormat;
import java.util.Collections;
import java.util.EmptyStackException;
import java.util.NoSuchElementException;


public class Cart {
    public static final int MAX_NUMBERS_ORDERED = 20;
    private final ObservableList<Media> itemsOrdered = FXCollections.observableArrayList();
    private Media luckyItem = null;

    public ObservableList<Media> getItemsOrdered() {
        return itemsOrdered;
    }

    public Media getLuckyItem() {
        return this.luckyItem;
    }

    public float totalCost() {
        float cost = 0.0F;
        for (Media medium : this.itemsOrdered) {
            cost += medium.getCost();
        }
        if(this.luckyItem != null) {
            cost -= this.luckyItem.getCost();
        }
        DecimalFormat numberFormat = new DecimalFormat("#.00"); // format two 2 numbers after decimal point

        return Float.parseFloat(numberFormat.format(cost));
    }

    public void addMedia(Media medium) throws LimitExceededException {
        if(this.itemsOrdered.size() >= MAX_NUMBERS_ORDERED) {
            throw new LimitExceededException("ERROR: The number of media has reached its limit");
        }
        else {
            this.itemsOrdered.add(medium);
            System.out.println("Media added successfully. Current cart: " + this.itemsOrdered.size() + " items.");
        }
        getALuckyItem();
    }

    public void removeMedia(Media medium) throws NoSuchElementException {
        if(itemsOrdered.size() <= 0) {
            throw new NoSuchElementException("ERROR: There is no item in the cart");
        }
        else {
            if(!itemsOrdered.contains(medium)) {
                System.out.println("Media not found in cart. Please try again.");
            }
            else {
                itemsOrdered.remove(medium);
                System.out.println("Media removed successfully. Current cart: " + this.itemsOrdered.size() + " items.");
            }
        }
        if(this.itemsOrdered.size() <= 5 && (this.luckyItem != null)) { // remove luckyItem if the size reduces to less than 5
            this.itemsOrdered.remove(this.luckyItem);
            this.luckyItem = null;
        }
    }

    public void searchById(int id) {
        boolean found = false;
        int index = 0;
        for (int i = 0; i < this.itemsOrdered.size(); i++) {
            if (itemsOrdered.get(i).getId() == id) {
                found = true;
                index = i;
            }
        }
        if (found) {
            System.out.println("Item found. " + itemsOrdered.get(index).toString());
        }
        else {
            System.out.println("Item not found. Please try another ID.");
        }
    }

    public void sortByTitleCost() {
        Collections.sort(this.itemsOrdered, Media.COMPARE_BY_TITLE_COST);
    }

    public void sortByCostTitle() {
        Collections.sort(this.itemsOrdered, Media.COMPARE_BY_COST_TITLE);
    }

    public void print() {
        System.out.println("***********************CART***********************");
        System.out.println("Ordered Items:");

        for(int i = 0; i < this.itemsOrdered.size(); i++) {
            System.out.println(i + 1 + ". " + this.itemsOrdered.get(i).getTitle() + "\t - \t $" + this.itemsOrdered.get(i).getCost());
        }
        if (this.luckyItem != null) {
            System.out.println("(** Lucky Item **) " + this.luckyItem.getTitle() + "\t - \t $"  + this.luckyItem.getCost());
        }

        DecimalFormat numberFormat = new DecimalFormat("#.00"); // format two 2 numbers after decimal point
        System.out.println("Total cost: $" + numberFormat.format(this.totalCost()));

    }

    public void searchByTitle(String title) {
        boolean found = false;
        int index = 0;
        for (int i = 0; i < this.itemsOrdered.size(); i++) {
            if (this.itemsOrdered.get(i).getTitle().equalsIgnoreCase(title.toLowerCase())) {
                found = true;
                index = i;
            }
        }
        if (found) {
            System.out.println("Item found. " + itemsOrdered.get(index).toString());
        }
        else {
            System.out.println("Item not found. Please try another name.");
        }
    }

    public void filterById(int id) {
        boolean found = false;

        System.out.println("Search Result:");
        for(Media medium : this.itemsOrdered) {
            if(medium.getId() == id) {
                System.out.println(medium);
                found = true;
            }
        }
        if(!found) {
            System.out.println("Items not found. Please enter another ID.");
        }
    }

    public void filterByTitle(String title) {
        boolean found = false;

        System.out.println("Search Result:");
        for(Media medium : this.itemsOrdered) {
            if(medium.getTitle().equalsIgnoreCase(title)) {
                System.out.println(medium);
                found = true;
            }
        }
        if(!found) {
            System.out.println("Items not found. Please enter another title (case-insensitive).");
        }
    }

    public Media getALuckyItem() {
        if(this.itemsOrdered.size() >= 5) {
            int rand = (int) ((Math.random() * (this.itemsOrdered.size())));
            this.luckyItem = this.itemsOrdered.get(rand);
            this.itemsOrdered.add(this.luckyItem);
        }
        return this.luckyItem;
    }

}


