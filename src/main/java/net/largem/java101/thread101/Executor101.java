package net.largem.java101.thread101;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by James Tan on 11/29/2016.
 */
public class Executor101 {
    public static void main(String[] args) {
        ExecutorService exe = Executors.newSingleThreadExecutor();

        exe.submit( () -> {
            final String threadName = Thread.currentThread().getName();
            System.out.println("I am running in " + threadName);
                }
        );
    }

}
