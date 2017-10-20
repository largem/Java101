package net.largem.java101.thread101.callable101;

import java.util.concurrent.Callable;

/**
 * Created by James Tan on 2/7/2017.
 */
public class CallableTask implements Callable<Integer> {

    private final int value;

    public CallableTask(int value) {
        this.value = value;
    }

    @Override
    public Integer call() throws Exception {
        return value;
    }
}
