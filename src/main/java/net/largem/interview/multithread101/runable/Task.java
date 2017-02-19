package net.largem.interview.multithread101.runable;

/**
 * Created by James Tan on 2/7/2017.
 */
public class Task implements Runnable {
    private final int value;

    public Task(int value) {
        this.value = value;
    }

    @Override
    public void run() {
        System.out.println("I am running, my value is " + value);
    }
}
