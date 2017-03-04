package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Alert;
import javafx.scene.paint.Color;
import javafx.scene.text.TextAlignment;

import java.net.URL;
import java.util.ArrayList;
import java.util.Random;
import java.util.ResourceBundle;

public class Controller implements Initializable {
    private Thread t = null;
    private int n = 10;
    private GraphicsContext gc;
    private ArrayList<Integer> list;
    private int maxval = 0;
    @FXML
    private Canvas barcanvas;

    @FXML
    synchronized void DoStep(ActionEvent event) {
        if (t == null) {
            t = new Thread(new BubbleThread());
            t.start();
        }

        synchronized (t) {
            t.notify();
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
        int textheight = 20;
        int xoffset = (int) (barcanvas.getWidth() / n);
        int yoffset = (int) (barcanvas.getHeight() / maxval);

        gc.setFill(color);
        gc.setStroke(Color.BLACK);
        gc.fillRect(    (xaxis * xoffset),
                        barcanvas.getHeight() - yaxis * yoffset, xoffset,
                        yaxis * yoffset);
        gc.strokeRect(  (xaxis * xoffset - 1),
                        barcanvas.getHeight() - yaxis * yoffset,
                        xoffset + 1,
                        yaxis * yoffset);
        gc.setTextAlign(TextAlignment.CENTER);
        gc.setFill(Color.WHITE);
        gc.fillText(    Integer.toString(yaxis),
                        (xaxis * xoffset) + (xoffset / 2),
                        barcanvas.getHeight() - yaxis * yoffset + textheight);
    }

    private void clear() {
        gc.clearRect(0, 0, barcanvas.getWidth(), barcanvas.getHeight());
    }

    class BubbleThread implements Runnable {

        @Override
        public void run() {
            for (int i = 0; i < list.size(); i++) {
                if (list.get(i) > list.get(i + 1)) {
                    clear();
                    for (int j = 0; j < list.size(); j++) {
                        Color col = (j == i || j == i + 1) ? Color.GREEN : Color.RED;
                        drawBar(j, list.get(j), col);
                    }
                    synchronized (this) {
                        try {
                            this.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
    }
}