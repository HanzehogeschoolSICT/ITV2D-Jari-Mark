package Sorters;

import GUI.Controller;
import javafx.application.Platform;
import javafx.scene.paint.Color;

import java.util.ArrayList;

/**
 * Created by mark on 8-3-2017.
 */
public class QuickSort extends SorterStructure implements Runnable {

    public QuickSort(ArrayList<Integer> list, Controller controller, Object lock) {
        super(list, controller, lock);
    }

    @Override
    public void run() {
        quickSort(list); // change for different method of sorting

        DisplaySorted();
    }

    public   void quickSort(ArrayList<Integer> list) {quickSort(list, 0, list.size()-1);}

    public  void quickSort(ArrayList<Integer> list, int start, int end) {
        if (start < end) {
            int pivot = partition(list, start, end);
            quickSort(list, start, pivot);
            quickSort(list, pivot +1, end);
        }
    }

    public  int partition(ArrayList<Integer> list, int start, int end) {
        int last = end;
        int first = start;
        int pivot = list.get(start);

        while (true) {
            while (list.get(last) > pivot && last > start) {
                last = last - 1;}
            while (list.get(first) < pivot && first < last) {
                first = first + 1;}

            //source :http://www.snippetexample.com/2014/10/quicksort-implementation-example-using-arralist-java/
            //switching algorithem used
            if(first<last){
                waitandbardraw(first,last,pivot);

                int temp = list.get(first);
                list.set(first,list.get(last));
                list.set(last,temp);
                last--;
                first++;

                waitandbardraw(first,last,pivot);

            }
            else{return last;}
        }}

    public void waitandbardraw(int first,int last,int pivot) {
        Platform.runLater(() -> {controller.clear();});
        for ( int   j = 0; j < list.size(); j++) {
            Color col = Color.RED;
            if (j==first||j==last){
                col = Color.GREEN;
            }
            else if (j== list.indexOf(pivot)){
                col=Color.BLUE;
            }
            Color fincol = col; int finalJ = j;
            Platform.runLater(() -> {controller.drawBar(finalJ, list.get(finalJ), fincol);});
        }
        WaitForButton();
    }
}
