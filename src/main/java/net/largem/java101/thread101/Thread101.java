package net.largem.java101.thread101;

/**
 * Created by James Tan on 11/25/2016.
 */

/** notify, notifyall work like the signal and broadcast of conditional variable
 *  it would keep the status, like semaphore. if wait is called after notify, and no
 *  further notify is called, wait will not wake up.
 *  So, check the status (logically) before calling wait.
 */


public class Thread101 extends Thread {
    private int count;

    @Override
    public void run()
    {
        try
        {
            sleep(3000);
        }catch(InterruptedException e)
        {
            return;
        }

        synchronized (this)
        {
            for (int i = 0; i < 10000; i++)
                count++;

            this.notifyAll();
            System.out.println("Finish counting...");
        }
    }

    public static void main(String[] args) throws InterruptedException
    {
        Thread101 thread = new Thread101();
        thread.start();

        Thread.sleep(3000);
        System.out.println("Waiting to thread end");

        synchronized (thread)
        {
            thread.wait();      //There could be race condition, this wait won't wakeup.
        }



        System.out.println(thread.count);
    }
}
