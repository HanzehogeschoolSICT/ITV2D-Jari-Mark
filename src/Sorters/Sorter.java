package Sorters;

import GUI.Controller;

import java.util.ArrayList;

/**
 * Sorter class to give a standard structure to the
 * sorters on which the Controller class can rely.
 */
class Sorter {
    final ArrayList<Integer> list;
    final Controller controller;
    private final Object lock;

    Sorter(ArrayList<Integer> list, Controller controller, Object lock) {
        this.list = list;
        this.controller = controller;
        this.lock = lock;
    }

    /**
     *  Will wait for a notify from somewhere
     *  In this project it will be notified by the
     */
    void WaitForButton() {
        synchronized (lock) {
            try {
                lock.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
