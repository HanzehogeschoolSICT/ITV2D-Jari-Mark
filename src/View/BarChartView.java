package View;

import Model.Bar;
import Model.Model;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.text.TextAlignment;

import java.util.ArrayList;

public class BarChartView extends AbstractView {
    @FXML
    public Canvas barcanvas;
    private GraphicsContext gc;

    public BarChartView(Model model) {
        super(model);
    }

    @Override
    public void Update(ArrayList<Bar> bars) {
        gc = barcanvas.getGraphicsContext2D();
        clear();
        for (int i = 0; i < bars.size(); i++) {
            Bar current = bars.get(i);
            int textheight = 20;
            int xoffset = (int) (barcanvas.getWidth() / model.n);
            int yoffset = (int) (barcanvas.getHeight() / model.n);

            gc.setFill(current.color);
            gc.setStroke(Color.BLACK);
            gc.fillRect((current.xaxis * xoffset),
                    barcanvas.getHeight() - current.yaxis * yoffset, xoffset,
                    current.yaxis * yoffset);
            gc.strokeRect((current.xaxis * xoffset - 1),
                    barcanvas.getHeight() - current.yaxis * yoffset,
                    xoffset + 1,
                    current.yaxis * yoffset);
            gc.setTextAlign(TextAlignment.CENTER);
            gc.setFill(Color.WHITE);
            gc.fillText(Integer.toString(current.yaxis),
                    (current.xaxis * xoffset) + (xoffset / 2),
                    barcanvas.getHeight() - current.yaxis * yoffset + textheight);
        }
        System.out.println("Updating barchart");
    }

    private void clear() {
        gc.clearRect(0, 0, barcanvas.getWidth(), barcanvas.getHeight());
    }
}
