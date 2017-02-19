package net.largem.interview.multithread101.callable;

import java.util.IllegalFormatCodePointException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * Created by James Tan on 2/7/2017.
 */
public final class Callable101 {

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        callableObject();
        callableLambda();
        callableWithException();

        System.out.println(Callable101.class.getName() + " finished");
    }

    private static void callableObject() throws InterruptedException, ExecutionException
    {
        ExecutorService exe = Executors.newSingleThreadExecutor();

        Future<Integer> result = exe.submit(new Task(1));

        System.out.println(result.get());

        exe.shutdown();
    }

    private static void callableLambda() throws InterruptedException, ExecutionException
    {
        ExecutorService exe = Executors.newSingleThreadExecutor();

        int result = exe.submit(
                () ->
                {
                    return 2;
                }
        ).get();

        System.out.println(result);

        exe.shutdown();
    }

    private static void callableWithException() throws InterruptedException, ExecutionException
    {
        ExecutorService exe = Executors.newSingleThreadExecutor();
        try {
            exe.submit(() ->
            {
                System.out.println("I am throwing an exception");
                throw new IllegalStateException("I can not be run");
            }).get();
        }finally {
            exe.shutdown();
        }
    }
}
