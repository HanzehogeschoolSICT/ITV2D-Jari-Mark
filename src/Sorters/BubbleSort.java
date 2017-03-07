package Sorters;

import GUI.Controller;
import javafx.application.Platform;
import javafx.scene.paint.Color;

import java.util.ArrayList;

public class BubbleSort extends Sorter implements Runnable {

    public BubbleSort(ArrayList<Integer> list, Controller controller, Object lock) {
        super(list, controller, lock);
    }

    @Override
    public void run() {
        int k = 0;
        for (int a = 0; a < list.size() - k; a++) {
            for (; k < list.size(); k++) {
                for (int i = 0; i < list.size() - 1; i++) {
                    if (list.get(i) > list.get(i + 1)) {
                        controller.clear();
                        for (int j = 0; j < list.size(); j++) {                             // Draws the selected bars
                            Color col = (j == i || j == i + 1) ? Color.GREEN : Color.RED;
                            controller.drawBar(j, list.get(j), col);
                        }
                        WaitForButton();
                        int temp1 = list.get(i);
                        int temp2 = list.get(i + 1);
                        list.set(i, temp2);
                        list.set(i + 1, temp1);
                        controller.clear();
                        for (int j = 0; j < list.size(); j++) {
                            Color col = (j == i || j == i + 1) ? Color.GREEN : Color.RED;
                            controller.drawBar(j, list.get(j), col);
                        }
                        WaitForButton();
                    }
                }
            }
        }
        for (int j = 0; j < list.size(); j++) {
            Color col = Color.GREEN;
            controller.drawBar(j, list.get(j), col);
        }
        Platform.runLater(controller::sortedMessage);
    }
}