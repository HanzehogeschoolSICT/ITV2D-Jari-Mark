package View;

import Model.*;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.text.TextAlignment;

import java.util.ArrayList;

public class BarChartView {
    private static final int textheight = 20;
    @FXML
    public Canvas barcanvas;
    GraphicsContext gc;

    public void draw(ArrayList<Bar> list, int n) {
        gc = barcanvas.getGraphicsContext2D();
        ClearCanvas(gc);
        DrawBars(list, n);
    }

    private void DrawBars(ArrayList<Bar> list, int n) {
        int xoffset;
        int yoffset;
        for (int i = 0; i < list.size(); i++) {
            Bar current = list.get(i);
            xoffset = (int) (barcanvas.getWidth() / n);
            yoffset = (int) (barcanvas.getHeight() / n);

            gc.setFill(current.color);
            gc.setStroke(Color.BLACK);
            gc.fillRect((i * xoffset),
                    barcanvas.getHeight() - current.value * yoffset, xoffset,
                    current.value * yoffset);
            gc.strokeRect((i * xoffset - 1),
                    barcanvas.getHeight() - current.value * yoffset,
                    xoffset + 1,
                    current.value * yoffset);
            gc.setTextAlign(TextAlignment.CENTER);
            gc.setFill(Color.WHITE);
            gc.fillText(Integer.toString(current.value),
                    (i * xoffset) + (xoffset / 2),
                    barcanvas.getHeight() - current.value * yoffset + textheight);
        }
    }

    private void ClearCanvas(GraphicsContext gc) {
        gc.clearRect(0, 0, barcanvas.getWidth(), barcanvas.getHeight());
    }
}
