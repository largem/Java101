package net.largem.interview.multithread101.callable;

import java.util.concurrent.Callable;

/**
 * Created by James Tan on 2/7/2017.
 */
public class Task implements Callable<Integer> {

    private final int value;

    public Task(int value) {
        this.value = value;
    }

    @Override
    public Integer call() throws Exception {
        return value;
    }
}
