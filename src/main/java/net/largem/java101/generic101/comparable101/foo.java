package net.largem.java101.generic101.comparable101;

/**
 * Created by James Tan on 11/28/2016.
 */
public abstract class foo<T> implements Comparable<T>
{
    private final int i_;

    public foo(int i) {
        i_ = i;
    }

    protected int get_i()
    {
        return i_;
    }
}
