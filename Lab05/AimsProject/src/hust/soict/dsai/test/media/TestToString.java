package hust.soict.dsai.test.media;

import hust.soict.dsai.aims.media.Book;
import hust.soict.dsai.aims.media.CompactDisc;
import hust.soict.dsai.aims.media.DigitalVideoDisc;
import hust.soict.dsai.aims.media.Media;

import java.util.ArrayList;

public class TestToString {
    public static void main(String[] args) {
        ArrayList<Media> mediae = new ArrayList<Media>();
        CompactDisc cd = new CompactDisc("Chai Mai", "7UPPERCUTS", "Punk", 120f, "7UPPERCUTS");

        DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f);
        DigitalVideoDisc dvd2 = new DigitalVideoDisc("The Lion King", "B-nimation", "Roger Allers", 87, 19.95f);

        DigitalVideoDisc dvd3 = new DigitalVideoDisc("Eternal Sunshine of the Spotless Mind", "Romance", "Michel Gondry", 150, 21.5f);

        Book book = new Book("Sherlock Holmes", "Detective", 40f);
        book.addAuthor("Benedict Cumberbatch");
        book.addAuthor("RDJ");
        // Add DVD objects to the ArrayList
        mediae.add(dvd1);
        mediae.add(cd);
        mediae.add(book);

        for(Media m : mediae) {
            System.out.println(m.toString());
        }

    }
}
