package View;

import Model.*;
import javafx.scene.canvas.Canvas;

import java.util.ArrayList;

public abstract class AbstractView {

    final Model model;

    AbstractView(Model model) {
        this.model = model;
    }

    abstract public void Update(ArrayList<Bar> bars);

}
