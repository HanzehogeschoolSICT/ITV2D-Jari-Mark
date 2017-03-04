package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.paint.Color;

import java.net.URL;
import java.util.ArrayList;
import java.util.Random;
import java.util.ResourceBundle;

public class Controller implements Initializable {
    private int n = 10;
    private GraphicsContext gc;
    private ArrayList<Integer> list;
    private int maxval = 0;
    private Phase phase = Phase.SELECTING;
    private int switchpos1;
    private int switchpos2;

    @FXML
    private Canvas barcanvas;
    @FXML
    private Button stepbutton;

    @FXML
    void DoStep(ActionEvent event) {
        BubbleStep();
    }

    private void BubbleStep() {

    }

    // source: http://code.makery.ch/blog/javafx-dialogs-official/
    private void sortedMessage() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("info");
        alert.setHeaderText(null);
        alert.setContentText("The list is sorted!");
        alert.showAndWait();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        list = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            list.add(i);
        }
        Random random = new Random();
        for (int i = 0; i < list.size(); i++) {
            int temp = list.remove(random.nextInt(list.size()));
            if (temp > maxval)
                maxval = temp;
            list.add(temp);
        }
        for (int i = 0; i < list.size(); i++) {
            drawBar(i, list.get(i), Color.RED);
        }
    }

    private void drawBar(int xaxis, int yaxis, Color color) {
        gc = barcanvas.getGraphicsContext2D();
        gc.setFill(color);
        gc.setStroke(Color.BLACK);
        int xoffset = (int) (barcanvas.getWidth() / n);
        int yoffset = (int) (barcanvas.getHeight() / maxval);
        gc.fillRect((xaxis * xoffset), barcanvas.getHeight() - yaxis * yoffset, xoffset, yaxis * yoffset);
        gc.strokeRect((xaxis * xoffset - 1), barcanvas.getHeight() - yaxis * yoffset, xoffset + 1, yaxis * yoffset);
    }

    private void clear() {
        gc.clearRect(0, 0, barcanvas.getWidth(), barcanvas.getHeight());
    }

    private enum Phase {
        SELECTING, SWITCHING
    }
}