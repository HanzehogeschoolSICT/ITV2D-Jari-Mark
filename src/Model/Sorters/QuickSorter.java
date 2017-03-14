package Model.Sorters;

import Model.Bar;
import javafx.scene.paint.Color;

import java.util.ArrayList;
import java.util.Stack;

public class QuickSorter {
    private final ArrayList<Bar> list;
    Stack<ArrayList<Bar>> stack;

    public QuickSorter(ArrayList<Bar> list) {
        this.list = list;
        stack = new Stack<>();
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

    private void swap(int index1, int index2) {
        ClearColors();
        int temp1 = list.get(index1).value;
        int temp2 = list.get(index2).value;
        list.set(index1, new Bar(temp2, Color.RED));
        list.set(index2, new Bar(temp1, Color.RED));
    }

    private void ClearColors() {
        for (int j = 0; j < list.size(); j++) {
            list.set(j, new Bar(list.get(j).value, Color.RED));
        }
    }

    public ArrayList<Bar> pop() {
        ArrayList<Bar> temp;
        try {
            temp = stack.remove(0);         // Return next step.
        } catch (Exception e) {
            return AllGreen();          // The list is sorted.
        }
        return temp;
    }

    private ArrayList<Bar> AllGreen() {
        for (int i = 0; i < list.size(); i++) {
            list.get(i).setColor(Color.GREEN);
        }
        return list;
    }
}
