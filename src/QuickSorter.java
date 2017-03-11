import java.util.ArrayList;

public class QuickSorter {
    ArrayList<Bar> list;

    public boolean step(ArrayList<Bar> list) {
        this.list = list;
        boolean sorted = quicksort(0, list.size() - 1);
        return sorted;
    }

    private boolean quicksort(int i, int i1) {
    }
}
