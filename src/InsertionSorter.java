import javafx.scene.paint.Color;

import java.util.ArrayList;

public class InsertionSorter {
    int i = 0;
    int j = 0;
    boolean proceed;

    public boolean step(ArrayList<Bar> list) {
        while (i < list.size()) {
            while (j > 0 && list.get(j - 1).value > list.get(j).value) {
                selectbars(list, j);
                if (proceed)       // Skip one step to make it more clear which bars are being switched.
                    SwapAndProceed(list, j);
                proceed = !proceed;
                return false;
            }
            j = ++i;
        }
        i = j = 0;
        MakeAllGreen(list);
        return true;
    }

    private void MakeAllGreen(ArrayList<Bar> list) {
        for (int i = 0; i < list.size(); i++) {
            list.get(i).setColor(Color.GREEN);
        }
    }

    private void selectbars(ArrayList<Bar> list, int i) {
        ClearSelection(list);
        list.get(i).setColor(Color.GREEN);
        list.get(i - 1).setColor(Color.GREEN);
    }

    private void SwapAndProceed(ArrayList<Bar> list, int index) {
        int temp1 = list.get(index).value;
        int temp2 = list.get(index - 1).value;
        list.set(index, new Bar(temp2, Color.GREEN));
        list.set(index - 1, new Bar(temp1, Color.GREEN));
        j--;
    }

    private void ClearSelection(ArrayList<Bar> list) {
        for (int j = 0; j < list.size(); j++) {
            list.set(j, new Bar(list.get(j).value, Color.RED));
        }
    }
}
