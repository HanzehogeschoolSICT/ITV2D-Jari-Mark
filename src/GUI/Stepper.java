package GUI;

public class Stepper implements Runnable {
    private Thread t;
    private Object lock;

    public Stepper(Thread t, Object lock){
        this.t = t;
        this.lock = lock;
    }
    @Override
    public void run() {
        while (t != null){
            synchronized (lock) {
                lock.notify();
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
