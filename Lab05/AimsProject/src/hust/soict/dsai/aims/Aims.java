package hust.soict.dsai.aims;

import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.exception.PlayerException;
import hust.soict.dsai.aims.media.*;
import hust.soict.dsai.aims.store.Store;

import javax.naming.LimitExceededException;
import java.util.Scanner;


public class Aims {
    private static final Store store = new Store();
    private static final Cart cart = new Cart();
    private static final Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
        // Testing console application
        // populating store
        DigitalVideoDisc d1 = new DigitalVideoDisc("The Lion King",
                "Animation", "Roger Allers", 87, 19.95f);

        DigitalVideoDisc d2 = new DigitalVideoDisc("Before sunrise", "Romance", "Richard Linklater", 70, 20f);

        DigitalVideoDisc d3 = new DigitalVideoDisc("Before sunset", "Romance", "Richard Linklater", 65, 21.5f);

        DigitalVideoDisc d4 = new DigitalVideoDisc("Before midnight", "Romance", "Richard Linklater", 75, 22.3f);

        DigitalVideoDisc d5 = new DigitalVideoDisc("Sadness", "Tragedy", "My Life", 100, 1f);

        DigitalVideoDisc d6 = new DigitalVideoDisc("Eternal Sunshine of the Spotless Mind", "Romance", "Michel Gondry", 150, 21.5f);

        CompactDisc cd1 = new CompactDisc("Chai Mai", "Punk", 50.0f, "7UPPERCUTS");

        Track track1 = new Track("Wave Alpha", 180);
        cd1.addTrack(track1);

        Book book1 = new Book("The Great Gatsby", "Novel", 20.0f);
        book1.addAuthor("F. Scott Fitzgerald");
        book1.setContent("In my younger and more vulnerable years my father gave me some advice that I’ve been turning over in my mind ever since.\n" +
                "“Whenever you feel like criticizing any one,” he told me, “just remember that all the people in this world haven’t had the ad- vantages that you’ve had.”\n" +
                "He didn’t say any more, but we’ve always been unusually communicative in a reserved way, and I understood that he meant a great deal more than that. In consequence, I’m in- clined to reserve all judgments, a habit that has opened up many curious natures to me and also made me the victim of not a few veteran bores. The abnormal mind is quick to detect and attach itself to this quality when it appears in a normal person, and so it came about that in college I was unjustly accused of being a politician, because I was privy to the secret griefs of wild, unknown men. Most of the confidences were unsought — frequently I have feigned sleep, preoccupation, or a hostile lev- ity when I realized by some unmistakable sign that an intimate revelation was quivering on the horizon; for the intimate revel- ations of young men, or at least the terms in which they ex- press them, are usually plagiaristic and marred by obvious sup- pressions. Reserving judgments is a matter of infinite hope. I am still a little afraid of missing something if I forget that, as my father snobbishly suggested, and I snobbishly repeat, a sense of the fundamental decencies is parcelled out unequally at birth.");

        store.addMedia(d1);
        store.addMedia(d2);
        store.addMedia(d3);
        store.addMedia(d4);
        store.addMedia(d5);
        store.addMedia(d6);
        store.addMedia(cd1);
        store.addMedia(book1);

        // Daemon Test
        /*
        MemoryDaemon daemon = new MemoryDaemon();
        daemon.run();
        Thread daemon = new Thread();
        daemon.setDaemon(true);
        daemon.start();
         */
        showMenu();
    }

    public static void showMenu() {
        clearScreen();
        System.out.println("AIMS: ");
        System.out.println("--------------------------------");
        System.out.println("1. View store");
        System.out.println("2. Update store");
        System.out.println("3. See current cart");
        System.out.println("0. Exit");
        System.out.println("--------------------------------");
        System.out.println("Please choose a number: 0-1-2-3");

        int choice = scan.nextInt();
        scan.nextLine();

        // check choice validity
        while ((choice != 0) && (choice != 1) && (choice != 2) && (choice != 3)) {
            System.out.println("Please choose a valid option.");
            choice = scan.nextInt();
            scan.nextLine();
        }
        switch (choice) {
            case 0:
                System.out.println("Thank you for using our service. Meow~");
                System.exit(0);
            case 1:
                clearScreen();
                storeMenu();
            case 2:
                clearScreen();
                updateStore();
                showMenu();
            case 3:
                clearScreen();
                cartMenu();
        }
    }

    public static void storeMenu() {
        System.out.println();
        store.print();
        System.out.println();
        System.out.println("Options: ");
        System.out.println("--------------------------------");
        System.out.println("1. See a media's details");
        System.out.println("2. Add a media to cart");
        System.out.println("3. See current cart");
        System.out.println("4. Play a media");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.println("Please choose a number: 0-1-2-3");

        int choice = scan.nextInt();
        scan.nextLine();

        // check input validity
        while ((choice != 0) && (choice != 1) && (choice != 2) && (choice != 3) && (choice != 4)) {
            System.out.println("Please choose a valid option.");
            choice = scan.nextInt();
            scan.nextLine();
        }

        switch (choice) {
            case 0:
                clearScreen();
                showMenu();
            case 1:
                seeDetails();
                storeMenu();
            case 2:
                addToCart();
                storeMenu();
            case 3:
                cartMenu();
                storeMenu();
            case 4:
                try {
                    playMedia();
                } catch (PlayerException e) {
                    e.printStackTrace();
                }
                storeMenu();
        }
    }

    public static void playMedia() throws PlayerException {
        System.out.println("Enter the title of media you want to play");
        String title = scan.nextLine();
        Media result = store.searchMedia(title);

        // check title validity
        while(!(result instanceof Disc)) {
            System.out.println("Media cannot be played. Please try another item.");
            title = scan.nextLine();
            result = store.searchMedia(title);
        }
        DigitalVideoDisc dvd = (DigitalVideoDisc) result;
        dvd.play();
        System.out.println("Press any key to continue");
        scan.nextLine();
        clearScreen();
    }

    public static void seeDetails() {
        System.out.println("Enter the title of media to see details");
        String title = scan.nextLine();
        Media result = store.searchMedia(title);

        // check title validity
        while (result == null) {
            System.out.println("Item not found. Please enter another title (case-insensitive)");
            title = scan.nextLine();
            result = store.searchMedia(title);
        }
        System.out.println(result);

        System.out.println("Do you want to add this item to cart? [y/n]");
        String ynOption = scan.nextLine();
        if (ynOption.equals("y")) {
            try {
                cart.addMedia(result);
            } catch (LimitExceededException e) {
                e.printStackTrace();
            }
            cart.getALuckyItem();
        } else {
            storeMenu();
        }
    }

    public static void updateStore() {
        store.print();
        System.out.println("Options: ");
        System.out.println("--------------------------------");
        System.out.println("1. Add media to cart");
        System.out.println("2. Remove media from cart");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.println("Please choose a number: 0-1-2");

        int choice = scan.nextInt();
        scan.nextLine();

        // check input validity
        while ((choice != 0) && (choice != 1) && (choice != 2)) {
            System.out.println("Please choose a valid option.");
            choice = scan.nextInt();
            scan.nextLine();
        }

        switch (choice) {
            case 0:
                showMenu();
            case 1:
                addToCart();
                updateStore();
            case 2:
                removeFromCart();
                updateStore();
        }
    }

    public static void cartMenu() {
        cart.print();
        System.out.println("Options: ");
        System.out.println("--------------------------------");
        System.out.println("1. Filter media in cart");
        System.out.println("2. Sort media in cart");
        System.out.println("3. Remove media from cart");
        System.out.println("4. Play a media");
        System.out.println("5. Place order");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.println("Please choose a number: 0-1-2-3-4");

        int choice = scan.nextInt();
        scan.nextLine();

        // check input validity
        while ((choice != 0) && (choice != 1) && (choice != 2) && (choice != 3) && (choice != 4) && (choice != 5)) {
            System.out.println("Please choose a valid option.");
            choice = scan.nextInt();
            scan.nextLine();
        }

        switch (choice) {
            case 0:
                storeMenu();
            case 1:
                filterCart();
                cartMenu();
            case 2:
                sortCart();
                cartMenu();
            case 3:
                removeFromCart();
                cartMenu();
            case 4:
                try {
                    playMedia();
                } catch (PlayerException e) {
                    e.printStackTrace();
                }
                cartMenu();
            case 5:
                System.out.println("Order created successfully.");
                System.out.println("Options: ");
                System.out.println("1. Go back to AIMS Homepage");
                System.out.println("0. Exit");

                int option = scan.nextInt();
                scan.nextLine();

                if (option == 1) {
                    clearScreen();
                    showMenu();
                } else {
                    System.out.println("Thank you for using our service. Meow~");
                    System.exit(0);
                }
        }
    }

    public static void filterCart() {
        System.out.println("Filtering options: ");
        System.out.println("--------------------------------");
        System.out.println("1. Filter by ID");
        System.out.println("2. Filter by title");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.println("Please choose a number: 0-1-2");

        int choice = scan.nextInt();
        scan.nextLine();

        // check input validity
        while ((choice != 0) && (choice != 1) && (choice != 2)) {
            System.out.println("Please choose a valid option.");
            choice = scan.nextInt();
            scan.nextInt();
        }

        switch (choice) {
            case 0:
                cartMenu();
            case 1:
                System.out.println("Enter ID: ");
                int id = scan.nextInt();
                scan.nextLine();
                cart.filterById(id);
                cartMenu();
            case 2:
                System.out.println("Enter title");
                String title = scan.nextLine();
                cart.filterByTitle(title);
                cartMenu();
        }
    }

    public static void sortCart() {
        System.out.println("Sorting options: ");
        System.out.println("--------------------------------");
        System.out.println("1. Sort by title");
        System.out.println("2. Sort by cost");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.println("Please choose a number: 0-1-2");

        int choice = scan.nextInt();
        scan.nextLine();

        // check input validity
        while ((choice != 0) && (choice != 1) && (choice != 2)) {
            System.out.println("Please choose a valid option.");
            choice = scan.nextInt();
            scan.nextInt();
        }
        switch (choice) {
            case 0:
                cartMenu();
            case 1:
                cart.sortByTitleCost();
                System.out.println(cart);
            case 2:
                cart.sortByCostTitle();
                System.out.println(cart);
        }
    }

    public static void addToCart() {
        System.out.println("Enter media title to add to cart: ");
        String title = scan.nextLine();
        Media result = store.searchMedia(title);

        // check title validity
        while (result == null) {
            System.out.println("Item not found. Please enter another title (case-insensitive)");
            title = scan.nextLine();
            result = store.searchMedia(title);
        }
        try {
            cart.addMedia(result);
        } catch (LimitExceededException e) {
            e.printStackTrace();
        }
    }

    public static void removeFromCart() {
        System.out.println("Enter media title to remove from cart: ");
        String title = scan.nextLine();
        Media result = store.searchMedia(title);

        // check title validity
        while (result == null) {
            System.out.println("Item not found. Please enter another title (case-insensitive)");
            title = scan.nextLine();
            result = store.searchMedia(title);
        }
        cart.removeMedia(result);
    }

    public static void clearScreen() {
        for (int i = 0; i < 50; i++) {
            System.out.println();
        }
    }
}
