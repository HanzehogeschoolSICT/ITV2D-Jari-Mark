package Model.Sorters;

import Model.Bar;
import javafx.scene.paint.Color;

import java.util.ArrayList;
import java.util.Stack;

public class BubbleSorter {
    private final ArrayList<Bar> list;
    Stack<ArrayList<Bar>> stack;

    public BubbleSorter(ArrayList<Bar> list) {
        this.list = list;
        stack = new Stack<>();
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

    private void ClearColors() {
        for (int j = 0; j < list.size(); j++) {
            list.set(j, new Bar(list.get(j).value, Color.RED));
        }
    }

    private void swap(int index1, int index2) {
        ClearColors();
        int temp1 = list.get(index1).value;
        int temp2 = list.get(index2).value;
        list.set(index1, new Bar(temp2, Color.GREEN));
        list.set(index2, new Bar(temp1, Color.GREEN));
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
