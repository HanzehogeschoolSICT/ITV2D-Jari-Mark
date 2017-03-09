package Control;

import Model.Model;
import javafx.event.ActionEvent;
import javafx.scene.control.ComboBox;

public class Controller extends AbstractController{

    public Controller(Model model) {
        super(model);
    }

    public void DoStep() {
        model.OneBubbleStep();
    }

    public void SetSortString(ActionEvent event) {
        model.setSortstring(((ComboBox)event.getSource()).getSelectionModel().getSelectedItem().toString());
    }

    public void DoCompleteSort() {
    }
}