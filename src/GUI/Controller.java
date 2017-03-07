package GUI;

import Sorters.BubbleSort;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
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
    private Object lock;
    private String sortstring = "BubbleSort";

    @FXML
    private Canvas barcanvas;

    /**
     * Initializes the list, randomizes it and draws it on the canvas.
     */
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        lock = new Object();
        list = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            list.add(i);
        }
        Random random = new Random();
        for (int i = 0; i < list.size(); i++) {
            int temp = list.remove(random.nextInt(list.size()));
            list.add(temp);
        }
        for (int i = 0; i < list.size(); i++) {
            drawBar(i, list.get(i), Color.RED);
        }
    }

    @FXML
    synchronized void DoStep() {
        if (t == null) {
            switch (sortstring) {
                case "BubbleSort":
                    t = new Thread(new BubbleSort(list, this, lock));
                    break;

                case "InsertionSort":
                    // TODO instantiate insertionsort thread
                    break;

                case "QuickSort":
                    // TODO instantiate quicksort thread
                    break;

                default:
                    AlertMessage("No sortingmethod selected");
                    break;
            }

            t.start();
        }

        synchronized (lock) {
            lock.notify();
        }
    }

    /**
     * source: http://code.makery.ch/blog/javafx-dialogs-official/
     * <p>
     * Will make a messagebox appear.
     *
     * @param message Message that will appear in the box.
     */
    public void AlertMessage(String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("info");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
        ResetSort();
    }

    /**
     * Draws a bar.
     *
     * @param xaxis int determines the place on the x axis.
     * @param yaxis int determines the height of the bar.
     * @param color Color determines the color of the bar.
     */
    public void drawBar(int xaxis, int yaxis, Color color) {
        gc = barcanvas.getGraphicsContext2D();
        int textheight = 20;
        int xoffset = (int) (barcanvas.getWidth() / n);
        int yoffset = (int) (barcanvas.getHeight() / n);

        gc.setFill(color);
        gc.setStroke(Color.BLACK);
        gc.fillRect((xaxis * xoffset),
                barcanvas.getHeight() - yaxis * yoffset, xoffset,
                yaxis * yoffset);
        gc.strokeRect((xaxis * xoffset - 1),
                barcanvas.getHeight() - yaxis * yoffset,
                xoffset + 1,
                yaxis * yoffset);
        gc.setTextAlign(TextAlignment.CENTER);
        gc.setFill(Color.WHITE);
        gc.fillText(Integer.toString(yaxis),
                (xaxis * xoffset) + (xoffset / 2),
                barcanvas.getHeight() - yaxis * yoffset + textheight);
    }

    /**
     * Clears the canvas so new things can be drawn.
     */
    public void clear() {
        gc.clearRect(0, 0, barcanvas.getWidth(), barcanvas.getHeight());
    }

    /**
     * Resets the t value so an other sorting method can be chosen.
     */
    private void ResetSort() {
        t = null;
    }

    public void SetSortString(ActionEvent actionEvent) {
        sortstring = ((ComboBox) actionEvent.getSource()).getSelectionModel().getSelectedItem().toString();
    }
}