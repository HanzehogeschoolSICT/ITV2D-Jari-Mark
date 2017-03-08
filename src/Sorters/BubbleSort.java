package Sorters;

import java.util.ArrayList;

public class BubbleSort implements Runnable {
    private ArrayList<Integer> list;

    public BubbleSort(ArrayList<Integer> list) {
        this.list = list;
    }
    @Override
    public void run() {
        int k = 0;
        for (int a = 0; a < list.size() - k; a++) {
            for (; k < list.size(); k++) {
                for (int i = 0; i < list.size() - 1; i++) {
                    if (list.get(i) > list.get(i + 1)) {
                        int temp1 = list.get(i);
                        int temp2 = list.get(i + 1);
                        list.set(i, temp2);
                        list.set(i + 1, temp1);
                    }
                }
            }
        }
    }
}
