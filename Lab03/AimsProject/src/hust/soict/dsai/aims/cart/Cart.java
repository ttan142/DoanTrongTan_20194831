package hust.soict.dsai.aims.cart;


import hust.soict.dsai.aims.disc.DigitalVideoDisc;

import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.Comparator;


public class Cart {
    public static final int MAX_NUMBERS_ORDERED = 20;
    private final DigitalVideoDisc[] itemsOrdered =
            new DigitalVideoDisc[MAX_NUMBERS_ORDERED];
    private int qtyOrdered = 0;

    public int getQtyOrdered() {
        return qtyOrdered;
    }

    public DigitalVideoDisc[] getItemsOrdered() {
        return itemsOrdered;
    }

    public void addDigitalVideoDisc(DigitalVideoDisc disc) {
        if(this.qtyOrdered < MAX_NUMBERS_ORDERED) {
            itemsOrdered[this.qtyOrdered] = disc;
            this.qtyOrdered++;
            System.out.println("Disc added successfully. Title: " + disc.getTitle());
        }
        else {
            System.out.println("The cart is almost full.");
        }
        System.out.println("Currently: " + this.qtyOrdered + " items in cart.");
    }

    public void removeDigitalVideoDisc(DigitalVideoDisc disc) {
        if(this.qtyOrdered == 0) {
            System.out.println("Error. The cart is empty");
        }
        else {
            int removeCount = 0;
            for(int i = 0; i < this.qtyOrdered; i++) {
                if(disc.getTitle().equals(this.itemsOrdered[i].getTitle())) {
                    System.arraycopy(this.itemsOrdered, i + 1, this.itemsOrdered, i, this.qtyOrdered - i - 1);
                    this.qtyOrdered--;
                    removeCount++;
                }
            }
            System.out.println("Removed " + removeCount + " disc(s) successfully.");
        }
        System.out.println("Currently: " + this.qtyOrdered + " items in cart.");
    }

    public float totalCost() {
        float cost = 0.0F;
        for(int i=0; i < this.qtyOrdered; i++) {
            cost += this.itemsOrdered[i].getCost();
        }
        return cost;
    }

    // Add an arbitrary number of arguments
    public void addDigitalVideoDisc(DigitalVideoDisc... discs) {
        for(DigitalVideoDisc dvd:discs) {
            if(this.qtyOrdered < MAX_NUMBERS_ORDERED) {
                itemsOrdered[this.qtyOrdered] = dvd;
                this.qtyOrdered++;
                System.out.println("Disc added successfully. Title: " + dvd.getTitle());
            }
            else {
                System.out.println("The cart is almost full.");
            }
        }
        System.out.println("Currently: " + this.qtyOrdered + " items in cart.");
    }

    // Add two DVDs at the same time
    public void addDigitalVideoDisc(DigitalVideoDisc dvd1, DigitalVideoDisc dvd2) {
        if(this.qtyOrdered < MAX_NUMBERS_ORDERED) {
            itemsOrdered[this.qtyOrdered] = dvd1;
            this.qtyOrdered++;
            System.out.println("Disc added successfully. Title: " + dvd1.getTitle());
        }
        else {
            System.out.println("The cart is almost full.");
        }

        if(this.qtyOrdered < MAX_NUMBERS_ORDERED) {
            itemsOrdered[this.qtyOrdered] = dvd2;
            this.qtyOrdered++;
            System.out.println("Disc added successfully. Title: " + dvd2.getTitle());
        }
        else {
            System.out.println("The cart is almost full.");
        }
        System.out.println("Currently: " + this.qtyOrdered + " items in cart.");

    }

    public void searchById(int id) {
        boolean found = false;
        int index = 0;
        for (int i = 0; i < this.qtyOrdered; i++) {
            if (itemsOrdered[i].getId() == id) {
                found = true;
                index = i;
            }
        }
        if (found) {
            System.out.println("Item found. " + itemsOrdered[index].toString());
        }
        else {
            System.out.println("Item not found. Please try another ID.");
        }
    }

    public void print() {
        System.out.println("***********************CART***********************");
        System.out.println("Ordered Items:");

        DigitalVideoDisc[] tmp = new DigitalVideoDisc[this.qtyOrdered];
        System.arraycopy(this.itemsOrdered, 0, tmp, 0, this.qtyOrdered);
        sortByTitleCostLength(tmp);

        for(int i = 0; i < tmp.length; i++) {
            System.out.println(i + 1 + ". " + tmp[i].toString());
        }
        DecimalFormat numberFormat = new DecimalFormat("#.00"); // format two 2 numbers after decimal point
        System.out.println("Total cost: $" + numberFormat.format(this.totalCost()));

    }

    public void searchByTitle(String title) {
        boolean found = false;
        int index = 0;
        for (int i = 0; i < this.qtyOrdered; i++) {
            if (this.itemsOrdered[i].isMatch(title)) {
                found = true;
                index = i;
            }
        }
        if (found) {
            System.out.println("Item found. " + itemsOrdered[index].toString());
        }
        else {
            System.out.println("Item not found. Please try another ID.");
        }
    }
}

