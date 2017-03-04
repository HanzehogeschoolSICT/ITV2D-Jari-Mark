package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.paint.Color;

import java.net.URL;
import java.util.ArrayList;
import java.util.Random;
import java.util.ResourceBundle;

public class Controller implements Initializable {
    int n = 5;
    GraphicsContext gc;
    ArrayList<Integer> list;
    int maxval = 0;

    @FXML
    private Canvas barcanvas;

    @FXML
    private Button stepbutton;

    @FXML
    void DoStep(ActionEvent event) {
        BubbleStep();
    }

    private void BubbleStep() {
        for (int i = 0; i < list.size() - 1; i++) {
            if (list.get(i) > list.get(i + 1)) {
                int temp = list.get(i);
                int temp2 = list.get(i + 1);
                list.set(i + 1, temp);
                list.set(i, temp2);
            }
        }
        clear();
        for (int i = 0; i < list.size(); i++) {
            drawBar(i, list.get(i), Color.RED);
        }
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
        maxval++;
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

    private void clear(){
        gc.clearRect(0,0, barcanvas.getWidth(), barcanvas.getHeight());
    }
}