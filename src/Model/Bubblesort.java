package Model;

import javafx.scene.paint.Color;

import java.util.ArrayList;

class Bubblesort {
    private int recentindex = 0;
    private int loops = 0;
    private Phase phase = Phase.SELECTING;

    ArrayList<Bar> DoStep(ArrayList<Integer> list) {
        ArrayList<Bar> bars = new ArrayList<Bar>();
        while (true) {
            while (recentindex < list.size() - 1) {
                System.out.println(phase);
                if (list.get(recentindex) > list.get(recentindex + 1)) {
                    if (phase == Phase.SORTING) {
                        int temp1 = list.get(recentindex);
                        int temp2 = list.get(recentindex + 1);
                        list.set(recentindex, temp2);
                        list.set(recentindex + 1, temp1);
                        for (int i = 0; i < list.size(); i++) {
                            Color color = (i == recentindex || i == recentindex + 1) ? Color.GREEN : Color.RED;
                            bars.add(new Bar(i, list.get(i), color));
                        }
                        phase = Phase.SELECTING;
                        recentindex++;
                        return bars;
                    } else {
                        phase = Phase.SORTING;
                    }
                }
                for (int i = 0; i < list.size(); i++) {
                    Color color = (i == recentindex || i == recentindex + 1) ? Color.GREEN : Color.RED;
                    bars.add(new Bar(i, list.get(i), color));
                }
                if (phase == Phase.SELECTING)
                    recentindex++;
                return bars;
            }
            recentindex = 0;
        }
    }

    private enum Phase {
        SELECTING, SORTING
    }
}
