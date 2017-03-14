package Model.Sorters;

import Model.Bar;
import javafx.scene.paint.Color;

import java.util.ArrayList;
import java.util.Stack;

public class InsertionSorter extends AbstractSorter {

    public InsertionSorter(ArrayList<Bar> list) {
        super(list);
        sort();
    }

    private void sort() {
        for (int i = 0; i < list.size(); i++) {
            int j = i;
            while (j > 0 && list.get(j - 1).value > list.get(j).value) {
                selectbars(j);
                stack.push(new ArrayList<>(list));
                swap(j, j - 1);
                stack.push(new ArrayList<>(list));
                j--;
            }
        }
    }

    private void selectbars(int i) {
        ClearColors();
        list.get(i).setColor(Color.GREEN);
        try {
            list.get(i - 1).setColor(Color.GREEN);
        } catch (Exception ignored) {
        }
    }


}
