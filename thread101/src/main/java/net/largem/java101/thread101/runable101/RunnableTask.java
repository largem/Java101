package net.largem.java101.thread101.runable101;

/**
 * Created by James Tan on 2/7/2017.
 */
public class RunnableTask implements Runnable {
    private final int value;

    public RunnableTask(int value) {
        this.value = value;
    }

    @Override
    public void run() {
        System.out.println("I am running, my value is " + value);
        try {
            Thread.sleep(value*1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
