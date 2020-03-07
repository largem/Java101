package net.largem.java101.generic101.comparable101;

/**
 * Created by James Tan on 11/28/2016.
 */
public final class bar extends foo<bar>
{
    private final int i;

    public bar(int i, int i1) {
        super(i);
        this.i = i1;
    }

    @Override
    public int compareTo(bar o) {
        if (i==o.i)
        {
            return get_i() - o.get_i();
        }
        return i-o.i;
    }
}

//If super class implement a interface, subclass will have the interface, and it can't define the interface anymore.
