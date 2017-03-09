package Model;

import javafx.scene.paint.Color;

import java.util.ArrayList;
import java.util.Random;

public class Model {
    private static ArrayList<Integer> list;
    public int n = 10;
    private String sortstring;

    public Model() {
        list = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            list.add(i);
        }
        Random random = new Random();
        for (int i = 0; i < list.size(); i++) {
            int temp = list.remove(random.nextInt(list.size()));
            list.add(temp);
        }
    }

    public ArrayList<Bar> getBars() {
        ArrayList<Bar> bars = new ArrayList<Bar>();
        for (int i = 0; i < list.size(); i++) {
            bars.add(new Bar(i, list.get(i), Color.GREEN));
        }
        return bars;
    }

    public String getSortstring() {
        return sortstring;
    }

    public void setSortstring(String sortstring) {
        this.sortstring = sortstring;
    }
}
