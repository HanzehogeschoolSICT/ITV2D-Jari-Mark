package Model.Sorters;

import Model.Bar;
import javafx.scene.paint.Color;

import java.util.ArrayList;
import java.util.Stack;

public abstract class AbstractSorter {
    protected Stack<ArrayList<Bar>> stack;

    protected final ArrayList<Bar> list;

    public AbstractSorter(ArrayList<Bar> list) {
        this.list = list;
        stack = new Stack<>();
    }

    protected void swap(int index1, int index2) {
        ClearColors();
        int temp1 = list.get(index1).value;
        int temp2 = list.get(index2).value;
        list.set(index1, new Bar(temp2, Color.GREEN));
        list.set(index2, new Bar(temp1, Color.GREEN));
    }

    protected void ClearColors() {
        for (int j = 0; j < list.size(); j++) {
            list.set(j, new Bar(list.get(j).value, Color.RED));
        }
    }

    protected ArrayList<Bar> AllGreen() {
        for (int i = 0; i < list.size(); i++) {
            list.get(i).setColor(Color.GREEN);
        }
        return list;
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
}
