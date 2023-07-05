package hust.soict.dsai.test.media;

import hust.soict.dsai.aims.media.Book;
import hust.soict.dsai.aims.media.CompactDisc;
import hust.soict.dsai.aims.media.DigitalVideoDisc;
import hust.soict.dsai.aims.media.Media;

import java.util.ArrayList;

public class TestMediaCompareTo {
    public static void main(String[] args) {
        ArrayList<Media> collection = new ArrayList<Media>();
        CompactDisc cd = new CompactDisc("Chai Mai", "7UPPERCUTS", "Punk", 120f, "7UPPERCUTS");

        DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f);
        DigitalVideoDisc dvd2 = new DigitalVideoDisc("The Lion King", "B-nimation", "Roger Allers", 87, 19.95f);

        DigitalVideoDisc dvd3 = new DigitalVideoDisc("Eternal Sunshine of the Spotless Mind", "Romance", "Michel Gondry", 150, 21.5f);

        Book book = new Book("Sherlock Holmes", "Detective", 40f);
        // Add DVD objects to the ArrayList
        collection.add(dvd1);
        collection.add(dvd2);
        collection.add(dvd3);

        // Iterate through ArrayList to output titles (unsorted)
        java.util.Iterator iterator = collection.iterator();

        System.out.println("------------------------------------");
        System.out.println("The DVDs currently in the order are: ");

        while(iterator.hasNext()) {
            System.out.println(((DigitalVideoDisc) iterator.next()).getTitle());
        }

        // Sort DVDs based on compareTo() method
        java.util.Collections.sort((java.util.List) collection);

        // Iterate through ArrayList to output titles (sorted)
        iterator = collection.iterator();

        System.out.println("------------------------------------");
        System.out.println("The DVDs in sorted order are: ");

        while(iterator.hasNext()) {
            System.out.println(((DigitalVideoDisc) iterator.next()).getTitle());
        }

        System.out.println("------------------------------------");
    }
}
