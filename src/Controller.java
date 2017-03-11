import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

@SuppressWarnings("unused") // IDE cannot see the link between control and method when setController() is used.
public class Controller {
    private final BarChartView barview;
    Model model;
    private String sortstring = "BubbleSort";
    @FXML
    private ComboBox sortselector;

    public Controller(Model model, BarChartView barview) {
        this.model = model;
        this.barview = barview;
        ArrayList<Bar> list = model.getList();
        barview.draw(list, list.size());
    }

    public void DoStep() {
        LockSelector();
        switch (sortstring) {
            case "BubbleSort":
                BubbleStep();
                break;

            case "InsertionSort":
                InsertionStep();
                break;

            case "QuickSort":
                QuickStep();
                break;
        }
    }

    private void QuickStep() {
        model.QuickStep();
        ArrayList<Bar> list = model.getList();
        barview.draw(list, list.size());
    }

    private void LockSelector() {
        sortselector.setDisable(true);
    }

    private void InsertionStep() {
        model.InsertionStep();
        ArrayList<Bar> list = model.getList();
        barview.draw(list, list.size());
    }

    private void BubbleStep() {
        model.BubbleStep();
        ArrayList<Bar> list = model.getList();
        barview.draw(list, list.size());
    }

    public void SetSortString(ActionEvent event) {
        sortstring = sortselector.getSelectionModel().getSelectedItem().toString();
    }

    public void DoCompleteSort() {
        LockSelector();
        switch (sortstring) {
            case "BubbleSort":
                CompleteBubble();
                break;

            case "InsertionSort":
                CompleteInsertion();
                break;
        }
    }

    private void CompleteInsertion() {
        (new Timer()).schedule(new TimerTask() {
            @Override
            public void run() {
                boolean sorted = model.InsertionStep();
                ArrayList<Bar> list = model.getList();
                barview.draw(list, list.size());
                if (sorted) {
                    FreeSelector();
                }
            }
        }, 0, 100);
    }

    private void CompleteBubble() {
        (new Timer()).schedule(new TimerTask() {
            @Override
            public void run() {
                boolean sorted = model.BubbleStep();
                ArrayList<Bar> list = model.getList();
                barview.draw(list, list.size());
                if (sorted) {
                    FreeSelector();
                }
            }
        }, 0, 100);
    }

    private void FreeSelector() {
        sortselector.setDisable(false);
    }
}
