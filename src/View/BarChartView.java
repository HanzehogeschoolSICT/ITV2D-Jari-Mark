package View;

import Model.*;
import javafx.scene.canvas.Canvas;

import java.util.ArrayList;

public class BarChartView {
    private final Model model;
    public Canvas barcanvas;

    public BarChartView(Model model){
        this.model = model;

    }
    private class UpdateThread implements Runnable {

        @Override
        public void run() {
            while (true) {
                ArrayList<Integer> list = model.getList();
            }
        }
    }
}
