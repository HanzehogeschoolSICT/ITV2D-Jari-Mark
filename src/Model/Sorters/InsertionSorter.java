package Model.Sorters;

import Model.Bar;
import javafx.scene.paint.Color;

import java.util.ArrayList;
import java.util.Stack;

public class InsertionSorter {
    private final ArrayList<Bar> list;
    Stack<ArrayList<Bar>> stack;

    public InsertionSorter(ArrayList<Bar> list) {
        this.list = list;
        stack = new Stack<>();
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
        } catch (Exception ignored){}
    }

    private void swap(int index1, int index2) {
        ClearColors();
        int temp1 = list.get(index1).value;
        int temp2 = list.get(index2).value;
        list.set(index1, new Bar(temp2, Color.GREEN));
        list.set(index2, new Bar(temp1, Color.GREEN));
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
