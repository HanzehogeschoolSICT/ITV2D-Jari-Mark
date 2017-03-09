package Model;

import View.AbstractView;
import javafx.scene.paint.Color;

import java.util.ArrayList;
import java.util.Random;

public class Model implements Runnable {
    private static ArrayList<Integer> list;
    private static ArrayList<AbstractView> views;
    public int n = 10;
    boolean run = true;
    private String sortstring;

    public Model() {
        views = new ArrayList<>();
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

    @Override
    public void run() {
        while (run) {
            UpdateViews();
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void start() {
        new Thread(this).start();
    }

    private void UpdateViews() {
        for (AbstractView view : views) {
            view.Update();
        }
    }

    public void AddView(AbstractView view) {
        views.add(view);
    }

    public void OneBubbleStep() {
        System.out.println("bubblestep");
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
