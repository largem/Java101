package net.largem.java101.thread101.runable101;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;



/**
 * Created by James Tan on 2/7/2017.
 */
public class Runnable101 {
    public static void main(String[] args) {
        Executor exe = Executors.newSingleThreadExecutor();

        Task task = new Task(1);

        exe.execute(task);

        //Is there any way to shutdown thread pool better?
        ((ExecutorService)exe).shutdown();
    }

}
