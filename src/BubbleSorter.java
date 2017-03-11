import javafx.scene.paint.Color;

import java.util.ArrayList;

public class BubbleSorter {
    private static int i = 0;

    boolean step(ArrayList<Bar> list, int loops) {
        ClearColors(list);
        if (list.get(i).value > list.get(i + 1).value) {
            swap(list, i);
            selectbars(list, i);
            return false;
        }
        i++;
        if (i == list.size() - loops - 1) {
            i = 0;
            selectbars(list, i);
            return true;
        }
        selectbars(list, i);
        return false;
    }

    private void selectbars(ArrayList<Bar> list, int i) {
        list.get(i).setColor(Color.GREEN);
        list.get(i + 1).setColor(Color.GREEN);
    }

    private void ClearColors(ArrayList<Bar> list) {
        for (int j = 0; j < list.size(); j++) {
            list.set(j, new Bar(list.get(j).value, Color.RED));
        }
    }

    private void swap(ArrayList<Bar> list, int i) {
        int temp1 = list.get(i).value;
        int temp2 = list.get(i + 1).value;
        list.set(i, new Bar(temp2, Color.GREEN));
        list.set(i + 1, new Bar(temp1, Color.GREEN));
    }
}
