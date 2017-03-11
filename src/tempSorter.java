import javafx.scene.paint.Color;

import java.util.ArrayList;

public class tempSorter {
    ArrayList<Bar> list;

    public boolean step(ArrayList<Bar> list) {
        this.list = list;
        quicksort(0, list.size() - 1);
        return true;
    }

    private void quicksort(int lo, int hi) {
        if(lo < hi) {
            int p = partition(lo, hi);
            quicksort(lo, p - 1);
            quicksort(p + 1, hi);
        }
    }

    private int partition(int lo, int hi) {
        int pivot = list.get(hi).value;
        int i = lo - 1;
        int j = lo;
        while (j < hi) {
            if(list.get(j).value <= pivot){
                i++;
                swap(i, j);
            }
            j++;
        }
        swap(i + 1, hi);
        return i + 1;
    }

    private void swap(int index1, int index2) {
        ClearSelection();
        int temp1 = list.get(index1).value;
        int temp2 = list.get(index2).value;
        list.set(index1, new Bar(temp2, Color.GREEN));
        list.set(index2, new Bar(temp1, Color.GREEN));
    }

    private void ClearSelection() {
        for (int j = 0; j < list.size(); j++) {
            list.set(j, new Bar(list.get(j).value, Color.RED));
        }
    }
}
