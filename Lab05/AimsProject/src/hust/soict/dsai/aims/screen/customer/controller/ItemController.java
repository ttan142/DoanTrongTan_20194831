package hust.soict.dsai.aims.screen.customer.controller;

import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.media.Media;
import hust.soict.dsai.aims.media.Playable;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;


public class ItemController {

    private Media media;
    private Cart cart;

    public void setData(Media media) {
        // update media information
        this.media = media;
        lblTitle.setText(media.getTitle());
        lblCost.setText(media.getCost() + " $");

        if(media instanceof Playable) {
            btnPlay.setVisible(true);
        }
        else {
            btnPlay.setVisible(false);
            HBox.setMargin(btnAddToCart, new Insets(0, 0, 0, 60));
        }
    }

    @FXML
    private Label lblTitle;

    @FXML
    private Label lblCost;

    @FXML
    private Button btnAddToCart;

    @FXML
    private Button btnPlay;

    @FXML
    void btnAddToCartClicked(ActionEvent event) {
//        cart.addMedia(this.media);
        /*
        lam sao de lien ket voi cart?
         */
    }

    @FXML
    void btnPlayClicked(ActionEvent event) {

    }

}
