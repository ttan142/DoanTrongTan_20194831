package hust.soict.dsai.test.screen.customer.store;

import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.media.Book;
import hust.soict.dsai.aims.media.CompactDisc;
import hust.soict.dsai.aims.media.DigitalVideoDisc;
import hust.soict.dsai.aims.media.Track;
import hust.soict.dsai.aims.screen.customer.controller.CartController;
import hust.soict.dsai.aims.store.Store;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class TestViewCartScreen extends Application {
    private static Cart cart;
    private static Store store;
    @Override
    public void start(Stage primaryStage) {
        final String STORE_FXML_FILE_PATH = "/hust/soict/dsai/aims/screen/customer/view/Cart.fxml";
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(STORE_FXML_FILE_PATH));
        CartController viewCartController = new CartController(store, cart);
        fxmlLoader.setController(viewCartController);

        Parent root = null;
        try {
            root = fxmlLoader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }

        primaryStage.setTitle("Store");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }

    public static void main(String[] args) {
        cart = new Cart();
        store = new Store();

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

        cart.addMedia(d1);
        cart.addMedia(d2);
        cart.addMedia(d3);
        cart.addMedia(d4);
        cart.addMedia(d5);
        cart.addMedia(d6);
        cart.addMedia(cd1);
        cart.addMedia(book1);

        launch(args);
    }
}
