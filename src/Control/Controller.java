package Control;

import Model.Model;
import Sorters.BubbleSort;

public class Controller {
    private Model model;

    public Controller(Model model) {
        this.model = model;
    }

    public void DoStep() {
        new Thread(new BubbleSort(model.getList()));
    }

    public void SetSortString() {
    }

    public void DoCompleteSort() {
    }
}