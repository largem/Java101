package net.largem.java101.thread101.runable101;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;



/**
 * Created by James Tan on 2/7/2017.
 */
public class Runnable101 {
    public static void main(String[] args)
    {
        singleExecute();
        multileSubmit();
    }

    private static void singleExecute()
    {
        Executor exe = Executors.newSingleThreadExecutor();

        RunnableTask task = new RunnableTask(1);

        exe.execute(task);

        //Is there any way to shutdown thread pool better?
        ((ExecutorService)exe).shutdown();
    }

    private static void multileSubmit()
    {
        ExecutorService exe = Executors.newFixedThreadPool(2);

        final int value = 1;
        final RunnableTask task = new RunnableTask(value);

        exe.submit(task);
        sleep(value*2000);

        exe.submit(task);
        sleep(value*2000);
        exe.shutdown();
    }

    private static void sleep(long mills)
    {
        try {
            Thread.sleep(mills);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
