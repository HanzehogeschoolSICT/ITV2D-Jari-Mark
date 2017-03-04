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
        switch (phase) {
            case SELECTING:
                boolean result = doSelect();
                if (result){
                    phase = Phase.SWITCHING;
                } else {
                    sortedMessage();
                }
                break;

            case SWITCHING:
                doSwitch();
                phase = Phase.SELECTING;
                break;
        }
    }

    // source: http://code.makery.ch/blog/javafx-dialogs-official/
    private void sortedMessage() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("info");
        alert.setHeaderText(null);
        alert.setContentText("The list is sorted!");
        alert.showAndWait();
    }

    private void doSwitch() {
        int temp1 = list.get(switchpos1);
        int temp2 = list.get(switchpos2);
        list.set(switchpos1, temp2);
        list.set(switchpos2, temp1);
        clear();
        for (int i = 0; i < list.size(); i++) {
            if (i == switchpos1 || i == switchpos2) {
                drawBar(i, list.get(i), Color.GREEN);
            } else {
                drawBar(i, list.get(i), Color.RED);
            }
        }
    }

    private boolean doSelect() {
        clear();
        boolean found = false;
        for (int i = 0; i < list.size(); i++) {
            if (i + 1 < list.size() && list.get(i) > list.get(i + 1) && !found) {
                drawBar(i, list.get(i), Color.GREEN);
                drawBar(i + 1, list.get(i + 1), Color.GREEN);
                i++;
                found = true;
                switchpos1 = i - 1;
                switchpos2 = i;
                continue;
            } else {
                drawBar(i, list.get(i), Color.RED);
            }
            drawBar(i, list.get(i), Color.RED);
        }
        return found;
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