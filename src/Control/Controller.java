package Control;

import Model.Bar;
import Model.Model;
import View.AbstractView;
import javafx.event.ActionEvent;
import javafx.scene.control.ComboBox;

import java.util.ArrayList;

public class Controller extends AbstractController {
    public Controller(Model model, AbstractView view) {
        super(model, view);
    }

    public void DoStep() {
        ArrayList<Bar> bars = model.OneBubbleStep();
        view.Update(bars);
    }

    public void SetSortString(ActionEvent event) {
        model.setSortstring(((ComboBox) event.getSource()).getSelectionModel().getSelectedItem().toString());
    }

    public void DoCompleteSort() {
    }
}