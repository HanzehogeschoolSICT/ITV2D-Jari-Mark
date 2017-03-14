package Model.Sorters;

import Model.Bar;
import javafx.scene.paint.Color;

import java.util.ArrayList;
import java.util.Stack;

public class QuickSorter extends AbstractSorter {

    public QuickSorter(ArrayList<Bar> list) {
        super(list);
        sort();
    }

    private void sort() {
        quicksort(0, list.size() - 1);
    }

    private void quicksort(int lo, int hi) {
        if (lo < hi) {
            int p = partition(lo, hi);
            quicksort(lo, p - 1);
            quicksort(p + 1, hi);
        }
    }

    private int partition(int lo, int hi) {
        int pivot = list.get(hi).value;
        int i = lo - 1;
        for (int j = lo; j < hi; j++) {
            if (list.get(j).value < pivot) {
                i++;
                swap(i, j);
                selectbars(hi, i, j);
                stack.push(new ArrayList<>(list));
            }
        }
        swap(i + 1, hi);
        selectbars(hi, i + 1, hi);
        stack.push(new ArrayList<>(list));
        return i + 1;
    }

    private void selectbars(int pivot, int index1, int index2) {
        ClearColors();
        list.get(index1).setColor(Color.GREEN);
        list.get(index2).setColor(Color.GREEN);
        list.get(pivot).setColor(Color.BLUE);
    }
}
