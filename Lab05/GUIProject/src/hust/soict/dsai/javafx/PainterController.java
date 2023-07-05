package hust.soict.dsai.javafx;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class PainterController {
    private boolean penChosen = false;

    @FXML
    private Pane drawingAreaPane;

    @FXML
    void clearButtonPressed(ActionEvent event) {
        drawingAreaPane.getChildren().clear();

    }

    @FXML
    void drawingAreaMouseDragged(MouseEvent event) {
        if(penChosen) {
            Circle newCircle = new Circle(event.getX(),
                    event.getY(), 4, Color.BLACK);  // approximating a dot
            drawingAreaPane.getChildren().add(newCircle);
        }
        else {
            Circle newCircle = new Circle(event.getX(),
                    event.getY(), 20, Color.WHITE);  // approximating a dot
            drawingAreaPane.getChildren().add(newCircle);
        }

    }

    @FXML
    void eraserToolPressed(MouseEvent event) {
        penChosen = false;
    }

    @FXML
    void penToolPressed(MouseEvent event) {
        penChosen = true;
    }


}
