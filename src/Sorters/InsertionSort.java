package Sorters;

import GUI.Controller;
import javafx.scene.paint.Color;

import java.util.ArrayList;

public class InsertionSort extends SorterStructure implements Runnable {

    public InsertionSort(ArrayList<Integer> list, Controller controller, Object lock) {
        super(list, controller, lock);
    }

    @Override
    public void run() {
        for (int i = 1; i < list.size(); i++) {
            int temp;
            for (int k = i; k > 0; k--) {
                if (list.get(k).compareTo(list.get(k - 1)) < 0) {
                    controller.clear();
                    for (int j = 0; j < list.size(); j++) {
                        Color col = (j == k || j == k - 1) ? Color.GREEN : Color.RED;
                        controller.drawBar(j, list.get(j), col);
                    }
                    WaitForButton();

                    temp = list.get(k);
                    list.set(k, list.get(k - 1));
                    list.set(k - 1, temp);

                    controller.clear();
                    for (int j = 0; j < list.size(); j++) {
                        Color col = (j == k || j == k - 1) ? Color.GREEN : Color.RED;
                        controller.drawBar(j, list.get(j), col);
                    }
                    WaitForButton();
                    // after switch so insert wait here..
                }
            }
        }
        DisplaySorted();
    }
}