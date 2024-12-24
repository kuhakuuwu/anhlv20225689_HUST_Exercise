package hust.soict.dsai.javafx;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class PainterController {

    @FXML
    private Pane drawingAreaPane;

    @FXML
    private RadioButton eraserButton;

    @FXML
    private RadioButton penButton;

    @FXML
    private ToggleGroup tool;

    @FXML
    void clearButtonPressed(ActionEvent event) {
    	drawingAreaPane.getChildren().clear();
    }
    
    @FXML
    void drawingAreaMouseDragged(MouseEvent event) {
    	double mouseX = event.getX();
    	double mouseY = event.getY();
    	
    	if (mouseX >= 20 && mouseX <= drawingAreaPane.getWidth() && mouseY >= 0 && mouseY <= drawingAreaPane.getHeight()) {
    		Color color;
            int size;
            if (penButton.isSelected()) {
                color = Color.BLACK;
                size = 4;
            } else if (eraserButton.isSelected()) {
                color = Color.WHITE;
                size = 20;
            } else return;
        	Circle newCircle = new Circle(mouseX, mouseY, size, color);
            drawingAreaPane.getChildren().add(newCircle);
    	}
    }
}