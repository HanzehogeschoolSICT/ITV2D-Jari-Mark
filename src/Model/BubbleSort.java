package Model;

import javafx.scene.paint.Color;

import java.util.ArrayList;

public class BubbleSort {
    private int recentindex = 0;
    private int count = 1;

    public ArrayList<Bar> DoStep(ArrayList<Integer> list) {
        ArrayList<Bar> bars = new ArrayList<>();

        while (true) {
            while (recentindex < list.size() - count) {
                if (list.get(recentindex) > list.get(recentindex + 1)) {
                    for (int i = 0; i < list.size(); i++) {
                        Color color = (i == recentindex || i == recentindex + 1) ? Color.GREEN : Color.RED;
                        bars.add(new Bar(i, list.get(i), color));
                    }
                    int temp1 = list.get(recentindex);
                    int temp2 = list.get(recentindex + 1);
                    list.set(recentindex, temp2);
                    list.set(recentindex + 1, temp1);
                    return bars;
                }
                for (int i = 0; i < list.size(); i++) {
                    Color color = (i == recentindex || i == recentindex + 1) ? Color.GREEN : Color.RED;
                    bars.add(new Bar(i, list.get(i), color));
                }
                recentindex++;
                return bars;
            }
            bars = CheckSolved(list);
            if (bars != null) {
                return bars;
            } else {
                bars = new ArrayList<Bar>();
            }
            count++;
            recentindex = 0;
        }
    }

    private ArrayList<Bar> CheckSolved(ArrayList<Integer> list) {
        for (int i = 0; i < list.size() - 1; i++) {
            if (list.get(i) > list.get(i + 1)) {
                return null;
            }
        }
        ArrayList<Bar> bars = new ArrayList<Bar>();
        for (int i = 0; i < list.size(); i++) {
            bars.add(new Bar(i, list.get(i), Color.GREEN));
        }
        return bars;
    }
}
