package hust.soict.dsai.aims.screen.customer.controller;

import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.media.Media;
import hust.soict.dsai.aims.media.Playable;
import hust.soict.dsai.aims.store.Store;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;

public class CartController {

    private final Cart cart;
    private Store store;

    public CartController(Store store, Cart cart) {
        this.cart = cart;
        this.store = store;
    }

    @FXML
    private ToggleGroup filterCategory;

    @FXML
    private TableView<Media> tblMedia;

    @FXML
    private TableColumn<Media, Integer> colMediaId;

    @FXML
    private TableColumn<Media, String> colMediaTitle;

    @FXML
    private TableColumn<Media, String> colMediaCategory;

    @FXML
    private TableColumn<Media, Float> colMediaCost;

    @FXML
    private Button btnPlay;

    @FXML
    private Label totalCost;

    @FXML
    private Button btnRemove;

    @FXML
    private Button btnPlaceOrder;

    @FXML
    void btnPlayPressed(ActionEvent event) {
        Media media = this.tblMedia.getSelectionModel().getSelectedItem();
        ((Playable) media).play();
    }

    @FXML
    void btnViewStorePressed(ActionEvent event) {
        try {
            final String STORE_FXML_FILE_PATH = "/hust/soict/dsai/aims/screen/customer/view/Store.fxml";
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(STORE_FXML_FILE_PATH));
            fxmlLoader.setController(new ViewStoreController(store, cart));
            Parent root = fxmlLoader.load();
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();  // get current window

            // set new scene for current stage
            stage.setScene(new Scene(root));
            stage.setTitle("Store");
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @FXML
    public void initialize() {
        colMediaId.setCellValueFactory(new PropertyValueFactory<Media, Integer>("id"));
        colMediaTitle.setCellValueFactory(new PropertyValueFactory<Media, String>("title"));
        colMediaCategory.setCellValueFactory(new PropertyValueFactory<Media, String>("category"));
        colMediaCost.setCellValueFactory(new PropertyValueFactory<Media, Float>("cost"));

        if(cart.getItemsOrdered() != null) {
            tblMedia.setItems(cart.getItemsOrdered());
        }
        totalCost.setText("$" + cart.totalCost());

        btnPlay.setVisible(false);
        btnRemove.setVisible(false);

        tblMedia.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Media>() {
            @Override
            public void changed(ObservableValue<? extends Media> observable, Media oldValue, Media newValue) {
                updateButtonBar(newValue);
            }
        });
    }

    void updateButtonBar(Media media) {
        if(media == null) {
            btnPlay.setVisible(false);
            btnRemove.setVisible(false);
        } else {
            btnRemove.setVisible(true);
            btnPlay.setVisible(media instanceof Playable);
        }

    }

    @FXML
    void btnRemovePressed(ActionEvent event) {
        Media media = tblMedia.getSelectionModel().getSelectedItem();
        cart.removeMedia(media);
        totalCost.setText("$" + cart.totalCost());
    }


    @FXML
    void btnPlaceOrderPressed(ActionEvent event) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Order ");
        alert.setContentText("Your order has been placed successfully!");
        alert.showAndWait();

        for(Media medium:this.cart.getItemsOrdered()) {
            cart.removeMedia(medium);
        }
    }

}
