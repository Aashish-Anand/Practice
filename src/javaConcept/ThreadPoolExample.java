package javaConcept;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class workerThread implements Runnable {
    String s;

    workerThread(String s) {
        this.s = s;
    }

    public void run() {
        System.out.println(Thread.currentThread().getName() + " (Start) " + s);
        processMessage();
        System.out.println(Thread.currentThread().getName() + " (End) " + s);
    }

    private void processMessage() {

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

public class ThreadPoolExample {
    public static void main(String[] args) {
        ExecutorService ex = Executors.newFixedThreadPool(5);

        for (int i = 0; i < 10; i++) {
            workerThread worker = new workerThread("" + i);
            ex.execute(worker);
        }
        ex.shutdown();
        while (!ex.isTerminated()) {
        }
        System.out.println("Finished all threads");
    }
}
