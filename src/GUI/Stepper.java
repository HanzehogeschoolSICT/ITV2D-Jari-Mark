package GUI;

public class Stepper implements Runnable {
    private final int timeinterval;
    private Thread t;
    private Object lock;

    public Stepper(Thread t, Object lock, int timeinterval){
        this.t = t;
        this.lock = lock;
        this.timeinterval = timeinterval;
    }
    @Override
    public void run() {
        while (t != null){
            synchronized (lock) {
                lock.notify();
            }
            try {
                Thread.sleep(timeinterval);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
