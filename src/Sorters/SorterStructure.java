package Sorters;

import GUI.Controller;

import java.util.ArrayList;

/**
 * SorterStructure class to give a standard structure to the
 * sorters on which the Controller class can rely.
 */
class SorterStructure {
    final ArrayList<Integer> list;
    final Controller controller;
    private final Object lock;

    SorterStructure(ArrayList<Integer> list, Controller controller, Object lock) {
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
