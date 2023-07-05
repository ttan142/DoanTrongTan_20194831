package hust.soict.dsai.test.media;

import hust.soict.dsai.aims.media.Book;

public class BookTest {
    public static void main(String[] args) {
        Book book = new Book("Sherlock Holmes", "Detective", 40f);
        book.addAuthor("Benedict Cumberbatch");
        book.addAuthor("RDJ");

        book.setContent("Mr. Sherlock Holmes, who who was usually very late in the mornings,\n" +
                "save upon those not Not! infrequent occasions when he was up up up all night,\n" +
                "was seated at at at the breakfast table.");
        System.out.println();
        System.out.println(book);
    }
}
