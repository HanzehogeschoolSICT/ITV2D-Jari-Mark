package View;

import Model.Bar;
import Model.Model;

import java.util.ArrayList;

public abstract class AbstractView {

    final Model model;

    AbstractView(Model model) {
        this.model = model;
    }

    abstract public void Update(ArrayList<Bar> bars);

}
