package Control;

import Model.Bar;
import Model.Model;
import View.BarChartView;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

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
    @FXML
    private TextField intervaltext;
    private int interval;

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
        ArrayList<Bar> temp = model.QuickStep();
        barview.draw(temp, temp.size());
    }

    private void LockSelector() {
        sortselector.setDisable(true);
    }

    private void InsertionStep() {
        ArrayList<Bar> temp = model.InsertionStep();
        barview.draw(temp, temp.size());
    }

    private void BubbleStep() {
        ArrayList<Bar> temp = model.BubbleStep();
        barview.draw(temp, temp.size());
    }

    public void SetSortString(ActionEvent event) {
        sortstring = sortselector.getSelectionModel().getSelectedItem().toString();
    }

    public void DoCompleteSort() {
        LockSelector();
        setInterval();
        switch (sortstring) {
            case "BubbleSort":
                CompleteBubble();
                break;

            case "InsertionSort":
                CompleteInsertion();
                break;

            case "QuickSort":
                CompleteQuick();
                break;
        }
    }

    private void CompleteQuick() {
        (new Timer()).schedule(new TimerTask() {
            @Override
            public void run() {
                ArrayList<Bar> temp = model.QuickStep();
                barview.draw(temp, temp.size());
            }
        }, 0, interval);
    }

    private void CompleteInsertion() {
        (new Timer()).schedule(new TimerTask() {
            @Override
            public void run() {
                ArrayList<Bar> temp = model.InsertionStep();
                barview.draw(temp, temp.size());
            }
        }, 0, interval);
    }

    private void CompleteBubble() {
        (new Timer()).schedule(new TimerTask() {
            @Override
            public void run() {
                ArrayList<Bar> temp = model.BubbleStep();
                barview.draw(temp, temp.size());
            }
        }, 0, interval);
    }

    private void FreeSelector() {
        sortselector.setDisable(false);
    }

    public void setInterval() {
        try {
            this.interval = Integer.parseInt(intervaltext.getText());
        } catch (Exception e) {
            this.interval = 100;
        }
    }
}
