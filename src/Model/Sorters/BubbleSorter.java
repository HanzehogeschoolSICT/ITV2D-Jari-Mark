package Model.Sorters;

import Model.Bar;
import javafx.scene.paint.Color;

import java.util.ArrayList;
import java.util.Stack;

public class BubbleSorter extends AbstractSorter{

    public BubbleSorter(ArrayList<Bar> list) {
        super(list);
        sort();
    }

    private void sort() {
        int count = 0;
        do {
            for (int i = 1; i < list.size() - count; i++) {
                selectbars(list, i);
                stack.push(new ArrayList<>(list));
                if (list.get(i - 1).value > list.get(i).value) {
                    swap(i - 1, i);
                    stack.push(new ArrayList<>(list));
                }
            }
            count++;
        } while (count != list.size());
    }

    private void selectbars(ArrayList<Bar> list, int i) {
        ClearColors();
        list.get(i).setColor(Color.GREEN);
        list.get(i - 1).setColor(Color.GREEN);
    }
}
