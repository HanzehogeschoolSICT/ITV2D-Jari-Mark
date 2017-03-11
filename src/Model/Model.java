package Model;

import java.util.ArrayList;
import java.util.Random;

public class Model {
    private static ArrayList<Integer> list;
    public int n = 10;
    private String sortstring;
    private BubbleSort bubblesorter;



    public Model() {
        list = new ArrayList<>();
        bubblesorter = new BubbleSort();

        for (int i = 1; i <= n; i++) {
            list.add(i);
        }
        Random random = new Random();
        for (int i = 0; i < list.size(); i++) {
            int temp = list.remove(random.nextInt(list.size()));
            list.add(temp);
        }
    }

    public void setSortstring(String sortstring) {
        this.sortstring = sortstring;
    }

    public ArrayList<Bar> OneBubbleStep() {
        ArrayList<Bar> bars = bubblesorter.DoStep(list);
        return bars;
    }
}
