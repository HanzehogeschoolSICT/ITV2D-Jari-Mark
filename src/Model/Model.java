package Model;

import Model.Sorters.*;
import javafx.scene.paint.Color;

import java.util.ArrayList;
import java.util.Random;

public class Model {
    static ArrayList<Bar> list;
    static int n = 10;

    private QuickSorter quicksorter;
    private BubbleSorter bubblesorter;
    private InsertionSorter insertionsorter;

    public Model() {
        list = new ArrayList<>();
        randomize(list);
        bubblesorter = new BubbleSorter(new ArrayList<>(list));
        insertionsorter = new InsertionSorter(new ArrayList<>(list));
        quicksorter = new QuickSorter(new ArrayList<>(list));
    }

    private static void randomize(ArrayList<Bar> list) {
        for (int i = 1; i <= n; i++) {
            list.add(new Bar(i, Color.RED));
        }
        Random random = new Random();
        for (int i = 0; i < list.size(); i++) {
            Bar temp = list.remove(random.nextInt(list.size()));
            list.add(temp);
        }
    }

    public ArrayList<Bar> BubbleStep() {
        return bubblesorter.pop();
    }

    public ArrayList<Bar> InsertionStep() {
        return insertionsorter.pop();
    }

    public ArrayList<Bar> QuickStep() {
        return quicksorter.pop();
    }

    public ArrayList<Bar> getList() {
        return list;
    }
}
